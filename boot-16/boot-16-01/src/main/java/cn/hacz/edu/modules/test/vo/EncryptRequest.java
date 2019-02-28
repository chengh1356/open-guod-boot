package cn.hacz.edu.modules.test.vo;

import cn.hacz.edu.annotation.EncryptField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/1/2 时间:9:49
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EncryptRequest {
    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 银行卡号
     */
    @EncryptField
    private String bankCardNo;

    /**
     * 身份证号
     */
    @EncryptField
    private String idCard;
}