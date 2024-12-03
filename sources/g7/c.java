package g7;

import com.coffeemeetsbagel.match.i;
import com.coffeemeetsbagel.match.u;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.responses.ResponseBagels;
import java.util.ArrayList;
import java.util.List;
import retrofit2.b;
import retrofit2.d;
import retrofit2.r;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f15211a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f15212b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f15213c;

    /* renamed from: d  reason: collision with root package name */
    private final int f15214d;

    /* renamed from: e  reason: collision with root package name */
    private final u f15215e;

    /* renamed from: f  reason: collision with root package name */
    private final i f15216f;

    /* renamed from: g  reason: collision with root package name */
    private int f15217g;

    /* renamed from: h  reason: collision with root package name */
    private String f15218h;

    /* renamed from: i  reason: collision with root package name */
    private String f15219i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f15220j;

    /* renamed from: k  reason: collision with root package name */
    private final List<Bagel> f15221k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final String f15222l = c.class.getSimpleName();

    class a implements d<ResponseBagels> {
        a() {
        }

        public void onFailure(b<ResponseBagels> bVar, Throwable th2) {
            String str;
            c.this.c();
            String a10 = c.this.f15222l;
            if (th2 == null) {
                str = "Unknown exception fetching bagels.";
            } else {
                str = th2.getMessage();
            }
            fa.a.f(a10, str);
        }

        public void onResponse(b<ResponseBagels> bVar, r<ResponseBagels> rVar) {
            if (rVar.g()) {
                c.this.d(rVar.a());
            } else {
                c.this.c();
            }
        }
    }

    public c(boolean z10, int i10, String str, String str2, boolean z11, boolean z12, boolean z13, u uVar, i iVar) {
        this.f15211a = z10;
        this.f15220j = z11;
        this.f15214d = i10;
        this.f15218h = str;
        this.f15219i = str2;
        this.f15212b = z12;
        this.f15213c = z13;
        this.f15215e = uVar;
        this.f15216f = iVar;
        this.f15221k = new ArrayList();
    }

    private void b() {
        this.f15216f.a(this.f15217g, this.f15218h, this.f15219i, this.f15220j, this.f15221k);
    }

    private void e() {
        boolean z10;
        if (this.f15211a || this.f15217g < this.f15214d) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!this.f15220j || !z10) {
            b();
        } else {
            this.f15215e.e(this.f15212b, this.f15213c, this.f15218h).L(new a());
        }
    }

    public void c() {
        b();
    }

    public void d(ResponseBagels responseBagels) {
        this.f15221k.addAll(responseBagels.getResults());
        this.f15220j = responseBagels.isMoreBefore();
        this.f15218h = responseBagels.getCursorBefore();
        if (this.f15219i == null && this.f15217g == 0) {
            this.f15219i = responseBagels.getCurrentToken();
        }
        this.f15217g++;
        e();
    }

    public void f() {
        e();
    }
}
