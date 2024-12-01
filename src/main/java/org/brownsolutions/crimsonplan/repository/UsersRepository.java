package org.brownsolutions.crimsonplan.repository;

import org.brownsolutions.crimsonplan.domain.entity.Users;
import org.brownsolutions.crimsonplan.domain.type.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * English:
 * Repository interface for managing {@link Users} entities.
 * <p>Extends {@link org.springframework.data.jpa.repository.JpaRepository} to provide standard CRUD operations.
 * Includes custom queries for updating specific fields and finding a user by email.</p>
 *
 * Português:
 * Interface de repositório para gerenciar entidades {@link Users}.
 * <p>Estende {@link org.springframework.data.jpa.repository.JpaRepository} para fornecer operações CRUD padrão.
 * Inclui consultas personalizadas para atualizar campos específicos e encontrar um usuário pelo e-mail.</p>
 */
public interface UsersRepository extends JpaRepository<Users, Long> {

    /**
     * English:
     * Finds a user by their email address.
     *
     * @param email the email address of the user
     * @return an {@link Optional} containing the user if found, or empty if not found
     * <br>
     * Português:
     * Encontra um usuário pelo seu endereço de e-mail.
     *
     * @param email o endereço de e-mail do usuário
     * @return um {@link Optional} contendo o usuário, se encontrado, ou vazio caso contrário
     */
    Optional<Users> findByEmail(String email);

    /**
     * English:
     * Updates the username of a user by their ID.
     *
     * @param id the ID of the user
     * @param username the new username to set
     * <br>
     * Português:
     * Atualiza o nome de usuário de um usuário pelo seu ID.
     *
     * @param id o ID do usuário
     * @param username o novo nome de usuário a ser definido
     */
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Users u SET u.username = :username WHERE u.id = :id")
    void updateUsername(Long id, String username);

    /**
     * English:
     * Updates the biography of a user by their ID.
     *
     * @param id the ID of the user
     * @param biography the new biography to set
     * <br>
     * Português:
     * Atualiza a biografia de um usuário pelo seu ID.
     *
     * @param id o ID do usuário
     * @param biography a nova biografia a ser definida
     */
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Users u SET u.biography = :biography WHERE u.id = :id")
    void updateBiography(Long id, String biography);

    /**
     * English:
     * Updates the type of a user by their ID.
     *
     * @param id the ID of the user
     * @param type the new {@link UserType} to set
     * <br>
     * Português:
     * Atualiza o tipo de um usuário pelo seu ID.
     *
     * @param id o ID do usuário
     * @param type o novo {@link UserType} a ser definido
     */
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Users u SET u.type = :type WHERE u.id = :id")
    void updateUsersType(Long id, UserType type);
}
