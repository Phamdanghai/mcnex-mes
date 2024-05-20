package mcnex.com.mes.systemmanagement.controller;

import mcnex.com.mes.systemmanagement.dto.response.AccountResponse;
import mcnex.com.mes.systemmanagement.service.AdmaccService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    final AdmaccService admaccService;

    public AccountController(AdmaccService admaccService) {
        this.admaccService = admaccService;
    }
    @GetMapping
    List<AccountResponse> getAllAccount() {
        return admaccService.getAllUser();
    }
}
