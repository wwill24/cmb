package u4;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

public class b implements Executor {

    /* renamed from: a  reason: collision with root package name */
    Handler f18016a = new Handler(Looper.getMainLooper());

    public void execute(@NonNull Runnable runnable) {
        this.f18016a.post(runnable);
    }
}
