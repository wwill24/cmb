package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private final DataSetObservable f7223a = new DataSetObservable();

    /* renamed from: b  reason: collision with root package name */
    private DataSetObserver f7224b;

    @Deprecated
    public void a(@NonNull View view, int i10, @NonNull Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void b(@NonNull ViewGroup viewGroup, int i10, @NonNull Object obj) {
        a(viewGroup, i10, obj);
    }

    @Deprecated
    public void c(@NonNull View view) {
    }

    public void d(@NonNull ViewGroup viewGroup) {
        c(viewGroup);
    }

    public abstract int e();

    public int f(@NonNull Object obj) {
        return -1;
    }

    public CharSequence g(int i10) {
        return null;
    }

    public float h(int i10) {
        return 1.0f;
    }

    @NonNull
    public abstract Object i(@NonNull ViewGroup viewGroup, int i10);

    public abstract boolean j(@NonNull View view, @NonNull Object obj);

    public void k() {
        synchronized (this) {
            DataSetObserver dataSetObserver = this.f7224b;
            if (dataSetObserver != null) {
                dataSetObserver.onChanged();
            }
        }
        this.f7223a.notifyChanged();
    }

    public void l(@NonNull DataSetObserver dataSetObserver) {
        this.f7223a.registerObserver(dataSetObserver);
    }

    public void m(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable n() {
        return null;
    }

    @Deprecated
    public void o(@NonNull View view, int i10, @NonNull Object obj) {
    }

    public void p(@NonNull ViewGroup viewGroup, int i10, @NonNull Object obj) {
        o(viewGroup, i10, obj);
    }

    /* access modifiers changed from: package-private */
    public void q(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f7224b = dataSetObserver;
        }
    }

    @Deprecated
    public void r(@NonNull View view) {
    }

    public void s(@NonNull ViewGroup viewGroup) {
        r(viewGroup);
    }

    public void t(@NonNull DataSetObserver dataSetObserver) {
        this.f7223a.unregisterObserver(dataSetObserver);
    }
}
