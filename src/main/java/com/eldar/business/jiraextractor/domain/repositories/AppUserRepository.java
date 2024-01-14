package com.eldar.business.jiraextractor.domain.repositories;

import com.eldar.business.jiraextractor.domain.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author claudio.vilas
 * date 01/2024
 * description reositorio para entidad AppUser
 */

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    List<AppUser> findByNameContainingIgnoreCaseOrSurnameContainingIgnoreCase(String name, String surname);
    @Query("SELECT u FROM AppUser u WHERE u.id <> :id and u.email = :email")
    AppUser mailInUse(Long id, String email);
    @Query("SELECT u FROM AppUser u WHERE u.id <> :id and u.username = :username")
    AppUser userNameInUse(Long id, String username);
    @Query("SELECT u FROM AppUser u WHERE u.enabled <> true")
    List<AppUser> getNotEnabled();
}
