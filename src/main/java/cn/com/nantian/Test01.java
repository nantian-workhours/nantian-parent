package cn.com.nantian;

import org.springframework.util.DigestUtils;

public class Test01 {

    public static void main(String[] args) {
        String pwd="111111";
        System.out.println(DigestUtils.md5DigestAsHex(pwd.getBytes()));
    }
}
