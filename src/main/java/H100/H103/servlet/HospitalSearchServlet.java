package H100.H103.servlet;

import H100.H101.model.Hospital;
import H100.H103.model.HospitalSearchLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/HospitalSearchServlet")
public class HospitalSearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // セッションスコープからユーザーIDを取得
        if (request.getSession().getAttribute("empId") == null) {
            // ログイペレイト
            response.sendRedirect("LoginServlet");
            return;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/H100/H103/hospitalSearch.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String address = request.getParameter("address");

        HospitalSearchLogic logic = new HospitalSearchLogic();
        List<Hospital> hospitals = logic.searchHospitals(address);

        request.setAttribute("hospitals", hospitals);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/H100/H103/hospitalSearchResult.jsp");
        dispatcher.forward(request, response);
    }
}
