package bitc.fullstack503.team1.service.kms;

import bitc.fullstack503.team1.dto.mysql.MyPlaceDTO;
import bitc.fullstack503.team1.dto.mysql.MyReviewBoardDTO;
import bitc.fullstack503.team1.dto.mysql.MySpotDTO;
import bitc.fullstack503.team1.dto.mysql.MyUserDTO;
import bitc.fullstack503.team1.mapper.kms.MyPageMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyPageServiceImpl implements MyPageService {

    @Autowired
    private MyPageMapper myPageMapper;

    @Override
    public MyUserDTO selectMyProfile(String userId) {
        MyUserDTO profile = myPageMapper.selectMyProfile(userId);
        return profile;
    }

    @Override
    public Page<MyReviewBoardDTO> selectReviewByUserName(int pageNum, String userId) throws Exception {

        PageHelper.startPage(pageNum, 4);

        return myPageMapper.selectReviewByUserName(userId);
    }

    @Override
    public MyReviewBoardDTO selectReviewDetail(String userId, int reviewIdx) throws Exception {
        MyUserDTO user = myPageMapper.selectUserGrade(userId);
        if(user != null && "A".equals(user.getGrade())){
            return myPageMapper.selectReviewDetailGradeA(reviewIdx);
        }else{
            return myPageMapper.selectReviewDetail(userId, reviewIdx);
        }
    }

    @Override
    public void updateReview(MyReviewBoardDTO reviews)  {
        myPageMapper.updateReview(reviews);
    }

    @Override
    public void deleteReview(int reviewIdx)  {
        myPageMapper.deleteReview(reviewIdx);
    }

    @Override
    public Page<MySpotDTO> selectMySpot(int pageNum, String userId) throws Exception  {

        PageHelper.startPage(pageNum, 2);

        return myPageMapper.selectMySpot(userId);
    }

    @Override
    public Page<MyPlaceDTO> selectMyPlace(int pageNum, String userId) throws Exception  {

        PageHelper.startPage(pageNum, 2);

        return myPageMapper.selectMyPlace(userId);
    }

    @Override
    public Page<MyReviewBoardDTO> selectReviewByManager(int pageNum) throws Exception {

        PageHelper.startPage(pageNum, 15);

        return myPageMapper.selectReviewByManager();

//        return myPageMapper.selectReviewByManager();
    }

    @Override
    public Page<MyUserDTO> selectUserByManager(int pageNum) throws Exception {

        PageHelper.startPage(pageNum, 15);

        return myPageMapper.selectUserByManager();
    }

    @Override
    public MyUserDTO selectUserDetail(String userId) throws Exception {
        return myPageMapper.selectUserDetail(userId);
    }

    @Override
    public void updateUser(MyUserDTO userId) {
        myPageMapper.updateUser(userId);
    }

    @Override
    public void deleteUser(String userId) {
        myPageMapper.deleteUser(userId);
    }


}
