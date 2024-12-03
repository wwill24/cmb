package hl;

import bl.d;
import com.google.android.gms.common.api.a;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import net.bytebuddy.jar.asm.Opcodes;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportCandidate;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0007\nB\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR#\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010¨\u0006\u0014"}, d2 = {"Lhl/b;", "", "", "Lokio/ByteString;", "", "d", "name", "a", "", "Lhl/a;", "b", "[Lhl/a;", "c", "()[Lhl/a;", "STATIC_HEADER_TABLE", "Ljava/util/Map;", "()Ljava/util/Map;", "NAME_TO_FIRST_INDEX", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f29760a;

    /* renamed from: b  reason: collision with root package name */
    private static final a[] f29761b;

    /* renamed from: c  reason: collision with root package name */
    private static final Map<ByteString, Integer> f29762c;

    static {
        b bVar = new b();
        f29760a = bVar;
        ByteString byteString = a.f29753g;
        ByteString byteString2 = a.f29754h;
        ByteString byteString3 = a.f29755i;
        ByteString byteString4 = a.f29752f;
        f29761b = new a[]{new a(a.f29756j, ""), new a(byteString, "GET"), new a(byteString, "POST"), new a(byteString2, (String) RemoteSettings.FORWARD_SLASH_STRING), new a(byteString2, "/index.html"), new a(byteString3, "http"), new a(byteString3, "https"), new a(byteString4, "200"), new a(byteString4, "204"), new a(byteString4, "206"), new a(byteString4, "304"), new a(byteString4, "400"), new a(byteString4, "404"), new a(byteString4, "500"), new a("accept-charset", ""), new a("accept-encoding", "gzip, deflate"), new a("accept-language", ""), new a("accept-ranges", ""), new a("accept", ""), new a("access-control-allow-origin", ""), new a("age", ""), new a("allow", ""), new a("authorization", ""), new a("cache-control", ""), new a("content-disposition", ""), new a("content-encoding", ""), new a("content-language", ""), new a("content-length", ""), new a("content-location", ""), new a("content-range", ""), new a("content-type", ""), new a("cookie", ""), new a("date", ""), new a("etag", ""), new a("expect", ""), new a("expires", ""), new a("from", ""), new a((String) JingleS5BTransportCandidate.ATTR_HOST, ""), new a("if-match", ""), new a("if-modified-since", ""), new a("if-none-match", ""), new a("if-range", ""), new a("if-unmodified-since", ""), new a("last-modified", ""), new a("link", ""), new a("location", ""), new a("max-forwards", ""), new a("proxy-authenticate", ""), new a("proxy-authorization", ""), new a("range", ""), new a("referer", ""), new a("refresh", ""), new a("retry-after", ""), new a("server", ""), new a("set-cookie", ""), new a("strict-transport-security", ""), new a("transfer-encoding", ""), new a("user-agent", ""), new a("vary", ""), new a("via", ""), new a("www-authenticate", "")};
        f29762c = bVar.d();
    }

    private b() {
    }

    private final Map<ByteString, Integer> d() {
        a[] aVarArr = f29761b;
        LinkedHashMap linkedHashMap = new LinkedHashMap(aVarArr.length);
        int length = aVarArr.length;
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            a[] aVarArr2 = f29761b;
            if (!linkedHashMap.containsKey(aVarArr2[i10].f29757a)) {
                linkedHashMap.put(aVarArr2[i10].f29757a, Integer.valueOf(i10));
            }
            i10 = i11;
        }
        Map<ByteString, Integer> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        j.f(unmodifiableMap, "unmodifiableMap(result)");
        return unmodifiableMap;
    }

    public final ByteString a(ByteString byteString) throws IOException {
        boolean z10;
        j.g(byteString, "name");
        int H = byteString.H();
        int i10 = 0;
        while (i10 < H) {
            int i11 = i10 + 1;
            byte i12 = byteString.i(i10);
            if (65 > i12 || i12 > 90) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (!z10) {
                i10 = i11;
            } else {
                throw new IOException(j.p("PROTOCOL_ERROR response malformed: mixed case name: ", byteString.Q()));
            }
        }
        return byteString;
    }

    public final Map<ByteString, Integer> b() {
        return f29762c;
    }

    public final a[] c() {
        return f29761b;
    }

    @Metadata(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010'\u001a\u00020.\u0012\u0006\u0010 \u001a\u00020\u0005\u0012\b\b\u0002\u0010!\u001a\u00020\u0005¢\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0002J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u0018J\u0006\u0010\u001a\u001a\u00020\u0002J\u0016\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005J\u0006\u0010\u001e\u001a\u00020\u0010R\u0014\u0010 \u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001fR\u0016\u0010!\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u001fR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00140\"8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010#R\u0014\u0010'\u001a\u00020%8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010&R\u001e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140(8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010)R\u0016\u0010+\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001fR\u0016\u0010,\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u001fR\u0016\u0010-\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u001f¨\u00061"}, d2 = {"Lhl/b$a;", "", "", "a", "b", "", "bytesToRecover", "d", "index", "l", "c", "p", "q", "nameIndex", "n", "o", "Lokio/ByteString;", "f", "", "h", "Lhl/a;", "entry", "g", "i", "", "e", "k", "firstByte", "prefixMask", "m", "j", "I", "headerTableSizeSetting", "maxDynamicTableByteCount", "", "Ljava/util/List;", "headerList", "Lokio/BufferedSource;", "Lokio/BufferedSource;", "source", "", "[Lhl/a;", "dynamicTable", "nextHeaderIndex", "headerCount", "dynamicTableByteCount", "Lokio/Source;", "<init>", "(Lokio/Source;II)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f29763a;

        /* renamed from: b  reason: collision with root package name */
        private int f29764b;

        /* renamed from: c  reason: collision with root package name */
        private final List<a> f29765c;

        /* renamed from: d  reason: collision with root package name */
        private final BufferedSource f29766d;

        /* renamed from: e  reason: collision with root package name */
        public a[] f29767e;

        /* renamed from: f  reason: collision with root package name */
        private int f29768f;

        /* renamed from: g  reason: collision with root package name */
        public int f29769g;

        /* renamed from: h  reason: collision with root package name */
        public int f29770h;

        public a(Source source, int i10, int i11) {
            j.g(source, "source");
            this.f29763a = i10;
            this.f29764b = i11;
            this.f29765c = new ArrayList();
            this.f29766d = Okio.c(source);
            a[] aVarArr = new a[8];
            this.f29767e = aVarArr;
            this.f29768f = aVarArr.length - 1;
        }

        private final void a() {
            int i10 = this.f29764b;
            int i11 = this.f29770h;
            if (i10 >= i11) {
                return;
            }
            if (i10 == 0) {
                b();
            } else {
                d(i11 - i10);
            }
        }

        private final void b() {
            k.n(this.f29767e, (Object) null, 0, 0, 6, (Object) null);
            this.f29768f = this.f29767e.length - 1;
            this.f29769g = 0;
            this.f29770h = 0;
        }

        private final int c(int i10) {
            return this.f29768f + 1 + i10;
        }

        private final int d(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f29767e.length;
                while (true) {
                    length--;
                    i11 = this.f29768f;
                    if (length < i11 || i10 <= 0) {
                        a[] aVarArr = this.f29767e;
                        System.arraycopy(aVarArr, i11 + 1, aVarArr, i11 + 1 + i12, this.f29769g);
                        this.f29768f += i12;
                    } else {
                        a aVar = this.f29767e[length];
                        j.d(aVar);
                        int i13 = aVar.f29759c;
                        i10 -= i13;
                        this.f29770h -= i13;
                        this.f29769g--;
                        i12++;
                    }
                }
                a[] aVarArr2 = this.f29767e;
                System.arraycopy(aVarArr2, i11 + 1, aVarArr2, i11 + 1 + i12, this.f29769g);
                this.f29768f += i12;
            }
            return i12;
        }

        private final ByteString f(int i10) throws IOException {
            if (h(i10)) {
                return b.f29760a.c()[i10].f29757a;
            }
            int c10 = c(i10 - b.f29760a.c().length);
            if (c10 >= 0) {
                a[] aVarArr = this.f29767e;
                if (c10 < aVarArr.length) {
                    a aVar = aVarArr[c10];
                    j.d(aVar);
                    return aVar.f29757a;
                }
            }
            throw new IOException(j.p("Header index too large ", Integer.valueOf(i10 + 1)));
        }

        private final void g(int i10, a aVar) {
            this.f29765c.add(aVar);
            int i11 = aVar.f29759c;
            if (i10 != -1) {
                a aVar2 = this.f29767e[c(i10)];
                j.d(aVar2);
                i11 -= aVar2.f29759c;
            }
            int i12 = this.f29764b;
            if (i11 > i12) {
                b();
                return;
            }
            int d10 = d((this.f29770h + i11) - i12);
            if (i10 == -1) {
                int i13 = this.f29769g + 1;
                a[] aVarArr = this.f29767e;
                if (i13 > aVarArr.length) {
                    a[] aVarArr2 = new a[(aVarArr.length * 2)];
                    System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                    this.f29768f = this.f29767e.length - 1;
                    this.f29767e = aVarArr2;
                }
                int i14 = this.f29768f;
                this.f29768f = i14 - 1;
                this.f29767e[i14] = aVar;
                this.f29769g++;
            } else {
                this.f29767e[i10 + c(i10) + d10] = aVar;
            }
            this.f29770h += i11;
        }

        private final boolean h(int i10) {
            return i10 >= 0 && i10 <= b.f29760a.c().length - 1;
        }

        private final int i() throws IOException {
            return d.d(this.f29766d.readByte(), 255);
        }

        private final void l(int i10) throws IOException {
            if (h(i10)) {
                this.f29765c.add(b.f29760a.c()[i10]);
                return;
            }
            int c10 = c(i10 - b.f29760a.c().length);
            if (c10 >= 0) {
                a[] aVarArr = this.f29767e;
                if (c10 < aVarArr.length) {
                    List<a> list = this.f29765c;
                    a aVar = aVarArr[c10];
                    j.d(aVar);
                    list.add(aVar);
                    return;
                }
            }
            throw new IOException(j.p("Header index too large ", Integer.valueOf(i10 + 1)));
        }

        private final void n(int i10) throws IOException {
            g(-1, new a(f(i10), j()));
        }

        private final void o() throws IOException {
            g(-1, new a(b.f29760a.a(j()), j()));
        }

        private final void p(int i10) throws IOException {
            this.f29765c.add(new a(f(i10), j()));
        }

        private final void q() throws IOException {
            this.f29765c.add(new a(b.f29760a.a(j()), j()));
        }

        public final List<a> e() {
            List<a> x02 = CollectionsKt___CollectionsKt.x0(this.f29765c);
            this.f29765c.clear();
            return x02;
        }

        public final ByteString j() throws IOException {
            boolean z10;
            int i10 = i();
            if ((i10 & 128) == 128) {
                z10 = true;
            } else {
                z10 = false;
            }
            long m10 = (long) m(i10, Opcodes.LAND);
            if (!z10) {
                return this.f29766d.O0(m10);
            }
            Buffer buffer = new Buffer();
            i.f29933a.b(this.f29766d, m10, buffer);
            return buffer.y1();
        }

        public final void k() throws IOException {
            while (!this.f29766d.Y0()) {
                int d10 = d.d(this.f29766d.readByte(), 255);
                if (d10 == 128) {
                    throw new IOException("index == 0");
                } else if ((d10 & 128) == 128) {
                    l(m(d10, Opcodes.LAND) - 1);
                } else if (d10 == 64) {
                    o();
                } else if ((d10 & 64) == 64) {
                    n(m(d10, 63) - 1);
                } else if ((d10 & 32) == 32) {
                    int m10 = m(d10, 31);
                    this.f29764b = m10;
                    if (m10 < 0 || m10 > this.f29763a) {
                        throw new IOException(j.p("Invalid dynamic table size update ", Integer.valueOf(this.f29764b)));
                    }
                    a();
                } else if (d10 == 16 || d10 == 0) {
                    q();
                } else {
                    p(m(d10, 15) - 1);
                }
            }
        }

        public final int m(int i10, int i11) throws IOException {
            int i12 = i10 & i11;
            if (i12 < i11) {
                return i12;
            }
            int i13 = 0;
            while (true) {
                int i14 = i();
                if ((i14 & 128) == 0) {
                    return i11 + (i14 << i13);
                }
                i11 += (i14 & Opcodes.LAND) << i13;
                i13 += 7;
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(Source source, int i10, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this(source, i10, (i12 & 4) != 0 ? i10 : i11);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\n\u0018\u00002\u00020\u0001B%\b\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0018\u0012\u0006\u0010\u001d\u001a\u00020\u001b¢\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0014\u0010\r\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bJ\u001e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0004R\u0016\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0017R\u0016\u0010\u001f\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0019R\u0016\u0010 \u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0017R\u001e\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070!8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\"R\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0017R\u0016\u0010&\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b%\u0010\u0017R\u0016\u0010(\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b'\u0010\u0017¨\u0006+"}, d2 = {"Lhl/b$b;", "", "", "b", "", "bytesToRecover", "c", "Lhl/a;", "entry", "d", "a", "", "headerBlock", "g", "value", "prefixMask", "bits", "h", "Lokio/ByteString;", "data", "f", "headerTableSizeSetting", "e", "I", "", "Z", "useCompression", "Lokio/Buffer;", "Lokio/Buffer;", "out", "smallestHeaderTableSizeSetting", "emitDynamicTableSizeUpdate", "maxDynamicTableByteCount", "", "[Lhl/a;", "dynamicTable", "nextHeaderIndex", "i", "headerCount", "j", "dynamicTableByteCount", "<init>", "(IZLokio/Buffer;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    /* renamed from: hl.b$b  reason: collision with other inner class name */
    public static final class C0346b {

        /* renamed from: a  reason: collision with root package name */
        public int f29771a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f29772b;

        /* renamed from: c  reason: collision with root package name */
        private final Buffer f29773c;

        /* renamed from: d  reason: collision with root package name */
        private int f29774d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f29775e;

        /* renamed from: f  reason: collision with root package name */
        public int f29776f;

        /* renamed from: g  reason: collision with root package name */
        public a[] f29777g;

        /* renamed from: h  reason: collision with root package name */
        private int f29778h;

        /* renamed from: i  reason: collision with root package name */
        public int f29779i;

        /* renamed from: j  reason: collision with root package name */
        public int f29780j;

        public C0346b(int i10, boolean z10, Buffer buffer) {
            j.g(buffer, "out");
            this.f29771a = i10;
            this.f29772b = z10;
            this.f29773c = buffer;
            this.f29774d = a.e.API_PRIORITY_OTHER;
            this.f29776f = i10;
            a[] aVarArr = new a[8];
            this.f29777g = aVarArr;
            this.f29778h = aVarArr.length - 1;
        }

        private final void a() {
            int i10 = this.f29776f;
            int i11 = this.f29780j;
            if (i10 >= i11) {
                return;
            }
            if (i10 == 0) {
                b();
            } else {
                c(i11 - i10);
            }
        }

        private final void b() {
            k.n(this.f29777g, (Object) null, 0, 0, 6, (Object) null);
            this.f29778h = this.f29777g.length - 1;
            this.f29779i = 0;
            this.f29780j = 0;
        }

        private final int c(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f29777g.length;
                while (true) {
                    length--;
                    i11 = this.f29778h;
                    if (length < i11 || i10 <= 0) {
                        a[] aVarArr = this.f29777g;
                        System.arraycopy(aVarArr, i11 + 1, aVarArr, i11 + 1 + i12, this.f29779i);
                        a[] aVarArr2 = this.f29777g;
                        int i13 = this.f29778h;
                        Arrays.fill(aVarArr2, i13 + 1, i13 + 1 + i12, (Object) null);
                        this.f29778h += i12;
                    } else {
                        a aVar = this.f29777g[length];
                        j.d(aVar);
                        i10 -= aVar.f29759c;
                        int i14 = this.f29780j;
                        a aVar2 = this.f29777g[length];
                        j.d(aVar2);
                        this.f29780j = i14 - aVar2.f29759c;
                        this.f29779i--;
                        i12++;
                    }
                }
                a[] aVarArr3 = this.f29777g;
                System.arraycopy(aVarArr3, i11 + 1, aVarArr3, i11 + 1 + i12, this.f29779i);
                a[] aVarArr22 = this.f29777g;
                int i132 = this.f29778h;
                Arrays.fill(aVarArr22, i132 + 1, i132 + 1 + i12, (Object) null);
                this.f29778h += i12;
            }
            return i12;
        }

        private final void d(a aVar) {
            int i10 = aVar.f29759c;
            int i11 = this.f29776f;
            if (i10 > i11) {
                b();
                return;
            }
            c((this.f29780j + i10) - i11);
            int i12 = this.f29779i + 1;
            a[] aVarArr = this.f29777g;
            if (i12 > aVarArr.length) {
                a[] aVarArr2 = new a[(aVarArr.length * 2)];
                System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                this.f29778h = this.f29777g.length - 1;
                this.f29777g = aVarArr2;
            }
            int i13 = this.f29778h;
            this.f29778h = i13 - 1;
            this.f29777g[i13] = aVar;
            this.f29779i++;
            this.f29780j += i10;
        }

        public final void e(int i10) {
            this.f29771a = i10;
            int min = Math.min(i10, Opcodes.ACC_ENUM);
            int i11 = this.f29776f;
            if (i11 != min) {
                if (min < i11) {
                    this.f29774d = Math.min(this.f29774d, min);
                }
                this.f29775e = true;
                this.f29776f = min;
                a();
            }
        }

        public final void f(ByteString byteString) throws IOException {
            j.g(byteString, "data");
            if (this.f29772b) {
                i iVar = i.f29933a;
                if (iVar.d(byteString) < byteString.H()) {
                    Buffer buffer = new Buffer();
                    iVar.c(byteString, buffer);
                    ByteString y12 = buffer.y1();
                    h(y12.H(), Opcodes.LAND, 128);
                    this.f29773c.K1(y12);
                    return;
                }
            }
            h(byteString.H(), Opcodes.LAND, 0);
            this.f29773c.K1(byteString);
        }

        public final void g(List<a> list) throws IOException {
            int i10;
            int i11;
            boolean z10;
            j.g(list, "headerBlock");
            if (this.f29775e) {
                int i12 = this.f29774d;
                if (i12 < this.f29776f) {
                    h(i12, 31, 32);
                }
                this.f29775e = false;
                this.f29774d = a.e.API_PRIORITY_OTHER;
                h(this.f29776f, 31, 32);
            }
            int size = list.size();
            int i13 = 0;
            while (i13 < size) {
                int i14 = i13 + 1;
                a aVar = list.get(i13);
                ByteString M = aVar.f29757a.M();
                ByteString byteString = aVar.f29758b;
                b bVar = b.f29760a;
                Integer num = bVar.b().get(M);
                if (num != null) {
                    i10 = num.intValue() + 1;
                    if (2 > i10 || i10 >= 8) {
                        z10 = false;
                    } else {
                        z10 = true;
                    }
                    if (z10) {
                        if (j.b(bVar.c()[i10 - 1].f29758b, byteString)) {
                            i11 = i10;
                        } else if (j.b(bVar.c()[i10].f29758b, byteString)) {
                            int i15 = i10;
                            i10++;
                            i11 = i15;
                        }
                    }
                    i11 = i10;
                    i10 = -1;
                } else {
                    i11 = -1;
                    i10 = -1;
                }
                if (i10 == -1) {
                    int i16 = this.f29778h + 1;
                    int length = this.f29777g.length;
                    while (true) {
                        if (i16 >= length) {
                            break;
                        }
                        int i17 = i16 + 1;
                        a aVar2 = this.f29777g[i16];
                        j.d(aVar2);
                        if (j.b(aVar2.f29757a, M)) {
                            a aVar3 = this.f29777g[i16];
                            j.d(aVar3);
                            if (j.b(aVar3.f29758b, byteString)) {
                                i10 = b.f29760a.c().length + (i16 - this.f29778h);
                                break;
                            } else if (i11 == -1) {
                                i11 = b.f29760a.c().length + (i16 - this.f29778h);
                            }
                        }
                        i16 = i17;
                    }
                }
                if (i10 != -1) {
                    h(i10, Opcodes.LAND, 128);
                } else if (i11 == -1) {
                    this.f29773c.writeByte(64);
                    f(M);
                    f(byteString);
                    d(aVar);
                } else if (!M.I(a.f29751e) || j.b(a.f29756j, M)) {
                    h(i11, 63, 64);
                    f(byteString);
                    d(aVar);
                } else {
                    h(i11, 15, 0);
                    f(byteString);
                }
                i13 = i14;
            }
        }

        public final void h(int i10, int i11, int i12) {
            if (i10 < i11) {
                this.f29773c.writeByte(i10 | i12);
                return;
            }
            this.f29773c.writeByte(i12 | i11);
            int i13 = i10 - i11;
            while (i13 >= 128) {
                this.f29773c.writeByte(128 | (i13 & Opcodes.LAND));
                i13 >>>= 7;
            }
            this.f29773c.writeByte(i13);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ C0346b(int i10, boolean z10, Buffer buffer, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? Opcodes.ACC_SYNTHETIC : i10, (i11 & 2) != 0 ? true : z10, buffer);
        }
    }
}
