package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

public class g0 {

    /* renamed from: a  reason: collision with root package name */
    private int f4826a;

    /* renamed from: b  reason: collision with root package name */
    private int f4827b;

    public g0(@NonNull ViewGroup viewGroup) {
    }

    public int a() {
        return this.f4826a | this.f4827b;
    }

    public void b(@NonNull View view, @NonNull View view2, int i10) {
        c(view, view2, i10, 0);
    }

    public void c(@NonNull View view, @NonNull View view2, int i10, int i11) {
        if (i11 == 1) {
            this.f4827b = i10;
        } else {
            this.f4826a = i10;
        }
    }

    public void d(@NonNull View view, int i10) {
        if (i10 == 1) {
            this.f4827b = 0;
        } else {
            this.f4826a = 0;
        }
    }
}
