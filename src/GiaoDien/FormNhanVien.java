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
import dbs.DanhSachNhanSu;
import dbs.DanhSachNhanVien;
import entitis.NhanSu;
import entitis.NhanVien;
import entitis.ThanhToan;
import entitis.ThuePhong;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FormNhanVien extends JFrame implements ActionListener,MouseListener{
	
		/**
		 * 
		 */
		private JPanel contentPane;
		private DanhSachNhanVien dsnv= new DanhSachNhanVien();
		private java.util.List<NhanVien> list;
		private DefaultTableModel tableModel;
		private JTable table;
		private static final String REGEX_Tim = "[^!@#$&*%,.~?:;/]+";
		private JTextField txtma;
		private JTextField txtten;
		private JTextField txtchucvu;
		private JTextField txtdiachi;
		private JTextField txtngaysinh;
		private JTextField txtsdt;
		private JTextField txttim;
		public JPanel panKT;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						FormNhanVien frame = new FormNhanVien();
						frame = new FormNhanVien();
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
		public FormNhanVien() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1158, 729);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			panKT = new JPanel();
			panKT.setBounds(0, 119, 1144, 563);
			contentPane.add(panKT);
			panKT.setLayout(null);


			//	JScrollPane scrollPaneDichVu = new JScrollPane();
			//scrollPaneDichVu.setBounds(416, 84, 691, 442);



			String tieude[]= {"Mã Nhân Viên","Chức Vụ", "Tên Nhân Viên","Địa Chỉ","Ngày Sinh","Số Điện Thoại"};
			tableModel = new DefaultTableModel(tieude, 0);
			table = new JTable(tableModel);
			JScrollPane sc = new JScrollPane(table);
			sc.setBounds(0, 271, 1107, 276);
			sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			sc.setPreferredSize(new Dimension(900, 350));
			panKT.add(sc);



			JPanel panKetoan = new JPanel();
			panKetoan.setBounds(0, 21, 1106, 40);
			panKT.add(panKetoan);
			panKetoan.setLayout(null);

			JLabel lblKT = new JLabel("QUẢN LÍ NHÂN VIÊN");
			lblKT.setBackground(Color.pink);
			lblKT.setBounds(176, 0, 751, 40);
			panKetoan.add(lblKT);
			lblKT.setForeground(Color.BLUE);
			lblKT.setFont(new Font("Times New Roman", Font.BOLD, 20));
			lblKT.setHorizontalAlignment(SwingConstants.CENTER);
			
			txtma = new JTextField();
			txtma.setBounds(139, 79, 146, 26);
			panKT.add(txtma);
			txtma.setColumns(10);
			
			txtten = new JTextField();
			txtten.setText("");
			txtten.setBounds(731, 79, 271, 26);
			panKT.add(txtten);
			txtten.setColumns(10);
			
			txtchucvu = new JTextField();
			txtchucvu.setText("");
			txtchucvu.setBounds(451, 79, 146, 26);
			panKT.add(txtchucvu);
			txtchucvu.setColumns(10);
			
			txtdiachi = new JTextField();
			txtdiachi.setText("");
			txtdiachi.setBounds(117, 135, 211, 26);
			panKT.add(txtdiachi);
			txtdiachi.setColumns(10);
			
			txtngaysinh = new JTextField();
			txtngaysinh.setBounds(451, 135, 146, 26);
			panKT.add(txtngaysinh);
			txtngaysinh.setColumns(10);
			
			txtsdt = new JTextField();
			txtsdt.setBounds(778, 135, 211, 26);
			panKT.add(txtsdt);
			txtsdt.setColumns(10);
			
			JLabel lblMNhnVin = new JLabel("Mã nhân viên :");
			lblMNhnVin.setBounds(10, 82, 114, 20);
			panKT.add(lblMNhnVin);
			
			JLabel lblChcV = new JLabel("Chức vụ");
			lblChcV.setBounds(367, 82, 69, 20);
			panKT.add(lblChcV);
			
			JLabel lblTn = new JLabel("Tên :");
			lblTn.setBounds(647, 82, 69, 20);
			panKT.add(lblTn);
			
			JLabel lblaCh = new JLabel("Địa chỉ :");
			lblaCh.setBounds(10, 141, 69, 20);
			panKT.add(lblaCh);
			
			JLabel lblNgySinh = new JLabel("Ngày sinh :");
			lblNgySinh.setBounds(367, 138, 101, 20);
			panKT.add(lblNgySinh);
			
			JLabel lblSinThoi = new JLabel("Số điện thoại :");
			lblSinThoi.setBounds(647, 141, 137, 20);
			panKT.add(lblSinThoi);
			
			JButton btnThem = new JButton("THÊM");
			btnThem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(validDataThem())
						ThemNhanVien();
							
				}
			});
			btnThem.setBackground(Color.LIGHT_GRAY);
			btnThem.setForeground(Color.RED);
			btnThem.setBounds(9, 209, 172, 29);
			panKT.add(btnThem);
			
			JButton btnxoa = new JButton("XÓA");
			btnxoa.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					XoaNV();
				}
			});
			btnxoa.setBackground(Color.LIGHT_GRAY);
			btnxoa.setForeground(Color.MAGENTA);
			btnxoa.setBounds(195, 209, 151, 29);
			panKT.add(btnxoa);
			
			JButton btnsua = new JButton("SỬA");
			btnsua.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					SuaNV();
					
				}
			});
			btnsua.setBackground(Color.LIGHT_GRAY);
			btnsua.setForeground(Color.BLUE);
			btnsua.setBounds(367, 209, 146, 29);
			panKT.add(btnsua);
			
			txttim = new JTextField();
			txttim.setBounds(582, 210, 146, 26);
			panKT.add(txttim);
			txttim.setColumns(10);
			
			JButton btntim = new JButton("TÌM");
			btntim.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Tim();
				}
			});
			btntim.setBackground(Color.LIGHT_GRAY);
			btntim.setForeground(Color.ORANGE);
			btntim.setBounds(744, 209, 115, 29);
			panKT.add(btntim);
			//		dbs.Database.getIntance().connect();
			//		capnhatDLTable();
			dbs.Database.getIntance().connect();
			XoaHetDuLieuTableModel(table);
			capnhatDLTable();
			table.addMouseListener(this);

		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}	
	
		private void capnhatDLTable() {
			list = dsnv.docTuBang();
			for (NhanVien t : list) {
				String[] rowData= {t.getMaNhanVien(), t.getChucVu(),t.getHoTen(),t.getDiaChi(),t.getNgaySinh().toString(),t.getSdt()};
				tableModel.addRow(rowData);
			}
			table.setModel(tableModel);
		}
	

