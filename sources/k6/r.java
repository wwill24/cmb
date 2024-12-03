package k6;

import a1.a;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.coffeemeetsbagel.R;

public class r extends q {
    private static final ViewDataBinding.i I = null;
    private static final SparseIntArray J;
    @NonNull
    private final LinearLayout G;
    private long H;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        J = sparseIntArray;
        sparseIntArray.put(R.id.my_profile_edit_value, 2);
    }

    public r(f fVar, @NonNull View view) {
        this(fVar, view, ViewDataBinding.w(fVar, view, 3, I, J));
    }

    public void G(String str) {
        this.F = str;
        synchronized (this) {
            this.H |= 1;
        }
        a(1);
        super.A();
    }

    /* access modifiers changed from: protected */
    public void i() {
        long j10;
        synchronized (this) {
            j10 = this.H;
            this.H = 0;
        }
        String str = this.F;
        if ((j10 & 3) != 0) {
            a.b(this.D, str);
        }
    }

    public boolean p() {
        synchronized (this) {
            if (this.H != 0) {
                return true;
            }
            return false;
        }
    }

    public void r() {
        synchronized (this) {
            this.H = 2;
        }
        A();
    }

    private r(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, objArr[1], objArr[2]);
        this.H = -1;
        LinearLayout linearLayout = objArr[0];
        this.G = linearLayout;
        linearLayout.setTag((Object) null);
        this.D.setTag((Object) null);
        D(view);
        r();
    }
}
