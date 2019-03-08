package cn.hacz.edu.modules.system;

import cn.hacz.edu.properties.QRCodeProperties;
import cn.hacz.edu.util.QRCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * project - GitHub整理
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/10/17 时间:10:07
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
@Slf4j
public class QRCodeController {
    @Autowired
    private QRCodeProperties cd;

    /**
     * 功能描述：生成二维码
     */
    @RequestMapping(value = "/getQRCode")
    public Object getQRCode(Object object) {
        String encode = null;
        try {
            log.info("[{}]", cd.getLength());
            encode = QRCodeUtil.encode("牛逼！", "e:/", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encode;
    }

    /**
     * 功能描述：生成带logo的二维码
     */
    @RequestMapping(value = "/getQRCodeLogo")
    public Object getQRCodeLogo(Object object) {
        String encode = null;
        try {
            encode = QRCodeUtil.encode("logo牛逼！", "f:/aaa.jpg", "e:/", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encode;
    }
}