private void XoaHetDuLieuTableModel(JTable table) {
	DefaultTableModel dtm = (DefaultTableModel) table.getModel();
	//dtm.getDataVector().removeAllElements();
	dtm.setNumRows(0);
}
private void ThemNhanVien(){
	String ma = txtma.getText().trim();
	String cv = txtchucvu.getText().trim();
	String ten =txtten.getText().trim();
	String dc = txtdiachi.getText().trim();
	String ngaysinh =txtngaysinh.getText().trim();
	String sdt= txtsdt.getText().trim();

	NhanVien nv = new NhanVien(ma, cv, ten, dc,ngaysinh, sdt);
		try {
		if(dsnv.ThemNhanVien(nv)){
			tableModel.addRow(new Object[] {nv.getMaNhanVien(),nv.getChucVu(),nv.getHoTen(),nv.getDiaChi(),nv.getNgaySinh(),nv.getSdt()});
			JOptionPane.showMessageDialog(null, "Thêm Thành Công!");
		}
		else
			JOptionPane.showMessageDialog(null, "Thêm không thành công");
	} catch (Exception e1) {
		e1.printStackTrace();
		JOptionPane.showMessageDialog(this, "Trùng mã NV");
	}
	}
private void XoaNV() {

	int row= table.getSelectedRow();
	if(row>=0) {
		int re = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xoá?");
		if(re==JOptionPane.YES_OPTION)
		{
			String ma=(String) table.getValueAt(row, 0);
			if(dsnv.delete(ma)) {
				tableModel.removeRow(row);
				JOptionPane.showMessageDialog(null, "Xoá thành công!");
			}
			else 
				JOptionPane.showMessageDialog(null, "Xoá thất bại!");
		}

	}
	else JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 dòng để xoá!");
}
private void SuaNV() {
	int row = table.getSelectedRow();
	if(row>=0) {
	int re = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa?");
	if(re == JOptionPane.YES_OPTION)
	{
		boolean flag = dsnv.update(txtma.getText().trim(), txtchucvu.getText().trim(), txtten.getText().trim(),txtdiachi.getText().trim(),txtngaysinh.getText().trim(),txtsdt.getText().trim());
		if(flag==true)
		{
			JOptionPane.showMessageDialog(null, "Sửa thành công!");
			XoaHetDuLieuTableModel(table);
			list.clear();
			capnhatDLTable();
		}
		else
			JOptionPane.showMessageDialog(null, "Sửa thất bại!");
		
	}	
	}
	else 
		JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 dòng để sửa");
}
private void Tim(){
	String key = txttim.getText();
	list.clear();
	list = dsnv.Tim(key);
	if(validData())
	if(list != null)
	{

		XoaHetDuLieuTableModel(table);
		for (NhanVien l : list) {
			String[] rowData= {l.getMaNhanVien(),l.getChucVu(),l.getHoTen(),l.getDiaChi(),l.getNgaySinh(),l.getSdt()};
			tableModel.addRow(rowData);
		}

	}
	if(key.equals("")) //Khi để trống thì hiện lại danh sách ban đầu
	{
		JOptionPane.showMessageDialog(null, "Vui lòng nhập mã nhân viên cần tìm");
		XoaHetDuLieuTableModel(table);
		list.clear();
		capnhatDLTable();
	}
	table.setModel(tableModel);
}

