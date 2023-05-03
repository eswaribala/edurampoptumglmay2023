package com.optum.customerapi.subscriptions;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.optum.customerapi.models.IndividualContactNo;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

@Component
public class IndividualSubscriptionResolver implements GraphQLSubscriptionResolver {

    public Publisher<IndividualContactNo> individualContactNo(long accountNo) {

        Random random = new Random();
        return Flux.interval(Duration.ofSeconds(5))
                .map(num -> new IndividualContactNo(accountNo, random.nextInt(10000000), LocalDateTime.now().toString()));
    }
}