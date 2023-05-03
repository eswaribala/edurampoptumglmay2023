package com.optum.messagedgs.fetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;

import com.optum.graphqlmusicstoremaven.generated.types.Message;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@DgsComponent
public class MessageFetcher {
@Autowired
    private Faker faker;
    private List<Message> messageList=new ArrayList<Message>();

@DgsQuery
 public List<Message> showMessages(){
   return getMessages();
 }

 @DgsQuery
 public Message showMessage(int id){
   return getMessages().stream().filter(x->x.getId() <= id).findFirst().orElse(null);
 }

 private List<Message> getMessages(){
   
     for(int i=0;i<100;i++) {
         var messageObj = Message.newBuilder().id(faker.random().nextInt(10000)).info(faker.country().name()).build();
         messageList.add(messageObj);
     }
     return messageList;
 }

}
