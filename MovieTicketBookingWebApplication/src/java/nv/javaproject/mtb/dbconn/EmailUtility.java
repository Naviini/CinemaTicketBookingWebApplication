/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nv.javaproject.mtb.dbconn;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtility {
    private static final String SMTP_HOST = "smtp.your-email-provider.com"; // Replace with your SMTP server
    private static final String SMTP_PORT = "587"; // Typically 587 for TLS, 465 for SSL
    private static final String USERNAME = "your-email@example.com"; // Your email address
    private static final String PASSWORD = "your-email-password"; // Your email password

    public static void sendEmail(String to, String subject, String messageBody) {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", SMTP_HOST);
        properties.put("mail.smtp.port", SMTP_PORT);

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(messageBody);

            Transport.send(message);
            System.out.println("Email sent successfully to " + to);
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Failed to send email to " + to);
        }
    }
}

