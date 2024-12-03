package th;

import java.util.Map;
import java.util.regex.Pattern;
import net.bytebuddy.jar.asm.Opcodes;

public class a {

    /* renamed from: e  reason: collision with root package name */
    private static final Integer[] f24626e = {100, 116, 135, Integer.valueOf(Opcodes.IFGE), Integer.valueOf(Opcodes.PUTFIELD), 210, 244, 283, 328, 380, 441, 512, 594, 689, 799, 927, 1075, 1247, 1446, 1678, 1946, 2257, 2619, 3038, 3524, 4087, 4741, 5500, 6380, 7401, 8192};

    /* renamed from: f  reason: collision with root package name */
    private static final Integer[] f24627f = {75, 50, 35, 23, 20};

    /* renamed from: g  reason: collision with root package name */
    private static final Integer[] f24628g = {1, 2, 3, 4, 5};

    /* renamed from: a  reason: collision with root package name */
    private String f24629a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f24630b;

    /* renamed from: c  reason: collision with root package name */
    private String f24631c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f24632d;

    public a(String str, boolean z10, String str2, boolean z11) {
        Pattern compile = Pattern.compile("^(?:[a-z\\d\\-_]{1,62}\\.){0,125}(?:[a-z\\d](?:\\-(?=\\-*[a-z\\d])|[a-z]|\\d){0,62}\\.)[a-z\\d]{1,63}$");
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("At lease one domain must be passed to URLBuilder");
        } else if (compile.matcher(str).matches()) {
            this.f24629a = str;
            this.f24630b = z10;
            this.f24631c = str2;
            this.f24632d = z11;
        } else {
            throw new IllegalArgumentException("Domain must be passed in as a fully-qualified domain name and should not include a protocol or any path element, i.e. \"example.imgix.net\".");
        }
    }

    public String a(String str, Map<String, String> map) {
        String str2;
        if (this.f24630b) {
            str2 = "https";
        } else {
            str2 = "http";
        }
        String str3 = str2;
        if (this.f24632d) {
            map.put("ixlib", "java-2.3.2");
        }
        return new c(this.f24629a, str, str3, this.f24631c, map).g();
    }

    public void b(boolean z10) {
        this.f24630b = z10;
    }
}
