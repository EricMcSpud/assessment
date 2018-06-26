package com.qa.assessment.services;

import com.qa.assessment.dtos.AccountDTO;

import java.util.List;

public interface AccountService {

    List<AccountDTO> getAll();

    String create( AccountDTO dto);
}
