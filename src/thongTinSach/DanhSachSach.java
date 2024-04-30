package thongTinSach;

import java.io.Serializable;
import java.util.ArrayList;

public class DanhSachSach implements Serializable{
	private ArrayList<Sach> list;
	public DanhSachSach() {
		// TODO Auto-generated constructor stub
		list = new ArrayList<Sach>();
	}
	// thêm sách 
	public boolean themSach(Sach s) {
		if(list.contains(s))
			return false;
		list.add(s);
		return true;
	}
	// xóa sách
	public boolean xoaSach(int ma) {
		Sach s = new Sach(ma);
		if(list.contains(s)) {
			list.remove(s);
			return true;
		}
		return false;
	}
	// tìm kiếm sách
	public Sach timKiem(int ma) {
		Sach s = new Sach(ma);
		if(list.contains(s)) {
			return list.get(list.indexOf(s));
		}
		return null;
	}
	public int getSize() {
		return list.size();
	}
	public Sach getSach(int i) {
		if(i >= 0 && i < list.size()) {
			return list.get(i);
		}
		return null;
	}
	public ArrayList<Sach> getList(){
		return list;
	}
	// Sửa nhân viên
	public boolean suaSach(int idOld, Sach sNew) {
		Sach sOld = new Sach(idOld);
		if(list.contains(sOld)) {
			sOld = list.get(list.indexOf(sOld));
			sOld.setTuaSach(sNew.getTuaSach());
			sOld.setTacGia(sNew.getTacGia());
			sOld.setNamXB(sNew.getNamXB());
			sOld.setNhaXB(sNew.getNhaXB());
			sOld.setSoTrang(sNew.getSoTrang());
			sOld.setDonGia(sNew.getDonGia());
			sOld.setInter(sNew.getInter());
			return true;
		}
		return false;
	}
}
