package org.brownsolutions.crimsonplan.repository;

import org.brownsolutions.crimsonplan.domain.entity.Charts;
import org.brownsolutions.crimsonplan.domain.entity.Sections;
import org.brownsolutions.crimsonplan.domain.entity.Tasks;
import org.brownsolutions.crimsonplan.domain.entity.Users;
import org.brownsolutions.crimsonplan.domain.type.UserType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Timestamp;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class TasksRepositoryTest {

    @Autowired
    private SectionsRepository sectionsRepository;

    @Autowired
    private ChartsRepository chartsRepository;

    @Autowired
    private TasksRepository tasksRepository;

    @Autowired
    private UsersRepository usersRepository;

    private Tasks previousTasks;
    private Tasks nextTasks;
    private Sections sections;
    private Charts charts;
    private Tasks tasks;
    private Users reserveUsers;
    private Users users;

    @BeforeEach
    void setup() {
        charts = createCharts();
        sections = createSections();
        reserveUsers = createReserveUsers();
        users = createUsers();
        previousTasks = createPreviousTasks();
        nextTasks = createNextTasks();
        tasks = createTasks();
    }

    @Test
    @DisplayName("Test Tasks Repository")
    void test() {
        chartsRepository.save(charts);

        sectionsRepository.save(sections);

        usersRepository.save(reserveUsers);
        usersRepository.save(users);

        tasksRepository.save(previousTasks);
        tasksRepository.save(nextTasks);
        tasksRepository.save(tasks);

        tasksRepository.updatePreviousTasks(tasks.getId(), previousTasks.getId());
        tasksRepository.updateNextTasks(tasks.getId(), nextTasks.getId());
        tasksRepository.updateDescription(tasks.getId(), "New Description");
        tasksRepository.updateReserveResponsible(tasks.getId(), reserveUsers.getId());
        tasksRepository.setTaskCompleted(tasks.getId(), true);

        Optional<Tasks> task = tasksRepository.findById(tasks.getId());

        assertThat(task.isPresent()).isTrue();

        assertThat(task.get().getPreviousTasks()).isNotNull();
        assertThat(task.get().getNextTasks()).isNotNull();
        assertThat(task.get().getDescription()).isEqualTo("New Description");
        assertThat(task.get().getReserveResponsible()).isNotNull();
        assertThat(task.get().isCompleted()).isTrue();
    }

    private Tasks createTasks() {
        return Tasks.builder()
                .title("Title")
                .description("Description")
                .responsible(users)
                .completionDate(Timestamp.valueOf("2024-11-30 15:25:00"))
                .deadlineDate(Timestamp.valueOf("2024-11-30 15:25:00"))
                .sections(sections)
                .build();
    }

    private Tasks createPreviousTasks() {
        return Tasks.builder()
                .title("Previous Title")
                .description("Previous Description")
                .responsible(users)
                .completionDate(Timestamp.valueOf("2024-11-30 15:25:00"))
                .deadlineDate(Timestamp.valueOf("2024-11-30 15:25:00"))
                .sections(sections)
                .build();
    }

    private Tasks createNextTasks() {
        return Tasks.builder()
                .title("Next Title")
                .description("Next Description")
                .responsible(users)
                .completionDate(Timestamp.valueOf("2024-11-30 15:25:00"))
                .deadlineDate(Timestamp.valueOf("2024-11-30 15:25:00"))
                .sections(sections)
                .build();
    }

    private Sections createSections() {
        return Sections.builder()
                .title("Title")
                .archived(false)
                .charts(charts)
                .build();
    }

    private Charts createCharts() {
        return Charts.builder()
                .title("Title")
                .build();
    }

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

    private Users createReserveUsers() {
        return Users.builder()
                .username("Daniel Silva")
                .email("daniel-dasilva70@aprimor.com")
                .password("senha@2024")
                .type(UserType.USER)
                .biography("Random User...")
                .created(Timestamp.valueOf("2024-11-30 15:25:00"))
                .build();
    }
}
