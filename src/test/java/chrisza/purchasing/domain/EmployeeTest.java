package chrisza.purchasing.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeTest {

    @Test
    void markShouldBeSeniorManagement() {
        Employee mark = new Employee("mark@microapplesoft.com");
        assertEquals(EmployeeLevel.SeniorManagement, mark.level());
    }

    @Test
    void steveShouldBeMidLevel() {
        Employee steve = new Employee("steve@microapplesoft.com");
        assertEquals(EmployeeLevel.MidLevelManagement, steve.level());
    }

    @Test
    void shouldReturnEmployeeOtherwise() {
        Employee john = new Employee("john@microapplesoft.com");
        assertEquals(EmployeeLevel.Employee, john.level());
    }
}