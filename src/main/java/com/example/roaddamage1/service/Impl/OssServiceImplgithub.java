package com.example.roaddamage1.service.Impl;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyun.oss.model.ObjectMetadata;
import com.example.roaddamage1.DO.UrlObjectDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class OssServiceImplgithub {

    @Autowired(required = false)
    private com.example.roaddamage1.service.PicUrlService PicUrlService;

    public String uploadfile(MultipartFile multipartFile) throws Exception {
         String fileUrl = null;
        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
        String endpoint = "oss-cn-hangzhou.aliyuncs.com";
        // 强烈建议不要把访问凭证保存到工程代码里，否则可能导致访问凭证泄露，威胁您账号下所有资源的安全。本代码示例以从环境变量中获取访问凭证为例。运行本代码示例之前，请先配置环境变量。
//      https://help.aliyun.com/document_detail/2362535.html?spm=a2c4g.32011.0.0.2cf21cc8tJb73c
        EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = "111";
        String accessKeySecret = "222";
        // 填写Bucket名称，例如examplebucket。
        String bucketName = "roaddamagedetector";
//             填写Object完整路径，例如exampledir/exampleobject.txt。Object完整路径中不能包含Bucket名称。
//            String objectName = "exampledir/exampleobject.txt";

        // 创建OSSClient实例。
        //OSS ossClient = new OSSClientBuilder().build(endpoint, credentialsProvider);
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
//                String content = "Hello OSS";
//                ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(content.getBytes()));

            InputStream inputStream = multipartFile.getInputStream();
            // 2: 获取文件上传的流   public String uploadfile(File multipartFile)
//            InputStream inputStream = new FileInputStream(multipartFile);
            // 3：构建日期目录
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String datePath = dateFormat.format(new Date());// 日期目录：2021/10/27
            // 4: 获取文件名
            String originname = multipartFile.getOriginalFilename(); // 上传的文件：aaa.jpg
            String filename = UUID.randomUUID().toString();
           String suffix = originname.substring(originname.lastIndexOf("."));  //jpg
            String newName = filename + suffix;
            fileUrl =  datePath + "/" + newName;
            //5：文件上传到阿里云服务器

            /**
             * 下面两行代码是重点坑：
             * 现在阿里云OSS 默认图片上传ContentType是image/jpeg
             * 也就是说，获取图片链接后，图片是下载链接，而并非在线浏览链接，
             * 因此，这里在上传的时候要解决ContentType的问题，将其改为image/jpg
             */
            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentType("image/jpg");

            //文件上传至阿里云OSS
            ossClient.putObject(bucketName, fileUrl, inputStream, meta);
//            ossClient.putObject(bucketName, fileUrl, inputStream);


        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        // 获取文件上传后的图片返回地址
        PicUrlService.insertUrl(new UrlObjectDO(1,"http://" + bucketName + "." + endpoint + "/" + fileUrl));
        return  "http://" + bucketName + "." + endpoint + "/" + fileUrl;
    }


    public String uploadfile1(MultipartFile multipartFile) throws Exception {
        String fileUrl = null;
        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
        String endpoint = "oss-cn-hangzhou.aliyuncs.com";
        // 强烈建议不要把访问凭证保存到工程代码里，否则可能导致访问凭证泄露，威胁您账号下所有资源的安全。本代码示例以从环境变量中获取访问凭证为例。运行本代码示例之前，请先配置环境变量。
//            https://help.aliyun.com/document_detail/2362535.html?spm=a2c4g.32011.0.0.2cf21cc8tJb73c
        EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = "111";
        String accessKeySecret = "22";
        // 填写Bucket名称，例如examplebucket。
        String bucketName = "roaddamagedetector";
//             填写Object完整路径，例如exampledir/exampleobject.txt。Object完整路径中不能包含Bucket名称。
//            String objectName = "exampledir/exampleobject.txt";

        // 创建OSSClient实例。
        //OSS ossClient = new OSSClientBuilder().build(endpoint, credentialsProvider);
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
//                String content = "Hello OSS";
//                ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(content.getBytes()));

            InputStream inputStream = multipartFile.getInputStream();
            // 2: 获取文件上传的流   (File multipartFile)
//            InputStream inputStream = new FileInputStream(multipartFile);
            // 3：构建日期目录
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String datePath = dateFormat.format(new Date());// 日期目录：2021/10/27
            // 4: 获取文件名
            String originname = multipartFile.getOriginalFilename(); // 上传的文件：aaa.jpg
            String filename = UUID.randomUUID().toString();
            String suffix = originname.substring(originname.lastIndexOf("."));  //jpg
            String newName = filename + suffix;
            fileUrl =  datePath + "/" + newName;
            //5：文件上传到阿里云服务器

            /**
             * 下面两行代码是重点坑：
             * 现在阿里云OSS 默认图片上传ContentType是image/jpeg
             * 也就是说，获取图片链接后，图片是下载链接，而并非在线浏览链接，
             * 因此，这里在上传的时候要解决ContentType的问题，将其改为image/jpg
             */
//            ObjectMetadata meta = new ObjectMetadata();
//            meta.setContentType("image/jpg");

            //文件上传至阿里云OSS
            ossClient.putObject(bucketName, fileUrl, inputStream);


        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        // 获取文件上传后的图片返回地址
        return  "http://" + bucketName + "." + endpoint + "/" + fileUrl;
    }

}
