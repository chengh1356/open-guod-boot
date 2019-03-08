package cn.hacz.edu.xml;

import cn.hacz.edu.xmlvo.BodyVo;
import cn.hacz.edu.xmlvo.DivVo;
import cn.hacz.edu.xmlvo.HeadVo;
import cn.hacz.edu.xmlvo.RootVo;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * project - GitHub整理 ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/8 时间:11:28
 * @JDK 1.8
 * @Description 功能模块：
 */
public class XmlMainTest01 {
    public static void main(String[] args) throws Exception {
        RootVo rootVo = new RootVo();
        HeadVo headVo = new HeadVo();
        BodyVo bodyVo = new BodyVo();
        rootVo.setBodyVo(bodyVo);
        rootVo.setHeadVo(headVo);
        List<DivVo> divVos = new ArrayList<>();
        DivVo divVo01 = new DivVo();
        DivVo divVo02 = new DivVo();
        divVos.add(divVo01);
        divVos.add(divVo02);
        bodyVo.setDivVoList(divVos);
        bodyVo.setSize(bodyVo.getDivVoList().size());
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
        // 序列化成标准的XML格式
        String s = xmlMapper.writeValueAsString(rootVo);
        System.out.println(s);
        // 反序列化成pojo对象
        RootVo rootVoObject = xmlMapper.readValue(s, RootVo.class);
        System.out.println(rootVoObject.getHeadVo().getScript());
    }
}
