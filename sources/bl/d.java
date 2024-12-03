package bl;

import com.facebook.internal.security.CertificateUtil;
import com.facebook.stetho.server.http.HttpHeaders;
import com.google.android.gms.common.api.a;
import hl.a;
import j$.util.DesugarTimeZone;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.b;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;
import kotlin.ranges.IntRange;
import kotlin.text.Regex;
import net.bytebuddy.jar.asm.Opcodes;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.e;
import okhttp3.q;
import okhttp3.s;
import okhttp3.t;
import okhttp3.v;
import okhttp3.x;
import okhttp3.z;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
import okio.Source;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000\u001a\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b\u001a;\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\f*\b\u0012\u0004\u0012\u00020\u00060\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00060\u000e¢\u0006\u0004\b\u0010\u0010\u0011\u001a7\u0010\u0012\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\u00060\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00060\u000e¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0014\u0010\u0016\u001a\u00020\u0006*\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\b\u001a-\u0010\u0019\u001a\u00020\u0018*\b\u0012\u0004\u0012\u00020\u00060\f2\u0006\u0010\u0017\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e¢\u0006\u0004\b\u0019\u0010\u001a\u001a%\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\f*\b\u0012\u0004\u0012\u00020\u00060\f2\u0006\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001e\u0010\u001f\u001a\u00020\u0018*\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u0018\u001a\u001e\u0010 \u001a\u00020\u0018*\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u0018\u001a\u001e\u0010!\u001a\u00020\u0006*\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u0018\u001a&\u0010#\u001a\u00020\u0018*\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u0018\u001a&\u0010&\u001a\u00020\u0018*\u00020\u00062\u0006\u0010%\u001a\u00020$2\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u0018\u001a\n\u0010'\u001a\u00020\u0018*\u00020\u0006\u001a\n\u0010(\u001a\u00020\b*\u00020\u0006\u001a\u000e\u0010)\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006\u001a)\u0010-\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020+0\f\"\u00020+¢\u0006\u0004\b-\u0010.\u001a\u0012\u00102\u001a\u000200*\u00020/2\u0006\u00101\u001a\u000200\u001a \u00106\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u00002\b\u00105\u001a\u0004\u0018\u000104\u001a\n\u00107\u001a\u00020\u0018*\u00020$\u001a\u0010\u0010;\u001a\u00020:*\b\u0012\u0004\u0012\u00020908\u001a\u0010\u0010<\u001a\b\u0012\u0004\u0012\u00020908*\u00020:\u001a\u0012\u0010=\u001a\u00020\b*\u00020\u00142\u0006\u0010\r\u001a\u00020\u0014\u001a\n\u0010@\u001a\u00020?*\u00020>\u001a\u0015\u0010C\u001a\u00020\u0018*\u00020A2\u0006\u0010B\u001a\u00020\u0018H\u0004\u001a\u0015\u0010E\u001a\u00020\u0018*\u00020D2\u0006\u0010B\u001a\u00020\u0018H\u0004\u001a\u0015\u0010F\u001a\u00020\u0000*\u00020\u00182\u0006\u0010B\u001a\u00020\u0000H\u0004\u001a\u0012\u0010I\u001a\u00020\u0004*\u00020G2\u0006\u0010H\u001a\u00020\u0018\u001a\n\u0010J\u001a\u00020\u0018*\u00020/\u001a\u001a\u0010M\u001a\u00020\b*\u00020K2\u0006\u00103\u001a\u00020\u00182\u0006\u0010L\u001a\u000204\u001a\u001a\u0010O\u001a\u00020\b*\u00020K2\u0006\u0010N\u001a\u00020\u00182\u0006\u0010L\u001a\u000204\u001a\u0012\u0010R\u001a\u00020\b*\u00020P2\u0006\u0010Q\u001a\u00020/\u001a\u0012\u0010U\u001a\u00020\u0018*\u00020S2\u0006\u0010T\u001a\u00020A\u001a\u0014\u0010V\u001a\u00020\u0018*\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u0018\u001a\n\u0010X\u001a\u00020\u0000*\u00020W\u001a\u0012\u0010Z\u001a\u00020\u0000*\u00020\u00062\u0006\u0010Y\u001a\u00020\u0000\u001a\u0014\u0010[\u001a\u00020\u0018*\u0004\u0018\u00010\u00062\u0006\u0010Y\u001a\u00020\u0018\u001a\u001c\u0010]\u001a\b\u0012\u0004\u0012\u00028\u000008\"\u0004\b\u0000\u0010\\*\b\u0012\u0004\u0012\u00028\u000008\u001a/\u0010_\u001a\b\u0012\u0004\u0012\u00028\u000008\"\u0004\b\u0000\u0010\\2\u0012\u0010^\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\f\"\u00028\u0000H\u0007¢\u0006\u0004\b_\u0010`\u001a.\u0010\\\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010a\"\u0004\b\u0000\u0010U\"\u0004\b\u0001\u0010[*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010a\u001a\n\u0010c\u001a\u00020\u0004*\u00020b\u001a\n\u0010d\u001a\u00020\u0004*\u00020P\u001a'\u0010g\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000e2\u0006\u0010f\u001a\u00028\u0000H\u0000¢\u0006\u0004\bg\u0010h\u001a \u0010m\u001a\u00020l*\u00060ij\u0002`j2\u0010\u0010k\u001a\f\u0012\b\u0012\u00060ij\u0002`j08\"\u0014\u0010q\u001a\u00020n8\u0006X\u0004¢\u0006\u0006\n\u0004\bo\u0010p\"\u0014\u0010s\u001a\u00020:8\u0006X\u0004¢\u0006\u0006\n\u0004\bT\u0010r\"\u0014\u0010v\u001a\u00020t8\u0006X\u0004¢\u0006\u0006\n\u0004\bg\u0010u\"\u0014\u0010y\u001a\u00020w8\u0006X\u0004¢\u0006\u0006\n\u0004\bC\u0010x\"\u0014\u0010|\u001a\u00020z8\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010{\"\u0014\u0010\u001a\u00020}8\u0006X\u0004¢\u0006\u0006\n\u0004\bF\u0010~\"\u0017\u0010\u0001\u001a\u00030\u00018\u0002X\u0004¢\u0006\u0007\n\u0005\b@\u0010\u0001\"\u0016\u0010\u0001\u001a\u00020\b8\u0000X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010I\"\u0016\u0010\u0001\u001a\u00020\u00068\u0000X\u0004¢\u0006\u0007\n\u0005\b(\u0010\u0001¨\u0006\u0001"}, d2 = {"", "arrayLength", "offset", "count", "", "l", "", "name", "", "daemon", "Ljava/util/concurrent/ThreadFactory;", "M", "", "other", "Ljava/util/Comparator;", "comparator", "E", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)[Ljava/lang/String;", "u", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)Z", "Lokhttp3/t;", "includeDefaultPort", "Q", "value", "", "x", "([Ljava/lang/String;Ljava/lang/String;Ljava/util/Comparator;)I", "o", "([Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "startIndex", "endIndex", "z", "B", "W", "delimiters", "q", "", "delimiter", "p", "y", "i", "G", "format", "", "args", "t", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "Lokio/BufferedSource;", "Ljava/nio/charset/Charset;", "default", "I", "duration", "Ljava/util/concurrent/TimeUnit;", "unit", "k", "H", "", "Lhl/a;", "Lokhttp3/s;", "P", "O", "j", "Lokhttp3/q;", "Lokhttp3/q$c;", "g", "", "mask", "d", "", "e", "f", "Lokio/BufferedSink;", "medium", "Z", "J", "Lokio/Source;", "timeUnit", "L", "timeout", "s", "Ljava/net/Socket;", "source", "F", "Lokio/Buffer;", "b", "K", "D", "Lokhttp3/a0;", "v", "defaultValue", "U", "V", "T", "S", "elements", "w", "([Ljava/lang/Object;)Ljava/util/List;", "", "Ljava/io/Closeable;", "m", "n", "", "element", "c", "(Ljava/util/List;Ljava/lang/Object;)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "suppressed", "", "Y", "", "a", "[B", "EMPTY_BYTE_ARRAY", "Lokhttp3/s;", "EMPTY_HEADERS", "Lokhttp3/b0;", "Lokhttp3/b0;", "EMPTY_RESPONSE", "Lokhttp3/z;", "Lokhttp3/z;", "EMPTY_REQUEST", "Lokio/Options;", "Lokio/Options;", "UNICODE_BOMS", "Ljava/util/TimeZone;", "Ljava/util/TimeZone;", "UTC", "Lkotlin/text/Regex;", "Lkotlin/text/Regex;", "VERIFY_AS_IP_ADDRESS", "h", "assertionsEnabled", "Ljava/lang/String;", "okHttpName", "okhttp"}, k = 2, mv = {1, 6, 0})
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f24928a;

    /* renamed from: b  reason: collision with root package name */
    public static final s f24929b = s.f33166b.g(new String[0]);

    /* renamed from: c  reason: collision with root package name */
    public static final b0 f24930c;

    /* renamed from: d  reason: collision with root package name */
    public static final z f24931d;

    /* renamed from: e  reason: collision with root package name */
    private static final Options f24932e;

    /* renamed from: f  reason: collision with root package name */
    public static final TimeZone f24933f;

    /* renamed from: g  reason: collision with root package name */
    private static final Regex f24934g = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f24935h = false;

    /* renamed from: i  reason: collision with root package name */
    public static final String f24936i;

    static {
        byte[] bArr = new byte[0];
        f24928a = bArr;
        f24930c = b0.b.i(b0.Companion, bArr, (v) null, 1, (Object) null);
        f24931d = z.a.l(z.f33274a, bArr, (v) null, 0, 0, 7, (Object) null);
        Options.Companion companion = Options.f33374d;
        ByteString.Companion companion2 = ByteString.f33308c;
        f24932e = companion.d(companion2.a("efbbbf"), companion2.a("feff"), companion2.a("fffe"), companion2.a("0000ffff"), companion2.a("ffff0000"));
        TimeZone timeZone = DesugarTimeZone.getTimeZone("GMT");
        j.d(timeZone);
        f24933f = timeZone;
        Class<x> cls = x.class;
        String name = x.class.getName();
        j.f(name, "OkHttpClient::class.java.name");
        f24936i = StringsKt__StringsKt.v0(StringsKt__StringsKt.u0(name, "okhttp3."), "Client");
    }

    public static /* synthetic */ int A(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return z(str, i10, i11);
    }

    public static final int B(String str, int i10, int i11) {
        j.g(str, "<this>");
        int i12 = i11 - 1;
        if (i10 <= i12) {
            while (true) {
                int i13 = i12 - 1;
                char charAt = str.charAt(i12);
                boolean z10 = false;
                if ((((charAt == 9 || charAt == 10) || charAt == 12) || charAt == 13) || charAt == ' ') {
                    z10 = true;
                }
                if (!z10) {
                    return i12 + 1;
                }
                if (i12 == i10) {
                    break;
                }
                i12 = i13;
            }
        }
        return i10;
    }

    public static /* synthetic */ int C(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return B(str, i10, i11);
    }

    public static final int D(String str, int i10) {
        j.g(str, "<this>");
        int length = str.length();
        while (i10 < length) {
            int i11 = i10 + 1;
            char charAt = str.charAt(i10);
            if (charAt != ' ' && charAt != 9) {
                return i10;
            }
            i10 = i11;
        }
        return str.length();
    }

    public static final String[] E(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        j.g(strArr, "<this>");
        j.g(strArr2, "other");
        j.g(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        int i10 = 0;
        while (i10 < length) {
            String str = strArr[i10];
            i10++;
            int length2 = strArr2.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length2) {
                    break;
                }
                String str2 = strArr2[i11];
                i11++;
                if (comparator.compare(str, str2) == 0) {
                    arrayList.add(str);
                    break;
                }
            }
        }
        Object[] array2 = arrayList.toArray(new String[0]);
        if (array2 != null) {
            return (String[]) array2;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static final boolean F(Socket socket, BufferedSource bufferedSource) {
        int soTimeout;
        j.g(socket, "<this>");
        j.g(bufferedSource, "source");
        try {
            soTimeout = socket.getSoTimeout();
            socket.setSoTimeout(1);
            boolean z10 = !bufferedSource.Y0();
            socket.setSoTimeout(soTimeout);
            return z10;
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        } catch (Throwable th2) {
            socket.setSoTimeout(soTimeout);
            throw th2;
        }
    }

    public static final boolean G(String str) {
        j.g(str, "name");
        if (r.t(str, "Authorization", true) || r.t(str, "Cookie", true) || r.t(str, "Proxy-Authorization", true) || r.t(str, "Set-Cookie", true)) {
            return true;
        }
        return false;
    }

    public static final int H(char c10) {
        boolean z10 = true;
        if ('0' <= c10 && c10 < ':') {
            return c10 - '0';
        }
        char c11 = 'a';
        if (!('a' <= c10 && c10 < 'g')) {
            c11 = 'A';
            if ('A' > c10 || c10 >= 'G') {
                z10 = false;
            }
            if (!z10) {
                return -1;
            }
        }
        return (c10 - c11) + 10;
    }

    public static final Charset I(BufferedSource bufferedSource, Charset charset) throws IOException {
        j.g(bufferedSource, "<this>");
        j.g(charset, "default");
        int a22 = bufferedSource.a2(f24932e);
        if (a22 == -1) {
            return charset;
        }
        if (a22 == 0) {
            Charset charset2 = StandardCharsets.UTF_8;
            j.f(charset2, "UTF_8");
            return charset2;
        } else if (a22 == 1) {
            Charset charset3 = StandardCharsets.UTF_16BE;
            j.f(charset3, "UTF_16BE");
            return charset3;
        } else if (a22 == 2) {
            Charset charset4 = StandardCharsets.UTF_16LE;
            j.f(charset4, "UTF_16LE");
            return charset4;
        } else if (a22 == 3) {
            return kotlin.text.d.f32215a.a();
        } else {
            if (a22 == 4) {
                return kotlin.text.d.f32215a.b();
            }
            throw new AssertionError();
        }
    }

    public static final int J(BufferedSource bufferedSource) throws IOException {
        j.g(bufferedSource, "<this>");
        return d(bufferedSource.readByte(), 255) | (d(bufferedSource.readByte(), 255) << 16) | (d(bufferedSource.readByte(), 255) << 8);
    }

    public static final int K(Buffer buffer, byte b10) {
        j.g(buffer, "<this>");
        int i10 = 0;
        while (!buffer.Y0() && buffer.l(0) == b10) {
            i10++;
            buffer.readByte();
        }
        return i10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0051, code lost:
        if (r5 == Long.MAX_VALUE) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0053, code lost:
        r11.p().a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005b, code lost:
        r11.p().d(r0 + r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007d, code lost:
        if (r5 != Long.MAX_VALUE) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0080, code lost:
        return r12;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean L(okio.Source r11, int r12, java.util.concurrent.TimeUnit r13) throws java.io.IOException {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.j.g(r11, r0)
            java.lang.String r0 = "timeUnit"
            kotlin.jvm.internal.j.g(r13, r0)
            long r0 = java.lang.System.nanoTime()
            okio.Timeout r2 = r11.p()
            boolean r2 = r2.e()
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r2 == 0) goto L_0x0027
            okio.Timeout r2 = r11.p()
            long r5 = r2.c()
            long r5 = r5 - r0
            goto L_0x0028
        L_0x0027:
            r5 = r3
        L_0x0028:
            okio.Timeout r2 = r11.p()
            long r7 = (long) r12
            long r12 = r13.toNanos(r7)
            long r12 = java.lang.Math.min(r5, r12)
            long r12 = r12 + r0
            r2.d(r12)
            okio.Buffer r12 = new okio.Buffer     // Catch:{ InterruptedIOException -> 0x007a, all -> 0x0064 }
            r12.<init>()     // Catch:{ InterruptedIOException -> 0x007a, all -> 0x0064 }
        L_0x003e:
            r7 = 8192(0x2000, double:4.0474E-320)
            long r7 = r11.N1(r12, r7)     // Catch:{ InterruptedIOException -> 0x007a, all -> 0x0064 }
            r9 = -1
            int r13 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r13 == 0) goto L_0x004e
            r12.a()     // Catch:{ InterruptedIOException -> 0x007a, all -> 0x0064 }
            goto L_0x003e
        L_0x004e:
            r12 = 1
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 != 0) goto L_0x005b
        L_0x0053:
            okio.Timeout r11 = r11.p()
            r11.a()
            goto L_0x0080
        L_0x005b:
            okio.Timeout r11 = r11.p()
            long r0 = r0 + r5
            r11.d(r0)
            goto L_0x0080
        L_0x0064:
            r12 = move-exception
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 != 0) goto L_0x0071
            okio.Timeout r11 = r11.p()
            r11.a()
            goto L_0x0079
        L_0x0071:
            okio.Timeout r11 = r11.p()
            long r0 = r0 + r5
            r11.d(r0)
        L_0x0079:
            throw r12
        L_0x007a:
            r12 = 0
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 != 0) goto L_0x005b
            goto L_0x0053
        L_0x0080:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: bl.d.L(okio.Source, int, java.util.concurrent.TimeUnit):boolean");
    }

    public static final ThreadFactory M(String str, boolean z10) {
        j.g(str, "name");
        return new b(str, z10);
    }

    /* access modifiers changed from: private */
    public static final Thread N(String str, boolean z10, Runnable runnable) {
        j.g(str, "$name");
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(z10);
        return thread;
    }

    public static final List<a> O(s sVar) {
        j.g(sVar, "<this>");
        IntRange o10 = j.o(0, sVar.size());
        ArrayList arrayList = new ArrayList(r.t(o10, 10));
        Iterator it = o10.iterator();
        while (it.hasNext()) {
            int nextInt = ((kotlin.collections.b0) it).nextInt();
            arrayList.add(new a(sVar.f(nextInt), sVar.n(nextInt)));
        }
        return arrayList;
    }

    public static final s P(List<a> list) {
        j.g(list, "<this>");
        s.a aVar = new s.a();
        for (a next : list) {
            aVar.d(next.a().Q(), next.b().Q());
        }
        return aVar.f();
    }

    public static final String Q(t tVar, boolean z10) {
        String str;
        j.g(tVar, "<this>");
        if (StringsKt__StringsKt.O(tVar.i(), CertificateUtil.DELIMITER, false, 2, (Object) null)) {
            str = '[' + tVar.i() + PropertyUtils.INDEXED_DELIM2;
        } else {
            str = tVar.i();
        }
        if (!z10 && tVar.o() == t.f33169k.c(tVar.s())) {
            return str;
        }
        return str + ':' + tVar.o();
    }

    public static /* synthetic */ String R(t tVar, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return Q(tVar, z10);
    }

    public static final <T> List<T> S(List<? extends T> list) {
        j.g(list, "<this>");
        List<T> unmodifiableList = Collections.unmodifiableList(CollectionsKt___CollectionsKt.z0(list));
        j.f(unmodifiableList, "unmodifiableList(toMutableList())");
        return unmodifiableList;
    }

    public static final <K, V> Map<K, V> T(Map<K, ? extends V> map) {
        j.g(map, "<this>");
        if (map.isEmpty()) {
            return h0.i();
        }
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
        j.f(unmodifiableMap, "{\n    Collections.unmodi…(LinkedHashMap(this))\n  }");
        return unmodifiableMap;
    }

    public static final long U(String str, long j10) {
        j.g(str, "<this>");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j10;
        }
    }

    public static final int V(String str, int i10) {
        Long l10;
        if (str == null) {
            l10 = null;
        } else {
            try {
                l10 = Long.valueOf(Long.parseLong(str));
            } catch (NumberFormatException unused) {
                return i10;
            }
        }
        if (l10 == null) {
            return i10;
        }
        long longValue = l10.longValue();
        if (longValue > 2147483647L) {
            return a.e.API_PRIORITY_OTHER;
        }
        if (longValue < 0) {
            return 0;
        }
        return (int) longValue;
    }

    public static final String W(String str, int i10, int i11) {
        j.g(str, "<this>");
        int z10 = z(str, i10, i11);
        String substring = str.substring(z10, B(str, z10, i11));
        j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String X(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return W(str, i10, i11);
    }

    public static final Throwable Y(Exception exc, List<? extends Exception> list) {
        j.g(exc, "<this>");
        j.g(list, "suppressed");
        if (list.size() > 1) {
            System.out.println(list);
        }
        for (Exception a10 : list) {
            b.a(exc, a10);
        }
        return exc;
    }

    public static final void Z(BufferedSink bufferedSink, int i10) throws IOException {
        j.g(bufferedSink, "<this>");
        bufferedSink.writeByte((i10 >>> 16) & 255);
        bufferedSink.writeByte((i10 >>> 8) & 255);
        bufferedSink.writeByte(i10 & 255);
    }

    public static final <E> void c(List<E> list, E e10) {
        j.g(list, "<this>");
        if (!list.contains(e10)) {
            list.add(e10);
        }
    }

    public static final int d(byte b10, int i10) {
        return b10 & i10;
    }

    public static final int e(short s10, int i10) {
        return s10 & i10;
    }

    public static final long f(int i10, long j10) {
        return ((long) i10) & j10;
    }

    public static final q.c g(q qVar) {
        j.g(qVar, "<this>");
        return new c(qVar);
    }

    /* access modifiers changed from: private */
    public static final q h(q qVar, e eVar) {
        j.g(qVar, "$this_asFactory");
        j.g(eVar, "it");
        return qVar;
    }

    public static final boolean i(String str) {
        j.g(str, "<this>");
        return f24934g.e(str);
    }

    public static final boolean j(t tVar, t tVar2) {
        j.g(tVar, "<this>");
        j.g(tVar2, "other");
        if (!j.b(tVar.i(), tVar2.i()) || tVar.o() != tVar2.o() || !j.b(tVar.s(), tVar2.s())) {
            return false;
        }
        return true;
    }

    public static final int k(String str, long j10, TimeUnit timeUnit) {
        boolean z10;
        boolean z11;
        boolean z12;
        j.g(str, "name");
        int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
        boolean z13 = true;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (timeUnit != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                long millis = timeUnit.toMillis(j10);
                if (millis <= 2147483647L) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    if (millis == 0 && i10 > 0) {
                        z13 = false;
                    }
                    if (z13) {
                        return (int) millis;
                    }
                    throw new IllegalArgumentException(j.p(str, " too small.").toString());
                }
                throw new IllegalArgumentException(j.p(str, " too large.").toString());
            }
            throw new IllegalStateException("unit == null".toString());
        }
        throw new IllegalStateException(j.p(str, " < 0").toString());
    }

    public static final void l(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void m(Closeable closeable) {
        j.g(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception unused) {
        }
    }

    public static final void n(Socket socket) {
        j.g(socket, "<this>");
        try {
            socket.close();
        } catch (AssertionError e10) {
            throw e10;
        } catch (RuntimeException e11) {
            if (!j.b(e11.getMessage(), "bio == null")) {
                throw e11;
            }
        } catch (Exception unused) {
        }
    }

    public static final String[] o(String[] strArr, String str) {
        j.g(strArr, "<this>");
        j.g(str, "value");
        Object[] copyOf = Arrays.copyOf(strArr, strArr.length + 1);
        j.f(copyOf, "copyOf(this, newSize)");
        String[] strArr2 = (String[]) copyOf;
        strArr2[l.C(strArr2)] = str;
        return strArr2;
    }

    public static final int p(String str, char c10, int i10, int i11) {
        j.g(str, "<this>");
        while (i10 < i11) {
            int i12 = i10 + 1;
            if (str.charAt(i10) == c10) {
                return i10;
            }
            i10 = i12;
        }
        return i11;
    }

    public static final int q(String str, String str2, int i10, int i11) {
        j.g(str, "<this>");
        j.g(str2, "delimiters");
        while (i10 < i11) {
            int i12 = i10 + 1;
            if (StringsKt__StringsKt.N(str2, str.charAt(i10), false, 2, (Object) null)) {
                return i10;
            }
            i10 = i12;
        }
        return i11;
    }

    public static /* synthetic */ int r(String str, char c10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = str.length();
        }
        return p(str, c10, i10, i11);
    }

    public static final boolean s(Source source, int i10, TimeUnit timeUnit) {
        j.g(source, "<this>");
        j.g(timeUnit, "timeUnit");
        try {
            return L(source, i10, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final String t(String str, Object... objArr) {
        j.g(str, "format");
        j.g(objArr, "args");
        o oVar = o.f32141a;
        Locale locale = Locale.US;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        String format2 = String.format(locale, str, Arrays.copyOf(copyOf, copyOf.length));
        j.f(format2, "format(locale, format, *args)");
        return format2;
    }

    public static final boolean u(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        boolean z10;
        boolean z11;
        j.g(strArr, "<this>");
        j.g(comparator, "comparator");
        if (strArr.length == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10 && strArr2 != null) {
            if (strArr2.length == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                int length = strArr.length;
                int i10 = 0;
                while (i10 < length) {
                    String str = strArr[i10];
                    i10++;
                    Iterator a10 = b.a(strArr2);
                    while (true) {
                        if (a10.hasNext()) {
                            if (comparator.compare(str, (String) a10.next()) == 0) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final long v(a0 a0Var) {
        j.g(a0Var, "<this>");
        String b10 = a0Var.n().b(HttpHeaders.CONTENT_LENGTH);
        if (b10 == null) {
            return -1;
        }
        return U(b10, -1);
    }

    @SafeVarargs
    public static final <T> List<T> w(T... tArr) {
        j.g(tArr, "elements");
        Object[] objArr = (Object[]) tArr.clone();
        List<T> unmodifiableList = Collections.unmodifiableList(q.m(Arrays.copyOf(objArr, objArr.length)));
        j.f(unmodifiableList, "unmodifiableList(listOf(*elements.clone()))");
        return unmodifiableList;
    }

    public static final int x(String[] strArr, String str, Comparator<String> comparator) {
        boolean z10;
        j.g(strArr, "<this>");
        j.g(str, "value");
        j.g(comparator, "comparator");
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (comparator.compare(strArr[i10], str) == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                return i10;
            }
        }
        return -1;
    }

    public static final int y(String str) {
        j.g(str, "<this>");
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            char charAt = str.charAt(i10);
            if (j.i(charAt, 31) <= 0 || j.i(charAt, Opcodes.LAND) >= 0) {
                return i10;
            }
            i10 = i11;
        }
        return -1;
    }

    public static final int z(String str, int i10, int i11) {
        j.g(str, "<this>");
        while (i10 < i11) {
            int i12 = i10 + 1;
            char charAt = str.charAt(i10);
            boolean z10 = false;
            if ((((charAt == 9 || charAt == 10) || charAt == 12) || charAt == 13) || charAt == ' ') {
                z10 = true;
            }
            if (!z10) {
                return i10;
            }
            i10 = i12;
        }
        return i11;
    }
}
