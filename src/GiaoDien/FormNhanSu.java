package GiaoDien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import dbs.DanhSachNhanSu;
import dbs.Database;
import entitis.NhanSu;
import entitis.NhanVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
@SuppressWarnings("serial")
public class FormNhanSu extends JFrame{
	private static final String REGEX_MaNV = "^NV(\\d{1,3})";
	private static final String REGEX_MK ="[A-Za-z0-9_]+";
	private static final String REGEX_TK ="[A-Za-z0-9_]+";
	public JPanel contentPane;
	private JTextField textTim;
	private JTextField txtMaNV;
	private JTextField txtTenDN;
	private JTextField txtmk;
	private DanhSachNhanSu dsns= new DanhSachNhanSu();
	private java.util.List<NhanSu> list;
	private DefaultTableModel tableModel;
	private JTable table;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormNhanSu frame = new FormNhanSu();
					frame = new FormNhanSu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public FormNhanSu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1158, 729);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//
		//		JPanel panNS = new JPanel();
		//		panNS.setBounds(0, 119, 1144, 563);
		//		contentPane.add(panNS);
		//		panNS.setLayout(null);
		//		
		String tieude[]= {"Mã Nhân Viên","Tên đăng nhập", "Mật khẩu",};
		tableModel = new DefaultTableModel(tieude, 0);
		table = new JTable(tableModel);
		JScrollPane sc = new JScrollPane(table);
		sc.setBounds(416, 84, 691, 442);
		sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sc.setPreferredSize(new Dimension(900, 350));
		getContentPane().add(sc);

		JLabel lblQu = new JLabel("Quản Lí Nhân Sự");
		lblQu.setBackground(Color.WHITE);
		lblQu.setForeground(Color.GREEN);
		lblQu.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblQu.setHorizontalAlignment(SwingConstants.CENTER);
		lblQu.setBounds(15, 34, 1121, 31);
		contentPane.add(lblQu);

		JLabel lblThmTiKhon = new JLabel("Thêm tài khoản ");
		lblThmTiKhon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThmTiKhon.setHorizontalAlignment(SwingConstants.CENTER);
		lblThmTiKhon.setBounds(0, 222, 233, 40);
		contentPane.add(lblThmTiKhon);

		JLabel lblNewLabel = new JLabel("Tìm tài khoản");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(40, 124, 146, 40);
		contentPane.add(lblNewLabel);

		textTim = new JTextField();
		textTim.setBounds(40, 180, 146, 26);
		contentPane.add(textTim);
		textTim.setColumns(10);

		JButton btnTm = new JButton("Tìm");
		btnTm.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				Tim();
			}
		});
		btnTm.setBackground(Color.GRAY);
		btnTm.setForeground(Color.PINK);
		btnTm.setBounds(207, 179, 73, 29);
		contentPane.add(btnTm);

		JLabel lblMaNV = new JLabel("Mã nhân viên");
		lblMaNV.setBounds(10, 281, 127, 20);
		contentPane.add(lblMaNV);

		txtMaNV = new JTextField();
		txtMaNV.setBounds(134, 278, 199, 26);
		contentPane.add(txtMaNV);
		txtMaNV.setColumns(10);

		JLabel lblTenDN = new JLabel("Tên đăng nhập");
		lblTenDN.setBounds(15, 320, 122, 20);
		contentPane.add(lblTenDN);

		txtTenDN = new JTextField();
		txtTenDN.setBounds(134, 317, 199, 26);
		contentPane.add(txtTenDN);
		txtTenDN.setColumns(10);

		JLabel lblMtKhu = new JLabel("Mật khẩu");
		lblMtKhu.setBounds(15, 356, 69, 20);
		contentPane.add(lblMtKhu);

		txtmk = new JTextField();
		txtmk.setBounds(134, 353, 199, 26);
		contentPane.add(txtmk);
		txtmk.setColumns(10);

		JLabel lblXoTiKhon = new JLabel("Xoá tài khoản");
		lblXoTiKhon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblXoTiKhon.setHorizontalAlignment(SwingConstants.CENTER);
		lblXoTiKhon.setBounds(15, 434, 193, 31);
		contentPane.add(lblXoTiKhon);

		JButton btnThm = new JButton("Thêm");
		btnThm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ThemNhanSu();

			}
		});
		btnThm.setBackground(Color.GRAY);
		btnThm.setForeground(Color.GREEN);
		btnThm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThm.setBounds(71, 389, 115, 29);
		contentPane.add(btnThm);

		JButton btnXo = new JButton("Xoá");
		btnXo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				XoaNS();
			}
		});
		btnXo.setBackground(Color.GRAY);
		btnXo.setForeground(Color.RED);
		btnXo.setBounds(57, 469, 115, 29);
		contentPane.add(btnXo);
		dbs.Database.getIntance().connect();
		XoaHetDuLieuTableModel(table);
		capnhatDLTable();
	}
	private void capnhatDLTable() {
		list = dsns.docTuBang();
		for (NhanSu t : list) {
			String[] rowData= {t.getNhanvien().getMaNhanVien(), t.getTenDangnhap(),t.getMatKhau()};
			tableModel.addRow(rowData);
		}
		table.setModel(tableModel);
	}
	private void ThemNhanSu(){
		String maNV = txtMaNV.getText().trim();
		String tendn = txtTenDN.getText().trim();
		String mk= txtmk.getText().trim();

		NhanSu ns = new NhanSu(new NhanVien(maNV), tendn, mk);
		if(validData()){try {
			if(dsns.ThemNhanSu(ns)){
				tableModel.addRow(new Object[] {ns.getNhanvien().getMaNhanVien(), ns.getTenDangnhap(), ns.getMatKhau()});
				JOptionPane.showMessageDialog(null, "Thêm Thành Công!");
				xoarong();

			}
			else
				JOptionPane.showMessageDialog(null, "Thêm không thành công, mã nhân viên không tồn tại");
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "Trùng");
		}
		}
	}

	private void XoaNS() {

		int row= table.getSelectedRow();
		if(row>=0) {
			int re = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xoá?");
			if(re==JOptionPane.YES_OPTION)
			{
				String ten=(String) table.getValueAt(row, 1);
				if(dsns.delete(ten)) {
					tableModel.removeRow(row);
					xoarong();
					JOptionPane.showMessageDialog(null, "Xoá thành công!");
				}
				else 
					JOptionPane.showMessageDialog(null, "Xoá thất bại!");
			}

		}
		else JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 dòng để xoá!");
	}
	private void Tim(){
		String key = textTim.getText();
		list.clear();
		list = dsns.Tim(key);
		if(list != null)
		{

			XoaHetDuLieuTableModel(table);
			for (NhanSu l : list) {
				String[] rowData= {l.getNhanvien().getMaNhanVien()+"",l.getTenDangnhap(),l.getMatKhau()};
				tableModel.addRow(rowData);
			}

		}
		if(key.equals("")) //Khi để trống thì hiện lại danh sách ban đầu
		{
			JOptionPane.showMessageDialog(null, "Vui lòng nhập tên tài khoản cần tìm");
			XoaHetDuLieuTableModel(table);
			list.clear();
			capnhatDLTable();
		}
		table.setModel(tableModel);
	}
