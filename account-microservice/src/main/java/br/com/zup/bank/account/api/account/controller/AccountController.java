
package br.com.zup.bank.account.api.account.controller;

import br.com.zup.bank.account.api.account.domain.AbstractAccountOperations;
import br.com.zup.bank.account.api.account.domain.models.FirstAccessModel;
import br.com.zup.bank.account.api.account.domain.models.FirstPasswordModel;
import br.com.zup.bank.account.api.account.domain.models.transfer.Transfer;
import br.com.zup.bank.account.api.account.service.AccountService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController implements AbstractAccountOperations {
    
    @Autowired
    private AccountService accountService;

    @PostMapping(path = "/account/firstPassword")
    @Override
    public ResponseEntity createFirstPassword(@RequestBody FirstPasswordModel firstPasswordModel) {
        return accountService.createFirstPassword(firstPasswordModel);
    }

    @PostMapping(path = "/account", consumes = "application/json")
    @Override
    public ResponseEntity createNewAccount(@RequestParam(name = "proposalId") String proposalId) {
        return accountService.createNewAccount(proposalId);
    }

    @PostMapping(path = "/account/firstAccess")
    @Override
    public ResponseEntity firstAccess(@RequestBody FirstAccessModel firstAccessModel) {
        return accountService.firstAccess(firstAccessModel);
    }
    
    @PostMapping(path = "/account/transfer/in", consumes = "application/json")
    @Override
    public ResponseEntity receiveTransfers(@RequestBody ArrayList<Transfer> transferInfo) {
        return accountService.receiveTransfers(transferInfo);
    }
    
}
