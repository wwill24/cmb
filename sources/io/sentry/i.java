package io.sentry;

import io.sentry.util.l;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class i implements v4 {

    /* renamed from: a  reason: collision with root package name */
    private final Object f31263a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private volatile Timer f31264b = null;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, List<x1>> f31265c = new ConcurrentHashMap();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final List<d0> f31266d;

    /* renamed from: e  reason: collision with root package name */
    private final SentryOptions f31267e;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicBoolean f31268f = new AtomicBoolean(false);

    class a extends TimerTask {
        a() {
        }

        public void run() {
            for (d0 a10 : i.this.f31266d) {
                a10.a();
            }
        }
    }

    class b extends TimerTask {
        b() {
        }

        public void run() {
            x1 x1Var = new x1();
            for (d0 b10 : i.this.f31266d) {
                b10.b(x1Var);
            }
            for (List add : i.this.f31265c.values()) {
                add.add(x1Var);
            }
        }
    }

    public i(SentryOptions sentryOptions) {
        this.f31267e = (SentryOptions) l.c(sentryOptions, "The options object is required.");
        this.f31266d = sentryOptions.getCollectors();
    }

    /* renamed from: a */
    public List<x1> f(n0 n0Var) {
        List<x1> remove = this.f31265c.remove(n0Var.d().toString());
        this.f31267e.getLogger().c(SentryLevel.DEBUG, "stop collecting performance info for transactions %s (%s)", n0Var.getName(), n0Var.m().j().toString());
        if (this.f31265c.isEmpty() && this.f31268f.getAndSet(false)) {
            synchronized (this.f31263a) {
                if (this.f31264b != null) {
                    this.f31264b.cancel();
                    this.f31264b = null;
                }
            }
        }
        return remove;
    }

    public void b(n0 n0Var) {
        if (this.f31266d.isEmpty()) {
            this.f31267e.getLogger().c(SentryLevel.INFO, "No collector found. Performance stats will not be captured during transactions.", new Object[0]);
            return;
        }
        if (!this.f31265c.containsKey(n0Var.d().toString())) {
            this.f31265c.put(n0Var.d().toString(), new ArrayList());
            this.f31267e.getExecutorService().schedule(new h(this, n0Var), 30000);
        }
        if (!this.f31268f.getAndSet(true)) {
            synchronized (this.f31263a) {
                if (this.f31264b == null) {
                    this.f31264b = new Timer(true);
                }
                this.f31264b.schedule(new a(), 0);
                this.f31264b.scheduleAtFixedRate(new b(), 100, 100);
            }
        }
    }
}
