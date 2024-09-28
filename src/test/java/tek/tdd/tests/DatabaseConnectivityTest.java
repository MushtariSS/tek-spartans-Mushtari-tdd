package tek.tdd.tests;

import com.aventstack.extentreports.service.ExtentTestManager;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import tek.tdd.api.models.AccountResponse;
import tek.tdd.api.models.EndPoints;
import tek.tdd.utility.DataBaseUtility;

import javax.xml.transform.Result;
import java.sql.*;

public class DatabaseConnectivityTest {
    String url = "jdbc:mysql://tek-database-server.mysql.database.azure.com:3306/tek_insurance_app";
    String username = "tek_student_user";
    String password = "FEB_2024";

    @Test
    public void databaseConnectivityTest() {
        //Step 1 Create a connection
        //Create statement
        //execute query
        //get results

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            //Create statement
            Statement statement = connection.createStatement();
            //execute
            ResultSet result = statement.executeQuery("SELECT* FROM tek_insurance_app.primary_person where id = 10107;");
            //get resuilt set
            while (result.next()) {
                System.out.println(result.getString("email"));
                System.out.println(result.getInt("id"));
                System.out.println(result.getDate("date_of_birth"));
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //Run the query that return the last id from DB
    @Test
    public void getLastPrimaryPersonID() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "SELECT max(id) as idSelected from primary_person";
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            System.out.println(resultSet.getInt("idSelected"));

        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } finally {
            if (connection != null)
                connection.close();
        }
    }

    //Activity Retrieve Latest primary person from database call API/get-primary-account
    //Validate API response with database response



}
