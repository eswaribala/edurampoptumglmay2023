package com.optum.accountdgs.repositories;

import com.optum.accountdgs.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
