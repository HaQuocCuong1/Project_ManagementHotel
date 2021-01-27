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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import danhsachs.Danhsachloaiphong;
import danhsachs.Database;
import entitis.Loaiphong;



public class Formloaiphong extends JFrame implements ActionListener,MouseListener{

	private JPanel contentPane;
	private JTextField txtmaloai;
	private JTextField txtloaiphong;
	private JTextField txtghichu;
	private static JTable table;
	private static DefaultTableModel modelloaiphong;
	private JButton btnthemloai;
	private JButton btnthoat;
	private JButton btnsua;
	private JButton btnxoaloaiphong;
	private static Danhsachloaiphong dslp = new Danhsachloaiphong();
	private static List<Loaiphong> list;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formloaiphong frame = new Formloaiphong();
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
	public static void updateTableDataloaiphong()
	{
		list = dslp.docloaiphong();
		for(Loaiphong lp : list)
		{
			String[] rowData = {lp.getMaLoaiphong(),lp.getTenLoai(),lp.getGhiChu()};
			modelloaiphong.addRow(rowData);
		}
		table.setModel(modelloaiphong);
		list.clear();
	}
	public Formloaiphong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 495);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblThngTinLoi = new JLabel("THÔNG TIN LOẠI PHÒNG");
		lblThngTinLoi.setForeground(new Color(255, 0, 0));
		lblThngTinLoi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblThngTinLoi.setBounds(206, 32, 226, 32);
		contentPane.add(lblThngTinLoi);
		
		JLabel lblM = new JLabel("Mã loại :");
		lblM.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblM.setBounds(37, 99, 62, 14);
		contentPane.add(lblM);
		
		txtmaloai = new JTextField();
		txtmaloai.setBounds(109, 97, 112, 20);
		contentPane.add(txtmaloai);
		txtmaloai.setColumns(10);
		
		JLabel lblLoiPhng = new JLabel("Loại phòng:");
		lblLoiPhng.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLoiPhng.setBounds(37, 138, 78, 14);
		contentPane.add(lblLoiPhng);
		
		txtloaiphong = new JTextField();
		txtloaiphong.setBounds(109, 136, 112, 20);
		contentPane.add(txtloaiphong);
		txtloaiphong.setColumns(10);
		
		JLabel lblGhiCh = new JLabel("Ghi chú :");
		lblGhiCh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGhiCh.setBounds(352, 100, 62, 14);
		contentPane.add(lblGhiCh);
		
		txtghichu = new JTextField();
		txtghichu.setBounds(424, 97, 112, 20);
		contentPane.add(txtghichu);
		txtghichu.setColumns(10);
		
		btnthemloai = new JButton("Thêm");
		btnthemloai.setForeground(Color.GREEN);
		btnthemloai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnthemloai.setBounds(48, 197, 89, 32);
		contentPane.add(btnthemloai);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 264, 581, 181);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(modelloaiphong=new DefaultTableModel(new String[] {
				"M\u00E3 lo\u1EA1i", "Lo\u1EA1i ph\u00F2ng", "Ghi ch\u00FA"
			}, 0));
		scrollPane.setViewportView(table);
		
		btnthoat = new JButton("Thoát");
		btnthoat.setForeground(Color.RED);
		btnthoat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnthoat.setBounds(465, 197, 89, 32);
		contentPane.add(btnthoat);
		
		btnsua = new JButton("Sửa");
		btnsua.setForeground(Color.BLUE);
		btnsua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnsua.setBounds(207, 199, 89, 29);
		contentPane.add(btnsua);
		
		btnxoaloaiphong = new JButton("Xóa");
		btnxoaloaiphong.setForeground(Color.RED);
		btnxoaloaiphong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnxoaloaiphong.setBounds(338, 197, 89, 32);
		contentPane.add(btnxoaloaiphong);
		btnthemloai.addActionListener(this);
		btnthoat.addActionListener(this);
		btnsua.addActionListener(this);
		table.addMouseListener(this);
		btnxoaloaiphong.addActionListener(this);
		Database.getinstance().connect();
		updateTableDataloaiphong();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row= table.getSelectedRow();
		txtmaloai.setText(table.getValueAt(row, 0).toString());
		txtloaiphong.setText(table.getValueAt(row, 1).toString());
		txtghichu.setText(table.getValueAt(row, 2).toString());
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
		Object s = e.getSource();
		if(s.equals(btnthemloai))
		{
			ThemLop();
		}
		else if(s.equals(btnthoat))
		{
			this.dispose();
		}
		else if(s.equals(btnsua))
		{
			Sualoaiphong();
		}
		else if(s.equals(btnxoaloaiphong))
		{
			XoaLoaiphong();
		}
	}
	private void ThemLop(){
		if(validData())
		{
			String maloaiphong = txtmaloai.getText().trim();
			String tenloai = txtloaiphong.getText().trim();
			String ghichu = txtghichu.getText().trim();
			
			Loaiphong lp = new Loaiphong(maloaiphong, tenloai, ghichu);
			try {
				if(dslp.ThemLop(lp)){
					modelloaiphong.addRow(new Object[] {lp.getMaLoaiphong(), lp.getTenLoai(), lp.getGhiChu()});
					JOptionPane.showMessageDialog(null, "Thêm loại phòng thành Công!");
					XoaHetDuLieuTableModel(table);
					updateTableDataloaiphong();
					xoarong();
				}
				else
					JOptionPane.showMessageDialog(null, "Thêm không thành công");
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "Trùng");
			}
		}
	}
	
	private boolean validData(){
		String maloai = txtmaloai.getText().trim();
		String tenloai = txtloaiphong.getText().trim();
		String ghichu = txtghichu.getText().trim();
		list = dslp.docloaiphong();
		for(Loaiphong lp : list)
		{
			if(maloai.equalsIgnoreCase(lp.getMaLoaiphong().trim()))
			{
				JOptionPane.showMessageDialog(null, "Trùng mã loại phòng!");
				return false;
			}
				
		}
		list.clear();
		if(!(maloai.length()>0 && maloai.matches("^LP(\\d)+")))
		{
			JOptionPane.showMessageDialog(null, "Mã phòng phải bắt đầu bằng LP, theo sau là kí tự số không để trống");
			return false;
		}
		if(!(tenloai.length()>0 && tenloai.matches("[a-zA-Z0-9]+(\\s[a-zA-Z0-9]+)*")))
		{
			JOptionPane.showMessageDialog(null, "Tên loại phòng gồm nhiều từ có thể là chữ cái,cách nhau bằng dấu cách không để trống");
			return false;
		}
		if(!(ghichu.length()>0 && ghichu.matches("[a-zA-Z0-9]+(\\s[a-zA-Z0-9]+)*")))
		{
			JOptionPane.showMessageDialog(null, "Tên ghi chú gồm nhiều từ có thể là chữ cái,cách nhau bằng dấu cách không để trống");
			return false;
		}
		return true;
	}
	public void xoarong()
	{
		txtmaloai.setText("");
		txtloaiphong.setText("");
		txtghichu.setText("");
		txtmaloai.requestFocus();
	}
	private void Sualoaiphong() {
		int row = table.getSelectedRow();
		if(row>=0) {
		int re = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa?");
		if(re == JOptionPane.YES_OPTION)
		{
			boolean flag = dslp.updateloaiphong(txtmaloai.getText().trim(), txtloaiphong.getText().trim(), txtghichu.getText().trim());
			if(flag==true)
			{
				JOptionPane.showMessageDialog(null, "Sửa thành công!");
				XoaHetDuLieuTableModel(table);
				list.clear();
				updateTableDataloaiphong();
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
	private void XoaLoaiphong() {
		int row = table.getSelectedRow();
		if(row>=0) {
			int re = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xoá?");
			if(re==JOptionPane.YES_OPTION)
			{
				String maLoai=(String) table.getValueAt(row, 0);
				if(delete(maLoai)) {
					modelloaiphong.removeRow(row);
					xoarong();
					JOptionPane.showMessageDialog(null, "Xoá thành công!");
				}
			}
			
		}
		else 
			JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 dòng để xoá!");
	}
	public boolean delete(String mphong) {
		Connection con = Database.getinstance().getconnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("delete from LoaiPhong where maLoai=?");
			stmt.setString(1, mphong);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Không thể xóa loại phòng đang thuê!");
		}
		return n>0;
	}
}
