package H100.H101.servlet;

import H100.H101.model.Hospital;
import H100.H101.model.HospitalRegistrationLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/HospitalRegistrationServlet")
public class HospitalRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/H100/H101/hospitalRegistration.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String tabyouinid = request.getParameter("tabyouinid");
        String tabyouinmei = request.getParameter("tabyouinmei");
        String tabyouinaddres = request.getParameter("tabyouinaddres");
        String tabyouintel = request.getParameter("tabyouintel");
        int tabyouinshihonkin = Integer.parseInt(request.getParameter("tabyouinshihonkin"));
        int kyukyu = Integer.parseInt(request.getParameter("kyukyu"));

        Hospital hospital = new Hospital(tabyouinid, tabyouinmei, tabyouinaddres, tabyouintel, tabyouinshihonkin, kyukyu);
        HospitalRegistrationLogic logic = new HospitalRegistrationLogic();
        logic.registerHospital(hospital);

        response.sendRedirect("/Kadai1Admin");
    }
}
