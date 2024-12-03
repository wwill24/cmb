package vg;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import java.util.concurrent.Executor;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f24664a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f24665b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f24666c;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f24667a = 0;

        /* renamed from: b  reason: collision with root package name */
        private boolean f24668b;

        /* renamed from: c  reason: collision with root package name */
        private Executor f24669c;

        @NonNull
        public b a() {
            return new b(this.f24667a, this.f24668b, this.f24669c, (d) null);
        }

        @NonNull
        public a b(int i10, @NonNull int... iArr) {
            this.f24667a = i10;
            if (iArr != null) {
                for (int i11 : iArr) {
                    this.f24667a = i11 | this.f24667a;
                }
            }
            return this;
        }
    }

    /* synthetic */ b(int i10, boolean z10, Executor executor, d dVar) {
        this.f24664a = i10;
        this.f24665b = z10;
        this.f24666c = executor;
    }

    public final int a() {
        return this.f24664a;
    }

    public final Executor b() {
        return this.f24666c;
    }

    public final boolean c() {
        return this.f24665b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f24664a == bVar.f24664a && this.f24665b == bVar.f24665b && n.b(this.f24666c, bVar.f24666c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return n.c(Integer.valueOf(this.f24664a), Boolean.valueOf(this.f24665b), this.f24666c);
    }
}
