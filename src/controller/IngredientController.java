package controller;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import dao.CustomerDAO;
import dao.IngredientDAO;
import diaglog.AppDialog;
import diaglog.AppOptionPaneDialog;
import model.CustomerModel;
import model.ImportExportModel;
import model.IngredientModel;
import view.inventory.IngredientInfoForm;
import view.inventory.IngredientPageView;

public class IngredientController {
	public IngredientPageView view;
	public IngredientInfoForm form;
	public JTable table;
	private int selectedRow;
	List<ImportExportModel> importExportList;

	public IngredientController(IngredientPageView view) {
		this.view = view;
		this.table = view.scrollPane_ingredient.jTable;
		displayIngredientListToTable();
		displayImportTable();
		displayExportTable();
		// Khởi tạo TableRowSorter
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

		// clicked on a table row
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
				IngredientModel ingredient = getIngredientBySelected();
				if (ingredient != null) {
					
					setDataToForm(ingredient);

					AppController.showPage(form);

					form.btnDelete.addActionListener(new ActionListener() {

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
									deleteIngredient(ingredient.getIngredientID());
									AppOptionPaneDialog dialog = new AppOptionPaneDialog("Xóa thành công", 1000);
									AppController.showPage(view);
									displayExportTable();
									displayImportTable();

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

					form.btnSave.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							int check = 0;
							IngredientModel newIngre = getDataFromForm();
							newIngre.setIngredientID(ingredient.getIngredientID());
							check = updateIngredientInfo(newIngre);
							if (check != 0) {
								AppOptionPaneDialog dialog = new AppOptionPaneDialog(
										"Sửa thành công nguyên liệu:" + ingredient.getIngredientID(), 1000);

							} else {
								AppOptionPaneDialog dialog = new AppOptionPaneDialog("Sửa không thành công", 1000);
							}

							AppController.showPage(view);
							displayExportTable();
							displayImportTable();
						}
					});
				}
			}
		});

		view.btn_addIngredient.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				form = new IngredientInfoForm(null);
				AppController.showPage(form);
				form.btnSave.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						IngredientModel ingredient = getDataFromForm();
						ingredient = insertIngredient(ingredient); 
						
						if (ingredient == null) {
							AppOptionPaneDialog dialog = new AppOptionPaneDialog("Thêm không thành công!", 1000);
						} else {
							AppOptionPaneDialog dialog = new AppOptionPaneDialog(
									"Thêm thành công.\nMã nguyên liệu:" + ingredient.getIngredientID(), 5000);
							AppController.showPage(view);
							displayImportTable();
							displayExportTable();
							addIngredientToTable(ingredient);
						}

					}
				});

			}
		});

	}
	public IngredientModel getDataFromForm() {
		String name = form.textField_name.getText();
		String unit = form.comboBox_unit.getSelectedItem().toString();
		double amount = form.spinner_amount.getNumber();
		double price = form.spinner_price.getNumber();
		Date mfDate = form.mfDate.getDate();
		Date expDate  = form.expDate.getDate();
		String supplier = form.textField_supplier.getText();
		IngredientModel i = new IngredientModel(name, unit, amount, price, mfDate, expDate, supplier);
		return i; 
		
	}

	public void addIngredientToTable(IngredientModel ingredient) {
		DefaultTableModel dtm = (DefaultTableModel) view.scrollPane_ingredient.jTable.getModel();
		dtm.addRow(ingredient.toObject());
	}

	public void displayIngredientListToTable() {

		DefaultTableModel dtm = (DefaultTableModel) view.scrollPane_ingredient.jTable.getModel();
		List<IngredientModel> ingredientList = IngredientDAO.getIngredientList();
		dtm.setNumRows(0);
		if (ingredientList.isEmpty()) {
			System.out.println("Khong co nguyen lieu.");
		} else {
			for (int i = 0; i < ingredientList.size(); i++) {
				IngredientModel ingredient = ingredientList.get(i);
				dtm.addRow(ingredient.toObject());
			}
		}
		table.setModel(dtm);
	}

	public IngredientModel insertIngredient(IngredientModel i) {
		int check = 0;
		check = IngredientDAO.insertIngredient(i);
		if (check == 1) {
			i = IngredientDAO.getMaxIDIngredient();
			return i;
		}
		return null;

	}

	public IngredientModel getIngredientBySelected() {
		selectedRow = table.getRowSorter().convertRowIndexToModel(table.getSelectedRow());
		if (selectedRow == -1)
			return null;
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		String id = String.valueOf(tableModel.getValueAt(selectedRow, 0));
		return IngredientDAO.getIngredientByID(id);
	}

	public int updateIngredientInfo(IngredientModel ingredient) {
		int check = IngredientDAO.updateIngredient(ingredient);
		if (check == 1) {
			DefaultTableModel dtm = (DefaultTableModel) view.scrollPane_ingredient.jTable.getModel();
			dtm.setValueAt(ingredient.getName(), selectedRow, 1);
			dtm.setValueAt(ingredient.getUnit(), selectedRow, 2);
			dtm.setValueAt(ingredient.getAmount(), selectedRow, 3);
			dtm.setValueAt(ingredient.getPrice(), selectedRow, 4);
			dtm.setValueAt(ingredient.getMfDate(),selectedRow, 5);
			dtm.setValueAt(ingredient.getExpDate(),selectedRow, 6);
			dtm.setValueAt(ingredient.getSupplier(),selectedRow, 7);
			return 1;
		}
		return 0;

	}

	public int deleteIngredient(String id) {
		int check = IngredientDAO.deleteIngredientByID(id);
		if (check == 1) {
			DefaultTableModel dtm = (DefaultTableModel) view.scrollPane_ingredient.jTable.getModel();
			dtm.removeRow(selectedRow);
			return 1;
		}
		return 0;
	}

	public void displayImportTable() {
		DefaultTableModel dtm = (DefaultTableModel) view.scrollPane_import.jTable.getModel();
		importExportList = IngredientDAO.getImportExportModelList();
		dtm.setNumRows(0);
		if (importExportList.isEmpty()) {
			System.out.println("Khong co nguyen lieu.");
		} else {
			for (int i = 0; i < importExportList.size(); i++) {
				ImportExportModel ie = importExportList.get(i);
				if (ie.getAmount() > 0)
					dtm.addRow(ie.toObject());
			}
		}
		view.scrollPane_import.jTable.setModel(dtm);
	}

	public void displayExportTable() {
		DefaultTableModel dtm = (DefaultTableModel) view.scrollPane_export.jTable.getModel();
		importExportList = IngredientDAO.getImportExportModelList();
		dtm.setNumRows(0);
		if (importExportList.isEmpty()) {
			System.out.println("Khong co nguyen lieu.");
		} else {
			for (int i = 0; i < importExportList.size(); i++) {
				ImportExportModel ie = importExportList.get(i);
				if (ie.getAmount() < 0)
					dtm.addRow(ie.toObject());
			}
		}
		view.scrollPane_export.jTable.setModel(dtm);
	}
	public void setDataToForm(IngredientModel i) {
		form = new IngredientInfoForm(i); 
		form.lblNewLabel_ingredientID.setText(i.getIngredientID());
		form.comboBox_unit.setSelectedItem(i.getUnit());
		form.spinner_amount.setValue(i.getAmount());
		form.spinner_price.setValue(i.getPrice());
		form.textField_name.setText(i.getName());
		form.comboBox_unit.setSelectedItem(i.getUnit());
		form.mfDate.setDate(i.getMfDate());
		form.expDate.setDate(i.getExpDate());
		form.textField_supplier.setText(i.getSupplier());
	
	}
}
