package in.ashokit.entity;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@XmlRootElement
public class UnLockUserRequest {

	private String userEmail;
	private String userTempPaswd;
	private String userNewPaswd;
}
