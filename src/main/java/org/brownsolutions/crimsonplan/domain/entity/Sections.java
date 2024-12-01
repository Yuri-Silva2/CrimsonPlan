package org.brownsolutions.crimsonplan.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sections")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Sections {

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

    /**
     * English:
     * Indicates whether the entity is archived.
     * <p>This field is annotated with {@link jakarta.persistence.Column}. The default value is {@code false}, indicating that the entity is not archived.</p>
     *
     * Português:
     * Indica se a entidade está arquivada.
     * <p>Este campo é anotado com {@link jakarta.persistence.Column}. O valor padrão é {@code false}, indicando que a entidade não está arquivada.</p>
     */
    @Column
    private boolean archived = false;

    /**
     * English:
     * The chart associated with this entity.
     * <p>This field is annotated with {@link jakarta.persistence.ManyToOne} to define a many-to-one relationship with the {@code Chart} entity.
     * The {@link jakarta.persistence.JoinColumn} annotation specifies that the foreign key is stored in the column named {@code chart_id}, and the field is mandatory (nullable = false).</p>
     *
     * Português:
     * O gráfico associado a esta entidade.
     * <p>Este campo é anotado com {@link jakarta.persistence.ManyToOne} para definir um relacionamento muitos-para-um com a entidade {@code Chart}.
     * A anotação {@link jakarta.persistence.JoinColumn} especifica que a chave estrangeira é armazenada na coluna chamada {@code chart_id}, e o campo é obrigatório (nullable = false).</p>
     */
    @ManyToOne
    @JoinColumn(name = "charts_id", nullable = false)
    private Charts charts;
}
