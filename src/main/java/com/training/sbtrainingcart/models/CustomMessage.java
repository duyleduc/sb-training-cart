package com.training.sbtrainingcart.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public record CustomMessage(@JsonProperty("itemId") String itemId,@JsonProperty("quantity") Long quantity) implements Serializable {
}
