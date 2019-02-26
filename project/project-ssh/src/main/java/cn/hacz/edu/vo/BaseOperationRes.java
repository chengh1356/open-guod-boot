package cn.hacz.edu.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BaseOperationRes {
    /**
     * 属性描述：message
     */
    private String message;

    /**
     * 属性描述：code
     */
    private String code;

    /**
     * 属性描述：success
     */
    private Boolean success;

    /**
     * 属性描述：T
     */
    private Object data;
}