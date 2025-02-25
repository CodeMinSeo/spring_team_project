package bitc.fullstack503.team1.service.main;

import bitc.fullstack503.team1.dto.mysql.MyReviewBoardDTO;
import bitc.fullstack503.team1.dto.mysql.ReviewImageDTO;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface ReviewService {
    List<MyReviewBoardDTO> selectDetailReviewCardListA(int ucseq) throws Exception;

    List<MyReviewBoardDTO> selectDetailReviewCardListB(int ucseq) throws Exception;

    void insertReviewA(MyReviewBoardDTO review, MultipartHttpServletRequest multipart) throws Exception;

    void insertReviewB(MyReviewBoardDTO review, MultipartHttpServletRequest multipart) throws Exception;


}
