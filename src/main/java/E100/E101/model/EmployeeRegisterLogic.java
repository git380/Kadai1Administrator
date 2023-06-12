package E100.E101.model;

import A100.model.Account;
import E100.E101.dao.EmployeeRegisterDAO;

public class EmployeeRegisterLogic {
    public boolean nullEmployee(String empid){
        EmployeeRegisterDAO dao = new EmployeeRegisterDAO();
        return dao.nullEmployee(empid);
    }
    public void newAccount(Account account) {
        EmployeeRegisterDAO dao = new EmployeeRegisterDAO();
        dao.insertAccount(account);
    }
}
