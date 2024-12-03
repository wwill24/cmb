package ti;

import android.view.View;
import com.google.android.material.snackbar.Snackbar;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;

public final class o {

    public static final class a extends Snackbar.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f33867a;

        a(Function0<Unit> function0) {
            this.f33867a = function0;
        }

        /* renamed from: d */
        public void a(Snackbar snackbar, int i10) {
            this.f33867a.invoke();
        }
    }

    public static final void a(View view, String str, Function0<Unit> function0, View view2, int i10, int i11) {
        j.g(view, "snackbarContainer");
        j.g(function0, "onDismissed");
        if (str != null) {
            Snackbar n02 = Snackbar.n0(view, str, i11);
            j.f(n02, "make(snackbarContainer, error, duration)");
            n02.q0(i10);
            if (view2 != null) {
                Snackbar snackbar = (Snackbar) n02.W(view2);
            }
            ((Snackbar) n02.u(new a(function0))).b0();
        }
    }

    public static /* synthetic */ void b(View view, String str, Function0 function0, View view2, int i10, int i11, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            view2 = null;
        }
        View view3 = view2;
        if ((i12 & 16) != 0) {
            i10 = 2;
        }
        int i13 = i10;
        if ((i12 & 32) != 0) {
            i11 = 0;
        }
        a(view, str, function0, view3, i13, i11);
    }
}
