package cn.hacz.edu.main;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;

/**
 * project - GitHub整理 综合客户服务系统
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/8/14 时间:18:04
 * @JDK 1.8
 * @Description 功能模块：
 */
public class FirstPOITest {
    public static void main(String[] args) throws Exception {
        // 01Excel报表实例
        HSSFWorkbook excel = new HSSFWorkbook();
        // 02添加一个sheet，名字叫"POI之旅"
        HSSFSheet hssfSheet = excel.createSheet("POI之旅");
        // 03往excel表格创建一行，excel的行号是从0开始的
        HSSFRow hssfRow = hssfSheet.createRow(0);
        // 04第一行创建第一个单元格
        HSSFCell hssfCell = hssfRow.createCell(12);
        excel.write(new FileOutputStream("D:/haha.xls"));
    }
}
