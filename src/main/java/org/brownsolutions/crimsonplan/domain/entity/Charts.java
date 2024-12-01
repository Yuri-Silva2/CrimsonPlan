package org.brownsolutions.crimsonplan.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "charts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Charts {

    /**
     * English:
     * The unique identifier for this entity
     *
     * <p>This field is annotated with {@link jakarta.persistence.Id}, marking it as the primary key
     * of the entity, and with {@link jakarta.persistence.GeneratedValue}, indicating that its value
     * is automatically generated. The {@code GenerationType.IDENTITY} strategy is used, which relies
     * on the underlying database to generate the identifier, typically as an auto-increment value.</p>
     *
     * Português:
     * O identificador único desta entidade.
     * <p>Este campo é anotado com {@link jakarta.persistence.Id}, marcando-o como a chave primária
     * da entidade, e com {@link jakarta.persistence.GeneratedValue}, indicando que seu valor é
     * gerado automaticamente. A estratégia {@code GenerationType.IDENTITY} é usada, o que depende
     * do banco de dados subjacente para gerar o identificador, normalmente como um valor auto-incrementado.</p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * English:
     * The title of the entity.
     * <p>This field is annotated with {@link jakarta.persistence.Column} to define specific column properties:
     * <ul>
     *   <li><b>length:</b> Specifies a maximum length of 15 characters for the title.</li>
     *   <li><b>nullable:</b> Indicates that the title cannot be null.</li>
     * </ul></p>
     *
     * Português:
     * O título da entidade.
     * <p>Este campo é anotado com {@link jakarta.persistence.Column} para definir propriedades específicas da coluna:
     * <ul>
     *   <li><b>length:</b> Especifica um comprimento máximo de 15 caracteres para o título.</li>
     *   <li><b>nullable:</b> Indica que o título não pode ser nulo.</li>
     * </ul></p>
     */
    @Column(length = 15, nullable = false)
    private String title;
}
