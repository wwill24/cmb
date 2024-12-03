package b9;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import b9.a;
import com.coffeemeetsbagel.models.ReportMetadata;
import com.coffeemeetsbagel.models.enums.EventType;
import com.coffeemeetsbagel.utils.model.Optional;
import com.jakewharton.rxrelay2.b;
import java.util.ArrayList;
import java.util.List;
import z9.f;

public class c implements a, f {

    /* renamed from: a  reason: collision with root package name */
    private final y7.a f7887a;

    /* renamed from: b  reason: collision with root package name */
    private final a6.a f7888b;

    /* renamed from: c  reason: collision with root package name */
    private List<ReportMetadata> f7889c;

    /* renamed from: d  reason: collision with root package name */
    private List<a.C0090a> f7890d;

    /* renamed from: e  reason: collision with root package name */
    private com.jakewharton.rxrelay2.c<Optional<Integer>> f7891e = b.D0(Optional.a());

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7892a;

        static {
            int[] iArr = new int[EventType.values().length];
            f7892a = iArr;
            try {
                iArr[EventType.SYNC_COMPLETE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public c(y7.a aVar, a6.a aVar2) {
        this.f7887a = aVar;
        this.f7888b = aVar2;
        this.f7889c = new ArrayList();
        this.f7890d = new ArrayList();
        aVar.c(this, EventType.SYNC_COMPLETE);
        e();
    }

    /* access modifiers changed from: private */
    public void e() {
        this.f7891e.accept(Optional.b(Integer.valueOf(d())));
        for (a.C0090a u10 : this.f7890d) {
            u10.u();
        }
    }

    public void a(a.C0090a aVar) {
        this.f7890d.remove(aVar);
    }

    public void b(a.C0090a aVar) {
        if (!this.f7890d.contains(aVar)) {
            this.f7890d.add(aVar);
        }
    }

    public int d() {
        return this.f7888b.a("tip_report") ^ true ? 1 : 0;
    }

    public void n0(EventType eventType, Bundle bundle) {
        if (a.f7892a[eventType.ordinal()] == 1) {
            new Handler(Looper.getMainLooper()).post(new b(this));
        }
    }
}
