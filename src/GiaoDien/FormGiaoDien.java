package GiaoDien;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.parser.ParserDelegator;

import Data.Connect;
import dbs.DanhSachKeToan;
import dbs.DanhSachNhanSu;
import entitis.NhanSu;
import entitis.ThanhToan;

import java.awt.CardLayout;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.print.attribute.standard.Copies;
import javax.swing.DefaultComboBoxModel;
import java.text.Normalizer.Form;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Random;
import java.util.Vector;

import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;

public class FormGiaoDien extends JFrame  implements ActionListener {

	private JPanel contentPane,pChinh,pThuePhong,pLapPhieuDichVu ;
	private JTable tableBangGia;
	private JTextField txtQLDV_TenDV;
	private JTextField txtQLDV_GiaTien,txtMaNV;
	private JTextField txtMaKH;
	private JTextField txtDatCoc;
	public JTable tableDSThuePhong;
	public JTable tableLapHoaDon;
	public JTextField txtQLKH_tenKH;
	public JTextField txtQLKH_DiaChiKH;
	public JTextField txtQLKH_sdtKH;	
	public JTable tableDSKH;
	private JDateChooser txtNgaySD, txtNgayVao, txtNgayRa;

	private JComboBox cbThuePhong_MaPhong,cbTenNV,cbLoaiPhong;

	public JButton btnQLKHThemKH,btnThemDV,btnSuaDV,btnXoaDV,btnThuePhong,btnThuePhongTuDSKH,btnThueDichVu,btnThueDV,btnLapHoaDon;

	private JTable tableDSPhong;
	public JTextField txtMaThue;
	private JTextField txtSoLuong;
	public JTable tableDSKHThueDV;

	private Connection connect = null;
	private DefaultTableModel tableModelDichVu = new DefaultTableModel();
	private DefaultTableModel tableModelThuePhong= new DefaultTableModel();
	private DefaultTableModel tableModelDSKH= new DefaultTableModel();
	private DefaultTableModel tableModelDSPhong= new DefaultTableModel();
	private DefaultTableModel tableModelDSKHThueDV= new DefaultTableModel();
	private JTable tableDSDichVuThue;
	private Vector<String> column;

	private DefaultTableModel tableModelDSPhongTrong= new DefaultTableModel();
	private DefaultTableModel tableModelDSPhongDaThue= new DefaultTableModel();
	private DefaultTableModel tableModelDSPhongDon= new DefaultTableModel();
	private DefaultTableModel tableModelDSPhongDoi= new DefaultTableModel();
	private DefaultTableModel tableModelDSPhongTapThe= new DefaultTableModel();
	private DefaultTableModel tableModelLapHoaDon= new DefaultTableModel();
	private JTextField txtMaDV;
	private JTextField txtLapPhieuThueMa;

