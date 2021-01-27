package GiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Data.Connect;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.TextArea;
import com.toedter.calendar.JDateChooser;

public class FormThanhToan extends JFrame implements ActionListener {

	private JPanel contentPane;
	public JTextField txtThanhTien;
	public JTextField txtMaThueTT;
	FormGiaoDien fgd;
	public JDateChooser txtNgayThanhToan;
	
	public JButton btnHoanTac,btnThanhToan;
	private DefaultTableModel tableModeThanhToan = new DefaultTableModel();
	
	public DefaultTableModel tbmodel = new DefaultTableModel();
	private JComboBox<String> cbHinhThucTra;
	private JTextArea txtGhiChu;


	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormThanhToan frame = new FormThanhToan();
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
	public FormThanhToan() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 655);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblM = new JLabel("Mã thuê:");
		lblM.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblM.setBounds(36, 75, 105, 28);
		contentPane.add(lblM);
		
		JLabel lblThanhTien = new JLabel("Tổng tiền:");
		lblThanhTien.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThanhTien.setBounds(36, 421, 105, 28);
		contentPane.add(lblThanhTien);
		
		JLabel lblGhiCh = new JLabel("Ghi chú: ");
		lblGhiCh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGhiCh.setBounds(36, 229, 105, 34);
		contentPane.add(lblGhiCh);
		
		JLabel lblHinhThucTra = new JLabel("Hình thức trả:");
		lblHinhThucTra.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHinhThucTra.setBounds(36, 179, 131, 28);
		contentPane.add(lblHinhThucTra);
		
		JLabel lblNgyThanhTon = new JLabel("Ngày thanh toán:");
		lblNgyThanhTon.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNgyThanhTon.setBounds(36, 126, 148, 28);
		contentPane.add(lblNgyThanhTon);
		
		JLabel lblNewLabel = new JLabel("PHIẾU THANH TOÁN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 10, 436, 40);
		contentPane.add(lblNewLabel);
		
		btnThanhToan = new JButton("Thanh Toán");
		btnThanhToan.addActionListener(this);
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnThanhToan.setBounds(16, 519, 168, 46);
		contentPane.add(btnThanhToan);
		
		btnHoanTac = new JButton("Hoàn tác");
		btnHoanTac.addActionListener(this);
		btnHoanTac.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnHoanTac.setBounds(222, 519, 168, 46);
		contentPane.add(btnHoanTac);
		
		txtThanhTien = new JTextField();
		txtThanhTien.setEditable(false);
		txtThanhTien.setColumns(10);
		txtThanhTien.setBounds(209, 425, 196, 26);
		contentPane.add(txtThanhTien);
		
		txtMaThueTT = new JTextField();
		txtMaThueTT.setEditable(false);
		
		txtMaThueTT.setColumns(10);
		txtMaThueTT.setBounds(209, 79, 196, 26);
		contentPane.add(txtMaThueTT);
		
		cbHinhThucTra = new JComboBox();
		cbHinhThucTra.setBounds(209, 181, 195, 28);
		contentPane.add(cbHinhThucTra);
		
		txtNgayThanhToan = new JDateChooser();
		txtNgayThanhToan.setBounds(209, 126, 196, 34);
		contentPane.add(txtNgayThanhToan);
		
		txtGhiChu = new JTextArea();
		txtGhiChu.setBounds(209, 227, 196, 150);
		contentPane.add(txtGhiChu);
		
		
		loadComboHinhThucThanhToan();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(btnHoanTac.equals(obj))
		{
			this.dispose();
		}
		else if(btnThanhToan.equals(obj))
		{
			try {
				
				Connect a= new Connect();
				Connection con= a.getConnect();
				PreparedStatement ps = con.prepareStatement("insert into ThanhToan values(?,?,?,?,?)");
				ps.setString(1, txtMaThueTT.getText());
				ps.setString(2, txtThanhTien.getText());
				ps.setString(3, cbHinhThucTra.getSelectedItem().toString());
				ps.setString(4, txtGhiChu.getText());
				
				SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
				String date= sdf.format(txtNgayThanhToan.getDate());
				
				ps.setString(5, date);	
				
				int ck= ps.executeUpdate();
				if(JOptionPane.showConfirmDialog(this,"Bạn có muốn in in hóa đơn không ?","Confirm",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
				{
					JOptionPane.showMessageDialog(this,"Thanh toán Thành công - In hóa đơn !");
				}
				else JOptionPane.showMessageDialog(this,"Thanh toán Thành công - Không in hóa đơn !");
				
				fgd.XoaSauTT();
				this.dispose();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Bạn vui lòng nhập đầy đủ thông tin !");
			}
		}	
	}
	public void  loadComboHinhThucThanhToan()
	{
		try {
			Connect a= new Connect();
			Connection conn= a.getConnect();
			PreparedStatement st= conn.prepareStatement("select distinct [hinhThucThanhToan] from [dbo].[ThanhToan]");
			ResultSet rs= st.executeQuery();
			while(rs.next())
			{
				cbHinhThucTra.addItem(rs.getString("hinhThucThanhToan"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}

























