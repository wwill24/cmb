package dl;

import bl.d;
import com.leanplum.messagetemplates.MessageTemplateConstants;
import fl.c;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import okhttp3.a0;
import okhttp3.s;
import okhttp3.y;

@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0002\u0003\u0005B\u001d\b\u0000\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n¨\u0006\u000f"}, d2 = {"Ldl/b;", "", "Lokhttp3/y;", "a", "Lokhttp3/y;", "b", "()Lokhttp3/y;", "networkRequest", "Lokhttp3/a0;", "Lokhttp3/a0;", "()Lokhttp3/a0;", "cacheResponse", "<init>", "(Lokhttp3/y;Lokhttp3/a0;)V", "c", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class b {

    /* renamed from: c  reason: collision with root package name */
    public static final a f29563c = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final y f29564a;

    /* renamed from: b  reason: collision with root package name */
    private final a0 f29565b;

    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Ldl/b$a;", "", "Lokhttp3/a0;", "response", "Lokhttp3/y;", "request", "", "a", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(a0 a0Var, y yVar) {
            j.g(a0Var, "response");
            j.g(yVar, "request");
            int f10 = a0Var.f();
            if (!(f10 == 200 || f10 == 410 || f10 == 414 || f10 == 501 || f10 == 203 || f10 == 204)) {
                if (f10 != 307) {
                    if (!(f10 == 308 || f10 == 404 || f10 == 405)) {
                        switch (f10) {
                            case MessageTemplateConstants.Values.CENTER_POPUP_WIDTH:
                            case 301:
                                break;
                            case 302:
                                break;
                            default:
                                return false;
                        }
                    }
                }
                if (a0.m(a0Var, "Expires", (String) null, 2, (Object) null) == null && a0Var.b().d() == -1 && !a0Var.b().c() && !a0Var.b().b()) {
                    return false;
                }
            }
            if (a0Var.b().i() || yVar.b().i()) {
                return false;
            }
            return true;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0006\u0010\f\u001a\u00020\u0004R\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\rR\u001a\u0010\n\u001a\u00020\t8\u0000X\u0004¢\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0019R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0016R\u0016\u0010!\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010\rR\u0016\u0010#\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010\rR\u0018\u0010%\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010\u0019R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006,"}, d2 = {"Ldl/b$b;", "", "", "f", "Ldl/b;", "c", "", "d", "a", "Lokhttp3/y;", "request", "e", "b", "J", "nowMillis", "Lokhttp3/y;", "getRequest$okhttp", "()Lokhttp3/y;", "Lokhttp3/a0;", "Lokhttp3/a0;", "cacheResponse", "Ljava/util/Date;", "Ljava/util/Date;", "servedDate", "", "Ljava/lang/String;", "servedDateString", "lastModified", "g", "lastModifiedString", "h", "expires", "i", "sentRequestMillis", "j", "receivedResponseMillis", "k", "etag", "", "l", "I", "ageSeconds", "<init>", "(JLokhttp3/y;Lokhttp3/a0;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    /* renamed from: dl.b$b  reason: collision with other inner class name */
    public static final class C0339b {

        /* renamed from: a  reason: collision with root package name */
        private final long f29566a;

        /* renamed from: b  reason: collision with root package name */
        private final y f29567b;

        /* renamed from: c  reason: collision with root package name */
        private final a0 f29568c;

        /* renamed from: d  reason: collision with root package name */
        private Date f29569d;

        /* renamed from: e  reason: collision with root package name */
        private String f29570e;

        /* renamed from: f  reason: collision with root package name */
        private Date f29571f;

        /* renamed from: g  reason: collision with root package name */
        private String f29572g;

        /* renamed from: h  reason: collision with root package name */
        private Date f29573h;

        /* renamed from: i  reason: collision with root package name */
        private long f29574i;

        /* renamed from: j  reason: collision with root package name */
        private long f29575j;

        /* renamed from: k  reason: collision with root package name */
        private String f29576k;

        /* renamed from: l  reason: collision with root package name */
        private int f29577l = -1;

        public C0339b(long j10, y yVar, a0 a0Var) {
            j.g(yVar, "request");
            this.f29566a = j10;
            this.f29567b = yVar;
            this.f29568c = a0Var;
            if (a0Var != null) {
                this.f29574i = a0Var.G();
                this.f29575j = a0Var.E();
                s n10 = a0Var.n();
                int i10 = 0;
                int size = n10.size();
                while (i10 < size) {
                    int i11 = i10 + 1;
                    String f10 = n10.f(i10);
                    String n11 = n10.n(i10);
                    if (r.t(f10, "Date", true)) {
                        this.f29569d = c.a(n11);
                        this.f29570e = n11;
                    } else if (r.t(f10, "Expires", true)) {
                        this.f29573h = c.a(n11);
                    } else if (r.t(f10, "Last-Modified", true)) {
                        this.f29571f = c.a(n11);
                        this.f29572g = n11;
                    } else if (r.t(f10, "ETag", true)) {
                        this.f29576k = n11;
                    } else if (r.t(f10, "Age", true)) {
                        this.f29577l = d.V(n11, -1);
                    }
                    i10 = i11;
                }
            }
        }

        private final long a() {
            Date date = this.f29569d;
            long j10 = 0;
            if (date != null) {
                j10 = Math.max(0, this.f29575j - date.getTime());
            }
            int i10 = this.f29577l;
            if (i10 != -1) {
                j10 = Math.max(j10, TimeUnit.SECONDS.toMillis((long) i10));
            }
            long j11 = this.f29575j;
            return j10 + (j11 - this.f29574i) + (this.f29566a - j11);
        }

        private final b c() {
            long j10;
            if (this.f29568c == null) {
                return new b(this.f29567b, (a0) null);
            }
            if (this.f29567b.f() && this.f29568c.h() == null) {
                return new b(this.f29567b, (a0) null);
            }
            if (!b.f29563c.a(this.f29568c, this.f29567b)) {
                return new b(this.f29567b, (a0) null);
            }
            okhttp3.d b10 = this.f29567b.b();
            if (b10.h() || e(this.f29567b)) {
                return new b(this.f29567b, (a0) null);
            }
            okhttp3.d b11 = this.f29568c.b();
            long a10 = a();
            long d10 = d();
            if (b10.d() != -1) {
                d10 = Math.min(d10, TimeUnit.SECONDS.toMillis((long) b10.d()));
            }
            long j11 = 0;
            if (b10.f() != -1) {
                j10 = TimeUnit.SECONDS.toMillis((long) b10.f());
            } else {
                j10 = 0;
            }
            if (!b11.g() && b10.e() != -1) {
                j11 = TimeUnit.SECONDS.toMillis((long) b10.e());
            }
            if (!b11.h()) {
                long j12 = j10 + a10;
                if (j12 < j11 + d10) {
                    a0.a x10 = this.f29568c.x();
                    if (j12 >= d10) {
                        x10.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (a10 > 86400000 && f()) {
                        x10.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new b((y) null, x10.c());
                }
            }
            String str = this.f29576k;
            String str2 = "If-Modified-Since";
            if (str != null) {
                str2 = "If-None-Match";
            } else if (this.f29571f != null) {
                str = this.f29572g;
            } else if (this.f29569d == null) {
                return new b(this.f29567b, (a0) null);
            } else {
                str = this.f29570e;
            }
            s.a j13 = this.f29567b.e().j();
            j.d(str);
            j13.d(str2, str);
            return new b(this.f29567b.h().g(j13.f()).b(), this.f29568c);
        }

        private final long d() {
            long j10;
            long j11;
            a0 a0Var = this.f29568c;
            j.d(a0Var);
            okhttp3.d b10 = a0Var.b();
            if (b10.d() != -1) {
                return TimeUnit.SECONDS.toMillis((long) b10.d());
            }
            Date date = this.f29573h;
            Long l10 = null;
            if (date != null) {
                Date date2 = this.f29569d;
                if (date2 != null) {
                    l10 = Long.valueOf(date2.getTime());
                }
                if (l10 == null) {
                    j11 = this.f29575j;
                } else {
                    j11 = l10.longValue();
                }
                long time = date.getTime() - j11;
                if (time > 0) {
                    return time;
                }
                return 0;
            } else if (this.f29571f == null || this.f29568c.F().j().p() != null) {
                return 0;
            } else {
                Date date3 = this.f29569d;
                if (date3 != null) {
                    l10 = Long.valueOf(date3.getTime());
                }
                if (l10 == null) {
                    j10 = this.f29574i;
                } else {
                    j10 = l10.longValue();
                }
                Date date4 = this.f29571f;
                j.d(date4);
                long time2 = j10 - date4.getTime();
                if (time2 > 0) {
                    return time2 / ((long) 10);
                }
                return 0;
            }
        }

        private final boolean e(y yVar) {
            return (yVar.d("If-Modified-Since") == null && yVar.d("If-None-Match") == null) ? false : true;
        }

        private final boolean f() {
            a0 a0Var = this.f29568c;
            j.d(a0Var);
            return a0Var.b().d() == -1 && this.f29573h == null;
        }

        public final b b() {
            b c10 = c();
            if (c10.b() == null || !this.f29567b.b().k()) {
                return c10;
            }
            return new b((y) null, (a0) null);
        }
    }

    public b(y yVar, a0 a0Var) {
        this.f29564a = yVar;
        this.f29565b = a0Var;
    }

    public final a0 a() {
        return this.f29565b;
    }

    public final y b() {
        return this.f29564a;
    }
}
