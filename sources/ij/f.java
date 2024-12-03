package ij;

import android.content.Context;
import android.widget.TextView;
import androidx.annotation.NonNull;
import bm.d;
import ij.e;
import ij.g;
import ij.k;
import ij.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jj.a;

class f implements e.a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f29970a;

    /* renamed from: b  reason: collision with root package name */
    private final List<i> f29971b = new ArrayList(3);

    /* renamed from: c  reason: collision with root package name */
    private TextView.BufferType f29972c = TextView.BufferType.SPANNABLE;

    /* renamed from: d  reason: collision with root package name */
    private e.b f29973d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f29974e = true;

    f(@NonNull Context context) {
        this.f29970a = context;
    }

    @NonNull
    private static List<i> b(@NonNull List<i> list) {
        return new p(list).b();
    }

    @NonNull
    public e.a a(@NonNull i iVar) {
        this.f29971b.add(iVar);
        return this;
    }

    @NonNull
    public e build() {
        if (!this.f29971b.isEmpty()) {
            List<i> b10 = b(this.f29971b);
            d.b bVar = new d.b();
            a.C0363a i10 = a.i(this.f29970a);
            g.b bVar2 = new g.b();
            n.a aVar = new n.a();
            k.a aVar2 = new k.a();
            for (i next : b10) {
                next.a(bVar);
                next.f(i10);
                next.i(bVar2);
                next.j(aVar);
                next.c(aVar2);
            }
            g h10 = bVar2.h(i10.z(), aVar2.build());
            return new h(this.f29972c, this.f29973d, bVar.f(), m.b(aVar, h10), h10, Collections.unmodifiableList(b10), this.f29974e);
        }
        throw new IllegalStateException("No plugins were added to this builder. Use #usePlugin method to add them");
    }
}
