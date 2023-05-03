package com.optum.customerapi.subscriptions;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.optum.customerapi.dto.TransactionDTO;
import com.optum.customerapi.facades.TransactionFacade;
import com.optum.customerapi.services.TransactionConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TransactionSubscriptionResolver implements GraphQLSubscriptionResolver {
@Autowired
 private TransactionConsumerService transactionConsumerService;

    public TransactionDTO showTransaction(){

        log.info("Transaction Received" + transactionConsumerService.transactionDTO);

       if(transactionConsumerService.transactionDTO!=null)
        return transactionConsumerService.transactionDTO;
       else
           return null;
    }



}