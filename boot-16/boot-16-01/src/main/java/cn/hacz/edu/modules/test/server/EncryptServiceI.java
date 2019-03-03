package cn.hacz.edu.modules.test.server;

import cn.hacz.edu.modules.test.vo.EncryptRequest;
import cn.hacz.edu.modules.system.vo.Json;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/1/2 时间:9:50
 * @JDK 1.8
 * @Description 功能模块：
 */
public interface EncryptServiceI {
    Json testEncrypt(EncryptRequest request);

    Json testDecrypt(EncryptRequest request);
}
