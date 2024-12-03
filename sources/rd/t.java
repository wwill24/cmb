package rd;

import android.os.Process;

final class t extends Thread {
    t(Runnable runnable, String str) {
        super(runnable, str);
    }

    public final void run() {
        Process.setThreadPriority(10);
        super.run();
    }
}
