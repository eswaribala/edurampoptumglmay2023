package com.optum.customerapi.subscriptions;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.optum.customerapi.dto.TransactionDTO;
import com.optum.customerapi.facades.TransactionFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TransactionSubscriptionResolver implements GraphQLSubscriptionResolver {

    private ObjectMapper objectMapper;
    private TransactionDTO transactionDTO;

    @StreamListener(target = TransactionFacade.inChannel)

    public TransactionDTO showTransactions(String message){
        log.info("Transaction Received" + message);

        objectMapper = new ObjectMapper();
        try {
            transactionDTO = objectMapper.readValue(message, TransactionDTO.class);
            log.info("Java Object" + transactionDTO);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return transactionDTO;
    }



}
