import javax.mail.MessagingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.Set;

public class Registration {

   /* private MyDataBase db = new MyDataBase();
    private MailSender mailSender = new MailSender("kzosimovmp2@gmail.com", "kirill423531");
    private Set<String> users;

    public String signUp(User user) {
        try {
            if (!(db.dbHave("Username", user.getUsername()) || db.dbHave("Email", user.getEmail()))) {
                String password = this.generatePassword();
                mailSender.send(user.getEmail(), user.getUsername(), password);
                PreparedStatement preparedStatement = db.connection.prepareStatement("INSERT INTO \"Users\" VALUES(?,?,?)");
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, this.hash(password));
                preparedStatement.setString(3, user.getEmail());
                db.change(preparedStatement, "set");
                return "Registration was successful, check your email for password";
            } else {
                return "This username or email is already exist!";
            }
        } catch (SQLException | MessagingException e) {
            e.printStackTrace();
            return "Something wrong";
        }
    }

    public String login(User user) {

        if (user.getUsername() == null || user.getPassword() == null) {
            return "Empty username or password";
        }

        String hashedPassword = this.hash(user.getPassword());

        try {
            //SELECT Пароль FROM имя_таблицы WHERE Имя = 'Кирилл';
            if ((db.dbHave("Username", user.getUsername())) && (db.dbHave("Password", hashedPassword)) && (user.getUsername() != null)) {
                if (users.contains(user.getUsername())) {
                    return "This user is already in BookCase!";
                } else {
                    users.add(user.getUsername());
                    return "You successfully logged in";
                }
            } else {
                return "Invalid username or password";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String hash(String s) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-224");
            return digest.digest(s.getBytes(StandardCharsets.UTF_8)).toString().trim();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String generatePassword() {
        String symbols = "?!#%&'()*+,-.0123456789:<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz[]{|}~;\"";
        String password = new String();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            password += symbols.charAt(random.nextInt(symbols.length()));
        }
        return password;
    }*/
}
