package i4;

import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnit;
import com.clevertap.android.sdk.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import o4.e;
import o4.f;

public class g extends b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<k4.b> f15469a;

    /* renamed from: b  reason: collision with root package name */
    private n f15470b;

    /* renamed from: c  reason: collision with root package name */
    private o4.g f15471c;

    /* renamed from: d  reason: collision with root package name */
    private WeakReference<o> f15472d;

    /* renamed from: e  reason: collision with root package name */
    private p f15473e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public d f15474f;

    /* renamed from: g  reason: collision with root package name */
    private final CleverTapInstanceConfig f15475g;

    /* renamed from: h  reason: collision with root package name */
    private final l f15476h;

    /* renamed from: i  reason: collision with root package name */
    private m f15477i;

    /* renamed from: j  reason: collision with root package name */
    private WeakReference<c> f15478j;

    /* renamed from: k  reason: collision with root package name */
    private e f15479k;

    /* renamed from: l  reason: collision with root package name */
    private f f15480l;

    /* renamed from: m  reason: collision with root package name */
    private WeakReference<r4.b> f15481m;

    /* renamed from: n  reason: collision with root package name */
    private s4.a f15482n = null;

    /* renamed from: o  reason: collision with root package name */
    private com.clevertap.android.sdk.pushnotification.a f15483o = null;

    /* renamed from: p  reason: collision with root package name */
    private w f15484p = null;

    class a implements Runnable {
        a() {
        }

        public void run() {
            if (g.this.f15474f != null) {
                g.this.f15474f.a();
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f15486a;

        b(ArrayList arrayList) {
            this.f15486a = arrayList;
        }

        public void run() {
            if (g.this.f15469a != null && g.this.f15469a.get() != null) {
                ((k4.b) g.this.f15469a.get()).a(this.f15486a);
            }
        }
    }

    public g(CleverTapInstanceConfig cleverTapInstanceConfig, l lVar) {
        this.f15475g = cleverTapInstanceConfig;
        this.f15476h = lVar;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        d dVar = this.f15474f;
        if (dVar != null) {
            dVar.b();
        }
    }

    public void b() {
        if (this.f15474f != null) {
            x.v(new a());
        }
    }

    public m c() {
        return this.f15477i;
    }

    public c d() {
        WeakReference<c> weakReference = this.f15478j;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.f15478j.get();
    }

    public n e() {
        return this.f15470b;
    }

    public o f() {
        WeakReference<o> weakReference = this.f15472d;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.f15472d.get();
    }

    public p g() {
        return this.f15473e;
    }

    public e h() {
        return this.f15479k;
    }

    public f i() {
        return this.f15480l;
    }

    public r4.b j() {
        WeakReference<r4.b> weakReference = this.f15481m;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.f15481m.get();
    }

    public s4.a k() {
        return this.f15482n;
    }

    public com.clevertap.android.sdk.pushnotification.a l() {
        return this.f15483o;
    }

    public o4.g m() {
        return this.f15471c;
    }

    public w n() {
        return this.f15484p;
    }

    public void o(ArrayList<CleverTapDisplayUnit> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            this.f15475g.n().t(this.f15475g.e(), "DisplayUnit : No Display Units found");
            return;
        }
        WeakReference<k4.b> weakReference = this.f15469a;
        if (weakReference == null || weakReference.get() == null) {
            this.f15475g.n().t(this.f15475g.e(), "DisplayUnit : No registered listener, failed to notify");
        } else {
            x.v(new b(arrayList));
        }
    }

    public void p(String str) {
        if (str == null) {
            str = this.f15476h.x();
        }
        if (str != null) {
            try {
                w n10 = n();
                if (n10 != null) {
                    n10.b(str);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void q(m mVar) {
        this.f15477i = mVar;
    }
}
