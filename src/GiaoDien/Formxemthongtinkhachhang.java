package GiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import danhsachs.Danhsachkhachhang;
import danhsachs.Database;
import entitis.Khachhang;

import javax.swing.JTextField;
import javax.swing.JComboBox;

public class Formxemthongtinkhachhang extends JFrame implements ActionListener,MouseListener{

	private JPanel contentPane;
	private static JTable table;
	private static DefaultTableModel dftable;
	private JTextField txttimdiachi;
	private JButton btnxoakh;
	private JButton btnsuakh;
	private JButton btntimdiachi;
	private static Danhsachkhachhang dskh = new Danhsachkhachhang();
	private static List<Khachhang> list;
	private JTextField txtmakh;
	private JTextField txttenkh;
	private JTextField txtdiachi;
	private JTextField txtsdt;
	private JTextField txttimma;
	private JTextField txttimten;
	private JButton btntimma;
	private JButton btntimten;
	
	public JPanel ptimkhachhang;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formxemthongtinkhachhang frame = new Formxemthongtinkhachhang();
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
	public static void updateTableDatakhachhang()
	{
		list = dskh.docloaikhachang();
		for(Khachhang kh : list)
		{
			String[] rowData = {kh.getMaKH(),kh.getTenKH(),kh.getDiaChi(),kh.getSdt()};
			dftable.addRow(rowData);
		}
		table.setModel(dftable);
		list.clear();
	}
	public Formxemthongtinkhachhang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1158, 729);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ptimkhachhang = new JPanel();
		ptimkhachhang.setBackground(new Color(224, 255, 255));
		ptimkhachhang.setBounds(0, 144, 1144, 551);
		contentPane.add(ptimkhachhang);
		ptimkhachhang.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1134, 81);
		panel.setBackground(Color.GRAY);
		ptimkhachhang.add(panel);
		panel.setLayout(null);
		
		JLabel lblTmKhchHng = new JLabel("THÔNG TIN KHÁCH HÀNG");
		lblTmKhchHng.setForeground(Color.RED);
		lblTmKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblTmKhchHng.setBounds(516, 25, 320, 32);
		panel.add(lblTmKhchHng);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(238, 232, 170));
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBounds(10, 127, 196, 414);
		panel_1.setBorder(new TitledBorder(null, "Thao t\u00E1c", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		ptimkhachhang.add(panel_1);
		panel_1.setLayout(null);
		
		btnxoakh = new JButton("XÓA");
		btnxoakh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnxoakh.setForeground(Color.RED);
		btnxoakh.setBounds(45, 295, 97, 23);
		panel_1.add(btnxoakh);
		
		btnsuakh = new JButton("SỬA");
		btnsuakh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnsuakh.setForeground(Color.BLUE);
		btnsuakh.setBounds(45, 356, 97, 23);
		panel_1.add(btnsuakh);
		
		JLabel lblMKh = new JLabel("Mã KH:");
		lblMKh.setBounds(20, 63, 48, 14);
		panel_1.add(lblMKh);
		
		txtmakh = new JTextField();
		txtmakh.setBounds(90, 60, 96, 20);
		panel_1.add(txtmakh);
		txtmakh.setColumns(10);
		
		JLabel lblTnKh = new JLabel("Tên KH:");
		lblTnKh.setBounds(20, 101, 48, 14);
		panel_1.add(lblTnKh);
		
		txttenkh = new JTextField();
		txttenkh.setBounds(90, 98, 96, 20);
		panel_1.add(txttenkh);
		txttenkh.setColumns(10);
		
		JLabel lblaCh = new JLabel("Địa chỉ:");
		lblaCh.setBounds(20, 143, 48, 14);
		panel_1.add(lblaCh);
		
		txtdiachi = new JTextField();
		txtdiachi.setBounds(90, 140, 96, 20);
		panel_1.add(txtdiachi);
		txtdiachi.setColumns(10);
		
		JLabel lblSdt = new JLabel("SDT:");
		lblSdt.setBounds(20, 179, 48, 14);
		panel_1.add(lblSdt);
		
		txtsdt = new JTextField();
		txtsdt.setBounds(90, 176, 96, 20);
		panel_1.add(txtsdt);
		txtsdt.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(238, 232, 170));
		panel_2.setBounds(216, 127, 918, 411);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		ptimkhachhang.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 25, 873, 375);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setModel(dftable=new DefaultTableModel(new String[] {
				"M\u00E3 KH", "T\u00EAn KH", "\u0110\u1ECBa ch\u1EC9", "S\u0110T"
			}, 0));
		scrollPane.setViewportView(table);
		
		JLabel lblTmKhchHng_1 = new JLabel("Tìm địa chỉ:");
		lblTmKhchHng_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTmKhchHng_1.setBounds(840, 102, 75, 14);
		ptimkhachhang.add(lblTmKhchHng_1);
		
		txttimdiachi = new JTextField();
		txttimdiachi.setBounds(925, 101, 101, 20);
		ptimkhachhang.add(txttimdiachi);
		txttimdiachi.setColumns(10);
		
		btntimdiachi = new JButton("Tìm");
		btntimdiachi.setForeground(Color.MAGENTA);
		btntimdiachi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btntimdiachi.setBounds(1046, 102, 59, 23);
		ptimkhachhang.add(btntimdiachi);
		
		JLabel lblTmM = new JLabel("Tìm mã:");
		lblTmM.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTmM.setBounds(216, 102, 59, 14);
		ptimkhachhang.add(lblTmM);
		
		txttimma = new JTextField();
		txttimma.setBounds(282, 100, 96, 20);
		ptimkhachhang.add(txttimma);
		txttimma.setColumns(10);
		
		btntimma = new JButton("Tìm");
		btntimma.setForeground(Color.MAGENTA);
		btntimma.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btntimma.setBounds(388, 99, 59, 23);
		ptimkhachhang.add(btntimma);
		
		JLabel lblTmTn = new JLabel("Tìm tên :");
		lblTmTn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTmTn.setBounds(519, 102, 64, 14);
		ptimkhachhang.add(lblTmTn);
		
		txttimten = new JTextField();
		txttimten.setBounds(593, 101, 96, 20);
		ptimkhachhang.add(txttimten);
		txttimten.setColumns(10);
		
		btntimten = new JButton("Tìm");
		btntimten.setForeground(Color.MAGENTA);
		btntimten.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btntimten.setBounds(699, 99, 59, 23);
		ptimkhachhang.add(btntimten);
		Database.getinstance().connect();
		updateTableDatakhachhang();
		btnsuakh.addActionListener(this);
		btnxoakh.addActionListener(this);
		btntimdiachi.addActionListener(this);
		table.addMouseListener(this);
		btntimma.addActionListener(this);
		btntimten.addActionListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row= table.getSelectedRow();
		txtmakh.setText(table.getValueAt(row, 0).toString());
		txttenkh.setText(table.getValueAt(row, 1).toString());
		txtdiachi.setText(table.getValueAt(row, 2).toString());
		txtsdt.setText(table.getValueAt(row, 3).toString());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnxoakh))
		{
			XoaKhachang();
		}
		else if(o.equals(btnsuakh))
		{
			Suakhachhang();
		}
		else if(o.equals(btntimma))
		{
			Timkhtheoma();
		}
		else if(o.equals(btntimten))
		{
			Timkhtheoten();
		}
		else if(o.equals(btntimdiachi))
		{
			Timkhtheodiachi();
		}
	}
	private void XoaKhachang() {
		int row = table.getSelectedRow();
		if(row>=0) {
			int re = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xoá?");
			if(re==JOptionPane.YES_OPTION)
			{
				String makh=(String) table.getValueAt(row, 0);
				if(dskh.delete(makh)) {
					dftable.removeRow(row);
					xoarong();
					JOptionPane.showMessageDialog(null, "Xoá thành công!");
				}
				else 
					JOptionPane.showMessageDialog(null, "Xóa thất bại khách hàng đang thuê phòng!");
			}
			
		}
		else 
			JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 dòng để xoá!");
	}
	public void xoarong()
	{
		txtmakh.setText("");
		txttenkh.setText("");
		txtdiachi.setText("");
		txtsdt.setText("");
		txtmakh.requestFocus();
	}
	private void Suakhachhang() {
		int row = table.getSelectedRow();
		if(row>=0) {
		int re = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa?");
		if(re == JOptionPane.YES_OPTION)
		{
			boolean flag = dskh.updatekhachhang(txtmakh.getText().trim(), txttenkh.getText().trim(), txtdiachi.getText().trim(),txtsdt.getText().trim());
			if(flag==true)
			{
				JOptionPane.showMessageDialog(null, "Sửa thành công!");
				XoaHetDuLieuTableModel(table);
				list.clear();
				updateTableDatakhachhang();
				xoarong();
			}
			else
				JOptionPane.showMessageDialog(null, "Sửa thất bại!");
			
		}	
		}
		else 
			JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 dòng để sửa");
	}
	private static void XoaHetDuLieuTableModel(JTable table) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		//dtm.getDataVector().removeAllElements();
		dtm.setNumRows(0);
	}
	private void Timkhtheoma(){
		String key = txttimma.getText();
		list.clear();
		list = dskh.Timkhma(key);
		if(list != null)
		{
			
			XoaHetDuLieuTableModel(table);
			for (Khachhang kh : list) {
				String[] rowData= {kh.getMaKH(),kh.getTenKH(),kh.getDiaChi(),kh.getSdt()};
				dftable.addRow(rowData);
			}
			
		}
		if(key.equals("")) //Khi để trống thì hiện lại danh sách ban đầu
		{
			JOptionPane.showMessageDialog(null, "Vui long nhap thong tin tim");
			XoaHetDuLieuTableModel(table);
			list.clear();
			updateTableDatakhachhang();
		}
		table.setModel(dftable);
	}
	private void Timkhtheoten(){
		String key = txttimten.getText();
		list.clear();
		list = dskh.Timkhten(key);
		if(list != null)
		{
			
			XoaHetDuLieuTableModel(table);
			for (Khachhang kh : list) {
				String[] rowData= {kh.getMaKH(),kh.getTenKH(),kh.getDiaChi(),kh.getSdt()};
				dftable.addRow(rowData);
			}
			
		}
		if(key.equals("")) //Khi để trống thì hiện lại danh sách ban đầu
		{
			JOptionPane.showMessageDialog(null, "Vui long nhap thong tin tim");
			XoaHetDuLieuTableModel(table);
			list.clear();
			updateTableDatakhachhang();
		}
		table.setModel(dftable);
	}
	private void Timkhtheodiachi(){
		String key = txttimdiachi.getText();
		list.clear();
		list = dskh.Timkhiachi(key);
		if(list != null)
		{
			
			XoaHetDuLieuTableModel(table);
			for (Khachhang kh : list) {
				String[] rowData= {kh.getMaKH(),kh.getTenKH(),kh.getDiaChi(),kh.getSdt()};
				dftable.addRow(rowData);
			}
			
		}
		if(key.equals("")) //Khi để trống thì hiện lại danh sách ban đầu
		{
			JOptionPane.showMessageDialog(null, "Vui long nhap thong tin tim");
			XoaHetDuLieuTableModel(table);
			list.clear();
			updateTableDatakhachhang();
		}
		table.setModel(dftable);
	}
}
