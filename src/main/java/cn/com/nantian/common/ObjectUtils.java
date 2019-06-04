package cn.com.nantian.common;

import java.io.*;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @Author：Mr.Wind
 * @date: 2019/3/22 10:32
 * @Version：1.0
 */
public class ObjectUtils {

    private static Format FORMAT = new DecimalFormat("#.##");

    public ObjectUtils() {
    }

    public static boolean isNull(Object o) {
        return null == o;
    }

    public static boolean isNull(List<?> list) {
        return null == list || list.size() == 0;
    }

    public static boolean isNull(Set<?> set) {
        return null == set || set.size() == 0;
    }

    public static boolean isNull(Map<?, ?> map) {
        return null == map || map.size() == 0;
    }

    public static boolean isNull(Long lg) {
        return null == lg || lg.longValue() == 0L;
    }

    public static boolean isNull(Integer it) {
        return null == it || it.intValue() == 0;
    }

    public static boolean isNull(File file) {
        return null == file || !file.exists();
    }

    public static boolean isNull(Object[] strs) {
        return null == strs || strs.length == 0;
    }

    public static Number getNumber(Number number) {
        return (Number)(isNull((Object)number)?Long.valueOf(0L):number);
    }

    public static String numberFormat(Number number, String... pattern) {
        return isNull((Object[])pattern)?FORMAT.format(number):FORMAT.format(pattern[0]);
    }

    public static Object clone(Object o) {
        if(null == o) {
            return null;
        } else {
            ByteArrayOutputStream bos = null;
            ObjectOutputStream oos = null;
            ObjectInputStream ois = null;

            try {
                bos = new ByteArrayOutputStream();
                oos = new ObjectOutputStream(bos);
                oos.writeObject(o);
                ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
                Object e = ois.readObject();
                return e;
            } catch (IOException var16) {
                var16.printStackTrace();
            } catch (ClassNotFoundException var17) {
                var17.printStackTrace();
            } finally {
                try {
                    if(null != bos) {
                        bos.close();
                    }

                    if(null != oos) {
                        oos.close();
                    }

                    if(null != ois) {
                        ois.close();
                    }
                } catch (IOException var15) {
                    var15.printStackTrace();
                }

            }

            return null;
        }
    }

    public static boolean isNotNull(Object o) {
        return !isNull(o);
    }

    public static boolean isNotNull(List<?> list) {
        return !isNull(list);
    }

    public static boolean isNotNull(Set<?> set) {
        return !isNull(set);
    }

    public static boolean isNotNull(Map<?, ?> map) {
        return !isNull(map);
    }

    public static boolean isNotNull(Long lg) {
        return !isNull(lg);
    }

    public static boolean isNotNull(Integer it) {
        return !isNull(it);
    }

    public static boolean isNotNull(File file) {
        return !isNull(file);
    }

    public static boolean isNotNull(Object[] strs) {
        return !isNull(strs);
    }

    /**
      * @description: 效验传入的参数是否是价格(Double)格式
      * @auther: Mr.Wind
      * @date: 2019/5/7 15:48
      * @Param:  [str]
      * @return: boolean
      **/
    public static boolean isPriceNumber(String str) {
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$"); // 判断小数点后2位的数字的正则表达式
        java.util.regex.Matcher match = pattern.matcher(str);
        if (match.matches() == false) {
            return false;
        } else {
            return true;
        }
    }


}
