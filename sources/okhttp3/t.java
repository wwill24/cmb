package okhttp3;

import bl.d;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.text.Regex;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import okio.Buffer;
import org.apache.commons.validator.Field;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportCandidate;

@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\b\u0019\u0018\u0000 \r2\u00020\u0001:\u0002\u0015\u001aBc\b\u0000\u0012\u0006\u0010\u0019\u001a\u00020\b\u0012\u0006\u0010\u001b\u001a\u00020\b\u0012\u0006\u0010\u001d\u001a\u00020\b\u0012\u0006\u0010 \u001a\u00020\b\u0012\u0006\u0010%\u001a\u00020\u0012\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0&\u0012\u0010\u0010-\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010&\u0012\b\u0010/\u001a\u0004\u0018\u00010\b\u0012\u0006\u00100\u001a\u00020\b¢\u0006\u0004\b=\u0010>J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00002\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\bJ\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016R\u0017\u0010\u0019\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001b\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u0017\u0010\u001d\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018R\u0017\u0010 \u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001f\u0010\u0018R\u0017\u0010%\u001a\u00020\u00128\u0007¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0&8\u0007¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001e\u0010-\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010&8\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010(R\u0019\u0010/\u001a\u0004\u0018\u00010\b8\u0007¢\u0006\f\n\u0004\b.\u0010\u0016\u001a\u0004\b/\u0010\u0018R\u0014\u00100\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0016R\u0017\u00104\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b1\u00103R\u0011\u00105\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b,\u0010\u0018R\u0011\u00106\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0018R\u0011\u00107\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0018R\u0017\u00108\u001a\b\u0012\u0004\u0012\u00020\b0&8G¢\u0006\u0006\u001a\u0004\b!\u0010*R\u0013\u00109\u001a\u0004\u0018\u00010\b8G¢\u0006\u0006\u001a\u0004\b'\u0010\u0018R\u0013\u0010;\u001a\u0004\u0018\u00010\b8G¢\u0006\u0006\u001a\u0004\b:\u0010\u0018R\u0013\u0010<\u001a\u0004\u0018\u00010\b8G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018¨\u0006?"}, d2 = {"Lokhttp3/t;", "", "Ljava/net/URL;", "u", "()Ljava/net/URL;", "Ljava/net/URI;", "t", "()Ljava/net/URI;", "", "q", "link", "r", "Lokhttp3/t$a;", "k", "l", "other", "", "equals", "", "hashCode", "toString", "a", "Ljava/lang/String;", "s", "()Ljava/lang/String;", "scheme", "b", "username", "c", "password", "d", "i", "host", "e", "I", "o", "()I", "port", "", "f", "Ljava/util/List;", "n", "()Ljava/util/List;", "pathSegments", "g", "queryNamesAndValues", "h", "fragment", "url", "j", "Z", "()Z", "isHttps", "encodedUsername", "encodedPassword", "encodedPath", "encodedPathSegments", "encodedQuery", "p", "query", "encodedFragment", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class t {

    /* renamed from: k  reason: collision with root package name */
    public static final b f33169k = new b((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static final char[] f33170l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a  reason: collision with root package name */
    private final String f33171a;

    /* renamed from: b  reason: collision with root package name */
    private final String f33172b;

    /* renamed from: c  reason: collision with root package name */
    private final String f33173c;

    /* renamed from: d  reason: collision with root package name */
    private final String f33174d;

    /* renamed from: e  reason: collision with root package name */
    private final int f33175e;

    /* renamed from: f  reason: collision with root package name */
    private final List<String> f33176f;

    /* renamed from: g  reason: collision with root package name */
    private final List<String> f33177g;

    /* renamed from: h  reason: collision with root package name */
    private final String f33178h;

    /* renamed from: i  reason: collision with root package name */
    private final String f33179i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f33180j;

    @Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010!\n\u0002\b\u000e\u0018\u0000 D2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\bN\u0010OJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J0\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0002J\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001f\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\"\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\u0004J\u0018\u0010%\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u0004J\u0010\u0010'\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010\u0004J\u000f\u0010(\u001a\u00020\u0000H\u0000¢\u0006\u0004\b(\u0010)J\u0006\u0010+\u001a\u00020*J\b\u0010,\u001a\u00020\u0004H\u0016J!\u0010.\u001a\u00020\u00002\b\u0010-\u001a\u0004\u0018\u00010*2\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b.\u0010/R$\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b%\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00107\u001a\u00020\u00048\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\"\u00100\u001a\u0004\b5\u00102\"\u0004\b6\u00104R\"\u0010:\u001a\u00020\u00048\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b+\u00100\u001a\u0004\b8\u00102\"\u0004\b9\u00104R$\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0003\u00100\u001a\u0004\b;\u00102\"\u0004\b<\u00104R\"\u0010\u001a\u001a\u00020\u00028\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR \u0010F\u001a\b\u0012\u0004\u0012\u00020\u00040B8\u0000X\u0004¢\u0006\f\n\u0004\b'\u0010C\u001a\u0004\bD\u0010ER,\u0010K\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010B8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bG\u0010C\u001a\u0004\bH\u0010E\"\u0004\bI\u0010JR$\u0010M\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b8\u00100\u001a\u0004\bG\u00102\"\u0004\bL\u00104¨\u0006P"}, d2 = {"Lokhttp3/t$a;", "", "", "d", "", "input", "startPos", "limit", "", "y", "pos", "", "addTrailingSlash", "alreadyEncoded", "v", "p", "q", "t", "scheme", "z", "username", "H", "password", "s", "host", "o", "port", "u", "query", "w", "encodedQuery", "e", "name", "value", "b", "encodedName", "encodedValue", "a", "fragment", "f", "x", "()Lokhttp3/t$a;", "Lokhttp3/t;", "c", "toString", "base", "r", "(Lokhttp3/t;Ljava/lang/String;)Lokhttp3/t$a;", "Ljava/lang/String;", "n", "()Ljava/lang/String;", "G", "(Ljava/lang/String;)V", "k", "D", "encodedUsername", "h", "B", "encodedPassword", "l", "E", "I", "m", "()I", "F", "(I)V", "", "Ljava/util/List;", "i", "()Ljava/util/List;", "encodedPathSegments", "g", "j", "C", "(Ljava/util/List;)V", "encodedQueryNamesAndValues", "A", "encodedFragment", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* renamed from: i  reason: collision with root package name */
        public static final C0381a f33181i = new C0381a((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        private String f33182a;

        /* renamed from: b  reason: collision with root package name */
        private String f33183b = "";

        /* renamed from: c  reason: collision with root package name */
        private String f33184c = "";

        /* renamed from: d  reason: collision with root package name */
        private String f33185d;

        /* renamed from: e  reason: collision with root package name */
        private int f33186e = -1;

        /* renamed from: f  reason: collision with root package name */
        private final List<String> f33187f;

        /* renamed from: g  reason: collision with root package name */
        private List<String> f33188g;

        /* renamed from: h  reason: collision with root package name */
        private String f33189h;

        @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u001c\u0010\b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002R\u0014\u0010\u000b\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lokhttp3/t$a$a;", "", "", "input", "", "pos", "limit", "g", "h", "f", "e", "INVALID_HOST", "Ljava/lang/String;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
        /* renamed from: okhttp3.t$a$a  reason: collision with other inner class name */
        public static final class C0381a {
            private C0381a() {
            }

            public /* synthetic */ C0381a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* access modifiers changed from: private */
            public final int e(String str, int i10, int i11) {
                try {
                    int parseInt = Integer.parseInt(b.b(t.f33169k, str, i10, i11, "", false, false, false, false, (Charset) null, 248, (Object) null));
                    boolean z10 = false;
                    if (1 <= parseInt && parseInt < 65536) {
                        z10 = true;
                    }
                    if (z10) {
                        return parseInt;
                    }
                    return -1;
                } catch (NumberFormatException unused) {
                    return -1;
                }
            }

            /* access modifiers changed from: private */
            public final int f(String str, int i10, int i11) {
                while (i10 < i11) {
                    char charAt = str.charAt(i10);
                    if (charAt == '[') {
                        do {
                            i10++;
                            if (i10 >= i11) {
                                break;
                            }
                        } while (str.charAt(i10) == ']');
                    } else if (charAt == ':') {
                        return i10;
                    }
                    i10++;
                }
                return i11;
            }

            /* access modifiers changed from: private */
            public final int g(String str, int i10, int i11) {
                boolean z10;
                boolean z11;
                boolean z12;
                boolean z13;
                boolean z14;
                if (i11 - i10 < 2) {
                    return -1;
                }
                char charAt = str.charAt(i10);
                if ((j.i(charAt, 97) < 0 || j.i(charAt, 122) > 0) && (j.i(charAt, 65) < 0 || j.i(charAt, 90) > 0)) {
                    return -1;
                }
                int i12 = i10 + 1;
                while (i12 < i11) {
                    int i13 = i12 + 1;
                    char charAt2 = str.charAt(i12);
                    boolean z15 = false;
                    if ('a' > charAt2 || charAt2 >= '{') {
                        z10 = false;
                    } else {
                        z10 = true;
                    }
                    if (!z10 && ('A' > charAt2 || charAt2 >= '[')) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    if (!z11 && ('0' > charAt2 || charAt2 >= ':')) {
                        z12 = false;
                    } else {
                        z12 = true;
                    }
                    if (!z12 && charAt2 != '+') {
                        z13 = false;
                    } else {
                        z13 = true;
                    }
                    if (!z13 && charAt2 != '-') {
                        z14 = false;
                    } else {
                        z14 = true;
                    }
                    if (z14 || charAt2 == '.') {
                        z15 = true;
                    }
                    if (z15) {
                        i12 = i13;
                    } else if (charAt2 == ':') {
                        return i12;
                    } else {
                        return -1;
                    }
                }
                return -1;
            }

            /* access modifiers changed from: private */
            public final int h(String str, int i10, int i11) {
                int i12 = 0;
                while (i10 < i11) {
                    int i13 = i10 + 1;
                    char charAt = str.charAt(i10);
                    if (charAt != '\\' && charAt != '/') {
                        break;
                    }
                    i12++;
                    i10 = i13;
                }
                return i12;
            }
        }

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f33187f = arrayList;
            arrayList.add("");
        }

        private final int d() {
            int i10 = this.f33186e;
            if (i10 != -1) {
                return i10;
            }
            b bVar = t.f33169k;
            String str = this.f33182a;
            j.d(str);
            return bVar.c(str);
        }

        private final boolean p(String str) {
            return j.b(str, ".") || r.t(str, "%2e", true);
        }

        private final boolean q(String str) {
            if (j.b(str, "..") || r.t(str, "%2e.", true) || r.t(str, ".%2e", true) || r.t(str, "%2e%2e", true)) {
                return true;
            }
            return false;
        }

        private final void t() {
            boolean z10;
            List<String> list = this.f33187f;
            if (list.remove(list.size() - 1).length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10 || !(!this.f33187f.isEmpty())) {
                this.f33187f.add("");
                return;
            }
            List<String> list2 = this.f33187f;
            list2.set(list2.size() - 1, "");
        }

        private final void v(String str, int i10, int i11, boolean z10, boolean z11) {
            boolean z12;
            String b10 = b.b(t.f33169k, str, i10, i11, " \"<>^`{}|/\\?#", z11, false, false, false, (Charset) null, 240, (Object) null);
            if (!p(b10)) {
                if (q(b10)) {
                    t();
                    return;
                }
                List<String> list = this.f33187f;
                if (list.get(list.size() - 1).length() == 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    List<String> list2 = this.f33187f;
                    list2.set(list2.size() - 1, b10);
                } else {
                    this.f33187f.add(b10);
                }
                if (z10) {
                    this.f33187f.add("");
                }
            }
        }

        private final void y(String str, int i10, int i11) {
            boolean z10;
            if (i10 != i11) {
                char charAt = str.charAt(i10);
                if (charAt == '/' || charAt == '\\') {
                    this.f33187f.clear();
                    this.f33187f.add("");
                    i10++;
                } else {
                    List<String> list = this.f33187f;
                    list.set(list.size() - 1, "");
                }
                while (true) {
                    int i12 = i10;
                    while (true) {
                        if (i12 < i11) {
                            i10 = d.q(str, "/\\", i12, i11);
                            if (i10 < i11) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            v(str, i12, i10, z10, true);
                            if (z10) {
                                i12 = i10 + 1;
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
        }

        public final void A(String str) {
            this.f33189h = str;
        }

        public final void B(String str) {
            j.g(str, "<set-?>");
            this.f33184c = str;
        }

        public final void C(List<String> list) {
            this.f33188g = list;
        }

        public final void D(String str) {
            j.g(str, "<set-?>");
            this.f33183b = str;
        }

        public final void E(String str) {
            this.f33185d = str;
        }

        public final void F(int i10) {
            this.f33186e = i10;
        }

        public final void G(String str) {
            this.f33182a = str;
        }

        public final a H(String str) {
            j.g(str, "username");
            D(b.b(t.f33169k, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, (Charset) null, 251, (Object) null));
            return this;
        }

        public final a a(String str, String str2) {
            String str3;
            j.g(str, "encodedName");
            if (j() == null) {
                C(new ArrayList());
            }
            List<String> j10 = j();
            j.d(j10);
            b bVar = t.f33169k;
            j10.add(b.b(bVar, str, 0, 0, " \"'<>#&=", true, false, true, false, (Charset) null, 211, (Object) null));
            List<String> j11 = j();
            j.d(j11);
            if (str2 == null) {
                str3 = null;
            } else {
                str3 = b.b(bVar, str2, 0, 0, " \"'<>#&=", true, false, true, false, (Charset) null, 211, (Object) null);
            }
            j11.add(str3);
            return this;
        }

        public final a b(String str, String str2) {
            String str3;
            j.g(str, "name");
            if (j() == null) {
                C(new ArrayList());
            }
            List<String> j10 = j();
            j.d(j10);
            b bVar = t.f33169k;
            j10.add(b.b(bVar, str, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, (Charset) null, 219, (Object) null));
            List<String> j11 = j();
            j.d(j11);
            if (str2 == null) {
                str3 = null;
            } else {
                str3 = b.b(bVar, str2, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, (Charset) null, 219, (Object) null);
            }
            j11.add(str3);
            return this;
        }

        public final t c() {
            ArrayList arrayList;
            String str;
            String str2;
            String str3 = this.f33182a;
            if (str3 != null) {
                b bVar = t.f33169k;
                String h10 = b.h(bVar, this.f33183b, 0, 0, false, 7, (Object) null);
                String h11 = b.h(bVar, this.f33184c, 0, 0, false, 7, (Object) null);
                String str4 = this.f33185d;
                if (str4 != null) {
                    int d10 = d();
                    List<String> list = this.f33187f;
                    ArrayList arrayList2 = new ArrayList(r.t(list, 10));
                    for (String h12 : list) {
                        arrayList2.add(b.h(t.f33169k, h12, 0, 0, false, 7, (Object) null));
                    }
                    List<String> list2 = this.f33188g;
                    if (list2 == null) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(r.t(list2, 10));
                        for (String str5 : list2) {
                            if (str5 == null) {
                                str2 = null;
                            } else {
                                str2 = b.h(t.f33169k, str5, 0, 0, true, 3, (Object) null);
                            }
                            arrayList.add(str2);
                        }
                    }
                    String str6 = this.f33189h;
                    if (str6 == null) {
                        str = null;
                    } else {
                        str = b.h(t.f33169k, str6, 0, 0, false, 7, (Object) null);
                    }
                    return new t(str3, h10, h11, str4, d10, arrayList2, arrayList, str, toString());
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        public final a e(String str) {
            List<String> list = null;
            if (str != null) {
                b bVar = t.f33169k;
                String b10 = b.b(bVar, str, 0, 0, " \"'<>#", true, false, true, false, (Charset) null, 211, (Object) null);
                if (b10 != null) {
                    list = bVar.j(b10);
                }
            }
            C(list);
            return this;
        }

        public final a f(String str) {
            A(str == null ? null : b.b(t.f33169k, str, 0, 0, "", false, false, false, true, (Charset) null, Opcodes.NEW, (Object) null));
            return this;
        }

        public final String g() {
            return this.f33189h;
        }

        public final String h() {
            return this.f33184c;
        }

        public final List<String> i() {
            return this.f33187f;
        }

        public final List<String> j() {
            return this.f33188g;
        }

        public final String k() {
            return this.f33183b;
        }

        public final String l() {
            return this.f33185d;
        }

        public final int m() {
            return this.f33186e;
        }

        public final String n() {
            return this.f33182a;
        }

        public final a o(String str) {
            j.g(str, JingleS5BTransportCandidate.ATTR_HOST);
            String e10 = bl.a.e(b.h(t.f33169k, str, 0, 0, false, 7, (Object) null));
            if (e10 != null) {
                E(e10);
                return this;
            }
            throw new IllegalArgumentException(j.p("unexpected host: ", str));
        }

        public final a r(t tVar, String str) {
            int i10;
            int q10;
            char c10;
            int i11;
            String str2;
            boolean z10;
            boolean z11;
            int i12;
            boolean z12;
            String str3;
            int i13;
            boolean z13;
            String str4 = str;
            j.g(str4, "input");
            int A = d.A(str4, 0, 0, 3, (Object) null);
            int C = d.C(str4, A, 0, 2, (Object) null);
            C0381a aVar = f33181i;
            int c11 = aVar.g(str4, A, C);
            String str5 = "this as java.lang.String…ing(startIndex, endIndex)";
            char c12 = 65535;
            boolean z14 = true;
            if (c11 != -1) {
                if (r.G(str4, "https:", A, true)) {
                    this.f33182a = "https";
                    A += 6;
                } else if (r.G(str4, "http:", A, true)) {
                    this.f33182a = "http";
                    A += 5;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Expected URL scheme 'http' or 'https' but was '");
                    String substring = str4.substring(0, c11);
                    j.f(substring, str5);
                    sb2.append(substring);
                    sb2.append('\'');
                    throw new IllegalArgumentException(sb2.toString());
                }
            } else if (tVar != null) {
                this.f33182a = tVar.s();
            } else {
                if (str.length() > 6) {
                    str4 = j.p(t.h1(str4, 6), "...");
                }
                throw new IllegalArgumentException(j.p("Expected URL scheme 'http' or 'https' but no scheme was found for ", str4));
            }
            int d10 = aVar.h(str4, A, C);
            char c13 = '?';
            char c14 = '#';
            if (d10 >= 2 || tVar == null || !j.b(tVar.s(), this.f33182a)) {
                int i14 = A + d10;
                boolean z15 = false;
                boolean z16 = false;
                while (true) {
                    q10 = d.q(str4, "@/\\?#", i14, C);
                    if (q10 != C) {
                        c10 = str4.charAt(q10);
                    } else {
                        c10 = c12;
                    }
                    if (c10 == c12 || c10 == c14 || c10 == '/' || c10 == '\\' || c10 == c13) {
                        boolean z17 = z14;
                        String str6 = str5;
                        i10 = C;
                        int i15 = q10;
                        C0381a aVar2 = f33181i;
                        int b10 = aVar2.f(str4, i14, i15);
                        int i16 = b10 + 1;
                    } else if (c10 == '@') {
                        if (!z15) {
                            int p10 = d.p(str4, ':', i14, q10);
                            b bVar = t.f33169k;
                            String str7 = "%40";
                            int i17 = q10;
                            int i18 = p10;
                            z12 = z14;
                            i12 = C;
                            String str8 = str5;
                            String b11 = b.b(bVar, str, i14, p10, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, (Charset) null, 240, (Object) null);
                            if (z16) {
                                b11 = this.f33183b + str7 + b11;
                            }
                            this.f33183b = b11;
                            int i19 = i17;
                            int i20 = i18;
                            if (i20 != i19) {
                                this.f33184c = b.b(bVar, str, i20 + 1, i19, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, (Charset) null, 240, (Object) null);
                                z13 = z12;
                            } else {
                                z13 = z15;
                            }
                            z15 = z13;
                            str3 = str8;
                            z16 = z12;
                            i13 = i19;
                        } else {
                            z12 = z14;
                            i12 = C;
                            String str9 = str5;
                            int i21 = q10;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(this.f33184c);
                            sb3.append("%40");
                            StringBuilder sb4 = sb3;
                            str3 = str9;
                            i13 = i21;
                            sb4.append(b.b(t.f33169k, str, i14, i21, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, (Charset) null, 240, (Object) null));
                            this.f33184c = sb4.toString();
                        }
                        i14 = i13 + 1;
                        str5 = str3;
                        z14 = z12;
                        C = i12;
                        c14 = '#';
                        c13 = '?';
                        c12 = 65535;
                    }
                }
                boolean z172 = z14;
                String str62 = str5;
                i10 = C;
                int i152 = q10;
                C0381a aVar22 = f33181i;
                int b102 = aVar22.f(str4, i14, i152);
                int i162 = b102 + 1;
                if (i162 < i152) {
                    i11 = i14;
                    this.f33185d = bl.a.e(b.h(t.f33169k, str, i14, b102, false, 4, (Object) null));
                    int a10 = aVar22.e(str4, i162, i152);
                    this.f33186e = a10;
                    if (a10 != -1) {
                        z11 = z172;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        str2 = str62;
                    } else {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("Invalid URL port: \"");
                        String substring2 = str4.substring(i162, i152);
                        j.f(substring2, str62);
                        sb5.append(substring2);
                        sb5.append('\"');
                        throw new IllegalArgumentException(sb5.toString().toString());
                    }
                } else {
                    i11 = i14;
                    str2 = str62;
                    b bVar2 = t.f33169k;
                    this.f33185d = bl.a.e(b.h(bVar2, str, i11, b102, false, 4, (Object) null));
                    String str10 = this.f33182a;
                    j.d(str10);
                    this.f33186e = bVar2.c(str10);
                }
                if (this.f33185d != null) {
                    z10 = z172;
                } else {
                    z10 = false;
                }
                if (z10) {
                    A = i152;
                } else {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("Invalid URL host: \"");
                    String substring3 = str4.substring(i11, b102);
                    j.f(substring3, str2);
                    sb6.append(substring3);
                    sb6.append('\"');
                    throw new IllegalArgumentException(sb6.toString().toString());
                }
            } else {
                this.f33183b = tVar.g();
                this.f33184c = tVar.c();
                this.f33185d = tVar.i();
                this.f33186e = tVar.o();
                this.f33187f.clear();
                this.f33187f.addAll(tVar.e());
                if (A == C || str4.charAt(A) == '#') {
                    e(tVar.f());
                }
                i10 = C;
            }
            int i22 = i10;
            int q11 = d.q(str4, "?#", A, i22);
            y(str4, A, q11);
            if (q11 < i22 && str4.charAt(q11) == '?') {
                int p11 = d.p(str4, '#', q11, i22);
                b bVar3 = t.f33169k;
                this.f33188g = bVar3.j(b.b(bVar3, str, q11 + 1, p11, " \"'<>#", true, false, true, false, (Charset) null, 208, (Object) null));
                q11 = p11;
            }
            if (q11 < i22 && str4.charAt(q11) == '#') {
                this.f33189h = b.b(t.f33169k, str, q11 + 1, i22, "", true, false, false, true, (Charset) null, Opcodes.ARETURN, (Object) null);
            }
            return this;
        }

        public final a s(String str) {
            j.g(str, "password");
            B(b.b(t.f33169k, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, (Charset) null, 251, (Object) null));
            return this;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x003d, code lost:
            if (r1 != false) goto L_0x003f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b5, code lost:
            if (r1 != r2.c(r3)) goto L_0x00b7;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String toString() {
            /*
                r6 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = r6.n()
                if (r1 == 0) goto L_0x0018
                java.lang.String r1 = r6.n()
                r0.append(r1)
                java.lang.String r1 = "://"
                r0.append(r1)
                goto L_0x001d
            L_0x0018:
                java.lang.String r1 = "//"
                r0.append(r1)
            L_0x001d:
                java.lang.String r1 = r6.k()
                int r1 = r1.length()
                r2 = 1
                r3 = 0
                if (r1 <= 0) goto L_0x002b
                r1 = r2
                goto L_0x002c
            L_0x002b:
                r1 = r3
            L_0x002c:
                r4 = 58
                if (r1 != 0) goto L_0x003f
                java.lang.String r1 = r6.h()
                int r1 = r1.length()
                if (r1 <= 0) goto L_0x003c
                r1 = r2
                goto L_0x003d
            L_0x003c:
                r1 = r3
            L_0x003d:
                if (r1 == 0) goto L_0x0063
            L_0x003f:
                java.lang.String r1 = r6.k()
                r0.append(r1)
                java.lang.String r1 = r6.h()
                int r1 = r1.length()
                if (r1 <= 0) goto L_0x0051
                goto L_0x0052
            L_0x0051:
                r2 = r3
            L_0x0052:
                if (r2 == 0) goto L_0x005e
                r0.append(r4)
                java.lang.String r1 = r6.h()
                r0.append(r1)
            L_0x005e:
                r1 = 64
                r0.append(r1)
            L_0x0063:
                java.lang.String r1 = r6.l()
                if (r1 == 0) goto L_0x0091
                java.lang.String r1 = r6.l()
                kotlin.jvm.internal.j.d(r1)
                r2 = 2
                r5 = 0
                boolean r1 = kotlin.text.StringsKt__StringsKt.N(r1, r4, r3, r2, r5)
                if (r1 == 0) goto L_0x008a
                r1 = 91
                r0.append(r1)
                java.lang.String r1 = r6.l()
                r0.append(r1)
                r1 = 93
                r0.append(r1)
                goto L_0x0091
            L_0x008a:
                java.lang.String r1 = r6.l()
                r0.append(r1)
            L_0x0091:
                int r1 = r6.m()
                r2 = -1
                if (r1 != r2) goto L_0x009e
                java.lang.String r1 = r6.n()
                if (r1 == 0) goto L_0x00bd
            L_0x009e:
                int r1 = r6.d()
                java.lang.String r2 = r6.n()
                if (r2 == 0) goto L_0x00b7
                okhttp3.t$b r2 = okhttp3.t.f33169k
                java.lang.String r3 = r6.n()
                kotlin.jvm.internal.j.d(r3)
                int r2 = r2.c(r3)
                if (r1 == r2) goto L_0x00bd
            L_0x00b7:
                r0.append(r4)
                r0.append(r1)
            L_0x00bd:
                okhttp3.t$b r1 = okhttp3.t.f33169k
                java.util.List r2 = r6.i()
                r1.i(r2, r0)
                java.util.List r2 = r6.j()
                if (r2 == 0) goto L_0x00db
                r2 = 63
                r0.append(r2)
                java.util.List r2 = r6.j()
                kotlin.jvm.internal.j.d(r2)
                r1.k(r2, r0)
            L_0x00db:
                java.lang.String r1 = r6.g()
                if (r1 == 0) goto L_0x00ed
                r1 = 35
                r0.append(r1)
                java.lang.String r1 = r6.g()
                r0.append(r1)
            L_0x00ed:
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "StringBuilder().apply(builderAction).toString()"
                kotlin.jvm.internal.j.f(r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.t.a.toString():java.lang.String");
        }

        public final a u(int i10) {
            boolean z10 = false;
            if (1 <= i10 && i10 < 65536) {
                z10 = true;
            }
            if (z10) {
                F(i10);
                return this;
            }
            throw new IllegalArgumentException(j.p("unexpected port: ", Integer.valueOf(i10)).toString());
        }

        public final a w(String str) {
            List<String> list = null;
            if (str != null) {
                b bVar = t.f33169k;
                String b10 = b.b(bVar, str, 0, 0, " \"'<>#", false, false, true, false, (Charset) null, 219, (Object) null);
                if (b10 != null) {
                    list = bVar.j(b10);
                }
            }
            C(list);
            return this;
        }

        public final a x() {
            String str;
            String str2;
            String l10 = l();
            String str3 = null;
            if (l10 == null) {
                str = null;
            } else {
                str = new Regex("[\"<>^`{|}]").f(l10, "");
            }
            E(str);
            int size = i().size();
            int i10 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                i().set(i11, b.b(t.f33169k, i().get(i11), 0, 0, Field.TOKEN_INDEXED, true, true, false, false, (Charset) null, 227, (Object) null));
            }
            List<String> j10 = j();
            if (j10 != null) {
                int size2 = j10.size();
                while (i10 < size2) {
                    int i12 = i10 + 1;
                    String str4 = j10.get(i10);
                    if (str4 == null) {
                        str2 = null;
                    } else {
                        str2 = b.b(t.f33169k, str4, 0, 0, "\\^`{|}", true, true, true, false, (Charset) null, Opcodes.MONITOREXIT, (Object) null);
                    }
                    j10.set(i10, str2);
                    i10 = i12;
                }
            }
            String g10 = g();
            if (g10 != null) {
                str3 = b.b(t.f33169k, g10, 0, 0, " \"#<>\\^`{|}", true, true, false, true, (Charset) null, Opcodes.IF_ICMPGT, (Object) null);
            }
            A(str3);
            return this;
        }

        public final a z(String str) {
            j.g(str, "scheme");
            if (r.t(str, "http", true)) {
                G("http");
            } else if (r.t(str, "https", true)) {
                G("https");
            } else {
                throw new IllegalArgumentException(j.p("unexpected scheme: ", str));
            }
            return this;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0019\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b8\u00109J,\u0010\u000b\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u001c\u0010\f\u001a\u00020\b*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002JV\u0010\u0014\u001a\u00020\n*\u00020\u00022\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0003H\u0007J%\u0010\u001b\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u00030\u00172\n\u0010\u001a\u001a\u00060\u0018j\u0002`\u0019H\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\u001d\u001a\u00020\n*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00172\n\u0010\u001a\u001a\u00060\u0018j\u0002`\u0019H\u0000¢\u0006\u0004\b\u001d\u0010\u001cJ\u001b\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001e*\u00020\u0003H\u0000¢\u0006\u0004\b\u001f\u0010 J\u0013\u0010\"\u001a\u00020!*\u00020\u0003H\u0007¢\u0006\u0004\b\"\u0010#J\u0015\u0010$\u001a\u0004\u0018\u00010!*\u00020\u0003H\u0007¢\u0006\u0004\b$\u0010#J1\u0010%\u001a\u00020\u0003*\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b%\u0010&Jc\u0010'\u001a\u00020\u0003*\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00038\u0000XT¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00038\u0000XT¢\u0006\u0006\n\u0004\b+\u0010*R\u0014\u0010,\u001a\u00020\u00038\u0000XT¢\u0006\u0006\n\u0004\b,\u0010*R\u0014\u0010.\u001a\u00020-8\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00100\u001a\u00020\u00038\u0000XT¢\u0006\u0006\n\u0004\b0\u0010*R\u0014\u00101\u001a\u00020\u00038\u0000XT¢\u0006\u0006\n\u0004\b1\u0010*R\u0014\u00102\u001a\u00020\u00038\u0000XT¢\u0006\u0006\n\u0004\b2\u0010*R\u0014\u00103\u001a\u00020\u00038\u0000XT¢\u0006\u0006\n\u0004\b3\u0010*R\u0014\u00104\u001a\u00020\u00038\u0000XT¢\u0006\u0006\n\u0004\b4\u0010*R\u0014\u00105\u001a\u00020\u00038\u0000XT¢\u0006\u0006\n\u0004\b5\u0010*R\u0014\u00106\u001a\u00020\u00038\u0000XT¢\u0006\u0006\n\u0004\b6\u0010*R\u0014\u00107\u001a\u00020\u00038\u0000XT¢\u0006\u0006\n\u0004\b7\u0010*¨\u0006:"}, d2 = {"Lokhttp3/t$b;", "", "Lokio/Buffer;", "", "encoded", "", "pos", "limit", "", "plusIsSpace", "", "m", "e", "input", "encodeSet", "alreadyEncoded", "strict", "unicodeAllowed", "Ljava/nio/charset/Charset;", "charset", "l", "scheme", "c", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "out", "i", "(Ljava/util/List;Ljava/lang/StringBuilder;)V", "k", "", "j", "(Ljava/lang/String;)Ljava/util/List;", "Lokhttp3/t;", "d", "(Ljava/lang/String;)Lokhttp3/t;", "f", "g", "(Ljava/lang/String;IIZ)Ljava/lang/String;", "a", "(Ljava/lang/String;IILjava/lang/String;ZZZZLjava/nio/charset/Charset;)Ljava/lang/String;", "FORM_ENCODE_SET", "Ljava/lang/String;", "FRAGMENT_ENCODE_SET", "FRAGMENT_ENCODE_SET_URI", "", "HEX_DIGITS", "[C", "PASSWORD_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET_URI", "QUERY_COMPONENT_ENCODE_SET", "QUERY_COMPONENT_ENCODE_SET_URI", "QUERY_COMPONENT_REENCODE_SET", "QUERY_ENCODE_SET", "USERNAME_ENCODE_SET", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ String b(b bVar, String str, int i10, int i11, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset, int i12, Object obj) {
            int i13;
            int i14;
            boolean z14;
            boolean z15;
            boolean z16;
            boolean z17;
            Charset charset2;
            int i15 = i12;
            if ((i15 & 1) != 0) {
                i13 = 0;
            } else {
                i13 = i10;
            }
            if ((i15 & 2) != 0) {
                i14 = str.length();
            } else {
                i14 = i11;
            }
            if ((i15 & 8) != 0) {
                z14 = false;
            } else {
                z14 = z10;
            }
            if ((i15 & 16) != 0) {
                z15 = false;
            } else {
                z15 = z11;
            }
            if ((i15 & 32) != 0) {
                z16 = false;
            } else {
                z16 = z12;
            }
            if ((i15 & 64) != 0) {
                z17 = false;
            } else {
                z17 = z13;
            }
            if ((i15 & 128) != 0) {
                charset2 = null;
            } else {
                charset2 = charset;
            }
            return bVar.a(str, i13, i14, str2, z14, z15, z16, z17, charset2);
        }

        private final boolean e(String str, int i10, int i11) {
            int i12 = i10 + 2;
            if (i12 >= i11 || str.charAt(i10) != '%' || d.H(str.charAt(i10 + 1)) == -1 || d.H(str.charAt(i12)) == -1) {
                return false;
            }
            return true;
        }

        public static /* synthetic */ String h(b bVar, String str, int i10, int i11, boolean z10, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = 0;
            }
            if ((i12 & 2) != 0) {
                i11 = str.length();
            }
            if ((i12 & 4) != 0) {
                z10 = false;
            }
            return bVar.g(str, i10, i11, z10);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:33:0x005f, code lost:
            if (e(r1, r5, r2) == false) goto L_0x006c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void l(okio.Buffer r15, java.lang.String r16, int r17, int r18, java.lang.String r19, boolean r20, boolean r21, boolean r22, boolean r23, java.nio.charset.Charset r24) {
            /*
                r14 = this;
                r0 = r15
                r1 = r16
                r2 = r18
                r3 = r24
                r4 = 0
                r5 = r17
                r6 = r4
            L_0x000b:
                if (r5 >= r2) goto L_0x00b9
                int r7 = r1.codePointAt(r5)
                if (r20 == 0) goto L_0x0028
                r8 = 9
                if (r7 == r8) goto L_0x0023
                r8 = 10
                if (r7 == r8) goto L_0x0023
                r8 = 12
                if (r7 == r8) goto L_0x0023
                r8 = 13
                if (r7 != r8) goto L_0x0028
            L_0x0023:
                r8 = r14
                r12 = r19
                goto L_0x00b2
            L_0x0028:
                r8 = 43
                if (r7 != r8) goto L_0x0039
                if (r22 == 0) goto L_0x0039
                if (r20 == 0) goto L_0x0033
                java.lang.String r8 = "+"
                goto L_0x0035
            L_0x0033:
                java.lang.String r8 = "%2B"
            L_0x0035:
                r15.h0(r8)
                goto L_0x0023
            L_0x0039:
                r8 = 32
                r9 = 37
                if (r7 < r8) goto L_0x0069
                r8 = 127(0x7f, float:1.78E-43)
                if (r7 == r8) goto L_0x0069
                r8 = 128(0x80, float:1.794E-43)
                if (r7 < r8) goto L_0x0049
                if (r23 == 0) goto L_0x0069
            L_0x0049:
                char r8 = (char) r7
                r10 = 0
                r11 = 2
                r12 = r19
                boolean r8 = kotlin.text.StringsKt__StringsKt.N(r12, r8, r10, r11, r4)
                if (r8 != 0) goto L_0x0067
                if (r7 != r9) goto L_0x0062
                if (r20 == 0) goto L_0x0067
                if (r21 == 0) goto L_0x0062
                r8 = r14
                boolean r10 = r14.e(r1, r5, r2)
                if (r10 != 0) goto L_0x0063
                goto L_0x006c
            L_0x0062:
                r8 = r14
            L_0x0063:
                r15.A0(r7)
                goto L_0x00b2
            L_0x0067:
                r8 = r14
                goto L_0x006c
            L_0x0069:
                r8 = r14
                r12 = r19
            L_0x006c:
                if (r6 != 0) goto L_0x0073
                okio.Buffer r6 = new okio.Buffer
                r6.<init>()
            L_0x0073:
                if (r3 == 0) goto L_0x0087
                java.nio.charset.Charset r10 = java.nio.charset.StandardCharsets.UTF_8
                boolean r10 = kotlin.jvm.internal.j.b(r3, r10)
                if (r10 == 0) goto L_0x007e
                goto L_0x0087
            L_0x007e:
                int r10 = java.lang.Character.charCount(r7)
                int r10 = r10 + r5
                r6.t0(r1, r5, r10, r3)
                goto L_0x008a
            L_0x0087:
                r6.A0(r7)
            L_0x008a:
                boolean r10 = r6.Y0()
                if (r10 != 0) goto L_0x00b2
                byte r10 = r6.readByte()
                r10 = r10 & 255(0xff, float:3.57E-43)
                r15.writeByte(r9)
                char[] r11 = okhttp3.t.f33170l
                int r13 = r10 >> 4
                r13 = r13 & 15
                char r11 = r11[r13]
                r15.writeByte(r11)
                char[] r11 = okhttp3.t.f33170l
                r10 = r10 & 15
                char r10 = r11[r10]
                r15.writeByte(r10)
                goto L_0x008a
            L_0x00b2:
                int r7 = java.lang.Character.charCount(r7)
                int r5 = r5 + r7
                goto L_0x000b
            L_0x00b9:
                r8 = r14
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.t.b.l(okio.Buffer, java.lang.String, int, int, java.lang.String, boolean, boolean, boolean, boolean, java.nio.charset.Charset):void");
        }

        private final void m(Buffer buffer, String str, int i10, int i11, boolean z10) {
            int i12;
            while (i10 < i11) {
                int codePointAt = str.codePointAt(i10);
                if (codePointAt == 37 && (i12 = i10 + 2) < i11) {
                    int H = d.H(str.charAt(i10 + 1));
                    int H2 = d.H(str.charAt(i12));
                    if (!(H == -1 || H2 == -1)) {
                        buffer.writeByte((H << 4) + H2);
                        i10 = Character.charCount(codePointAt) + i12;
                    }
                } else if (codePointAt == 43 && z10) {
                    buffer.writeByte(32);
                    i10++;
                }
                buffer.A0(codePointAt);
                i10 += Character.charCount(codePointAt);
            }
        }

        public final String a(String str, int i10, int i11, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset) {
            String str3 = str;
            int i12 = i11;
            String str4 = str2;
            j.g(str, "<this>");
            j.g(str4, "encodeSet");
            int i13 = i10;
            while (i13 < i12) {
                int codePointAt = str.codePointAt(i13);
                if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || z13) && !StringsKt__StringsKt.N(str4, (char) codePointAt, false, 2, (Object) null))) {
                    if (codePointAt == 37) {
                        if (z10) {
                            if (z11) {
                                if (!e(str, i13, i12)) {
                                    Buffer buffer = new Buffer();
                                    int i14 = i10;
                                    buffer.n0(str, i10, i13);
                                    l(buffer, str, i13, i11, str2, z10, z11, z12, z13, charset);
                                    return buffer.G();
                                }
                                if (codePointAt == 43 || !z12) {
                                    i13 += Character.charCount(codePointAt);
                                } else {
                                    Buffer buffer2 = new Buffer();
                                    int i142 = i10;
                                    buffer2.n0(str, i10, i13);
                                    l(buffer2, str, i13, i11, str2, z10, z11, z12, z13, charset);
                                    return buffer2.G();
                                }
                            }
                        }
                    }
                    if (codePointAt == 43) {
                    }
                    i13 += Character.charCount(codePointAt);
                }
                Buffer buffer22 = new Buffer();
                int i1422 = i10;
                buffer22.n0(str, i10, i13);
                l(buffer22, str, i13, i11, str2, z10, z11, z12, z13, charset);
                return buffer22.G();
            }
            int i15 = i10;
            String substring = str.substring(i10, i11);
            j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }

        public final int c(String str) {
            j.g(str, "scheme");
            if (j.b(str, "http")) {
                return 80;
            }
            if (j.b(str, "https")) {
                return 443;
            }
            return -1;
        }

        public final t d(String str) {
            j.g(str, "<this>");
            return new a().r((t) null, str).c();
        }

        public final t f(String str) {
            j.g(str, "<this>");
            try {
                return d(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final String g(String str, int i10, int i11, boolean z10) {
            j.g(str, "<this>");
            int i12 = i10;
            while (i12 < i11) {
                int i13 = i12 + 1;
                char charAt = str.charAt(i12);
                if (charAt == '%' || (charAt == '+' && z10)) {
                    Buffer buffer = new Buffer();
                    buffer.n0(str, i10, i12);
                    m(buffer, str, i12, i11, z10);
                    return buffer.G();
                }
                i12 = i13;
            }
            String substring = str.substring(i10, i11);
            j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }

        public final void i(List<String> list, StringBuilder sb2) {
            j.g(list, "<this>");
            j.g(sb2, "out");
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                sb2.append('/');
                sb2.append(list.get(i10));
            }
        }

        public final List<String> j(String str) {
            j.g(str, "<this>");
            ArrayList arrayList = new ArrayList();
            int i10 = 0;
            while (i10 <= str.length()) {
                int a02 = StringsKt__StringsKt.a0(str, '&', i10, false, 4, (Object) null);
                if (a02 == -1) {
                    a02 = str.length();
                }
                int i11 = a02;
                int a03 = StringsKt__StringsKt.a0(str, SignatureVisitor.INSTANCEOF, i10, false, 4, (Object) null);
                if (a03 == -1 || a03 > i11) {
                    String substring = str.substring(i10, i11);
                    j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(substring);
                    arrayList.add((Object) null);
                } else {
                    String substring2 = str.substring(i10, a03);
                    j.f(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(substring2);
                    String substring3 = str.substring(a03 + 1, i11);
                    j.f(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(substring3);
                }
                i10 = i11 + 1;
            }
            return arrayList;
        }

        public final void k(List<String> list, StringBuilder sb2) {
            j.g(list, "<this>");
            j.g(sb2, "out");
            kotlin.ranges.a n10 = j.n(j.o(0, list.size()), 2);
            int b10 = n10.b();
            int d10 = n10.d();
            int f10 = n10.f();
            if ((f10 > 0 && b10 <= d10) || (f10 < 0 && d10 <= b10)) {
                while (true) {
                    int i10 = b10 + f10;
                    String str = list.get(b10);
                    String str2 = list.get(b10 + 1);
                    if (b10 > 0) {
                        sb2.append('&');
                    }
                    sb2.append(str);
                    if (str2 != null) {
                        sb2.append(SignatureVisitor.INSTANCEOF);
                        sb2.append(str2);
                    }
                    if (b10 != d10) {
                        b10 = i10;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public t(String str, String str2, String str3, String str4, int i10, List<String> list, List<String> list2, String str5, String str6) {
        j.g(str, "scheme");
        j.g(str2, "username");
        j.g(str3, "password");
        j.g(str4, JingleS5BTransportCandidate.ATTR_HOST);
        j.g(list, "pathSegments");
        j.g(str6, "url");
        this.f33171a = str;
        this.f33172b = str2;
        this.f33173c = str3;
        this.f33174d = str4;
        this.f33175e = i10;
        this.f33176f = list;
        this.f33177g = list2;
        this.f33178h = str5;
        this.f33179i = str6;
        this.f33180j = j.b(str, "https");
    }

    public static final t h(String str) {
        return f33169k.d(str);
    }

    public static final t m(String str) {
        return f33169k.f(str);
    }

    public final String b() {
        if (this.f33178h == null) {
            return null;
        }
        String substring = this.f33179i.substring(StringsKt__StringsKt.a0(this.f33179i, '#', 0, false, 6, (Object) null) + 1);
        j.f(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public final String c() {
        boolean z10;
        if (this.f33173c.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return "";
        }
        String substring = this.f33179i.substring(StringsKt__StringsKt.a0(this.f33179i, ':', this.f33171a.length() + 3, false, 4, (Object) null) + 1, StringsKt__StringsKt.a0(this.f33179i, '@', 0, false, 6, (Object) null));
        j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final String d() {
        int a02 = StringsKt__StringsKt.a0(this.f33179i, '/', this.f33171a.length() + 3, false, 4, (Object) null);
        String str = this.f33179i;
        String substring = this.f33179i.substring(a02, d.q(str, "?#", a02, str.length()));
        j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final List<String> e() {
        int a02 = StringsKt__StringsKt.a0(this.f33179i, '/', this.f33171a.length() + 3, false, 4, (Object) null);
        String str = this.f33179i;
        int q10 = d.q(str, "?#", a02, str.length());
        ArrayList arrayList = new ArrayList();
        while (a02 < q10) {
            int i10 = a02 + 1;
            int p10 = d.p(this.f33179i, '/', i10, q10);
            String substring = this.f33179i.substring(i10, p10);
            j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            arrayList.add(substring);
            a02 = p10;
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        return (obj instanceof t) && j.b(((t) obj).f33179i, this.f33179i);
    }

    public final String f() {
        if (this.f33177g == null) {
            return null;
        }
        int a02 = StringsKt__StringsKt.a0(this.f33179i, '?', 0, false, 6, (Object) null) + 1;
        String str = this.f33179i;
        String substring = this.f33179i.substring(a02, d.p(str, '#', a02, str.length()));
        j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final String g() {
        boolean z10;
        if (this.f33172b.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return "";
        }
        int length = this.f33171a.length() + 3;
        String str = this.f33179i;
        String substring = this.f33179i.substring(length, d.q(str, ":@", length, str.length()));
        j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public int hashCode() {
        return this.f33179i.hashCode();
    }

    public final String i() {
        return this.f33174d;
    }

    public final boolean j() {
        return this.f33180j;
    }

    public final a k() {
        int i10;
        a aVar = new a();
        aVar.G(this.f33171a);
        aVar.D(g());
        aVar.B(c());
        aVar.E(this.f33174d);
        if (this.f33175e != f33169k.c(this.f33171a)) {
            i10 = this.f33175e;
        } else {
            i10 = -1;
        }
        aVar.F(i10);
        aVar.i().clear();
        aVar.i().addAll(e());
        aVar.e(f());
        aVar.A(b());
        return aVar;
    }

    public final a l(String str) {
        j.g(str, "link");
        try {
            return new a().r(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final List<String> n() {
        return this.f33176f;
    }

    public final int o() {
        return this.f33175e;
    }

    public final String p() {
        if (this.f33177g == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        f33169k.k(this.f33177g, sb2);
        return sb2.toString();
    }

    public final String q() {
        a l10 = l("/...");
        j.d(l10);
        return l10.H("").s("").c().toString();
    }

    public final t r(String str) {
        j.g(str, "link");
        a l10 = l(str);
        if (l10 == null) {
            return null;
        }
        return l10.c();
    }

    public final String s() {
        return this.f33171a;
    }

    public final URI t() {
        String aVar = k().x().toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e10) {
            try {
                URI create = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").f(aVar, ""));
                j.f(create, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
                return create;
            } catch (Exception unused) {
                throw new RuntimeException(e10);
            }
        }
    }

    public String toString() {
        return this.f33179i;
    }

    public final URL u() {
        try {
            return new URL(this.f33179i);
        } catch (MalformedURLException e10) {
            throw new RuntimeException(e10);
        }
    }
}
