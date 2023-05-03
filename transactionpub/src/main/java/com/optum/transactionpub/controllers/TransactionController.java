package com.optum.transactionpub.controllers;

import com.optum.transactionpub.models.Transaction;
import com.optum.transactionpub.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping({"/v1.0"})
    public ResponseEntity<?> publishTransaction(@RequestBody Transaction transaction){

        if(this.transactionService.publishTransaction(transaction))
            return ResponseEntity.status(HttpStatus.OK).body(transaction);
            else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Transaction not published");
        }
    }

}
