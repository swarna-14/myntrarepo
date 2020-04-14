package DatadrivenTest;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {

	public Object[][] gettingdata(String SignUp) throws Exception
	{

	FileInputStream fis= new FileInputStream("D:/eclipse/Myntra/TestData.xlsx");
	XSSFWorkbook workbook= new XSSFWorkbook(fis);
	int sheets=workbook.getNumberOfSheets();
	XSSFSheet sh= workbook.getSheet(SignUp);
	System.out.println("number of sheet:"+sheets);
	Object[][] data= new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
	for(int i=0; i<sh.getLastRowNum();i++)
	{
		for(int k=0;k<sh.getRow(0).getLastCellNum();k++)
		{
			data[i][k]=sh.getRow(i+1).getCell(k).toString();
		}
	}
	return data;
	}
}
