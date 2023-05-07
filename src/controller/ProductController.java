package controller;

import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import constant.AppValues;
import dao.IngredientDAO;
import dao.ProductDAO;
import diaglog.AppDialog;
import diaglog.AppOptionPaneDialog;
import globalComponent.MultiLineTableCellRenderer;
import model.IngredientModel;
import model.ProductDetail;
import model.ProductModel;
import view.product.ChooseIngredientDetail;
import view.product.ChooseIngredientPanel;
import view.product.ProductInfoForm;
import view.product.ProductPageView;

public class ProductController {
	ProductPageView view;
	JTable table;
	ProductInfoForm form;
	List<IngredientModel> ingreList;
	JPanel panel_ingreDetails;
	Set<String> ingreIDSet;
	List<ChooseIngredientDetail> choseIngreDetailsList;
	List<ProductModel> productList;
	private int selectedRow;

	public ProductController(ProductPageView view) {
		// TODO Auto-generated constructor stub
		this.view = view;
		this.table = view.scrollPane_product.jTable;
		table.setDefaultRenderer(String.class, new MultiLineTableCellRenderer());
		ingreList = getIngredientList();
		displayProductListToTable();

		// search bar
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(sorter);
		view.searchBar.searchField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				search(view.searchBar.searchField.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				search(view.searchBar.searchField.getText());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				search(view.searchBar.searchField.getText());
			}

			private void search(String text) {
				if (text.trim().length() == 0) {
					sorter.setRowFilter(null);
				} else {
					// Tìm kiếm theo giá trị nhập vào
					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}
		});

		// click on row

