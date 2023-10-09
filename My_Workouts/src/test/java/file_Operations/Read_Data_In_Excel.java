package file_Operations;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Data_In_Excel {

	public static void main(String[] args) {
		
		Read_Data_In_Excel obj = new Read_Data_In_Excel();
		obj.readExcelData();
	}
	public void readExcelData() {

		try {
			String inputPath = System.getProperty("user.dir") + "/FileOperation.xlsx";

			System.out.println(inputPath);

			FileInputStream instream = new FileInputStream(inputPath);
			XSSFWorkbook book = new XSSFWorkbook(instream); 
			XSSFSheet sheet = book.getSheet("Sheet1"); 
			
			Row row;
			Cell cell;

			for (int i= 0 ; i<=4 ; i++) { 
				row = sheet.getRow(i);
				for (int j=0 ; j<=2 ; j++) {  
					cell = row.getCell(j);
					System.out.print(cell + "   ");
				}
				System.out.println();
			}
			book.close();
			instream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}