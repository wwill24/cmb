package kotlin.text;

import java.nio.charset.Charset;
import kotlin.jvm.internal.j;
import org.bouncycastle.i18n.LocalizedMessage;
import org.jivesoftware.smack.util.StringUtils;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f32215a = new d();

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f32216b;

    /* renamed from: c  reason: collision with root package name */
    public static final Charset f32217c;

    /* renamed from: d  reason: collision with root package name */
    public static final Charset f32218d;

    /* renamed from: e  reason: collision with root package name */
    public static final Charset f32219e;

    /* renamed from: f  reason: collision with root package name */
    public static final Charset f32220f;

    /* renamed from: g  reason: collision with root package name */
    public static final Charset f32221g;

    /* renamed from: h  reason: collision with root package name */
    private static volatile Charset f32222h;

    /* renamed from: i  reason: collision with root package name */
    private static volatile Charset f32223i;

    static {
        Charset forName = Charset.forName("UTF-8");
        j.f(forName, "forName(\"UTF-8\")");
        f32216b = forName;
        Charset forName2 = Charset.forName("UTF-16");
        j.f(forName2, "forName(\"UTF-16\")");
        f32217c = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        j.f(forName3, "forName(\"UTF-16BE\")");
        f32218d = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        j.f(forName4, "forName(\"UTF-16LE\")");
        f32219e = forName4;
        Charset forName5 = Charset.forName(StringUtils.USASCII);
        j.f(forName5, "forName(\"US-ASCII\")");
        f32220f = forName5;
        Charset forName6 = Charset.forName(LocalizedMessage.DEFAULT_ENCODING);
        j.f(forName6, "forName(\"ISO-8859-1\")");
        f32221g = forName6;
    }

    private d() {
    }

    public final Charset a() {
        Charset charset = f32223i;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32BE");
        j.f(forName, "forName(\"UTF-32BE\")");
        f32223i = forName;
        return forName;
    }

    public final Charset b() {
        Charset charset = f32222h;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32LE");
        j.f(forName, "forName(\"UTF-32LE\")");
        f32222h = forName;
        return forName;
    }
}
