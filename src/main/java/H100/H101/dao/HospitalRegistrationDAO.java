package H100.H101.dao;

import A100.dao.DAOParam;
import H100.H101.model.Hospital;

import java.sql.*;

public class HospitalRegistrationDAO extends DAOParam {
    public boolean checkHospital(String tabyouinid) {
        String tabyouinSQLId = null;

        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            // SQL文の準備
            String sql = "SELECT * FROM tabyouin WHERE tabyouinid = ?";
            PreparedStatement pStmt = connection.prepareStatement(sql);
            pStmt.setString(1, tabyouinid);

            // SELECTを実行し、結果表を取得
            ResultSet resultSet = pStmt.executeQuery();
            if (resultSet.next()) {
                // 取得した結果を追加
                tabyouinSQLId = resultSet.getString("tabyouinid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 検索結果のリストを返す
        return tabyouinSQLId == null;
    }
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
