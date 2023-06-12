package L100.L101.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import A100.dao.DAOParam;
import A100.model.Account;
import L100.L101.hash.SaltUserPassword;
import L100.L101.model.Login;

public class AccountDAO extends DAOParam {
    //DBに接続/自動切断
    public Account findByLogin(Login login) {
        Account account = null;
        // データベースへ接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

            // SELECT文を準備
            //権限が0の場合のみOK
            String sql = "SELECT * FROM employee WHERE empid = ? AND emppasswd = ? AND emprole = 0";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, login.getEmpId());
            pStmt.setString(2, new SaltUserPassword().getDigest(login.getEmpId(),login.getEmppasswd()));

            // SELECTを実行し、結果表を取得
            ResultSet rs = pStmt.executeQuery();

            // 一致したユーザーが存在した場合
            // そのユーザーを表すAccountインスタンスを生成
            if (rs.next()) {
                // 結果表からデータを取得
                String empid = rs.getString("empid");
                String empfname = rs.getString("empfname");
                String emplname = rs.getString("emplname");
                String emppasswd= rs.getString("emppasswd");
                int emprole = rs.getInt("emprole");
                account = new Account(empid,empfname,emplname,emppasswd, emprole);

                // 取得したデータを出力
                System.out.println("id:" + empid + "empfname:" + empfname + "emplname:" + emplname + "emppasswd:" + emppasswd + "role:" + emprole);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        // 見つかったユーザーまたはnullを返す
        return account;
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
