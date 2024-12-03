package ne;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.common.zzi;
import java.util.concurrent.Executor;

public class a implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f41304a;

    public a(@NonNull Looper looper) {
        this.f41304a = new zzi(looper);
    }

    public final void execute(@NonNull Runnable runnable) {
        this.f41304a.post(runnable);
    }
}
