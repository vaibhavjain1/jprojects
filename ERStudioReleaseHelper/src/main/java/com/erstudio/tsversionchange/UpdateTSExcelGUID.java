package main.java.com.erstudio.tsversionchange;

import main.java.com.erstudio.constants.Constants;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author darpan.kochar
 * @description updates GUID in excel file of TS
 */
public class UpdateTSExcelGUID {
    String excelFilePath;

    public UpdateTSExcelGUID(String filePath) {
        excelFilePath = filePath;
    }

    public List<String> update(UUID newGUID) {
        List<String> response = new ArrayList<String>();
        File directory = new File("");
        String filePath = directory.getAbsolutePath() + excelFilePath;
        Workbook workbook = null;
        try {
            FileInputStream excelFile = new FileInputStream(new File(filePath));
            workbook = WorkbookFactory.create(excelFile);
            // Retrieving sheet in the Workbook
            Sheet sheet = workbook.getSheetAt(1);
            sheet.forEach(row -> {
                //ignore the first header row and update only GUID Update operation
                if (row.getRowNum() != 0 && row.getCell(0).toString().equals(Constants.OPERATION_TYPE_GUID_UPDATE)) {
                    Row currentRow = sheet.getRow(row.getRowNum());
                    Cell cell = currentRow.getCell(4);
                    cell.setCellValue(newGUID.toString().toUpperCase());
                }
            });
            excelFile.close();
            FileOutputStream outFile = new FileOutputStream(new File(filePath));
            workbook.write(outFile);
            outFile.close();
            response.add("Successfully updated GUID in file " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            response.add("Error in updating GUID in file " + filePath);
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
                response.add("Error in updating GUID in file " + excelFilePath);
            }
        }
        return response;
    }
}
