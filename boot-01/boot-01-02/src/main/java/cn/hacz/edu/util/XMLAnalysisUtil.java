package cn.hacz.edu.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

public class XMLAnalysisUtil {

    /**
     * xml格式字符串转换成document对象
     *
     * @param xml
     * @return
     */

    public static Document StringToDocument(String xml) {
        try {
            return DocumentHelper.parseText(xml);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Element> getElement(String nodePath, String filePath) {
        Document document = null;
        try {
            File file = new File(filePath);
            SAXReader reader = new SAXReader();
            document = reader.read(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return document.selectNodes(nodePath);
    }

    public static void setArr2Map(Map<String, Object> map, String[] strings) {
        Iterator<String> it = map.keySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            String key = it.next();
            if (i < strings.length) {
                map.put(key, strings[i]);
                i++;
            }
        }
    }

    /**
     * 根据文件计算出文件的MD5
     *
     * @param file
     * @return
     */
    public static String getFileMD5(File file) {
        if (!file.isFile()) {
            return null;
        }

        MessageDigest digest = null;
        FileInputStream in = null;
        byte buffer[] = new byte[1024];
        int len;
        try {
            digest = MessageDigest.getInstance("MD5");
            in = new FileInputStream(file);
            while ((len = in.read(buffer, 0, 1024)) != -1) {
                digest.update(buffer, 0, len);
            }
            in.close();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BigInteger bigInt = new BigInteger(1, digest.digest());

        return leftAddZero(bigInt.toString(16), 32);
    }

    public static String leftAddZero(String numStr, int totalLen) {
        String data = "";
        for (int i = 0; i < totalLen - numStr.length(); i++) {
            data += "0";
        }
        data += numStr;
        return data;
    }

    //当前时间的前一天字符串
    public static String getBeforeDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String nowDateString = formatter.format(date);
        return nowDateString;
    }

}