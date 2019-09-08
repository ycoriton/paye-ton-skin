package com.bouteille.payetonskin.server.business;

import com.bouteille.payetonskin.server.businessmodel.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface AccountBusiness {

    Account createAccount(Account account);

    Account getAccount(UUID accountId);

    List<Account> getAccounts();

    Account updateAccount(Account account, UUID accountId);

    ResponseEntity<?> deleteAccount(UUID accountId);
}
