package E100.E102.servlet;

import E100.E102.model.EmployeeLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EmployeeUpdateServlet")
public class EmployeeUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String empId = request.getParameter("empId");

        // セッションスコープからユーザーIDを取得
        if (empId == null) {
            // ログイペレイト
            response.sendRedirect("WelcomeServlet");
            return;
        }
        // 従業員更新確認
        request.setAttribute("empId", empId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/E100/E102/employeeUpdateConfirm.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // リクエストパラメータの取得
        request.setCharacterEncoding("UTF-8");
        // 従業員情報受け取り
        String empId = request.getParameter("empId");
        String empFname = request.getParameter("firstName");
        String empLname = request.getParameter("lastName");

        // 従業員更新
        EmployeeLogic updateLogic = new EmployeeLogic();
        boolean success = updateLogic.updateEmployee(empId, empFname, empLname);

        if (success) {
            response.sendRedirect("/Kadai1Administrator/EmployeeUpdateServlet");
        } else {
            // エラーjspへフォワード
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/E100/E102/error.jsp");
            dispatcher.forward(request, response);
        }
    }
}
