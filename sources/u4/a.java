package u4;

import android.os.Handler;
import android.os.Looper;

public class a extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private Runnable f18015a = null;

    public a() {
        super(Looper.getMainLooper());
    }

    public Runnable a() {
        return this.f18015a;
    }

    public void b(Runnable runnable) {
        this.f18015a = runnable;
    }
}
