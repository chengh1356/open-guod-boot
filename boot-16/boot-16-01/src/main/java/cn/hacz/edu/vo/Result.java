package cn.hacz.edu.vo;

/**
 * @author guod
 */
public class Result<T> {

	/**
	 * 响应业务状态
	 */
	private Integer code;

	/**
	 * 响应消息
	 */
	private String msg;

	/**
	 * 响应中的数据
	 */
	private T data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
