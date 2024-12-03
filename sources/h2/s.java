package h2;

import androidx.annotation.NonNull;
import androidx.work.impl.e0;
import androidx.work.impl.v;
import b2.f;

public class s implements Runnable {

    /* renamed from: d  reason: collision with root package name */
    private static final String f15301d = f.i("StopWorkRunnable");

    /* renamed from: a  reason: collision with root package name */
    private final e0 f15302a;

    /* renamed from: b  reason: collision with root package name */
    private final v f15303b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f15304c;

    public s(@NonNull e0 e0Var, @NonNull v vVar, boolean z10) {
        this.f15302a = e0Var;
        this.f15303b = vVar;
        this.f15304c = z10;
    }

    public void run() {
        boolean z10;
        if (this.f15304c) {
            z10 = this.f15302a.l().t(this.f15303b);
        } else {
            z10 = this.f15302a.l().u(this.f15303b);
        }
        f e10 = f.e();
        String str = f15301d;
        e10.a(str, "StopWorkRunnable for " + this.f15303b.a().b() + "; Processor.stopWork = " + z10);
    }
}
