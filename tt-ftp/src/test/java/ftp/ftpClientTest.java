package ftp;

import com.qianfeng.ftp.util.FtpUtils;
import com.qianfeng.ftp.util.Prop;
import com.qianfeng.ftp.util.PropKit;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ftpClientTest {



    //单独上传类
/*    @Test
    public void testStoreFile() throws IOException {
        //创建FTP用户
        FTPClient ftpClient = new FTPClient();
        //连接
        ftpClient.connect("10.31.157.72",21);
        //登陆
        ftpClient.login("ftpuser","jiang19940406");
        //读取本地文件
        FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\admin\\Pictures\\Camera Roll\\2.jpg"));
        //配置上传参数
        ftpClient.changeWorkingDirectory("/home/ftpuser/www/images/");
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        //上传文件
        ftpClient.storeFile("meinv.jpg",fileInputStream);
        //释放资源
        fileInputStream.close();
        ftpClient.logout();
    }*/

    //调用文件读取类
/*    @Test
    public  void testStoreFile2() throws FileNotFoundException {
        Prop prop = PropKit.use("ftp.properties");
        String host = prop.get("ftp.host");
        int port = prop.getInt("ftp.port");
        String username = prop.get("ftp.username");
        String password = prop.get("ftp.password");

        String filepathname = prop.get("ftp.filepathname");

        System.out.println(host+"+++++"+port+"++++"+username+"+++"+password);

        FileInputStream fileInputStream = new FileInputStream(new File(filepathname));

        boolean b = FtpUtils.uploadFile(host, port, username, password, "/home/ftpuser/www/images", "/2018/01/16",
                "meinv.jpg", fileInputStream);

        System.out.println("++++++++++++++++++++++++++"+b);

    }*/
}
