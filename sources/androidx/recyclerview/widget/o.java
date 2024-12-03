package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

class o {

    /* renamed from: a  reason: collision with root package name */
    boolean f6686a = true;

    /* renamed from: b  reason: collision with root package name */
    int f6687b;

    /* renamed from: c  reason: collision with root package name */
    int f6688c;

    /* renamed from: d  reason: collision with root package name */
    int f6689d;

    /* renamed from: e  reason: collision with root package name */
    int f6690e;

    /* renamed from: f  reason: collision with root package name */
    int f6691f = 0;

    /* renamed from: g  reason: collision with root package name */
    int f6692g = 0;

    /* renamed from: h  reason: collision with root package name */
    boolean f6693h;

    /* renamed from: i  reason: collision with root package name */
    boolean f6694i;

    o() {
    }

    /* access modifiers changed from: package-private */
    public boolean a(RecyclerView.z zVar) {
        int i10 = this.f6688c;
        return i10 >= 0 && i10 < zVar.b();
    }

    /* access modifiers changed from: package-private */
    public View b(RecyclerView.v vVar) {
        View o10 = vVar.o(this.f6688c);
        this.f6688c += this.f6689d;
        return o10;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f6687b + ", mCurrentPosition=" + this.f6688c + ", mItemDirection=" + this.f6689d + ", mLayoutDirection=" + this.f6690e + ", mStartLine=" + this.f6691f + ", mEndLine=" + this.f6692g + '}';
    }
}
