package bitc.fullstack503.team1.dto.mysql;

import lombok.Data;

@Data
public class MyUserDTO {
    private String userId;
    private String userPw1;
    private String userPw;
    private String userName;
    private String userEmail;
    private String userPhone;
    //    private String userBirthday;
    private String createDate;
    private String updateDate;
    private String grade;
    private String deletedYn;
}
