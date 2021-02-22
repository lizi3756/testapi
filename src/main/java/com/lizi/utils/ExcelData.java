/*
package com.lizi.utils;
*/
/*
 * @author lizi

 * @date  2020/7/13 15:54
 * 支持高版本的excel格式xlsx
 *//*



import jxl.read.biff.BiffException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.poi.xssf.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;*/
/**//*



public class ExcelData {
    private static final Log log = LogFactory.getLog(ExcelData.class);
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFCell cell;
    public String filepath;
    int rows;
    int columns;


*/
/**
     * 根据环境、文件名、sheet名获取数据
     *
     * @param FileName    文件名 ex:aaa.xls "aaa"
     * @param caseName    sheet页名字
     * @return object[][]
     * @throws IOException
     * @throws BiffException
     *//*


    public Object[][] getData(String file, String caseName) {
        File filepath=new File(file);
        FileInputStream ExcelFile;
        try {
            ExcelFile = new FileInputStream(filepath);
            // 实例化 excel 文件的 XSSFWorkbook 对象
            workbook = new XSSFWorkbook(ExcelFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        sheet = workbook.getSheet(caseName);
        if(sheet==null){
            log.error("ExcelData-sheet:" +caseName+ " not have data");
            System.exit(1);
        }
        rows=sheet.getLastRowNum();
        System.out.println("行为："+rows);
        columns=sheet.getRow(0).getPhysicalNumberOfCells();
        System.out.println("列为："+columns);
        if(rows==0&&columns==0){
            log.error("ExcelData-sheet:" +caseName+ " not have data");
            System.exit(1);

        }
        // 为了返回值是Object[][],定义一个多行多列的二维数组
        String[][] arrays = new String[rows][columns];
        // 对数组中所有元素hashmap进行初始化
        if (rows < 1) {
            log.debug("ExcelData:" + "excel not have data");
        }

        // 遍历所有的单元格的值添加到hashmap中，因为第一行有标题
        for (int c = 0; c < columns; c++) {
            for (int r = 0; r < rows; r++) {
                arrays[r][c] =sheet.getRow(r+1).getCell(c).getStringCellValue();

             log.debug("ExcelData:" + c + " " + (r + 1) + ":" + arrays[r][c]);
            }
        }
        return arrays;
    }


*/
/**
     * 根据环境、文件名、sheet名、开始列、结束列 获取数据
     *
     * @param FileName    文件名 ex:aaa.xls "aaa"
     * @param caseName    sheet页名字
     * @param Startcol    开始列号 0
     * @param Endcol      结束列号 N
     * @return object[][]
     *//*



    public Object[][] getData(String file, String caseName, int Startcol, int Endcol) {
        File filepath=new File(file);
        FileInputStream ExcelFile;
        if (filepath == null) {
            return null;
        }
        if (Startcol < 0 && Startcol > Endcol && Endcol < 0) {
            log.error("ExcelData:" + "Startcol:" + Startcol + " or Endcol " + Endcol + " error!");
            return null;
        }
        try {
            ExcelFile = new FileInputStream(filepath);
            // 实例化 excel 文件的 XSSFWorkbook 对象
            workbook = new XSSFWorkbook(ExcelFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        sheet = workbook.getSheet(caseName);
        rows = sheet.getLastRowNum();
        columns=sheet.getRow(0).getPhysicalNumberOfCells();
        // 为了返回值是Object[][],定义一个多行单列的二维数组
        String[][] arrays = new String[rows][Endcol - Startcol + 1];
        // 对数组中所有元素hashmap进行初始化
        if (rows < 1) {
            log.debug("ExcelData:" + "excel not have data");
            return null;
        }
        if (columns < Endcol + 1 || columns < Startcol) {
            log.debug("ExcelData:" + "excel columns < Startcol/Endcol");
            return null;
        }
        for (int c = 0; c <=Endcol - Startcol ; c++) {
            for (int r = 0; r < rows; r++) {
                arrays[r][c] = sheet.getRow(r+1).getCell(c+Startcol).getStringCellValue();
                log.debug("ExcelData:" + c + "-" + (r+1) + ":" + arrays[r][c]);
            }
        }
        return arrays;
    }

*/
/**
     * 根据固定列号取相对的列的数据
     * @param FileName    文件名 ex:aaa.xls "aaa"
     * @param caseName    sheet页名字
     * @param colNum      列号
     * @return object[][]
     * @throws IOException
     * @throws BiffException
     *//*


    public Object[][] getData(String file, String caseName, int colNum) {
        File filepath=new File(file);
        FileInputStream ExcelFile;
        if (filepath == null) {
            return null;
        }
        try {
            ExcelFile = new FileInputStream(filepath);
            // 实例化 excel 文件的 XSSFWorkbook 对象
            workbook = new XSSFWorkbook(ExcelFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        sheet = workbook.getSheet(caseName);
        rows = sheet.getLastRowNum();
        columns=sheet.getRow(0).getPhysicalNumberOfCells();
        if (colNum < 0&&colNum>columns-1) {
            log.error("ExcelData:" + "colNum " + colNum + " error!");
            return null;
        }
        // 为了返回值是Object[][],定义一个多行单列的二维数组
        String[][] arrays = new String[rows][1];
        // 对数组中所有元素hashmap进行初始化
        if (rows < 1) {
            log.debug("ExcelData:" + "excel not have data");
        }
        for (int r = 0; r < rows; r++) {
            arrays[r][0] = sheet.getRow(r+1).getCell(colNum).getStringCellValue();
            log.debug("ExcelData:" + colNum + "-" + (r+1) + ":" + arrays[r][0]);
        }
        return arrays;
    }
    public void close() throws Exception {
        workbook.close();
    }

    public static void main(String[] args) {
        ExcelData excel =new ExcelData();
        //Object[][] data = excel.getData("src/main/resources/crmparams/CRMTest.xlsx", "crm登录接口");
        Object[][] data = excel.getData("src/main/resources/crmparams/CRMTest.xlsx", "crm登录接口",4);
       */
/* for (int i = 0; i < data.length; i++) {
            Object[] obl = data[i];
            System.out.println("");
            for (int j = 0; j < obl.length; j++) {
                System.out.print(obl[j] + "\t");
            }
//			if (ob[i][2].toString().equalsIgnoreCase("y")) {
//				k++;
//			}
        }*//*

    }
}

*/
