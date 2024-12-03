package j7;

import com.coffeemeetsbagel.bakery.h1;
import hb.c;
import java.util.ArrayList;
import java.util.List;
import ka.a;
import okhttp3.a0;
import okhttp3.s;

public class a implements ka.a, h1.b {

    /* renamed from: a  reason: collision with root package name */
    private final c f15630a;

    /* renamed from: b  reason: collision with root package name */
    private final h1 f15631b;

    /* renamed from: c  reason: collision with root package name */
    private List<a.C0498a> f15632c = new ArrayList();

    public a(c cVar, h1 h1Var) {
        this.f15630a = cVar;
        this.f15631b = h1Var;
        h1Var.f(this);
    }

    private void d(s sVar) {
        if (sVar != null) {
            if (sVar.b("feature-cache-purge") != null) {
                e(sVar);
            }
            if (sVar.b("pagination-cache-purge") != null) {
                this.f15630a.w("KEY_PAGINATION_PURGE", sVar.b("pagination-cache-purge"));
            }
            if (sVar.b("video-topic-cache-purge") != null) {
                g(sVar);
            }
            if (sVar.b("`device-token-cache-purge`") != null) {
                this.f15630a.remove("DEVICE_TOKEN_KEY");
            }
        }
    }

    private void e(s sVar) {
        int i10;
        String r10 = this.f15630a.r("KEY_FEATURE_CACHE_PURGE");
        String b10 = sVar.b("feature-cache-purge");
        int i11 = 0;
        if (b10 != null) {
            i10 = Integer.parseInt(b10);
        } else {
            i10 = 0;
        }
        if (r10 != null) {
            i11 = Integer.parseInt(r10);
        }
        if (i10 > i11) {
            this.f15630a.w("KEY_FEATURE_CACHE_PURGE", b10);
            for (a.C0498a C : this.f15632c) {
                C.C();
            }
        }
    }

    private void f() {
        for (a.C0498a f10 : this.f15632c) {
            f10.f();
        }
    }

    private void g(s sVar) {
        int i10;
        String r10 = this.f15630a.r("KEY_TOPIC_CACHE_PURGE");
        String b10 = sVar.b("video-topic-cache-purge");
        int i11 = 0;
        if (b10 != null) {
            i10 = Integer.parseInt(b10);
        } else {
            i10 = 0;
        }
        if (r10 != null) {
            i11 = Integer.parseInt(r10);
        }
        if (i10 > i11) {
            this.f15630a.w("KEY_TOPIC_CACHE_PURGE", b10);
            for (a.C0498a c10 : this.f15632c) {
                c10.c();
            }
        }
    }

    public void P() {
    }

    public void S() {
        c();
    }

    public void a(a0 a0Var) {
        d(a0Var.n());
    }

    public void b(a.C0498a aVar) {
        if (!this.f15632c.contains(aVar)) {
            this.f15632c.add(aVar);
        }
    }

    public void c() {
        int i10;
        String r10 = this.f15630a.r("KEY_LAST_PAGINATION_PURGE");
        String r11 = this.f15630a.r("KEY_PAGINATION_PURGE");
        int i11 = 0;
        if (r10 != null) {
            i10 = Integer.parseInt(r10);
        } else {
            i10 = 0;
        }
        if (r11 != null) {
            i11 = Integer.parseInt(r11);
        }
        if (i11 > i10) {
            f();
            this.f15630a.w("KEY_LAST_PAGINATION_PURGE", r11);
        }
    }
}
