package com.example.transactions.repository;

import com.example.transactions.model.Corporate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorporateRepository extends JpaRepository<Corporate, String> {
}
