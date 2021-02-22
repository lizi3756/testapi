/*
package com.lizi.utils;
*/
/*
 * @author lizi

 * @date  2020/7/13 15:54
 * jxl  支持Excel 95-2000的所有版本
 * 只支持xls格式的,不建议使用
 *//*



import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FilenameUtils.getPath;

public class ExcelData2 {
    private static final Log log = LogFactory.getLog(ExcelData2.class);
    public Workbook workbook;
    public Sheet sheet;
    public Cell cell;
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


    public Object[][] getData(String FileName, String caseName) {
        File filepath=new File(FileName);
        if (filepath == null) {
            return null;
        }
        try {
            workbook = Workbook.getWorkbook(filepath);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        sheet = workbook.getSheet(caseName);
        if(sheet==null){
            log.error("ExcelData-sheet:" +caseName+ " not have data");
            System.exit(1);
        }
        rows = sheet.getRows();
        columns = sheet.getColumns();
        if(rows==0&&columns==0){
            log.error("ExcelData-sheet:" +caseName+ " not have data");
            System.exit(1);

        }
        // 为了返回值是Object[][],定义一个多行单列的二维数组
        String[][] arrays = new String[rows - 1][columns];
        // 对数组中所有元素hashmap进行初始化
        if (rows < 1) {
            log.debug("ExcelData:" + "excel not have data");
        }

        // 遍历所有的单元格的值添加到hashmap中
        for (int c = 0; c < columns; c++) {
            for (int r = 1; r < rows; r++) {
                arrays[r - 1][c] = sheet.getCell(c, r).getContents();
                log.debug("ExcelData:" + c + " " + (r - 1) + ":" + arrays[r - 1][c]);
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



    public Object[][] getData(String FileName, String caseName, int Startcol, int Endcol) {

        File filepath=new File(FileName);
        if (filepath == null) {
            return null;
        }
        if (Startcol < 0 && Startcol > Endcol && Endcol < 0) {
            log.error("ExcelData:" + "Startcol:" + Startcol + " or Endcol " + Endcol + " error!");
            return null;
        }
        try {
            workbook = Workbook.getWorkbook(filepath);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        sheet = workbook.getSheet(caseName);
        rows = sheet.getRows();
        columns = sheet.getColumns();
        // 为了返回值是Object[][],定义一个多行单列的二维数组
        String[][] arrays = new String[rows - 1][Endcol - Startcol + 1];
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
            for (int r = 1; r < rows; r++) {
                arrays[r - 1][c] = sheet.getCell(c + Startcol, r).getContents();
                log.debug("ExcelData:" + c + "-" + (r - 1) + ":" + arrays[r - 1][c]);
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


    public Object[][] getData(String FileName, String caseName, int colNum) {
        File filepath=new File(FileName);
        if (filepath == null) {
            return null;
        }
        try {
            workbook = Workbook.getWorkbook(filepath);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        sheet = workbook.getSheet(caseName);
        rows = sheet.getRows();
        columns = sheet.getColumns();
        if (colNum < 0&&colNum>columns-1) {
            log.error("ExcelData:" + "colNum " + colNum + " error!");
            return null;
        }
        // 为了返回值是Object[][],定义一个多行单列的二维数组
        String[][] arrays = new String[rows-1][1];
        // 对数组中所有元素hashmap进行初始化
        if (rows < 1) {
            log.debug("ExcelData:" + "excel not have data");
        }
        for (int r = 1; r < rows; r++) {
            arrays[r-1][0] = sheet.getCell(colNum, r).getContents();
            log.debug("ExcelData:" + colNum + "-" + (r - 1) + ":" + arrays[r - 1][0]);
        }
        return arrays;
    }
    public void close() throws Exception {
        workbook.close();
    }

    public static void main(String[] args) {
        ExcelData2 excel =new ExcelData2();
        Object[][] data = excel.getData("src/main/resources/crmparams/CRMtest1.xls", "添加客户");
        for (int i = 0; i < data.length; i++) {
            Object[] obl = data[i];
            System.out.println("");
            for (int j = 0; j < obl.length; j++) {
                System.out.print(obl[j] + "\t");
            }
//			if (ob[i][2].toString().equalsIgnoreCase("y")) {
//				k++;
//			}
        }
    }
}

*/
