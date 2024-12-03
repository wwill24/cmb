package x1;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.core.view.n0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private static n f18459a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static ThreadLocal<WeakReference<androidx.collection.a<ViewGroup, ArrayList<n>>>> f18460b = new ThreadLocal<>();

    /* renamed from: c  reason: collision with root package name */
    static ArrayList<ViewGroup> f18461c = new ArrayList<>();

    private static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        n f18462a;

        /* renamed from: b  reason: collision with root package name */
        ViewGroup f18463b;

        /* renamed from: x1.p$a$a  reason: collision with other inner class name */
        class C0221a extends o {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ androidx.collection.a f18464a;

            C0221a(androidx.collection.a aVar) {
                this.f18464a = aVar;
            }

            public void e(@NonNull n nVar) {
                ((ArrayList) this.f18464a.get(a.this.f18463b)).remove(nVar);
                nVar.W(this);
            }
        }

        a(n nVar, ViewGroup viewGroup) {
            this.f18462a = nVar;
            this.f18463b = viewGroup;
        }

        private void a() {
            this.f18463b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f18463b.removeOnAttachStateChangeListener(this);
        }

        public boolean onPreDraw() {
            a();
            if (!p.f18461c.remove(this.f18463b)) {
                return true;
            }
            androidx.collection.a<ViewGroup, ArrayList<n>> d10 = p.d();
            ArrayList arrayList = d10.get(this.f18463b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                d10.put(this.f18463b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f18462a);
            this.f18462a.a(new C0221a(d10));
            this.f18462a.l(this.f18463b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((n) it.next()).Y(this.f18463b);
                }
            }
            this.f18462a.V(this.f18463b);
            return true;
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            a();
            p.f18461c.remove(this.f18463b);
            ArrayList arrayList = p.d().get(this.f18463b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((n) it.next()).Y(this.f18463b);
                }
            }
            this.f18462a.o(true);
        }
    }

    public static void a(@NonNull ViewGroup viewGroup, n nVar) {
        if (!f18461c.contains(viewGroup) && n0.W(viewGroup)) {
            f18461c.add(viewGroup);
            if (nVar == null) {
                nVar = f18459a;
            }
            n p10 = nVar.clone();
            g(viewGroup, p10);
            k.f(viewGroup, (k) null);
            f(viewGroup, p10);
        }
    }

    private static void b(k kVar, n nVar) {
        ViewGroup d10 = kVar.d();
        if (!f18461c.contains(d10)) {
            k c10 = k.c(d10);
            if (nVar == null) {
                if (c10 != null) {
                    c10.b();
                }
                kVar.a();
                return;
            }
            f18461c.add(d10);
            n p10 = nVar.clone();
            if (c10 != null && c10.e()) {
                p10.b0(true);
            }
            g(d10, p10);
            kVar.a();
            f(d10, p10);
        }
    }

    public static void c(ViewGroup viewGroup) {
        f18461c.remove(viewGroup);
        ArrayList arrayList = d().get(viewGroup);
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(arrayList);
            for (int size = arrayList2.size() - 1; size >= 0; size--) {
                ((n) arrayList2.get(size)).t(viewGroup);
            }
        }
    }

    static androidx.collection.a<ViewGroup, ArrayList<n>> d() {
        androidx.collection.a<ViewGroup, ArrayList<n>> aVar;
        WeakReference weakReference = f18460b.get();
        if (weakReference != null && (aVar = (androidx.collection.a) weakReference.get()) != null) {
            return aVar;
        }
        androidx.collection.a<ViewGroup, ArrayList<n>> aVar2 = new androidx.collection.a<>();
        f18460b.set(new WeakReference(aVar2));
        return aVar2;
    }

    public static void e(@NonNull k kVar, n nVar) {
        b(kVar, nVar);
    }

    private static void f(ViewGroup viewGroup, n nVar) {
        if (nVar != null && viewGroup != null) {
            a aVar = new a(nVar, viewGroup);
            viewGroup.addOnAttachStateChangeListener(aVar);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
        }
    }

    private static void g(ViewGroup viewGroup, n nVar) {
        ArrayList arrayList = d().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((n) it.next()).U(viewGroup);
            }
        }
        if (nVar != null) {
            nVar.l(viewGroup, true);
        }
        k c10 = k.c(viewGroup);
        if (c10 != null) {
            c10.b();
        }
    }
}
