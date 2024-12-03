package lm;

public class b {
    public static <T> T a(T t10, String str) throws IllegalArgumentException {
        if (t10 != null) {
            return t10;
        }
        throw new IllegalArgumentException("Argument '" + str + "' must not be null");
    }
}
