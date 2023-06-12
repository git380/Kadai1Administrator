package A100.model;

public class Account {
    private final String empId;
    private final String empFName;
    private final String empLName;
    private final String empPasswd;
    private final int empRole;

    public Account(String empId, String empFName, String empLName, String empPasswd, int empRole) {
        this.empId = empId;
        this.empFName = empFName;
        this.empLName = empLName;
        this.empPasswd = empPasswd;
        this.empRole = empRole;
    }

    public String getEmpId() {
        return empId;
    }

    public String getEmpFName() {
        return empFName;
    }

    public String getEmpLName() {
        return empLName;
    }

    public String getEmpPasswd() {
        return empPasswd;
    }

    public int getEmpRole() {
        return empRole;
    }
}