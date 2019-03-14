package cn.hacz.edu.util;

import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.ZipOutputStream;

public class FileUtil {
    public static void download(HttpServletResponse response, List<Object[]> objects) {
        try {
            String downloadFilename = new String("guo.zip".getBytes(StandardCharsets.UTF_8), "iso8859-1");
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=" + downloadFilename);
            ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
            zos.write(null);
            zos.flush();
            zos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
