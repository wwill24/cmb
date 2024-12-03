package fh;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.mlkit.common.sdkinternal.i;
import dh.d;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public class a implements d {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public static final a f23429c = new C0278a().a();

    /* renamed from: a  reason: collision with root package name */
    final AtomicReference f23430a = new AtomicReference();

    /* renamed from: b  reason: collision with root package name */
    private final Executor f23431b;

    /* renamed from: fh.a$a  reason: collision with other inner class name */
    public static class C0278a {

        /* renamed from: a  reason: collision with root package name */
        private Executor f23432a;

        @NonNull
        public a a() {
            return new a(this.f23432a, (b) null);
        }
    }

    /* synthetic */ a(Executor executor, b bVar) {
        this.f23431b = executor;
    }

    public final Executor a() {
        return this.f23431b;
    }

    @NonNull
    public final String b() {
        return true != c() ? "play-services-mlkit-text-recognition" : "text-recognition";
    }

    public final boolean c() {
        boolean z10;
        if (this.f23430a.get() != null) {
            return ((Boolean) this.f23430a.get()).booleanValue();
        }
        if (DynamiteModule.a(i.c().b(), "com.google.mlkit.dynamite.text.latin") > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f23430a.set(Boolean.valueOf(z10));
        return z10;
    }

    public final int d() {
        return c() ? 24317 : 24306;
    }

    public final int e() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        return n.b(this.f23431b, ((a) obj).f23431b);
    }

    @NonNull
    public final String f() {
        return true != c() ? "com.google.android.gms.vision.text.mlkit.TextRecognizerCreator" : "com.google.mlkit.vision.text.bundled.latin.BundledLatinTextRecognizerCreator";
    }

    @NonNull
    public final String getModuleId() {
        return true != c() ? "com.google.android.gms.vision.ocr" : "com.google.mlkit.dynamite.text.latin";
    }

    public int hashCode() {
        return n.c(this.f23431b);
    }
}