		table.addMouseListener(new MouseListener() {

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
				ProductModel product = getProductModelBySelectingRow();
				form = new ProductInfoForm();
				setDataOnForm(product);
				AppController.showPage(form);
				// chọn nguyên liệu
				form.chooseIngredientPanel.btn_addIngre.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						displayChoseIngredientIntoPanel();
					}
				});
				form.btn_chooseFile.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						chooseAndDisplayImage();
					}
				});
				// update sản phẩm
				form.btn_saveProduct.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						int check = updateProductAndDisplayIntoTable(form);
						if (check == 0) {
							AppOptionPaneDialog failDialog = new AppOptionPaneDialog("Lưu không thành công!", 5000);

						} else {
							AppOptionPaneDialog failDialog = new AppOptionPaneDialog("Lưu thành công!", 5000);
							AppController.showPage(view);

						}
						
					}
				});
				// xóa sản phẩm
				form.btn_deleteProduct.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						AppDialog confirmDelete = new AppDialog("Xác nhận xóa dữ liệu");
						confirmDelete.setVisible(true);
						confirmDelete.okButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// Xử lý khi người dùng xác nhận xóa
								// đóng dialog yêu cầu xác nhận xóa
								Window window = SwingUtilities.getWindowAncestor(confirmDelete);
								window.dispose();
								deleteProduct(product.getProductID());
								AppOptionPaneDialog dialog = new AppOptionPaneDialog("Xóa thành công", 1000);
								AppController.showPage(view);

							}
						});
						confirmDelete.cancelButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								confirmDelete.dispose();
							}
						});
					}
				});
			}
		});

		// click add button;
		view.btn_addProduct.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				form = new ProductInfoForm();
				ingreIDSet = new HashSet<String>();
				choseIngreDetailsList = new ArrayList<>();
				panel_ingreDetails = form.chooseIngredientPanel.panel_ingre;
				AppController.showPage(form);
				displayIngredientToComboBox(form.chooseIngredientPanel.comboBox_ingreList);

				// Step 1: choose image file
				form.btn_chooseFile.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						chooseAndDisplayImage();
					}
				});

				// Step 2: choose ingredient

				form.chooseIngredientPanel.btn_addIngre.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						displayChoseIngredientIntoPanel();

						// TODO Auto-generated method stub
						// displayChoseIngredientIntoPanel();
					}
				});

				form.btn_deleteProduct.setVisible(false);
				// Step 3: Save
				form.btn_saveProduct.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						ProductModel product = getProductModelFromView(form);
						int check = insertProductAndDisplayIntoTable(product);
						if (check ==0 ) {
							AppOptionPaneDialog failDialog = new AppOptionPaneDialog("Thêm dữ liệu không thành công!", 5000);
							
						}
						else {
							AppOptionPaneDialog failDialog = new AppOptionPaneDialog("Thêm dữ liệu thành công!", 5000);
							AppController.showPage(view); 
						}
						
					}
				});

			}
		});

	}

	public void chooseAndDisplayImage() {
		form.imageUri = chooseAndGetImageUri();

		// Load the image from file
		File imageFile = new File(form.imageUri);
		String imageURL = imageFile.toURI().toString();
		// Embed the image in an HTML <img> tag
		String html = "<html><body><img src=\"" + imageURL + "\" width=\"200\" height=\"200\"></body></html>";

		form.editorPane_image.setText(html);
		System.out.println("FILE PATH: " + form.imageUri);
	}

	// set dữ liệu lên view
	public void setDataOnForm(ProductModel product) {
		choseIngreDetailsList = new ArrayList<>();
		ingreIDSet = new HashSet<>();
		ingreList = getIngredientList();

		System.out.println("SET DATA ON FORM - Ingrelist Size: " + ingreList.size());
		// set name
		form.textField_name.setText(product.getName());
		// set type
		form.textField_type.setText(product.getType());
		// set price
		form.spinner_price.setValue(product.getPrice());

		// set ID
		form.lblNewLabel_ID.setText(product.getProductID());
//		set image
		form.imageUri = product.getImageUri();
		System.out.println("Form image: " + form.imageUri);
		File imageFile = new File(form.imageUri);
		String imageURL = imageFile.toURI().toString();
		// Embed the image in an HTML <img> tag
		String html = "<html><body><img src=\"" + imageURL + "\" width=\"200\" height=\"200\"></body></html>";
		form.editorPane_image.setText(html);
//		

		// set ingredient for comboBox

		displayIngredientToComboBox(form.chooseIngredientPanel.comboBox_ingreList);

		// set ingredient panel
		panel_ingreDetails = form.chooseIngredientPanel.panel_ingre;

		List<ProductDetail> productDetailList = product.getIngredientList();

		for (int i = 0; i < productDetailList.size(); ++i) {
			for (int j = 0; j < ingreList.size(); ++j) {
				if (productDetailList.get(i).getIngredientID().equals(ingreList.get(j).getIngredientID()))
					displayIngredientIntoPanelFromDB(productDetailList.get(i), j);
			}
		}

	}

	// hiển thị dữ liệu các nguyên liệu đã lấy được từ database lên scroll jPanel

	public void displayIngredientIntoPanelFromDB(ProductDetail productDetail, int index) {

		if (!ingreIDSet.contains(ingreList.get(index).getIngredientID())) {
			ChooseIngredientDetail temp = new ChooseIngredientDetail(ingreList.get(index));
			temp.spinner.setValue(productDetail.getiAmount());
			panel_ingreDetails.add(temp);
			choseIngreDetailsList.add(temp);
			System.out.println("INGREDIENT LIST SIZE: " + choseIngreDetailsList.size());
			ingreIDSet.add(ingreList.get(index).getIngredientID());
			System.out.println("INGRE ID: " + ingreList.get(index).getIngredientID());
		}
		panel_ingreDetails.validate();
		panel_ingreDetails.repaint();
	}

	// lấy dữ liệu từ view
	public ProductModel getProductModelFromView(ProductInfoForm form) {
		String name = form.textField_name.getText();
		String type = form.textField_type.getText();
		double price = form.spinner_price.getNumber();
		String productID = form.lblNewLabel_ID.getText();
		String imageUri = form.imageUri;

		List<ProductDetail> ingreList = new ArrayList<>();
		for (int i = 0; i < choseIngreDetailsList.size(); ++i) {
			String ingreID = choseIngreDetailsList.get(i).ingredient.getIngredientID();
			double amount = choseIngreDetailsList.get(i).spinner.getNumber();

			String iName = choseIngreDetailsList.get(i).ingredient.getName();
			System.out.println("NAME: " + iName + "- AMOUNT" + amount);

			ProductDetail productDetail = new ProductDetail();
			productDetail.setIngredientID(ingreID);
			productDetail.setiAmount(amount);
			productDetail.setiName(iName);
			if (productDetail.getiAmount() >= 0)
				ingreList.add(productDetail);

		}

		ProductModel product = new ProductModel();
		product.setName(name);
		product.setImageUri(imageUri);
		product.setPrice(price);
		product.setType(type);
		product.setIngredientList(ingreList);
		product.setProductID(productID);

		System.out.println("DETAIL LIST SIZE: " + product.getIngredientList().size());

		return product;

	}

	// Hiển thị nguyên liệu đã chọn lên jPanel bằng cách chọn và nhấn add add trong
	// combo box
	public IngredientModel displayChoseIngredientIntoPanel() {
		JComboBox comboBox = form.chooseIngredientPanel.comboBox_ingreList;
		int index = comboBox.getSelectedIndex() - 1;
		if (index >= 0) {
			System.out.println("NAME OF INGRE: " + ingreList.get(index).getName());
			if (!ingreIDSet.contains(ingreList.get(index).getIngredientID())) {
				ChooseIngredientDetail temp = new ChooseIngredientDetail(ingreList.get(index));
				panel_ingreDetails.add(temp);
				choseIngreDetailsList.add(temp);
				System.out.println("INGREDIENT LIST SIZE: " + choseIngreDetailsList.size());
				ingreIDSet.add(ingreList.get(index).getIngredientID());
				System.out.println("INDEX: " + index);
			}

		}
		panel_ingreDetails.validate();
		panel_ingreDetails.repaint();
		return ingreList.get(index);
	}

	public String chooseAndGetImageUri() {
		JFileChooser fileChooser = new JFileChooser();
		String imagePath = "";
		fileChooser.setDialogTitle("Choose an image file");

		// Set filter to show only image files
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif");
		fileChooser.setFileFilter(filter);

		int result = fileChooser.showOpenDialog(null);

		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			imagePath = selectedFile.getAbsolutePath();
			// Use the image path as needed
		}
		System.out.println("IMAGE PATH: " + imagePath);

		return imagePath;

	}

	List<ProductModel> getProductList() {
		return ProductDAO.getProductList();
	}

	// Hiển thị tên các nguyên liệu cho user chọn
	public void displayIngredientToComboBox(JComboBox comboBox) {
		String ingreOptions[] = new String[ingreList.size() + 1];
		ingreOptions[0] = null;
		for (int i = 0; i < ingreList.size(); ++i) {
			ingreOptions[i + 1] = ingreList.get(i).getName();
		}
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(ingreOptions);
		comboBox.setModel(model);
	}

	// Hiển thị toàn bộ các sản phẩm
	public void displayProductListToTable() {

		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		List<ProductModel> productList = ProductDAO.getProductList();
		dtm.setNumRows(0);
		if (productList.isEmpty()) {
			System.out.println("Không có sản phẩm nào.");
		} else {
			for (int i = 0; i < productList.size(); i++) {
				ProductModel product = productList.get(i);
				dtm.addRow(product.toOject());
				ImageIcon imageIcon = new ImageIcon(new ImageIcon(product.getImageUri()).getImage()
						.getScaledInstance(100, 100, Image.SCALE_DEFAULT));
				dtm.setValueAt(imageIcon, i, 1); // row and column indices start from 0
			}
		}
		table.setModel(dtm);
	}

	List<IngredientModel> getIngredientList() {
		return IngredientDAO.getIngredientList();

	}

	// thêm mới 1 sản phẩm và add nơ vào table
	public int insertProductAndDisplayIntoTable(ProductModel product) {
		int check = ProductDAO.insertProduct(product);
		ProductModel insertedProduct = ProductDAO.getMaxIDProduct();
		product.setProductID(insertedProduct.getProductID());

		if (check == 1) {
			DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			dtm.addRow(product.toOject());

			ImageIcon imageIcon = new ImageIcon(
					new ImageIcon(product.getImageUri()).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
			dtm.setValueAt(imageIcon, table.getRowCount() - 1, 1);
		}
		return check;

	}

	// lấy dữ liệu product bằng cách chọn 1 dòng
	public ProductModel getProductModelBySelectingRow() {
		selectedRow = table.getRowSorter().convertRowIndexToModel(table.getSelectedRow());
		if (selectedRow == -1)
			return null;
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		String id = String.valueOf(tableModel.getValueAt(selectedRow, 0));
		return ProductDAO.getProductByID(id);
	}

	// xóa dữ liệu trong db và trong table
	public int deleteProduct(String id) {
		int check = ProductDAO.deleteProductByID(id);
		if (check == 1) {
			DefaultTableModel dtm = (DefaultTableModel) view.scrollPane_product.jTable.getModel();
			dtm.removeRow(selectedRow);
			return 1;
		}
		return 0;
	}

	// update dữ liệu trong db và trong table
	public int updateProductAndDisplayIntoTable(ProductInfoForm form) {
		ProductModel product = getProductModelFromView(form);
		System.out.println("PRODUCT HAS TO UPDATE: " + product.getName());
		int check = ProductDAO.updateProduct(product);
		if (check == 1) {
			DefaultTableModel dtm = (DefaultTableModel) view.scrollPane_product.jTable.getModel();
			ImageIcon imageIcon = new ImageIcon(
					new ImageIcon(product.getImageUri()).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
			dtm.setValueAt(imageIcon, selectedRow, 1);
			dtm.setValueAt(product.getName(), selectedRow, 2);
			dtm.setValueAt(product.getType(), selectedRow, 3);
			dtm.setValueAt(product.getPrice(), selectedRow, 4);
			dtm.setValueAt(product.toStringIngredientList(), selectedRow, 5);

		}
		return check;

	}
	
	

}
