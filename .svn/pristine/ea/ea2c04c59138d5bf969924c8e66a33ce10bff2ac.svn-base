package com.wanjia.infoshopmallmanage.util;


import com.wanjia.infoshopmallmanage.entity.UploadDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Martin
 * @Date: 2018/12/12
 * @Description:
 * @Modify By:
 */
@Slf4j
@Component
public class FileVidiouploadUtil  {
    private final String  TARGETFILE=System.getProperty("user.dir")+"/src/main/resources/static/vidio"	;
    private String accessPath;
 
    /**
     * 功能描述: 上传文件
     *
     * @param multipartFile
     * @return java.util.List<com.saliai.lifebank_mall.common.model.UploadDto>
     * @author Martin
     * @date 2018/12/12
     * @version V1.0
     */
    public List<UploadDto> upload(MultipartFile multipartFile) {
 
        log.info(" >>> 文件上传入口... <<< ");
        List<UploadDto> list = new ArrayList<>();
        if (multipartFile == null) {
           return null;
        }
        UploadDto uploadDto = new UploadDto();
        String fileName = "";
        File filePath = new File(TARGETFILE);
        if (!filePath.mkdir()) {
            filePath.mkdirs();
        }
        try {
            byte[] bytes = multipartFile.getBytes();
            //获取上传文件类型
            String fileUrl = multipartFile.getOriginalFilename();
            String fileType = fileUrl.substring(fileUrl.lastIndexOf("/")+1).toLowerCase();
            uploadDto.setImgType("cover");
            uploadDto.setImgSuffix(fileType);
            //自定义上传文件的名字
            fileName = System.currentTimeMillis()  + fileType;
            uploadDto.setImgName(fileName);
            //截取文件格式
            String type = fileUrl.substring(fileUrl.lastIndexOf(".") + 1).toLowerCase();
            String destPath = filePath + File.separator + fileName;
            //保存到一个目标文件中
            multipartFile.transferTo(new File(destPath));
            uploadDto.setRealPath(TARGETFILE + "/" + fileName);
            uploadDto.setHttpPath(accessPath + "/" + fileName);
            list.add(uploadDto);
            log.info(" >>> 文件上传结束... <<< ");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("You failed to upload " + " => " + e.getMessage());
           
        }
        return list;
    }
 
    /**
     * 功能描述:删除文件
     *
     * @param fileRealUrl
     * @return boolean
     * @author Martin
     * @date 2018/12/12
     * @version V1.0
     */
    public boolean removeFile(String fileRealUrl) {
 
        boolean result = false;
        File file = null;
        if (!StringUtils.isEmpty(fileRealUrl)) {
            file = new File(fileRealUrl);
        } else {
            result = false;
        }
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (!file.delete()) {
               
            }
            result = true;
        }
        return result;
    }
 
    /**
     * 批量上传文件
     *
     * @param request
     * @return
     */
    public List<UploadDto> handleFileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("file");
        return this.uploadBatchFile(files);
 
    }
 
    /**
     * 功能描述: 多文件上传
     *
     * @param multipartFileList
     * @return java.util.List<com.saliai.lifebank_mall.common.model.UploadDto>
     * @author Martin
     * @date 2018/12/25
     * @version V1.0
     */
    public List<UploadDto> uploadBatchFile(List<MultipartFile> multipartFileList) {
        log.info(" >>> 文件上传入口... <<< ");
        List<UploadDto> list = new ArrayList<>();
        if (multipartFileList == null || multipartFileList.size() < 1) {
            
        }
        String fileName = "";
        File filePath = new File(TARGETFILE);
        if (!filePath.mkdir()) {
            filePath.mkdirs();
        }
        try {
            for (MultipartFile multipartFile : multipartFileList) {
                UploadDto uploadDto = new UploadDto();
                byte[] bytes = multipartFile.getBytes();
                //获取上传文件类型
                String fileUrl = multipartFile.getOriginalFilename();
                String fileType = fileUrl.substring(fileUrl.lastIndexOf(".")).toLowerCase();
                uploadDto.setImgType("detail");
                uploadDto.setImgSuffix(fileType);
                //自定义上传文件的名字
                fileName = System.currentTimeMillis()  + fileType;
                uploadDto.setImgName(fileName);
                //截取文件格式
                String type = fileUrl.substring(fileUrl.lastIndexOf(".") + 1).toLowerCase();
                String destPath = filePath + File.separator + fileName;
                //保存到一个目标文件中
                multipartFile.transferTo(new File(destPath));
                uploadDto.setRealPath(TARGETFILE + "/" + fileName);
                uploadDto.setHttpPath(accessPath + "/" + fileName);
                list.add(uploadDto);
            }
            log.info(" >>> 文件上传结束... <<< ");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("You failed to upload " + " => " + e.getMessage());
           
        }
        return list;
    }
     public  String fileName(String file) {

    	 return TARGETFILE + File.separator + file;
     }

}
 
 
