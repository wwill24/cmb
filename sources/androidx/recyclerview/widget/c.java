package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.h;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class c<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f6470a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Executor f6471b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final h.f<T> f6472c;

    public static final class a<T> {

        /* renamed from: d  reason: collision with root package name */
        private static final Object f6473d = new Object();

        /* renamed from: e  reason: collision with root package name */
        private static Executor f6474e;

        /* renamed from: a  reason: collision with root package name */
        private Executor f6475a;

        /* renamed from: b  reason: collision with root package name */
        private Executor f6476b;

        /* renamed from: c  reason: collision with root package name */
        private final h.f<T> f6477c;

        public a(@NonNull h.f<T> fVar) {
            this.f6477c = fVar;
        }

        @NonNull
        public c<T> a() {
            if (this.f6476b == null) {
                synchronized (f6473d) {
                    if (f6474e == null) {
                        f6474e = Executors.newFixedThreadPool(2);
                    }
                }
                this.f6476b = f6474e;
            }
            return new c<>(this.f6475a, this.f6476b, this.f6477c);
        }
    }

    c(Executor executor, @NonNull Executor executor2, @NonNull h.f<T> fVar) {
        this.f6470a = executor;
        this.f6471b = executor2;
        this.f6472c = fVar;
    }

    @NonNull
    public Executor a() {
        return this.f6471b;
    }

    @NonNull
    public h.f<T> b() {
        return this.f6472c;
    }

    public Executor c() {
        return this.f6470a;
    }
}
