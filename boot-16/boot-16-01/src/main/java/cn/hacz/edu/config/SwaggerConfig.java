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
 * 访问地址(端口号为7103测试地址、端口号为7102正式地址)
 * http://localhost:7402/swagger-ui.html
 *
 * @author Administrator
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("后台系统")
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.hacz.edu.modules.sys"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket createRestApiu() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("文件上传")
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.hacz.edu.modules.oss"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger RESTful APIs")
                .description("swagger RESTful APIs")
                .termsOfServiceUrl("http://www.test.com/")
                .contact("xiaoymin@foxmail.com")
                .version("1.0")
                .build();
    }
}