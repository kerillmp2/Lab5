import org.postgresql.core.SqlCommand;

import java.sql.*;
import java.time.ZonedDateTime;

public class MyDataBase {

    private Connection connection;
    private PreparedStatement loadRecipeBook;
    private PreparedStatement addRecipeBook;
    private PreparedStatement updateRecipeBook;
    private PreparedStatement executeLogin;
    private PreparedStatement checkRegToken;
    private PreparedStatement getEmail;
    private PreparedStatement updateRegToken;
    private PreparedStatement removeRecipeBook;
    private PreparedStatement loadRB;
    private PreparedStatement addUser;
    private PreparedStatement getUsersSalt;
    private PreparedStatement checkUnique;

    {
        try {

            Class.forName("org.postgresql.Driver");

            String db_URL = "jdbc:postgresql://127.0.0.1:5432/postgres";
            String user = "postgres";
            String password = "423531";

            connection = DriverManager.getConnection(db_URL, user, password);
            System.out.println("Connected to Data Base\n");

            loadRecipeBook = connection.prepareStatement("SELECT * FROM BookCase;");

            addRecipeBook = connection.prepareStatement("INSERT INTO BookCase VALUES (?, ?, ?, ?, ?, ?, ?)");

            updateRecipeBook = connection.prepareStatement("UPDATE BookCase SET x = ?, y = ? WHERE OwnerName=? AND Name=?;");

            executeLogin = connection.prepareStatement("SELECT * FROM Users WHERE Username=? AND  Password=?;");

            checkRegToken = connection.prepareStatement("SELECT * FROM user_tokens WHERE username=? AND reg_token=?;");

            getEmail = connection.prepareStatement("SELECT * FROM Users WHERE Username=?;");

            updateRegToken = connection.prepareStatement("UPDATE user_tokens SET reg_token=?, reg_token_time=? WHERE username=?;");

            removeRecipeBook = connection.prepareStatement("DELETE FROM BookCase WHERE name=? AND username=?;");

            loadRB = connection.prepareStatement("SELECT * FROM BookCase WHERE username=?;");

            checkUnique = connection.prepareStatement("SELECT * FROM Users WHERE Username=? AND Email=?;");

            addUser = connection.prepareStatement("INSERT INTO Users VALUES (?, ?, ?, ?);");

            getUsersSalt = connection.prepareStatement("SELECT salt FROM users WHERE username=?;");

        } catch (Exception e) {
            System.out.println("Can't connect to Data Base.");
        }
    }

    int loadRecipeBookFromDB(){
        try {

            int i = 0;
            ResultSet result = loadRecipeBook.executeQuery();

            while (result.next()) {

                String name = result.getString("Name");
                String ownerName = result.getString("OwnerName");
                int ownerAge = result.getInt("OwnerAge");
                String recipes = result.getString("Recipes");

                double x = result.getDouble("xCoordinate");
                double y = result.getDouble("yCoordinate");

                String date = result.getString("date");



                i++;

            }

            return i;
        } catch (Exception e) {
            System.err.printf("Ошибка при загрузке персонажей: %s\n", e.getMessage());
            return -1;
        }
    }
}
