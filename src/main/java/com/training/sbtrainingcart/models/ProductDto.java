package com.training.sbtrainingcart.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ProductDto implements Serializable {
//    private static final long serialVersionUID = -1138446817700416884L;
    @JsonProperty
    private Long id;
    @JsonProperty
    private String itemID;
    @JsonProperty
    private String itemName;
    @JsonProperty
    private Long quantity;
}
