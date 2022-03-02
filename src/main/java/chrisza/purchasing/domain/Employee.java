package chrisza.purchasing.domain;

public class Employee {

    private String emailAddress;

    public Employee(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public EmployeeLevel level() {
        switch (this.emailAddress) {
            case "steve@microapplesoft.com":
                return EmployeeLevel.MidLevelManagement;
            case "mark@microapplesoft.com":
                return EmployeeLevel.SeniorManagement;
            default:
                return EmployeeLevel.Employee;
        }
    }
}
