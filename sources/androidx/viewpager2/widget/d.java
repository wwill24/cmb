package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

final class d extends ViewPager2.i {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayoutManager f7300a;

    /* renamed from: b  reason: collision with root package name */
    private ViewPager2.k f7301b;

    d(LinearLayoutManager linearLayoutManager) {
        this.f7300a = linearLayoutManager;
    }

    public void a(int i10) {
    }

    public void b(int i10, float f10, int i11) {
        if (this.f7301b != null) {
            float f11 = -f10;
            int i12 = 0;
            while (i12 < this.f7300a.K()) {
                View J = this.f7300a.J(i12);
                if (J != null) {
                    this.f7301b.a(J, ((float) (this.f7300a.i0(J) - i10)) + f11);
                    i12++;
                } else {
                    throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", new Object[]{Integer.valueOf(i12), Integer.valueOf(this.f7300a.K())}));
                }
            }
        }
    }

    public void c(int i10) {
    }

    /* access modifiers changed from: package-private */
    public ViewPager2.k d() {
        return this.f7301b;
    }

    /* access modifiers changed from: package-private */
    public void e(ViewPager2.k kVar) {
        this.f7301b = kVar;
    }
}
