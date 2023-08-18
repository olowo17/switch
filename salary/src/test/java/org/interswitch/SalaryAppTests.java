package org.interswitch;

import org.instancio.Instancio;
import org.interswitch.model.Salary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.interswitch.client.EmployeeClient;
import org.interswitch.model.Employee;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    properties = {
        "spring.cloud.discovery.enabled=false",
        "spring.cloud.config.discovery.enabled=false"
    }
)
public class SalaryAppTests {

    @Autowired
    TestRestTemplate restTemplate;
    @MockBean
    EmployeeClient employeeClient;

    @Test
    void findAll() {
        Salary[] salaries = restTemplate.getForObject("/", Salary[].class);
        Assertions.assertTrue(salaries.length > 0);
    }

    @Test
    void findById() {
        Salary salary = restTemplate.getForObject("/{id}", Salary.class, 1L);
        Assertions.assertNotNull(salary);
        Assertions.assertNotNull(salary.getId());
        Assertions.assertNotNull(salary.getAmount());
        Assertions.assertEquals(1L, salary.getId());
    }

    @Test
    void findByOrganization() {
        Salary[] salaries = restTemplate.getForObject("/organization/{organizationId}", Salary[].class, 1L);
        Assertions.assertTrue(salaries.length > 0);
    }

    @Test
    void findByOrganizationWithEmployees() {
        Mockito.when(employeeClient.findByDepartment(Mockito.anyLong()))
                .thenReturn(Instancio.ofList(Employee.class).create());
        Salary[] salaries = restTemplate.getForObject("/organization/{organizationId}/with-employees", Salary[].class, 1L);
        Assertions.assertTrue(salaries.length > 0);
    }

    @Test
    void add() {
        Salary salary = Instancio.create(Salary.class);
        salary = restTemplate.postForObject("/", salary, Salary.class);
        Assertions.assertNotNull(salary);
        Assertions.assertNotNull(salary.getId());
        Assertions.assertNotNull(salary.getAmount());
    }
}
