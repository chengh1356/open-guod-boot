package cn.hacz.edu.exception;

/**
 * ========================
 * Created with IntelliJ IDEA.
 *
 * @author guod
 * Date：2018/3/8
 * Time：13:21
 * Description：功能模块：
 * JDK：V1.8
 * GitHub地址：https://github.com/guod369
 * ========================
 */
public class DataException extends RuntimeException {
    public int code;

    public final static int noPermission = -100;
    public final static int noID = -1;

    public DataException(int code) {
        this.code = code;
    }

    public DataException(int code , String message) {
        super(message);
        this.code = code;
    }

    public DataException(int code , String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public DataException(int code , Throwable cause) {
        super(cause);
        this.code = code;
    }
}
