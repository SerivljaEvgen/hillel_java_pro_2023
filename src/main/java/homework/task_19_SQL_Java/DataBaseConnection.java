package homework.task_19_SQL_Java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private final String url; // = "jdbc:mysql://localhost:3306/hillel_2023";
    private final String username; // = "root";
    private final String password; // =  "*********";

    public DataBaseConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // Method to get a connection to the database
    public Connection getConnection() { // Connection (is the class used to connect to the database).
        try {
            // the getConnection method of the DriverManager class is responsible for managing database connections
            return DriverManager.getConnection(this.url, this.username, this.password);
        } catch (SQLException e) {
            e.printStackTrace(); //outputs error information to the console
            throw new RuntimeException("Database connection error");
        }
    }

    //method to close the connection
    public void close(Connection connection){
        try{
            //If connection is null, it means that the database connection was not successfully established,
            // in which case there is no need to close the null connection.
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error closing connection");
        }
    }

}
