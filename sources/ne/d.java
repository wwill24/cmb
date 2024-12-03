package ne;

import android.os.Process;

final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f41310a;

    public d(Runnable runnable, int i10) {
        this.f41310a = runnable;
    }

    public final void run() {
        Process.setThreadPriority(0);
        this.f41310a.run();
    }
}