private boolean validData(){
	String maNV = txtMaNV.getText().trim();
	String tenDN = txtTenDN.getText().trim();
	String mk = txtmk.getText().trim();
	java.util.List<NhanSu> list = dsns.docTuBang();

	for (NhanSu ns : list)
	{
		if(tenDN.equalsIgnoreCase(ns.getTenDangnhap().trim()))
		{
			JOptionPane.showMessageDialog(null, "Trùng Tên Đăng Nhập !");
			return false;
		}

	}

	if(!(maNV.length()>0 && maNV.matches(REGEX_MaNV)))
	{
		JOptionPane.showMessageDialog(null, "Mã NV gồm NV1, NV2, NV3");
		return false;
	}
	if(!(mk.length()>0 && mk.matches(REGEX_MK)))
	{
		JOptionPane.showMessageDialog(null, "Mật khẩu gồm kí số và kí tự chữ , không dùng kí tự đặc biệt");
		return false;
	}
	if(!(tenDN.length()>0 && tenDN.matches(REGEX_TK))) {
		JOptionPane.showMessageDialog(null, "Tên đăng nhập là kí tự chữ viết liền không dấu");
		return false;
	}
	return true;
}

private void XoaHetDuLieuTableModel(JTable table) {
	DefaultTableModel dtm = (DefaultTableModel) table.getModel();
	//dtm.getDataVector().removeAllElements();
	dtm.setNumRows(0);
}
private void xoarong() {
	txtMaNV.setText("");
	txtTenDN.setText("");
	txtmk.setText("");
}
}
