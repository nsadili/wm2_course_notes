package az.edu.ada.wm2.testing.helper;

public class StringHelper {

    public static String reverse(String str) {
        if (str == null) throw new IllegalArgumentException("Provide non-null string");
        if (str.isBlank()) throw new IllegalArgumentException("Provide non-blank string");

        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
}
