package thongTinSach;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DocGhiFile {
	// ghi file
	public static void writeToFile(DanhSachSach dss, String file) throws Exception {
		ObjectOutputStream oos = null;
		oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(dss);
		oos.close();
	}
	public Object readFromFile(String file) throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Object list = ois.readObject();
		ois.close();
		return list;
	}
}
