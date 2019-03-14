package cn.hacz.edu.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * project -
 *
 * @author yanfa07
 * @version 1.0
 * @date 日期:2019/3/14 时间:15:38
 * @JDK 1.8
 * @Description 功能模块：
 */
@Component
public class KafkaConsumer {
    @KafkaListener(topics = {"myTopic"})
    public void listen(ConsumerRecord<?, ?> record) {
        System.out.printf("topic = %s, offest = %d, value = %s\n", record.topic(), record.offset(), record.value());
    }
}
