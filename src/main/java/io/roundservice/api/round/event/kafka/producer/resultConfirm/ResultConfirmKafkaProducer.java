package io.roundservice.api.round.event.kafka.producer.resultConfirm;

import io.roundservice.api.round.event.kafka.producer.resultConfirm.event.ResultConfirmEvent;
import io.roundservice.api.round.event.kafka.producer.resultConfirm.event.ResultConfirmEventRecord;
import io.roundservice.common.event.kafka.producer.GenericKafkaProducer;
import io.roundservice.common.mapper.ObjectMapper;
import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.LongSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Component
public class ResultConfirmKafkaProducer extends GenericKafkaProducer<ResultConfirmEvent, Long, ResultConfirmEventRecord> {

    protected ResultConfirmKafkaProducer(@Value("${spring.kafka.broker.url}") String brokerUrl, @Value("${spring.kafka.topic.round.result-confirm}")String topic) {
        super(topic);
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerUrl);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ObjectMapper.class.getName());
        kafkaProducer = new KafkaProducer<>(props);
    }

    @Override
    public Class<ResultConfirmEvent> getEventClass() {
        return ResultConfirmEvent.class;
    }

    @Override
    public void send(ResultConfirmEvent event) {
        kafkaProducer.send(produce(event));
    }

    @Override
    protected ProducerRecord<Long, ResultConfirmEventRecord> produce(ResultConfirmEvent event) {
        return convertToRecord(event);
    }

    @Override
    protected ProducerRecord<Long, ResultConfirmEventRecord> convertToRecord(ResultConfirmEvent event) {
        EnterGameMessage message = (EnterGameMessage) event;
        return new ProducerRecord<>(TOPIC, 0, message.userId(), message.getRecordValue());
    }
}
