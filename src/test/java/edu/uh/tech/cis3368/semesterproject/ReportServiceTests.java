package edu.uh.tech.cis3368.semesterproject;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.*;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportServiceTests {

    @Autowired
    JobService jobCreatorService;

    @Autowired
    JobRepository jobRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void reportsShouldNotAcceptStartDateAfterEndDate(){
        ReportService reportService = new ReportService();
        reportService.setStartDate(LocalDate.of(2020,1,1));
        reportService.setEndDate(LocalDate.now());
        assertFalse(reportService.validate());
    }

    public void reportClassShouldProvideProfit(){
        ReportService reportService = new ReportService();
        reportService.setStartDate(LocalDate.of(2020,1,1));
        reportService.setEndDate(LocalDate.now());
        ProfitReport profitReport = reportService.getProfitReport();
    }

}
