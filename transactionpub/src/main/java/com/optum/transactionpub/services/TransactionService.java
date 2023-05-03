package com.optum.transactionpub.services;

import com.optum.transactionpub.facades.TransactionFacade;
import com.optum.transactionpub.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
public class TransactionService {
    @Autowired
    TransactionFacade transactionFacade;

    public boolean publishTransaction(Transaction transaction){

       MessageChannel messageChannel= transactionFacade.sendChannel();
        return messageChannel.send(MessageBuilder
                .withPayload(transaction)
                .setHeader(MessageHeaders.CONTENT_TYPE,
                        MimeTypeUtils.APPLICATION_JSON)
                .build());

    }

}
