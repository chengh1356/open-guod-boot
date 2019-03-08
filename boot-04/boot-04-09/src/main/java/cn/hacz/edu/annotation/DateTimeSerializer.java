package cn.hacz.edu.annotation;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * project - GitHub整理
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/11/9 时间:15:57
 * @JDK 1.8
 * @Description 功能模块：
 */
public class DateTimeSerializer extends JsonSerializer<Date> {
    private final String key;

    /**
     * @param key
     */
    public DateTimeSerializer(String key) {
        super();
        this.key = key;
    }

    @Override
    public void serialize(Date value, JsonGenerator jgen,
                          SerializerProvider provider)
            throws IOException, JsonProcessingException {
        String output = StringUtils.EMPTY;
        if (value != null) {
            //  将日期转换为字符串
            output = new SimpleDateFormat(key).format(value);
        }
        //  输出转换结果
        jgen.writeString(output);
    }
}
