//package com.example.gradruate;
//
//import com.aliyun.oss.ClientException;
//import com.aliyun.oss.OSS;
//import com.aliyun.oss.OSSClientBuilder;
//import com.aliyun.oss.OSSException;
//import com.example.gradruate.commonutils.ConstantPropertiesUtils;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class GradruateApplicationTests {
//    /**
//     * 根据文件名删除oss单个文件
//     */
//    @Test
//    void contextLoads() {
//        String endpoint = ConstantPropertiesUtils.END_POIND;
//        String accessKeyId = ConstantPropertiesUtils.ACCESS_KEY_ID;
//        String accessKeySecret = ConstantPropertiesUtils.ACCESS_KEY_SECRET;
//        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;
//
//        // 创建OSSClient实例。
//        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
//
//        try {
//            // 删除文件或目录。如果要删除目录，目录必须为空。
//            String objectName = "2022/11/17/e3ade4627fd044479a56858742d4e814520.jpg";
//            ossClient.deleteObject(bucketName, objectName);
//            System.out.println("删除成功");
//        } catch (OSSException oe) {
//            System.out.println("Caught an OSSException, which means your request made it to OSS, "
//                    + "but was rejected with an error response for some reason.");
//            System.out.println("Error Message:" + oe.getErrorMessage());
//            System.out.println("Error Code:" + oe.getErrorCode());
//            System.out.println("Request ID:" + oe.getRequestId());
//            System.out.println("Host ID:" + oe.getHostId());
//        } catch (ClientException ce) {
//            System.out.println("Caught an ClientException, which means the client encountered "
//                    + "a serious internal problem while trying to communicate with OSS, "
//                    + "such as not being able to access the network.");
//            System.out.println("Error Message:" + ce.getMessage());
//        } finally {
//            if (ossClient != null) {
//                ossClient.shutdown();
//            }
//
//
//        }
//
//    }
//}
