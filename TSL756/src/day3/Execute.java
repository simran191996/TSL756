package day3;

import util.Excel;

public class Execute {
	public static void main(String[] args) 
	{
		Excel excel=new Excel("C:\\Users\\vshadmin\\Desktop\\Book1.xlsx");
		System.out.println(excel.rowCount("Sheet1"));
		System.out.println(excel.cellCount("Sheet1",0));
		System.out.println(excel.Read("Sheet1", 1, 1));
	}

}
