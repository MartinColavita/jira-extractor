package com.eldar.business.jiraextractor.domain.repositories;

import com.eldar.business.jiraextractor.domain.entities.Role;
import com.eldar.business.jiraextractor.utils.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author claudio.vilas
 * date 01/2024
 * description repositorio para entidad role
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(RoleName roleName);
}
