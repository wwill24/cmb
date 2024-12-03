package j2;

import androidx.work.impl.workers.ConstraintTrackingWorker;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConstraintTrackingWorker f15547a;

    public /* synthetic */ a(ConstraintTrackingWorker constraintTrackingWorker) {
        this.f15547a = constraintTrackingWorker;
    }

    public final void run() {
        ConstraintTrackingWorker.s(this.f15547a);
    }
}
