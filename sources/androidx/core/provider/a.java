package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.core.provider.f;
import androidx.core.provider.g;

class a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final g.c f4645a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Handler f4646b;

    /* renamed from: androidx.core.provider.a$a  reason: collision with other inner class name */
    class C0039a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g.c f4647a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Typeface f4648b;

        C0039a(g.c cVar, Typeface typeface) {
            this.f4647a = cVar;
            this.f4648b = typeface;
        }

        public void run() {
            this.f4647a.b(this.f4648b);
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g.c f4650a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f4651b;

        b(g.c cVar, int i10) {
            this.f4650a = cVar;
            this.f4651b = i10;
        }

        public void run() {
            this.f4650a.a(this.f4651b);
        }
    }

    a(@NonNull g.c cVar, @NonNull Handler handler) {
        this.f4645a = cVar;
        this.f4646b = handler;
    }

    private void a(int i10) {
        this.f4646b.post(new b(this.f4645a, i10));
    }

    private void c(@NonNull Typeface typeface) {
        this.f4646b.post(new C0039a(this.f4645a, typeface));
    }

    /* access modifiers changed from: package-private */
    public void b(@NonNull f.e eVar) {
        if (eVar.a()) {
            c(eVar.f4674a);
        } else {
            a(eVar.f4675b);
        }
    }
}
