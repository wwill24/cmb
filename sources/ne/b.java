package ne;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class b implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final String f41305a;

    /* renamed from: b  reason: collision with root package name */
    private final ThreadFactory f41306b = Executors.defaultThreadFactory();

    public b(@NonNull String str) {
        p.l(str, "Name must not be null");
        this.f41305a = str;
    }

    @NonNull
    public final Thread newThread(@NonNull Runnable runnable) {
        Thread newThread = this.f41306b.newThread(new d(runnable, 0));
        newThread.setName(this.f41305a);
        return newThread;
    }
}
