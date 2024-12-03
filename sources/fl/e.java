package fl;

import bl.d;
import com.google.firebase.perf.FirebasePerformance;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import okhttp3.a0;
import okhttp3.g;
import okhttp3.l;
import okhttp3.m;
import okhttp3.s;
import okhttp3.t;
import okio.Buffer;
import okio.ByteString;
import org.jivesoftware.smackx.shim.packet.HeadersExtension;

@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u001a\u0010\n\u001a\u00020\t*\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0002\u001a\f\u0010\f\u001a\u00020\u000b*\u00020\u0006H\u0002\u001a\u0014\u0010\u000f\u001a\u00020\u000b*\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002\u001a\u000e\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\u0006H\u0002\u001a\u000e\u0010\u0011\u001a\u0004\u0018\u00010\u0001*\u00020\u0006H\u0002\u001a\u001a\u0010\u0016\u001a\u00020\t*\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0000\u001a\n\u0010\u0018\u001a\u00020\u000b*\u00020\u0017\"\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001a\"\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u001a¨\u0006\u001d"}, d2 = {"Lokhttp3/s;", "", "headerName", "", "Lokhttp3/g;", "a", "Lokio/Buffer;", "", "result", "", "c", "", "g", "", "prefix", "h", "d", "e", "Lokhttp3/m;", "Lokhttp3/t;", "url", "headers", "f", "Lokhttp3/a0;", "b", "Lokio/ByteString;", "Lokio/ByteString;", "QUOTED_STRING_DELIMITERS", "TOKEN_DELIMITERS", "okhttp"}, k = 2, mv = {1, 6, 0})
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final ByteString f29659a;

    /* renamed from: b  reason: collision with root package name */
    private static final ByteString f29660b;

    static {
        ByteString.Companion companion = ByteString.f33308c;
        f29659a = companion.c("\"\\");
        f29660b = companion.c("\t ,=");
    }

    public static final List<g> a(s sVar, String str) {
        j.g(sVar, "<this>");
        j.g(str, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = sVar.size();
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            if (r.t(str, sVar.f(i10), true)) {
                try {
                    c(new Buffer().h0(sVar.n(i10)), arrayList);
                } catch (EOFException e10) {
                    il.j.f30050a.g().j("Unable to parse challenge", 5, e10);
                }
            }
            i10 = i11;
        }
        return arrayList;
    }

    public static final boolean b(a0 a0Var) {
        j.g(a0Var, "<this>");
        if (j.b(a0Var.F().g(), FirebasePerformance.HttpMethod.HEAD)) {
            return false;
        }
        int f10 = a0Var.f();
        if (((f10 >= 100 && f10 < 200) || f10 == 204 || f10 == 304) && d.v(a0Var) == -1 && !r.t("chunked", a0.m(a0Var, "Transfer-Encoding", (String) null, 2, (Object) null), true)) {
            return false;
        }
        return true;
    }

    private static final void c(Buffer buffer, List<g> list) throws EOFException {
        String e10;
        int K;
        String str;
        while (true) {
            String str2 = null;
            while (true) {
                if (str2 == null) {
                    g(buffer);
                    str2 = e(buffer);
                    if (str2 == null) {
                        return;
                    }
                }
                boolean g10 = g(buffer);
                e10 = e(buffer);
                if (e10 != null) {
                    K = d.K(buffer, (byte) 61);
                    boolean g11 = g(buffer);
                    if (g10 || (!g11 && !buffer.Y0())) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        int K2 = K + d.K(buffer, (byte) 61);
                        while (true) {
                            if (e10 == null) {
                                e10 = e(buffer);
                                if (g(buffer)) {
                                    continue;
                                    break;
                                }
                                K2 = d.K(buffer, (byte) 61);
                            }
                            if (K2 == 0) {
                                continue;
                                break;
                            } else if (K2 <= 1 && !g(buffer)) {
                                if (h(buffer, (byte) 34)) {
                                    str = d(buffer);
                                } else {
                                    str = e(buffer);
                                }
                                if (str == null || ((String) linkedHashMap.put(e10, str)) != null) {
                                    return;
                                }
                                if (g(buffer) || buffer.Y0()) {
                                    e10 = null;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        list.add(new g(str2, linkedHashMap));
                        str2 = e10;
                    }
                } else if (buffer.Y0()) {
                    list.add(new g(str2, h0.i()));
                    return;
                } else {
                    return;
                }
            }
            Map singletonMap = Collections.singletonMap((Object) null, j.p(e10, r.z("=", K)));
            j.f(singletonMap, "singletonMap<String, Str…ek + \"=\".repeat(eqCount))");
            list.add(new g(str2, singletonMap));
        }
    }

    private static final String d(Buffer buffer) throws EOFException {
        boolean z10;
        if (buffer.readByte() == 34) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            Buffer buffer2 = new Buffer();
            while (true) {
                long U = buffer.U(f29659a);
                if (U == -1) {
                    return null;
                }
                if (buffer.l(U) == 34) {
                    buffer2.k0(buffer, U);
                    buffer.readByte();
                    return buffer2.G();
                } else if (buffer.size() == U + 1) {
                    return null;
                } else {
                    buffer2.k0(buffer, U);
                    buffer.readByte();
                    buffer2.k0(buffer, 1);
                }
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private static final String e(Buffer buffer) {
        long U = buffer.U(f29660b);
        if (U == -1) {
            U = buffer.size();
        }
        if (U != 0) {
            return buffer.L0(U);
        }
        return null;
    }

    public static final void f(m mVar, t tVar, s sVar) {
        j.g(mVar, "<this>");
        j.g(tVar, "url");
        j.g(sVar, HeadersExtension.ELEMENT);
        if (mVar != m.f33144b) {
            List<l> e10 = l.f33129j.e(tVar, sVar);
            if (!e10.isEmpty()) {
                mVar.b(tVar, e10);
            }
        }
    }

    private static final boolean g(Buffer buffer) {
        boolean z10;
        boolean z11 = false;
        while (!buffer.Y0()) {
            byte l10 = buffer.l(0);
            if (l10 != 44) {
                if (l10 == 32 || l10 == 9) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    break;
                }
                buffer.readByte();
            } else {
                buffer.readByte();
                z11 = true;
            }
        }
        return z11;
    }

    private static final boolean h(Buffer buffer, byte b10) {
        return !buffer.Y0() && buffer.l(0) == b10;
    }
}
