package org.brownsolutions.crimsonplan.repository;

import jakarta.transaction.Transactional;
import org.brownsolutions.crimsonplan.domain.entity.Tasks;
import org.brownsolutions.crimsonplan.domain.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;

public interface TasksRepository extends JpaRepository<Tasks, Long> {

//    @Modifying
//    @Query(value = "UPDATE tasks SET previous_tasks_id = :tasks_id WHERE id = :id",
//            nativeQuery = true)
//    void updatePreviousTasks(@Param("tasks_id") Long tasksId, @Param("id") Long id);


//    void assignNextTasks(Long id, Tasks tasks);

//    @Modifying
//    @Transactional
//    @Query("UPDATE Tasks t SET t.description = :description WHERE t.id = :id")
//    void updateDescription(@Param("id") Long id, @Param("description") String description);
//


//    void assignResponsible(Long id, Users responsible);
//    void assignReserveResponsible(Long id, Users reserveResponsible);
//    void setTaskCompleted(Long id, boolean completed);
//    void updateCompletionDate(Long id, Timestamp completionDate);
}
