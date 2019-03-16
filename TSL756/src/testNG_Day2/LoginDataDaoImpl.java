package testNG_Day2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.MyConnection;

public class LoginDataDaoImpl implements LoginDataDao
{
	Connection conn=MyConnection.getMyConnection();

	@Override
	public List<LoginPojo> getAllLoginDetails() {
		
		List<LoginPojo> log_list = new ArrayList<LoginPojo>();
		LoginPojo log =null;

		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from Login");
			while(rs.next()) {
				log= new LoginPojo();
				log.setUserName(rs.getString(1));
				log.setPassWord(rs.getString(2));
				log.setStatus(rs.getString(3));
				log_list.add(log);
				}
			}
		 catch (SQLException e) {
					e.printStackTrace();
		}
		
		return log_list;
	}

	@Override
	public void insertStatus(String uname,String status) {
		
		try {
			PreparedStatement pst = conn.prepareStatement("update login set status=? where username="+"'"+uname+"'");
			pst.setString(1, status);
			int row = pst.executeUpdate();
			System.out.println("row updated :"+row);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
