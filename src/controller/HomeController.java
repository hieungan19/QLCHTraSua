package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import constant.ConstantValueView;
import dao.BillDAO;
import dao.CustomerDAO;
import dao.DiscountDAO;
import dao.ProductDAO;
import globalComponent.AppButton;
import globalComponent.NumberSpinner;
import globalComponent.SearchBar;
import model.BillModel;
import model.CustomerModel;
import model.DiscountModel;
import model.ProductModel;
import view.home.BillDialog;
import view.home.CartPanel;
import view.home.ChooseDrinkDialog;
import view.home.ChooseTopping;
import view.home.DrinkCardComponent;
import view.home.HomePageView;
import view.home.MainMenuPanel;

public class HomeController {
	public HomePageView home;
	public CartPanel cart;

	MainMenuPanel menu_view;
	JPanel menu;
	List<ProductModel> drinkList;
	List<ProductModel> toppingList;
	List<ProductModel> proList;
	List<ChooseTopping> choseToppingList;
	Set<String> toppingIDSet;
	ProductModel selected;
	List<ProductModel> cartProducts;
	List<DiscountModel> discountList;
	CustomerModel customer;
	// giỏ hàng
	JTable table; // bảng sản phẩm đã chọn
	final CustomerModel[] result = { null };

	public HomeController(HomePageView view) {
		super();
		this.home = view;
		this.menu_view = view.mainMenu;
		this.menu = menu_view.panel;
		this.cart = view.cart;
		this.table = view.cart.scrollPane_cart.jTable;

		// reset cart;
		resetCart();

		// menu_view
		getProductList();
		displayProducts(proList);

		// cart
		addMouseListenerToTable(table);
		setDiscountToComboBox();
		addActionListenerToBtnCalc(cart.btn_calc);

		// add key listener to jTextField to find Customer
		getAndDisplayCustomer();
		paymentConfirm();

		// filter
		filterByClickBtn(view.panel_filterButton);
		addActionListenerForSearchBar(view.searchBar);

	}

	// lấy list đồ uống và list topping
	public void getProductList() {
		proList = ProductDAO.getAllProducts();
		drinkList = new ArrayList<>();
		toppingList = new ArrayList<>();
		for (ProductModel pro : proList) {
			if (!pro.getType().equalsIgnoreCase("TOPPING")) {

				drinkList.add(pro);
			} else
				toppingList.add(pro);
		}

		System.out.println("getProductList(): " + proList.size());

	}

