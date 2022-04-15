package in.ashokit.entity;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class ForgotPasswordUserRequest {

	private String userEmail;
}
