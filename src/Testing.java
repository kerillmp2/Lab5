import java.util.Scanner;

public class Testing {
    public static void main(String args[]){
        MailSender mailSender = new MailSender("kzosimovmp2@gmail.com", "kirill423531");
        try {
            Scanner scanner = new Scanner(System.in);
            String email = scanner.nextLine();
            mailSender.send(email, "акцио", "жёёёпка");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}