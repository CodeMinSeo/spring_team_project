package bitc.fullstack503.team1.service.main;

import bitc.fullstack503.team1.dto.mysql.MyReviewBoardDTO;
import bitc.fullstack503.team1.dto.mysql.ReviewImageDTO;
import bitc.fullstack503.team1.mapper.main.ReviewMapper;
import bitc.fullstack503.team1.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;


@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewMapper reviewMapper;


    @Override
    public List<MyReviewBoardDTO> selectDetailReviewCardListA(int ucseq) throws Exception {
        return reviewMapper.selectDetailReviewCardListA(ucseq);
    }

    @Override
    public List<MyReviewBoardDTO> selectDetailReviewCardListB(int ucseq) throws Exception {
        return reviewMapper.selectDetailReviewCardListB(ucseq);
    }

    @Override
    public void insertReviewA(MyReviewBoardDTO review, MultipartHttpServletRequest multipart) throws Exception {
        reviewMapper.insertReviewA(review);
        List<ReviewImageDTO> imgList = ImageUtil.parseFileInfo(review.getReviewIdx(), review.getUserId(), multipart);
        if(!CollectionUtils.isEmpty(imgList)){
            reviewMapper.insertReviewImgListA(imgList);
        }
        int avgRating = reviewMapper.avgRatingA(review.getUCSEQ());
        reviewMapper.updateSpotRating(review.getUCSEQ(), avgRating);
    }

    @Override
    public void insertReviewB(MyReviewBoardDTO review, MultipartHttpServletRequest multipart) throws Exception {
        reviewMapper.insertReviewB(review);
        List<ReviewImageDTO> imgList = ImageUtil.parseFileInfo(review.getReviewIdx(), review.getUserId(), multipart);
        if(!CollectionUtils.isEmpty(imgList)){
            reviewMapper.insertReviewImgListB(imgList);
        }
        int avgRating = reviewMapper.avgRatingB(review.getUCSEQ());
        reviewMapper.updatePlaceRating(review.getUCSEQ(), avgRating);
    }
}
