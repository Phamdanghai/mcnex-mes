package mcnex.com.mes.systemmanagement.service;

import mcnex.com.mes.systemmanagement.dto.response.AccountResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdmaccService {
    List<AccountResponse> getAllUser();

    AccountResponse getAccByUser_id(String user_id);

}
