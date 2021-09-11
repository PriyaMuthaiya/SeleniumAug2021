package week5.day2;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {

	public static String[][] readData(String fileName) throws IOException {
		// TODO Auto-generated method stub
		
		
		XSSFWorkbook wb=new XSSFWorkbook("./data/"+fileName+".xlsx");
		XSSFSheet sheet=wb.getSheet("Sheet1");
		int rowCount=sheet.getLastRowNum();
		System.out.println("Create lead row count: " + rowCount);
		int cellCount=sheet.getRow(0).getLastCellNum();
		System.out.println("Create lead cell count: " + cellCount);
		//create 2D array
		String[][] data=new String[rowCount][cellCount];


		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				String text=sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(text);
			//get row and column value	
				data[i-1][j]=text;
			}


		}
		wb.close();
		return data;
			}


		}



