package c7;

public class a {
    public static String a(String str) {
        return String.format("CMBHTTP (%s)", new Object[]{str});
    }

    public static String b(String str, String str2) {
        return String.format("%s %s", new Object[]{str, str2});
    }

    public static String c(String str, String str2, int i10) {
        return String.format("%s %s %s", new Object[]{str, Integer.valueOf(i10), str2});
    }
}
