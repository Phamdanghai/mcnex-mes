package mcnex.com.mes.systemmanagement.service.impl;

import mcnex.com.mes.systemmanagement.doman.Madmaccdef;
import mcnex.com.mes.systemmanagement.dto.response.AccountResponse;
import mcnex.com.mes.systemmanagement.repository.MadmaccdefRepository;
import mcnex.com.mes.systemmanagement.service.AdmaccService;
import mcnex.com.mes.systemmanagement.service.mapper.AdmaccMapper;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdmaccServiceImpl implements AdmaccService {
    final MadmaccdefRepository madmaccdefRepository;

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
}
