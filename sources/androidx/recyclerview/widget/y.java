package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class y extends RecyclerView.r {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f6718a;

    /* renamed from: b  reason: collision with root package name */
    private Scroller f6719b;

    /* renamed from: c  reason: collision with root package name */
    private final RecyclerView.t f6720c = new a();

    class a extends RecyclerView.t {

        /* renamed from: a  reason: collision with root package name */
        boolean f6721a = false;

        a() {
        }

        public void a(RecyclerView recyclerView, int i10) {
            super.a(recyclerView, i10);
            if (i10 == 0 && this.f6721a) {
                this.f6721a = false;
                y.this.j();
            }
        }

        public void b(RecyclerView recyclerView, int i10, int i11) {
            if (i10 != 0 || i11 != 0) {
                this.f6721a = true;
            }
        }
    }

    private void e() {
        this.f6718a.j1(this.f6720c);
        this.f6718a.setOnFlingListener((RecyclerView.r) null);
    }

    private void h() throws IllegalStateException {
        if (this.f6718a.getOnFlingListener() == null) {
            this.f6718a.l(this.f6720c);
            this.f6718a.setOnFlingListener(this);
            return;
        }
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    private boolean i(@NonNull RecyclerView.o oVar, int i10, int i11) {
        RecyclerView.y d10;
        int g10;
        if (!(oVar instanceof RecyclerView.y.b) || (d10 = d(oVar)) == null || (g10 = g(oVar, i10, i11)) == -1) {
            return false;
        }
        d10.p(g10);
        oVar.K1(d10);
        return true;
    }

    public boolean a(int i10, int i11) {
        RecyclerView.o layoutManager = this.f6718a.getLayoutManager();
        if (layoutManager == null || this.f6718a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f6718a.getMinFlingVelocity();
        if ((Math.abs(i11) > minFlingVelocity || Math.abs(i10) > minFlingVelocity) && i(layoutManager, i10, i11)) {
            return true;
        }
        return false;
    }

    public void b(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.f6718a;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                e();
            }
            this.f6718a = recyclerView;
            if (recyclerView != null) {
                h();
                this.f6719b = new Scroller(this.f6718a.getContext(), new DecelerateInterpolator());
                j();
            }
        }
    }

    public abstract int[] c(@NonNull RecyclerView.o oVar, @NonNull View view);

    /* access modifiers changed from: protected */
    public abstract RecyclerView.y d(@NonNull RecyclerView.o oVar);

    @SuppressLint({"UnknownNullness"})
    public abstract View f(RecyclerView.o oVar);

    @SuppressLint({"UnknownNullness"})
    public abstract int g(RecyclerView.o oVar, int i10, int i11);

    /* access modifiers changed from: package-private */
    public void j() {
        RecyclerView.o layoutManager;
        View f10;
        RecyclerView recyclerView = this.f6718a;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null && (f10 = f(layoutManager)) != null) {
            int[] c10 = c(layoutManager, f10);
            int i10 = c10[0];
            if (i10 != 0 || c10[1] != 0) {
                this.f6718a.x1(i10, c10[1]);
            }
        }
    }
}
