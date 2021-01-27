package GiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import danhsachs.Danhsachthongtinphong;
import entitis.Phong;
import entitis.Thongtinphong;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FormthongkePhongtrong extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtphongcokhach;
	private JTextField txtphongtrong;
	private JTextField txttongtienthu;
	private JButton btnthoat;
	private static List<Thongtinphong> list;
	private static Danhsachthongtinphong tt = new Danhsachthongtinphong();
	private JTextField txttongsophong;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormthongkePhongtrong frame = new FormthongkePhongtrong();
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
	public FormthongkePhongtrong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 588, 421);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblThngK = new JLabel("THỐNG KÊ PHÒNG");
		lblThngK.setForeground(Color.RED);
		lblThngK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThngK.setBounds(214, 27, 176, 30);
		contentPane.add(lblThngK);
		
		JLabel lblPhngangC = new JLabel("Phòng đang có khách:");
		lblPhngangC.setForeground(new Color(0, 0, 255));
		lblPhngangC.setBackground(new Color(173, 216, 230));
		lblPhngangC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPhngangC.setBounds(26, 133, 131, 21);
		contentPane.add(lblPhngangC);
		
		txtphongcokhach = new JTextField();
		txtphongcokhach.setForeground(new Color(255, 0, 0));
		txtphongcokhach.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtphongcokhach.setEditable(false);
		txtphongcokhach.setBounds(167, 133, 71, 20);
		contentPane.add(txtphongcokhach);
		txtphongcokhach.setColumns(10);
		
		JLabel lblPhngCnTrng = new JLabel("Phòng còn trống:");
		lblPhngCnTrng.setForeground(new Color(0, 0, 255));
		lblPhngCnTrng.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPhngCnTrng.setBounds(26, 165, 119, 21);
		contentPane.add(lblPhngCnTrng);
		
		txtphongtrong = new JTextField();
		txtphongtrong.setForeground(new Color(255, 0, 0));
		txtphongtrong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtphongtrong.setEditable(false);
		txtphongtrong.setBounds(167, 164, 71, 20);
		contentPane.add(txtphongtrong);
		txtphongtrong.setColumns(10);
		
		JLabel lblTngTin = new JLabel("Tổng đơn giá phòng:");
		lblTngTin.setForeground(new Color(0, 0, 255));
		lblTngTin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTngTin.setBounds(271, 100, 119, 18);
		contentPane.add(lblTngTin);
		
		txttongtienthu = new JTextField();
		txttongtienthu.setForeground(new Color(255, 0, 0));
		txttongtienthu.setEditable(false);
		txttongtienthu.setBounds(408, 101, 89, 20);
		contentPane.add(txttongtienthu);
		txttongtienthu.setColumns(10);
		
		btnthoat = new JButton("Thoát");
		btnthoat.setBackground(Color.RED);
		btnthoat.setForeground(Color.WHITE);
		btnthoat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnthoat.setBounds(238, 323, 89, 23);
		contentPane.add(btnthoat);
		
		txtphongcokhach.setText(String.valueOf(thongkephongcokhach()));
		
		JLabel lblTngSPhng = new JLabel("Tổng số phòng:");
		lblTngSPhng.setForeground(Color.BLUE);
		lblTngSPhng.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTngSPhng.setBounds(26, 103, 119, 14);
		contentPane.add(lblTngSPhng);
		
		txttongsophong = new JTextField();
		txttongsophong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txttongsophong.setForeground(Color.RED);
		txttongsophong.setEditable(false);
		txttongsophong.setBounds(167, 100, 71, 20);
		contentPane.add(txttongsophong);
		txttongsophong.setColumns(10);
		tongsophong();
		thongkephongtrong();
		tonggiaphong();
		
		Phong p = new Phong();
		
		btnthoat.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object s = e.getSource();
		if(s.equals(btnthoat))
		{
			this.dispose();
		}
	}
	private int thongkephongcokhach()
	{
		int count=0;
		list=tt.Locphongcokhach();
		if(list !=null)
		{
			for(Thongtinphong ttp : list)
			{
				count++;
			}
		}
		list.clear();
		return count;
	}
	private void thongkephongtrong()
	{
		int count1=0;
		list=tt.Locphongtrong();
		if(list !=null)
		{
			for(Thongtinphong ttp : list)
			{
				count1++;
			}
			txtphongtrong.setText(String.valueOf(count1));
		}
		list.clear();
	}
	private void tonggiaphong()
	{
		float tong=0;
		list = tt.listphong();
		for(Thongtinphong ttp : list)
		{
			tong+=ttp.getDonGia();
		}
		txttongtienthu.setText(String.valueOf(tong));
		list.clear();
	}
	private void tongsophong()
	{
		int dem=0;
		list = tt.listphong();
		for(Thongtinphong ttp : list)
		{
			dem++;
		}
		txttongsophong.setText(String.valueOf(dem));
		list.clear();
	}
}
