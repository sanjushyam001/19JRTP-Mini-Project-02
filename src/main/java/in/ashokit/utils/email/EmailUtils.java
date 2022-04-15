package in.ashokit.utils.email;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class EmailUtils {

	private String subject="Unlock User";
	private String body="";
	
	public String formatWelcomeEmail(String fname,String lname,String generatedPaswd,String toEmail) {
		
		body=body+"Hi, "+fname+" "+lname+"\n Welcome to our family,Your registration is almost complete.\n";
		body=body+"Please unlock your account using below details\n";
		body=body+"\nTemporary password: "+generatedPaswd+"\n\n";
		body=body+"Click here : http://localhost:4200/edit?email="+toEmail+"";
		
		return body;
	}
}
