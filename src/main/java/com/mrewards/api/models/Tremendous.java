package com.mrewards.api.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Tremendous {
    private int tremendousId;
    private int orderId;
    private String createdAt;
    private String value;
    private String deliveryType;
    private String status;
    private Recipient recipient;
}
