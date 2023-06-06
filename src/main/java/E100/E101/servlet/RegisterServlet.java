package E100.E101.servlet;

import A100.model.Account;
import L100.L101.model.LoginLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/E100/E101/register.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // リクエストパラメータの取得
        request.setCharacterEncoding("UTF-8");
        String empId = request.getParameter("empId");
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String empPasswd = request.getParameter("empPasswd");
        int empRole = Integer.parseInt(request.getParameter("empRole"));

        // 登録処理の実行
        Account account = new Account(empId, fName, lName, empPasswd, empRole);
        LoginLogic bo = new LoginLogic();
        bo.newAccount(account);

        System.out.println(empId + " " + fName + " " + lName + " " + empPasswd + " " + empRole);

        response.sendRedirect("/Kadai1Administrator/LoginServlet");
    }
}

