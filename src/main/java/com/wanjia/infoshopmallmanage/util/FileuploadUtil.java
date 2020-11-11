package com.wanjia.infoshopmallmanage.util;

import com.wanjia.infoshopmallmanage.entity.UploadDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
public class FileuploadUtil  {
    @Value("${file.uploadFolder}")
    private String uploadFolder;
    @Value("${file.staticAccessPath}")
    private String staticAccessPath;
    /**
     * 功能描述: 上传文件
     *
     * @param multipartFile
     * @return java.util.List<com.saliai.lifebank_mall.common.model.UploadDto>
     * @author Martin
     * @date 2018/12/12
     * @version V1.0
     */
    public String upload(MultipartFile multipartFile, String userName) {
 
        log.info(" >>> 文件上传入口... <<< ");
        List<UploadDto> list = new ArrayList<>();
        if (multipartFile == null) {
           return null;
        }
        UploadDto uploadDto = new UploadDto();
        String fileName = "";
        File filePath = new File(uploadFolder+userName);
        System.out.println(uploadFolder);
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
            fileName = userName+"/"+System.currentTimeMillis() + fileType;
            log.info(fileName);
            uploadDto.setImgName(userName+"/"+fileName);
            //截取文件格式
            String type = fileUrl.substring(fileUrl.lastIndexOf(".") + 1).toLowerCase();
            String destPath = filePath + File.separator + fileName;
            //保存到一个目标文件中
            multipartFile.transferTo(new File(destPath));
            uploadDto.setRealPath(uploadFolder + "/" + fileName);
            list.add(uploadDto);
            log.info(" >>> 文件上传结束... <<< ");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("You failed to upload " + " => " + e.getMessage());
           
        }
        return fileName;
    }
    
    public boolean uploadDefaultFile(MultipartFile file,String defaultFileName) 
    {
		try 
		{
			file.transferTo(new File(uploadFolder+defaultFileName));
		} 
		catch (Exception e) 
		{
			return false;
		} 
		return	true; 
    }
 
    /**
     * 功能描述:删除文件以逗号分隔的文件路径
     *
     * @param fileRealUrl
     * @return boolean
     * @author Martin
     * @date 2018/12/12
     * @version V1.0
     */
    public boolean removeFile(String fileRealUrl) {
        if(StringUtils.isEmpty(fileRealUrl)){
            return false;
        }
        String[] fileUrls = fileRealUrl.split(",");
        for(String fileUrl:fileUrls){
            File file = null;
            if (!StringUtils.isEmpty(fileUrl)) {
                file = new File(uploadFolder+fileUrl);
            }
            // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
            if (file.exists() && file.isFile()) {
                if(file.delete()){
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * 删除指定的用户文件
     * @param fileUrl
     * @return
     */
    public boolean removeUserFile(String fileUrl) {
        File file = null;
        if (!StringUtils.isEmpty(fileUrl)) {
            file = new File(uploadFolder+fileUrl);
        } else {
            return false;
        }
        if(file.isFile())
        {
            file.delete();
        }else {
            File[] files = file.listFiles();
            if (files == null) {
                file.delete();
            }else
            {
                for (int i = 0; i < files.length; i++)
                {
                    removeUserFile(files[i].getAbsolutePath());
                }
                file.delete();
            }
        }
        return true;
    }
 
    /**
     * 批量上传文件
     *
     * @param request
     * @return
     */
    public List<UploadDto> handleFileUpload(HttpServletRequest request,String userName) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("file");
        return this.uploadBatchFile(files,userName);
 
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
    public List<UploadDto> uploadBatchFile(List<MultipartFile> multipartFileList, String userName) {
        log.info(" >>> 文件上传入口... <<< ");
        List<UploadDto> list = new ArrayList<>();
        if (multipartFileList == null || multipartFileList.size() < 1) {
            
        }
        String fileName = "";
        File filePath = new File(uploadFolder+userName);
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
                fileName = System.currentTimeMillis()+userName  + fileUrl;
         
                uploadDto.setImgName(userName+"/"+fileName);
                //截取文件格式
                String type = fileUrl.substring(fileUrl.lastIndexOf(".") + 1).toLowerCase();
                String destPath = filePath + File.separator + fileName;
                //保存到一个目标文件中
                multipartFile.transferTo(new File(destPath));
                uploadDto.setRealPath(uploadFolder + "/" + fileName);
                uploadDto.setHttpPath(uploadFolder + "/" + fileName);
                list.add(uploadDto);
            }
            log.info(" >>> 文件上传结束... <<< ");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("You failed to upload " + " => " + e.getMessage());
           
        }
        return list;
    }
    /**
     * 
     * @param fileName  获取文件物理地址
     * @return
     */
     public  String fileName(String fileName) {

    	 return uploadFolder + File.separator + fileName; 
     }
   /**
    * 
    * @param fileName 文件路径
    * @return
    */
     public String fileVideoName(String fileName) {
    	 return "/filelong/"+fileName; 
     }

    /**
     * 访问路径
     * @param fileName
     * @return
     */
     public String filePath(String fileName){
         if(fileName == null){
             return null;
         }
        String path = staticAccessPath.substring(0,staticAccessPath.lastIndexOf("/"));
        return path+"/"+fileName;
     }
     /**
      * 	拼接文件路径
      * @param fileName
      * @return
      */
     public String makeFileName(String fileName) {
    	 return "/file"+"/"+fileName;
     }

    /**
     * 上传文件
     * @param multipartFile
     * @param folder 文件夹
     * @return
     */
    public String fileUpload(MultipartFile multipartFile, String folder) {
        log.info(" >>> 文件上传入口... <<< ");
        if (multipartFile == null) {
            log.debug("没有上传文件");
            return null;
        }
        if(StringUtil.isEmpty(multipartFile.getOriginalFilename())){
            return null;
        }
        File filePath = new File(uploadFolder+File.separator+folder);
        if (!filePath.mkdir()) {
            filePath.mkdirs();
        }
        String fileName = "";
        try {
            //获取上传文件名
            String originalFilename = multipartFile.getOriginalFilename();
            if(originalFilename.lastIndexOf(".") == -1){
                log.debug("文件没有后缀");
                return null;
            }
            //自定义上传文件的名字
            fileName= System.currentTimeMillis()  + originalFilename;
            String destPath = filePath + File.separator + fileName;
            //保存到一个目标文件中
            multipartFile.transferTo(new File(destPath));
            log.info(" >>> 文件上传结束... <<< ");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("You failed to upload " + " => " + e.getMessage());
            return null;
        }
        return folder+"/"+fileName;
    }

    /**
     * 批量上传文件
     * @param multipartFileList
     * @param folder 文件夹
     * @return
     */
    public String batchFileUpload(List<MultipartFile> multipartFileList, String folder) {
        if (multipartFileList == null || multipartFileList.isEmpty()) {
            log.debug("没有上传文件");
            return null;
        }
        File filePath = new File(uploadFolder+File.separator+folder);
        if (!filePath.mkdir()) {
            filePath.mkdirs();
        }
        String url = "";
        for(MultipartFile multipartFile:multipartFileList) {
            //获取上传文件名称
            String originalFilename = multipartFile.getOriginalFilename();
            if(StringUtil.isEmpty(originalFilename)) {
                return null;
            }
            String fileName = "";
            try {
                if(originalFilename.lastIndexOf(".") == -1){
                    log.debug("文件没有后缀");
                    return null;
                }
                //自定义上传文件的名字
                fileName = System.currentTimeMillis() + originalFilename;
                String destPath = filePath + File.separator + fileName;
                //保存到一个目标文件中
                multipartFile.transferTo(new File(destPath));
            } catch (Exception e) {
                e.printStackTrace();
                log.error("You failed to upload " + " => " + e.getMessage());
                return null;
            }
            url += folder+"/"+fileName+",";
        }
        return url.substring(0,url.length()-1);
    }

    public Long imageUpload(MultipartFile file) {
 
        //文件名称
	String realFileName = file.getOriginalFilename();
	//文件后缀
	String suffix = realFileName.substring(realFileName.lastIndexOf(".") + 1);
    
        /*************获取文件大小****************/
        Long len = file.getSize();
        return len;
      
}

}
