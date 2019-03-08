package cn.hacz.edu.config;

import org.activiti.engine.*;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

/**
 * project - GitHub整理 综合客户服务系统
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/9/30 时间:9:22
 * @JDK 1.8
 * @Description 功能模块：
 */
@Configuration
public class ActivitiConfig {
    @Autowired
    private DataSource dataSource;
    // @Autowired
    // private ResourcePatternResolver resourceLoader

    /**
     * 独立流程引擎配置：初始化配置，将创建28张表
     *
     * @return
     */
    @Bean
    public StandaloneProcessEngineConfiguration processEngineConfiguration() {
        StandaloneProcessEngineConfiguration configuration = new StandaloneProcessEngineConfiguration();
        configuration.setDataSource(dataSource);
        configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        configuration.setAsyncExecutorActivate(false);
        return configuration;
    }

    /**
     * 功能描述：工作流引擎
     *
     * @return
     */
    @Bean
    public ProcessEngine processEngine() {
        return processEngineConfiguration().buildProcessEngine();
    }

    /**
     * 功能描述：提供一系列管理流程部署和流程定义的API
     *
     * @return
     */
    @Bean
    public RepositoryService repositoryService() {
        return processEngine().getRepositoryService();
    }

    /**
     * 功能描述：在流程运行时对流程实例进行管理与控制
     *
     * @return
     */
    @Bean
    public RuntimeService runtimeService() {
        return processEngine().getRuntimeService();
    }

    /**
     * 功能描述：对流程任务进行管理，例如任务提醒、任务完成和创建任务等
     *
     * @return
     */
    @Bean
    public TaskService taskService() {
        return processEngine().getTaskService();
    }
}
