package sample;

import java.sql.*;

public class DateBaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.jbdc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }
        public void signUpUser (User user) throws SQLException, ClassNotFoundException {
            String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_FIRSTNAME + ","
                    + Const.USER_LASTNAME + "," + Const.USER_USERNAME + "," + Const.USER_PASSWORD
                    + "," + Const.USER_LOCATION + "," + Const.USER_GENDER + ")" +
                    "VALUES (?,?,?,?,?,?)";
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getFirstName());
            prSt.setString(2, user.getLastName());
            prSt.setString(3, user.getUserName());
            prSt.setString(4, user.getPassword());
            prSt.setString(5, user.getLocation());
            prSt.setString(6, user.getGender());

            prSt.executeUpdate();
        }
}
