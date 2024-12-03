package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;
import b2.b;
import b2.o;
import java.util.UUID;
import java.util.concurrent.Executor;

public abstract class c {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private Context f7401a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private WorkerParameters f7402b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f7403c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7404d;

    public static abstract class a {

        /* renamed from: androidx.work.c$a$a  reason: collision with other inner class name */
        public static final class C0082a extends a {

            /* renamed from: a  reason: collision with root package name */
            private final b f7405a;

            public C0082a() {
                this(b.f7398c);
            }

            @NonNull
            public b e() {
                return this.f7405a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || C0082a.class != obj.getClass()) {
                    return false;
                }
                return this.f7405a.equals(((C0082a) obj).f7405a);
            }

            public int hashCode() {
                return (C0082a.class.getName().hashCode() * 31) + this.f7405a.hashCode();
            }

            @NonNull
            public String toString() {
                return "Failure {mOutputData=" + this.f7405a + '}';
            }

            public C0082a(@NonNull b bVar) {
                this.f7405a = bVar;
            }
        }

        public static final class b extends a {
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && b.class == obj.getClass();
            }

            public int hashCode() {
                return b.class.getName().hashCode();
            }

            @NonNull
            public String toString() {
                return "Retry";
            }
        }

        /* renamed from: androidx.work.c$a$c  reason: collision with other inner class name */
        public static final class C0083c extends a {

            /* renamed from: a  reason: collision with root package name */
            private final b f7406a;

            public C0083c() {
                this(b.f7398c);
            }

            @NonNull
            public b e() {
                return this.f7406a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || C0083c.class != obj.getClass()) {
                    return false;
                }
                return this.f7406a.equals(((C0083c) obj).f7406a);
            }

            public int hashCode() {
                return (C0083c.class.getName().hashCode() * 31) + this.f7406a.hashCode();
            }

            @NonNull
            public String toString() {
                return "Success {mOutputData=" + this.f7406a + '}';
            }

            public C0083c(@NonNull b bVar) {
                this.f7406a = bVar;
            }
        }

        a() {
        }

        @NonNull
        public static a a() {
            return new C0082a();
        }

        @NonNull
        public static a b() {
            return new b();
        }

        @NonNull
        public static a c() {
            return new C0083c();
        }

        @NonNull
        public static a d(@NonNull b bVar) {
            return new C0083c(bVar);
        }
    }

    public c(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        } else if (workerParameters != null) {
            this.f7401a = context;
            this.f7402b = workerParameters;
        } else {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
    }

    @NonNull
    public final Context a() {
        return this.f7401a;
    }

    @NonNull
    public Executor c() {
        return this.f7402b.a();
    }

    @NonNull
    public zf.a<b> d() {
        androidx.work.impl.utils.futures.a s10 = androidx.work.impl.utils.futures.a.s();
        s10.p(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return s10;
    }

    @NonNull
    public final UUID e() {
        return this.f7402b.c();
    }

    @NonNull
    public final b g() {
        return this.f7402b.d();
    }

    @NonNull
    public o h() {
        return this.f7402b.e();
    }

    public final boolean i() {
        return this.f7403c;
    }

    public final boolean j() {
        return this.f7404d;
    }

    public void k() {
    }

    public final void l() {
        this.f7404d = true;
    }

    @NonNull
    public abstract zf.a<a> m();

    public final void n() {
        this.f7403c = true;
        k();
    }
}
