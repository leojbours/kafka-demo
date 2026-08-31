package com.github.leojbours.strconsumer.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class KafkaExceptionHandler implements KafkaListenerErrorHandler {

  @Override
  public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
    log.error("Error processing message: {}, exception: {}", message, exception);
    return null;
  }
}
