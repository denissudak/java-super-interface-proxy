package com.denissudak.superinterfaceproxy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Invoice {

    private String invoiceNumber;

    private String customerId;

    private BigDecimal total;

}
