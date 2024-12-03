package h2;

import androidx.annotation.NonNull;
import androidx.work.WorkerParameters;
import androidx.work.impl.e0;
import androidx.work.impl.v;

public class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private e0 f15298a;

    /* renamed from: b  reason: collision with root package name */
    private v f15299b;

    /* renamed from: c  reason: collision with root package name */
    private WorkerParameters.a f15300c;

    public r(@NonNull e0 e0Var, @NonNull v vVar, WorkerParameters.a aVar) {
        this.f15298a = e0Var;
        this.f15299b = vVar;
        this.f15300c = aVar;
    }

    public void run() {
        this.f15298a.l().q(this.f15299b, this.f15300c);
    }
}