@Override
public void mouseClicked(MouseEvent arg0) {
	// TODO Auto-generated method stub
	int row= table.getSelectedRow();
	txtma.setText(table.getValueAt(row, 0).toString());
	txtchucvu.setText(table.getValueAt(row, 1).toString());
	txtten.setText(table.getValueAt(row, 2).toString());
	txtdiachi.setText(table.getValueAt(row, 3).toString());
	txtngaysinh.setText(table.getValueAt(row, 4).toString());
	txtsdt.setText(table.getValueAt(row, 5).toString());
}

@Override
public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

private boolean validData(){
	String tim = txttim.getText().trim();
	if(!( tim.matches(REGEX_Tim)))
	{
		JOptionPane.showMessageDialog(null, "Tìm không bao gồm kí tự đặc biệt."
				+ "Tìm theo tên hoặc mã");
		return false;
	}
	return true;
}

private boolean validDataThem(){
	String ma = txtma.getText().trim();
	String chucvu = txtchucvu.getText().trim();
	String ten = txtten.getText().trim();
	String dc =txtdiachi.getText().trim();
	String ngaysinh = txtngaysinh.getText().trim();
	String sdt =txtsdt.getText().trim();
	
	if(!(ma.length()>0 && ma.matches("^NV(\\d{1,5})")))
	{
		JOptionPane.showMessageDialog(null, "Mã không để trống , Bắt đầu NV theo sau là số");
		return false;
	}
	if(!(chucvu.length()>0 )){
		JOptionPane.showMessageDialog(null, "Chức vụ không để rỗng");
		return false;
	}
	if(!(ten.length()>0 )){
		JOptionPane.showMessageDialog(null, "Tên không để rỗng");
		return false;
	}
	if(!(dc.length()>0 )){
		JOptionPane.showMessageDialog(null, "Địa chỉ không để rỗng");
		return false;
	}
	if(!(ngaysinh.length()>0)){
		JOptionPane.showMessageDialog(null, "Ngày sinh không để rỗng, theo dang dd-MM-yyyy");
		return false;
	}
	if(!(sdt.length()>0 && sdt.matches("^0\\d{9}"))){
		JOptionPane.showMessageDialog(null, "Số điện thoại không rỗng, gồm 10 số");
		return false;
	}
	
	return true;
}




}	






