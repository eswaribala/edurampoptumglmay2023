package com.optum.customerapi.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.optum.customerapi.dto.TransactionDTO;
import com.optum.customerapi.facades.TransactionFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TransactionConsumerService {
    private ObjectMapper objectMapper;
    private TransactionDTO transactionDTO;

    @StreamListener(target = TransactionFacade.inChannel)
    public void consumeTransaction(String message) {

        log.info("Transaction Received" + message);

        objectMapper = new ObjectMapper();
        try {
            transactionDTO = objectMapper.readValue(message, TransactionDTO.class);
            log.info("Java Object" + transactionDTO);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
