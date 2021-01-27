package GiaoDien;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dbs.DanhSachKeToan;
import entitis.ThanhToan;
import entitis.ThuePhong;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.awt.event.ItemEvent;

public class FormKeToan extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private JPanel contentPane;
	private JTextField txtTim;
	private JButton btnThoat;
	private DanhSachKeToan dskt= new DanhSachKeToan();
	private java.util.List<ThanhToan> list;
	private DefaultTableModel tableModel;
	private JTable table;
	private static final String REGEX_Tim = "[^!@#$&*%,.~?:;/]+";
	
	public JPanel panKT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormKeToan frame = new FormKeToan();
					frame = new FormKeToan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormKeToan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1160, 728);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panKT = new JPanel();
		panKT.setBounds(0, 110, 1144, 563);
		contentPane.add(panKT);
		panKT.setLayout(null);

		JLabel lblTimHD = new JLabel("Tìm Hoá Đơn ");
		lblTimHD.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimHD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTimHD.setBounds(20, 117, 370, 26);
		panKT.add(lblTimHD);

		JLabel lblXem = new JLabel("Xem các hoá đơn");
		lblXem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblXem.setBounds(10, 75, 130, 40);
		panKT.add(lblXem);

		txtTim = new JTextField();
		txtTim.setBounds(20, 159, 196, 26);
		txtTim.setColumns(10);
		panKT.add(txtTim);


		//	JScrollPane scrollPaneDichVu = new JScrollPane();
		//scrollPaneDichVu.setBounds(416, 84, 691, 442);



		String tieude[]= {"Mã Thuê","Thành Tiền", "Hình thức Thanh toán","Ghi Chú","Ngày Thanh toán"};
		tableModel = new DefaultTableModel(tieude, 0);
		table = new JTable(tableModel);
		JScrollPane sc = new JScrollPane(table);
		sc.setBounds(416, 84, 691, 442);
		sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sc.setPreferredSize(new Dimension(900, 350));
		panKT.add(sc);



		JPanel panKetoan = new JPanel();
		panKetoan.setBounds(0, 21, 1106, 40);
		panKT.add(panKetoan);
		panKetoan.setBackground(new Color(34, 139, 34));
		panKetoan.setLayout(null);

		JLabel lblKT = new JLabel("Kế Toán");
		lblKT.setBackground(new Color(51, 204, 0));
		lblKT.setBounds(176, 0, 751, 40);
		panKetoan.add(lblKT);
		lblKT.setForeground(Color.YELLOW);
		lblKT.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblKT.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnTim = new JButton("TÌM");
		btnTim.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				{
					dbs.Database.getIntance().connect();
					XoaHetDuLieuTableModel(table);
					capnhatDLTable();			
					timHoaDon();
					list.clear();
				}
			}
		});
		btnTim.setBackground(new Color(204, 204, 204));
		btnTim.setForeground(new Color(255, 0, 153));
		btnTim.setBounds(256, 159, 115, 29);
		panKT.add(btnTim);

		JButton btnXem = new JButton("Xem ");
		btnXem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dbs.Database.getIntance().connect();
				XoaHetDuLieuTableModel(table);
				capnhatDLTable();
				list.clear();
			}
		});
		btnXem.setBackground(new Color(204, 204, 204));
		btnXem.setForeground(new Color(0, 0, 255));
		btnXem.setBounds(155, 81, 121, 29);
		panKT.add(btnXem);

		JLabel lblThngKDoanh = new JLabel("Thống kê doanh thu");
		lblThngKDoanh.setForeground(Color.MAGENTA);
		lblThngKDoanh.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngKDoanh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblThngKDoanh.setBounds(0, 348, 401, 23);
		panKT.add(lblThngKDoanh);

		JButton btnTK = new JButton("Thống Kê Tổng ");
		btnTK.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				dbs.Database.getIntance().connect();
				XoaHetDuLieuTableModel(table);
				capnhatDLTable();
				list.clear();
				double tongtien;
					tongtien = dskt.getSumThanhTien();
					JOptionPane.showMessageDialog(null, "Tổng doanh thu là:"+tongtien+"VNĐ");
				
			}
		});
