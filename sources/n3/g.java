package n3;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import i3.b;
import l3.c;
import n3.h;

public class g extends f4.g<b, c<?>> implements h {

    /* renamed from: e  reason: collision with root package name */
    private h.a f16402e;

    public g(long j10) {
        super(j10);
    }

    @SuppressLint({"InlinedApi"})
    public void a(int i10) {
        if (i10 >= 40) {
            b();
        } else if (i10 >= 20 || i10 == 15) {
            m(h() / 2);
        }
    }

    public void c(@NonNull h.a aVar) {
        this.f16402e = aVar;
    }

    public /* bridge */ /* synthetic */ c d(@NonNull b bVar, c cVar) {
        return (c) super.k(bVar, cVar);
    }

    public /* bridge */ /* synthetic */ c e(@NonNull b bVar) {
        return (c) super.l(bVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public int i(c<?> cVar) {
        if (cVar == null) {
            return super.i(null);
        }
        return cVar.getSize();
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public void j(@NonNull b bVar, c<?> cVar) {
        h.a aVar = this.f16402e;
        if (aVar != null && cVar != null) {
            aVar.a(cVar);
        }
    }
}
