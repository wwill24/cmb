package com.google.android.gms.common.api.internal;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import java.util.concurrent.Executor;

public final class k<L> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f38648a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f38649b;

    /* renamed from: c  reason: collision with root package name */
    private volatile a f38650c;

    public static final class a<L> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f38651a;

        /* renamed from: b  reason: collision with root package name */
        private final String f38652b;

        a(L l10, String str) {
            this.f38651a = l10;
            this.f38652b = str;
        }

        @NonNull
        public String a() {
            String str = this.f38652b;
            int identityHashCode = System.identityHashCode(this.f38651a);
            return str + "@" + identityHashCode;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f38651a != aVar.f38651a || !this.f38652b.equals(aVar.f38652b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f38651a) * 31) + this.f38652b.hashCode();
        }
    }

    public interface b<L> {
        void notifyListener(@NonNull L l10);

        void onNotifyListenerFailed();
    }

    k(@NonNull Looper looper, @NonNull L l10, @NonNull String str) {
        this.f38648a = new ne.a(looper);
        this.f38649b = p.l(l10, "Listener must not be null");
        this.f38650c = new a(l10, p.g(str));
    }

    public void a() {
        this.f38649b = null;
        this.f38650c = null;
    }

    public a<L> b() {
        return this.f38650c;
    }

    public void c(@NonNull b<? super L> bVar) {
        p.l(bVar, "Notifier must not be null");
        this.f38648a.execute(new x1(this, bVar));
    }

    /* access modifiers changed from: package-private */
    public final void d(b bVar) {
        Object obj = this.f38649b;
        if (obj == null) {
            bVar.onNotifyListenerFailed();
            return;
        }
        try {
            bVar.notifyListener(obj);
        } catch (RuntimeException e10) {
            bVar.onNotifyListenerFailed();
            throw e10;
        }
    }

    k(@NonNull Executor executor, @NonNull L l10, @NonNull String str) {
        this.f38648a = (Executor) p.l(executor, "Executor must not be null");
        this.f38649b = p.l(l10, "Listener must not be null");
        this.f38650c = new a(l10, p.g(str));
    }
}
