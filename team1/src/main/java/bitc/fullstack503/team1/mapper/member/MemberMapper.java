package bitc.fullstack503.team1.mapper.member;

import bitc.fullstack503.team1.dto.member.RegisterDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    void memberReg(RegisterDTO registerDTO) throws Exception;


    int isUserInfo(String userId, String userPw1);

    RegisterDTO getUserInfo(String userId);

    int checkId(String userId);
}
