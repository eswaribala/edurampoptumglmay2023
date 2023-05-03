package com.optum.customerapi.subscriptions;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.optum.customerapi.dto.TransactionDTO;
import com.optum.customerapi.facades.TransactionFacade;
import com.optum.customerapi.models.IndividualContactNo;
import com.optum.customerapi.services.TransactionConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
@Slf4j
public class TransactionSubscriptionResolver implements GraphQLSubscriptionResolver {
@Autowired
 private TransactionConsumerService transactionConsumerService;

    public Publisher<TransactionDTO> showTransaction(){

        log.info("Transaction Received" + transactionConsumerService.transactionDTO);

        return Flux.interval(Duration.ofSeconds(5))
                .map(num -> transactionConsumerService.transactionDTO);


    }



}