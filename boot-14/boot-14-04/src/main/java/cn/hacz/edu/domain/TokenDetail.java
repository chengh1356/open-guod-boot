package cn.hacz.edu.domain;

/**
 * project -
 *
 * @author dong
 * @version 1.0
 * @date 日期:2018/9/4 时间:22:39
 * @JDK 1.8
 * @Description 功能模块：
 */
public interface TokenDetail {
    /**
     * 这里封装了一层，不直接使用 username 做参数的原因是可以方便未来增加其他要封装到 token 中的信息
     *
     * @return
     */
    String getUsername();
}
