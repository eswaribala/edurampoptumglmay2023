package com.optum.accountdgs.datafetchers;

import com.netflix.graphql.dgs.*;

import com.optum.accountdgs.models.Account;
import com.optum.accountdgs.models.AccountInput;
import com.optum.accountdgs.models.Transaction;
import com.optum.accountdgs.models.TransactionInput;
import com.optum.accountdgs.repositories.AccountRepository;
import com.optum.accountdgs.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class AccountDataFetcher {

    @Autowired
    private AccountRepository accountRepository;
   @Autowired
    private TransactionRepository transactionRepository;

    @DgsQuery
    public List<Account> showAccounts(){

        return this.accountRepository.findAll();

    }

    @DgsData(parentType = "Account", field = "transactions")
    public List<Transaction> transactions(DgsDataFetchingEnvironment dgsDataFetchingEnvironment) {
        Account account = dgsDataFetchingEnvironment.getSource();
        List<Transaction> transactionsList = new ArrayList<>();
        for (Transaction transaction : account.getTransactions()) {
            Transaction transactionResponse = transactionRepository.findById(transaction.getTransactionId()).get();
            transactionsList.add(transactionResponse);
        }
        return transactionsList;
    }

    @DgsQuery
    public Account showAccount(@InputArgument("accountNo") String accountNo){

        return this.accountRepository.findById(accountNo).orElse(null);
    }

    @DgsMutation
    public Account addAccount(@InputArgument("accountInput") AccountInput accountInput){

        Account account = Account.builder()
                .accountId(accountInput.getAccountId())
                .openDate(accountInput.getOpenDate())
                .runningTotal(accountInput.getRunningTotal())
                .build();
        Account accountResponse = accountRepository.save(account);
        if(accountInput.getTransactions().size()>0){
            for(TransactionInput tran : accountInput.getTransactions()){
                Transaction transaction = Transaction.builder()
                        .transactionId(tran.getTransactionId())
                        .amount(tran.getAmount())
                        .sender(tran.getSender())
                        .receiver(tran.getReceiver())
                        .timeStamp(tran.getTimeStamp())
                        .account(account)
                        .build();
               this.transactionRepository.save(transaction);
            }
        }

        accountResponse.setTransactions(mapAccountTransactions(accountInput.getTransactions()));

        return accountResponse;
    }

    private List<Transaction> mapAccountTransactions(List<TransactionInput> transactionInput) {
        List<Transaction> transactionsList = transactionInput.stream().map(tranInput -> {
            Transaction transaction = Transaction.builder()
                    .transactionId(tranInput.getTransactionId())
                    .amount(tranInput.getAmount())
                    .sender(tranInput.getSender())
                    .receiver(tranInput.getReceiver())
                    .timeStamp(tranInput.getTimeStamp())
                    .build();
            return transaction;
        }).collect(Collectors.toList());
        return transactionsList;
    }
}
