package com.bouteille.payetonskin.server.rest;

import com.bouteille.payetonskin.server.business.AccountBusiness;
import com.bouteille.payetonskin.server.businessmodel.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private AccountBusiness accountBusiness;

    @Autowired
    public AccountController(AccountBusiness accountBusiness) {
        this.accountBusiness = accountBusiness;
    }

    @PostMapping
    public @ResponseBody
    Account createAccount(@RequestBody Account account) {
        return accountBusiness.createAccount(account);
    }

    @GetMapping
    public List<Account> getAccounts() {
        return accountBusiness.getAccounts();
    }
}
