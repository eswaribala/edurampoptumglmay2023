package com.optum.accountdgs.dataloaders;

import com.netflix.graphql.dgs.DgsDataLoader;
import com.optum.accountdgs.models.Account;
import com.optum.accountdgs.repositories.AccountRepository;
import org.dataloader.BatchLoader;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@DgsDataLoader(name="accounts")
public class AccountDataloader implements BatchLoader<String, Account> {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public CompletionStage<List<Account>> load(List<String> list) {
        return CompletableFuture.supplyAsync(() -> this.accountRepository.findAllById(list));
    }
}
