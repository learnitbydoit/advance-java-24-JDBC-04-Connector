package vn.edu.eiu.testDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import vn.edu.eiu.database.JdbcDbConnector;



public class TestConnection {

	public static void main(String[] args) {
		try {
			// 1. Tạo kết nối với DB
			JdbcDbConnector jdc = new JdbcDbConnector();
			Connection c = jdc.getConnection();
			System.out.println(jdc.toString());
			
			//2. Tạo ra đối tượng statement
			Statement st = c.createStatement();
			
			//3. Thực thi câu lệnh sql
			String sql = "INSERT INTO khachhang (hoVaTen, ngaySinh,diaChi)"
					+ "VALUES(\"Nguyễn Thanh Tuấn\",\"2004-03-05\",\"Bình Dương\")";
			
			int checkEffect = st.executeUpdate(sql);
			 //4. xử lý kết quả
			System.out.println("Số dòng thêm vào: " + checkEffect);
			if(checkEffect > 0) {
				System.out.println("Thêm dữ liệu thành công!");
			}
			else {
				System.out.println("Thêm dữ liệu thất bại!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

}
