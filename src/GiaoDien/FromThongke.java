package GiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;

import com.toedter.calendar.JDayChooser;

import danhsachs.Danhsachdichvu;
import danhsachs.Danhsachdoanhthu;
import danhsachs.Database;
import entitis.Dichvu;
import entitis.Doanhthu;

import com.toedter.calendar.JDateChooser;

public class FromThongke extends JFrame implements ActionListener{

	private JPanel contentPane;
	private static JTable table;
	private JTextField txtdoanhthu;
	private JTextField txtloinhuan;
	private static JTable table_1;
	private static DefaultTableModel modeldv;
	private static DefaultTableModel modeldt;
	private JTextField txtsl;
	private JTextField txtthanhtien;
	private JButton btnthongke;
	private JButton btnxuatexcel;
	private JButton btnthongkeDV;
	private JButton btnxuatexceldv;
	private JButton btnRefest;
	private JButton btnRefeshdt;
	private static List<Dichvu> listdv;
	private static List<Doanhthu> listdt;
	private static Danhsachdichvu dsdv = new Danhsachdichvu();
	private static Danhsachdoanhthu dsdt = new Danhsachdoanhthu();
	private static JDateChooser dateChoosertudt;
	private static JDateChooser dateChooserdendt;
	private static JDateChooser dateChoosertudv;
	private static JDateChooser dateChooserdendv;
	
