package E100.E101.dao;

import A100.dao.DAOParam;
import A100.model.Account;
import L100.L101.hash.SaltUserPassword;

import java.sql.*;

public class EmployeeRegisterDAO extends DAOParam {
    // 従業員を検索するメソッド
    public boolean nullEmployee(String empid) {
        String empSQLId = null;

        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            // SQL文の準備
            String sql = "SELECT * FROM employee WHERE empid = ?";
            PreparedStatement pStmt = connection.prepareStatement(sql);
            pStmt.setString(1, empid);

            // SELECTを実行し、結果表を取得
            ResultSet resultSet = pStmt.executeQuery();
            if (resultSet.next()) {
                // 取得した結果を追加
                empSQLId = resultSet.getString("empid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 検索結果のリストを返す
        return empSQLId == null;
    }
    public void insertAccount(Account account) {
        // データベースへ接続
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            // SQL文の準備
            String sql = "INSERT INTO employee (empid, empfname, emplname, emppasswd, emprole) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // パラメータの設定
            preparedStatement.setString(1, account.getEmpId());
            preparedStatement.setString(2, account.getEmpFName());
            preparedStatement.setString(3, account.getEmpLName());
            preparedStatement.setString(4, new SaltUserPassword().getDigest(account.getEmpId(),account.getEmpPasswd()));
            preparedStatement.setInt(5, account.getEmpRole());

            // SQL実行
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
