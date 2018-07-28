package com.yaozhou.permission.util;

import com.google.common.hash.Hashing;
import org.springframework.util.Assert;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Yao.Zhou
 * @since 2018/7/22 17:31
 */
public class PassWordUtil {

    private static final char[] words = {
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        'A', 'B', 'C', 'D', 'E', 'F','G', 'H', 'I', 'J', 'K', 'M', 'N', 'P', 'Q', 'R','S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    private static final char[] nums = {
        '2', '3' , '4', '5', '6', '7', '8', '9'
    };

    /**
     * 密码串中数字最多出现4次
     */
    private static final int NUM_LEN = 4;

    /**
     * 密码最大长度和最小长度
     */
    private static final int PWD_MIN_LEN = 9;
    private static final int PWD_MAX_LEN = 12;

    static {
        Assert.isTrue(PWD_MIN_LEN - NUM_LEN > NUM_LEN, "密码生成规则中数字长度必须小于总长度的一半");
    }

    /**
     * 根据盐值加密密码
     * @return
     */
    public static String encodePassword(String password, String salt) {
        return EncryptUtil.md5(50, password, salt).toLowerCase();
    }

    /**
     * 随机生成一个盐值
     * @return
     */
    public static String randomSalt() {

       return Hashing.md5().newHasher().putLong(System.currentTimeMillis()).hash().toString().substring(0, 10);
    }

    /**
     * 生成一个随机密码
     * @return
     */
    public static String randomPassword() {
        Random random = new Random(new Date().getTime());

        int len = random.nextInt(PWD_MAX_LEN - PWD_MIN_LEN + 1) + PWD_MIN_LEN;
        int numLen = random.nextInt(NUM_LEN + 1);
        int charLen = len - numLen;

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (numLen > 0) {
                set.add(
                    nums[random.nextInt(nums.length)]
                );
                numLen --;

                continue;
            }

            if (charLen > 0) {
                set.add(
                    words[random.nextInt(words.length)]
                );
                charLen --;

                continue;
            }
        }

        return set.stream().map(e -> e.toString()).collect(Collectors.joining(""));
    }

    public static void main(String[] args) {
        /*System.out.println(randomSalt());
        System.out.println(randomPassword());*/
        System.out.println(encodePassword("qwer00123456", "a17ce92b30"));
    }

}
