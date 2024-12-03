package r;

import android.util.Size;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import q.l;
import q.n;

public class d {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final String f17215a;

    public d(@NonNull String str) {
        this.f17215a = str;
    }

    @NonNull
    public List<Size> a(int i10) {
        n nVar = (n) l.a(n.class);
        if (nVar == null) {
            return new ArrayList();
        }
        return nVar.b(this.f17215a, i10);
    }
}
