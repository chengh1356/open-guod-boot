### 一、整合过程
1. 引入依赖 
2. yml配置 
3. 装配配置类 
4. 创建jobhandler执行器 
5. 进入xxl-job控制台新增执行器 
6. 使用新增的执行器开始任务 
7. 在业务模块中操作job的【增、删、改、查、暂停】

### 二、注意问题
1、执行器注册地址错误，配置正确的服务地址（http://127.0.0.1:8080/xxl-job-admin）
2、任务管理界面：执行器项目没启动或者启动失败
3、执行器注册地址为空
4. 执行器管理界面：里面至少要保留一个执行器，并且AppName需要和服务应用的AppName保持一致

