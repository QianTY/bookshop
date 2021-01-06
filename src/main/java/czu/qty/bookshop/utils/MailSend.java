package czu.qty.bookshop.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.servlet.http.HttpSession;

/**
 * @create 2020-12-25-13:17
 */
public class MailSend {

    @Autowired
    private JavaMailSender javaMailSender ;

    public String sendMailAction(String email){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("2895944345@qq.com");
        msg.setSubject("验证码");
        String code = "";
        for (int j = 0; j < 6; j++) {
            int i = (int) (Math.random() * 9+1);
            code = code + "" + i;
        }
        msg.setText(code);
        msg.setTo(email);
        javaMailSender.send(msg);
        return code;
    }

}
