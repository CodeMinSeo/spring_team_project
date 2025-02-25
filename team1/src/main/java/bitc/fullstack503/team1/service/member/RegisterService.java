package bitc.fullstack503.team1.service.member;

import bitc.fullstack503.team1.dto.member.RegisterDTO;

public interface RegisterService {

    public void memberReg(RegisterDTO registerDTO) throws Exception;

    boolean isUserInfo(String userId, String userPw1);

    RegisterDTO getUserInfo(String userId);

    boolean checkId(String userId);
}
