package w2;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private final String f18183a;

    /* renamed from: b  reason: collision with root package name */
    public final float f18184b;

    /* renamed from: c  reason: collision with root package name */
    public final float f18185c;

    public g(String str, float f10, float f11) {
        this.f18183a = str;
        this.f18185c = f11;
        this.f18184b = f10;
    }

    public boolean a(String str) {
        if (this.f18183a.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.f18183a.endsWith("\r")) {
            String str2 = this.f18183a;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
