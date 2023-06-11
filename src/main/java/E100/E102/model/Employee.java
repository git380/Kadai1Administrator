package E100.E102.model;

public class Employee {
    private String empId;
    private String empFname;
    private String empLname;
    // 他の従業員情報のフィールド

    public Employee(String empId, String empFname, String empLname) {
        this.empId = empId;
        this.empFname = empFname;
        this.empLname = empLname;
    }

    // GetterとSetterメソッド

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpFname() {
        return empFname;
    }

    public void setEmpFname(String empFname) {
        this.empFname = empFname;
    }

    public String getEmpLname() {
        return empLname;
    }

    public void setEmpLname(String empLname) {
        this.empLname = empLname;
    }
}
