package thongTinSach;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;



public class frmSach extends JFrame implements ActionListener, MouseListener{
	private JLabel lblMaSach;
	private JTextField txtMaSach;
	private JLabel lblTuaSach;
	private JTextField txtTuaSach;
	private JLabel lblTacGia;
	private JTextField txtTacGia;
	private JLabel lblNamXuatBan;
	private JTextField txtNamXuatBan;
	private JLabel lblNhaXuatBan;
	private JTextField txtNhaXuatBan;
	private JLabel lblSoTrang;
	private JTextField txtSoTrang;
	private JLabel lblDonGia;
	private JTextField txtDonGia;
	private JLabel lblInter;
	private JTextField txtInter;
	private JButton btnThem;
	private JButton btnXoaRong;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnLuu;
	private JLabel lblTim;
	private JComboBox cbb;
	private DefaultTableModel tableModel;
	private JTable table;
	private DanhSachSach dss;
	private DocGhiFile fi;
	public static final String file = "data//phamvanhau.txt";
	public frmSach(DanhSachSach dao) {
		// TODO Auto-generated constructor stub
		setTitle("Quản lý sách");
		setSize(900, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//
		Box b, b1, b2, b3, b4, b5;
		b = Box.createVerticalBox();
		b.setBorder(BorderFactory.createTitledBorder("Reconrds Editor"));
		// Mã sách
		b.add(b1 = Box.createHorizontalBox());
		b1.add(Box.createHorizontalStrut(10));
		b1.add(lblMaSach = new JLabel("Mã sách: "));
		b1.add(Box.createHorizontalStrut(30));
		b1.add(txtMaSach = new JTextField());
		b1.add(Box.createHorizontalStrut(500));
		b.add(Box.createVerticalStrut(10));
		// Tựa sách
		b.add(b2 = Box.createHorizontalBox());
		b2.add(Box.createHorizontalStrut(10));
		b2.add(lblTuaSach = new JLabel("Tựa sách :"));
		b2.add(Box.createHorizontalStrut(30));
		b2.add(txtTuaSach = new JTextField());
		
		// Tác giả
		b2.add(Box.createHorizontalStrut(30));
		b2.add(lblTacGia = new JLabel("Tác giả: "));
		b2.add(Box.createHorizontalStrut(30));
		b2.add(txtTacGia = new JTextField());
		b2.add(Box.createHorizontalStrut(20));
		b.add(Box.createVerticalStrut(10));
		// Năm xuất bản
		b.add(b3 = Box.createHorizontalBox());
		b3.add(Box.createHorizontalStrut(10));
		b3.add(lblNamXuatBan = new JLabel("Năm xuất bản: "));
		b3.add(Box.createHorizontalStrut(30));
		b3.add(txtNamXuatBan = new JTextField());
		// Nhà xuất bản
		b3.add(Box.createHorizontalStrut(30));
		b3.add(lblNhaXuatBan = new JLabel("Nhà xuất bản: "));
		b3.add(Box.createHorizontalStrut(30));
		b3.add(txtNhaXuatBan  = new JTextField());
		b3.add(Box.createHorizontalStrut(20));
		b.add(Box.createVerticalStrut(10));
		// Số trang
		b.add(b4 = Box.createHorizontalBox());
		b4.add(Box.createHorizontalStrut(10));
		b4.add(lblSoTrang = new JLabel("Số trang: "));
		b4.add(Box.createHorizontalStrut(30));
		b4.add(txtSoTrang = new JTextField());
		// Đơn giá
		b4.add(Box.createHorizontalStrut(30));
		b4.add(lblDonGia = new JLabel("Đơn giá: "));
		b4.add(Box.createHorizontalStrut(30));
		b4.add(txtDonGia = new JTextField());
		b4.add(Box.createHorizontalStrut(20));
		b.add(Box.createVerticalStrut(10));
		// Inter
		b.add(b5 = Box.createHorizontalBox());
		b5.add(Box.createHorizontalStrut(10));
		b5.add(lblInter = new JLabel("International Standard Book Number: "));
		b5.add(Box.createHorizontalStrut(5));
		b5.add(txtInter = new JTextField());
		b5.add(Box.createHorizontalStrut(397));
		b.add(Box.createVerticalStrut(20));
		add(b, BorderLayout.NORTH);
		// phần button 
		JPanel pCen = new JPanel();
		pCen.add(btnThem = new JButton("Thêm"));
		pCen.add(btnXoaRong = new JButton("Xóa rỗng"));
		pCen.add(btnXoa = new JButton("Xóa"));
		pCen.add(btnSua = new JButton("Sửa"));
		pCen.add(btnLuu = new JButton("Lưu"));
		pCen.add(lblTim = new JLabel("Tìm theo mã sách: "));
		String ma [] = {"A001", "B001"};
		pCen.add(cbb = new JComboBox<>(ma));
		add(pCen, BorderLayout.CENTER);
		// table
		String header [] = {"MaSach", "TuaSach", "TacGia", "NamXuatBan", "NhaXuatBan", "SoTrang", "DonGia", "ISBN"};
		tableModel = new DefaultTableModel(header, 0);
		JScrollPane scroll = new JScrollPane();
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách cuốn sách"));
		scroll.setViewportView(table = new JTable(tableModel));
		table.setRowHeight(25);
		add(scroll, BorderLayout.SOUTH);
		// 
		lblMaSach.setPreferredSize(lblNamXuatBan.getPreferredSize());
		lblTuaSach.setPreferredSize(lblNamXuatBan.getPreferredSize());
		lblSoTrang.setPreferredSize(lblNamXuatBan.getPreferredSize());
		
		lblTacGia.setPreferredSize(lblNhaXuatBan.getPreferredSize());
		lblNhaXuatBan.setPreferredSize(lblNhaXuatBan.getPreferredSize());
		lblDonGia.setPreferredSize(lblNhaXuatBan.getPreferredSize());
		
		//
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnSua.addActionListener(this);
		btnLuu.addActionListener(this);
		table.addMouseListener(this);
		
		//
		dss = new DanhSachSach();
		fi = new DocGhiFile();
		try {
			dss = (DanhSachSach)fi.readFromFile(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hienTable();
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMaSach.setText(table.getValueAt(row, 0).toString());
		txtTuaSach.setText(table.getValueAt(row, 1).toString());
		txtTacGia.setText(table.getValueAt(row, 2).toString());
		txtNamXuatBan.setText(table.getValueAt(row, 3).toString());
		txtNhaXuatBan.setText(table.getValueAt(row, 4).toString());
		txtSoTrang.setText(table.getValueAt(row, 5).toString());
		txtDonGia.setText(table.getValueAt(row, 6).toString());
		txtInter.setText(table.getValueAt(row, 7).toString());
		
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
		Object o = e.getSource();
		if(o.equals(btnXoaRong))
			xoaRongAction();
		if(o.equals(btnThem))
			themAction();
		if(o.equals(btnXoa))
			xoaAction();
		if(o.equals(btnLuu)) {
			try {
				fi.writeToFile(dss, file);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(o.equals(btnSua))
			suaAction();
	}
	public void xoaRongAction() {
		txtMaSach.setText("");
		txtTuaSach.setText("");
		txtTacGia.setText("");
		txtNamXuatBan.setText("");
		txtNhaXuatBan.setText("");
		txtSoTrang.setText("");
		txtDonGia.setText("");
		txtInter.setText("");
	}
	public void hienTable() {
		xoaHetDuLieuTrenTable();
		for(int i = 0; i < dss.getSize(); i++) {
			Sach s = dss.getSach(i);
			String dataRow[] = {s.getMaSach()+"", s.getTuaSach(), s.getTacGia(), s.getNamXB()+"", s.getNhaXB(), s.getSoTrang()+"", s.getDonGia()+"", s.getInter()+""};
			tableModel.addRow(dataRow);
		}
	}
	public void themAction() {
		try {
			int ma = Integer.parseInt(txtMaSach.getText());
			String tuaSach = txtTuaSach.getText();
			String tacGia = txtTacGia.getText();
			int namXB = Integer.parseInt(txtNamXuatBan.getText());
			String nhaXB = txtNhaXuatBan.getText();
			int soTrang = Integer.parseInt(txtSoTrang.getText());
			double donGia = Double.parseDouble(txtDonGia.getText());
			int inter = Integer.parseInt(txtInter.getText());
			Sach s = new Sach(ma, tuaSach, tacGia, namXB, nhaXB, soTrang, donGia, inter);
			if(dss.themSach(s)) {
				String dataRow [] = {s.getMaSach()+"", s.getTuaSach(), s.getTacGia(), s.getNamXB()+"", s.getNhaXB(), s.getSoTrang()+"", s.getDonGia()+"", s.getInter()+""};
				tableModel.addRow(dataRow);
				xoaRongAction();
			}
			else {
				JOptionPane.showMessageDialog(null, "Trùng mã nhân viên");
				txtMaSach.selectAll();
				txtMaSach.requestFocus();
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Lỗi nhập dữ liệu!");
			txtMaSach.selectAll();
			txtMaSach.requestFocus();
			return;
		}
	}
	public void xoaAction() {
		int row = table.getSelectedRow();
		if(row != -1) {
			int ma = Integer.parseInt((String)table.getModel().getValueAt(row, 0));
			int hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa?", "Chú ý", JOptionPane.YES_NO_CANCEL_OPTION);
			if(hoiNhac == JOptionPane.YES_OPTION) {
				if(dss.xoaSach(ma)) {
					tableModel.removeRow(row);
				}
			}
		}
	}
	public void suaAction() {
		try {
			int ma = Integer.parseInt(txtMaSach.getText());
			String tuaSach = txtTuaSach.getText();
			String tacGia = txtTacGia.getText();
			int namXB = Integer.parseInt(txtNamXuatBan.getText());
			String nhaXB = txtNhaXuatBan.getText();
			int soTrang = Integer.parseInt(txtSoTrang.getText());
			double donGia = Double.parseDouble(txtDonGia.getText());
			int inter = Integer.parseInt(txtInter.getText());
			Sach sNew = new Sach(ma, tuaSach, tacGia, namXB, nhaXB, soTrang, donGia, inter);
			if(dss.suaSach(ma, sNew)) {
				hienTable();
			}
			else {
				JOptionPane.showMessageDialog(this, "Cần chọn cuốn sách để cập nhật!");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Lỗi cập nhật");
			// TODO: handle exception
		}
	}
	public void xoaHetDuLieuTrenTable() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.getDataVector().removeAllElements();
	}
}
