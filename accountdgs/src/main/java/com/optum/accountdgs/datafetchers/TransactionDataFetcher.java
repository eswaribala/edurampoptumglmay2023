package com.optum.accountdgs.datafetchers;

import com.netflix.graphql.dgs.*;
import com.optum.accountdgs.models.Account;
import com.optum.accountdgs.models.Transaction;
import com.optum.accountdgs.models.TransactionInput;
import com.optum.accountdgs.repositories.AccountRepository;
import com.optum.accountdgs.repositories.TransactionRepository;
import graphql.schema.DataFetchingEnvironment;
import org.dataloader.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.CompletableFuture;

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



    @DgsData(parentType = "Transaction", field = "account")
    public CompletableFuture<Account> account(DataFetchingEnvironment dfe) {
        DataLoader<String,Account> dataLoader = dfe.getDataLoader("accounts");
        Transaction transaction = dfe.getSource();
        return dataLoader.load(transaction.getAccount().getAccountId());
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
