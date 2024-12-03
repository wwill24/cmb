package b6;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import b6.q;

public abstract class e<R extends q> extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    protected R f7852a;

    /* renamed from: b  reason: collision with root package name */
    protected ViewGroup f7853b;

    /* access modifiers changed from: protected */
    public abstract int A0();

    public boolean B0() {
        R r10 = this.f7852a;
        return r10 != null && r10.h();
    }

    public void onDestroy() {
        super.onDestroy();
        R r10 = this.f7852a;
        if (r10 != null) {
            r10.d();
        }
        this.f7852a = null;
    }

    public void onStart() {
        View l10;
        super.onStart();
        if (getView() == null) {
            throw new IllegalStateException("No view found for fragment");
        } else if (this.f7853b == null || this.f7852a == null) {
            ViewGroup viewGroup = (ViewGroup) getView().findViewById(A0());
            this.f7853b = viewGroup;
            R z02 = z0(viewGroup);
            this.f7852a = z02;
            if ((z02 instanceof u) && (l10 = ((u) z02).l()) != null) {
                this.f7853b.removeAllViews();
                this.f7853b.addView(l10);
            }
            this.f7852a.c();
        }
    }

    /* access modifiers changed from: protected */
    public abstract R z0(ViewGroup viewGroup);
}
