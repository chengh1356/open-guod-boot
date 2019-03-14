package cn.hacz.edu.service.impl;

import cn.hacz.edu.service.ZipServiceI;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * project -
 *
 * @author yanfa07
 * @version 1.0
 * @date 日期:2019/3/13 时间:8:38
 * @JDK 1.8
 * @Description 功能模块：
 */
@Service
public class ZipServiceImpl implements ZipServiceI {
    @Override
    public byte[] genZip() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        try {
            zip.putNextEntry(new ZipEntry("01.pdf"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }
}
