package c2;

import androidx.annotation.NonNull;
import b2.f;
import b2.k;
import g2.u;
import java.util.HashMap;
import java.util.Map;

public class a {

    /* renamed from: d  reason: collision with root package name */
    static final String f7908d = f.i("DelayedWorkTracker");

    /* renamed from: a  reason: collision with root package name */
    final b f7909a;

    /* renamed from: b  reason: collision with root package name */
    private final k f7910b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Runnable> f7911c = new HashMap();

    /* renamed from: c2.a$a  reason: collision with other inner class name */
    class C0093a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f7912a;

        C0093a(u uVar) {
            this.f7912a = uVar;
        }

        public void run() {
            f e10 = f.e();
            String str = a.f7908d;
            e10.a(str, "Scheduling work " + this.f7912a.f15077a);
            a.this.f7909a.d(this.f7912a);
        }
    }

    public a(@NonNull b bVar, @NonNull k kVar) {
        this.f7909a = bVar;
        this.f7910b = kVar;
    }

    public void a(@NonNull u uVar) {
        Runnable remove = this.f7911c.remove(uVar.f15077a);
        if (remove != null) {
            this.f7910b.a(remove);
        }
        C0093a aVar = new C0093a(uVar);
        this.f7911c.put(uVar.f15077a, aVar);
        long currentTimeMillis = System.currentTimeMillis();
        this.f7910b.b(uVar.c() - currentTimeMillis, aVar);
    }

    public void b(@NonNull String str) {
        Runnable remove = this.f7911c.remove(str);
        if (remove != null) {
            this.f7910b.a(remove);
        }
    }
}
