package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.models.util.FacebookParse;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ProfileInstallerInitializer implements v1.a<c> {

    private static class a {
        public static void c(Runnable runnable) {
            Choreographer.getInstance().postFrameCallback(new l(runnable));
        }
    }

    private static class b {
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    public static class c {
    }

    /* access modifiers changed from: private */
    public static void l(@NonNull Context context) {
        new ThreadPoolExecutor(0, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new k(context));
    }

    @NonNull
    public List<Class<? extends v1.a<?>>> a() {
        return Collections.emptyList();
    }

    @NonNull
    /* renamed from: f */
    public c b(@NonNull Context context) {
        g(context.getApplicationContext());
        return new c();
    }

    /* access modifiers changed from: package-private */
    public void g(@NonNull Context context) {
        a.c(new i(this, context));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void i(@NonNull Context context) {
        Handler handler;
        if (Build.VERSION.SDK_INT >= 28) {
            handler = b.a(Looper.getMainLooper());
        } else {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.postDelayed(new j(context), (long) (new Random().nextInt(Math.max(1000, 1)) + FacebookParse.FB_NO_LIMIT));
    }
}