	public void addListenerToSpinnerNumberCustomerPayment(BillModel bill, NumberSpinner spinner) {
		ChangeListener changeListener = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				double value = spinner.getNumber();
				if (value >= bill.getTotal()) {
					cart.btn_confirm.setEnabled(true);
					cart.btn_confirm.setBackground(ConstantValueView.primaryDark);
				} else {
					cart.btn_confirm.setEnabled(false);
					cart.btn_confirm.setBackground(new Color(128, 128, 128));
				}
			}
		};
		spinner.addChangeListener(changeListener);

	}

	public void displayProducts(List<ProductModel> productList) {
		menu.removeAll();
		for (ProductModel pro : productList) {
			DrinkCardComponent drinkCardComponent = new DrinkCardComponent(pro);

			menu.add(drinkCardComponent);
			drinkCardComponent.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					ChooseDrinkDialog dialog = new ChooseDrinkDialog(pro);
					selected = new ProductModel(pro);
					displayToppingListToComboBox(dialog.toppingPanel.comboBox_topList);
					dialog.setVisible(true);
					toppingIDSet = new HashSet<>();
					choseToppingList = new ArrayList<>();

					dialog.toppingPanel.btn_addTopping.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							displayChoseToppingIntoPanel(dialog);
						}
					});

					// save
					dialog.btn_save.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							ProductModel drink = getProductDetailsFromDialog(dialog, pro);
							addDrinkToListAndDisplayToCart(drink);

						}
					});

				}
			});
		}
		menu.validate();
		menu.repaint();
	}

	// set toan bo topping vao combobox
	public void displayToppingListToComboBox(JComboBox comboBox) {

		String toppingOptions[] = new String[toppingList.size() + 1];
		toppingOptions[0] = null;
		for (int i = 0; i < toppingList.size(); ++i) {
			toppingOptions[i + 1] = toppingList.get(i).getName();
		}
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(toppingOptions);
		comboBox.setModel(model);
	}

	public ProductModel displayChoseToppingIntoPanel(ChooseDrinkDialog dialog) {
		JComboBox comboBox = dialog.toppingPanel.comboBox_topList;
		int index = comboBox.getSelectedIndex() - 1;
		if (index >= 0) {
			if (!toppingIDSet.contains(toppingList.get(index).getProductID())) {
				ChooseTopping temp = new ChooseTopping(toppingList.get(index));
				dialog.toppingPanel.panel_topping.add(temp);
				choseToppingList.add(temp);
				toppingIDSet.add(toppingList.get(index).getProductID());
			}

		}
		dialog.toppingPanel.panel_topping.validate();
		dialog.toppingPanel.panel_topping.repaint();
		return toppingList.get(index);
	}

	public ProductModel getProductDetailsFromDialog(ChooseDrinkDialog dialog, ProductModel pro) {
		ProductModel result = new ProductModel(pro);
		result.setAmount(dialog.spinner_amount.getInt());
		List<ProductModel> list = new ArrayList<>();
		System.out.println("getProductDetailsFromDialog- choseToppingListSize(): " + choseToppingList.size());
		for (ChooseTopping t : choseToppingList) {
			if (t.spinner_toppingAmount.getInt() > 0) {
				t.topping.setAmount(t.spinner_toppingAmount.getInt());
				list.add(t.topping);
			}
		}
		result.setToppingList(list);
		System.out.println(result.toStringToppingList());
		return result;
	}

	public void addDrinkToListAndDisplayToCart(ProductModel drink) {
		cartProducts.add(drink);
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.addRow(drink.toObjectDrink());
	}

	// thêm listener cho table
	public void addMouseListenerToTable(JTable t) {
		t.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int selectedRow = t.getSelectedRow();
				ProductModel p = cartProducts.get(selectedRow);
				ChooseDrinkDialog dialog = new ChooseDrinkDialog(p);
				displayToppingListToComboBox(dialog.toppingPanel.comboBox_topList);
				choseToppingList = new ArrayList<>();
				toppingIDSet = new HashSet<>();
				setDataToDrinkDialog(dialog, p, selectedRow);
				dialog.show();

			}
		});
	}

	// kiem tra so tien khach dua, neu lon hon hoac bang tong hoa don moi cho xuat
	// hoa don

	// đưa dữ liệu vào dialog chọn số lượng thức uống và topping
	public void setDataToDrinkDialog(ChooseDrinkDialog dialog, ProductModel p, int selectedRow) {
		// neu san pham la topping
		if (p.getType().equals("TOPING"))
			dialog.panel_1.remove(1);
		// set listener cho việc thêm topping;

		dialog.toppingPanel.btn_addTopping.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				displayChoseToppingIntoPanel(dialog);
			}
		});

		// set data to dialog
		dialog.spinner_amount.setValue(p.getAmount());
		for (ProductModel topping : p.getToppingList()) {
			ChooseTopping t = new ChooseTopping(topping);
			choseToppingList.add(t);
			toppingIDSet.add(topping.getProductID());
			t.spinner_toppingAmount.setValue(topping.getAmount());
			dialog.toppingPanel.panel_topping.add(t);

		}

		// lưu giá trị đã thay đổi
		dialog.btn_save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ProductModel result = getProductDetailsFromDialog(dialog, p);
				cartProducts.remove(selectedRow);
				cartProducts.add(selectedRow,result);
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				dtm.setValueAt(result.toStringToppingList(), selectedRow, 2);
				dtm.setValueAt(result.getTotal(), selectedRow, 3);
			}
		});
		// xóa thức uống
		dialog.btn_delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				cartProducts.remove(selectedRow);
				dtm.removeRow(selectedRow);

			}
		});

	}

	// tim kiem customer
	public void getAndDisplayCustomer() {
		List<CustomerModel> customerList = CustomerDAO.getCustomerList();
		cart.cusPhoneNumber.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String phoneNumber = cart.cusPhoneNumber.getText();
				for (CustomerModel cus : customerList) {
					if (cus.getPhoneNumber().equals(phoneNumber)) {
						cart.cusName.setText(cus.getName());
						cart.cusID.setText(cus.getCustomerID());
						break;
					}
				}

			}
		});

	}

	public void consoleCartProduct() {
		for (ProductModel p : cartProducts) {
			System.out.println("SP: " + p.getName());
		}
	}

	public BillModel getBill() {
		BillModel bill = new BillModel("NV13", cart.cusID.getText(), cartProducts, null, 0, 0, 0, 0);
		bill.setSubtotal();
		bill.setDiscountID(getDiscountID());
		Object payment = cart.spinner_cusPaymentAmount.getValue();
		bill.setTenderAmount(Double.valueOf(String.valueOf(payment.toString())));
		bill.setDiscountValue();
		bill.setTotal();
		return bill;
	}

	// add listener for confirm button
	public void paymentConfirm() {
		cart.btn_confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BillModel bill = getBill();
				System.out.println("BILL: " + bill.getTotal());
				BillDAO.insertBill(bill);
				
				BillModel maxIDBill = BillDAO.getMaxIDBill(); 
				bill.setBillID(maxIDBill.getBillID());
				bill.setBillDate(maxIDBill.getBillDate());
				
				BillDialog dialog = new BillDialog(bill);
				
				
			}
		});
	}

	public void setDiscountToComboBox() {
		discountList = DiscountDAO.getDiscountList();
		String[] options = new String[discountList.size() + 1];
		options[0] = null;
		for (int i = 0; i < discountList.size(); ++i) {
			options[i + 1] = discountList.get(i).getName();
		}
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(options);
		cart.comboBox_discount.setModel(model);
	}

	public void resetCart() {
		setDiscountToComboBox();
		cart.cusName.setText(null);
		cart.cusID.setText(null);
		cart.cusPhoneNumber.setText(null);
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		cart.spinner_cusPaymentAmount.setValue(0);
		cartProducts = new ArrayList<>();
	}

	public CustomerModel getCustomer() {
		CustomerModel customer = CustomerDAO.getCustomerByID(cart.cusID.getText());
		return customer;
	}

	// get discount ID
	public String getDiscountID() {
		int index = cart.comboBox_discount.getSelectedIndex();
		customer = getCustomer();
		if (index < 1)
			return null;
		DiscountModel discount = discountList.get(index - 1);
		BillModel bill = new BillModel("NV13", cart.cusID.getText(), cartProducts, null, 0, 0, 0, 0);
		bill.setSubtotal();
		if (customer==null && !discount.getCustomerType().equals("ALL")) return null; 
		if (bill.getSubtotal() < discount.getTotalBill())
			return null;
		if (!discount.getCustomerType().equals("ALL") && !discount.getCustomerType().equals(customer.getLevel())) {
			return null;

		}
		return discount.getDiscountID();
	}

	public void addActionListenerForSearchBar(SearchBar searchBar) {
		searchBar.searchField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				List<ProductModel> result = new ArrayList<>();
				for (ProductModel pro : proList) {
					if (pro.getName().toLowerCase().contains(searchBar.searchField.getText().toLowerCase())) {
						result.add(pro);

					}

				}
				displayProducts(result);
			}
		});
	}

	public void filterByClickBtn(JPanel panel_filterButton) {
		for (int i = 0; i < panel_filterButton.getComponentCount(); ++i) {

			List<ProductModel> result = new ArrayList<>();
			AppButton btn = (AppButton) panel_filterButton.getComponent(i);
			String text = btn.getText();
			for (ProductModel pro : proList) {
				if (pro.getType().equals(text))
					result.add(pro);
			}

			btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if (text.equals("TẤT CẢ"))
						displayProducts(proList);
					else
						displayProducts(result);

				}
			});
		}
	}

	// tamtinh
	public void addActionListenerToBtnCalc(AppButton btn_calc) {
		btn_calc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BillModel bill = getBill();
				cart.total.setText(String.valueOf(bill.getTotal()));
				cart.subtotal.setText(String.valueOf(bill.getSubtotal()));
				cart.discountValue.setText(String.valueOf(bill.getDiscountValue()));
				addListenerToSpinnerNumberCustomerPayment(bill, cart.spinner_cusPaymentAmount);
			}
		});
	}

}
