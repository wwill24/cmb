package o9;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.Objects;

public class f extends HandlerThread {

    /* renamed from: a  reason: collision with root package name */
    private final a f16841a;

    /* renamed from: b  reason: collision with root package name */
    private long f16842b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f16843c;

    /* renamed from: d  reason: collision with root package name */
    private Handler f16844d;

    public interface a {
        void g0();

        void l0(long j10);
    }

    public f(a aVar) {
        super("TodayTimerThread");
        this.f16841a = aVar;
    }

    /* access modifiers changed from: private */
    public boolean d(Message message) {
        int i10 = message.what;
        if (i10 == 1) {
            e();
            return true;
        } else if (i10 == 2) {
            this.f16843c.removeMessages(1);
            this.f16842b = ((Long) message.obj).longValue();
            this.f16843c.obtainMessage(1).sendToTarget();
            return true;
        } else {
            throw new UnsupportedOperationException("Unrecognized message type: " + message.what);
        }
    }

    private void e() {
        long currentTimeMillis = this.f16842b - System.currentTimeMillis();
        if (currentTimeMillis < 1000) {
            Handler handler = this.f16844d;
            a aVar = this.f16841a;
            Objects.requireNonNull(aVar);
            handler.post(new d(aVar));
            return;
        }
        this.f16844d.post(new e(this, currentTimeMillis));
        Handler handler2 = this.f16843c;
        handler2.sendMessageDelayed(handler2.obtainMessage(1), 1000);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(long j10) {
        this.f16841a.l0(j10);
    }

    public void c() {
        this.f16843c.removeMessages(1);
    }

    public void g(long j10) {
        if (this.f16843c == null) {
            this.f16843c = new Handler(getLooper(), new c(this));
        }
        if (this.f16844d == null) {
            this.f16844d = new Handler(Looper.getMainLooper());
        }
        this.f16843c.obtainMessage(2, Long.valueOf(j10)).sendToTarget();
    }
}
