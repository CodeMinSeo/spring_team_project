package bitc.fullstack503.team1.controller.kms;

import bitc.fullstack503.team1.dto.mysql.MyPlaceDTO;
import bitc.fullstack503.team1.dto.mysql.MySpotDTO;
import bitc.fullstack503.team1.service.kms.MainPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainPageController {

    @Autowired
    private MainPageService mainPageService;

    //    뷰("/kms"주소와 "main/kms/mainPage")는 하나만 mav(데이터) 부분은 여러개를 넣어서 사용 가능
    //    평점 가장 높은 명소 1개 뷰, 평균 평점이 같은 경우 리뷰 개수 기준으로 뷰
    @GetMapping(value = "/")
    public ModelAndView selectSpotRank() throws Exception {
        ModelAndView mav = new ModelAndView("main/kms/mainPage");

//        명소 평점 가장 높은 하나를 게시, 평균 평점이 같은 경우 리뷰 개수 기준으로 함
        MySpotDTO spotRank = mainPageService.selectSpotRank();
        mav.addObject("spotRank", spotRank);

//        리뷰 많은 순으로 맛집 10개 게시
        List<MyPlaceDTO> placeRankList = mainPageService.selectPlaceList();
        mav.addObject("placeRankList", placeRankList);


        return mav;
    }
}
