package mcnex.com.mes.systemmanagement.controller;

import mcnex.com.mes.systemmanagement.dto.response.AccountResponse;
import mcnex.com.mes.systemmanagement.service.AdmaccService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    final AdmaccService admaccService;
    @Autowired
    RestTemplate restTemplate;

    public AccountController(AdmaccService admaccService) {
        this.admaccService = admaccService;
    }
    @GetMapping
    List<AccountResponse> getAllAccount() {
        return admaccService.getAllUser();
    }

    @GetMapping("/{userId}")
    AccountResponse getAccount(@PathVariable String userId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return admaccService.getAccByUser_id(userId);
    }
}
