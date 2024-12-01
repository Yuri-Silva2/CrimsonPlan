package org.brownsolutions.crimsonplan.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.brownsolutions.crimsonplan.domain.type.UserType;

import java.sql.Timestamp;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Users {

    /**
     * English:
     * The unique identifier for this entity
     *
     * <p>This field is annotated with {@link Id}, marking it as the primary key
     * of the entity, and with {@link GeneratedValue}, indicating that its value
     * is automatically generated. The {@code GenerationType.IDENTITY} strategy is used, which relies
     * on the underlying database to generate the identifier, typically as an auto-increment value.</p>
     *
     * Português:
     * O identificador único desta entidade.
     * <p>Este campo é anotado com {@link Id}, marcando-o como a chave primária
     * da entidade, e com {@link GeneratedValue}, indicando que seu valor é
     * gerado automaticamente. A estratégia {@code GenerationType.IDENTITY} é usada, o que depende
     * do banco de dados subjacente para gerar o identificador, normalmente como um valor auto-incrementado.</p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * English:
     * The username of the user.
     * <p>This field is annotated with {@link Column} to define specific column properties:
     * <ul>
     *     <li><b>length:</b> Specifies a maximum length of 5 characters for the username.</li>
     *     <li><b>length:</b> Ensures that the username must be unique in the database.</li>
     *     <li><b>length:</b> Indicates that the username cannot be null.</li>
     * </ul></p>
     *
     * Português:
     * O nome de usuário do usuário.
     * <p>Este campo é anotado com {@link Column} para definir propriedades específicas da coluna:
     * <ul>
     *     <li><b>length:</b> Especifica um comprimento máximo de 15 caracteres para o nome de usuário.</li>
     *     <li><b>length:</b> Garante que o nome de usuário seja único no banco de dados.</li>
     *     <li><b>length:</b> Indica que o nome de usuário não pode ser nulo.</li>
     * </ul></p>
     */
    @Column(length = 15, unique = true, nullable = false)
    private String username;

    /**
     * English:
     * The email address of the user.
     * <p>This field is annotated with {@link Column} to define specific column properties:
     * <ul>
     *   <li><b>unique:</b> Ensures that the email address must be unique in the database.</li>
     *   <li><b>nullable:</b> Indicates that the email address cannot be null.</li>
     * </ul></p>
     *
     * Português:
     * O endereço de e-mail do usuário.
     * <p>Este campo é anotado com {@link Column} para definir propriedades específicas da coluna:
     * <ul>
     *   <li><b>unique:</b> Garante que o endereço de e-mail seja único no banco de dados.</li>
     *   <li><b>nullable:</b> Indica que o endereço de e-mail não pode ser nulo.</li>
     * </ul></p>
     */
    @Column(unique = true, nullable = false)
    private String email;

    /**
     * English:
     * The password of the user.
     * <p>This field is annotated with {@link Column} to ensure it cannot be null.</p>
     *
     * Português:
     * A senha do usuário.
     * <p>Este campo é anotado com {@link Column} para garantir que ele não possa ser nulo.</p>
     */
    @Column(nullable = false)
    private String password;

    /**
     * English:
     * The type of the user.
     * <p>This field is annotated with {@link Column} to ensure it cannot be null.</p>
     *
     * Português:
     * O tipo de usuário.
     * <p>Este campo é anotado com {@link Column} para garantir que ele não possa ser nulo.</p>
     */
    @Column(nullable = false)
    private UserType type;

    /**
     * English:
     * The biography of the user.
     * <p>This field is optional and is annotated with {@link Column} without additional constraints.</p>
     *
     * Português:
     * A biografia do usuário.
     * <p>Este campo é opcional e é anotado com {@link Column} sem restrições adicionais.</p>
     */
    @Column
    private String biography;

    /**
     * English:
     * The timestamp of when the user was created.
     * <p>This field is annotated with {@link Column} and {@link Temporal} to store
     * the creation time. The {@link TemporalType#TIMESTAMP} is used to handle date and time values.</p>
     *
     * Português:
     * O carimbo de data e hora de quando o usuário foi criado.
     * <p>Este campo é anotado com {@link Column} e {@link Temporal} para armazenar
     * a data e hora de criação. O {@link TemporalType#TIMESTAMP} é usado para manipular valores de
     * data e hora.</p>
     */
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp created;
}
