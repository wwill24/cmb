package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public final class b implements r {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final RecyclerView.Adapter f6469a;

    public b(@NonNull RecyclerView.Adapter adapter) {
        this.f6469a = adapter;
    }

    public void a(int i10, int i11) {
        this.f6469a.r(i10, i11);
    }

    public void b(int i10, int i11) {
        this.f6469a.s(i10, i11);
    }

    @SuppressLint({"UnknownNullness"})
    public void c(int i10, int i11, Object obj) {
        this.f6469a.q(i10, i11, obj);
    }

    public void d(int i10, int i11) {
        this.f6469a.o(i10, i11);
    }
}
