package L100.L101.model;

import L100.L101.dao.AccountDAO;
import A100.model.Account;

public class LoginLogic {
    public boolean execute(Login login) {
        AccountDAO dao = new AccountDAO();
        Account account = dao.findByLogin(login);
        return account != null;
    }
    public void newAccount(Account account) {
        AccountDAO dao = new AccountDAO();
        dao.insertAccount(account);
    }
}