package com.optum.accountdgs.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.optum.accountdgs.generated.types.AccountInput;
import com.optum.accountdgs.generated.types.TransactionInput;
import com.optum.accountdgs.models.Account;
import com.optum.accountdgs.models.Transaction;
import com.optum.accountdgs.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class AccountDataFetcher {

    @Autowired
    private AccountRepository accountRepository;

    @DgsQuery
    public List<Account> showAccounts(){

    }

    @DgsQuery
    public Account showAccount(@InputArgument("accountNo") String accountNo){

    }

    @DgsMutation
    public Account addAccount(@InputArgument("accountInput") AccountInput accountInput){
        Account account = Account.builder()
                .accountId(accountInput.getAccountId())
                .openDate(accountInput.getOpenDate())
                .runningTotal(accountInput.getRunningTotal())
                .transactions(mapAccountTransactions(accountInput.getTransactions()))
                .build();
        Account accountResponse = accountRepository.save(account);
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
