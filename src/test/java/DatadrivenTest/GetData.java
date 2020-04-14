package DatadrivenTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class GetData {
	
	@Test
	public void readingdata() throws Exception
	{
		ArrayList<String> a=new ArrayList<String>();
		File fl= new File("D:/eclipse/Myntra/TestData.xlsx");
		FileInputStream fis= new FileInputStream(fl);
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		int sheets=workbook.getNumberOfSheets();
		System.out.println("number"+sheets);
		for(int i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("SignUp"))
			{
				XSSFSheet sheet=workbook.getSheetAt(i);
				Iterator <Row> rows=sheet.iterator();
				Row firstrow= rows.next();
				Iterator<Cell> cv= firstrow.cellIterator();
				int k=0;
				int column=0;
				while(cv.hasNext())
				{
					Cell value=cv.next();
				System.out.println("value:" +value);
				if(value.getStringCellValue().equalsIgnoreCase("SignUp"))
				{
					column=k;
				}
				k++;
				System.out.println(column);
				}
				while(rows.hasNext())
				{
					Row r=rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase("SignUp"))
					{
						Iterator<Cell> cv1=r.cellIterator();
						while(cv1.hasNext())
						{
							Cell c=cv1.next();
							
							if(c.getCellType()==CellType.STRING)
							{
								a.add(c.getStringCellValue());
								System.out.println("value:" +c);
							}
							else
							{
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
							//System.out.println("value:" +c);
						}
					}
				
				}
				
			}
		}
	//	XSSFSheet xsheet= workbook.getSheet("SignUp");
	  
//		int totalrow = xsheet.getLastRowNum();
//		
//		for(int row=0; row<totalrow;row++)
//		{
//			XSSFRow rownum= xsheet.getRow(row);
//			for(int col=0;col<10;col++)
//			{
//				XSSFCell cellnum= rownum.getCell(col);
//			}
//			System.out.println("rownumber:"+rownum);
//		}
//		Object data =xsheet.getRow(0).getCell(0).getStringCellValue();
//		
	}

}
