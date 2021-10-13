package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	private String username;
	private String userid;
	private String userpwd;
	private String mvname;
	private int mvtime;
	private String loc;
	private String sitnum;
	
}
