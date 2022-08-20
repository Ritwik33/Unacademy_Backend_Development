package com.vishwa.KafkaProducerApp.services;

import java.io.IOException;

import com.vishwa.KafkaProducerApp.publishers.KafkaMessagePublisherImpl;
import com.vishwa.KafkaProducerApp.publishers.MessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MessageServiceImpl implements MessageService{

  @Autowired
  private KafkaMessagePublisherImpl kafkaMessagePublisher;

  @Override
  public void produceMessage(String topicName, String key, String value) throws IOException {

    /**
     * logic for sending message to kafka
     */

    kafkaMessagePublisher.publish(topicName, key, value);

  }
}
