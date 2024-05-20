package mcnex.com.mes.systemmanagement.service.mapper;

import mcnex.com.mes.systemmanagement.doman.Madmaccdef;
import mcnex.com.mes.systemmanagement.dto.request.AccountRequest;
import mcnex.com.mes.systemmanagement.dto.response.AccountResponse;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface AdmaccMapper {
    Madmaccdef AccountRequestToAccount(AccountRequest accountRequest);

    AccountResponse AccountToAccountResponse(Madmaccdef account);

}
