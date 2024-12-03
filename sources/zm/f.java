package zm;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f42248a;

    public static boolean a() {
        if (f42248a == null) {
            try {
                Class.forName("android.Manifest");
                f42248a = Boolean.TRUE;
            } catch (Exception unused) {
                f42248a = Boolean.FALSE;
            }
        }
        return f42248a.booleanValue();
    }
}
