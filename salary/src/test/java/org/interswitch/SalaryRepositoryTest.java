//package org.interswitch;
//
//import org.interswitch.model.Salary;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.util.Assert;
//import org.interswitch.repository.SalaryRepository;
//
//import java.util.List;
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class SalaryRepositoryTest {
//
//    private static final SalaryRepository repository = new SalaryRepository();
//
//    @Test
//    @Order(1)
//    void testAddDepartment() {
//        Salary salary = new Salary(1L, "Test");
//        salary = repository.add(salary);
//        Assert.notNull(salary, "Department is null.");
//        Assert.isTrue(salary.getId() == 1L, "Department bad id.");
//    }
//
//    @Test
//    @Order(2)
//    void testFindAll() {
//        List<Salary> salaries = repository.findAll();
//        Assert.isTrue(salaries.size() == 1, "Departments size is wrong.");
//        Assert.isTrue(salaries.get(0).getId() == 1L, "Department bad id.");
//    }
//
//    @Test
//    @Order(3)
//    void testFindByOrganization() {
//        List<Salary> salaries = repository.findByOrganization(1L);
//        Assert.isTrue(salaries.size() == 1, "Departments size is wrong.");
//        Assert.isTrue(salaries.get(0).getId() == 1L, "Department bad id.");
//    }
//
//    @Test
//    @Order(4)
//    void testFindById() {
//        Salary salary = repository.findById(1L);
//        Assert.notNull(salary, "Department not found.");
//        Assert.isTrue(salary.getId() == 1L, "Department bad id.");
//    }
//
//}
