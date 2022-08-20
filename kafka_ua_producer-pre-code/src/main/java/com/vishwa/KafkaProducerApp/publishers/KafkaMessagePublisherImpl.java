package com.vishwa.KafkaProducerApp.publishers;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class KafkaMessagePublisherImpl implements MessagePublisher {

    @Override
    public void publish(String topicName, String key, String value) {

        /**
         * will have the logic for sending the message to a kafka topic ...
         */

        Properties properties = new Properties();
        properties.put("bootstrap.servers", "127.0.0.1:9092");

        // key and value serializers

        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // partitioning logic

        properties.put("partitioner.class", "org.apache.kafka.clients.producer.internals.DefaultPartitioner");


        /**
         * create a Producer Object
         */

        Producer<String, String> producer = new KafkaProducer<String, String>(properties);

        /**
         * publishing the messages ...
         */

        System.out.println("producing the message to kafka");

        producer.send(new ProducerRecord<String, String>(topicName, key, value));

        /**
         * close the producer connection ...
         */

        producer.close();

    }
}
