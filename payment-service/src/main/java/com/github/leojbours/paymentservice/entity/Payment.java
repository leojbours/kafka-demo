package com.github.leojbours.paymentservice.entity;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class Payment implements Serializable {
  private String id;
  private List<Long> productsIds;
  private Long buyerId;
  private Integer quantity;
}
