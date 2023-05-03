package com.optum.messagedgs.fetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.optum.messagedgs.models.Message;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@DgsComponent
public class MessageFetcher {



@DgsQuery
 public List<Message> showMessages(){
   return getMessages();
 }

 @DgsQuery
 public Message showMessage(int id){
   return getMessages().stream().filter(x->x.getId()==id).findFirst().orElse(null);
 }

 private List<Message> getMessages(){
     List<Message> messageList=  List.of(new Message(new Random().nextInt(1000000),"M1"),
             new Message(new Random().nextInt(1000000),"M2"),
             new Message(new Random().nextInt(1000000),"M3"),
     new Message(new Random().nextInt(1000000),"M4"),
             new Message(new Random().nextInt(1000000),"M5"));
     return messageList;
 }

}
