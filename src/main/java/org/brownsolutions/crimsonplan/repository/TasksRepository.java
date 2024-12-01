package org.brownsolutions.crimsonplan.repository;

import org.brownsolutions.crimsonplan.domain.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;

public interface TasksRepository extends JpaRepository<Tasks, Long> {

    /**
     * English:
     * Updates the ID of the previous task for the specified task.
     *
     * @param id the ID of the task
     * @param previousTaskId the ID of the previous task to associate
     *
     * Português:
     * Atualiza o ID da tarefa anterior para a tarefa especificada.
     *
     * @param id o ID da tarefa
     * @param previousTaskId o ID da tarefa anterior a ser associada
     */
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE Tasks SET previous_tasks_id = :previousTaskId WHERE id = :id", nativeQuery = true)
    void updatePreviousTasks(Long id, Long previousTaskId);

    /**
     * English:
     * Updates the ID of the next task for the specified task.
     *
     * @param id the ID of the task
     * @param nextTaskId the ID of the next task to associate
     *
     * Português:
     * Atualiza o ID da próxima tarefa para a tarefa especificada.
     *
     * @param id o ID da tarefa
     * @param nextTaskId o ID da próxima tarefa a ser associada
     */
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE Tasks SET next_tasks_id = :nextTaskId WHERE id = :id", nativeQuery = true)
    void updateNextTasks(Long id, Long nextTaskId);

    /**
     * English:
     * Updates the description of the specified task.
     *
     * @param id the ID of the task
     * @param description the new description to set
     *
     * Português:
     * Atualiza a descrição da tarefa especificada.
     *
     * @param id o ID da tarefa
     * @param description a nova descrição a ser definida
     */
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Tasks t SET t.description = :description WHERE t.id = :id")
    void updateDescription(Long id, String description);

    /**
     * English:
     * Updates the responsible user for the specified task.
     *
     * @param id the ID of the task
     * @param userId the ID of the new responsible user
     *
     * Português:
     * Atualiza o usuário responsável pela tarefa especificada.
     *
     * @param id o ID da tarefa
     * @param userId o ID do novo usuário responsável
     */
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE Tasks SET responsible_id = :userId WHERE id = :id", nativeQuery = true)
    void updateResponsible(Long id, Long userId);

    /**
     * English:
     * Updates the reserve responsible user for the specified task.
     *
     * @param id the ID of the task
     * @param userId the ID of the reserve responsible user
     *
     * Português:
     * Atualiza o usuário responsável de reserva pela tarefa especificada.
     *
     * @param id o ID da tarefa
     * @param userId o ID do usuário responsável de reserva
     */
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE Tasks SET reserve_responsible_id = :userId WHERE id = :id", nativeQuery = true)
    void updateReserveResponsible(Long id, Long userId);

    /**
     * English:
     * Sets the completion status of the specified task.
     *
     * @param id the ID of the task
     * @param completed {@code true} if the task is completed, {@code false} otherwise
     *
     * Português:
     * Define o status de conclusão da tarefa especificada.
     *
     * @param id o ID da tarefa
     * @param completed {@code true} se a tarefa está concluída, {@code false} caso contrário
     */
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Tasks t SET t.completed = :completed WHERE t.id = :id")
    void setTaskCompleted(Long id, boolean completed);

    /**
     * English:
     * Updates the completion date of the specified task.
     *
     * @param id the ID of the task
     * @param completionDate the new completion date
     *
     * Português:
     * Atualiza a data de conclusão da tarefa especificada.
     *
     * @param id o ID da tarefa
     * @param completionDate a nova data de conclusão
     */
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Tasks t SET t.completionDate = :completionDate WHERE t.id = :id")
    void updateCompletionDate(Long id, Timestamp completionDate);

    /**
     * English:
     * Updates the deadline date of the specified task.
     *
     * @param id the ID of the task
     * @param deadlineDate the new deadline date
     *
     * Português:
     * Atualiza a data limite da tarefa especificada.
     *
     * @param id o ID da tarefa
     * @param deadlineDate a nova data limite
     */
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Tasks t SET t.deadlineDate = :deadlineDate WHERE t.id = :id")
    void updateDeadlineDate(Long id, Timestamp deadlineDate);
}
