package x1;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import x1.n;

public class r extends n {
    private ArrayList<n> Q = new ArrayList<>();
    private boolean R = true;
    int S;
    boolean T = false;
    private int U = 0;

    class a extends o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f18484a;

        a(n nVar) {
            this.f18484a = nVar;
        }

        public void e(@NonNull n nVar) {
            this.f18484a.a0();
            nVar.W(this);
        }
    }

    static class b extends o {

        /* renamed from: a  reason: collision with root package name */
        r f18486a;

        b(r rVar) {
            this.f18486a = rVar;
        }

        public void c(@NonNull n nVar) {
            r rVar = this.f18486a;
            if (!rVar.T) {
                rVar.j0();
                this.f18486a.T = true;
            }
        }

        public void e(@NonNull n nVar) {
            r rVar = this.f18486a;
            int i10 = rVar.S - 1;
            rVar.S = i10;
            if (i10 == 0) {
                rVar.T = false;
                rVar.s();
            }
            nVar.W(this);
        }
    }

    private void o0(@NonNull n nVar) {
        this.Q.add(nVar);
        nVar.f18447x = this;
    }

    private void x0() {
        b bVar = new b(this);
        Iterator<n> it = this.Q.iterator();
        while (it.hasNext()) {
            it.next().a(bVar);
        }
        this.S = this.Q.size();
    }

    public void U(View view) {
        super.U(view);
        int size = this.Q.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.Q.get(i10).U(view);
        }
    }

    public void Y(View view) {
        super.Y(view);
        int size = this.Q.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.Q.get(i10).Y(view);
        }
    }

    /* access modifiers changed from: protected */
    public void a0() {
        if (this.Q.isEmpty()) {
            j0();
            s();
            return;
        }
        x0();
        if (!this.R) {
            for (int i10 = 1; i10 < this.Q.size(); i10++) {
                this.Q.get(i10 - 1).a(new a(this.Q.get(i10)));
            }
            n nVar = this.Q.get(0);
            if (nVar != null) {
                nVar.a0();
                return;
            }
            return;
        }
        Iterator<n> it = this.Q.iterator();
        while (it.hasNext()) {
            it.next().a0();
        }
    }

    /* access modifiers changed from: package-private */
    public void b0(boolean z10) {
        super.b0(z10);
        int size = this.Q.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.Q.get(i10).b0(z10);
        }
    }

    /* access modifiers changed from: protected */
    public void cancel() {
        super.cancel();
        int size = this.Q.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.Q.get(i10).cancel();
        }
    }

    public void d0(n.e eVar) {
        super.d0(eVar);
        this.U |= 8;
        int size = this.Q.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.Q.get(i10).d0(eVar);
        }
    }

    public void g0(g gVar) {
        super.g0(gVar);
        this.U |= 4;
        if (this.Q != null) {
            for (int i10 = 0; i10 < this.Q.size(); i10++) {
                this.Q.get(i10).g0(gVar);
            }
        }
    }

    public void h(@NonNull u uVar) {
        if (M(uVar.f18493b)) {
            Iterator<n> it = this.Q.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next.M(uVar.f18493b)) {
                    next.h(uVar);
                    uVar.f18494c.add(next);
                }
            }
        }
    }

    public void h0(q qVar) {
        super.h0(qVar);
        this.U |= 2;
        int size = this.Q.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.Q.get(i10).h0(qVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void j(u uVar) {
        super.j(uVar);
        int size = this.Q.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.Q.get(i10).j(uVar);
        }
    }

    public void k(@NonNull u uVar) {
        if (M(uVar.f18493b)) {
            Iterator<n> it = this.Q.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next.M(uVar.f18493b)) {
                    next.k(uVar);
                    uVar.f18494c.add(next);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String k0(String str) {
        String k02 = super.k0(str);
        for (int i10 = 0; i10 < this.Q.size(); i10++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(k02);
            sb2.append("\n");
            sb2.append(this.Q.get(i10).k0(str + "  "));
            k02 = sb2.toString();
        }
        return k02;
    }

    @NonNull
    /* renamed from: l0 */
    public r a(@NonNull n.f fVar) {
        return (r) super.a(fVar);
    }

    @NonNull
    /* renamed from: m0 */
    public r b(@NonNull View view) {
        for (int i10 = 0; i10 < this.Q.size(); i10++) {
            this.Q.get(i10).b(view);
        }
        return (r) super.b(view);
    }

    @NonNull
    public r n0(@NonNull n nVar) {
        o0(nVar);
        long j10 = this.f18432c;
        if (j10 >= 0) {
            nVar.c0(j10);
        }
        if ((this.U & 1) != 0) {
            nVar.f0(x());
        }
        if ((this.U & 2) != 0) {
            nVar.h0(B());
        }
        if ((this.U & 4) != 0) {
            nVar.g0(A());
        }
        if ((this.U & 8) != 0) {
            nVar.d0(w());
        }
        return this;
    }

    /* renamed from: p */
    public n clone() {
        r rVar = (r) super.clone();
        rVar.Q = new ArrayList<>();
        int size = this.Q.size();
        for (int i10 = 0; i10 < size; i10++) {
            rVar.o0(this.Q.get(i10).clone());
        }
        return rVar;
    }

    public n p0(int i10) {
        if (i10 < 0 || i10 >= this.Q.size()) {
            return null;
        }
        return this.Q.get(i10);
    }

    public int q0() {
        return this.Q.size();
    }

    /* access modifiers changed from: protected */
    public void r(ViewGroup viewGroup, v vVar, v vVar2, ArrayList<u> arrayList, ArrayList<u> arrayList2) {
        long D = D();
        int size = this.Q.size();
        for (int i10 = 0; i10 < size; i10++) {
            n nVar = this.Q.get(i10);
            if (D > 0 && (this.R || i10 == 0)) {
                long D2 = nVar.D();
                if (D2 > 0) {
                    nVar.i0(D2 + D);
                } else {
                    nVar.i0(D);
                }
            }
            nVar.r(viewGroup, vVar, vVar2, arrayList, arrayList2);
        }
    }

    @NonNull
    /* renamed from: r0 */
    public r W(@NonNull n.f fVar) {
        return (r) super.W(fVar);
    }

    @NonNull
    /* renamed from: s0 */
    public r X(@NonNull View view) {
        for (int i10 = 0; i10 < this.Q.size(); i10++) {
            this.Q.get(i10).X(view);
        }
        return (r) super.X(view);
    }

    /* access modifiers changed from: package-private */
    public void t(ViewGroup viewGroup) {
        super.t(viewGroup);
        int size = this.Q.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.Q.get(i10).t(viewGroup);
        }
    }

    @NonNull
    /* renamed from: t0 */
    public r c0(long j10) {
        ArrayList<n> arrayList;
        super.c0(j10);
        if (this.f18432c >= 0 && (arrayList = this.Q) != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.Q.get(i10).c0(j10);
            }
        }
        return this;
    }

    @NonNull
    /* renamed from: u0 */
    public r f0(TimeInterpolator timeInterpolator) {
        this.U |= 1;
        ArrayList<n> arrayList = this.Q;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.Q.get(i10).f0(timeInterpolator);
            }
        }
        return (r) super.f0(timeInterpolator);
    }

    @NonNull
    public r v0(int i10) {
        if (i10 == 0) {
            this.R = true;
        } else if (i10 == 1) {
            this.R = false;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i10);
        }
        return this;
    }

    @NonNull
    /* renamed from: w0 */
    public r i0(long j10) {
        return (r) super.i0(j10);
    }
}
