package cn.woblog;

import cn.woblog.util.CommandUtil;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        File file = new File("signconfig/sign.conf");

        if (file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String config = bufferedReader.readLine();

                if (config != null) {
                    if (config.contains("signapk.jar")) {
                        //使用signapk.jar,如:java -jar signapk.jar platform.x509.pem platform.pk8 MyDemo.apk MyDemo_signed.apk
                    } else {
                        //使用jarsigner,如:jarsigner -verbose -keystore abc.keystore [-storepass feelyou.info] -signedjar 123x.apk 123.apk hi
                        config = String.format(config,"sign.apk","a.apk");

                        String result = CommandUtil.exec(config);
                        System.out.print(result);
                    }
                }





            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
