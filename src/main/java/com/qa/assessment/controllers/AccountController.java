package com.qa.assessment.controllers;

import com.qa.assessment.dtos.AccountDTO;
import com.qa.assessment.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    AccountService accountService;
    void setAccountServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAll() {
        return new ResponseEntity<>( accountService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody AccountDTO dto) {
        return new ResponseEntity<>( accountService.create( dto), HttpStatus.OK);
    }
}
