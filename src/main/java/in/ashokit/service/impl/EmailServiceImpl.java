package in.ashokit.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import in.ashokit.constants.AppConstants;
import in.ashokit.props.AppProperties;
import in.ashokit.service.EmailService;


@Service
public class EmailServiceImpl implements EmailService{

	
	//create java mail sender object
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private AppProperties appProps;
	
	@Override
	public boolean sendEmail(String toEmail, String subject, String body) {
	
		Map<String, String> messages = appProps.getMessages();
		try {
			SimpleMailMessage emailMessage=new SimpleMailMessage();
			//message.setFrom("kumarsanjuashokit@gmail.com");
			emailMessage.setFrom(messages.get(AppConstants.EMAIL_FROM));
			emailMessage.setTo(toEmail);
			emailMessage.setSubject(subject);
			emailMessage.setText(body);
			
			
			mailSender.send(emailMessage);
			return true;
		}catch (Exception e) {
			System.out.println(e.getMessage()); 
			return false;
		}
		
	}

}