//		double tongtien = dskt.getSumThanhTien();
//		JOptionPane.showMessageDialog(null, "Tổng doanh thu là:"+tongtien+"VNĐ");
		btnTK.setBackground(new Color(204, 204, 204));
		btnTK.setForeground(new Color(0, 0, 255));
		btnTK.setBounds(20, 497, 260, 29);
		panKT.add(btnTK);

		btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(this);
		btnThoat.setBackground(new Color(204, 204, 204));
		btnThoat.setForeground(new Color(255, 153, 0));
		btnThoat.setBounds(312, 500, 89, 26);
		panKT.add(btnThoat);

		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(comboBox.getSelectedItem().equals("Trên 500.000Đ")) {
					ThongKeTren500();
					list.clear();
				}
				if(comboBox.getSelectedItem().equals("Dưới 500.000Đ")) {
					ThongKeDuoi500();
					list.clear();
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Dưới 500.000Đ", "Trên 500.000Đ"}));	
		comboBox.setBounds(115, 201, 161, 26);
		panKT.add(comboBox);

		JLabel lblTin = new JLabel("Tiền :");
		lblTin.setBounds(30, 201, 69, 20);
		panKT.add(lblTin);

		JLabel lblHnhThc = new JLabel("Hình thức :");
		lblHnhThc.setBounds(20, 246, 89, 20);
		panKT.add(lblHnhThc);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(comboBox_1.getSelectedItem().equals("Tiền mặt")) {
					ThongKeTienMat();
					list.clear();
				}
				if(comboBox_1.getSelectedItem().equals("Thẻ thanh toán")) {
					ThongKeTheThanhToan();
					list.clear();
				}
				if(comboBox_1.getSelectedItem().equals("Chuyển khoản")) {
					ThongKeChuyenKhoan();
					list.clear();
				}
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Tiền mặt", "Thẻ thanh toán", "Chuyển khoản"}));
		comboBox_1.setBounds(115, 243, 161, 26);
		panKT.add(comboBox_1);

		JLabel lblNm = new JLabel("Năm :");
		lblNm.setBounds(20, 288, 69, 20);
		panKT.add(lblNm);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addItemListener(new ItemListener() {		
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if(comboBox_2.getSelectedItem().equals("2019")) {
					ThongKe2019();
					list.clear();
				}
				if(comboBox_2.getSelectedItem().equals("2018")) {
					ThongKe2018();
					list.clear();
				}
				if(comboBox_2.getSelectedItem().equals("2017")){
					ThongKe2017();
					list.clear();
				}
				if(comboBox_2.getSelectedItem().equals("2016")) {
					ThongKe2016();
					list.clear();				
				}
				if(comboBox_2.getSelectedItem().equals("2015")) {
					ThongKe2015();
					list.clear();
				}
			}
		});
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"2019", "2018", "2017", "2016", "2015"}));
		comboBox_2.setBounds(115, 285, 161, 26);
		panKT.add(comboBox_2);
		
		JComboBox thongkenam = new JComboBox();
		thongkenam.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(thongkenam.getSelectedItem().equals("Doanh thu năm 2019")) {
					double tongtien;
					
						tongtien = dskt.DT2019();
						JOptionPane.showMessageDialog(null, "Tổng doanh thu 2019 là:"+tongtien+"VNĐ");
						
			}
				 if(thongkenam.getSelectedItem().equals("Doanh thu năm 2018")) {

					double tongtien;
						tongtien = dskt.DT2018();
						JOptionPane.showMessageDialog(null, "Tổng doanh thu 2018 là:"+tongtien+"VNĐ");
			}
				if(thongkenam.getSelectedItem().equals("Doanh thu năm 2017")) {

					double tongtien;
						tongtien = dskt.DT2017();
						JOptionPane.showMessageDialog(null, "Tổng doanh thu 2017 là:"+tongtien+"VNĐ");
			}
				if(thongkenam.getSelectedItem().equals("Doanh thu năm 2016")) {

					double tongtien;
						tongtien = dskt.DT2016();
						JOptionPane.showMessageDialog(null, "Tổng doanh thu 2016 là:"+tongtien+"VNĐ");
			}
				if(thongkenam.getSelectedItem().equals("Doanh thu năm 2015")) {

					double tongtien;
						tongtien = dskt.DT2015();
						JOptionPane.showMessageDialog(null, "Tổng doanh thu 2015 là:"+tongtien+"VNĐ");
			}
				
			}
		});
		thongkenam.setModel(new DefaultComboBoxModel(new String[] {"Doanh thu năm 2019", "Doanh thu năm 2018", "Doanh thu năm 2017", "Doanh thu năm 2016", "Doanh thu năm 2015"}));
		thongkenam.setBounds(84, 387, 212, 40);
		panKT.add(thongkenam);
		//		dbs.Database.getIntance().connect();
		//		capnhatDLTable();

	}	
	private void capnhatDLTable() {
		list = dskt.docTuBang();
		for (ThanhToan t : list) {
			String[] rowData= {t.getMaThue().getMaThue(), String.valueOf(t.getThanhTien()),t.getHinhThucThanhToan(),t.getGhiChu(),t.getNgayThanhToan().toString()};
			tableModel.addRow(rowData);
		}
		table.setModel(tableModel);
	}
	private void XoaHetDuLieuTableModel(JTable table) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		//dtm.getDataVector().removeAllElements();
		dtm.setNumRows(0);
	}

	private void timHoaDon() {
		String key = txtTim.getText();
		list.clear();
		list= dskt.Tim(key);
		if(key.equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin tìm");
			XoaHetDuLieuTableModel(table);
			list.clear();
			capnhatDLTable();
		}
		if(validData()) 
			if(list != null) {
				XoaHetDuLieuTableModel(table);
				for (ThanhToan t : list) {
					String[] rowData= {t.getMaThue().getMaThue(), String.valueOf(t.getThanhTien()),t.getHinhThucThanhToan(),t.getGhiChu(),t.getNgayThanhToan().toString()};
					tableModel.addRow(rowData);
				}
			}

		table.setModel(tableModel);
	}

	private void ThongKeTren500() {
		list.clear();
		list= dskt.ThongKeTren500();
		if(list != null) {
			XoaHetDuLieuTableModel(table);
			for (ThanhToan t : list) {
				String[] rowData= {t.getMaThue().getMaThue(), String.valueOf(t.getThanhTien()),t.getHinhThucThanhToan(),t.getGhiChu(),t.getNgayThanhToan().toString()};
				tableModel.addRow(rowData);
			}
		}

		table.setModel(tableModel);
	}
	private void ThongKeDuoi500() {
		list.clear();
		list= dskt.ThongKeDuoi500();
		if(list != null) {
			XoaHetDuLieuTableModel(table);
			for (ThanhToan t : list) {
				String[] rowData= {t.getMaThue().getMaThue(), String.valueOf(t.getThanhTien()),t.getHinhThucThanhToan(),t.getGhiChu(),t.getNgayThanhToan().toString()};
				tableModel.addRow(rowData);
			}
		}

		table.setModel(tableModel);
	}
	private void ThongKeTienMat() {
		list.clear();
		list= dskt.ThongKeTienMat();
		if(list != null) {
			XoaHetDuLieuTableModel(table);
			for (ThanhToan t : list) {
				String[] rowData= {t.getMaThue().getMaThue(), String.valueOf(t.getThanhTien()),t.getHinhThucThanhToan(),t.getGhiChu(),t.getNgayThanhToan().toString()};
				tableModel.addRow(rowData);
			}
		}

		table.setModel(tableModel);
	}
	private void ThongKeTheThanhToan() {
		list.clear();
		list= dskt.ThongKeTheThanhToan();
		if(list != null) {
			XoaHetDuLieuTableModel(table);
			for (ThanhToan t : list) {
				String[] rowData= {t.getMaThue().getMaThue(), String.valueOf(t.getThanhTien()),t.getHinhThucThanhToan(),t.getGhiChu(),t.getNgayThanhToan().toString()};
				tableModel.addRow(rowData);
			}
		}

		table.setModel(tableModel);
	}
	private void ThongKeChuyenKhoan() {
		list.clear();
		list= dskt.ThongKeChuyenKhoan();
		if(list != null) {
			XoaHetDuLieuTableModel(table);
			for (ThanhToan t : list) {
				String[] rowData= {t.getMaThue().getMaThue(), String.valueOf(t.getThanhTien()),t.getHinhThucThanhToan(),t.getGhiChu(),t.getNgayThanhToan().toString()};
				tableModel.addRow(rowData);
			}
		}

		table.setModel(tableModel);
	}
	private void ThongKe2019() {
		list.clear();
		list= dskt.ThongKe2019();
		if(list != null) {
			XoaHetDuLieuTableModel(table);
			for (ThanhToan t : list) {
				String[] rowData= {t.getMaThue().getMaThue(), String.valueOf(t.getThanhTien()),t.getHinhThucThanhToan(),t.getGhiChu(),t.getNgayThanhToan().toString()};
				tableModel.addRow(rowData);
			}
		}

		table.setModel(tableModel);
	}
	private void ThongKe2018() {
		list.clear();
		list= dskt.ThongKe2018();
		if(list != null) {
			XoaHetDuLieuTableModel(table);
			for (ThanhToan t : list) {
				String[] rowData= {t.getMaThue().getMaThue(), String.valueOf(t.getThanhTien()),t.getHinhThucThanhToan(),t.getGhiChu(),t.getNgayThanhToan().toString()};
				tableModel.addRow(rowData);
			}
		}

		table.setModel(tableModel);
	}
	private void ThongKe2017() {
		list.clear();
		list= dskt.ThongKe2017();
		if(list != null) {
			XoaHetDuLieuTableModel(table);
			for (ThanhToan t : list) {
				String[] rowData= {t.getMaThue().getMaThue(), String.valueOf(t.getThanhTien()),t.getHinhThucThanhToan(),t.getGhiChu(),t.getNgayThanhToan().toString()};
				tableModel.addRow(rowData);
			}
		}

		table.setModel(tableModel);
	}
	private void ThongKe2016() {
		list.clear();
		list= dskt.ThongKe2016();
		if(list != null) {
			XoaHetDuLieuTableModel(table);
			for (ThanhToan t : list) {
				String[] rowData= {t.getMaThue().getMaThue(), String.valueOf(t.getThanhTien()),t.getHinhThucThanhToan(),t.getGhiChu(),t.getNgayThanhToan().toString()};
				tableModel.addRow(rowData);
			}
		}

		table.setModel(tableModel);
	}
	private void ThongKe2015() {
		list.clear();
		list= dskt.ThongKe2015();
		if(list != null) {
			XoaHetDuLieuTableModel(table);
			for (ThanhToan t : list) {
				String[] rowData= {t.getMaThue().getMaThue(), String.valueOf(t.getThanhTien()),t.getHinhThucThanhToan(),t.getGhiChu(),t.getNgayThanhToan().toString()};
				tableModel.addRow(rowData);
			}
		}

		table.setModel(tableModel);
	}
	private boolean validData(){
		String tim = txtTim.getText().trim();
		if(!( tim.matches(REGEX_Tim)))
		{
			JOptionPane.showMessageDialog(null, "Tìm Hoá Đơn không bao gồm kí tự đặc biệt."
					+ "Tìm theo chữ hoặc kí số");
			return false;
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnThoat)) {
			int re = JOptionPane.showConfirmDialog(null, "Bạn có chắc ĐĂNG XUẤT ?");
			if(re==JOptionPane.YES_OPTION) {
				this.dispose();
			}
		}

	}
}
