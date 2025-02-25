package bitc.fullstack503.team1.util;

import bitc.fullstack503.team1.dto.mysql.ReviewImageDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class ImageUtil {
    public static List<ReviewImageDTO> parseFileInfo(int reviewIdx, String userId, MultipartHttpServletRequest multipart) throws Exception {

        if(ObjectUtils.isEmpty(multipart)){
            return null;
        }

        List<ReviewImageDTO> fileList = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ZonedDateTime current = ZonedDateTime.now();

        String path = "C:/fullstack503/images/" + current.format(formatter);

        File file = new File(path);

        if(!file.exists()){
            file.mkdirs();
        }

        Iterator<String> iterator = multipart.getFileNames();
        String newFileName;
        String originalFileExt;
        String contentType;

        while(iterator.hasNext()){
            String name = iterator.next();
            List<MultipartFile> multipartFileList = multipart.getFiles(name);
            for(MultipartFile uploadFile : multipartFileList){
                contentType = uploadFile.getContentType();
                if(ObjectUtils.isEmpty(contentType)){
                    break;
                }else{
                    if(contentType.contains("image/jpeg")){
                        originalFileExt = ".jpg";
                    }else if(contentType.contains("image/png")){
                        originalFileExt = ".png";
                    }else if(contentType.contains("image/gif")){
                        originalFileExt = ".gif";
                    }else{
                        break;
                    }
                }
                newFileName = System.nanoTime() + originalFileExt;
                ReviewImageDTO ReviewImageDTO = new ReviewImageDTO();
                ReviewImageDTO.setReviewIdx(reviewIdx);
                ReviewImageDTO.setFileSize(uploadFile.getSize());
                ReviewImageDTO.setOriginalFileName(uploadFile.getOriginalFilename());
                ReviewImageDTO.setStoredFileName(path + "/" + newFileName);
                ReviewImageDTO.setImageUrl(path + "/" + newFileName);
                ReviewImageDTO.setUserId(userId);


                fileList.add(ReviewImageDTO);

                file = new File(path + "/" + newFileName);
                uploadFile.transferTo(file);
            }
        }
        return fileList;
    }
}
