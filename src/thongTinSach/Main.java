package thongTinSach;

public class Main {
	public static void main(String[] args) {
		DanhSachSach dao = new DanhSachSach();
		new frmSach(dao).setVisible(true);
	}
}
