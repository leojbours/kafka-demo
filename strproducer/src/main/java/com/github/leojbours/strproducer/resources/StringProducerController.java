package com.github.leojbours.strproducer.resources;

import com.github.leojbours.strproducer.controller.StringProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/string-producer")
@RequiredArgsConstructor
public class StringProducerController {

  private final StringProducerService stringProducerService;

  @PostMapping
  public ResponseEntity<?> send(@RequestBody String message) {
    stringProducerService.send(message);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
