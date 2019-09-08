package com.bouteille.payetonskin.server.jpa;

import com.bouteille.payetonskin.server.model.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, UUID> {

    @Query("SELECT e FROM AccountEntity e WHERE username = :username")
    Optional<AccountEntity> findAccountEntityByUsername(@Param("username") String username);

    @Query("SELECT e FROM AccountEntity e WHERE email = :email")
    Optional<AccountEntity> findAccountEntityByEmail(@Param("email") String email);
}
