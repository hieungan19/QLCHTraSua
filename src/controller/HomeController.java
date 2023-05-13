package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.table.DefaultTableModel;

import dao.BillDAO;
import dao.CustomerDAO;
import dao.DiscountDAO;
import dao.ProductDAO;
import model.BillModel;
import model.CustomerModel;
import model.DiscountModel;
import model.ProductModel;
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
	final CustomerModel[] result = {null};
	

	public HomeController(HomePageView view) {
		super();
		this.home = view;
		this.menu_view = view.mainMenu;
		this.menu = menu_view.panel;
		this.cart = view.cart;
		this.table = view.cart.scrollPane_cart.jTable;
		
		//reset cart; 
		resetCart();

		// menu_view
		getProductList();
		displayProducts();

		// cart
		addMouseListenerToTable(table);
		setDiscountToComboBox();
		
		//add key listener to jTextField to find Customer
		getAndDisplayCustomer(); 
		paymentConfirm(); 
		

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

	public void displayProducts() {
		for (ProductModel pro : proList) {
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

	//set toan bo topping vao combobox 
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
				System.out.println("Home controller - addMouseListenerToTable - SELECTED ROW: " + selectedRow);
				ProductModel p = cartProducts.get(selectedRow);
				ChooseDrinkDialog dialog = new ChooseDrinkDialog(p);
				displayToppingListToComboBox(dialog.toppingPanel.comboBox_topList);
				choseToppingList = new ArrayList<>() ; 
				toppingIDSet = new HashSet<>(); 
				setDataToDrinkDialog(dialog, p,selectedRow);
				
				dialog.show();
				
			}
		});
	}

	// đưa dữ liệu vào dialog chọn số lượng thức uống và topping
	public void setDataToDrinkDialog(ChooseDrinkDialog dialog, ProductModel p, int selectedRow) {
		//set listener cho việc thêm topping; 
		dialog.toppingPanel.btn_addTopping.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				displayChoseToppingIntoPanel(dialog);
			}
		});

		//set data to dialog
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
				cartProducts.add(selectedRow, p);
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				dtm.setValueAt(result.toStringToppingList(), selectedRow, 2);
				dtm.setValueAt(result.getTotal(), selectedRow, 3);
			}
		});
		//xóa thức uống
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
	
	//tim kiem customer
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
		for (ProductModel p: cartProducts) {
			System.out.println("SP: "+p.getName());
		}
	}
	
	// add listener for confirm button
	public void paymentConfirm() {
		cart.btn_confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BillModel bill  = new BillModel("NV13", cart.cusID.getText(), cartProducts, null, 0, 0, 0, 0);
				bill.setSubtotal();
				bill.setDiscountID(getDiscountID());
				bill.setTenderAmount((Integer)cart.spinner_cusPaymentAmount.getValue());
				bill.setDiscountValue();
				bill.setTotal();
				System.out.println("BILL: "+ bill.getTotal());
				BillDAO.insertBill(bill); 
			}
		});
	}
	
	public void setDiscountToComboBox() {
		discountList = DiscountDAO.getDiscountList(); 
		String[] options = new String[discountList.size()+1]; 
		options[0] = null; 
		for (int i =0; i<discountList.size(); ++i) {
			options[i+1] = discountList.get(i).getName(); 
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
		if (index <1) return null; 
		DiscountModel discount = discountList.get(index-1); 
		BillModel bill  = new BillModel("NV13", cart.cusID.getText(), cartProducts, null, 0, 0, 0, 0);
		bill.setSubtotal();
		
		if (bill.getSubtotal()< discount.getTotalBill()) return null; 
		if (!discount.getCustomerType().equals("ALL") && !discount.getCustomerType().equals(customer.getLevel())) {
				return null; 
		
		}
		return discount.getDiscountID(); 
	}
	
	// g


}
