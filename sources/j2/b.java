package j2;

import androidx.work.impl.workers.ConstraintTrackingWorker;
import zf.a;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConstraintTrackingWorker f15548a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f15549b;

    public /* synthetic */ b(ConstraintTrackingWorker constraintTrackingWorker, a aVar) {
        this.f15548a = constraintTrackingWorker;
        this.f15549b = aVar;
    }

    public final void run() {
        ConstraintTrackingWorker.r(this.f15548a, this.f15549b);
    }
}
