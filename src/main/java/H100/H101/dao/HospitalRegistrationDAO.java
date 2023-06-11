package H100.H101.dao;

import A100.dao.DAOParam;
import H100.H101.model.Hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HospitalRegistrationDAO extends DAOParam {
    public void registerHospital(Hospital hospital) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            String sql = "INSERT INTO tabyouin (tabyouinid, tabyouinmei, tabyouinaddres, tabyouintel, tabyouinshihonkin, kyukyu) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, hospital.getTabyouinid());
            preparedStatement.setString(2, hospital.getTabyouinmei());
            preparedStatement.setString(3, hospital.getTabyouinaddres());
            preparedStatement.setString(4, hospital.getTabyouintel());
            preparedStatement.setInt(5, hospital.getTabyouinshihonkin());
            preparedStatement.setInt(6, hospital.getKyukyu());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
