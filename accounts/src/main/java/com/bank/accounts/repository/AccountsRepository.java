package com.bank.accounts.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.bank.accounts.entity.Accounts;

import jakarta.transaction.Transactional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts,Long> {

    Optional<Accounts> findByCustId(long custId);

    @Transactional
    @Modifying
    void deleteByCustId(long id);

    
}