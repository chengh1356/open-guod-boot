package cn.hacz.edu.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/2/11 时间:11:21
 * @JDK 1.8
 * @Description 功能模块：
 */
public class Crypto3DesUtil {
    private static final String KEY_STRING = "isiGuRWo36Gny+Y0yOU+rhYfL4kvUiOD";
    private static final byte[] KEY_IV = "99999999".getBytes();//加密IV偏移量，必须为8为字节
    private static final String KEY_ALGORITHM = "DESede";//3DES加密算法
    private static final String PADDING_PATTERN = "DESede/CBC/PKCS5Padding";//填充模式

    /**
     * 3Des CBC 模式加密
     *
     * @param data 明文
     * @return Base64编码字符串密文
     * @throws Exception
     */
    public static String Encrypt3DesCBC(String data) throws Exception {
        Cipher cipher = Cipher.getInstance(PADDING_PATTERN);
        IvParameterSpec ips = new IvParameterSpec(KEY_IV);
        cipher.init(Cipher.ENCRYPT_MODE, get3DesKey(), ips);
        byte[] bOut = cipher.doFinal(data.getBytes());
        return new BASE64Encoder().encode(bOut);
    }

    /**
     * 3DES解密
     *
     * @param cipherBase64Str Base64编码字符串密文
     * @return 解密后内容
     * @throws Exception
     */
    public static String Decrypt3DesCBC(String cipherBase64Str) throws Exception {
        byte[] cipherStrByte = new BASE64Decoder().decodeBuffer(cipherBase64Str);
        Cipher cipher = Cipher.getInstance(PADDING_PATTERN);
        IvParameterSpec ips = new IvParameterSpec(KEY_IV);
        cipher.init(Cipher.DECRYPT_MODE, get3DesKey(), ips);
        byte[] bOut = cipher.doFinal(cipherStrByte);
        return new String(bOut, "UTF-8");

    }

    /**
     * 获取3Des秘钥对象
     *
     * @return
     * @throws Exception
     */
    public static Key get3DesKey() throws Exception {
        //将keyString从Base64编码字符串转为原始正常的byte[]
        byte[] key = new BASE64Decoder().decodeBuffer(KEY_STRING);
        //实例化DES密钥规则
        DESedeKeySpec spec = new DESedeKeySpec(key);
        //实例化3DES（desede）密钥工厂
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
        //生成秘钥
        return keyfactory.generateSecret(spec);
    }


    public static void main(String[] args) throws Exception {
        //生成指定算法的秘密密钥的生成器
        KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
        //初始化此密钥生成器，使其具有确定的密钥大小
        kg.init(168);
        //生成一个密钥
        SecretKey secretKey = kg.generateKey();
        //将秘钥转为Base64编码字符串
        String keyStr = new BASE64Encoder().encode(secretKey.getEncoded());
        System.out.println(keyStr);


        // 加密
        String cipherStr = Crypto3DesUtil.Encrypt3DesCBC("testtttest");
        System.out.println(cipherStr);
        // 解密
        String dataStr = Crypto3DesUtil.Decrypt3DesCBC(cipherStr);
        System.out.println(dataStr);

    }
}
