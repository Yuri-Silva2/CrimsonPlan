package org.brownsolutions.crimsonplan.repository;

import org.brownsolutions.crimsonplan.domain.entity.Users;
import org.brownsolutions.crimsonplan.domain.type.UserType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Timestamp;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class UsersRepositoryTest {

    /**
     * English:
     * Injects the {@link UsersRepository} for accessing and manipulating user data in the test.
     *
     * Português:
     * Injeta o {@link UsersRepository} para acessar e manipular dados de usuários no teste.
     */
    @Autowired
    private UsersRepository usersRepository;

    private Users users;

    /**
     * English:
     * Sets up the test data before each test case.
     * <p>Creates a new {@link Users} object using the {@code createUsers} method.</p>
     *
     * Português:
     * Configura os dados de teste antes de cada caso de teste.
     * <p>Cria um novo objeto {@link Users} usando o método {@code createUsers}.</p>
     */
    @BeforeEach
    void setup() {
        users = createUsers();
    }

    /**
     * English:
     * Tests the functionality of {@link UsersRepository}.
     * <p>Validates saving, retrieving, and updating user data.</p>
     *
     * Português:
     * Testa a funcionalidade do {@link UsersRepository}.
     * <p>Valida o salvamento, a recuperação e a atualização de dados de usuários.</p>
     */
    @Test
    @DisplayName("Test Users Repository")
    void test() {
        usersRepository.save(users);

        Optional<Users> user = usersRepository.findByEmail(users.getEmail());

        assertThat(user.isPresent()).isTrue();
        assertThat(user.get().getUsername()).isEqualTo(users.getUsername());
        assertThat(user.get().getEmail()).isEqualTo(users.getEmail());
        assertThat(user.get().getPassword()).isEqualTo(users.getPassword());
        assertThat(user.get().getType()).isEqualTo(users.getType());
        assertThat(user.get().getBiography()).isNotEmpty();

        usersRepository.updateBiography(user.get().getId(), "New biography");
        usersRepository.updateUsername(user.get().getId(), "Murilo");
        usersRepository.updateUsersType(user.get().getId(), UserType.ADMIN);

        Optional<Users> finalUser = usersRepository.findByEmail(users.getEmail());

        assertThat(finalUser.isPresent()).isTrue();
        assertThat(finalUser.get().getUsername()).isEqualTo("Murilo");
        assertThat(finalUser.get().getBiography()).isEqualTo("New biography");
        assertThat(finalUser.get().getType()).isEqualTo(UserType.ADMIN);
    }

    /**
     * English:
     * Tests the behavior of {@link UsersRepository} when attempting to save duplicate users.
     * <p>Ensures that saving a user with duplicate unique fields (e.g., email) throws a {@link DataIntegrityViolationException}.</p>
     *
     * Português:
     * Testa o comportamento do {@link UsersRepository} ao tentar salvar usuários duplicados.
     * <p>Garante que salvar um usuário com campos únicos duplicados (por exemplo, email) lança uma {@link DataIntegrityViolationException}.</p>
     */
    @Test
    @DisplayName("Test Users Repository")
    void test2() {
        // Save the initial user
        usersRepository.save(users);

        // Attempt to save a user with duplicate unique fields and expect an exception
        assertThatThrownBy(() -> usersRepository.save(createDuplicateUsers()))
                .isInstanceOf(DataIntegrityViolationException.class);
    }

    /**
     * English:
     * Creates a new {@link Users} object for use in tests.
     * <p>Fill the user with sample data such as username, email, password, type, biography, and creation timestamp.</p>
     *
     * Português:
     * Cria um novo objeto {@link Users} para uso nos testes.
     * <p>Preenche o usuário com dados de exemplo, como nome de usuário, e-mail, senha, tipo, biografia e timestamp de criação.</p>
     *
     * @return a new {@link Users} object
     */
    private Users createUsers() {
        return Users.builder()
                .username("Murilo Castro")
                .email("murilo_julio_castro@sitran.com.br")
                .password("senha@2024")
                .type(UserType.USER)
                .biography("Random User...")
                .created(Timestamp.valueOf("2024-11-30 15:25:00"))
                .build();
    }

    private Users createDuplicateUsers() {
        return Users.builder()
                .username("Murilao Castro")
                .email("murilo_julio_castro@sitran.com.br")
                .password("senha@2024")
                .type(UserType.USER)
                .biography("Random User...")
                .created(Timestamp.valueOf("2024-11-30 15:25:00"))
                .build();
    }
}
