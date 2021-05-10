package nl.getandgo.application.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Service
@RequiredArgsConstructor
public class EmailService implements EmailSender{
    private final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);
    private final JavaMailSender mailSender;
    @Override
    @Async
    public void send(String to, String email) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper =
                    new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject("Confirm your email");
            helper.setFrom("confrimation.getandgo@gmail.com");
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            LOGGER.error("failed to send email", e);
            throw new IllegalStateException("failed to send email");
        }
    }
    public String buildEmailBody(String name, String token){
        String link="http://localhost:8080/api/confirm?token="+token;
        return "\n" +
                "<p>&nbsp;</p>\n" +
                "<table border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"><!-- start logo -->\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td align=\"center\" bgcolor=\"#e9ecef\">&nbsp;</td>\n" +
                "</tr>\n" +
                "<!-- end logo -->\n" +
                "<tr>\n" +
                "<td align=\"center\" bgcolor=\"#e9ecef\">\n" +
                "<table style=\"max-width: 600px;\" border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td style=\"padding: 36px 24px 0; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; border-top: 3px solid #d4dadf;\" align=\"left\" bgcolor=\"#ffffff\">\n" +
                "<h1 style=\"margin: 0; font-size: 32px; font-weight: bold; letter-spacing: -1px; line-height: 48px;\">Confirm Your Email Address</h1>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td align=\"center\" bgcolor=\"#e9ecef\">\n" +
                "<table style=\"max-width: 600px; height: 211px; width: 100%;\" border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "<tbody>\n" +
                "<tr style=\"height: 78px;\">\n" +
                "<td style=\"padding: 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 16px; line-height: 24px; height: 78px;\" align=\"left\" bgcolor=\"#ffffff\">\n" +
                "<p style=\"margin: 0;\">Hi ,"+name+"</p>\n" +
                "<pre>Thank you for registering.</pre>\n" +
                "<pre>Please click on the link below to activate your account:<br /><br /></pre>\n" +
                "<a href=\"" + link + "\">Activate Now</a>"+
                "</td>\n" +
                "</tr>\n" +
                "<tr style=\"height: 48px;\">\n" +
                "<td style=\"padding: 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 16px; line-height: 24px; border-bottom: 3px solid #d4dadf; height: 48px;\" align=\"left\" bgcolor=\"#ffffff\">\n" +
                "<p style=\"margin: 0;\">GetAndGo Team</p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td style=\"padding: 24px;\" align=\"center\" bgcolor=\"#e9ecef\">&nbsp;</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>";
    }
}
