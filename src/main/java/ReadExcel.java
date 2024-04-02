import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		
		//File-workbook-sheet-row-cell
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\DataSet1.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		XSSFRow row=sheet.getRow(2);
		XSSFCell cell=row.getCell(2);
		String cellValue=cell.toString();
		System.out.println(cellValue);
		
		int rowCount= sheet.getLastRowNum();
		int cellCount=row.getLastCellNum();
		System.out.println("Row Max Count"+rowCount); 
		System.out.println("Cell Max Count"+cellCount);
		
		for(int r=0;r<=rowCount;r++)//row
		{
			XSSFRow currentRow= sheet.getRow(r);
			
			for(int c=0;c <cellCount;c++)//cell
			{
				String value=currentRow.getCell(c).toString();
				System.out.print(value+"        ");
			}
			System.out.println();
		}
		
		
	}
	
	driver.findelement().sendKeys(userNAme)

}
