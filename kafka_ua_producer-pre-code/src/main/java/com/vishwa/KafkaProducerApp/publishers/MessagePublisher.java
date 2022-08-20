package com.vishwa.KafkaProducerApp.publishers;

/**
 * contract for sending/publishing message to kafka
 */
public interface MessagePublisher {

    public void publish(String topicName, String key, String value);

}
