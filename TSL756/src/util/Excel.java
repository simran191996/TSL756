package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel
{
	Workbook book;
	
  public Excel(String filename)

{
try {
	FileInputStream infile=new FileInputStream(filename);
	if(filename.endsWith(".xls"))
	{
		 book=new HSSFWorkbook(infile);	 
	}
	else if(filename.endsWith(".xlsx"))
	{
		book=new XSSFWorkbook(infile);
	}
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

public String Read(String SheetName, int R,int C)
{
String data;
try {
	Sheet sh=	book.getSheet(SheetName);
	data = sh.getRow(R).getCell(C).toString();
	if(data.endsWith(".0"))
		data=data.split("\\.")[0];
} catch (Exception e) {
	data=null;
}

return data;
}

public int rowCount(String SheetName)
{
	return book.getSheet(SheetName).getLastRowNum();
}

public int cellCount(String SheetName,int R)
{
	Sheet sh=	book.getSheet(SheetName);
	int C=sh.getRow(R).getLastCellNum()-1;
	return C;
}

}


