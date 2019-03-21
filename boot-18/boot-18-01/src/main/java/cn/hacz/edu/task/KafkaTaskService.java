package cn.hacz.edu.task;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/3/15 时间:17:20
 * @JDK 1.8
 * @Description 功能模块：
 */
@Service
public class KafkaTaskService {
    private static final Logger log = LoggerFactory.getLogger(KafkaTaskService.class);
    @Autowired
    private KafkaListenerEndpointRegistry registry;

    /**
     * 定时执行
     *
     * @param recordList
     * @param acknowledgment
     */
    @KafkaListener(id = "test-task", topics = {"test-task"}, groupId = "test-topic", containerFactory = "batchFactory")
    public void listenFailEmail(List<ConsumerRecord> recordList, Acknowledgment acknowledgment) {
        for (ConsumerRecord record : recordList) {
            log.info("fail email-消息：[{}]", record.toString());
        }
        acknowledgment.acknowledge();
    }

    @Scheduled(cron = "0 48 17 * * ?")
    public void startListener() {
        log.info("开启监听");
        MessageListenerContainer container = registry.getListenerContainer("topic01");
        if (!container.isRunning()) {
            container.start();
        }
        //恢复
        container.resume();
    }

    @Scheduled(cron = "0 49 17 * * ?")
    public void shutdownListener() {
        log.info("关闭监听");
        //暂停
        MessageListenerContainer container = registry.getListenerContainer("topic01");
        container.pause();
    }


    /**
     * kafka监听工厂
     *
     * @param configurer
     * @return
     */
    @Bean("batchFactory")
    public ConcurrentKafkaListenerContainerFactory<?, ?> kafkaListenerContainerFactory(
            ConcurrentKafkaListenerContainerFactoryConfigurer configurer,
            ConsumerFactory consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        //开启批量消费功能
        factory.setBatchListener(true);
        //不自动启动
        factory.setAutoStartup(false);
        configurer.configure(factory, consumerFactory);
        return factory;
    }
}
