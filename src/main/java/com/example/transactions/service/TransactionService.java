package com.example.transactions.service;

import com.example.transactions.exception.ResourceNotFoundException;
import com.example.transactions.model.Transaction;
import com.example.transactions.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> findByStatus(String status) {
        return transactionRepository.findByStatus(status);
    }

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Optional<Transaction> findById(Long id) {
        return transactionRepository.findById(id);
    }

    public Transaction auditTransaction(Long id, String status) {
        Transaction transaction = findById(id).orElseThrow(() -> new ResourceNotFoundException("Transaction not found"));
        transaction.setStatus(status);
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsByStatus(String status) {
        if ("all".equalsIgnoreCase(status)) {
            return transactionRepository.findAll();
        } else {
            return transactionRepository.findByStatus(status);
        }
    }
}
