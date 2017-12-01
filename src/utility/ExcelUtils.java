package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;


import config.Constants;
import test.java.DriverScriptTest;
import test.java.MainOne;
    public class ExcelUtils {
    	final static Logger Log = Logger.getLogger(ExcelUtils.class);
                private static HSSFSheet ExcelWSheet;
                private static HSSFWorkbook ExcelWBook;
                private static org.apache.poi.ss.usermodel.Cell Cell;
                private static HSSFRow Row;
                //private static XSSFRow Row;
           
            public static void setExcelFile(String Path) throws Exception {
            	try {
                    //FileInputStream ExcelFile = new FileInputStream(Path);
            		InputStream ExcelFile =  ExcelUtils.class.getClassLoader().getResourceAsStream(Path);
            		ExcelWBook = new HSSFWorkbook(ExcelFile);
            	} catch (Exception e){
            		Logtc.error("Class Utils | Method setExcelFile | Exception desc : "+e.getMessage());
            		DriverScriptTest.bResult = false;
                	}
            	}
            
            public static String getCellData(int RowNum, int ColNum, String SheetName ) throws Exception{
                try{
                	ExcelWSheet = ExcelWBook.getSheet(SheetName);
                   	Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
                    String CellData = Cell.getStringCellValue();
                    return CellData;
                 }catch (Exception e){
                	 Log.error("Class Utils | Method getCellData | Exception desc : abhishek  "+e.getMessage());
                     DriverScriptTest.bResult = false;
                     return"";
                     }
                 }
            
        	
        	public static int getRowCount(String SheetName){
        		int iNumber=0;
        		try {
        			ExcelWSheet = ExcelWBook.getSheet(SheetName);
        			iNumber=ExcelWSheet.getLastRowNum()+1;
        		} catch (Exception e){
        			Log.error("Class Utils | Method getRowCount | Exception desc : "+e.getMessage());
        			DriverScriptTest.bResult = false;
        			}
        		return iNumber;
        		}
        	
        	public static int getRowContains(String sTestCaseName, int colNum,String SheetName) throws Exception{
        		int iRowNum=0;	
        		try {
        		    //ExcelWSheet = ExcelWBook.getSheet(SheetName);
        			int rowCount = ExcelUtils.getRowCount(SheetName);
        			for (; iRowNum<rowCount; iRowNum++){
        				if  (ExcelUtils.getCellData(iRowNum,colNum,SheetName).equalsIgnoreCase(sTestCaseName)){
        					break;
        				}
        			}       			
        		} catch (Exception e){
        			Log.error("Class Utils | Method getRowContains | Exception desc : "+e.getMessage());
        			DriverScriptTest.bResult = false;
        			}
        		return iRowNum;
        		}
        	
        	public static int getTestStepsCount(String SheetName, String sTestCaseID, int iTestCaseStart) throws Exception{
        		try {
	        		for(int i=iTestCaseStart;i<=ExcelUtils.getRowCount(SheetName);i++){
	        			if(!sTestCaseID.equals(ExcelUtils.getCellData(i, Constants.Col_TestCaseID, SheetName))){
	        				int number = i;
	        				return number;      				
	        				}
	        			}
	        		ExcelWSheet = ExcelWBook.getSheet(SheetName);
	        		int number=ExcelWSheet.getLastRowNum()+1;
	        		return number;
        		} catch (Exception e){
        			Log.error("Class Utils | Method getRowContains | Exception desc : "+e.getMessage());
        			DriverScriptTest.bResult = false;
        			return 0;
                }
        	}
        	
        	@SuppressWarnings("static-access")
        	public static void setCellData(String Result,  int RowNum, int ColNum, String SheetName) throws Exception    {
                   try{
                	   
                	   ExcelWSheet = ExcelWBook.getSheet(SheetName);
                       Row  = ExcelWSheet.getRow(RowNum);
                       Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
                       if (Cell == null) {
                    	   Cell = Row.createCell(ColNum);
                    	   Cell.setCellValue(Result);
                        } else {
                            Cell.setCellValue(Result);
                        }
                         FileOutputStream fileOut = new FileOutputStream(Constants.Path_TestData);
                         ExcelWBook.write(fileOut);
                         //fileOut.flush();
                         fileOut.close();
                         ExcelWBook = new HSSFWorkbook(new FileInputStream(Constants.Path_TestData));
                     }catch(Exception e){
                    	 DriverScriptTest.bResult = false;
              
                     }
                }

    	}