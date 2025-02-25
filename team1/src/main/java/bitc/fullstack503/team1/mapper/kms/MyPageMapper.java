package bitc.fullstack503.team1.mapper.kms;

import bitc.fullstack503.team1.dto.mysql.MyPlaceDTO;
import bitc.fullstack503.team1.dto.mysql.MyReviewBoardDTO;
import bitc.fullstack503.team1.dto.mysql.MySpotDTO;
import bitc.fullstack503.team1.dto.mysql.MyUserDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MyPageMapper {

    MyUserDTO selectMyProfile(@Param("userId") String userId);

    Page<MyReviewBoardDTO> selectReviewByUserName(String userId) throws Exception;

    MyReviewBoardDTO selectReviewDetail(String userId, int reviewIdx) throws Exception;

    void updateReview(MyReviewBoardDTO reviews);

    void deleteReview(int reviewIdx);

    Page<MySpotDTO> selectMySpot(String userId) throws Exception;

    Page<MyPlaceDTO> selectMyPlace(String userId) throws Exception;

    Page<MyReviewBoardDTO> selectReviewByManager() throws Exception;

    MyUserDTO selectUserGrade(String userId) throws Exception;

    MyReviewBoardDTO selectReviewDetailGradeA(int reviewIdx) throws Exception;

    Page<MyUserDTO> selectUserByManager()  throws Exception;

    MyUserDTO selectUserDetail(String userId) throws Exception;

    void updateUser(MyUserDTO userId);

    void deleteUser(String userId);
}
