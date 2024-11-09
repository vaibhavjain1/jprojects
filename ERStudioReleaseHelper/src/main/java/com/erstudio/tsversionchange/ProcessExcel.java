package main.java.com.erstudio.tsversionchange;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.java.com.erstudio.constants.Constants;
import org.apache.poi.ss.usermodel.*;

import main.java.com.erstudio.tsversionchange.model.ExcelModel;
import main.java.com.erstudio.tsversionchange.model.VersionFormat;

/**
 * @author rajat.batra
 * @description reads excel file and returns list of files to be updated
 */
public class ProcessExcel {
    List<ExcelModel> processedExcelList;

    public ProcessExcel(String excelFilePath, String product) throws Exception {
        this.processedExcelList = processExcelFile(excelFilePath, product);
    }

    public List<ExcelModel> getProcessedExcelList() {
        return processedExcelList;
    }

    public void setProcessedExcelList(List<ExcelModel> processedExcelList) {
        this.processedExcelList = processedExcelList;
    }

    public List<ExcelModel> processExcelFile(String SAMPLE_XLSX_FILE, String Product) throws Exception {
    	int versionSheetindex;
    	if(Product.equals(Constants.TEAM_SERVER))
    		versionSheetindex = 0;
    	else
    		versionSheetindex = 2;
        List<ExcelModel> fileList = new ArrayList<>();
        File directory = new File("");
        String SAMPLE_XLSX_FILE_PATH = directory.getAbsolutePath() +SAMPLE_XLSX_FILE;
        // Creating a Workbook from an Excel file (.xls or .xlsx)
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

            
            // Retrieving the number of sheets in the Workbook
            Sheet versionSheet = workbook.getSheetAt(versionSheetindex);

            // Create a DataFormatter to format and get each cell's value as String
            DataFormatter dataFormatter = new DataFormatter();

            // iterating over Rows and Columns
            versionSheet.forEach(row -> {
                //ignore the first header row
                if (row.getRowNum() != 0) {
                    Iterator<Cell> cellIterator = row.cellIterator();
                    ExcelModel excelModel = new ExcelModel();
                    while (cellIterator.hasNext()) {
                        Cell cell1 = cellIterator.next();
                        // serial number
                        dataFormatter.formatCellValue(cell1);
                        // file path
                        Cell cell2 = cellIterator.next();
                        String path = "\\"+dataFormatter.formatCellValue(cell2);
                        excelModel.setFilepath(path.trim());
                        // full version : true/false
                        Cell cell3 = cellIterator.next();
                        excelModel.setFullVersion(dataFormatter.formatCellValue(cell3));
                        // patch version : true/false
                        Cell cell4 = cellIterator.next();
                        excelModel.setPatchVersion(dataFormatter.formatCellValue(cell4));
                        // string to replace format
                        Cell cell5 = cellIterator.next();
                        VersionFormat versionFormat = new VersionFormat(dataFormatter.formatCellValue(cell5));
                        excelModel.setVersionFormat(versionFormat);
                        // operation version change
                        excelModel.setOperationType(Constants.OPERATION_TYPE_VERSION_CHANGE);
                        fileList.add(excelModel);
                    }
                }
            });

            if(Product.equals(Constants.TEAM_SERVER)) {
	            // Retrieving Custom sheet
	            Sheet customSheet = workbook.getSheetAt(1);
	            // iterating over Rows and Columns
	            customSheet.forEach(row -> {
	                //ignore the first header row
	                if (row.getRowNum() != 0) {
	                    Iterator<Cell> cellIterator = row.cellIterator();
	                    ExcelModel excelModel = new ExcelModel();
	                    while (cellIterator.hasNext()) {
	                        Cell cell1 = cellIterator.next();
	                        // custom operation type
	                        excelModel.setOperationType(dataFormatter.formatCellValue(cell1));
	                        // file path
	                        Cell cell2 = cellIterator.next();
	                        String path = "\\" + dataFormatter.formatCellValue(cell2);
	                        excelModel.setFilepath(path.trim());
	                        // full version : true/false
	                        Cell cell3 = cellIterator.next();
	                        excelModel.setFullVersion(dataFormatter.formatCellValue(cell3));
	                        // patch version : true/false
	                        Cell cell4 = cellIterator.next();
	                        excelModel.setPatchVersion(dataFormatter.formatCellValue(cell4));
	                        // GUID to replace
	                        Cell cell5 = cellIterator.next();
	                        excelModel.setCustomData(dataFormatter.formatCellValue(cell5));
	                        fileList.add(excelModel);
	                    }
	                }
	            });
            }
        
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return fileList;
        }
	
    }
}