package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.d;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class m {

    /* renamed from: g  reason: collision with root package name */
    static int f3895g;

    /* renamed from: a  reason: collision with root package name */
    ArrayList<ConstraintWidget> f3896a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    int f3897b;

    /* renamed from: c  reason: collision with root package name */
    boolean f3898c = false;

    /* renamed from: d  reason: collision with root package name */
    int f3899d;

    /* renamed from: e  reason: collision with root package name */
    ArrayList<a> f3900e = null;

    /* renamed from: f  reason: collision with root package name */
    private int f3901f = -1;

    class a {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<ConstraintWidget> f3902a;

        /* renamed from: b  reason: collision with root package name */
        int f3903b;

        /* renamed from: c  reason: collision with root package name */
        int f3904c;

        /* renamed from: d  reason: collision with root package name */
        int f3905d;

        /* renamed from: e  reason: collision with root package name */
        int f3906e;

        /* renamed from: f  reason: collision with root package name */
        int f3907f;

        /* renamed from: g  reason: collision with root package name */
        int f3908g;

        public a(ConstraintWidget constraintWidget, d dVar, int i10) {
            this.f3902a = new WeakReference<>(constraintWidget);
            this.f3903b = dVar.x(constraintWidget.O);
            this.f3904c = dVar.x(constraintWidget.P);
            this.f3905d = dVar.x(constraintWidget.Q);
            this.f3906e = dVar.x(constraintWidget.R);
            this.f3907f = dVar.x(constraintWidget.S);
            this.f3908g = i10;
        }
    }

    public m(int i10) {
        int i11 = f3895g;
        f3895g = i11 + 1;
        this.f3897b = i11;
        this.f3899d = i10;
    }

    private String e() {
        int i10 = this.f3899d;
        return i10 == 0 ? "Horizontal" : i10 == 1 ? "Vertical" : i10 == 2 ? "Both" : "Unknown";
    }

    private int j(d dVar, ArrayList<ConstraintWidget> arrayList, int i10) {
        int x10;
        int x11;
        androidx.constraintlayout.core.widgets.d dVar2 = (androidx.constraintlayout.core.widgets.d) arrayList.get(0).K();
        dVar.D();
        dVar2.g(dVar, false);
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            arrayList.get(i11).g(dVar, false);
        }
        if (i10 == 0 && dVar2.W0 > 0) {
            b.b(dVar2, dVar, arrayList, 0);
        }
        if (i10 == 1 && dVar2.X0 > 0) {
            b.b(dVar2, dVar, arrayList, 1);
        }
        try {
            dVar.z();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        this.f3900e = new ArrayList<>();
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            this.f3900e.add(new a(arrayList.get(i12), dVar, i10));
        }
        if (i10 == 0) {
            x10 = dVar.x(dVar2.O);
            x11 = dVar.x(dVar2.Q);
            dVar.D();
        } else {
            x10 = dVar.x(dVar2.P);
            x11 = dVar.x(dVar2.R);
            dVar.D();
        }
        return x11 - x10;
    }

    public boolean a(ConstraintWidget constraintWidget) {
        if (this.f3896a.contains(constraintWidget)) {
            return false;
        }
        this.f3896a.add(constraintWidget);
        return true;
    }

    public void b(ArrayList<m> arrayList) {
        int size = this.f3896a.size();
        if (this.f3901f != -1 && size > 0) {
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                m mVar = arrayList.get(i10);
                if (this.f3901f == mVar.f3897b) {
                    g(this.f3899d, mVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public int c() {
        return this.f3897b;
    }

    public int d() {
        return this.f3899d;
    }

    public int f(d dVar, int i10) {
        if (this.f3896a.size() == 0) {
            return 0;
        }
        return j(dVar, this.f3896a, i10);
    }

    public void g(int i10, m mVar) {
        Iterator<ConstraintWidget> it = this.f3896a.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            mVar.a(next);
            if (i10 == 0) {
                next.I0 = mVar.c();
            } else {
                next.J0 = mVar.c();
            }
        }
        this.f3901f = mVar.f3897b;
    }

    public void h(boolean z10) {
        this.f3898c = z10;
    }

    public void i(int i10) {
        this.f3899d = i10;
    }

    public String toString() {
        String str = e() + " [" + this.f3897b + "] <";
        Iterator<ConstraintWidget> it = this.f3896a.iterator();
        while (it.hasNext()) {
            str = str + " " + it.next().t();
        }
        return str + " >";
    }
}
