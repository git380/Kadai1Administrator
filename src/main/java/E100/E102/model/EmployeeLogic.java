package E100.E102.model;

import E100.E102.dao.EmployeeDAO;

import java.util.List;

public class EmployeeLogic {

    public List<Employee> allEmployees() {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        return employeeDAO.getAllEmployees();
    }

    public boolean updateEmployee(String empId, String empFname, String empLname) {
        if (empFname.isEmpty() || empLname.isEmpty()) {
            return false; // Return false if first name or last name is empty
        }

        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.updateEmployee(empId, empFname, empLname);
        return true;
    }
}
