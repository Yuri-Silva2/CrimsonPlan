package org.brownsolutions.crimsonplan.repository;

import org.brownsolutions.crimsonplan.domain.entity.Charts;
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
public class ChartsRepositoryTest {

    @Autowired
    private ChartsRepository chartsRepository;

    private Charts charts;

    @BeforeEach
    void setup() {
        charts = createCharts();
    }

    @Test
    @DisplayName("Put Charts in Repository")
    void putChartsInRepository() {
        chartsRepository.save(charts);

        assertThat(chartsRepository.findAll()).isNotEmpty();
    }


    private Charts createCharts() {
        return Charts.builder()
                .title("Title")
                .build();
    }
}
