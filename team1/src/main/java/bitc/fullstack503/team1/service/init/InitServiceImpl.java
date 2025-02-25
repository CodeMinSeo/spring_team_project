package bitc.fullstack503.team1.service.init;

import bitc.fullstack503.team1.dto.place.PItemDTO;
import bitc.fullstack503.team1.dto.place.PlaceDTO;
import bitc.fullstack503.team1.dto.spot.SItemDTO;
import bitc.fullstack503.team1.dto.spot.SpotDTO;
import bitc.fullstack503.team1.mapper.init.InitMapper;
import com.google.gson.Gson;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


@Service
public class InitServiceImpl implements InitService {

    @Value("${team1.spot.service.url}")
    private String spotUrl;

    @Value("${team1.spot.service.userKey}")
    private String spotUserKey;

    @Value("${team1.place.service.url}")
    private String placeUrl;

    @Value("${team1.place.service.userKey}")
    private String placeUserKey;

    @PostConstruct
    public void init() throws Exception {
        String serviceKey = "?serviceKey=";
        String opt1 = "&pageNo=";
        String opt2 = "&numOfRows=";
        String ResultJson = "&resultType=json";
        String SpotUrl = spotUrl + serviceKey + spotUserKey + opt1 + "1" + opt2 + "197" + ResultJson;
        String PlaceUrl = placeUrl + serviceKey + placeUserKey + opt1 + "1" + opt2 + "394" + ResultJson;

        System.out.println("관광명소 URL : " + SpotUrl);
        System.out.println("맛집 URL : " + PlaceUrl);

//        getSpotList(SpotUrl);
//        getPlaceList(PlaceUrl);
    }

    @Autowired
    private InitMapper initMapper;

    @Override
    public void getSpotList(String url) throws Exception {

        List<SItemDTO> spotList;

        URL Serviceurl = null;
        HttpURLConnection UrlCon = null;
        BufferedReader reader = null;

        try{
            Serviceurl = new URL(url);
            UrlCon = (HttpURLConnection) Serviceurl.openConnection();
            UrlCon.setRequestMethod("GET");

            reader = new BufferedReader(new InputStreamReader(UrlCon.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String line;

            while((line = reader.readLine()) != null){
                sb.append(line);
            }
            Gson gson = new Gson();

            SpotDTO SpotDTOList = gson.fromJson(sb.toString(), SpotDTO.class);

            spotList = SpotDTOList.getGetAttractionKr().getItem();

            initMapper.insertSpotList(spotList);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void getPlaceList(String url) throws Exception {

        List<PItemDTO> placeList;

        URL Serviceurl = null;
        HttpURLConnection UrlCon = null;
        BufferedReader reader = null;

        try{
            Serviceurl = new URL(url);
            UrlCon = (HttpURLConnection) Serviceurl.openConnection();
            UrlCon.setRequestMethod("GET");

            reader = new BufferedReader(new InputStreamReader(UrlCon.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String line;

            while((line = reader.readLine()) != null){
                sb.append(line);
            }
            Gson gson = new Gson();

            PlaceDTO placeDTOList = gson.fromJson(sb.toString(), PlaceDTO.class);

            placeList = placeDTOList.getGetFoodKr().getItem();

            initMapper.insertPlaceList(placeList);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
