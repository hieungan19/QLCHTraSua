package controller;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

		//clicked on a table row
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
				System.out.println("NAME: " + ingredient.getName());
				if (ingredient != null) {
					form = new IngredientInfoForm(ingredient);
					form.lblNewLabel_ingredientID.setText(ingredient.getIngredientID());
					form.textField_unit.setText(ingredient.getUnit());
					form.spinner_amount.setValue(ingredient.getAmount());
					form.spinner_price.setValue(ingredient.getPrice());
					form.textField_name.setText(ingredient.getName());
					
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
									//đóng dialog yêu cầu xác nhận xóa
									Window window = SwingUtilities.getWindowAncestor(confirmDelete);
							        window.dispose(); 
							        deleteIngredient(ingredient.getIngredientID()); 
									AppOptionPaneDialog dialog = new AppOptionPaneDialog("Xóa thành công",1000);
									AppController.showPage(view);
									
									
								}});
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
							ingredient.setName( form.textField_name.getText());
							ingredient.setUnit(form.textField_unit.getText()); 
							ingredient.setAmount( (double) form.spinner_amount.getValue());
							ingredient.setPrice( (double) form.spinner_price.getValue()); 
							check = updateIngredientInfo(ingredient); 
							if (check !=0 ) {
								AppOptionPaneDialog dialog = new AppOptionPaneDialog(
										"Sửa thành công nguyên liệu:" + ingredient.getIngredientID(), 1000);
								
							}
							else {
								AppOptionPaneDialog dialog = new AppOptionPaneDialog(
										"Sửa không thành công" , 1000);
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
						String name = form.textField_name.getText();
						String unit = form.textField_unit.getText().toUpperCase();
						double amount = form.spinner_amount.getNumber();
						double price = form.spinner_price.getNumber();

						IngredientModel ingredient = insertIngredient(name, unit, amount, price);
						if (ingredient == null) {
							AppOptionPaneDialog dialog = new AppOptionPaneDialog("Thêm không thành công!", 1000);
						} else {
							AppOptionPaneDialog dialog = new AppOptionPaneDialog(
									"Thêm thành công.\nMã nguyên liệu:" + ingredient.getIngredientID(),
									5000);
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

	public IngredientModel insertIngredient(String name, String unit, double amount, double price) {
		IngredientModel model = new IngredientModel(null, name, unit, amount, price);
		int check = 0;
		check = IngredientDAO.insertIngredient(model);
		if (check == 1) {
			model = IngredientDAO.getMaxIDIngredient();
			return model;
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
		int check = IngredientDAO.updateIngredient(ingredient.getIngredientID(), ingredient.getName(), ingredient.getUnit(), ingredient.getAmount(), ingredient.getPrice());
		if (check==1) {
			DefaultTableModel dtm = (DefaultTableModel) view.scrollPane_ingredient.jTable.getModel();
			dtm.setValueAt(ingredient.getName(), selectedRow,1);
			dtm.setValueAt(ingredient.getUnit(), selectedRow, 2);
			dtm.setValueAt(ingredient.getAmount(), selectedRow,3);
			dtm.setValueAt(ingredient.getPrice(),selectedRow , 4);
			return 1; 
		}
		return 0; 
		
	}
	public int deleteIngredient(String id) {
		int check = IngredientDAO.deleteIngredientByID(id); 
		if (check==1) {
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
				if (ie.getAmount()>0) dtm.addRow(ie.toObject());
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
				if (ie.getAmount()<0) dtm.addRow(ie.toObject());
			}
		}
		view.scrollPane_export.jTable.setModel(dtm);
	}
}
