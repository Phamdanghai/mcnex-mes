package mcnex.com.mes.systemmanagement.service.impl;

import mcnex.com.mes.systemmanagement.doman.Madmaccdef;
import mcnex.com.mes.systemmanagement.dto.response.AccountResponse;
import mcnex.com.mes.systemmanagement.repository.MadmaccdefRepository;
import mcnex.com.mes.systemmanagement.service.AdmaccService;
import mcnex.com.mes.systemmanagement.service.mapper.AdmaccMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AdmaccServiceImpl implements AdmaccService {
    final MadmaccdefRepository madmaccdefRepository;

    @Autowired
    RestTemplate restTemplate = new RestTemplate();

    final AdmaccMapper admaccMapper;

    public AdmaccServiceImpl(MadmaccdefRepository madmaccdefRepository, AdmaccMapper admaccMapper) {
        this.madmaccdefRepository = madmaccdefRepository;
        this.admaccMapper = admaccMapper;
    }

    @Override
    public List<AccountResponse> getAllUser() {
        List<Madmaccdef> accountList = madmaccdefRepository.findAll();
        if (accountList.isEmpty()) {
            throw new NotFoundException("Not found account");
        }

        List<AccountResponse> accountResponseList = new ArrayList<>();
        accountList.forEach(a -> accountResponseList.add(admaccMapper.AccountToAccountResponse(a)));
        return accountResponseList;
    }

    @Override
    public AccountResponse getAccByUser_id(String user_id) {
        AccountResponse accountResponse;
        accountResponse = restTemplate.getForEntity(
                "http://localhost:8081/accounts/" + user_id,
                AccountResponse.class).getBody();
        System.out.println(accountResponse);
        return accountResponse;
    }
}
