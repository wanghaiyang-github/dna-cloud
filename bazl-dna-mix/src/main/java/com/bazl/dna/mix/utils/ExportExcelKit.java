package com.bazl.dna.mix.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * @Author: lzn
 * @Date: 2019/8/20 8:59
 * @Version: 1.0
 */
public class ExportExcelKit {

    private static final Logger logger = LoggerFactory.getLogger(AnalysisPDFUtils.class);

    /**
     * 导出列表数据
     *
     * @param title        表头集合
     * @param position     表头字段位置集合
     * @param data         需要导出的数据
     * @param sheetName    导出数据后在excel表格中左下角显示的工作簿名称（注意：不是导出后的文件名）
     * @param outputStream 从controller层通过response获取到的输出流
     * @throws IOException
     * @throws ExportExcelKit
     */
    public static void exportDataToExcel(Map<String, String> title, Map<String, Integer> position, List<Map<String, Object>> data, String sheetName, OutputStream outputStream) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        try {
            Sheet sheet = workbook.createSheet(sheetName);
            Row header = sheet.createRow(0);
            // 设置表头样式
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            // 字体样式
            XSSFFont font = ((XSSFWorkbook) workbook).createFont();
            font.setFontName("Arial");
            font.setFontHeightInPoints((short) 14);
            headerStyle.setFont(font);

            int col = 0;
            // 遍历表头map集合
            for (String key : title.keySet()) {
                sheet.setColumnWidth(col, 6000);
                // 设置表格头部
                Cell headerCell = header.createCell(position.get(key));
                headerCell.setCellValue(title.get(key) + "");
                headerCell.setCellStyle(headerStyle);
                col++;
            }
            CellStyle style = workbook.createCellStyle();
            style.setWrapText(true);

            /*
             * 遍历要导出列表的数据data 并与title的key相比较， 确认后插入值
             * 创建列时，根据title的key然后将值插入到对应的列中（position，dataMap，title三个集合的key值是一一对应的）
             */
            if (data != null && data.size() > 0) {
                int r = 0;
                for (Map<String, Object> dataMap : data) {
                    Row row = sheet.createRow(r + 1);
                    for (String dkey : dataMap.keySet()) {
                        for (String key : title.keySet()) {
                            if (key.equals(dkey)) {
                                Cell cell = row.createCell(position.get(key));
                                cell.setCellValue(dataMap.get(dkey) + "");
                                cell.setCellStyle(style);
                                break;
                            }
                        }
                    }
                    r++;
                }
            }
            //使用输出流
            workbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (Exception ex) {
            workbook.close();
            logger.error("导出列表失败", ex);
        }
    }

}
