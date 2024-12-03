package b0;

import androidx.annotation.NonNull;
import androidx.core.util.h;
import b0.a;
import b0.e;
import java.io.File;

public final class c extends e {

    /* renamed from: b  reason: collision with root package name */
    private final b f7680b;

    public static final class a extends e.a<c, a> {

        /* renamed from: b  reason: collision with root package name */
        private final b.a f7681b;

        public a(@NonNull File file) {
            super(new a.b());
            h.h(file, "File can't be null.");
            b.a aVar = (b.a) this.f7684a;
            this.f7681b = aVar;
            aVar.c(file);
        }

        @NonNull
        public c a() {
            return new c(this.f7681b.b());
        }
    }

    static abstract class b extends e.b {

        static abstract class a extends e.b.a<a> {
            a() {
            }

            /* access modifiers changed from: package-private */
            @NonNull
            public abstract b b();

            /* access modifiers changed from: package-private */
            @NonNull
            public abstract a c(@NonNull File file);
        }

        b() {
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public abstract File c();
    }

    c(@NonNull b bVar) {
        super(bVar);
        this.f7680b = bVar;
    }

    @NonNull
    public File c() {
        return this.f7680b.c();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        return this.f7680b.equals(((c) obj).f7680b);
    }

    public int hashCode() {
        return this.f7680b.hashCode();
    }

    @NonNull
    public String toString() {
        return this.f7680b.toString().replaceFirst("FileOutputOptionsInternal", "FileOutputOptions");
    }
}
