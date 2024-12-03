package b2;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.WorkerParameters;
import androidx.work.c;

public abstract class o {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7755a = f.i("WorkerFactory");

    class a extends o {
        a() {
        }

        public c a(@NonNull Context context, @NonNull String str, @NonNull WorkerParameters workerParameters) {
            return null;
        }
    }

    @NonNull
    public static o c() {
        return new a();
    }

    public abstract c a(@NonNull Context context, @NonNull String str, @NonNull WorkerParameters workerParameters);

    public final c b(@NonNull Context context, @NonNull String str, @NonNull WorkerParameters workerParameters) {
        c a10 = a(context, str, workerParameters);
        if (a10 == null) {
            Class<? extends U> cls = null;
            try {
                cls = Class.forName(str).asSubclass(c.class);
            } catch (Throwable th2) {
                f e10 = f.e();
                String str2 = f7755a;
                e10.d(str2, "Invalid class: " + str, th2);
            }
            if (cls != null) {
                try {
                    a10 = (c) cls.getDeclaredConstructor(new Class[]{Context.class, WorkerParameters.class}).newInstance(new Object[]{context, workerParameters});
                } catch (Throwable th3) {
                    f e11 = f.e();
                    String str3 = f7755a;
                    e11.d(str3, "Could not instantiate " + str, th3);
                }
            }
        }
        if (a10 == null || !a10.j()) {
            return a10;
        }
        String name = getClass().getName();
        throw new IllegalStateException("WorkerFactory (" + name + ") returned an instance of a ListenableWorker (" + str + ") which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.");
    }
}
