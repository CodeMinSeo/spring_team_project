package bitc.fullstack503.team1.service.kms;

import bitc.fullstack503.team1.dto.mysql.MyPlaceDTO;
import bitc.fullstack503.team1.dto.mysql.MyReviewBoardDTO;
import bitc.fullstack503.team1.dto.mysql.MySpotDTO;
import bitc.fullstack503.team1.dto.mysql.MyUserDTO;
import com.github.pagehelper.Page;

import java.util.List;

public interface MyPageService {


    MyUserDTO selectMyProfile(String userId) throws Exception;

    Page<MyReviewBoardDTO> selectReviewByUserName(int pageNum, String userId) throws Exception;

    MyReviewBoardDTO selectReviewDetail(String userId, int reviewIdx) throws Exception;

    void updateReview(MyReviewBoardDTO reviews);

    void deleteReview(int reviewIdx);

    Page<MySpotDTO> selectMySpot(int pageNum, String userId) throws Exception;

    Page<MyPlaceDTO> selectMyPlace(int pageNum, String userId) throws Exception;

    Page<MyUserDTO> selectUserByManager(int pageNum) throws Exception;

    Page<MyReviewBoardDTO> selectReviewByManager(int pageNum) throws Exception;

    MyUserDTO selectUserDetail(String userId) throws Exception;

    void updateUser(MyUserDTO userId);

    void deleteUser(String userId);
}
