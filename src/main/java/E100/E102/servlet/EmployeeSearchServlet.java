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

        // Perform employee search
        EmployeeLogic searchLogic = new EmployeeLogic();
        List<Employee> employeeList = searchLogic.allEmployees();

        if (employeeList.isEmpty()) {
            // Forward to error page if no employees found
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/E100/E102/error.jsp");
            dispatcher.forward(request, response);
        } else {
            // Forward to employee list page
            System.out.println(employeeList);
            request.setAttribute("employeeList", employeeList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/E100/E102/employeeList.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the selected employee ID
        String empId = request.getParameter("empId");

        // Forward to the employee update page
        request.setAttribute("empId", empId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/E100/E102/employeeUpdate.jsp");
        dispatcher.forward(request, response);
    }
}
