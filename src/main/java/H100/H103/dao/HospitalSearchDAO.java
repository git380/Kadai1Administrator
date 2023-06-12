package H100.H103.dao;

import A100.dao.DAOParam;
import H100.H101.model.Hospital;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospitalSearchDAO extends DAOParam {
    public List<Hospital> searchHospitals(String address) {
        List<Hospital> hospitals = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            String sql = "SELECT * FROM tabyouin WHERE tabyouinaddres LIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + address + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String tabyouinid = resultSet.getString("tabyouinid");
                String tabyouinmei = resultSet.getString("tabyouinmei");
                String tabyouinaddres = resultSet.getString("tabyouinaddres");
                String tabyouintel = resultSet.getString("tabyouintel");
                int tabyouinshihonkin = resultSet.getInt("tabyouinshihonkin");
                int kyukyu = resultSet.getInt("kyukyu");

                Hospital hospital = new Hospital(tabyouinid, tabyouinmei, tabyouinaddres, tabyouintel, tabyouinshihonkin, kyukyu);
                hospitals.add(hospital);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hospitals;
    }
}
