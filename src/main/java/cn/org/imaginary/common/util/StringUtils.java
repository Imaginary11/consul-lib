package cn.org.imaginary.common.util;

/**
 * @author Imaginary
 * @see
 * @since 1.0
 */
public class StringUtils {
    public static boolean isEmpty(Object str) {
        return str == null || "".equals(str);
    }
}
