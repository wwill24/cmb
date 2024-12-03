package rd;

import com.google.android.gms.common.internal.p;
import java.util.ArrayList;
import java.util.List;
import me.f;
import rd.n;

public class n<T extends n> {

    /* renamed from: a  reason: collision with root package name */
    private final u f41867a;

    /* renamed from: b  reason: collision with root package name */
    protected final k f41868b;

    /* renamed from: c  reason: collision with root package name */
    private final List<l> f41869c = new ArrayList();

    protected n(u uVar, f fVar) {
        p.k(uVar);
        this.f41867a = uVar;
        k kVar = new k(this, fVar);
        kVar.h();
        this.f41868b = kVar;
    }

    /* access modifiers changed from: protected */
    public void a(k kVar) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public final u b() {
        return this.f41867a;
    }

    /* access modifiers changed from: protected */
    public final void c(k kVar) {
        for (l zza : this.f41869c) {
            zza.zza();
        }
    }
}
