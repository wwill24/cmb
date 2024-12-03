package fl;

import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import okhttp3.a0;
import okhttp3.i;
import okhttp3.internal.connection.c;
import okhttp3.internal.connection.e;
import okhttp3.u;
import okhttp3.y;

@Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0011\u001a\u00020\u0015\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b*\u0010+JM\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000b\u0010\fJ\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001a\u0010\u0011\u001a\u00020\u00158\u0000X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001dR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0000X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010\u0007\u001a\u00020\u00068\u0000X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010\b\u001a\u00020\u00028\u0000X\u0004¢\u0006\f\n\u0004\b%\u0010\u001d\u001a\u0004\b%\u0010&R\u001a\u0010\t\u001a\u00020\u00028\u0000X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b'\u0010&R\u001a\u0010\n\u001a\u00020\u00028\u0000X\u0004¢\u0006\f\n\u0004\b \u0010\u001d\u001a\u0004\b(\u0010&R\u0016\u0010)\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010\u001d¨\u0006,"}, d2 = {"Lfl/g;", "Lokhttp3/u$a;", "", "index", "Lokhttp3/internal/connection/c;", "exchange", "Lokhttp3/y;", "request", "connectTimeoutMillis", "readTimeoutMillis", "writeTimeoutMillis", "c", "(ILokhttp3/internal/connection/c;Lokhttp3/y;III)Lfl/g;", "Lokhttp3/i;", "b", "l", "Lokhttp3/e;", "call", "g", "Lokhttp3/a0;", "a", "Lokhttp3/internal/connection/e;", "Lokhttp3/internal/connection/e;", "e", "()Lokhttp3/internal/connection/e;", "", "Lokhttp3/u;", "Ljava/util/List;", "interceptors", "I", "d", "Lokhttp3/internal/connection/c;", "h", "()Lokhttp3/internal/connection/c;", "Lokhttp3/y;", "j", "()Lokhttp3/y;", "f", "()I", "i", "k", "calls", "<init>", "(Lokhttp3/internal/connection/e;Ljava/util/List;ILokhttp3/internal/connection/c;Lokhttp3/y;III)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class g implements u.a {

    /* renamed from: a  reason: collision with root package name */
    private final e f29662a;

    /* renamed from: b  reason: collision with root package name */
    private final List<u> f29663b;

    /* renamed from: c  reason: collision with root package name */
    private final int f29664c;

    /* renamed from: d  reason: collision with root package name */
    private final c f29665d;

    /* renamed from: e  reason: collision with root package name */
    private final y f29666e;

    /* renamed from: f  reason: collision with root package name */
    private final int f29667f;

    /* renamed from: g  reason: collision with root package name */
    private final int f29668g;

    /* renamed from: h  reason: collision with root package name */
    private final int f29669h;

    /* renamed from: i  reason: collision with root package name */
    private int f29670i;

    public g(e eVar, List<? extends u> list, int i10, c cVar, y yVar, int i11, int i12, int i13) {
        j.g(eVar, "call");
        j.g(list, "interceptors");
        j.g(yVar, "request");
        this.f29662a = eVar;
        this.f29663b = list;
        this.f29664c = i10;
        this.f29665d = cVar;
        this.f29666e = yVar;
        this.f29667f = i11;
        this.f29668g = i12;
        this.f29669h = i13;
    }

    public static /* synthetic */ g d(g gVar, int i10, c cVar, y yVar, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = gVar.f29664c;
        }
        if ((i14 & 2) != 0) {
            cVar = gVar.f29665d;
        }
        c cVar2 = cVar;
        if ((i14 & 4) != 0) {
            yVar = gVar.f29666e;
        }
        y yVar2 = yVar;
        if ((i14 & 8) != 0) {
            i11 = gVar.f29667f;
        }
        int i15 = i11;
        if ((i14 & 16) != 0) {
            i12 = gVar.f29668g;
        }
        int i16 = i12;
        if ((i14 & 32) != 0) {
            i13 = gVar.f29669h;
        }
        return gVar.c(i10, cVar2, yVar2, i15, i16, i13);
    }

    public a0 a(y yVar) throws IOException {
        boolean z10;
        boolean z11;
        boolean z12;
        j.g(yVar, "request");
        boolean z13 = false;
        if (this.f29664c < this.f29663b.size()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f29670i++;
            c cVar = this.f29665d;
            if (cVar != null) {
                if (cVar.j().g(yVar.j())) {
                    if (this.f29670i == 1) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (!z12) {
                        throw new IllegalStateException(("network interceptor " + this.f29663b.get(this.f29664c - 1) + " must call proceed() exactly once").toString());
                    }
                } else {
                    throw new IllegalStateException(("network interceptor " + this.f29663b.get(this.f29664c - 1) + " must retain the same host and port").toString());
                }
            }
            g d10 = d(this, this.f29664c + 1, (c) null, yVar, 0, 0, 0, 58, (Object) null);
            u uVar = this.f29663b.get(this.f29664c);
            a0 intercept = uVar.intercept(d10);
            if (intercept != null) {
                if (this.f29665d != null) {
                    if (this.f29664c + 1 >= this.f29663b.size() || d10.f29670i == 1) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (!z11) {
                        throw new IllegalStateException(("network interceptor " + uVar + " must call proceed() exactly once").toString());
                    }
                }
                if (intercept.a() != null) {
                    z13 = true;
                }
                if (z13) {
                    return intercept;
                }
                throw new IllegalStateException(("interceptor " + uVar + " returned a response with no body").toString());
            }
            throw new NullPointerException("interceptor " + uVar + " returned null");
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public i b() {
        c cVar = this.f29665d;
        if (cVar == null) {
            return null;
        }
        return cVar.h();
    }

    public final g c(int i10, c cVar, y yVar, int i11, int i12, int i13) {
        j.g(yVar, "request");
        return new g(this.f29662a, this.f29663b, i10, cVar, yVar, i11, i12, i13);
    }

    public okhttp3.e call() {
        return this.f29662a;
    }

    public final e e() {
        return this.f29662a;
    }

    public final int f() {
        return this.f29667f;
    }

    public y g() {
        return this.f29666e;
    }

    public final c h() {
        return this.f29665d;
    }

    public final int i() {
        return this.f29668g;
    }

    public final y j() {
        return this.f29666e;
    }

    public final int k() {
        return this.f29669h;
    }

    public int l() {
        return this.f29668g;
    }
}
