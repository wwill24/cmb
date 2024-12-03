package t2;

import android.graphics.Path;
import c3.j;
import java.util.ArrayList;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final List<u> f17666a = new ArrayList();

    /* access modifiers changed from: package-private */
    public void a(u uVar) {
        this.f17666a.add(uVar);
    }

    public void b(Path path) {
        for (int size = this.f17666a.size() - 1; size >= 0; size--) {
            j.b(path, this.f17666a.get(size));
        }
    }
}
