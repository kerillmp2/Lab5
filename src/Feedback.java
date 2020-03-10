import java.sql.ResultSet;
import java.sql.Statement;

public class Feedback {

    private ResultSet resultSet;
    private Statement statement;

    public Feedback(ResultSet resultSet, Statement statement) {
        this.resultSet = resultSet;
        this.statement = statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }
}
