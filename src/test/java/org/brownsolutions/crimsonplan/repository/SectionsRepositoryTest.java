package org.brownsolutions.crimsonplan.repository;

import org.brownsolutions.crimsonplan.domain.entity.Charts;
import org.brownsolutions.crimsonplan.domain.entity.Sections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class SectionsRepositoryTest {

    @Autowired
    private SectionsRepository sectionsRepository;

    @Autowired
    private ChartsRepository chartsRepository;

    private Sections sections;
    private Charts charts;

    @BeforeEach
    void setup() {
        charts = createCharts();
        sections = createSections();
    }

    @Test
    @DisplayName("Put Sections in Repository")
    void putSectionsInRepository() {
        chartsRepository.save(charts);

        sectionsRepository.save(sections);

        assertThat(sectionsRepository.findAll()).isNotEmpty();
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
}
