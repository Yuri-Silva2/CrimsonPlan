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

    private Sections sections;
    private Charts charts;
    private Tasks tasks;
    private Users users;

    @BeforeEach
    void setup() {
        charts = createCharts();
        sections = createSections();
        users = createUsers();
        tasks = createTasks();
    }

    @Test
    @DisplayName("Test Tasks Repository")
    void test() {
        chartsRepository.save(charts);

        sectionsRepository.save(sections);

        usersRepository.save(users);

        tasksRepository.save(tasks);

        assertThat(tasksRepository.findAll()).isNotEmpty();
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
}
