package h7;

import com.coffeemeetsbagel.models.dto.RetryCall;
import com.coffeemeetsbagel.models.dto.RetryCallPartial;
import java.util.List;
import nc.b;
import u6.m;

public class a extends b {

    /* renamed from: d  reason: collision with root package name */
    private final m f15408d;

    public a(m mVar, int i10, b bVar) {
        super(i10, bVar);
        this.f15408d = mVar;
    }

    /* access modifiers changed from: protected */
    public void d(RetryCall retryCall) {
        this.f15408d.c(retryCall);
    }

    /* access modifiers changed from: protected */
    public void e(RetryCallPartial retryCallPartial) {
        this.f15408d.a(retryCallPartial);
    }

    /* access modifiers changed from: protected */
    public List<RetryCall> g() {
        return this.f15408d.b();
    }
}
