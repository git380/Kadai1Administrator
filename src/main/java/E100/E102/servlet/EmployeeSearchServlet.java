package E100.E102.servlet;

import E100.E102.model.Employee;
import E100.E102.model.EmployeeLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/EmployeeSearchServlet")
public class EmployeeSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // セッションスコープからユーザーIDを取得
        if (request.getSession().getAttribute("empId") == null) {
            // ログイペレイト
            response.sendRedirect("LoginServlet");
            return;
        }

        EmployeeLogic searchLogic = new EmployeeLogic();
        List<Employee> employeeList = searchLogic.allEmployees();

        if (employeeList.isEmpty()) {// 従業員がいない場合
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/E100/E102/employeeError.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("employeeList", employeeList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/E100/E102/employeeList.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String empId = request.getParameter("empId");

        request.setAttribute("empId", empId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/E100/E102/employeeUpdate.jsp");
        dispatcher.forward(request, response);
    }
}
