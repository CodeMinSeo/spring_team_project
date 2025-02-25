package bitc.fullstack503.team1.mapper.main;

import bitc.fullstack503.team1.dto.mysql.MyReviewBoardDTO;
import bitc.fullstack503.team1.dto.mysql.ReviewImageDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReviewMapper {
    List<MyReviewBoardDTO> selectDetailReviewCardListA(int ucseq) throws Exception;

    List<MyReviewBoardDTO> selectDetailReviewCardListB(int ucseq) throws Exception;

    void insertReviewA(MyReviewBoardDTO review) throws Exception;

    void insertReviewImgListA(List<ReviewImageDTO> imgList) throws Exception;

    void insertReviewB(MyReviewBoardDTO review) throws Exception;

    void insertReviewImgListB(List<ReviewImageDTO> imgList) throws Exception;

    int avgRatingA(int ucseq) throws Exception;

    void updateSpotRating(int ucseq, int avgRating) throws Exception;

    int avgRatingB(int ucseq) throws Exception;

    void updatePlaceRating(int ucseq, int avgRating) throws Exception;
}
