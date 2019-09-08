package com.bouteille.payetonskin.server.business.impl;

import com.bouteille.payetonskin.server.business.AccountBusiness;
import com.bouteille.payetonskin.server.business.exception.ResourceAlreadyExistsException;
import com.bouteille.payetonskin.server.business.mapper.AccountMapper;
import com.bouteille.payetonskin.server.businessmodel.Account;
import com.bouteille.payetonskin.server.jpa.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class AccountBusinessImpl implements AccountBusiness {

    private AccountRepository accountRepository;

    @Autowired
    public AccountBusinessImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount(Account account) {
        accountRepository.findAccountEntityByUsername(account.getUsername()).ifPresent(entity -> {
            throw new ResourceAlreadyExistsException("Account", "username", entity.getUsername());
        });

        accountRepository.findAccountEntityByEmail(account.getEmail()).ifPresent(entity -> {
            throw new ResourceAlreadyExistsException("Account", "email", entity.getEmail());
        });

        account.setId(UUID.randomUUID());

        return AccountMapper.INSTANCE.toAccount(accountRepository.save(AccountMapper.INSTANCE.toEntity(account)));
    }

    @Override
    public Account getAccount(UUID accountId) {
        return null;
    }

    @Override
    public List<Account> getAccounts() {
        return AccountMapper.INSTANCE.toAccounts(accountRepository.findAll());
    }

    @Override
    public Account updateAccount(Account account, UUID accountId) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteAccount(UUID accountId) {
        return null;
    }
}
