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
   public UserDTO(String username, String userid, String userpwd) {
      super();
      this.username = username;
      this.userid = userid;
      this.userpwd = userpwd;
   }
   private String userid;
   public UserDTO(String userid, String userpwd) {
      super();
      this.userid = userid;
      this.userpwd = userpwd;
   }
   private String userpwd;
   private String mvname;
   private int mvtime;
   private String loc; //상영관
   private String sitnum;//좌석
   private String Mvcode;
   
}