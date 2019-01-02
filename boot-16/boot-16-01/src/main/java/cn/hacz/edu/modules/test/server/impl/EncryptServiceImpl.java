package cn.hacz.edu.modules.test.server.impl;

import cn.hacz.edu.modules.test.server.EncryptServiceI;
import cn.hacz.edu.modules.test.vo.EncryptRequest;
import cn.hacz.edu.util.ResultUtils;
import cn.hacz.edu.vo.Json;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * project -
 *
 * @author yanfa07
 * @version 1.0
 * @date 日期:2019/1/2 时间:9:51
 * @JDK 1.8
 * @Description 功能模块：
 */
@Service
public class EncryptServiceImpl implements EncryptServiceI {

    @Override
    public Json testEncrypt(EncryptRequest request) {
        return ResultUtils.successJson(request);
    }

    @Override
    public Json testDecrypt(EncryptRequest request) {
        return null;
    }

    public static void main(String[] args) {
        String md5Password = DigestUtils.md5DigestAsHex("1".getBytes());
        System.out.println(md5Password);
    }

}