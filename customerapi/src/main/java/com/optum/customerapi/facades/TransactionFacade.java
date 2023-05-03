package com.optum.customerapi.facades;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface TransactionFacade {
String inChannel="in-channel";
@Input(inChannel)
MessageChannel receiverChannel();

}
