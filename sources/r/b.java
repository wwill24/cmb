package r;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.r1;
import q.k;
import q.l;
import q.s;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f17211a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f17212b;

    public b(@NonNull r1 r1Var) {
        boolean z10;
        this.f17211a = r1Var.a(s.class);
        if (l.a(k.class) != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f17212b = z10;
    }

    public int a(int i10) {
        if ((this.f17211a || this.f17212b) && i10 == 2) {
            return 1;
        }
        return i10;
    }
}
