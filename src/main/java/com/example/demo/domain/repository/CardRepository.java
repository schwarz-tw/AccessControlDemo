package com.example.demo.domain.repository;

import com.example.demo.domain.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository is already a bean.
public interface CardRepository extends JpaRepository<Card, Long> {
}
