package bitc.fullstack503.team1.service.kms;

import bitc.fullstack503.team1.dto.mysql.MyPlaceDTO;
import bitc.fullstack503.team1.dto.mysql.MySpotDTO;
import bitc.fullstack503.team1.mapper.kms.MainPageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainPageServiceImpl implements MainPageService {

    @Autowired
    private MainPageMapper mainPageMapper;

    @Override
    public MySpotDTO selectSpotRank() throws Exception {
        return mainPageMapper.selectSpotRank();
    }

    @Override
    public List<MyPlaceDTO> selectPlaceList() throws Exception {
        return mainPageMapper.selectPlaceList();
    }
}
