package com.qa.assessment.services;

import com.qa.assessment.dtos.AccountDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    // Temporary cache of accounts
    private static List<AccountDTO> accountsCache = new ArrayList<>();
    static {
        accountsCache.add( new AccountDTO( Long.valueOf( 1L), "John", "Doe", "1234"));
        accountsCache.add( new AccountDTO( Long.valueOf( 2L), "Jane", "Doe", "1235"));
        accountsCache.add( new AccountDTO( Long.valueOf( 3L), "Jim", "Taylor", "1236"));
    }

    public List<AccountDTO> getAll() {
        return accountsCache;
    }

    public String create( AccountDTO dto) {
        dto.setId( nextId());
        accountsCache.add( dto);
        return "Account has been successfully added";
    }

    private Long nextId() {
        Long result = accountsCache.stream().mapToLong(dto -> dto.getId()).max().getAsLong();
        return ++result;
    }
}
