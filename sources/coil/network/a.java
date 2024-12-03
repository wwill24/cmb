package coil.network;

import coil.util.Time;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.stetho.server.http.HttpHeaders;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import okhttp3.a0;
import okhttp3.d;
import okhttp3.s;
import okhttp3.y;

@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0002\u0003\u0005B\u001d\b\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n¨\u0006\u000f"}, d2 = {"Lcoil/network/a;", "", "Lokhttp3/y;", "a", "Lokhttp3/y;", "b", "()Lokhttp3/y;", "networkRequest", "Lcoil/network/CacheResponse;", "Lcoil/network/CacheResponse;", "()Lcoil/network/CacheResponse;", "cacheResponse", "<init>", "(Lokhttp3/y;Lcoil/network/CacheResponse;)V", "c", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static final C0105a f8236c = new C0105a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final y f8237a;

    /* renamed from: b  reason: collision with root package name */
    private final CacheResponse f8238b;

    @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\fJ\u0016\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e¨\u0006\u0014"}, d2 = {"Lcoil/network/a$a;", "", "", "name", "", "e", "d", "Lokhttp3/y;", "request", "Lokhttp3/a0;", "response", "c", "Lcoil/network/CacheResponse;", "b", "Lokhttp3/s;", "cachedHeaders", "networkHeaders", "a", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: coil.network.a$a  reason: collision with other inner class name */
    public static final class C0105a {
        private C0105a() {
        }

        public /* synthetic */ C0105a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean d(String str) {
            if (r.t(HttpHeaders.CONTENT_LENGTH, str, true) || r.t("Content-Encoding", str, true) || r.t(HttpHeaders.CONTENT_TYPE, str, true)) {
                return true;
            }
            return false;
        }

        private final boolean e(String str) {
            if (r.t("Connection", str, true) || r.t("Keep-Alive", str, true) || r.t("Proxy-Authenticate", str, true) || r.t("Proxy-Authorization", str, true) || r.t("TE", str, true) || r.t("Trailers", str, true) || r.t("Transfer-Encoding", str, true) || r.t("Upgrade", str, true)) {
                return false;
            }
            return true;
        }

        public final s a(s sVar, s sVar2) {
            s.a aVar = new s.a();
            int size = sVar.size();
            for (int i10 = 0; i10 < size; i10++) {
                String f10 = sVar.f(i10);
                String n10 = sVar.n(i10);
                if ((!r.t("Warning", f10, true) || !r.J(n10, AppEventsConstants.EVENT_PARAM_VALUE_YES, false, 2, (Object) null)) && (d(f10) || !e(f10) || sVar2.b(f10) == null)) {
                    aVar.a(f10, n10);
                }
            }
            int size2 = sVar2.size();
            for (int i11 = 0; i11 < size2; i11++) {
                String f11 = sVar2.f(i11);
                if (!d(f11) && e(f11)) {
                    aVar.a(f11, sVar2.n(i11));
                }
            }
            return aVar.f();
        }

        public final boolean b(y yVar, CacheResponse cacheResponse) {
            if (yVar.b().i() || cacheResponse.a().i() || j.b(cacheResponse.d().b("Vary"), "*")) {
                return false;
            }
            return true;
        }

        public final boolean c(y yVar, a0 a0Var) {
            if (yVar.b().i() || a0Var.b().i() || j.b(a0Var.n().b("Vary"), "*")) {
                return false;
            }
            return true;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000bR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0010R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0010R\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010\u0013R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcoil/network/a$b;", "", "", "c", "a", "Lokhttp3/y;", "request", "", "d", "Lcoil/network/a;", "b", "Lokhttp3/y;", "Lcoil/network/CacheResponse;", "Lcoil/network/CacheResponse;", "cacheResponse", "Ljava/util/Date;", "Ljava/util/Date;", "servedDate", "", "Ljava/lang/String;", "servedDateString", "e", "lastModified", "f", "lastModifiedString", "g", "expires", "h", "J", "sentRequestMillis", "i", "receivedResponseMillis", "j", "etag", "", "k", "I", "ageSeconds", "<init>", "(Lokhttp3/y;Lcoil/network/CacheResponse;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final y f8239a;

        /* renamed from: b  reason: collision with root package name */
        private final CacheResponse f8240b;

        /* renamed from: c  reason: collision with root package name */
        private Date f8241c;

        /* renamed from: d  reason: collision with root package name */
        private String f8242d;

        /* renamed from: e  reason: collision with root package name */
        private Date f8243e;

        /* renamed from: f  reason: collision with root package name */
        private String f8244f;

        /* renamed from: g  reason: collision with root package name */
        private Date f8245g;

        /* renamed from: h  reason: collision with root package name */
        private long f8246h;

        /* renamed from: i  reason: collision with root package name */
        private long f8247i;

        /* renamed from: j  reason: collision with root package name */
        private String f8248j;

        /* renamed from: k  reason: collision with root package name */
        private int f8249k = -1;

        public b(y yVar, CacheResponse cacheResponse) {
            this.f8239a = yVar;
            this.f8240b = cacheResponse;
            if (cacheResponse != null) {
                this.f8246h = cacheResponse.e();
                this.f8247i = cacheResponse.c();
                s d10 = cacheResponse.d();
                int size = d10.size();
                for (int i10 = 0; i10 < size; i10++) {
                    String f10 = d10.f(i10);
                    if (r.t(f10, "Date", true)) {
                        this.f8241c = d10.d("Date");
                        this.f8242d = d10.n(i10);
                    } else if (r.t(f10, "Expires", true)) {
                        this.f8245g = d10.d("Expires");
                    } else if (r.t(f10, "Last-Modified", true)) {
                        this.f8243e = d10.d("Last-Modified");
                        this.f8244f = d10.n(i10);
                    } else if (r.t(f10, "ETag", true)) {
                        this.f8248j = d10.n(i10);
                    } else if (r.t(f10, "Age", true)) {
                        this.f8249k = coil.util.j.z(d10.n(i10), -1);
                    }
                }
            }
        }

        private final long a() {
            Date date = this.f8241c;
            long j10 = 0;
            if (date != null) {
                j10 = Math.max(0, this.f8247i - date.getTime());
            }
            int i10 = this.f8249k;
            if (i10 != -1) {
                j10 = Math.max(j10, TimeUnit.SECONDS.toMillis((long) i10));
            }
            return j10 + (this.f8247i - this.f8246h) + (Time.f8420a.a() - this.f8247i);
        }

        private final long c() {
            long j10;
            long j11;
            CacheResponse cacheResponse = this.f8240b;
            j.d(cacheResponse);
            d a10 = cacheResponse.a();
            if (a10.d() != -1) {
                return TimeUnit.SECONDS.toMillis((long) a10.d());
            }
            Date date = this.f8245g;
            if (date != null) {
                Date date2 = this.f8241c;
                if (date2 != null) {
                    j11 = date2.getTime();
                } else {
                    j11 = this.f8247i;
                }
                long time = date.getTime() - j11;
                if (time > 0) {
                    return time;
                }
                return 0;
            } else if (this.f8243e == null || this.f8239a.j().p() != null) {
                return 0;
            } else {
                Date date3 = this.f8241c;
                if (date3 != null) {
                    j10 = date3.getTime();
                } else {
                    j10 = this.f8246h;
                }
                Date date4 = this.f8243e;
                j.d(date4);
                long time2 = j10 - date4.getTime();
                if (time2 > 0) {
                    return time2 / ((long) 10);
                }
                return 0;
            }
        }

        private final boolean d(y yVar) {
            if (yVar.d("If-Modified-Since") == null && yVar.d("If-None-Match") == null) {
                return false;
            }
            return true;
        }

        public final a b() {
            long j10;
            if (this.f8240b == null) {
                return new a(this.f8239a, (CacheResponse) null, (DefaultConstructorMarker) null);
            }
            if (this.f8239a.f() && !this.f8240b.f()) {
                return new a(this.f8239a, (CacheResponse) null, (DefaultConstructorMarker) null);
            }
            d a10 = this.f8240b.a();
            if (!a.f8236c.b(this.f8239a, this.f8240b)) {
                return new a(this.f8239a, (CacheResponse) null, (DefaultConstructorMarker) null);
            }
            d b10 = this.f8239a.b();
            if (b10.h() || d(this.f8239a)) {
                return new a(this.f8239a, (CacheResponse) null, (DefaultConstructorMarker) null);
            }
            long a11 = a();
            long c10 = c();
            if (b10.d() != -1) {
                c10 = Math.min(c10, TimeUnit.SECONDS.toMillis((long) b10.d()));
            }
            long j11 = 0;
            if (b10.f() != -1) {
                j10 = TimeUnit.SECONDS.toMillis((long) b10.f());
            } else {
                j10 = 0;
            }
            if (!a10.g() && b10.e() != -1) {
                j11 = TimeUnit.SECONDS.toMillis((long) b10.e());
            }
            if (!a10.h() && a11 + j10 < c10 + j11) {
                return new a((y) null, this.f8240b, (DefaultConstructorMarker) null);
            }
            String str = this.f8248j;
            String str2 = "If-Modified-Since";
            if (str != null) {
                j.d(str);
                str2 = "If-None-Match";
            } else if (this.f8243e != null) {
                str = this.f8244f;
                j.d(str);
            } else if (this.f8241c == null) {
                return new a(this.f8239a, (CacheResponse) null, (DefaultConstructorMarker) null);
            } else {
                str = this.f8242d;
                j.d(str);
            }
            return new a(this.f8239a.h().a(str2, str).b(), this.f8240b, (DefaultConstructorMarker) null);
        }
    }

    private a(y yVar, CacheResponse cacheResponse) {
        this.f8237a = yVar;
        this.f8238b = cacheResponse;
    }

    public /* synthetic */ a(y yVar, CacheResponse cacheResponse, DefaultConstructorMarker defaultConstructorMarker) {
        this(yVar, cacheResponse);
    }

    public final CacheResponse a() {
        return this.f8238b;
    }

    public final y b() {
        return this.f8237a;
    }
}
