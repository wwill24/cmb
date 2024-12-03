package x1;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.os.e;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.e0;
import java.util.ArrayList;
import java.util.List;
import x1.n;

@SuppressLint({"RestrictedApi"})
public class e extends e0 {

    class a extends n.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Rect f18397a;

        a(Rect rect) {
            this.f18397a = rect;
        }

        public Rect a(@NonNull n nVar) {
            return this.f18397a;
        }
    }

    class b implements n.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f18399a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f18400b;

        b(View view, ArrayList arrayList) {
            this.f18399a = view;
            this.f18400b = arrayList;
        }

        public void a(@NonNull n nVar) {
        }

        public void b(@NonNull n nVar) {
        }

        public void c(@NonNull n nVar) {
            nVar.W(this);
            nVar.a(this);
        }

        public void d(@NonNull n nVar) {
        }

        public void e(@NonNull n nVar) {
            nVar.W(this);
            this.f18399a.setVisibility(8);
            int size = this.f18400b.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((View) this.f18400b.get(i10)).setVisibility(0);
            }
        }
    }

    class c extends o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f18402a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f18403b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f18404c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList f18405d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Object f18406e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ArrayList f18407f;

        c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f18402a = obj;
            this.f18403b = arrayList;
            this.f18404c = obj2;
            this.f18405d = arrayList2;
            this.f18406e = obj3;
            this.f18407f = arrayList3;
        }

        public void c(@NonNull n nVar) {
            Object obj = this.f18402a;
            if (obj != null) {
                e.this.w(obj, this.f18403b, (ArrayList<View>) null);
            }
            Object obj2 = this.f18404c;
            if (obj2 != null) {
                e.this.w(obj2, this.f18405d, (ArrayList<View>) null);
            }
            Object obj3 = this.f18406e;
            if (obj3 != null) {
                e.this.w(obj3, this.f18407f, (ArrayList<View>) null);
            }
        }

        public void e(@NonNull n nVar) {
            nVar.W(this);
        }
    }

    class d implements e.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f18409a;

        d(n nVar) {
            this.f18409a = nVar;
        }

        public void onCancel() {
            this.f18409a.cancel();
        }
    }

    /* renamed from: x1.e$e  reason: collision with other inner class name */
    class C0220e implements n.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f18411a;

        C0220e(Runnable runnable) {
            this.f18411a = runnable;
        }

        public void a(@NonNull n nVar) {
        }

        public void b(@NonNull n nVar) {
        }

        public void c(@NonNull n nVar) {
        }

        public void d(@NonNull n nVar) {
        }

        public void e(@NonNull n nVar) {
            this.f18411a.run();
        }
    }

    class f extends n.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Rect f18413a;

        f(Rect rect) {
            this.f18413a = rect;
        }

        public Rect a(@NonNull n nVar) {
            Rect rect = this.f18413a;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.f18413a;
        }
    }

    private static boolean v(n nVar) {
        if (!e0.i(nVar.E()) || !e0.i(nVar.F()) || !e0.i(nVar.G())) {
            return true;
        }
        return false;
    }

    public void a(Object obj, View view) {
        if (obj != null) {
            ((n) obj).b(view);
        }
    }

    public void b(Object obj, ArrayList<View> arrayList) {
        n nVar = (n) obj;
        if (nVar != null) {
            int i10 = 0;
            if (nVar instanceof r) {
                r rVar = (r) nVar;
                int q02 = rVar.q0();
                while (i10 < q02) {
                    b(rVar.p0(i10), arrayList);
                    i10++;
                }
            } else if (!v(nVar) && e0.i(nVar.H())) {
                int size = arrayList.size();
                while (i10 < size) {
                    nVar.b(arrayList.get(i10));
                    i10++;
                }
            }
        }
    }

    public void c(ViewGroup viewGroup, Object obj) {
        p.a(viewGroup, (n) obj);
    }

    public boolean e(Object obj) {
        return obj instanceof n;
    }

    public Object f(Object obj) {
        if (obj != null) {
            return ((n) obj).clone();
        }
        return null;
    }

    public Object j(Object obj, Object obj2, Object obj3) {
        n nVar = (n) obj;
        n nVar2 = (n) obj2;
        n nVar3 = (n) obj3;
        if (nVar != null && nVar2 != null) {
            nVar = new r().n0(nVar).n0(nVar2).v0(1);
        } else if (nVar == null) {
            if (nVar2 != null) {
                nVar = nVar2;
            } else {
                nVar = null;
            }
        }
        if (nVar3 == null) {
            return nVar;
        }
        r rVar = new r();
        if (nVar != null) {
            rVar.n0(nVar);
        }
        rVar.n0(nVar3);
        return rVar;
    }

    public Object k(Object obj, Object obj2, Object obj3) {
        r rVar = new r();
        if (obj != null) {
            rVar.n0((n) obj);
        }
        if (obj2 != null) {
            rVar.n0((n) obj2);
        }
        if (obj3 != null) {
            rVar.n0((n) obj3);
        }
        return rVar;
    }

    public void m(Object obj, View view, ArrayList<View> arrayList) {
        ((n) obj).a(new b(view, arrayList));
    }

    public void n(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((n) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    public void o(Object obj, Rect rect) {
        if (obj != null) {
            ((n) obj).d0(new f(rect));
        }
    }

    public void p(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            h(view, rect);
            ((n) obj).d0(new a(rect));
        }
    }

    public void q(@NonNull Fragment fragment, @NonNull Object obj, @NonNull androidx.core.os.e eVar, @NonNull Runnable runnable) {
        n nVar = (n) obj;
        eVar.b(new d(nVar));
        nVar.a(new C0220e(runnable));
    }

    public void s(Object obj, View view, ArrayList<View> arrayList) {
        r rVar = (r) obj;
        List<View> H = rVar.H();
        H.clear();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            e0.d(H, arrayList.get(i10));
        }
        H.add(view);
        arrayList.add(view);
        b(rVar, arrayList);
    }

    public void t(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        r rVar = (r) obj;
        if (rVar != null) {
            rVar.H().clear();
            rVar.H().addAll(arrayList2);
            w(rVar, arrayList, arrayList2);
        }
    }

    public Object u(Object obj) {
        if (obj == null) {
            return null;
        }
        r rVar = new r();
        rVar.n0((n) obj);
        return rVar;
    }

    public void w(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        int i10;
        n nVar = (n) obj;
        int i11 = 0;
        if (nVar instanceof r) {
            r rVar = (r) nVar;
            int q02 = rVar.q0();
            while (i11 < q02) {
                w(rVar.p0(i11), arrayList, arrayList2);
                i11++;
            }
        } else if (!v(nVar)) {
            List<View> H = nVar.H();
            if (H.size() == arrayList.size() && H.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    i10 = 0;
                } else {
                    i10 = arrayList2.size();
                }
                while (i11 < i10) {
                    nVar.b(arrayList2.get(i11));
                    i11++;
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    nVar.X(arrayList.get(size));
                }
            }
        }
    }
}
