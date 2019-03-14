/**
 *
 */
package cn.hacz.edu.xml;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

/**
 * project - GitHub整理
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018年3月2日 时间:上午9:34:47
 * @JDK 1.8
 * @Description 功能模块： xml组装工具类
 */
public class XmlMapperUtils {

    /**
     * @return XmlMapper
     * @Title getMapper
     * @date 日期:2018年3月2日 时间:上午9:40:26
     * @Description 功能：对XML进行格式等额外操作
     */
    public static XmlMapper getMapper() {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
        return xmlMapper;
    }

    /**
     * @return ObjectMapper
     * @Title getObjectMapper
     * @date 日期:2018年3月2日 时间:上午9:40:21
     * @Description 功能：声明转换器，一般使用ObjectMapper就已足够
     */
    public static ObjectMapper getObjectMapper() {
        ObjectMapper o = new ObjectMapper();
        // 作用到objectMapper所指的地方
        o.setSerializationInclusion(Include.NON_NULL);
        o.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return o;
    }

}