	FormThanhToan tt = new FormThanhToan();
	public FormKeToan kt = new FormKeToan();
	public FormNhanVien nv = new FormNhanVien();
	FormNhanSu ns= new FormNhanSu();
	private JTextField txtQLKH_MaKH;
	private JTextField txtMaThuePhong;
	private JTextField txtQLDV_MaDV;
	private JTextField txtMaSuDung;
	private JTextField txtCMND;
	private JTextArea txtGhiChu;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormGiaoDien frame = new FormGiaoDien();
					frame.setVisible(true);
					frame.setLocation(200, 50);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		public void loadDataDSKHThuePhong()
		{
			try {
				Connect a = new Connect();
				Connection  conn= a.getConnect();
				int number;
				Vector row;
				String column[]= {"Mã khách hàng","Tên khách hàng","Địa chỉ","Số diện thoại","Số CMND","Ghi chú"};
				java.sql.Statement st= conn.createStatement();
				ResultSet rs= st.executeQuery("select * from KhachHang");
				ResultSetMetaData metadata= rs.getMetaData();
				number= metadata.getColumnCount();
				tableModelDSKH.setColumnIdentifiers(column);
				while(rs.next())
				{
					row = new Vector();
					for(int i = 1; i<= number; i++)
					{
						row.addElement(rs.getString(i));
					}
					tableModelDSKH.addRow(row);
					tableDSKH.setModel(tableModelDSKH);
				}
				tableDSKH.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						if(tableDSKH.getSelectedRow() >=0)
						{
							txtQLKH_MaKH.setText(tableDSKH.getValueAt(tableDSKH.getSelectedRow(), 0) + "");
							txtQLKH_tenKH.setText(tableDSKH.getValueAt(tableDSKH.getSelectedRow(), 1) + "");
							txtQLKH_DiaChiKH.setText(tableDSKH.getValueAt(tableDSKH.getSelectedRow(), 2) + "");
							txtQLKH_sdtKH.setText(tableDSKH.getValueAt(tableDSKH.getSelectedRow(), 3) + "");
							txtCMND.setText(tableDSKH.getValueAt(tableDSKH.getSelectedRow(), 4) + "");
							txtGhiChu.setText(tableDSKH.getValueAt(tableDSKH.getSelectedRow(), 5) + "");
						}
					}
				});
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		public FormGiaoDien() {

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1160, 728);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			//Tieu đề

			JPanel pTieuDe = new JPanel();
			pTieuDe.setBackground(SystemColor.activeCaption);
			pTieuDe.setBounds(0, 0, 1144, 67);
			contentPane.add(pTieuDe);
			pTieuDe.setLayout(null);

			JLabel lblTieuDe = new JLabel("PHẦN MỀN QUẢN LÍ ĐẶT PHÒNG KHÁCH SẠN");
			lblTieuDe.setForeground(new Color(220, 20, 60));
			lblTieuDe.setBackground(Color.GRAY);
			lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
			lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 30));
			lblTieuDe.setBounds(0, 0, 1144, 67);
			pTieuDe.add(lblTieuDe);

			pChinh = new JPanel();
			pChinh.setBounds(0, 141, 1144, 551);
			contentPane.add(pChinh);
			pChinh.setLayout(new CardLayout(0, 0));

			JPanel pGiaoDienChao = new JPanel();
			pGiaoDienChao.setBackground(SystemColor.info);
			pChinh.add(pGiaoDienChao, "name_15754182484200");

			JPanel pQuanLiKhachHang = new JPanel();
			pQuanLiKhachHang.setBackground(new Color(210, 180, 140));
			pChinh.add(pQuanLiKhachHang, "name_14714746260400");
			pQuanLiKhachHang.setLayout(null);

			JScrollPane scrollPaneDSKH = new JScrollPane();
			scrollPaneDSKH.setBounds(425, 72, 709, 420);
			pQuanLiKhachHang.add(scrollPaneDSKH);

			tableDSKH = new JTable();

			scrollPaneDSKH.setViewportView(tableDSKH);

			JPanel lblQLKHMa = new JPanel();
			lblQLKHMa.setForeground(Color.RED);
			lblQLKHMa.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			lblQLKHMa.setBounds(10, 160, 383, 381);
			pQuanLiKhachHang.add(lblQLKHMa);
			lblQLKHMa.setLayout(null);

			JLabel lblQLKHTen = new JLabel("Tên khách hàng:");
			lblQLKHTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblQLKHTen.setBounds(20, 79, 114, 36);
			lblQLKHMa.add(lblQLKHTen);

			JLabel lblQLKHDiaChi = new JLabel("Địa chỉ:");
			lblQLKHDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblQLKHDiaChi.setBounds(20, 132, 88, 36);
			lblQLKHMa.add(lblQLKHDiaChi);

			JLabel lblQLKHSdt = new JLabel("Số điện thoại:");
			lblQLKHSdt.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblQLKHSdt.setBounds(20, 178, 88, 36);
			lblQLKHMa.add(lblQLKHSdt);

			txtQLKH_tenKH = new JTextField();
			txtQLKH_tenKH.setColumns(10);
			txtQLKH_tenKH.setBounds(144, 86, 186, 28);
			lblQLKHMa.add(txtQLKH_tenKH);

			txtQLKH_DiaChiKH = new JTextField();
			txtQLKH_DiaChiKH.setColumns(10);
			txtQLKH_DiaChiKH.setBounds(144, 139, 186, 28);
			lblQLKHMa.add(txtQLKH_DiaChiKH);

			txtQLKH_sdtKH = new JTextField();
			txtQLKH_sdtKH.setColumns(10);
			txtQLKH_sdtKH.setBounds(144, 185, 186, 28);
			lblQLKHMa.add(txtQLKH_sdtKH);

			JLabel tbtMaKH = new JLabel("Mã khách hàng");
			tbtMaKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tbtMaKH.setBounds(20, 26, 114, 36);
			lblQLKHMa.add(tbtMaKH);

			txtQLKH_MaKH = new JTextField();
			txtQLKH_MaKH.setEditable(false);
			txtQLKH_MaKH.setColumns(10);
			txtQLKH_MaKH.setBounds(144, 33, 186, 28);
			lblQLKHMa.add(txtQLKH_MaKH);

			JLabel lblCmnd = new JLabel("CMND:");
			lblCmnd.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCmnd.setBounds(20, 235, 88, 36);
			lblQLKHMa.add(lblCmnd);

			txtCMND = new JTextField();
			txtCMND.setColumns(10);
			txtCMND.setBounds(144, 234, 186, 28);
			lblQLKHMa.add(txtCMND);

			JLabel lblGhiCh = new JLabel("Ghi chú:");
			lblGhiCh.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblGhiCh.setBounds(20, 281, 88, 36);
			lblQLKHMa.add(lblGhiCh);

			txtGhiChu = new JTextArea();
			txtGhiChu.setBounds(144, 270, 186, 101);
			lblQLKHMa.add(txtGhiChu);

			JPanel pQLKHTieuDe = new JPanel();
			pQLKHTieuDe.setBounds(421, 10, 713, 52);
			pQuanLiKhachHang.add(pQLKHTieuDe);
			pQLKHTieuDe.setLayout(null);

			JLabel lblTieuDeDSKH = new JLabel("Danh sách khách hàng thuê phòng");
			lblTieuDeDSKH.setBounds(0, 0, 713, 52);
			pQLKHTieuDe.add(lblTieuDeDSKH);
			lblTieuDeDSKH.setHorizontalAlignment(SwingConstants.CENTER);
			lblTieuDeDSKH.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));

			JPanel pTraCuuPhong = new JPanel();
			pTraCuuPhong.setBackground(new Color(112, 128, 144));
			pChinh.add(pTraCuuPhong, "name_14722732121900");
			pTraCuuPhong.setLayout(null);

			JPanel panel_3 = new JPanel();
			panel_3.setBackground(new Color(0, 206, 209));
			panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tra c\u1EE9u ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, Color.MAGENTA));
			panel_3.setBounds(25, 135, 221, 305);
			pTraCuuPhong.add(panel_3);

			JButton btnPhongTrong = new JButton("PHÒNG TRỐNG");
			btnPhongTrong.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					loadDataDSPhongTrong();
					tableModelDSPhongTrong.setRowCount(0);
					loadDataDSPhongTrong();
				}
			});
			btnPhongTrong.setFont(new Font("Tahoma", Font.BOLD, 15));

			JButton btnPhongDaThue = new JButton("PHÒNG ĐÃ THUÊ");
			btnPhongDaThue.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					loadDataDSPhongDaThue();
					tableModelDSPhongDaThue.setRowCount(0);
					loadDataDSPhongDaThue();
				}
			});
			btnPhongDaThue.setFont(new Font("Tahoma", Font.BOLD, 15));

			JButton btnPhongDon = new JButton("PHÒNG ĐƠN");
			btnPhongDon.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	
					loadDataDSPhongDon();
					tableModelDSPhongDon.setRowCount(0);
					loadDataDSPhongDon();
				}
			});
			btnPhongDon.setFont(new Font("Tahoma", Font.BOLD, 15));

			JButton btnPhongDoi = new JButton("PHÒNG ĐÔI");
			btnPhongDoi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					loadDataDSPhongDoi();
					tableModelDSPhongDoi.setRowCount(0);
					loadDataDSPhongDoi();
				}
			});
			btnPhongDoi.setFont(new Font("Tahoma", Font.BOLD, 15));

			JButton btnPhongTapThe = new JButton("PHÒNG TẬP THỂ");
			btnPhongTapThe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					loadDataDSPhongTapThe();
					tableModelDSPhongTapThe.setRowCount(0);
					loadDataDSPhongTapThe();
				}
			});
			btnPhongTapThe.setFont(new Font("Tahoma", Font.BOLD, 15));
			GroupLayout gl_panel_3 = new GroupLayout(panel_3);
			gl_panel_3.setHorizontalGroup(
					gl_panel_3.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_3.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
									.addComponent(btnPhongTrong, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnPhongDaThue, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnPhongDon, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnPhongDoi, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnPhongTapThe, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(21, Short.MAX_VALUE))
					);
			gl_panel_3.setVerticalGroup(
					gl_panel_3.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_3.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnPhongTrong, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(btnPhongDaThue, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(btnPhongDon, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(btnPhongDoi, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
							.addComponent(btnPhongTapThe, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
					);
			panel_3.setLayout(gl_panel_3);

			JScrollPane scrollPaneTraCuuPhong = new JScrollPane();
			scrollPaneTraCuuPhong.setBounds(307, 82, 827, 459);
			pTraCuuPhong.add(scrollPaneTraCuuPhong);

			tableDSPhong = new JTable();

			scrollPaneTraCuuPhong.setViewportView(tableDSPhong);

			JPanel pTieuDeTraCuuPhong = new JPanel();
			pTieuDeTraCuuPhong.setBackground(new Color(72, 61, 139));
			pTieuDeTraCuuPhong.setBounds(307, 10, 827, 48);
			pTraCuuPhong.add(pTieuDeTraCuuPhong);
			pTieuDeTraCuuPhong.setLayout(null);

			JLabel lblDanhSchPhng_1 = new JLabel("Danh sách phòng khách san\r\n");
			lblDanhSchPhng_1.setForeground(new Color(255, 0, 255));
			lblDanhSchPhng_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblDanhSchPhng_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));
			lblDanhSchPhng_1.setBounds(0, 0, 827, 48);
			pTieuDeTraCuuPhong.add(lblDanhSchPhng_1);

			pThuePhong = new JPanel();
			pThuePhong.setBackground(new Color(218, 112, 214));
			pChinh.add(pThuePhong, "name_14719674327000");

			JPanel pLapHoaDon = new JPanel();
			pChinh.add(pLapHoaDon, "name_14754186497900");

			JPanel pQuanLiDichVu = new JPanel();
			pChinh.add(pQuanLiDichVu, "name_14756448132500");

			pLapPhieuDichVu = new JPanel();
			pChinh.add(pLapPhieuDichVu, "name_14763320470700");
			pLapPhieuDichVu.setLayout(null);

			JPanel pThognTinThue = new JPanel();
			pThognTinThue.setBackground(new Color(255, 250, 205));
			pThognTinThue.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin thu\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pThognTinThue.setBounds(10, 78, 245, 331);
			pLapPhieuDichVu.add(pThognTinThue);
			pThognTinThue.setLayout(null);

			JLabel lblMaThue = new JLabel("Mã thuê:");
			lblMaThue.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblMaThue.setBounds(10, 86, 101, 30);
			pThognTinThue.add(lblMaThue);

			JLabel lblMaDichVu = new JLabel("Mã dịch vụ:");
			lblMaDichVu.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblMaDichVu.setBounds(10, 145, 101, 30);
			pThognTinThue.add(lblMaDichVu);

			JLabel lblNgaySuDung = new JLabel("Ngày sử dụng:");
			lblNgaySuDung.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNgaySuDung.setBounds(10, 214, 101, 30);
			pThognTinThue.add(lblNgaySuDung);

			JLabel lblSLng = new JLabel("Số lượng:");
			lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblSLng.setBounds(10, 265, 101, 30);
			pThognTinThue.add(lblSLng);

			txtMaThue = new JTextField();
			txtMaThue.setEditable(false);
			txtMaThue.setBounds(121, 94, 96, 19);
			pThognTinThue.add(txtMaThue);
			txtMaThue.setColumns(10);

			txtSoLuong = new JTextField();
			txtSoLuong.setColumns(10);
			txtSoLuong.setBounds(121, 273, 94, 19);
			pThognTinThue.add(txtSoLuong);

			txtMaDV = new JTextField();
			txtMaDV.setEditable(false);
			txtMaDV.setBounds(119, 153, 96, 19);
			pThognTinThue.add(txtMaDV);
			txtMaDV.setColumns(10);

			JLabel txtMaThueDV = new JLabel("Mã sử dụng DV");
			txtMaThueDV.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtMaThueDV.setBounds(10, 26, 101, 30);
			pThognTinThue.add(txtMaThueDV);

			txtMaSuDung = new JTextField();
			txtMaSuDung.setEditable(false);
			txtMaSuDung.setColumns(10);
			txtMaSuDung.setBounds(121, 34, 96, 19);
			pThognTinThue.add(txtMaSuDung);

			txtNgaySD = new JDateChooser();
			txtNgaySD.setBounds(121, 214, 96, 19);
			pThognTinThue.add(txtNgaySD);

			JScrollPane scrollPane_DSKHThueDV = new JScrollPane();
			scrollPane_DSKHThueDV.setBounds(671, 66, 473, 470);
			pLapPhieuDichVu.add(scrollPane_DSKHThueDV);

			tableDSKHThueDV = new JTable();

			scrollPane_DSKHThueDV.setViewportView(tableDSKHThueDV);

			JPanel pDSKHThueDV = new JPanel();
			pDSKHThueDV.setBounds(661, 10, 473, 46);
			pLapPhieuDichVu.add(pDSKHThueDV);
			pDSKHThueDV.setLayout(null);

			JLabel lblDSKHThueDV = new JLabel("Danh sách khách hàng thuê dịch vụ");
			lblDSKHThueDV.setHorizontalAlignment(SwingConstants.CENTER);
			lblDSKHThueDV.setForeground(new Color(0, 128, 128));
			lblDSKHThueDV.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblDSKHThueDV.setBounds(0, 0, 473, 46);
			pDSKHThueDV.add(lblDSKHThueDV);

			btnThueDV = new JButton("THUÊ");
			btnThueDV.addActionListener(this);
			btnThueDV.setBounds(22, 458, 129, 32);
			pLapPhieuDichVu.add(btnThueDV);
			btnThueDV.setFont(new Font("Tahoma", Font.BOLD, 14));

			JButton btnXoaTrangThueDV = new JButton("XÓA TRẮNG");
			btnXoaTrangThueDV.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtMaSuDung.setText("");
					txtMaThue.setText("");
					txtMaDV.setText("");
					SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
					String date= sdf.format(txtNgaySD.getDate());
					//txtNgaySD.setText("");
					txtSoLuong.setText("");
				}
			});
			btnXoaTrangThueDV.setBounds(231, 457, 129, 35);
			pLapPhieuDichVu.add(btnXoaTrangThueDV);
			btnXoaTrangThueDV.setFont(new Font("Tahoma", Font.BOLD, 14));

			JScrollPane scrollPaneDSDVThue = new JScrollPane();
			scrollPaneDSDVThue.setBounds(302, 87, 316, 322);
			pLapPhieuDichVu.add(scrollPaneDSDVThue);

			tableDSDichVuThue = new JTable();

			scrollPaneDSDVThue.setViewportView(tableDSDichVuThue);

			JPanel panel = new JPanel();
			panel.setBackground(new Color(175, 238, 238));
			panel.setBounds(10, 10, 600, 46);
			pLapPhieuDichVu.add(panel);
			panel.setLayout(null);

			JLabel lblThuDchV = new JLabel("THUÊ DỊCH VỤ");
			lblThuDchV.setHorizontalAlignment(SwingConstants.CENTER);
			lblThuDchV.setFont(new Font("Times New Roman", Font.BOLD, 25));
			lblThuDchV.setBounds(0, 0, 600, 46);
			panel.add(lblThuDchV);

			JPanel pTimPhong = new JPanel();
			pChinh.add(pTimPhong, "name_14759827106300");

			JPanel pTimKhachHang = new JPanel();
			pChinh.add(pTimKhachHang, "name_14761407656800");

			JPanel pQuanLiPhong = new JPanel();
			pChinh.add(pQuanLiPhong, "name_14765735037500");

			JPanel pThongKePhongTrong = new JPanel();
			pChinh.add(pThongKePhongTrong, "name_14767838040900");

			JPanel pTimHoaDon = new JPanel();
			pChinh.add(pTimHoaDon, "name_14769761217000");

			JPanel pXemPhong = new JPanel();
			pChinh.add(pXemPhong, "name_14758112897900");
			pXemPhong.setLayout(null);

			JLabel lblNewLabel1 = new JLabel("");
			lblNewLabel1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			lblNewLabel1.setIcon(new ImageIcon("C:\\Users\\Nguyen Duc Thien\\Pictures\\rsz_1locker-32360_960_720.png"));
			lblNewLabel1.setBounds(37, 90, 90, 72);
			pXemPhong.add(lblNewLabel1);

			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon("C:\\Users\\Nguyen Duc Thien\\Pictures\\rsz_1locker-32360_960_720.png"));
			label.setBounds(209, 90, 90, 72);
			pXemPhong.add(label);

			JLabel label_1 = new JLabel("");
			label_1.setIcon(new ImageIcon("C:\\Users\\Nguyen Duc Thien\\Pictures\\rsz_1locker-32360_960_720.png"));
			label_1.setBounds(370, 90, 90, 72);
			pXemPhong.add(label_1);

			JLabel label_2 = new JLabel("");
			label_2.setIcon(new ImageIcon("C:\\Users\\Nguyen Duc Thien\\Pictures\\rsz_1locker-32360_960_720.png"));
			label_2.setBounds(542, 90, 90, 72);
			pXemPhong.add(label_2);

			JLabel label_3 = new JLabel("");
			label_3.setIcon(new ImageIcon("C:\\Users\\Nguyen Duc Thien\\Pictures\\rsz_1locker-32360_960_720.png"));
			label_3.setBounds(209, 249, 90, 72);
			pXemPhong.add(label_3);

			JLabel label_4 = new JLabel("");
			label_4.setIcon(new ImageIcon("C:\\Users\\Nguyen Duc Thien\\Pictures\\rsz_1locker-32360_960_720.png"));
			label_4.setBounds(542, 249, 90, 72);
			pXemPhong.add(label_4);

			JLabel label_5 = new JLabel("");
			label_5.setIcon(new ImageIcon("C:\\Users\\Nguyen Duc Thien\\Pictures\\rsz_1locker-32360_960_720.png"));
			label_5.setBounds(741, 90, 90, 72);
			pXemPhong.add(label_5);

			JLabel label_6 = new JLabel("");
			label_6.setIcon(new ImageIcon("C:\\Users\\Nguyen Duc Thien\\Pictures\\rsz_1locker-32360_960_720.png"));
			label_6.setBounds(741, 249, 90, 72);
			pXemPhong.add(label_6);

			JLabel label_7 = new JLabel("");
			label_7.setIcon(new ImageIcon("C:\\Users\\Nguyen Duc Thien\\Pictures\\rsz_1locker-32360_960_720.png"));
			label_7.setBounds(920, 90, 90, 72);
			pXemPhong.add(label_7);

			JLabel label_8 = new JLabel("");
			label_8.setIcon(new ImageIcon("C:\\Users\\Nguyen Duc Thien\\Pictures\\rsz_1locker-32360_960_720.png"));
			label_8.setBounds(37, 249, 90, 72);
			pXemPhong.add(label_8);

			JLabel label_9 = new JLabel("");
			label_9.setIcon(new ImageIcon("C:\\Users\\Nguyen Duc Thien\\Pictures\\rsz_1locker-32360_960_720.png"));
			label_9.setBounds(370, 249, 90, 72);
			pXemPhong.add(label_9);

			JPanel pDSPhongSdDichVu = new JPanel();
			pDSPhongSdDichVu.setBackground(new Color(102, 205, 170));
			pDSPhongSdDichVu.setBounds(0, 10, 1144, 50);
			pXemPhong.add(pDSPhongSdDichVu);
			pDSPhongSdDichVu.setLayout(null);

			JLabel lblDSPhong = new JLabel("Danh sách phòng ");
			lblDSPhong.setForeground(new Color(255, 0, 0));
			lblDSPhong.setHorizontalAlignment(SwingConstants.CENTER);
			lblDSPhong.setFont(new Font("Times New Roman", Font.BOLD, 25));
			lblDSPhong.setBounds(0, 0, 1144, 50);
			pDSPhongSdDichVu.add(lblDSPhong);

			JLabel lblP = new JLabel("P101");
			lblP.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblP.setHorizontalAlignment(SwingConstants.CENTER);
			lblP.setBounds(37, 172, 90, 20);
			pXemPhong.add(lblP);

			JLabel lblP_1 = new JLabel("P102");
			lblP_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblP_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblP_1.setBounds(209, 178, 90, 20);
			pXemPhong.add(lblP_1);

			JLabel lblP_2 = new JLabel("P103");
			lblP_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblP_2.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblP_2.setBounds(370, 178, 90, 20);
			pXemPhong.add(lblP_2);

			JLabel lblP_3 = new JLabel("P104");
			lblP_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblP_3.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblP_3.setBounds(542, 178, 90, 20);
			pXemPhong.add(lblP_3);

			JLabel lblP_4 = new JLabel("P105");
			lblP_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblP_4.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblP_4.setBounds(741, 178, 90, 20);
			pXemPhong.add(lblP_4);

			JLabel lblP_5 = new JLabel("P105");
			lblP_5.setHorizontalAlignment(SwingConstants.CENTER);
			lblP_5.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblP_5.setBounds(920, 178, 90, 20);
			pXemPhong.add(lblP_5);

			JLabel lblP_6 = new JLabel("P201");
			lblP_6.setHorizontalAlignment(SwingConstants.CENTER);
			lblP_6.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblP_6.setBounds(37, 342, 90, 20);
			pXemPhong.add(lblP_6);

			JLabel lblP_7 = new JLabel("P202");
			lblP_7.setHorizontalAlignment(SwingConstants.CENTER);
			lblP_7.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblP_7.setBounds(209, 342, 90, 20);
			pXemPhong.add(lblP_7);

			JLabel lblP_8 = new JLabel("P203");
			lblP_8.setHorizontalAlignment(SwingConstants.CENTER);
			lblP_8.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblP_8.setBounds(370, 342, 90, 20);
			pXemPhong.add(lblP_8);

			JLabel lblP_9 = new JLabel("P204");
			lblP_9.setHorizontalAlignment(SwingConstants.CENTER);
			lblP_9.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblP_9.setBounds(542, 348, 90, 20);
			pXemPhong.add(lblP_9);

			JLabel lblP_10 = new JLabel("P205");
			lblP_10.setHorizontalAlignment(SwingConstants.CENTER);
			lblP_10.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblP_10.setBounds(741, 348, 90, 20);
			pXemPhong.add(lblP_10);

			JPanel pThongKeDoanhThu = new JPanel();
			pChinh.add(pThongKeDoanhThu, "name_14775239101800");

			JPanel pXemThongTimHoaDon = new JPanel();
			pChinh.add(pXemThongTimHoaDon, "name_14778370057000");

			JPanel pXemThongTinTaiKhoan = new JPanel();
			pChinh.add(pXemThongTinTaiKhoan, "name_14787532659800");

			JPanel pQuanLiTaiKhoan = new JPanel();
			pChinh.add(pQuanLiTaiKhoan, "name_14811654142600");
			pGiaoDienChao.setLayout(null);

			JLabel lblHinh1 = new JLabel("");
			lblHinh1.setIcon(new ImageIcon("C:\\Users\\Nguyen Duc Thien\\Pictures\\a25-hotel-45-phan-chu-trinh-khach-san-2-sao-quan-hoan-kiem-ha-noi.jpg"));
			lblHinh1.setBounds(23, 137, 509, 334);
			pGiaoDienChao.add(lblHinh1);

			JLabel lblHinh2 = new JLabel("");
			lblHinh2.setIcon(new ImageIcon("C:\\Users\\Nguyen Duc Thien\\Pictures\\Khach-san-Praha-Phu-Quoc.png"));
			lblHinh2.setBounds(620, 137, 502, 334);
			pGiaoDienChao.add(lblHinh2);

			JLabel lblThietKe = new JLabel("Thiết kế bởi Nhóm 1");
			lblThietKe.setHorizontalAlignment(SwingConstants.CENTER);
			lblThietKe.setFont(new Font("Times New Roman", Font.ITALIC, 20));
			lblThietKe.setBounds(487, 504, 166, 24);
			pGiaoDienChao.add(lblThietKe);

			JLabel lblChucMung = new JLabel("Chúc các bạn làm việc ngày mới tốt lành, nhiều niềm vui !!!!");
			lblChucMung.setBounds(0, 28, 1144, 78);
			pGiaoDienChao.add(lblChucMung);
			lblChucMung.setHorizontalAlignment(SwingConstants.CENTER);
			lblChucMung.setForeground(Color.BLUE);
			lblChucMung.setFont(new Font("Times New Roman", Font.BOLD, 28));

			//Menubar 

			JPanel pMenuBar = new JPanel();
			pMenuBar.setBackground(Color.BLACK);
			pMenuBar.setBounds(0, 71, 1144, 60);
			contentPane.add(pMenuBar);
			pMenuBar.setLayout(null);

			JMenuBar menuBar = new JMenuBar();
			menuBar.setBackground(Color.PINK);
			menuBar.setBounds(0, 0, 1144, 57);
			pMenuBar.add(menuBar);

			JMenu mnLeTan = new JMenu("               LỄ TÂN                ");
			mnLeTan.setFont(new Font("Times New Roman", Font.BOLD, 16));
			menuBar.add(mnLeTan);

			JMenuItem mntmQuanLiKhachHang = new JMenuItem("Quản lí khách hàng");
			mntmQuanLiKhachHang.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pChinh.removeAll();
					pChinh.add(pQuanLiKhachHang);
					pChinh.repaint();
					pChinh.validate();
				}
			});
			mntmQuanLiKhachHang.setFont(new Font("Segoe UI", Font.BOLD, 14));
			mnLeTan.add(mntmQuanLiKhachHang);

			JMenuItem mntmTraCuuPhong = new JMenuItem("Tra cứu phòng");
			mntmTraCuuPhong.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pChinh.removeAll();
					pChinh.add(pTraCuuPhong);
					pChinh.repaint();
					pChinh.validate();
				}
			});
			mntmTraCuuPhong.setFont(new Font("Segoe UI", Font.BOLD, 14));
			mnLeTan.add(mntmTraCuuPhong);

			JMenuItem mntmThuePhong = new JMenuItem("Thuê phòng");
			mntmThuePhong.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pChinh.removeAll();
					pChinh.add(pThuePhong);
					pChinh.repaint();
					pChinh.validate();
				}
			});
			mntmThuePhong.setFont(new Font("Segoe UI", Font.BOLD, 14));
			mnLeTan.add(mntmThuePhong);

			JMenuItem mntmLapHoaDon = new JMenuItem("Lập hóa đơn");
			mntmLapHoaDon.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pChinh.removeAll();
					pChinh.add(pLapHoaDon);
					pChinh.repaint();
					pChinh.validate();
				}
			});
			mntmLapHoaDon.setFont(new Font("Segoe UI", Font.BOLD, 14));
			mnLeTan.add(mntmLapHoaDon);

			JMenu mnDichVu = new JMenu("               DỊCH VỤ               ");
			mnDichVu.setFont(new Font("Times New Roman", Font.BOLD, 16));
			menuBar.add(mnDichVu);

			JMenuItem mntmQuanLiDichVu = new JMenuItem("Quản lí dịch vụ");
			mntmQuanLiDichVu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pChinh.removeAll();
					pChinh.add(pQuanLiDichVu);
					pChinh.repaint();
					pChinh.validate();
				}
			});
			mntmQuanLiDichVu.setFont(new Font("Segoe UI", Font.BOLD, 14));
			mnDichVu.add(mntmQuanLiDichVu);

			JMenuItem mntnLapPhieuDichVu = new JMenuItem("Lập phiếu dịch vụ");
			mntnLapPhieuDichVu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pChinh.removeAll();
					pChinh.add(pLapPhieuDichVu);
					pChinh.repaint();
					pChinh.validate();
				}
			});
			mntnLapPhieuDichVu.setFont(new Font("Segoe UI", Font.BOLD, 14));
			mnDichVu.add(mntnLapPhieuDichVu);

			JMenu mnBoPhanKinhDoanh = new JMenu("          BỘ PHẬN KINH DOANH                   ");
			mnBoPhanKinhDoanh.setFont(new Font("Times New Roman", Font.BOLD, 16));
			menuBar.add(mnBoPhanKinhDoanh);

			Formxemthongtinkhachhang ttkh= new Formxemthongtinkhachhang();
			JMenuItem mntmTimKhachHang = new JMenuItem("Tìm khách hàng");
			mntmTimKhachHang.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pChinh.removeAll();
					pChinh.add(ttkh.ptimkhachhang);
					pChinh.repaint();
					pChinh.validate();
				}
			});
			mntmTimKhachHang.setFont(new Font("Segoe UI", Font.BOLD, 14));
			mnBoPhanKinhDoanh.add(mntmTimKhachHang);

			JMenuItem mntmXemPhong = new JMenuItem("Xem phòng");
			mntmXemPhong.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pChinh.removeAll();
					pChinh.add(pXemPhong);
					pChinh.repaint();
					pChinh.validate();
				}
			});
			mntmXemPhong.setFont(new Font("Segoe UI", Font.BOLD, 14));
			mnBoPhanKinhDoanh.add(mntmXemPhong);

			//FormQuanliphong qlp= new FormQuanliphong();
			FormQuanliphong qlp1 =new FormQuanliphong();
			JMenuItem mntmQuanLiPhong = new JMenuItem("Quản lí phòng");
			mntmQuanLiPhong.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pChinh.removeAll();
					pChinh.add(qlp1.pQuanliphong);
					pChinh.repaint();
					pChinh.validate();
				}
			});
			mntmQuanLiPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
			mnBoPhanKinhDoanh.add(mntmQuanLiPhong);

			FromThongke tk= new FromThongke();
			JMenuItem mntmThongKePhongTrong = new JMenuItem("Thống kê ");
			mntmThongKePhongTrong.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pChinh.removeAll();
					pChinh.add(tk.pthongke);
					pChinh.repaint();
					pChinh.validate();
				}
			});
			mntmThongKePhongTrong.setFont(new Font("Segoe UI", Font.BOLD, 14));
			mnBoPhanKinhDoanh.add(mntmThongKePhongTrong);

			JMenu mnKeToan = new JMenu("              KẾ TOÁN               ");
			mnKeToan.setFont(new Font("Times New Roman", Font.BOLD, 16));
			menuBar.add(mnKeToan);

			JMenu mnNewMenu_4 = new JMenu("               PHẬN NHÂN SỰ        ");

			javax.swing.JMenuItem menuItem = new javax.swing.JMenuItem("New menu item");
			mnKeToan.setFont(new Font("Times New Roman", Font.BOLD, 16));
			menuBar.add(mnKeToan);
			
			JMenuItem mntmTimHoaDon = new JMenuItem("Tìm hóa đơn");
			mntmTimHoaDon.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pChinh.removeAll();
					pChinh.add(kt.panKT);
					pChinh.repaint();
					pChinh.validate();
				}
			});
			mntmTimHoaDon.setFont(new Font("Segoe UI", Font.BOLD, 14));
			mnKeToan.add(mntmTimHoaDon);

			JMenuItem mntmThongKeDoanhThu = new JMenuItem("Thống kê doanh thu");
			mntmThongKeDoanhThu.setFont(new Font("Segoe UI", Font.BOLD, 14));
			mnKeToan.add(mntmThongKeDoanhThu);

			JMenuItem mntmXemThongTinHoaDon = new JMenuItem("Xem thông tin hóa đơn");
			mntmXemThongTinHoaDon.setFont(new Font("Segoe UI", Font.BOLD, 14));
			mnKeToan.add(mntmXemThongTinHoaDon);

			JMenu mnBoPhanNhanSu = new JMenu("          BỘ PHẬN NHÂN SỰ           ");
			mnBoPhanNhanSu.setFont(new Font("Times New Roman", Font.BOLD, 16));
			menuBar.add(mnBoPhanNhanSu);

			FormNhanSu ns = new FormNhanSu();

			JMenuItem mntmXemThongTinTaiKhoan = new JMenuItem("Xem thông tin tài khoản");
			mntmXemThongTinTaiKhoan.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pChinh.removeAll();
					pChinh.add(nv.panKT);
					pChinh.repaint();
					pChinh.validate();
				}
			});
			mntmXemThongTinTaiKhoan.setFont(new Font("Segoe UI", Font.BOLD, 14));
			mnBoPhanNhanSu.add(mntmXemThongTinTaiKhoan);

			JMenuItem mntmQuanLiTaiKhoan = new JMenuItem("Quản lí tài khoản");
			mntmQuanLiTaiKhoan.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pChinh.removeAll();
					pChinh.add(ns.contentPane);
					pChinh.repaint();
					pChinh.validate();
				}
			});
			mntmQuanLiTaiKhoan.setFont(new Font("Segoe UI", Font.BOLD, 14));
			mnBoPhanNhanSu.add(mntmQuanLiTaiKhoan);
			pQuanLiDichVu.setLayout(null);

			JScrollPane scrollPaneDichVu = new JScrollPane();
			scrollPaneDichVu.setBounds(726, 67, 360, 474);
			pQuanLiDichVu.add(scrollPaneDichVu);

			tableBangGia = new JTable();

			scrollPaneDichVu.setViewportView(tableBangGia);

			JLabel lblBangGia = new JLabel("Bảng giá dịch vụ của khách sạn");
			lblBangGia.setBounds(726, 10, 360, 40);
			pQuanLiDichVu.add(lblBangGia);
			lblBangGia.setForeground(new Color(244, 164, 96));
			lblBangGia.setFont(new Font("Times New Roman", Font.BOLD, 20));
			lblBangGia.setHorizontalAlignment(SwingConstants.CENTER);

			JPanel pThemDichVu = new JPanel();
			pThemDichVu.setBackground(new Color(204, 153, 255));
			pThemDichVu.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "D\u1ECBch v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pThemDichVu.setBounds(72, 67, 376, 228);
			pQuanLiDichVu.add(pThemDichVu);
			pThemDichVu.setLayout(null);

			JLabel lblGiaTien = new JLabel("Giá tiền");
			lblGiaTien.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblGiaTien.setBounds(10, 146, 101, 25);
			pThemDichVu.add(lblGiaTien);

			txtQLDV_TenDV = new JTextField();
			txtQLDV_TenDV.setBounds(121, 103, 182, 19);
			pThemDichVu.add(txtQLDV_TenDV);
			txtQLDV_TenDV.setColumns(10);

			txtQLDV_GiaTien = new JTextField();
			txtQLDV_GiaTien.setColumns(10);
			txtQLDV_GiaTien.setBounds(121, 150, 182, 19);
			pThemDichVu.add(txtQLDV_GiaTien);

			JLabel lblTenDichVu = new JLabel("Tên dịch vụ:");
			lblTenDichVu.setBounds(10, 99, 101, 25);
			pThemDichVu.add(lblTenDichVu);
			lblTenDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 14));

			JLabel lblMDchV = new JLabel("Mã dịch vụ:");
			lblMDchV.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblMDchV.setBounds(10, 45, 101, 25);
			pThemDichVu.add(lblMDchV);

			txtQLDV_MaDV = new JTextField();
			txtQLDV_MaDV.setEditable(false);
			txtQLDV_MaDV.setColumns(10);
			txtQLDV_MaDV.setBounds(121, 49, 182, 19);
			pThemDichVu.add(txtQLDV_MaDV);

			btnThemDV = new JButton("THÊM");
			btnThemDV.addActionListener(this);
			btnThemDV.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnThemDV.setBounds(553, 100, 105, 39);
			pQuanLiDichVu.add(btnThemDV);

			btnXoaDV = new JButton("XÓA");
			btnXoaDV.addActionListener(this);
			btnXoaDV.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnXoaDV.setBounds(553, 179, 105, 39);
			pQuanLiDichVu.add(btnXoaDV);

			btnSuaDV = new JButton("SỬA");
			btnSuaDV.addActionListener(this);

			btnSuaDV.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnSuaDV.setBounds(553, 252, 105, 43);
			pQuanLiDichVu.add(btnSuaDV);

			JLabel label_10 = new JLabel("");
			label_10.setIcon(new ImageIcon("C:\\Users\\Nguyen Duc Thien\\Pictures\\rsz_cac-dich-vu-trong-khach-san-4-5-sao-1.jpg"));
			label_10.setBounds(26, 323, 463, 218);
			pQuanLiDichVu.add(label_10);

			JButton btnQLDVXoaTrang = new JButton("XÓA TRẮNG");
			btnQLDVXoaTrang.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtQLDV_MaDV.setText("");
					txtQLDV_TenDV.setText("");
					txtQLDV_GiaTien.setText("");
				}
			});
			btnQLDVXoaTrang.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnQLDVXoaTrang.setBounds(540, 338, 140, 40);
			pQuanLiDichVu.add(btnQLDVXoaTrang);
			pThuePhong.setLayout(null);

			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "M\u1EABu thu\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(28, 37, 326, 426);
			pThuePhong.add(panel_1);
			panel_1.setLayout(null);

			JLabel lblMaPhongThue = new JLabel("Mã phòng:");
			lblMaPhongThue.setBounds(10, 167, 68, 17);
			panel_1.add(lblMaPhongThue);
			lblMaPhongThue.setFont(new Font("Tahoma", Font.PLAIN, 14));

			JLabel lblMaNVThue = new JLabel("Nhân viên:");
			lblMaNVThue.setBounds(10, 221, 90, 17);
			panel_1.add(lblMaNVThue);
			lblMaNVThue.setFont(new Font("Tahoma", Font.PLAIN, 14));

			JLabel lblNgayVao = new JLabel("Ngày vào:");
			lblNgayVao.setBounds(10, 282, 64, 17);
			panel_1.add(lblNgayVao);
			lblNgayVao.setFont(new Font("Tahoma", Font.PLAIN, 14));

			JLabel lblNgayRa = new JLabel("Ngày ra:");
			lblNgayRa.setBounds(10, 332, 54, 17);
			panel_1.add(lblNgayRa);
			lblNgayRa.setFont(new Font("Tahoma", Font.PLAIN, 14));

			JLabel lblDatCoc = new JLabel("Đặt cọc:");
			lblDatCoc.setBounds(10, 380, 53, 17);
			panel_1.add(lblDatCoc);
			lblDatCoc.setFont(new Font("Tahoma", Font.PLAIN, 14));

			JLabel lblMaKH = new JLabel("Mã khách hàng:");
			lblMaKH.setBounds(10, 104, 101, 17);
			panel_1.add(lblMaKH);
			lblMaKH.setFont(new Font("Tahoma", Font.PLAIN, 14));

			txtMaKH = new JTextField();
			txtMaKH.setEditable(false);
			txtMaKH.setBounds(127, 105, 175, 19);
			panel_1.add(txtMaKH);
			txtMaKH.setColumns(10);

			txtDatCoc = new JTextField();
			txtDatCoc.setBounds(127, 381, 175, 19);
			panel_1.add(txtDatCoc);
			txtDatCoc.setColumns(10);

			cbThuePhong_MaPhong = new JComboBox();
			cbThuePhong_MaPhong.setBounds(234, 167, 68, 21);
			panel_1.add(cbThuePhong_MaPhong);

			JLabel lblMThuePhong = new JLabel("Mã thuê:");
			lblMThuePhong.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblMThuePhong.setBounds(10, 42, 101, 17);
			panel_1.add(lblMThuePhong);

			txtMaThuePhong = new JTextField();
			txtMaThuePhong.setEditable(false);
			txtMaThuePhong.setColumns(10);
			txtMaThuePhong.setBounds(127, 43, 175, 19);
			panel_1.add(txtMaThuePhong);

			txtNgayVao = new JDateChooser();
			txtNgayVao.getCalendarButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			txtNgayVao.setBounds(127, 280, 175, 19);
			panel_1.add(txtNgayVao);

			txtNgayRa = new JDateChooser();
			txtNgayRa.setBounds(127, 332, 175, 19);
			panel_1.add(txtNgayRa);

			cbTenNV = new JComboBox();
			cbTenNV.setBounds(127, 221, 175, 19);
			panel_1.add(cbTenNV);

			cbLoaiPhong = new JComboBox();
			cbLoaiPhong.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					loadComboDSPhongTrongTheoLoai();
				}
			});
			cbLoaiPhong.setBounds(127, 167, 97, 21);
			panel_1.add(cbLoaiPhong);

			JPanel panelThuePhong = new JPanel();
			panelThuePhong.setBackground(new Color(128, 128, 0));
			panelThuePhong.setBounds(529, 14, 1, 1);
			pThuePhong.add(panelThuePhong);
			panelThuePhong.setLayout(null);

			JLabel lblThuePhong = new JLabel("THUÊ PHÒNG");
			lblThuePhong.setBackground(Color.MAGENTA);
			lblThuePhong.setBounds(0, 0, 1134, 54);
			panelThuePhong.add(lblThuePhong);
			lblThuePhong.setForeground(new Color(135, 206, 250));
			lblThuePhong.setHorizontalAlignment(SwingConstants.CENTER);
			lblThuePhong.setFont(new Font("Times New Roman", Font.BOLD, 30));

			JScrollPane scrollPaneDSThue = new JScrollPane();
			scrollPaneDSThue.setBounds(429, 63, 705, 402);
			pThuePhong.add(scrollPaneDSThue);

			tableDSThuePhong = new JTable();

			scrollPaneDSThue.setViewportView(tableDSThuePhong);

			JLabel lblDanhSchPhng = new JLabel("Danh sách phòng khách hàng thuê");
			lblDanhSchPhng.setHorizontalAlignment(SwingConstants.CENTER);
			lblDanhSchPhng.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblDanhSchPhng.setBounds(429, 14, 705, 36);
			pThuePhong.add(lblDanhSchPhng);

			btnThuePhong = new JButton("THUÊ PHÒNG");
			btnThuePhong.addActionListener(this);
			btnThuePhong.setBackground(Color.DARK_GRAY);
			btnThuePhong.setForeground(Color.ORANGE);
			btnThuePhong.setFont(new Font("Times New Roman", Font.BOLD, 20));
			btnThuePhong.setBounds(28, 487, 201, 40);
			pThuePhong.add(btnThuePhong);

			btnThueDichVu = new JButton("+ THUÊ DICH VỤ");
			btnThueDichVu.addActionListener(this);
			btnThueDichVu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pChinh.removeAll();
					pChinh.add(pLapPhieuDichVu);
					pChinh.repaint();
					pChinh.validate();
				}
			});
			btnThueDichVu.setForeground(Color.RED);
			btnThueDichVu.setFont(new Font("Tahoma", Font.BOLD, 20));
			btnThueDichVu.setBounds(893, 504, 222, 37);
			pThuePhong.add(btnThueDichVu);

			JButton btnXoaTrangThuePhong = new JButton("XÓA TRẮNG");
			btnXoaTrangThuePhong.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtMaThuePhong.setText("");
					txtMaKH.setText("");
					//txtMaNV.setText("");
					txtDatCoc.setText("");
					//txtNgayVao.setText("");
					//txtNgayRa.setText("");
					txtDatCoc.setText("");
				}
			});
			btnXoaTrangThuePhong.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnXoaTrangThuePhong.setBounds(253, 487, 145, 40);
			pThuePhong.add(btnXoaTrangThuePhong);

			JButton btnNewButton = new JButton("SỬA PHÒNG");
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnNewButton.setBounds(454, 487, 150, 40);
			pThuePhong.add(btnNewButton);
			pLapHoaDon.setLayout(null);

			//Lập hóa đơn

			JScrollPane scrollPaneLapHoaDon = new JScrollPane();
			scrollPaneLapHoaDon.setBounds(10, 73, 1124, 411);
			pLapHoaDon.add(scrollPaneLapHoaDon);

			tableLapHoaDon = new JTable();

			scrollPaneLapHoaDon.setViewportView(tableLapHoaDon);

			btnLapHoaDon = new JButton("LẬP HÓA ĐƠN THANH TOÁN");
			btnLapHoaDon.addActionListener(this);
			btnLapHoaDon.setForeground(new Color(230, 230, 250));
			btnLapHoaDon.setBackground(new Color(0, 0, 255));
			btnLapHoaDon.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnLapHoaDon.setBounds(440, 505, 296, 36);
			pLapHoaDon.add(btnLapHoaDon);

			JPanel panelLapHoaDon = new JPanel();
			panelLapHoaDon.setBackground(new Color(112, 128, 144));
			panelLapHoaDon.setBounds(931, 217, 1, 1);
			pLapHoaDon.add(panelLapHoaDon);
			panelLapHoaDon.setLayout(null);

			JLabel lblLapHoaDon = new JLabel("Danh sách phòng thuê");
			lblLapHoaDon.setBounds(10, 10, 1124, 53);
			pLapHoaDon.add(lblLapHoaDon);
			lblLapHoaDon.setForeground(new Color(65, 105, 225));
			lblLapHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
			lblLapHoaDon.setFont(new Font("Times New Roman", Font.BOLD, 30));

			JLabel lblMThu = new JLabel("Mã thuê");
			lblMThu.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblMThu.setBounds(10, 511, 88, 24);
			pLapHoaDon.add(lblMThu);

			txtLapPhieuThueMa = new JTextField();
			txtLapPhieuThueMa.setFont(new Font("Tahoma", Font.BOLD, 10));
			txtLapPhieuThueMa.setEditable(false);
			txtLapPhieuThueMa.setBounds(108, 505, 114, 30);
			pLapHoaDon.add(txtLapPhieuThueMa);
			txtLapPhieuThueMa.setColumns(10);

			btnThuePhongTuDSKH = new JButton("+ THUÊ PHÒNG");
			btnThuePhongTuDSKH.addActionListener(this);
			btnThuePhongTuDSKH.setForeground(Color.RED);
			btnThuePhongTuDSKH.setFont(new Font("Tahoma", Font.BOLD, 20));
			btnThuePhongTuDSKH.setBounds(930, 502, 204, 39);
			pQuanLiKhachHang.add(btnThuePhongTuDSKH);

			JLabel label_11 = new JLabel("");
			label_11.setIcon(new ImageIcon("C:\\Users\\Nguyen Duc Thien\\Downloads\\rsz_dos-donts-customer-og.jpg"));
			label_11.setBounds(10, 10, 383, 140);
			pQuanLiKhachHang.add(label_11);

			JButton btnQLKH_Xoatrang = new JButton("XÓA TRẮNG ");
			btnQLKH_Xoatrang.setBounds(731, 502, 144, 36);
			pQuanLiKhachHang.add(btnQLKH_Xoatrang);
			btnQLKH_Xoatrang.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtQLKH_tenKH.setText("");
					txtQLKH_MaKH.setText("");
					txtQLKH_DiaChiKH.setText("");
					txtQLKH_sdtKH.setText("");
					txtCMND.setText("");
					txtGhiChu.setText("");
				}
			});
			btnQLKH_Xoatrang.setFont(new Font("Tahoma", Font.BOLD, 15));

			JButton btnQLKH_sua = new JButton("SỬA");
			btnQLKH_sua.setBounds(596, 502, 88, 36);
			pQuanLiKhachHang.add(btnQLKH_sua);
			btnQLKH_sua.setFont(new Font("Tahoma", Font.BOLD, 15));

			btnQLKHThemKH = new JButton("THÊM");
			btnQLKHThemKH.setBounds(435, 502, 100, 34);
			pQuanLiKhachHang.add(btnQLKHThemKH);
			btnQLKHThemKH.addActionListener(this);
			btnQLKHThemKH.setFont(new Font("Tahoma", Font.BOLD, 20));
			btnQLKHThemKH.setBackground(Color.BLUE);
			btnQLKHThemKH.setForeground(Color.WHITE);

			loadDataDSKHThuePhong();
			loadDataDSPhong();
			loadDataDSThuePhong();
			loadDataDSDichVu();
			loadDataDSKHThueDichVu();
			loadDataMaLapHoaDon();
			loadComboDSNV();
			loadComboDSTheoTenLoai();
		}

		public void loadDataDSPhong()
		{
			try {
				Connect a = new Connect();
				Connection  conn= a.getConnect();
				int number;
				Vector row;
				String []column = {"Mã phòng","Mã loại","Tên phòng","Diện tích","Giá thuê"};
				java.sql.Statement st= conn.createStatement();
				ResultSet rs= st.executeQuery("select * from Phong");
				ResultSetMetaData metadata= rs.getMetaData();
				number= metadata.getColumnCount();
				tableModelDSPhong.setColumnIdentifiers(column);
				while(rs.next())
				{
					row = new Vector();
					for(int i = 1; i<= number; i++)
					{
						row.addElement(rs.getString(i));
					}
					tableModelDSPhong.addRow(row);
					tableDSPhong.setModel(tableModelDSPhong);
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		public void loadDataDSThuePhong()
		{
			try {
				Connect a = new Connect();
				Connection  conn= a.getConnect();
				int number;
				Vector row;
				java.sql.Statement st= conn.createStatement();
				ResultSet rs= st.executeQuery("select * from ThuePhong");
				ResultSetMetaData metadata= rs.getMetaData();
				number= metadata.getColumnCount();
				String column[] = {"Mã thuê","Mã khách hàng","Mã phòng","Mã nhân viên","Ngày vao","Ngày ra","Đặt cọc"};
				tableModelThuePhong.setColumnIdentifiers(column);
				while(rs.next())
				{
					row = new Vector();
					for(int i = 1; i<= number; i++)
					{
						row.addElement(rs.getString(i));
					}
					tableModelThuePhong.addRow(row);

					tableLapHoaDon.setModel(tableModelThuePhong);
					tableDSThuePhong.setModel(tableModelThuePhong);
				}
				tableDSThuePhong.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent e) {
						if(tableDSThuePhong.getSelectedRow() >=0)
						{	
							txtMaThuePhong.setText(tableDSThuePhong.getValueAt(tableDSThuePhong.getSelectedRow(), 0) + "");
							txtMaKH.setText(tableDSThuePhong.getValueAt(tableDSThuePhong.getSelectedRow(), 1) + "");
							cbThuePhong_MaPhong.setSelectedItem(tableDSThuePhong.getModel().getValueAt(tableDSThuePhong.getSelectedRow(), 2) + "");
							cbTenNV.setSelectedItem(tableDSThuePhong.getModel().getValueAt(tableDSThuePhong.getSelectedRow(), 3) + "");
							int index= tableDSThuePhong.getSelectedRow();
							try {
								java.util.Date dateIn = new SimpleDateFormat("yyyy-MM-dd").parse((String)tableModelThuePhong.getValueAt(index, 4));
								txtNgayVao.setDate(dateIn);
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							try {
								java.util.Date dateOut = new SimpleDateFormat("yyyy-MM-dd").parse((String)tableModelThuePhong.getValueAt(index, 5));
								txtNgayRa.setDate(dateOut);
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							txtDatCoc.setText(tableDSThuePhong.getValueAt(tableDSThuePhong.getSelectedRow(), 6) + "");
						}
					}
				});
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		public void loadDataDSDichVu()
		{
			try {
				Connect a = new Connect();
				Connection  conn= a.getConnect();
				int number;
				Vector row;
				String column[]= {"Mã dịch vụ","Tên dịch vụ","Giá tiền"}; 
				java.sql.Statement st= conn.createStatement();
				ResultSet rs= st.executeQuery("select * from DichVu");
				ResultSetMetaData metadata= rs.getMetaData();
				number= metadata.getColumnCount();
				tableModelDichVu.setColumnIdentifiers(column);
				while(rs.next())
				{
					row = new Vector();
					for(int i = 1; i<= number; i++)
					{
						row.addElement(rs.getString(i));
					}
					tableModelDichVu.addRow(row);

					tableDSDichVuThue.setModel(tableModelDichVu);
					tableBangGia.setModel(tableModelDichVu);
				}

				tableBangGia.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						if(tableBangGia.getSelectedRow() >=0)
						{
							txtQLDV_MaDV.setText(tableBangGia.getValueAt(tableBangGia.getSelectedRow(), 0) + "");
							txtQLDV_TenDV.setText(tableBangGia.getValueAt(tableBangGia.getSelectedRow(), 1) + "");
							txtQLDV_GiaTien.setText(tableBangGia.getValueAt(tableBangGia.getSelectedRow(), 2) + "");			
						}
					}
				});
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		public void loadDataDSKHThueDichVu()
		{
			try {
				Connect a = new Connect();
				Connection  conn= a.getConnect();
				int number;
				Vector row;
				String column[]= {"Mã sử dụng","Mã thuê","Mã dịch vụ","Ngày sử dụng","Số lượng"};
				java.sql.Statement st= conn.createStatement();
				ResultSet rs= st.executeQuery("select * from SuDungDichVu");
				ResultSetMetaData metadata= rs.getMetaData();
				number= metadata.getColumnCount();
				tableModelDSKHThueDV.setColumnIdentifiers(column);
				while(rs.next())
				{
					row = new Vector();
					for(int i = 1; i<= number; i++)
					{
						row.addElement(rs.getString(i));
					}
					tableModelDSKHThueDV.addRow(row);

					tableDSKHThueDV.setModel(tableModelDSKHThueDV);
				}
				tableDSKHThueDV.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						if(tableDSKHThueDV.getSelectedRow() >=0)
						{
							txtMaSuDung.setText(tableDSKHThueDV.getValueAt(tableDSKHThueDV.getSelectedRow(), 0) + "");
							txtMaThue.setText(tableDSKHThueDV.getValueAt(tableDSKHThueDV.getSelectedRow(), 1) + "");
							txtMaDV.setText(tableDSKHThueDV.getValueAt(tableDSKHThueDV.getSelectedRow(), 2) + "");

							int inde= tableDSKHThueDV.getSelectedRow();
							try {
								java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)tableModelDSKHThueDV.getValueAt(inde, 3));
								txtNgaySD.setDate(date);
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							txtSoLuong.setText(tableDSKHThueDV.getValueAt(tableDSKHThueDV.getSelectedRow(), 4) + "");
						}
					}
				});
				tableDSDichVuThue.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						if(tableDSDichVuThue.getSelectedRow() >=0)
						{
							txtMaDV.setText(tableDSDichVuThue.getValueAt(tableDSDichVuThue.getSelectedRow(), 0) + "");
						}
					}
				});	
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		public void  loadComboDSTheoTenLoai()
		{
			try {
				Connect a= new Connect();
				Connection conn= a.getConnect();
				PreparedStatement st= conn.prepareStatement("select distinct [tenLoai]\r\n" + 
						"from [dbo].[Phong] p join [dbo].[LoaiPhong] lp on lp.[maLoai]=p.[maLoai]");
				ResultSet rs= st.executeQuery();
				while(rs.next())
				{
					cbLoaiPhong.addItem(rs.getString("tenLoai"));
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		public void  loadComboDSPhongTrongTheoLoai()
		{
			String ab= cbLoaiPhong.getSelectedItem().toString();
			try {
				Connect a= new Connect();
				Connection conn= a.getConnect();
				PreparedStatement st= conn.prepareStatement("select distinct p.[maPhong] \r\n" + 
						"from Phong p left join ThuePhong tp on p.maPhong=tp.maPhong\r\n" + 
						"	join [dbo].[LoaiPhong] lp on lp.maLoai=p.maLoai\r\n" + 
						"where tp.maPhong is null and [tenLoai] like '" +ab+"'"+
						"group by p.[maPhong]");
				ResultSet rs= st.executeQuery();
				cbThuePhong_MaPhong.removeAllItems();
				while(rs.next())
				{
					cbThuePhong_MaPhong.addItem(rs.getString("maPhong"));
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		public void loadDataDSPhongTrong()
		{
			try {
				Connect a = new Connect();
				Connection  conn= a.getConnect();
				int number;
				Vector row;
				String column[]= {"Mã phòng","Mã loại","Tên phòng","Diện tích","Giá thuê"};
				java.sql.Statement st= conn.createStatement();
				ResultSet rs= st.executeQuery("select p.maPhong,tenPhong,dienTich,giaThue\r\n" + 
						"from ThuePhong tp right join Phong p on tp.maPhong=p.maPhong\r\n" + 
						"where tp.maPhong is null");
				ResultSetMetaData metadata= rs.getMetaData();
				number= metadata.getColumnCount();
				tableModelDSPhongTrong.setColumnIdentifiers(column);
				while(rs.next())
				{
					row = new Vector();
					for(int i = 1; i<= number; i++)
					{
						row.addElement(rs.getString(i));
					}
					tableModelDSPhongTrong.addRow(row);
					tableDSPhong.setModel(tableModelDSPhongTrong);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		public void loadDataDSPhongDaThue()
		{
			try {
				Connect a = new Connect();
				Connection  conn= a.getConnect();
				int number;
				Vector row;
				String column[]= {"Mã phòng","Mã loại","Tên phòng","Diện tích","Giá thuê"};
				java.sql.Statement st= conn.createStatement();
				ResultSet rs= st.executeQuery("select p.maPhong,tenPhong,dienTich,giaThue\r\n" + 
						"from ThuePhong tp right join Phong p on tp.maPhong=p.maPhong\r\n" + 
						"where tp.maPhong is not null");
				ResultSetMetaData metadata= rs.getMetaData();
				number= metadata.getColumnCount();
				tableModelDSPhongDaThue.setColumnIdentifiers(column);
				while(rs.next())
				{
					row = new Vector();
					for(int i = 1; i<= number; i++)
					{
						row.addElement(rs.getString(i));
					}
					tableModelDSPhongDaThue.addRow(row);

					tableDSPhong.setModel(tableModelDSPhongDaThue);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		public void loadDataDSPhongDon()
		{
			try {
				Connect a = new Connect();
				Connection  conn= a.getConnect();
				int number;
				Vector row;
				String column[]= {"Mã phòng","Mã loại","Tên phòng","Diện tích","Giá thuê"};
				java.sql.Statement st= conn.createStatement();
				ResultSet rs= st.executeQuery("select * from Phong where  maLoai ='LP1'");
				ResultSetMetaData metadata= rs.getMetaData();
				number= metadata.getColumnCount();
				tableModelDSPhongDon.setColumnIdentifiers(column);
				while(rs.next())
				{
					row = new Vector();
					for(int i = 1; i<= number; i++)
					{
						row.addElement(rs.getString(i));
					}
					tableModelDSPhongDon.addRow(row);

					tableDSPhong.setModel(tableModelDSPhongDon);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		public void loadDataDSPhongDoi()
		{
			try {
				Connect a = new Connect();
				Connection  conn= a.getConnect();
				int number;
				Vector row;
				String column[]= {"Mã phòng","Mã loại","Tên phòng","Diện tích","Giá thuê"};
				java.sql.Statement st= conn.createStatement();
				ResultSet rs= st.executeQuery("select * from Phong where  maLoai ='LP2'");
				ResultSetMetaData metadata= rs.getMetaData();
				number= metadata.getColumnCount();
				tableModelDSPhongDoi.setColumnIdentifiers(column);
				while(rs.next())
				{
					row = new Vector();
					for(int i = 1; i<= number; i++)
					{
						row.addElement(rs.getString(i));
					}
					tableModelDSPhongDoi.addRow(row);

					tableDSPhong.setModel(tableModelDSPhongDoi);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		public void loadDataDSPhongTapThe()
		{
			try {
				Connect a = new Connect();
				Connection  conn= a.getConnect();
				int number;
				Vector row;
				String column[]= {"Mã phòng","Mã loại","Tên phòng","Diện tích","Giá thuê"};
				java.sql.Statement st= conn.createStatement();
				ResultSet rs= st.executeQuery("select * from Phong where  maLoai ='LP3'");
				ResultSetMetaData metadata= rs.getMetaData();
				number= metadata.getColumnCount();
				tableModelDSPhongTapThe.setColumnIdentifiers(column);
				while(rs.next())
				{
					row = new Vector();
					for(int i = 1; i<= number; i++)
					{
						row.addElement(rs.getString(i));
					}
					tableModelDSPhongTapThe.addRow(row);

					tableDSPhong.setModel(tableModelDSPhongTapThe);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		public void loadDataMaLapHoaDon()
		{
			FormThanhToan tt = new FormThanhToan();
			try {
				Connect a = new Connect();
				Connection  conn= a.getConnect();
				tableLapHoaDon.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent e) {
						if(tableLapHoaDon.getSelectedRow() >=0)
						{
							txtLapPhieuThueMa.setText(tableLapHoaDon.getValueAt(tableLapHoaDon.getSelectedRow(), 0) + "");
						}
					}
				});	
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		public double TongTien(String maThue) {
			double tongtien = 0 ;
			FormThanhToan tt = new FormThanhToan();
			try {
				Connect a= new Connect();
				Connection con= a.getConnect();
				String sql = "TinhTong ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, txtLapPhieuThueMa.getText());
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					tongtien = rs.getDouble(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return tongtien;
		}
		
		public void  loadComboDSNV()
		{
			try {
				Connect a= new Connect();
				Connection conn= a.getConnect();
				PreparedStatement st= conn.prepareStatement("select distinct [maNhanVien]\r\n" + 
						"from [dbo].[NhanVien]");
				ResultSet rs= st.executeQuery();
				while(rs.next())
				{
					cbTenNV.addItem(rs.getString("maNhanVien"));
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		public boolean KiemTraThemKH()
		{
			String ten=txtQLKH_tenKH.getText().trim();
			String sdt= txtQLKH_sdtKH.getText();
			if(ten.equals("")  || sdt.equals(""))
			{
				JOptionPane.showMessageDialog(this,"Vui lòng nhập đầy đủ thuộc tính !");
			}
			if(!ten.matches("[^0-9]+"))
			{
				JOptionPane.showMessageDialog(this, "Tên không bao gồm số vầ kí tự đặc biệt");
				return false;
			}
			if(!sdt.matches("^0+[1-9]+[0-9]{8}"))
			{
				JOptionPane.showMessageDialog(this,"Số điện thoại gồm 10 số và bắt đầu là 0");
				return false;
			}
			return true;
		}
		//	public boolean KiemTra
		
		public void XoaSauTT()
		{
			try {
				Connect a= new Connect();
				Connection con= a.getConnect();
				PreparedStatement ps = con.prepareStatement("delete [dbo].[ThuePhong] where [maThue]=?");
				ps.setString(1, tableLapHoaDon.getValueAt(tableLapHoaDon.getSelectedRow(),0).toString());
				if(JOptionPane.showConfirmDialog(this,"Bạn chắc có muốn xóa ?","Confirm",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
				{
					ps.executeUpdate();
					tableModelThuePhong.setRowCount(0);
					loadDataDSThuePhong();
				}

			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Dịch vụ đang được sử dụng nên không thể xóa !");
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object ob= e.getSource();
			if(btnQLKHThemKH.equals(ob))
			{
				Random rd= new Random();
				int b= rd.nextInt(500);
				String maKH= "KH-"+b;
				if(KiemTraThemKH()==true)
				{
					try {
						Connect a= new Connect();
						Connection con= a.getConnect();
						PreparedStatement ps = con.prepareStatement("insert into KhachHang values(?,?,?,?,?,?)");
						ps.setString(1,maKH);
						ps.setString(2, txtQLKH_tenKH.getText());
						ps.setString(3, txtQLKH_DiaChiKH.getText());
						ps.setString(4, txtQLKH_sdtKH.getText());
						ps.setString(5, txtCMND.getText());
						ps.setString(6, txtGhiChu.getText());
						int ck= ps.executeUpdate();
						if(ck >0 )
						{
							JOptionPane.showMessageDialog(this, "Thêm thành công !");
							tableModelDSKH.setRowCount(0);
							loadDataDSKHThuePhong();
						}
					} catch (Exception e2) {
						System.out.println("Cần nhập đủ thông tin Khách hàng !");
					}
				}
			}
			else if(btnThemDV.equals(ob))
			{
				Connect a= new Connect();
				Connection con= a.getConnect();
				Random rd= new Random();
				int b= rd.nextInt(100);
				String maDV= "DV-"+b;
				try {

					PreparedStatement ps = con.prepareStatement("insert into DichVu values(?,?,?)");
					ps.setString(1, maDV);
					ps.setString(2, txtQLDV_TenDV.getText());
					ps.setString(3, txtQLDV_GiaTien.getText());
					int ck= ps.executeUpdate();
					if(ck >0 )
					{
						JOptionPane.showMessageDialog(this, "Thêm thành công !");
						tableModelDichVu.setRowCount(0);
						loadDataDSDichVu();
					}
				}
				catch (Exception e2) {
				}
			}
			else if(btnThuePhongTuDSKH.equals(ob))
			{
				pChinh.removeAll();
				pChinh.add(pThuePhong);
				pChinh.repaint();
				pChinh.validate();
				txtMaKH.setText(txtQLKH_MaKH.getText());	
			}
			else if (btnThuePhong.equals(ob))
			{
				Random rd= new Random();
				int b= rd.nextInt(500);
				String maThue= "TP-"+b;
				try {
					Connect a= new Connect();
					Connection con= a.getConnect();
					PreparedStatement ps = con.prepareStatement("insert into ThuePhong values(?,?,?,?,?,?,?)");
					ps.setString(1, maThue);
					ps.setString(2, txtMaKH.getText());
					ps.setString(3, cbThuePhong_MaPhong.getSelectedItem().toString());
					ps.setString(4, cbTenNV.getSelectedItem().toString());

					SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
					String date= sdf.format(txtNgayVao.getDate());
					String dateOut= sdf.format(txtNgayRa.getDate());

					ps.setString(5, date);
					ps.setString(6, dateOut);
					ps.setString(7, txtDatCoc.getText());
					int ck= ps.executeUpdate();
					if(ck >0 )
					{
						JOptionPane.showMessageDialog(this, "Thêm thành công !");
						tableModelThuePhong.setRowCount(0);
						loadDataDSThuePhong();

					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ dữ liệu !");
				}
				//loadComboDSPhongTrongTheoLoai();
			}
			else if(btnSuaDV.equals(ob))
			{
				try {
					Connect a= new Connect();
					Connection con= a.getConnect();
					PreparedStatement ps = con.prepareStatement("update DichVu set tenDichVu=?,giaTien=? where maDichVu=?");
					ps.setString(1, txtQLDV_TenDV.getText());
					ps.setString(2, txtQLDV_GiaTien.getText());
					ps.setString(3, txtQLDV_MaDV.getText());			
					int ck=ps.executeUpdate();
					if(ck >0 )
					{
						JOptionPane.showMessageDialog(this, "Sửa thành công !");
						tableModelDichVu.setRowCount(0);
						loadDataDSDichVu();
					}
					tableModelDichVu.setRowCount(0);
					loadDataDSDichVu();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			else if(btnXoaDV.equals(ob))
			{
				try {
					Connect a= new Connect();
					Connection con= a.getConnect();
					PreparedStatement ps = con.prepareStatement("delete DichVu where maDichVu=?");
					ps.setString(1, tableBangGia.getValueAt(tableBangGia.getSelectedRow(),0).toString());
					if(JOptionPane.showConfirmDialog(this,"Bạn chắc có muốn xóa ?","Confirm",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
					{
						ps.executeUpdate();
						tableModelDichVu.setRowCount(0);
						loadDataDSDichVu();
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Dịch vụ đang được sử dụng nên không thể xóa !");
				}
			}
			else if(btnThueDichVu.equals(ob))
			{
				pChinh.removeAll();
				pChinh.add(pLapPhieuDichVu);
				pChinh.repaint();
				pChinh.validate();
				txtMaThue.setText(txtMaThuePhong.getText());
			}
			else if(btnThueDV.equals(ob))	
			{
				Random rd= new Random();
				int b= rd.nextInt(500);
				String maSDDV= "SDDV"+b;
				try {
					Connect a= new Connect();
					Connection con= a.getConnect();
					PreparedStatement ps = con.prepareStatement("insert SuDungDichVu values(?,?,?,?,?)");

					ps.setString(1, maSDDV);
					ps.setString(2, txtMaThue.getText());
					ps.setString(3, txtMaDV.getText());

					SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
					String date= sdf.format(txtNgaySD.getDate());

					ps.setString(4, date);
					ps.setString(5, txtSoLuong.getText());
					int ck= ps.executeUpdate();
					if(ck >0 )
					{
						JOptionPane.showMessageDialog(this, "Thêm thành công !");
						tableModelDSKHThueDV.setRowCount(0);
						loadDataDSKHThueDichVu();
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Thêm thất bại !");
				}
			}
			else if(btnLapHoaDon.equals(ob))
			{
				XoaSauTT();
//				if(tableLapHoaDon.getSelectedRow() >=0)
//				{
//					FormThanhToan tt= new FormThanhToan();
//					tt.setVisible(true);
//					tt.txtMaThueTT.setText(tableLapHoaDon.getValueAt(tableLapHoaDon.getSelectedRow(), 0) + "");
//					double tien=TongTien(txtLapPhieuThueMa.getText());
//					tt.txtThanhTien.setText(tien+"");
//
//				}
//				else JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng trước khi thanh toán !"); 	
			}
		}}

	/////////////























