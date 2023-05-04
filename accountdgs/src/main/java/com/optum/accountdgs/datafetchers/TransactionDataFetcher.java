package com.optum.accountdgs.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.optum.accountdgs.models.Account;
import com.optum.accountdgs.models.Transaction;
import com.optum.accountdgs.models.TransactionInput;
import com.optum.accountdgs.repositories.AccountRepository;
import com.optum.accountdgs.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DgsComponent
public class TransactionDataFetcher {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountRepository accountRepository;

    @DgsQuery
    public List<Transaction> showTransactions(){

        return this.transactionRepository.findAll();
    }

    @DgsQuery
    public Transaction showTransaction(@InputArgument("transactionId") String transactionId){

        return this.transactionRepository.findById(transactionId).orElse(null);
    }

    @DgsMutation
    public Transaction  addTransaction(@InputArgument("transactionInput")TransactionInput transactionInput){

        Account account=this.accountRepository.findById(transactionInput.getAccount().getAccountId()).orElse(null);

        if(account!=null) {
            Transaction transaction = Transaction.builder()
                    .transactionId(transactionInput.getTransactionId())
                    .amount(transactionInput.getAmount())
                    .receiver(transactionInput.getReceiver())
                    .sender(transactionInput.getSender())
                    .timeStamp(transactionInput.getTimeStamp())
                    .account(account).build();
           return this.transactionRepository.save(transaction);
        }else {
            return null;
        }


    }

}
