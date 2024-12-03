package ce;

import android.content.Context;
import androidx.loader.content.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.internal.r;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public final class e extends a implements r {

    /* renamed from: p  reason: collision with root package name */
    private final Semaphore f34058p = new Semaphore(0);

    /* renamed from: q  reason: collision with root package name */
    private final Set f34059q;

    public e(Context context, Set set) {
        super(context);
        this.f34059q = set;
    }

    public final /* bridge */ /* synthetic */ Object B() {
        int i10 = 0;
        for (d o10 : this.f34059q) {
            if (o10.o(this)) {
                i10++;
            }
        }
        try {
            this.f34058p.tryAcquire(i10, 5, TimeUnit.SECONDS);
            return null;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    public final void onComplete() {
        this.f34058p.release();
    }

    /* access modifiers changed from: protected */
    public final void p() {
        this.f34058p.drainPermits();
        h();
    }
}
