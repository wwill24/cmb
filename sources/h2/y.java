package h2;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.impl.WorkDatabase;
import b2.c;
import b2.f;
import g2.u;
import g2.v;
import g2.x;
import i2.b;
import java.util.UUID;

public class y implements c {

    /* renamed from: d  reason: collision with root package name */
    private static final String f15319d = f.i("WMFgUpdater");

    /* renamed from: a  reason: collision with root package name */
    private final b f15320a;

    /* renamed from: b  reason: collision with root package name */
    final androidx.work.impl.foreground.a f15321b;

    /* renamed from: c  reason: collision with root package name */
    final v f15322c;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ androidx.work.impl.utils.futures.a f15323a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UUID f15324b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b2.b f15325c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f15326d;

        a(androidx.work.impl.utils.futures.a aVar, UUID uuid, b2.b bVar, Context context) {
            this.f15323a = aVar;
            this.f15324b = uuid;
            this.f15325c = bVar;
            this.f15326d = context;
        }

        public void run() {
            try {
                if (!this.f15323a.isCancelled()) {
                    String uuid = this.f15324b.toString();
                    u h10 = y.this.f15322c.h(uuid);
                    if (h10 == null || h10.f15078b.b()) {
                        throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                    }
                    y.this.f15321b.d(uuid, this.f15325c);
                    this.f15326d.startService(androidx.work.impl.foreground.b.d(this.f15326d, x.a(h10), this.f15325c));
                }
                this.f15323a.o(null);
            } catch (Throwable th2) {
                this.f15323a.p(th2);
            }
        }
    }

    public y(@NonNull WorkDatabase workDatabase, @NonNull androidx.work.impl.foreground.a aVar, @NonNull b bVar) {
        this.f15321b = aVar;
        this.f15320a = bVar;
        this.f15322c = workDatabase.K();
    }

    @NonNull
    public zf.a<Void> a(@NonNull Context context, @NonNull UUID uuid, @NonNull b2.b bVar) {
        androidx.work.impl.utils.futures.a s10 = androidx.work.impl.utils.futures.a.s();
        this.f15320a.c(new a(s10, uuid, bVar, context));
        return s10;
    }
}
