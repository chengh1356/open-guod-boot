package cn.hacz.edu.config;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * project - GitHub整理
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/10/16 时间:11:45
 * @JDK 1.8
 * @Description 功能模块：消息转换器
 */
//@Configuration
public class GdHttpMessageConverter extends AbstractHttpMessageConverter<Object> {

    public final static Charset UTF8 = Charset.forName("UTF-8");

    @Override
    protected boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        List<MediaType> supportedMediaTypes2 = new ArrayList<>();
        supportedMediaTypes2.add(new MediaType("text", "html", UTF8));
        supportedMediaTypes2.add(new MediaType("text", "html", Charset.forName("GBK")));
        return supportedMediaTypes2;
    }

    @Override
    protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        XmlMapper xmlMapper = new XmlMapper();
        String copyToString = StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("GBK"));
        byte[] decode = Base64.getDecoder().decode(copyToString);
        if (clazz.equals(String.class)) {
            return new String(decode);
        }
        return xmlMapper.readValue(new String(decode), clazz);
    }

    @Override
    protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        byte[] encode;
        if (o.getClass().equals(String.class)) {
            String writeValueAsString = (String) o;
            encode = writeValueAsString.getBytes();
        } else {
            XmlMapper xmlMapper = new XmlMapper();
            String writeValueAsString = xmlMapper.writeValueAsString(o);
            encode = Base64.getEncoder().encode(writeValueAsString.getBytes());
        }
        outputMessage.getBody().write(encode);
    }
}
