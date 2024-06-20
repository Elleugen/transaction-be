package com.example.transactions.controller;

import com.example.transactions.exception.ResourceNotFoundException;
import com.example.transactions.model.Transaction;
import com.example.transactions.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

//    @GetMapping
//    public List<Transaction> getTransactions(@RequestParam(required = false, defaultValue = "all") String status) {
//        return transactionService.findByStatus(status);
//    }

    @GetMapping
    public List<Transaction> getTransactions(@RequestParam(required = false, defaultValue = "all") String status) {
        return transactionService.getTransactionsByStatus(status);
    }

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.saveTransaction(transaction);
    }

    @GetMapping("/{id}")
    public Transaction getTransaction(@PathVariable Long id) {
        return transactionService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Transaction not found"));
    }

    @PutMapping("/{id}/audit")
    public Transaction auditTransaction(@PathVariable Long id, @RequestBody String status) {
        return transactionService.auditTransaction(id, status);
    }
}
