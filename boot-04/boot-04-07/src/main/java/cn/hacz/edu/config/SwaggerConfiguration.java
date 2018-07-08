/**
 *
 */
package cn.hacz.edu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * project - ETC发票系统
 *
 * @author guod 
 * @date 日期:2018年4月21日 时间:下午12:16:49
 * @JDK 1.8 
 * @version 3.0
 * @Description 功能模块： 
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	@Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.hacz.edu.controllerr"))
                .paths(PathSelectors.any())
                .build();
    }

    @SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("使用Swagger2构建RESTful APIs")
                .description("关注博主博客：https://www.jianshu.com/u/88339594d03e")
                .termsOfServiceUrl("https://www.jianshu.com/u/88339594d03e")
                .contact("guod")
                .version("1.0")
                .build();
    }
}
