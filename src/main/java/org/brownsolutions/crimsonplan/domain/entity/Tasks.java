package org.brownsolutions.crimsonplan.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Tasks {

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
     * The task that precedes this one in a sequence.
     * <p>This field is annotated with {@link jakarta.persistence.OneToOne} to define a one-to-one relationship with the {@code Task} entity.
     * The {@link jakarta.persistence.JoinColumn} annotation specifies that the foreign key is stored in the column named {@code previous_task_id}.</p>
     *
     * Português:
     * A tarefa que precede esta em uma sequência.
     * <p>Este campo é anotado com {@link jakarta.persistence.OneToOne} para definir um relacionamento um-para-um com a entidade {@code Task}.
     * A anotação {@link jakarta.persistence.JoinColumn} especifica que a chave estrangeira é armazenada na coluna chamada {@code previous_task_id}.</p>
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "previous_tasks_id")
    private Tasks previousTasks = null;

    /**
     * English:
     * The task that follows this one in a sequence.
     * <p>This field is annotated with {@link jakarta.persistence.OneToOne} to define a one-to-one relationship with the {@code Task} entity.
     * The {@link jakarta.persistence.JoinColumn} annotation specifies that the foreign key is stored in the column named {@code next_task_id}.</p>
     *
     * Português:
     * A tarefa que segue esta em uma sequência.
     * <p>Este campo é anotado com {@link jakarta.persistence.OneToOne} para definir um relacionamento um-para-um com a entidade {@code Task}.
     * A anotação {@link jakarta.persistence.JoinColumn} especifica que a chave estrangeira é armazenada na coluna chamada {@code next_task_id}.</p>
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "next_tasks_id")
    private Tasks nextTasks = null;

    /**
     * English:
     * The title of the task.
     * <p>This field is annotated with {@link jakarta.persistence.Column} to define specific column properties:
     * <ul>
     *   <li><b>length:</b> Specifies a maximum length of 30 characters for the title.</li>
     *   <li><b>nullable:</b> Indicates that the title cannot be null.</li>
     * </ul></p>
     *
     * Português:
     * O título da tarefa.
     * <p>Este campo é anotado com {@link jakarta.persistence.Column} para definir propriedades específicas da coluna:
     * <ul>
     *   <li><b>length:</b> Especifica um comprimento máximo de 30 caracteres para o título.</li>
     *   <li><b>nullable:</b> Indica que o título não pode ser nulo.</li>
     * </ul></p>
     */
    @Column(length = 30, nullable = false)
    private String title;

    /**
     * English:
     * A detailed description of the task.
     * <p>This field is optional and is annotated with {@link jakarta.persistence.Column} without additional constraints.</p>
     *
     * Português:
     * Uma descrição detalhada da tarefa.
     * <p>Este campo é opcional e é anotado com {@link jakarta.persistence.Column} sem restrições adicionais.</p>
     */
    @Column
    private String description;

    /**
     * English:
     * The user responsible for the task.
     * <p>This field is annotated with {@link jakarta.persistence.ManyToOne} to define a many-to-one relationship with the {@code User} entity.
     * The {@link jakarta.persistence.JoinColumn} annotation specifies that the foreign key is stored in the column named {@code responsible_id}.</p>
     *
     * Português:
     * O usuário responsável pela tarefa.
     * <p>Este campo é anotado com {@link jakarta.persistence.ManyToOne} para definir um relacionamento muitos-para-um com a entidade {@code User}.
     * A anotação {@link jakarta.persistence.JoinColumn} especifica que a chave estrangeira é armazenada na coluna chamada {@code responsible_id}.</p>
     */
    @ManyToOne
    @JoinColumn(name = "responsible_id")
    private Users responsible = null;

    /**
     * English:
     * The user who acts as a backup responsible for the task.
     * <p>This field is annotated with {@link jakarta.persistence.ManyToOne} to define a many-to-one relationship with the {@code User} entity.
     * The {@link jakarta.persistence.JoinColumn} annotation specifies that the foreign key is stored in the column named {@code reserve_responsible_id}.</p>
     *
     * Português:
     * O usuário que atua como responsável reserva pela tarefa.
     * <p>Este campo é anotado com {@link jakarta.persistence.ManyToOne} para definir um relacionamento muitos-para-um com a entidade {@code User}.
     * A anotação {@link jakarta.persistence.JoinColumn} especifica que a chave estrangeira é armazenada na coluna chamada {@code reserve_responsible_id}.</p>
     */
    @ManyToOne
    @JoinColumn(name = "reserve_responsible_id")
    private Users reserveResponsible = null;

    /**
     * English:
     * Indicates whether the task is completed.
     * <p>This field is optional and is annotated with {@link jakarta.persistence.Column}. Defaults to {@code false}.</p>
     *
     * Português:
     * Indica se a tarefa foi concluída.
     * <p>Este campo é opcional e é anotado com {@link jakarta.persistence.Column}. O valor padrão é {@code false}.</p>
     */
    @Column
    private boolean completed = false;

    /**
     * English:
     * The date and time when the task was completed.
     * <p>This field is optional and is annotated with {@link jakarta.persistence.Column} and {@link jakarta.persistence.Temporal}, using {@link jakarta.persistence.TemporalType#TIMESTAMP} to store date and time values.</p>
     *
     * Português:
     * A data e hora de conclusão da tarefa.
     * <p>Este campo é opcional e é anotado com {@link jakarta.persistence.Column} e {@link jakarta.persistence.Temporal}, usando {@link jakarta.persistence.TemporalType#TIMESTAMP} para armazenar valores de data e hora.</p>
     */
    @Column()
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp completionDate;

    /**
     * English:
     * The deadline date and time for completing the task.
     * <p>This field is annotated with {@link jakarta.persistence.Column} and {@link jakarta.persistence.Temporal}, using {@link jakarta.persistence.TemporalType#TIMESTAMP} to store date and time values. This field is mandatory.</p>
     *
     * Português:
     * A data e hora limite para a conclusão da tarefa.
     * <p>Este campo é anotado com {@link jakarta.persistence.Column} e {@link jakarta.persistence.Temporal}, usando {@link jakarta.persistence.TemporalType#TIMESTAMP} para armazenar valores de data e hora. Este campo é obrigatório.</p>
     */
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp deadlineDate;

    /**
     * English:
     * The section to which this task belongs.
     * <p>This field is annotated with {@link jakarta.persistence.ManyToOne} to define a many-to-one relationship with the {@code Section} entity.
     * The {@link jakarta.persistence.JoinColumn} annotation specifies that the foreign key is stored in the column named {@code section_id}.</p>
     *
     * Português:
     * A seção à qual esta tarefa pertence.
     * <p>Este campo é anotado com {@link jakarta.persistence.ManyToOne} para definir um relacionamento muitos-para-um com a entidade {@code Section}.
     * A anotação {@link jakarta.persistence.JoinColumn} especifica que a chave estrangeira é armazenada na coluna chamada {@code section_id}.</p>
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sections_id", nullable = false)
    private Sections sections;
}
