package com.webapp5.AdminService;




import com.webapp5.Studentpayload.StudentDto;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelService {

    static String[] HEADERs = {
        "Id", "first_name", "last_name", "usn", "email", "department", 
        "address", "town", "taluka", "state", "category"
    };
    static String SHEET = "Student_Details";

    public static ByteArrayInputStream studentToExcel(List<StudentDto> students) {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet(SHEET);

            // Create header row
            Row headerRow = sheet.createRow(0);
            for (int col = 0; col < HEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
            }

            // Create data rows
            int rowIdx = 1;
            for (StudentDto student : students) {
                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(student.getId());
                row.createCell(1).setCellValue(student.getFirstName());
                row.createCell(2).setCellValue(student.getLastName());
                row.createCell(3).setCellValue(student.getUsn());
                row.createCell(4).setCellValue(student.getEmail());
                row.createCell(5).setCellValue(student.getDepartment());
                row.createCell(6).setCellValue(student.getAddress());
                row.createCell(7).setCellValue(student.getTown());
                row.createCell(8).setCellValue(student.getTaluka());
                row.createCell(9).setCellValue(student.getState());
                row.createCell(10).setCellValue(student.getCategory());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException ex) {
            throw new RuntimeException("Failed to import data to Excel file: " + ex.getMessage());
        }
    }
}
