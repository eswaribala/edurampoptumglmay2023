package com.optum.customerapi.facades;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(TransactionFacade.class)
public class StreamConfig {
}
