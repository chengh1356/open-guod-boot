
package cn.hacz.edu.consumer;

import cn.hacz.edu.domain.CmdMessage;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;

import java.util.List;
import java.util.Optional;

/**
 * Simple to Introduction
 * className: MyListener
 *
 * @author EricYang
 * @version 2018/5/12 18:33
 */

@Slf4j
public class MyListener {
    private static final String TOPIC01 = "topic01";
    private static final String TOPIC02 = "topic02";

    @KafkaListener(id = "id0", topicPartitions = {@TopicPartition(topic = TOPIC01, partitions = {"0"})})
    public void listenPartition0(List<ConsumerRecord<?, ?>> records) {
        log.info("Id0 Listener, Thread ID: " + Thread.currentThread().getId());
        log.info("Id0 records size " + records.size());

        for (ConsumerRecord<?, ?> record : records) {
            Optional<?> kafkaMessage = Optional.ofNullable(record.value());
            log.info("Received: " + record);
            if (kafkaMessage.isPresent()) {
                Object message = record.value();
                CmdMessage cmdMessage = JSONUtil.toBean(JSONUtil.toJsonStr(record.value()), CmdMessage.class);
                System.out.println(cmdMessage.getId());
                String topic = record.topic();
                log.info("p0 Received message={}", message);
            }
        }
    }

    @KafkaListener(id = "id1", topicPartitions = {@TopicPartition(topic = TOPIC02, partitions = {"1"})})
    public void listenPartition1(List<ConsumerRecord<?, ?>> records) {
        log.info("Id1 Listener, Thread ID: " + Thread.currentThread().getId());
        log.info("Id1 records size " + records.size());

        for (ConsumerRecord<?, ?> record : records) {
            Optional<?> kafkaMessage = Optional.ofNullable(record.value());
            log.info("Received: " + record);
            if (kafkaMessage.isPresent()) {
                Object message = record.value();
                String topic = record.topic();
                log.info("p1 Received message={}", message);
            }
        }
    }

    @KafkaListener(id = "id2", topicPartitions = {@TopicPartition(topic = TOPIC02, partitions = {"2"})})
    public void listenPartition2(List<ConsumerRecord<?, ?>> records) {
        log.info("Id2 Listener, Thread ID: " + Thread.currentThread().getId());
        log.info("Id2 records size " + records.size());

        for (ConsumerRecord<?, ?> record : records) {
            Optional<?> kafkaMessage = Optional.ofNullable(record.value());
            log.info("Received: " + record);
            if (kafkaMessage.isPresent()) {
                Object message = record.value();
                String topic = record.topic();
                log.info("p2 Received message={}", message);
            }
        }
    }

    @KafkaListener(id = "id3", topicPartitions = {@TopicPartition(topic = TOPIC02, partitions = {"3"})})
    public void listenPartition3(List<ConsumerRecord<?, ?>> records) {
        log.info("Id3 Listener, Thread ID: " + Thread.currentThread().getId());
        log.info("Id3 records size " + records.size());

        for (ConsumerRecord<?, ?> record : records) {
            Optional<?> kafkaMessage = Optional.ofNullable(record.value());
            log.info("Received: " + record);
            if (kafkaMessage.isPresent()) {
                Object message = record.value();
                String topic = record.topic();
                log.info("p3 Received message={}", message);
            }
        }
    }
}
