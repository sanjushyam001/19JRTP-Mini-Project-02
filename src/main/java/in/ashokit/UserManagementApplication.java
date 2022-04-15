package in.ashokit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import in.ashokit.service.EmailService;


@SpringBootApplication
public class UserManagementApplication {

	@Autowired
	private EmailService emailService;
	
	public static void main(String[] args) {
		SpringApplication.run(UserManagementApplication.class, args);
		System.out.println("'UserManagementApplication' application started..");
	
		//Testing email sending
	}
	/*
	 * @EventListener(ApplicationReadyEvent.class) public void sendEmail() {
	 * emailService.sendEmail("kumarsanjugt@gmail.com", "Email Testing",
	 * "Email Testing"); }
	 */

}
