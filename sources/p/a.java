package p;

import android.hardware.camera2.params.InputConfiguration;
import android.os.Build;
import androidx.annotation.NonNull;
import java.util.Objects;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final c f16880a;

    /* renamed from: p.a$a  reason: collision with other inner class name */
    private static class C0183a implements c {

        /* renamed from: a  reason: collision with root package name */
        private final InputConfiguration f16881a;

        C0183a(@NonNull Object obj) {
            this.f16881a = (InputConfiguration) obj;
        }

        public Object b() {
            return this.f16881a;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            return Objects.equals(this.f16881a, ((c) obj).b());
        }

        public int hashCode() {
            return this.f16881a.hashCode();
        }

        @NonNull
        public String toString() {
            return this.f16881a.toString();
        }
    }

    private static final class b extends C0183a {
        b(@NonNull Object obj) {
            super(obj);
        }
    }

    private interface c {
        Object b();
    }

    private a(@NonNull c cVar) {
        this.f16880a = cVar;
    }

    public static a b(Object obj) {
        if (obj == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return new a(new b(obj));
        }
        return new a(new C0183a(obj));
    }

    public Object a() {
        return this.f16880a.b();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        return this.f16880a.equals(((a) obj).f16880a);
    }

    public int hashCode() {
        return this.f16880a.hashCode();
    }

    @NonNull
    public String toString() {
        return this.f16880a.toString();
    }
}
