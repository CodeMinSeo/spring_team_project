package bitc.fullstack503.team1.service.main;

import bitc.fullstack503.team1.dto.mysql.MyPlaceDTO;
import bitc.fullstack503.team1.dto.mysql.MySpotDTO;
import bitc.fullstack503.team1.mapper.main.ListMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchListServiceImpl implements SearchListService {

    @Autowired
    private ListMapper listMapper;


    @Override
    public MySpotDTO selectDetailSpot(int ucseq) throws Exception {
        return listMapper.selectDetailSpot(ucseq);
    }


    @Override
    public Page<MySpotDTO> SelectPageSearchListA(String keyword, int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 5);
        Page<MySpotDTO> Spot = listMapper.selectPageSearchListA(keyword);

        return Spot;
    }

    @Override
    public Page<MyPlaceDTO> SelectPageSearchListB(String keyword, int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 5);
        Page<MyPlaceDTO> Place = listMapper.selectPageSearchListB(keyword);

        return Place;
    }

    @Override
    public List<MySpotDTO> selectGugunList() throws Exception {
        return listMapper.selectGugunList();
    }

    @Override
    public MyPlaceDTO selectDetailPlace(int ucseq) throws Exception {
        return listMapper.selectDetailPlace(ucseq);
    }

    @Override
    public int SelectCountResult(String keyword) throws Exception {
        return listMapper.selectCountResult(keyword);
    }

    @Override
    public int SelectCountResultB(String keyword) throws Exception {
        return listMapper.selectCountResultB(keyword);
    }

    @Override
    public int SelectABtype(String keyword, String category, int pageNum) throws Exception {

        int result;

        if("A".equals(category)){
            result = 1;
        }else if("B".equals(category)){
            result = 2;
        }else{
//            디폴트 값
            result = 1;
        }

        return result;
    }

    @Override
    public void insertBookmark(String userId, int ucSeq) throws Exception {
        listMapper.insertBookmark(userId, ucSeq);
    }

    @Override
    public void deleteBookmark(String userId, int ucSeq) throws Exception {
        listMapper.deleteBookmark(userId, ucSeq);
    }

    @Override
    public int selectBookmark(int ucseq, String userId) throws Exception {
        return listMapper.selectBookmark(ucseq, userId);
    }

    @Override
    public void insertBookmarkB(String userId, int ucSeq) throws Exception {
        listMapper.insertBookmarkB(userId, ucSeq);
    }

    @Override
    public void deleteBookmarkB(String userId, int ucSeq) throws Exception {
        listMapper.deleteBookmarkB(userId, ucSeq);
    }

    @Override
    public int selectBookmarkB(int ucseq, String userId) throws Exception {
        return listMapper.selectBookmarkB(ucseq, userId);
    }
}
