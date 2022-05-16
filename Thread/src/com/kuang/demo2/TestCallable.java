package com.kuang.demo2;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

//实现Callable 接口
public class TestCallable implements Callable<Boolean> {

  private String url;
  private String name;

  public TestCallable(String url,String name){
    this.url = url;
    this.name = name;
  }

  @Override
  public Boolean call() {
    WebDownloader webDownloader = new WebDownloader();
    webDownloader.downloader(url ,name);
    System.out.println("下载了文件名:"+name);
    return true;
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    TestCallable t1 = new TestCallable("https://www.baidu.com/link?url=vncAahWAZ-7dQlRYul7a_lNEbjkFsjUKqmJ0IBhNWV5mpm778nULhn-FS25SjboPZ4DXWH_aYwsAlLfaFyhhNFU_o7LmkaNRIkzNCiCBX1h2CF827xZL2WunxNHC37W1R_dBNMJ3DVqJj0Uip2A_-HJzBnu9e3aTDJqKRwtLiM2ZSQIqphko4Gp8YjPKZXR71ZdWzXDuEZWur068eXDnlxrXDB15ujQsFtP6FMnamJrdQ0Hsy2H2I-VAMyDdlTyDYYdC8qAXSlyoKsL9Rt2PgmPvLXc1VotDW8KRxvQvt0oiY2MwwJrtbKZ_NeFsuUgzjp4JslYkuRA3OeSTv9X8aaST236z11uLyvDBxH_rfPfVGIgEb4SLqZq3hznlThPd0wyoBVC4UryhWOhXCiv2C_3964qQQAZLPf0dMgm1NU--medDMMvrxWJXLi1vpynyUJ7OxeFYju2qPr8m6Bg0sTXaZlKq31VAE2ha3OSlcJkdCunf3NL7y-XEk7JBHa78oxV_rcFE7eKhuGMWiwMgThNRWedEVhkW1z_9M-_iFcp8HQsgS8ZPkxrEi4lzsxwzECsBVST94N5rO69n6duDdV48HU3tybGK3sAivLmLpjwWfi4lFjTg7VQTsxZbMU6UpbQvt9kxbzgIdx_QqwUueVsWv0YLR3U9t_zv3qehknG&wd=&eqid=890978790023d9eb00000004627925b2", "1.jpg");
    TestCallable t2 = new TestCallable("https://www.baidu.com/link?url=2hPibF09SiEuICPrF1fnDJTyi0tlM_41QUtVow1fEuCEV0ktz4Dk8SMTMJ_8Ng86LDVPeeKmi70xx58h5NMOi54hmN-UmmK1VI6wprVVXpZXSH1aRLuPSNwOToOYONK252norVOO2AU6j6lI_ijGIcBYb-zpAy9a9xD6o3uUeur9DkL-7thlBTzj7lSxdGUbLB7Ji3XqxDAB4eFr7v0h7q8Cs6_hBEbCOEQA0JWisipcNUR0p6xhBd74WINTYIrNcszkbjlJmuc3Hs_kHt6q3P-HW1AT0AfaW2HkLaUDjQY8Hp1wV0rH1ED2pYkWemIn4cequ5rXgrQlpw_qiTZA6IfsmpSIkAdP2x0wmXcQm4NCAFtX2Ar_aM0Hf7MVbY80pgN6jH-YMDVMzivcMoIM6s7yDc55xmPWuQiZy9thu6ircIP7ZEsVeP1_YY3bp-Tspx9cR7LfKGW7c0POFo1D750N3yp68WJDp1IETwYeWDDxFkHrbGZCp2c4ghl7O-I7vEXW7dkRiI7jE4B8Rzna_gRcecrKhfHvbLtbCQBzJnCOPTEUUwl9d-UGy2CmxKy4hnD4ojYQqJg8ThR2078vLFs9Gr5EsLAM_66ONWdAfnqfwFpR_wHJi0iYBePpMj1mcP6NgPiU2R1uGB_FvT2XbIu7NsXB07Dee1kjGBTZJee&wd=&eqid=890978790023d9eb00000004627925b2", "2.jpg");
    TestCallable t3 = new TestCallable("https://www.baidu.com/link?url=SQ8G5nFXtyLYwvYi34osJn9FpeiCl8jA5YXbved7mKoNSqlugSAHjKPjaKNbkSZ8wHFfPYLIE49y6SqsYi5K-2fv6UDdB3l6nU1qmGZOQ3IJD2Zz_zcVQz985F6WQPPMWCEEGxYfyUzA7aH9iNuUOwD_dyOu7aGr84kY7Lb1IHcRNItRb2ySxQGlcwRVNY2xREjvftOC0gBuLaSOVYbh4gc9Jy2ZEf8oTbcRKJaa_Oclzz0LynJjAHQueqnU_deY4nNh9C67mpJhcrl_a_C7bjclwf9lFIAm8J4xDd0CCHfqdMrgAsSjZ52PvoLdZitT7j-X-k-zEjD9Zg905X2-GVQEClXkkr6n8uYuGGaq6-2-CX8rBJspZt0BftJoT20n7jj8qD3VnhsGNzGY4d-w5wCcFcorC_HEz60WHjvLjA22VN3KAt6LWnh7jvalbLTPsrtOu6j5gdLehzFvy1wUoHhb-ABelQHhS_WqEkoGSTR5_X7mBDdumLmUGaJiyu9PsMTtLCsRW5OJSEW-MO98fSTv8YVOa5WhaBFKsj_jF7u99EO66jA0lRj85mGxteP078eUHVuotKzoaB4mkeQwD5LC_AvfQUs7EtZO7N5n5NPC0BSH0lgeF-75UcRjMBV8aFbTGoEDH4MWzuKMAAsFEq&wd=&eqid=890978790023d9eb00000004627925b2", "3.jpg");

    //创建执行服务
    ExecutorService service = Executors.newFixedThreadPool(3);  //new了一个池子，放了三个线程

    //提交执行
    Future<Boolean> result1 = service.submit(t1);
    Future<Boolean> result2 = service.submit(t2);
    Future<Boolean> result3 = service.submit(t3);

    //获取结果
    boolean r1 = result1.get();
    boolean r2 = result2.get();
    boolean r3 = result3.get();

    //关闭服务
    service.shutdown();

  }
}


//下载器
class WebDownloader{

  //下载方法
  public void downloader(String url,String name){
    try {
      FileUtils.copyURLToFile(new URL(url), new File(name));
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("IO异常，downloader方法出现问题");
    }
  }
}

