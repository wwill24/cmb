package androidx.emoji2.text;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.os.m;
import androidx.emoji2.text.e;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.lifecycle.l;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class EmojiCompatInitializer implements v1.a<Boolean> {

    static class a extends e.c {
        protected a(Context context) {
            super(new b(context));
            b(1);
        }
    }

    static class b implements e.g {

        /* renamed from: a  reason: collision with root package name */
        private final Context f5409a;

        class a extends e.h {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ e.h f5410a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ThreadPoolExecutor f5411b;

            a(e.h hVar, ThreadPoolExecutor threadPoolExecutor) {
                this.f5410a = hVar;
                this.f5411b = threadPoolExecutor;
            }

            public void a(Throwable th2) {
                try {
                    this.f5410a.a(th2);
                } finally {
                    this.f5411b.shutdown();
                }
            }

            public void b(@NonNull m mVar) {
                try {
                    this.f5410a.b(mVar);
                } finally {
                    this.f5411b.shutdown();
                }
            }
        }

        b(Context context) {
            this.f5409a = context.getApplicationContext();
        }

        public void a(@NonNull e.h hVar) {
            ThreadPoolExecutor b10 = b.b("EmojiCompatInitializer");
            b10.execute(new f(this, hVar, b10));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void d(@NonNull e.h hVar, @NonNull ThreadPoolExecutor threadPoolExecutor) {
            try {
                j a10 = c.a(this.f5409a);
                if (a10 != null) {
                    a10.c(threadPoolExecutor);
                    a10.a().a(new a(hVar, threadPoolExecutor));
                    return;
                }
                throw new RuntimeException("EmojiCompat font provider not available on this device.");
            } catch (Throwable th2) {
                hVar.a(th2);
                threadPoolExecutor.shutdown();
            }
        }
    }

    static class c implements Runnable {
        c() {
        }

        public void run() {
            try {
                m.a("EmojiCompat.EmojiCompatInitializer.run");
                if (e.h()) {
                    e.b().k();
                }
            } finally {
                m.b();
            }
        }
    }

    @NonNull
    public List<Class<? extends v1.a<?>>> a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @NonNull
    /* renamed from: c */
    public Boolean b(@NonNull Context context) {
        e.g(new a(context));
        d(context);
        return Boolean.TRUE;
    }

    /* access modifiers changed from: package-private */
    public void d(@NonNull Context context) {
        final Lifecycle lifecycle = ((l) androidx.startup.a.e(context).f(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.a(new DefaultLifecycleObserver() {
            public void onResume(@NonNull l lVar) {
                EmojiCompatInitializer.this.e();
                lifecycle.d(this);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void e() {
        b.d().postDelayed(new c(), 500);
    }
}
