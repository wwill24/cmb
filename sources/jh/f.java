package jh;

import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final Charset f23592a = Charset.defaultCharset();

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f23593b = Charset.forName("SJIS");

    /* renamed from: c  reason: collision with root package name */
    public static final Charset f23594c;

    /* renamed from: d  reason: collision with root package name */
    private static final Charset f23595d;

    /* renamed from: e  reason: collision with root package name */
    private static final boolean f23596e;

    static {
        Charset charset;
        boolean z10;
        try {
            charset = Charset.forName("GB2312");
        } catch (UnsupportedCharsetException unused) {
            charset = null;
        }
        f23594c = charset;
        Charset forName = Charset.forName("EUC_JP");
        f23595d = forName;
        Charset charset2 = f23593b;
        Charset charset3 = f23592a;
        if (charset2.equals(charset3) || forName.equals(charset3)) {
            z10 = true;
        } else {
            z10 = false;
        }
        f23596e = z10;
    }
}
