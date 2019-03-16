package testNG_Day2;

import java.util.List;

public interface LoginDataDao {

	public List<LoginPojo> getAllLoginDetails();
	public void insertStatus(String uname,String status);
	
}
