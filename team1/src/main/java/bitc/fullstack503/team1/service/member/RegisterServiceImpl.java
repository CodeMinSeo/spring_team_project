package bitc.fullstack503.team1.service.member;

import bitc.fullstack503.team1.dto.member.RegisterDTO;
import bitc.fullstack503.team1.mapper.member.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private MemberMapper memberMapper;


    @Override
    public void memberReg(RegisterDTO registerDTO) throws Exception {
        memberMapper.memberReg(registerDTO);
    }

    @Override
    public boolean isUserInfo(String userId, String userPw1) {

        int result = memberMapper.isUserInfo(userId, userPw1);

        if (result == 1) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public RegisterDTO getUserInfo(String userId) {
        return memberMapper.getUserInfo(userId);
    }

//    아이드 중복 확인
//    데이터 베이스에 지정 아이디가 없다고 if(result==0) 고장
//    1. 입력한 아이디가 데이터 베이스 없는(return = true) 아이디며 가입 가능 / 있으면(return = false) 가입 불가능
    @Override
    public boolean checkId(String userId) {
        int result = memberMapper.checkId(userId);
        if (result == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
