package com.optum.transactionpub.facades;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TransactionFacade {

    String outputChannel="out-channel";
    @Output(outputChannel)
    MessageChannel sendChannel();

}
