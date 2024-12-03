package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import androidx.core.view.n0;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class g extends x {

    /* renamed from: s  reason: collision with root package name */
    private static TimeInterpolator f6505s;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<RecyclerView.d0> f6506h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<RecyclerView.d0> f6507i = new ArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<j> f6508j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private ArrayList<i> f6509k = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    ArrayList<ArrayList<RecyclerView.d0>> f6510l = new ArrayList<>();

    /* renamed from: m  reason: collision with root package name */
    ArrayList<ArrayList<j>> f6511m = new ArrayList<>();

    /* renamed from: n  reason: collision with root package name */
    ArrayList<ArrayList<i>> f6512n = new ArrayList<>();

    /* renamed from: o  reason: collision with root package name */
    ArrayList<RecyclerView.d0> f6513o = new ArrayList<>();

    /* renamed from: p  reason: collision with root package name */
    ArrayList<RecyclerView.d0> f6514p = new ArrayList<>();

    /* renamed from: q  reason: collision with root package name */
    ArrayList<RecyclerView.d0> f6515q = new ArrayList<>();

    /* renamed from: r  reason: collision with root package name */
    ArrayList<RecyclerView.d0> f6516r = new ArrayList<>();

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f6517a;

        a(ArrayList arrayList) {
            this.f6517a = arrayList;
        }

        public void run() {
            Iterator it = this.f6517a.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                g.this.T(jVar.f6551a, jVar.f6552b, jVar.f6553c, jVar.f6554d, jVar.f6555e);
            }
            this.f6517a.clear();
            g.this.f6511m.remove(this.f6517a);
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f6519a;

        b(ArrayList arrayList) {
            this.f6519a = arrayList;
        }

        public void run() {
            Iterator it = this.f6519a.iterator();
            while (it.hasNext()) {
                g.this.S((i) it.next());
            }
            this.f6519a.clear();
            g.this.f6512n.remove(this.f6519a);
        }
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f6521a;

        c(ArrayList arrayList) {
            this.f6521a = arrayList;
        }

        public void run() {
            Iterator it = this.f6521a.iterator();
            while (it.hasNext()) {
                g.this.R((RecyclerView.d0) it.next());
            }
            this.f6521a.clear();
            g.this.f6510l.remove(this.f6521a);
        }
    }

    class d extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f6523a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f6524b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f6525c;

        d(RecyclerView.d0 d0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f6523a = d0Var;
            this.f6524b = viewPropertyAnimator;
            this.f6525c = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f6524b.setListener((Animator.AnimatorListener) null);
            this.f6525c.setAlpha(1.0f);
            g.this.H(this.f6523a);
            g.this.f6515q.remove(this.f6523a);
            g.this.W();
        }

        public void onAnimationStart(Animator animator) {
            g.this.I(this.f6523a);
        }
    }

    class e extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f6527a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f6528b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f6529c;

        e(RecyclerView.d0 d0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f6527a = d0Var;
            this.f6528b = view;
            this.f6529c = viewPropertyAnimator;
        }

        public void onAnimationCancel(Animator animator) {
            this.f6528b.setAlpha(1.0f);
        }

        public void onAnimationEnd(Animator animator) {
            this.f6529c.setListener((Animator.AnimatorListener) null);
            g.this.B(this.f6527a);
            g.this.f6513o.remove(this.f6527a);
            g.this.W();
        }

        public void onAnimationStart(Animator animator) {
            g.this.C(this.f6527a);
        }
    }

    class f extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f6531a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f6532b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f6533c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f6534d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f6535e;

        f(RecyclerView.d0 d0Var, int i10, View view, int i11, ViewPropertyAnimator viewPropertyAnimator) {
            this.f6531a = d0Var;
            this.f6532b = i10;
            this.f6533c = view;
            this.f6534d = i11;
            this.f6535e = viewPropertyAnimator;
        }

        public void onAnimationCancel(Animator animator) {
            if (this.f6532b != 0) {
                this.f6533c.setTranslationX(0.0f);
            }
            if (this.f6534d != 0) {
                this.f6533c.setTranslationY(0.0f);
            }
        }

        public void onAnimationEnd(Animator animator) {
            this.f6535e.setListener((Animator.AnimatorListener) null);
            g.this.F(this.f6531a);
            g.this.f6514p.remove(this.f6531a);
            g.this.W();
        }

        public void onAnimationStart(Animator animator) {
            g.this.G(this.f6531a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.g$g  reason: collision with other inner class name */
    class C0072g extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f6537a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f6538b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f6539c;

        C0072g(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f6537a = iVar;
            this.f6538b = viewPropertyAnimator;
            this.f6539c = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f6538b.setListener((Animator.AnimatorListener) null);
            this.f6539c.setAlpha(1.0f);
            this.f6539c.setTranslationX(0.0f);
            this.f6539c.setTranslationY(0.0f);
            g.this.D(this.f6537a.f6545a, true);
            g.this.f6516r.remove(this.f6537a.f6545a);
            g.this.W();
        }

        public void onAnimationStart(Animator animator) {
            g.this.E(this.f6537a.f6545a, true);
        }
    }

    class h extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f6541a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f6542b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f6543c;

        h(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f6541a = iVar;
            this.f6542b = viewPropertyAnimator;
            this.f6543c = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f6542b.setListener((Animator.AnimatorListener) null);
            this.f6543c.setAlpha(1.0f);
            this.f6543c.setTranslationX(0.0f);
            this.f6543c.setTranslationY(0.0f);
            g.this.D(this.f6541a.f6546b, false);
            g.this.f6516r.remove(this.f6541a.f6546b);
            g.this.W();
        }

        public void onAnimationStart(Animator animator) {
            g.this.E(this.f6541a.f6546b, false);
        }
    }

    private static class j {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.d0 f6551a;

        /* renamed from: b  reason: collision with root package name */
        public int f6552b;

        /* renamed from: c  reason: collision with root package name */
        public int f6553c;

        /* renamed from: d  reason: collision with root package name */
        public int f6554d;

        /* renamed from: e  reason: collision with root package name */
        public int f6555e;

        j(RecyclerView.d0 d0Var, int i10, int i11, int i12, int i13) {
            this.f6551a = d0Var;
            this.f6552b = i10;
            this.f6553c = i11;
            this.f6554d = i12;
            this.f6555e = i13;
        }
    }

    private void U(RecyclerView.d0 d0Var) {
        View view = d0Var.f6302a;
        ViewPropertyAnimator animate = view.animate();
        this.f6515q.add(d0Var);
        animate.setDuration(o()).alpha(0.0f).setListener(new d(d0Var, animate, view)).start();
    }

    private void X(List<i> list, RecyclerView.d0 d0Var) {
        for (int size = list.size() - 1; size >= 0; size--) {
            i iVar = list.get(size);
            if (Z(iVar, d0Var) && iVar.f6545a == null && iVar.f6546b == null) {
                list.remove(iVar);
            }
        }
    }

    private void Y(i iVar) {
        RecyclerView.d0 d0Var = iVar.f6545a;
        if (d0Var != null) {
            Z(iVar, d0Var);
        }
        RecyclerView.d0 d0Var2 = iVar.f6546b;
        if (d0Var2 != null) {
            Z(iVar, d0Var2);
        }
    }

    private boolean Z(i iVar, RecyclerView.d0 d0Var) {
        boolean z10 = false;
        if (iVar.f6546b == d0Var) {
            iVar.f6546b = null;
        } else if (iVar.f6545a != d0Var) {
            return false;
        } else {
            iVar.f6545a = null;
            z10 = true;
        }
        d0Var.f6302a.setAlpha(1.0f);
        d0Var.f6302a.setTranslationX(0.0f);
        d0Var.f6302a.setTranslationY(0.0f);
        D(d0Var, z10);
        return true;
    }

    private void a0(RecyclerView.d0 d0Var) {
        if (f6505s == null) {
            f6505s = new ValueAnimator().getInterpolator();
        }
        d0Var.f6302a.animate().setInterpolator(f6505s);
        j(d0Var);
    }

    @SuppressLint({"UnknownNullness"})
    public boolean A(RecyclerView.d0 d0Var) {
        a0(d0Var);
        this.f6506h.add(d0Var);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void R(RecyclerView.d0 d0Var) {
        View view = d0Var.f6302a;
        ViewPropertyAnimator animate = view.animate();
        this.f6513o.add(d0Var);
        animate.alpha(1.0f).setDuration(l()).setListener(new e(d0Var, view, animate)).start();
    }

    /* access modifiers changed from: package-private */
    public void S(i iVar) {
        View view;
        RecyclerView.d0 d0Var = iVar.f6545a;
        View view2 = null;
        if (d0Var == null) {
            view = null;
        } else {
            view = d0Var.f6302a;
        }
        RecyclerView.d0 d0Var2 = iVar.f6546b;
        if (d0Var2 != null) {
            view2 = d0Var2.f6302a;
        }
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(m());
            this.f6516r.add(iVar.f6545a);
            duration.translationX((float) (iVar.f6549e - iVar.f6547c));
            duration.translationY((float) (iVar.f6550f - iVar.f6548d));
            duration.alpha(0.0f).setListener(new C0072g(iVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            this.f6516r.add(iVar.f6546b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(m()).alpha(1.0f).setListener(new h(iVar, animate, view2)).start();
        }
    }

    /* access modifiers changed from: package-private */
    public void T(RecyclerView.d0 d0Var, int i10, int i11, int i12, int i13) {
        View view = d0Var.f6302a;
        int i14 = i12 - i10;
        int i15 = i13 - i11;
        if (i14 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i15 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.f6514p.add(d0Var);
        animate.setDuration(n()).setListener(new f(d0Var, i14, view, i15, animate)).start();
    }

    /* access modifiers changed from: package-private */
    public void V(List<RecyclerView.d0> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).f6302a.animate().cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public void W() {
        if (!p()) {
            i();
        }
    }

    public boolean g(@NonNull RecyclerView.d0 d0Var, @NonNull List<Object> list) {
        return !list.isEmpty() || super.g(d0Var, list);
    }

    @SuppressLint({"UnknownNullness"})
    public void j(RecyclerView.d0 d0Var) {
        View view = d0Var.f6302a;
        view.animate().cancel();
        int size = this.f6508j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.f6508j.get(size).f6551a == d0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                F(d0Var);
                this.f6508j.remove(size);
            }
        }
        X(this.f6509k, d0Var);
        if (this.f6506h.remove(d0Var)) {
            view.setAlpha(1.0f);
            H(d0Var);
        }
        if (this.f6507i.remove(d0Var)) {
            view.setAlpha(1.0f);
            B(d0Var);
        }
        for (int size2 = this.f6512n.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = this.f6512n.get(size2);
            X(arrayList, d0Var);
            if (arrayList.isEmpty()) {
                this.f6512n.remove(size2);
            }
        }
        for (int size3 = this.f6511m.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = this.f6511m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (((j) arrayList2.get(size4)).f6551a == d0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    F(d0Var);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f6511m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f6510l.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = this.f6510l.get(size5);
            if (arrayList3.remove(d0Var)) {
                view.setAlpha(1.0f);
                B(d0Var);
                if (arrayList3.isEmpty()) {
                    this.f6510l.remove(size5);
                }
            }
        }
        this.f6515q.remove(d0Var);
        this.f6513o.remove(d0Var);
        this.f6516r.remove(d0Var);
        this.f6514p.remove(d0Var);
        W();
    }

    public void k() {
        int size = this.f6508j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = this.f6508j.get(size);
            View view = jVar.f6551a.f6302a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            F(jVar.f6551a);
            this.f6508j.remove(size);
        }
        for (int size2 = this.f6506h.size() - 1; size2 >= 0; size2--) {
            H(this.f6506h.get(size2));
            this.f6506h.remove(size2);
        }
        int size3 = this.f6507i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.d0 d0Var = this.f6507i.get(size3);
            d0Var.f6302a.setAlpha(1.0f);
            B(d0Var);
            this.f6507i.remove(size3);
        }
        for (int size4 = this.f6509k.size() - 1; size4 >= 0; size4--) {
            Y(this.f6509k.get(size4));
        }
        this.f6509k.clear();
        if (p()) {
            for (int size5 = this.f6511m.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = this.f6511m.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    j jVar2 = (j) arrayList.get(size6);
                    View view2 = jVar2.f6551a.f6302a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    F(jVar2.f6551a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f6511m.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f6510l.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = this.f6510l.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.d0 d0Var2 = (RecyclerView.d0) arrayList2.get(size8);
                    d0Var2.f6302a.setAlpha(1.0f);
                    B(d0Var2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f6510l.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f6512n.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = this.f6512n.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    Y((i) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f6512n.remove(arrayList3);
                    }
                }
            }
            V(this.f6515q);
            V(this.f6514p);
            V(this.f6513o);
            V(this.f6516r);
            i();
        }
    }

    public boolean p() {
        if (!this.f6507i.isEmpty() || !this.f6509k.isEmpty() || !this.f6508j.isEmpty() || !this.f6506h.isEmpty() || !this.f6514p.isEmpty() || !this.f6515q.isEmpty() || !this.f6513o.isEmpty() || !this.f6516r.isEmpty() || !this.f6511m.isEmpty() || !this.f6510l.isEmpty() || !this.f6512n.isEmpty()) {
            return true;
        }
        return false;
    }

    public void v() {
        long j10;
        long j11;
        boolean z10 = !this.f6506h.isEmpty();
        boolean z11 = !this.f6508j.isEmpty();
        boolean z12 = !this.f6509k.isEmpty();
        boolean z13 = !this.f6507i.isEmpty();
        if (z10 || z11 || z13 || z12) {
            Iterator<RecyclerView.d0> it = this.f6506h.iterator();
            while (it.hasNext()) {
                U(it.next());
            }
            this.f6506h.clear();
            if (z11) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f6508j);
                this.f6511m.add(arrayList);
                this.f6508j.clear();
                a aVar = new a(arrayList);
                if (z10) {
                    n0.l0(((j) arrayList.get(0)).f6551a.f6302a, aVar, o());
                } else {
                    aVar.run();
                }
            }
            if (z12) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f6509k);
                this.f6512n.add(arrayList2);
                this.f6509k.clear();
                b bVar = new b(arrayList2);
                if (z10) {
                    n0.l0(((i) arrayList2.get(0)).f6545a.f6302a, bVar, o());
                } else {
                    bVar.run();
                }
            }
            if (z13) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.f6507i);
                this.f6510l.add(arrayList3);
                this.f6507i.clear();
                c cVar = new c(arrayList3);
                if (z10 || z11 || z12) {
                    long j12 = 0;
                    if (z10) {
                        j10 = o();
                    } else {
                        j10 = 0;
                    }
                    if (z11) {
                        j11 = n();
                    } else {
                        j11 = 0;
                    }
                    if (z12) {
                        j12 = m();
                    }
                    n0.l0(((RecyclerView.d0) arrayList3.get(0)).f6302a, cVar, j10 + Math.max(j11, j12));
                    return;
                }
                cVar.run();
            }
        }
    }

    @SuppressLint({"UnknownNullness"})
    public boolean x(RecyclerView.d0 d0Var) {
        a0(d0Var);
        d0Var.f6302a.setAlpha(0.0f);
        this.f6507i.add(d0Var);
        return true;
    }

    @SuppressLint({"UnknownNullness"})
    public boolean y(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i10, int i11, int i12, int i13) {
        if (d0Var == d0Var2) {
            return z(d0Var, i10, i11, i12, i13);
        }
        float translationX = d0Var.f6302a.getTranslationX();
        float translationY = d0Var.f6302a.getTranslationY();
        float alpha = d0Var.f6302a.getAlpha();
        a0(d0Var);
        int i14 = (int) (((float) (i12 - i10)) - translationX);
        int i15 = (int) (((float) (i13 - i11)) - translationY);
        d0Var.f6302a.setTranslationX(translationX);
        d0Var.f6302a.setTranslationY(translationY);
        d0Var.f6302a.setAlpha(alpha);
        if (d0Var2 != null) {
            a0(d0Var2);
            d0Var2.f6302a.setTranslationX((float) (-i14));
            d0Var2.f6302a.setTranslationY((float) (-i15));
            d0Var2.f6302a.setAlpha(0.0f);
        }
        this.f6509k.add(new i(d0Var, d0Var2, i10, i11, i12, i13));
        return true;
    }

    @SuppressLint({"UnknownNullness"})
    public boolean z(RecyclerView.d0 d0Var, int i10, int i11, int i12, int i13) {
        View view = d0Var.f6302a;
        int translationX = i10 + ((int) view.getTranslationX());
        int translationY = i11 + ((int) d0Var.f6302a.getTranslationY());
        a0(d0Var);
        int i14 = i12 - translationX;
        int i15 = i13 - translationY;
        if (i14 == 0 && i15 == 0) {
            F(d0Var);
            return false;
        }
        if (i14 != 0) {
            view.setTranslationX((float) (-i14));
        }
        if (i15 != 0) {
            view.setTranslationY((float) (-i15));
        }
        this.f6508j.add(new j(d0Var, translationX, translationY, i12, i13));
        return true;
    }

    private static class i {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.d0 f6545a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView.d0 f6546b;

        /* renamed from: c  reason: collision with root package name */
        public int f6547c;

        /* renamed from: d  reason: collision with root package name */
        public int f6548d;

        /* renamed from: e  reason: collision with root package name */
        public int f6549e;

        /* renamed from: f  reason: collision with root package name */
        public int f6550f;

        private i(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
            this.f6545a = d0Var;
            this.f6546b = d0Var2;
        }

        @SuppressLint({"UnknownNullness"})
        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f6545a + ", newHolder=" + this.f6546b + ", fromX=" + this.f6547c + ", fromY=" + this.f6548d + ", toX=" + this.f6549e + ", toY=" + this.f6550f + '}';
        }

        i(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i10, int i11, int i12, int i13) {
            this(d0Var, d0Var2);
            this.f6547c = i10;
            this.f6548d = i11;
            this.f6549e = i12;
            this.f6550f = i13;
        }
    }
}
