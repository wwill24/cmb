package bo;

import android.annotation.TargetApi;
import android.content.Context;
import android.widget.OverScroller;

@TargetApi(9)
public class a extends c {

    /* renamed from: a  reason: collision with root package name */
    protected final OverScroller f42250a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f42251b = false;

    public a(Context context) {
        this.f42250a = new OverScroller(context);
    }

    public void b(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
        this.f42250a.fling(i10, i11, i12, i13, i14, i15, i16, i17, i18, i19);
    }

    public void c(boolean z10) {
        this.f42250a.forceFinished(z10);
    }

    public int d() {
        return this.f42250a.getCurrX();
    }

    public int e() {
        return this.f42250a.getCurrY();
    }

    public boolean g() {
        return this.f42250a.isFinished();
    }
}
