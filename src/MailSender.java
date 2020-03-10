import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;


public class MailSender {
    private Properties properties;
    private String host = "127.0.0.7";
    private String sender;
    private String senderPass;

   public MailSender(String sender, String senderPass){
       this.sender = sender;
       this.senderPass = senderPass;
       properties = new Properties();
       properties.put("mail.smtp.auth", "true");
       properties.put("mail.smtp.starttls.enable", "true");
       properties.put("mail.smtp.host", "smtp.gmail.com");
       properties.put("mail.smtp.port", "587");
   }

    public void send(String receiver, String login, String password) throws MessagingException {

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(sender, senderPass);
            }
        });

        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
            message.setSubject("Mail from BookCase");
            message.setText("Поздравляем! Вы успешно зарегестрировались в RecipeBook!\n Вот ваш логин: " + login + "\n Вот ваш пароль: " + password);
            Transport.send(message);
            System.out.println("Email sent successfully to " + login + " (" + receiver + ")");
        } catch (MessagingException ex){
            ex.printStackTrace();
        }
    }
}
