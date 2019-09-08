package com.bouteille.payetonskin.server.business.mapper;

import com.bouteille.payetonskin.server.businessmodel.Account;
import com.bouteille.payetonskin.server.model.AccountEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "entity.uuid"),
            @Mapping(target = "username", source = "entity.username"),
            @Mapping(target = "password", source = "entity.password"),
            @Mapping(target = "salt", source = "entity.salt"),
            @Mapping(target = "email", source = "entity.email")
    })
    Account toAccount(AccountEntity entity);

    List<Account> toAccounts(List<AccountEntity> entities);

    @InheritInverseConfiguration
    AccountEntity toEntity(Account business);
}
