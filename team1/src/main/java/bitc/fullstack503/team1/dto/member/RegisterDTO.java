package bitc.fullstack503.team1.dto.member;

import lombok.Data;

@Data
public class RegisterDTO {
    private String userId;
    private String userPw1;
    private String userName;
    private String userEmail;
    private String userPhone;
//    private String userBirthday;
    private String createDate;
    private String updateDate;
}
