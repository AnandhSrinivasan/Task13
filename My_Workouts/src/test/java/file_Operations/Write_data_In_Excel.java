package file_Operations;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write_data_In_Excel {

	public static void main(String[] args) throws IOException {
		String excelFilePath = "FileOperation.xlsx";
	
		try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            XSSFSheet sheet = workbook.createSheet("Sheet1");
            Row headerRow = sheet.createRow(0);
            String[] headers = {"Name", "Age", "Email"};
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);

            }
            Object[][] data = {
                    {"John Doe", 30, "john@test.com"},
                    {"Jane Doe" , 28 , "jane@test.com"},
                    {"Bob Smith", 35, "	jacky@example.com"},
                    {"Swapnil", 37, "joe@example.com"}
            };
            int rowNum = 1;
            for (Object[] rowData : data) {
                Row row = sheet.createRow(rowNum++);
                int colNum = 0;
                for (Object field : rowData) {
                    Cell cell = row.createCell(colNum++);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    } else if (field instanceof Integer) {
                        cell.setCellValue((Integer) field);
                    }
                }
            }
            try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
                workbook.write(outputStream);
            }
            System.out.println("Excel file created successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}