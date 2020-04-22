package day05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println(checkPas("-1aa++++cA"));
//        System.out.println(checkDate("1997-04-07"));
//        System.out.println(checkQQ("1078421794"));
//        System.out.println(checkPhone("15341111119"));
//        System.out.println(checkEmail("zh111555ao@foxmail.com"));
//        String urlContent = webSpider("https://www.uestc.edu.cn/").toString();
////        Pattern pattern = Pattern.compile("<a.+?</a>");// 取到所有超链接内容
////        Pattern pattern = Pattern.compile("href=\".+?\"");//直接取到链接
//        Pattern pattern = Pattern.compile("href=\"(.+?)\"");//使用捕获组可以连href都不出现
//        Matcher matcher = pattern.matcher(urlContent);
//        while (matcher.find()) {
//            System.out.println(matcher.group(1));
//        }
    }

    public static boolean checkPas(String pas) {
        //注意,这里(?=.*\d)意味这将"1aa++++cA-"里1前面那个空字符""捕获，因为这个空字符满足条件因此后面三个条件都满足，所以其实
        //一直都在捕获第一个空字符.后面.才开始捕获1aa..这些.
        Pattern pattern = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=-).{8,15}$");
        Matcher matcher = pattern.matcher(pas);
        return matcher.matches();
    }

    public static boolean checkDate(String date) {
        Pattern pattern = Pattern.compile("^(\\d{1,4})(-|\\/)(\\d{1,2})\\2(\\d{1,2})");
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }

    public static boolean checkQQ(String qq) {
        Pattern pattern = Pattern.compile("^[1-9][0-9]{4,14}$");
        Matcher matcher = pattern.matcher(qq);
        return matcher.matches();
    }

    public static boolean checkPhone(String phone) {
        Pattern pattern = Pattern.compile("^[1][3,5,7,8,9][0-9]{9}$");
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public static boolean checkEmail(String email) {
        Pattern pattern = Pattern.compile("^[\\w\\-]+@[a-z0-9A-Z]+(\\.[A-Za-z]{2,3}){1,2}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static StringBuilder webSpider(String str) throws Exception {
        URL url = new URL(str);
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        String temp = "";
        while ((temp = br.readLine()) != null) {
            stringBuilder.append(temp);
        }
        return stringBuilder;
    }
}
