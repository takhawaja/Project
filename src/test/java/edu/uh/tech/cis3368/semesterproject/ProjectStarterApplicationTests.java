package edu.uh.tech.cis3368.semesterproject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectStarterApplicationTests {

    @Autowired
    JobService jobCreatorService;

    @Autowired
    JobRepository jobRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Before
    public void deleteAll(){
        jobRepository.deleteAll();
        customerRepository.deleteAll();
        productRepository.deleteAll();
    }

    @Test
    public void createJobWithCustomer(){
        String jobName = "Sample job";
        String jobDescription = "A job description";
        String customerName = "John Doe";
        String customerEmail = "aaa@abc.com";
        String customerPhone = "999-999-9999";
        Job job = jobCreatorService.createJobWithCustomer(jobName,
                jobDescription,
                customerName,
                customerEmail,
                customerPhone);

        assert job.getProduct() != null;

    }

    @Test
    public void deletingJobDeletesProduct(){
        String jobName = "Sample job";
        String jobDescription = "A job description";
        String customerName = "John Doe";
        String customerEmail = "aaa@abc.com";
        String customerPhone = "999-999-9999";
        Job job = jobCreatorService.createJobWithCustomer(jobName,
                jobDescription,
                customerName,
                customerEmail,
                customerPhone);
        jobRepository.save(job);
        jobRepository.delete(job);
        Optional<Product> testProduct = productRepository.findById(job.getProduct().getId());
        assert testProduct.isEmpty();
        Optional<Customer> testCustomer = customerRepository.findById(job.getCustomer().getId());
        assert testCustomer.isPresent();
    }
}
