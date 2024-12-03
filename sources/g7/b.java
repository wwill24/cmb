package g7;

import com.coffeemeetsbagel.match.h;
import com.coffeemeetsbagel.match.u;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.responses.ResponseBagels;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import retrofit2.d;
import retrofit2.r;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f15198a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f15199b;

    /* renamed from: c  reason: collision with root package name */
    private final String f15200c;

    /* renamed from: d  reason: collision with root package name */
    private final String f15201d;

    /* renamed from: e  reason: collision with root package name */
    private final u f15202e;

    /* renamed from: f  reason: collision with root package name */
    private final h f15203f;

    /* renamed from: g  reason: collision with root package name */
    private String f15204g;

    /* renamed from: h  reason: collision with root package name */
    private String f15205h;

    /* renamed from: i  reason: collision with root package name */
    private List<Bagel> f15206i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    private boolean f15207j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f15208k;

    /* renamed from: l  reason: collision with root package name */
    private Set<String> f15209l = new HashSet();

    class a implements d<ResponseBagels> {
        a() {
        }

        public void onFailure(retrofit2.b<ResponseBagels> bVar, Throwable th2) {
            String str;
            b.this.c();
            if (th2 == null) {
                str = "Unknown exception fetching bagels.";
            } else {
                str = th2.getMessage();
            }
            fa.a.f("NewBagelsPager", str);
            b.this.b();
        }

        public void onResponse(retrofit2.b<ResponseBagels> bVar, r<ResponseBagels> rVar) {
            if (rVar.g()) {
                b.this.d(rVar.a());
            } else {
                b.this.c();
            }
        }
    }

    public b(boolean z10, boolean z11, String str, String str2, u uVar, h hVar) {
        this.f15198a = z10;
        this.f15199b = z11;
        this.f15201d = str;
        this.f15202e = uVar;
        this.f15203f = hVar;
        this.f15200c = str2;
    }

    /* access modifiers changed from: private */
    public void b() {
        this.f15203f.a(this.f15204g, this.f15206i);
    }

    private void e() {
        if (this.f15207j) {
            this.f15202e.a(this.f15198a, this.f15199b, this.f15205h, this.f15200c, this.f15201d).L(new a());
        } else {
            b();
        }
    }

    public void c() {
        b();
    }

    public void d(ResponseBagels responseBagels) {
        for (Bagel next : responseBagels.getResults()) {
            if (!this.f15209l.contains(next.getProfileId())) {
                this.f15206i.add(next);
                this.f15209l.add(next.getProfileId());
            }
        }
        if (!this.f15208k) {
            this.f15208k = true;
            this.f15204g = responseBagels.getCurrentToken();
        }
        this.f15205h = responseBagels.getCursorBefore();
        this.f15207j = responseBagels.isMoreBefore();
        e();
    }

    public void f() {
        this.f15207j = true;
        e();
    }
}
