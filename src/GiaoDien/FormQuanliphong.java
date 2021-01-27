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
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import danhsachs.Danhsachloaiphong;
import danhsachs.Danhsachphong;
import danhsachs.Danhsachthongtinphong;
import danhsachs.Database;
import entitis.Loaiphong;
import entitis.Phong;
import entitis.Thongtinphong;

import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

public class FormQuanliphong extends JFrame implements ActionListener,MouseListener{

	private JPanel contentPane;
	private JTextField txtmaphong;
	private JTextField txttenphong;
	private JTextField txtdongia;
	private JTextField txtdientich;
	private static JTable table;
	private static DefaultTableModel modelphong;
	private JTextField txttim;
	public static JComboBox comboloaiphong;
	private JButton btnthemp;
	private JButton btnsuaphong;
	private JButton btnxoaphong;
	private JButton btnthemlp;
	private JButton btntim;
	private JButton btnrefrsh;
	private static Danhsachthongtinphong dsp = new Danhsachthongtinphong();
	private static Danhsachphong dsp1 = new Danhsachphong();
	private static Danhsachloaiphong dslp = new Danhsachloaiphong();
	private static List<Thongtinphong> list;
	private static List<Phong> listphong;
	private static List<Loaiphong> listlp;
	private JButton btnxoatrang;
	private JTextField txtMLP;
	private JTextField txtTP;
	private JTextField txtLP;
	private JButton btnMLP;
	private JButton btnTP;
	private JButton btnLP;
	private JButton btnthongke;
	private JButton btntrong;
	private JButton btnsudung;
	private JButton btntatcaphong;
	private JTextField txtmaloaiphong;
	//protected Component pQuanliphong;
	public JPanel pQuanliphong;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormQuanliphong frame = new FormQuanliphong();
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
	public static void updateTableData()
	{
		list = dsp.docbangphong();
		for(Thongtinphong tt : list)
		{
			String[] rowData = {tt.getMaPhong(),tt.getMaLoaiphong(),tt.getTenPhong(),tt.getLoaiPhong(),String.valueOf(tt.getDienTich()),String.valueOf(tt.getDonGia()),tt.getGhichu()};
			modelphong.addRow(rowData);
		}
		list.clear();
		table.setModel(modelphong);
	}
	public FormQuanliphong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1158, 729);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pQuanliphong = new JPanel();
		pQuanliphong.setBackground(new Color(255, 255, 255));
		pQuanliphong.setForeground(Color.RED);
		pQuanliphong.setBounds(0, 144, 1144, 551);
		contentPane.add(pQuanliphong);
		pQuanliphong.setLayout(null);
		
		JPanel pTieude = new JPanel();
		pTieude.setBackground(new Color(100, 149, 237));
		pTieude.setForeground(Color.RED);
		pTieude.setBounds(0, 0, 1144, 58);
		pQuanliphong.add(pTieude);
		pTieude.setLayout(null);
		
		JLabel lblquanliphong = new JLabel("QUẢN LÝ PHÒNG");
		lblquanliphong.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblquanliphong.setForeground(Color.RED);
		lblquanliphong.setBounds(484, 11, 198, 36);
		pTieude.add(lblquanliphong);
		
		JPanel pchucnang = new JPanel();
		pchucnang.setBackground(new Color(240, 230, 140));
		pchucnang.setBorder(new TitledBorder(null, "Thao T\u00E1c", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pchucnang.setBounds(12, 198, 1109, 154);
		pQuanliphong.add(pchucnang);
		pchucnang.setLayout(null);
		
		btnthemp = new JButton("Thêm phòng");
		btnthemp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnthemp.setForeground(new Color(0, 255, 0));
		btnthemp.setBounds(21, 65, 121, 33);
		pchucnang.add(btnthemp);
		
		btnsuaphong = new JButton("Sửa phòng");
		btnsuaphong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnsuaphong.setForeground(new Color(0, 0, 255));
		btnsuaphong.setBounds(154, 21, 105, 33);
		pchucnang.add(btnsuaphong);
		
		btnxoaphong = new JButton("Xóa phòng");
		btnxoaphong.setForeground(new Color(255, 0, 0));
		btnxoaphong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnxoaphong.setBounds(152, 65, 107, 33);
		pchucnang.add(btnxoaphong);
		
		btnthemlp = new JButton("QL loại phòng");
		btnthemlp.setForeground(Color.BLUE);
		btnthemlp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnthemlp.setBounds(21, 21, 121, 33);
		pchucnang.add(btnthemlp);
		
		JLabel lblTmPhng = new JLabel("Tìm theo MP:");
		lblTmPhng.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTmPhng.setBounds(497, 25, 91, 24);
		pchucnang.add(lblTmPhng);
		
		txttim = new JTextField();
		txttim.setBounds(612, 28, 96, 20);
		pchucnang.add(txttim);
		txttim.setColumns(10);
		
		btntim = new JButton("Tìm");
		btntim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btntim.setBounds(718, 26, 68, 23);
		pchucnang.add(btntim);
		
		btnrefrsh = new JButton("Refresh");
		btnrefrsh.setForeground(Color.MAGENTA);
		btnrefrsh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnrefrsh.setBounds(271, 21, 96, 33);
		pchucnang.add(btnrefrsh);
		
		btnxoatrang = new JButton("Xóa trắng");
		btnxoatrang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnxoatrang.setForeground(Color.CYAN);
		btnxoatrang.setBounds(269, 65, 98, 33);
		pchucnang.add(btnxoatrang);
		
		JLabel lblTmTheoMlp = new JLabel("Tìm theo MLP :");
		lblTmTheoMlp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTmTheoMlp.setBounds(497, 74, 91, 14);
		pchucnang.add(lblTmTheoMlp);
		
		txtMLP = new JTextField();
		txtMLP.setBounds(612, 65, 96, 20);
		pchucnang.add(txtMLP);
		txtMLP.setColumns(10);
		
		btnMLP = new JButton("Tìm");
		btnMLP.setBounds(718, 64, 68, 23);
		pchucnang.add(btnMLP);
		
		JLabel lblTmTheoTp = new JLabel("Tìm theo TP và DT:");
		lblTmTheoTp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTmTheoTp.setBounds(796, 30, 124, 14);
		pchucnang.add(lblTmTheoTp);
		
		txtTP = new JTextField();
		txtTP.setBounds(918, 28, 104, 20);
		pchucnang.add(txtTP);
		txtTP.setColumns(10);
		
		btnTP = new JButton("Tìm");
		btnTP.setBounds(1032, 27, 68, 23);
		pchucnang.add(btnTP);
		
		JLabel lblTmTheoLp = new JLabel("Tìm theo LP và DG:");
		lblTmTheoLp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTmTheoLp.setBounds(796, 65, 112, 14);
		pchucnang.add(lblTmTheoLp);
		
		txtLP = new JTextField();
		txtLP.setBounds(919, 65, 103, 20);
		pchucnang.add(txtLP);
		txtLP.setColumns(10);
		
		btnLP = new JButton("Tìm");
		btnLP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLP.setBounds(1032, 63, 68, 23);
		pchucnang.add(btnLP);
		
		btnthongke = new JButton("Thống kê phòng");
		btnthongke.setBackground(Color.BLUE);
		btnthongke.setForeground(Color.WHITE);
		btnthongke.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnthongke.setBounds(21, 109, 124, 34);
		pchucnang.add(btnthongke);
		
		btntrong = new JButton("Trống");
		btntrong.setForeground(Color.BLUE);
		btntrong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btntrong.setBounds(271, 109, 96, 34);
		pchucnang.add(btntrong);
		
		btnsudung = new JButton("Sử dụng");
		btnsudung.setForeground(Color.GREEN);
		btnsudung.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnsudung.setBounds(379, 109, 96, 34);
		pchucnang.add(btnsudung);
		
		btntatcaphong = new JButton("Tất cả phòng");
		btntatcaphong.setForeground(new Color(0, 128, 0));
		btntatcaphong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btntatcaphong.setBounds(154, 109, 107, 34);
		pchucnang.add(btntatcaphong);
		
		JPanel pdanhsach = new JPanel();
		pdanhsach.setBounds(12, 363, 1109, 176);
		pQuanliphong.add(pdanhsach);
		pdanhsach.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 11, 1089, 167);
		pdanhsach.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setModel(modelphong=new DefaultTableModel(new String[] {
				"M\u00E3 ph\u00F2ng", "M\u00E3 lo\u1EA1i ph\u00F2ng", "T\u00EAn ph\u00F2ng", "Lo\u1EA1i ph\u00F2ng", "Di\u1EC7n t\u00EDch", "\u0110\u01A1n gi\u00E1", "Ghi ch\u00FA"
			}, 0));
		
		
		table.getColumnModel().getColumn(1).setPreferredWidth(92);
		scrollPane.setViewportView(table);
		
		JPanel pthongtin = new JPanel();
		pthongtin.setBackground(new Color(240, 230, 140));
		pthongtin.setBorder(new TitledBorder(null, "Th\u00F4ng tin ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pthongtin.setBounds(10, 69, 1111, 118);
		pQuanliphong.add(pthongtin);
		pthongtin.setLayout(null);
		
		JLabel lblmaphong = new JLabel("Mã phòng:");
		lblmaphong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblmaphong.setBounds(32, 32, 80, 21);
		pthongtin.add(lblmaphong);
		
		txtmaphong = new JTextField();
		txtmaphong.setBounds(122, 33, 119, 20);
		pthongtin.add(txtmaphong);
		txtmaphong.setColumns(10);
		
		JLabel lbltenphong = new JLabel("Tên phòng:");
		lbltenphong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbltenphong.setBounds(32, 70, 80, 21);
		pthongtin.add(lbltenphong);
		
		txttenphong = new JTextField();
		txttenphong.setBounds(122, 71, 119, 20);
		pthongtin.add(txttenphong);
		txttenphong.setColumns(10);
		
		JLabel lbldongia = new JLabel("Giá thuê:");
		lbldongia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbldongia.setBounds(680, 35, 66, 14);
		pthongtin.add(lbldongia);
		
		txtdongia = new JTextField();
		txtdongia.setBounds(762, 33, 119, 20);
		pthongtin.add(txtdongia);
		txtdongia.setColumns(10);
		
		JLabel lbldientich = new JLabel("Diện tích:");
		lbldientich.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbldientich.setBounds(367, 74, 66, 18);
		pthongtin.add(lbldientich);
		
		txtdientich = new JTextField();
		txtdientich.setBounds(456, 74, 137, 20);
		pthongtin.add(txtdientich);
		txtdientich.setColumns(10);
		
		JLabel lblmaloai = new JLabel("Loại phòng:");
		lblmaloai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblmaloai.setBounds(367, 36, 80, 27);
		pthongtin.add(lblmaloai);
		
		comboloaiphong = new JComboBox();
		comboloaiphong.setBounds(456, 32, 112, 22);
		pthongtin.add(comboloaiphong);
		
		txtmaloaiphong = new JTextField();
		txtmaloaiphong.setEditable(false);
		txtmaloaiphong.setBounds(578, 33, 80, 20);
		pthongtin.add(txtmaloaiphong);
		txtmaloaiphong.setColumns(10);
		Database.getinstance().connect();
		updateTableData();
		capnhatComboBox();
		btnsuaphong.addActionListener(this);
		btnthemlp.addActionListener(this);
		btnthemp.addActionListener(this);
		btntim.addActionListener(this);
		btnxoaphong.addActionListener(this);
		table.addMouseListener(this);
		btnrefrsh.addActionListener(this);
		btnxoatrang.addActionListener(this);
		btnLP.addActionListener(this);
		btnMLP.addActionListener(this);
		btnTP.addActionListener(this);
		btnthongke.addActionListener(this);
		btntrong.addActionListener(this);
		btnsudung.addActionListener(this);
		btntatcaphong.addActionListener(this);
		comboloaiphong.addActionListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row= table.getSelectedRow();
		txtmaphong.setText(table.getValueAt(row, 0).toString());
		txttenphong.setText(table.getValueAt(row, 2).toString());
		comboloaiphong.setSelectedItem(table.getValueAt(row, 3).toString());
		txtdientich.setText(table.getValueAt(row, 4).toString());
		txtdongia.setText(table.getValueAt(row, 5).toString());
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
		if(s.equals(btnthemlp))
		{
			Formloaiphong lp = new Formloaiphong();
			lp.setVisible(true);
		}
		else if(s.equals(btnthemp))
		{
			Themphong();
		}
		else if(s.equals(btnxoaphong))
		{
			Xoaphong();
		}
		else if(s.equals(btnsuaphong))
		{
			Suaphong();
		}
		else if(s.equals(btnrefrsh))
		{
			XoaHetDuLieuTableModel(table);
			updateTableData();
			//list.clear();
			capnhatComboBox();
		}
		else if(s.equals(btnxoatrang))
		{
			xoarong();
		}
		else if(s.equals(btntim))
		{
			Timphong();
		}
		else if(s.equals(btnMLP))
		{
			TimphongMLP();
		}
		else if(s.equals(btnTP))
		{
			TimphongTP();
		}
		else if(s.equals(btnLP))
		{
			TimphongLP();
		}
		else if(s.equals(btnthongke))
		{
			FormthongkePhongtrong tkp = new FormthongkePhongtrong();
			tkp.setVisible(true);
		}
		else if(s.equals(btntrong))
		{
			Locphongtrong();
		}
		else if(s.equals(btnsudung))
		{
			LocphongSudung();
		}
		else if(s.equals(btntatcaphong))
		{
			Tatcaphong();
		}
		else if(s.equals(comboloaiphong))
		{
			timmaphong();
		}
	}
	private void Themphong(){
		if(validData())
		{
			String maphong = txtmaphong.getText().trim();
			String maloai = txtmaloaiphong.getText().trim();
			String tenPhong = txttenphong.getText().trim();
			String dt =  txtdientich.getText().trim();
			float dienTich = dt.equals("") ? 0 : Float.parseFloat(dt);
			String gt = txtdongia.getText().trim();
			float giathue = gt.equals("") ? 0 : Float.parseFloat(gt);
			
			Phong p = new Phong(maphong, new Loaiphong(maloai), tenPhong, dienTich, giathue);
			try {
				if(dsp1.Themphong(p)){
					modelphong.addRow(new Object[] {p.getMaPhong(),p.getMaLoaiphong().getTenLoai(), p.getTenPhong(), String.valueOf(p.getDienTich()),String.valueOf(p.getDongia())});
					
					JOptionPane.showMessageDialog(null, "Thêm phòng thành Công!");
					xoarong();
					list.clear();
					capnhatComboBox();
//					updateTableData();
				//	txtMaLop.setEditable(false);
				}
				else
					JOptionPane.showMessageDialog(null, "Thêm phòng không thành công");
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "Trùng");
			}
		}
	}
	private boolean validData(){
		String maphong = txtmaphong.getText().trim();
		String maloai = (String) comboloaiphong.getSelectedItem();
		String tenphong = txttenphong.getText().trim();
		String dt =  txtdientich.getText().trim();
		float dienTich = dt.equals("") ? 0 : Float.parseFloat(dt);
		String gt = txtdongia.getText().trim();
		float giathue = gt.equals("") ? 0 : Float.parseFloat(gt);
		//List<Phong> listp;
		list = dsp.docbangphong();
		for (Thongtinphong p : list)
		{
			if(maphong.equalsIgnoreCase(p.getMaPhong().trim()))
			{
				JOptionPane.showMessageDialog(null, "Trùng mã phòng!");
				return false;
			}
				
		}//P204
		list.clear();
		
		if(!(maphong.length()>0 && maphong.matches("^P(\\d)+")))
		{
			JOptionPane.showMessageDialog(null, "Mã phòng phải bắt đầu bằng P, theo sau là kí tự số không để trống");
			return false;
		}
		if(!(tenphong.length()>0 && tenphong.matches("[a-zA-Z0-9]*(\\s[a-zA-Z0-9]+)*")))
		{
			JOptionPane.showMessageDialog(null, "Tên phòng gồm nhiều từ có thể là chữ cái,cách nhau bằng dấu cách không để trống");
			return false;
		}
		if(!((dienTich>1) && ((String.valueOf(dienTich).length())>1)))
		{
			JOptionPane.showMessageDialog(this, "Diện tích phải là số dương không để trống không để trống");
			return false;
		}
		if(!((giathue>1) && ((String.valueOf(giathue).length())>1)))
		{
			JOptionPane.showMessageDialog(this, "Giá thuê tích phải là số dương không để trống không để trống");
			return false;
		}
		return true;
	}
	private static void XoaHetDuLieuTableModel(JTable table) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		//dtm.getDataVector().removeAllElements();
		dtm.setNumRows(0);
	}
	public void xoarong()
	{
		txtmaphong.setText("");
		txtmaloaiphong.setText("");
		comboloaiphong.setSelectedItem("");
		txttenphong.setText("");
		txtdientich.setText("");
		txtdongia.setText("");
		txtmaphong.requestFocus();
	}
	public static void capnhatComboBox() {
		List<Loaiphong> listlp = null;
		listlp = dslp.docloaiphong();
		for (Loaiphong lp : listlp) {
			comboloaiphong.addItem(lp.getTenLoai());
		}
		listlp.clear();
	}
	private void Suaphong() {
		int row = table.getSelectedRow();
		if(row>=0) {
		int re = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa?");
		if(re == JOptionPane.YES_OPTION)
		{
			//boolean flag = dsp1.updatephong(txtmaphong.getText().trim(), txttenphong.getText().trim(), txtdientich.getText().trim(),txtdongia.getText().trim());
			boolean flag = dsp1.updatephong(txtmaphong.getText().trim(),txttenphong.getText().trim(), Float.parseFloat(txtdientich.getText().trim()), String.valueOf(txtmaloaiphong.getText()),Float.parseFloat(txtdongia.getText().trim()));
			if(flag==true)
			{
				JOptionPane.showMessageDialog(null, "Sửa thành công!");
				XoaHetDuLieuTableModel(table);
				list.clear();
				updateTableData();
				xoarong();
			}
			else
				JOptionPane.showMessageDialog(null, "Sửa thất bại!");
			
		}	
		}
		else 
			JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 dòng để sửa");
	}
	private void Xoaphong() {
		int row = table.getSelectedRow();
		if(row>=0) {
			int re = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xoá?");
			if(re==JOptionPane.YES_OPTION)
			{
				String maphong=(String) table.getValueAt(row, 0);
				if(delete(maphong)) {
					modelphong.removeRow(row);
					xoarong();
					JOptionPane.showMessageDialog(null, "Xoá thành công!");
				}
			}
			
		}
		else 
			JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 dòng để xoá!");
	}
	private void TimphongMLP(){
		String key = txtMLP.getText().trim();
		list.clear();
		list = dsp.TimphongMLP(key);
		if(list != null)
		{
			
			XoaHetDuLieuTableModel(table);
			//JOptionPane.showMessageDialog(this, "cho de");
			for(Thongtinphong tt1 : list)
			{
				String[] rowData = {tt1.getMaPhong(),tt1.getMaLoaiphong(),tt1.getTenPhong(),tt1.getLoaiPhong(),String.valueOf(tt1.getDienTich()),String.valueOf(tt1.getDonGia()),tt1.getGhichu()};
				modelphong.addRow(rowData);
			}
			
		}
		if(key.equals("")) //Khi để trống thì hiện lại danh sách ban đầu
		{
			JOptionPane.showMessageDialog(null, "Vui long nhap thong tin tim");
			XoaHetDuLieuTableModel(table);
			list.clear();
			updateTableData();;
		}
		table.setModel(modelphong);
	}
	private void TimphongTP(){
		String key = txtTP.getText().trim();
		list.clear();
		list = dsp.Timphongtenphong(key);
		if(list != null)
		{
			
			XoaHetDuLieuTableModel(table);
			//JOptionPane.showMessageDialog(this, "cho de");
			for(Thongtinphong tt1 : list)
			{
				String[] rowData = {tt1.getMaPhong(),tt1.getMaLoaiphong(),tt1.getTenPhong(),tt1.getLoaiPhong(),String.valueOf(tt1.getDienTich()),String.valueOf(tt1.getDonGia()),tt1.getGhichu()};
				modelphong.addRow(rowData);
			}
			
		}
		if(key.equals("")) //Khi để trống thì hiện lại danh sách ban đầu
		{
			JOptionPane.showMessageDialog(null, "Vui long nhap thong tin tim");
			XoaHetDuLieuTableModel(table);
			list.clear();
			updateTableData();;
		}
		table.setModel(modelphong);
	}
	private void TimphongLP(){
		String key = txtLP.getText().trim();
		list.clear();
		list = dsp.Timphongloaiphong(key);
		if(list != null)
		{
			
			XoaHetDuLieuTableModel(table);
			//JOptionPane.showMessageDialog(this, "cho de");
			for(Thongtinphong tt1 : list)
			{
				String[] rowData = {tt1.getMaPhong(),tt1.getMaLoaiphong(),tt1.getTenPhong(),tt1.getLoaiPhong(),String.valueOf(tt1.getDienTich()),String.valueOf(tt1.getDonGia()),tt1.getGhichu()};
				modelphong.addRow(rowData);
			}
			
		}
		if(key.equals("")) //Khi để trống thì hiện lại danh sách ban đầu
		{
			JOptionPane.showMessageDialog(null, "Vui long nhap thong tin tim");
			XoaHetDuLieuTableModel(table);
			list.clear();
			updateTableData();;
		}
		table.setModel(modelphong);
	}
	private void Timphong(){
		String key = txttim.getText().trim();
		list.clear();
		list = dsp.Timphong(key);
		if(list != null)
		{
			
			XoaHetDuLieuTableModel(table);
			//JOptionPane.showMessageDialog(this, "cho de");
			for(Thongtinphong tt1 : list)
			{
				String[] rowData = {tt1.getMaPhong(),tt1.getMaLoaiphong(),tt1.getTenPhong(),tt1.getLoaiPhong(),String.valueOf(tt1.getDienTich()),String.valueOf(tt1.getDonGia()),tt1.getGhichu()};
				modelphong.addRow(rowData);
			}
			
		}
		if(key.equals("")) //Khi để trống thì hiện lại danh sách ban đầu
		{
			JOptionPane.showMessageDialog(null, "Vui long nhap thong tin tim");
			XoaHetDuLieuTableModel(table);
			list.clear();
			updateTableData();;
		}
		table.setModel(modelphong);
	}
	public boolean delete(String mhong) {
		Connection con = Database.getinstance().getconnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("delete from Phong where maPhong=?");
			stmt.setString(1, mhong);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Không thể xóa phòng đang sử dụng!");
		}
		return n>0;
	}
	private static void Locphongtrong(){
		list.clear();
		list = dsp.Locphongtrong();
		if(list != null)
		{
			XoaHetDuLieuTableModel(table);
			for(Thongtinphong tt1 : list)
			{
			String[] rowData = {tt1.getMaPhong(),tt1.getMaLoaiphong(),tt1.getTenPhong(),tt1.getLoaiPhong(),String.valueOf(tt1.getDienTich()),String.valueOf(tt1.getDonGia()),tt1.getGhichu()};
				modelphong.addRow(rowData);
			}
		}
	}
	private static void LocphongSudung(){
		list.clear();
		list = dsp.Locphongcokhach();
		if(list != null)
		{
			XoaHetDuLieuTableModel(table);
			for(Thongtinphong tt1 : list)
			{
			String[] rowData = {tt1.getMaPhong(),tt1.getMaLoaiphong(),tt1.getTenPhong(),tt1.getLoaiPhong(),String.valueOf(tt1.getDienTich()),String.valueOf(tt1.getDonGia()),tt1.getGhichu()};
				modelphong.addRow(rowData);
			}
		}
	}
	private void Tatcaphong(){		
			XoaHetDuLieuTableModel(table);
			list.clear();
			updateTableData();
			table.setModel(modelphong);
	}
	public void timmaphong()
	{
		String key = (String) comboloaiphong.getSelectedItem();
		Loaiphong lp2 = dslp.Timmaloai(key);
		if(lp2 != null)
		{
				txtmaloaiphong.setText(lp2.getMaLoaiphong());
		}
		else
			JOptionPane.showMessageDialog(this, "432");
	}
}