	public JPanel pthongke;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FromThongke frame = new FromThongke();
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
	public FromThongke() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1158, 729);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pthongke = new JPanel();
		pthongke.setBounds(0, 144, 1144, 551);
		contentPane.add(pthongke);
		pthongke.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 1124, 529);
		pthongke.add(tabbedPane);
		
		JPanel pDoanhthu = new JPanel();
		pDoanhthu.setBackground(new Color(173, 216, 230));
		tabbedPane.addTab("Doanh thu", null, pDoanhthu, null);
		pDoanhthu.setLayout(null);
		
		JLabel lblTNgy = new JLabel("Từ ngày:");
		lblTNgy.setBounds(87, 58, 48, 15);
		pDoanhthu.add(lblTNgy);
		lblTNgy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblThngKDoanh = new JLabel("Thống kê doanh thu");
		lblThngKDoanh.setBounds(462, 5, 147, 21);
		pDoanhthu.add(lblThngKDoanh);
		lblThngKDoanh.setForeground(Color.RED);
		lblThngKDoanh.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblnNgy = new JLabel("Đến ngày:");
		lblnNgy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblnNgy.setBounds(669, 58, 87, 14);
		pDoanhthu.add(lblnNgy);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 109, 1086, 321);
		pDoanhthu.add(scrollPane);
		
		table = new JTable();
		table.setModel(modeldt=new DefaultTableModel(new String[] {
				"T\u00EAn ph\u00F2ng", "T\u00EAn KH", "T\u00EAn NV", "Ng\u00E0y l\u1EADp", "T\u1ED5ng ti\u1EC1n"
			}, 0));
		table.getColumnModel().getColumn(0).setPreferredWidth(86);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(2).setPreferredWidth(105);
		table.getColumnModel().getColumn(3).setPreferredWidth(91);
		table.getColumnModel().getColumn(4).setPreferredWidth(82);
		scrollPane.setViewportView(table);
		
		JLabel lblTngDoanhThu = new JLabel("Tổng doanh thu:");
		lblTngDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTngDoanhThu.setBounds(50, 461, 96, 14);
		pDoanhthu.add(lblTngDoanhThu);
		
		txtdoanhthu = new JTextField();
		txtdoanhthu.setForeground(Color.RED);
		txtdoanhthu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtdoanhthu.setEditable(false);
		txtdoanhthu.setBounds(156, 459, 103, 20);
		pDoanhthu.add(txtdoanhthu);
		txtdoanhthu.setColumns(10);
		
		JLabel lblVnd = new JLabel("VNĐ");
		lblVnd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVnd.setBounds(269, 462, 48, 14);
		pDoanhthu.add(lblVnd);
		
		JLabel lblLiNhun = new JLabel("Lợi nhuận:");
		lblLiNhun.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLiNhun.setBounds(342, 462, 70, 14);
		pDoanhthu.add(lblLiNhun);
		
		txtloinhuan = new JTextField();
		txtloinhuan.setForeground(Color.RED);
		txtloinhuan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtloinhuan.setEditable(false);
		txtloinhuan.setBounds(416, 459, 115, 20);
		pDoanhthu.add(txtloinhuan);
		txtloinhuan.setColumns(10);
		
		JLabel lblVn = new JLabel("VNĐ");
		lblVn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVn.setBounds(541, 462, 48, 14);
		pDoanhthu.add(lblVn);
		
		btnthongke = new JButton("Thống kê");
		btnthongke.setBackground(Color.BLUE);
		btnthongke.setForeground(Color.WHITE);
		btnthongke.setBounds(655, 452, 89, 29);
		pDoanhthu.add(btnthongke);
		
		btnxuatexcel = new JButton("Xuất excel");
		btnxuatexcel.setBounds(787, 452, 103, 29);
		pDoanhthu.add(btnxuatexcel);
		
		btnRefeshdt = new JButton("Refesh");
		btnRefeshdt.setBounds(910, 458, 89, 23);
		pDoanhthu.add(btnRefeshdt);
		
		dateChoosertudt = new JDateChooser();
		dateChoosertudt.setBounds(165, 53, 129, 20);
		pDoanhthu.add(dateChoosertudt);
		
		dateChooserdendt = new JDateChooser();
		dateChooserdendt.setBounds(742, 58, 129, 20);
		pDoanhthu.add(dateChooserdendt);
		
		JPanel pDichvu = new JPanel();
		pDichvu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		pDichvu.setBackground(new Color(175, 238, 238));
		tabbedPane.addTab("Dich vu", null, pDichvu, null);
		pDichvu.setLayout(null);
		
		JLabel lblThngKDoanh_1 = new JLabel("Thống kê dịch vụ");
		lblThngKDoanh_1.setForeground(new Color(255, 0, 0));
		lblThngKDoanh_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblThngKDoanh_1.setBounds(488, 35, 158, 23);
		pDichvu.add(lblThngKDoanh_1);
		
		JLabel lblTNgy_1 = new JLabel("Từ ngày:");
		lblTNgy_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTNgy_1.setBounds(79, 90, 48, 14);
		pDichvu.add(lblTNgy_1);
		
		JLabel lblnNgy_1 = new JLabel("Đến ngày:");
		lblnNgy_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblnNgy_1.setBounds(752, 94, 65, 14);
		pDichvu.add(lblnNgy_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(21, 130, 1077, 310);
		pDichvu.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(modeldv=new DefaultTableModel(new String[] {
				"M\u00E3 DV", "T\u00EAn DV", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1", "Th\u00E0nh ti\u1EC1n", "Ng\u00E0y xu\u1EA5t"
			}, 0));
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblSLngDv = new JLabel("Số lượng DV:");
		lblSLngDv.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSLngDv.setBounds(44, 465, 83, 14);
		pDichvu.add(lblSLngDv);
		
		txtsl = new JTextField();
		txtsl.setForeground(new Color(255, 0, 0));
		txtsl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtsl.setEditable(false);
		txtsl.setBounds(137, 463, 96, 20);
		pDichvu.add(txtsl);
		txtsl.setColumns(10);
		
		JLabel lblThnhTin = new JLabel("Thành tiền:");
		lblThnhTin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblThnhTin.setBounds(331, 466, 73, 14);
		pDichvu.add(lblThnhTin);
		
		txtthanhtien = new JTextField();
		txtthanhtien.setForeground(new Color(255, 0, 0));
		txtthanhtien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtthanhtien.setEditable(false);
		txtthanhtien.setBounds(418, 463, 110, 20);
		pDichvu.add(txtthanhtien);
		txtthanhtien.setColumns(10);
		
		btnthongkeDV = new JButton("Thống kê");
		btnthongkeDV.setBackground(Color.GREEN);
		btnthongkeDV.setForeground(Color.WHITE);
		btnthongkeDV.setBounds(614, 462, 89, 28);
		pDichvu.add(btnthongkeDV);
		
		btnxuatexceldv = new JButton("Xuất Excel");
		btnxuatexceldv.setBounds(752, 462, 101, 28);
		pDichvu.add(btnxuatexceldv);
		
		btnRefest = new JButton("Refest");
		btnRefest.setBounds(882, 465, 89, 23);
		pDichvu.add(btnRefest);
		
		dateChoosertudv = new JDateChooser();
		dateChoosertudv.setBounds(148, 88, 122, 20);
		pDichvu.add(dateChoosertudv);
		
		dateChooserdendv = new JDateChooser();
		dateChooserdendv.setBounds(829, 90, 122, 20);
		pDichvu.add(dateChooserdendv);
		Database.getinstance().connect();
		btnthongkeDV.addActionListener(this);
		btnthongke.addActionListener(this);
		btnRefest.addActionListener(this);
		btnRefeshdt.addActionListener(this);
		btnxuatexcel.addActionListener(this);
		btnxuatexceldv.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object s = e.getSource();
		if(s.equals(btnthongkeDV))
		{
			updateTableData();
			soluongdichvu();
			thanhtiendv();
		}
		else if(s.equals(btnthongke))
		{
			updateTableDatadoanhthu();
			tongdoanhthu();
			txtloinhuan.setText("34056.0");
		}
		else if(s.equals(btnRefest))
		{
			updatelenbangdichvu();
		}
		else if(s.equals(btnRefeshdt))
		{
			updatelenbang();
		}
		else if(s.equals(btnxuatexcel))
		{
			exportExcel(table);
		}
		else if(s.equals(btnxuatexceldv))
		{
			exportExcel(table_1);
		}
	}
	public static void updateTableData()
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		listdv = dsdv.tinhdichvu(df.format(dateChoosertudv.getDate()), df.format(dateChooserdendv.getDate()));
		XoaHetDuLieuTableModel(table_1);
		for(Dichvu dv : listdv)
		{
			String[] rowData = {dv.getMaDV(),dv.getTenDV(),String.valueOf(dv.getSoLuong()),String.valueOf(dv.getDongia()),String.valueOf(dv.getThanhTien()),dv.getNgayXuat()};
			modeldv.addRow(rowData);
		}
		table_1.setModel(modeldv);
		listdv.clear();
	}
	public static void updateTableDatadoanhthu()
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		listdt = dsdt.tinhdoanhthu(df.format(dateChoosertudt.getDate()), df.format(dateChooserdendt.getDate()));
		XoaHetDuLieuTableModel(table);
		if(listdt !=null)
		{
			for(Doanhthu dt : listdt)
			{
				String[] rowData = {dt.getTenPhong(),dt.getTenKH(),dt.getTenNV(),dt.getNgayLap(),String.valueOf(dt.getTongTien())};
				modeldt.addRow(rowData);
			}
		}
		if(df.format(dateChoosertudt.getDate()).equals("") && df.format(dateChooserdendt.getDate()).equals(""))
		{
			XoaHetDuLieuTableModel(table);
			listdt.clear();
			updatelenbang();
		}
		table.setModel(modeldt);
		listdt.clear();
	}
	public static void updateTableDatadichvu()
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		listdt = dsdt.tinhdoanhthu(df.format(dateChoosertudt.getDate()), df.format(dateChooserdendt.getDate()));
		XoaHetDuLieuTableModel(table);
		if(listdt !=null)
		{
			for(Doanhthu dt : listdt)
			{
				String[] rowData = {dt.getTenPhong(),dt.getTenKH(),dt.getTenNV(),dt.getNgayLap(),String.valueOf(dt.getTongTien())};
				modeldt.addRow(rowData);
			}
		}
		if(df.format(dateChoosertudt.getDate()).equals("") && df.format(dateChooserdendt.getDate()).equals(""))
		{
			XoaHetDuLieuTableModel(table);
			listdt.clear();
			updatelenbang();
		}
		table.setModel(modeldt);
		listdt.clear();
	}
	public static void updatelenbang()
	{
		listdt = dsdt.docDanhthu();
		XoaHetDuLieuTableModel(table);
		for(Doanhthu dt : listdt)
		{
			String[] rowData = {dt.getTenPhong(),dt.getTenKH(),dt.getTenNV(),dt.getNgayLap(),String.valueOf(dt.getTongTien())};
			modeldt.addRow(rowData);
		}
		listdt.clear();
		table.setModel(modeldt);
	}
	public static void updatelenbangdichvu()
	{
		listdv = dsdv.doclendichvu();
		XoaHetDuLieuTableModel(table_1);
		for(Dichvu dv : listdv)
		{
			String[] rowData = {dv.getMaDV(),dv.getTenDV(),String.valueOf(dv.getSoLuong()),String.valueOf(dv.getDongia()),String.valueOf(dv.getThanhTien()),dv.getNgayXuat()};
			modeldv.addRow(rowData);
		}
		table_1.setModel(modeldv);
		listdv.clear();
	}
	private void soluongdichvu()
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		int dem=0;
		listdv = dsdv.tinhdichvu(df.format(dateChoosertudv.getDate()), df.format(dateChooserdendv.getDate()));
		for(Dichvu dv : listdv)
		{
			dem++;
		}
		txtsl.setText(String.valueOf(dem));
		listdv.clear();
	}
	private void thanhtiendv()
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		float tong=0;
		listdv = dsdv.tinhdichvu(df.format(dateChoosertudv.getDate()), df.format(dateChooserdendv.getDate()));
		for(Dichvu dv : listdv)
		{
			tong+=dv.getThanhTien();
		}
		txtthanhtien.setText(String.valueOf(tong));
		listdv.clear();
	}
	private void tongdoanhthu()
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		float tong=0;
		listdt = dsdt.tinhdoanhthu(df.format(dateChoosertudt.getDate()), df.format(dateChooserdendt.getDate()));
		for(Doanhthu dt : listdt)
		{
			tong+=dt.getTongTien();
		}
		txtdoanhthu.setText(String.valueOf(tong));
		listdt.clear();
	}
	private static void XoaHetDuLieuTableModel(JTable table) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		//dtm.getDataVector().removeAllElements();
		dtm.setNumRows(0);
	}
	public void exportExcel(JTable table) {
		 JFileChooser chooser = new JFileChooser();
		 int i = chooser.showSaveDialog(chooser);
		 if (i == JFileChooser.APPROVE_OPTION) {
		  java.io.File file = chooser.getSelectedFile();
		  try {
		   FileWriter out = new FileWriter(file + ".xls");
		   BufferedWriter bwrite = new BufferedWriter(out);
		   DefaultTableModel model = (DefaultTableModel) table.getModel();
		   // ten Cot
		   for (int j = 0; j < table.getColumnCount(); j++) {
		    bwrite.write(model.getColumnName(j) + "\t");
		   }
		   bwrite.write("\n");
		   // Lay du lieu dong
		   for (int j = 0; j < table.getRowCount(); j++) {
		    for (int k = 0; k < table.getColumnCount(); k++) {
		     bwrite.write(model.getValueAt(j, k) + "\t");
		    }
		    bwrite.write("\n");
		   }
		   bwrite.close();
		   JOptionPane.showMessageDialog(null, "Lưu file thành công!");
		  } catch (Exception e2) {
		   JOptionPane.showMessageDialog(null, "Lỗi khi lưu file!");
		  }
		 }
	}
}
