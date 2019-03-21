# 容器的依赖
FROM hub.c.163.com/wuxukun/maven-aliyun:3-jdk-8

# 校正容器时间
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo "Asia/Shanghai" > /etc/timezone

# 获取打包后的jar
COPY target/*.jar boot.jar

RUN bash -c 'touch ./boot.jar'

# 指定端口
EXPOSE 8080

# 进行启动
CMD ["java", "-jar", "boot.jar", "--spring.profiles.active=prod"]