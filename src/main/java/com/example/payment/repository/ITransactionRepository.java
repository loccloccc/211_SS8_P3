package com.example.payment.repository;

import com.example.payment.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionRepository
        extends JpaRepository<Transaction, Long> {
}