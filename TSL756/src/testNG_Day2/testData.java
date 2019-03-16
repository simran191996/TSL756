package testNG_Day2;

import java.util.Iterator;
import java.util.List;

public class testData {
public static void main(String[] args) {
	
	LoginDataDaoImpl loginImpl = new LoginDataDaoImpl();
	List<LoginPojo> loginList= loginImpl.getAllLoginDetails();
	Iterator<LoginPojo> loginItr=loginList.iterator();
	while(loginItr.hasNext())
	{
		LoginPojo log=loginItr.next();
		System.out.println("userName is:"+log.getUserName());
		System.out.println("PassWord is:"+log.getPassWord());
		System.out.println("Status is:"+log.getStatus());
		System.out.println("-------------------------------------------------------------------------");
	}

	LoginDataDaoImpl logI=new LoginDataDaoImpl();
	LoginPojo log= new LoginPojo();
	//log.setStatus("");
	logI.insertStatus(log.getUserName(), log.getStatus());
	//logI.insertStatus(uname, pass, status);
	

}
}
