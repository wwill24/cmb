package ne;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class c implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final String f41307a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicInteger f41308b = new AtomicInteger();

    /* renamed from: c  reason: collision with root package name */
    private final ThreadFactory f41309c = Executors.defaultThreadFactory();

    public c(@NonNull String str) {
        p.l(str, "Name must not be null");
        this.f41307a = str;
    }

    @NonNull
    public final Thread newThread(@NonNull Runnable runnable) {
        Thread newThread = this.f41309c.newThread(new d(runnable, 0));
        String str = this.f41307a;
        int andIncrement = this.f41308b.getAndIncrement();
        newThread.setName(str + "[" + andIncrement + "]");
        return newThread;
    }
}
