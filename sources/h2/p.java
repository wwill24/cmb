package h2;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import androidx.work.a;
import b2.f;
import b2.m;
import com.mparticle.identity.IdentityHttpResponse;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0001\u001a\u00020\u0000H\u0003\"\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Landroid/content/Context;", "context", "Landroidx/work/a;", "configuration", "", "b", "", "a", "Ljava/lang/String;", "TAG", "work-runtime_release"}, k = 2, mv = {1, 7, 1})
public final class p {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15291a;

    static {
        String i10 = f.i("ProcessUtils");
        j.f(i10, "tagWithPrefix(\"ProcessUtils\")");
        f15291a = i10;
    }

    @SuppressLint({"PrivateApi", "DiscouragedPrivateApi"})
    private static final String a(Context context) {
        T t10;
        boolean z10;
        if (Build.VERSION.SDK_INT >= 28) {
            return b.f15274a.a();
        }
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, m.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke((Object) null, new Object[0]);
            j.d(invoke);
            if (invoke instanceof String) {
                return (String) invoke;
            }
        } catch (Throwable th2) {
            f.e().b(f15291a, "Unable to check ActivityThread for processName", th2);
        }
        int myPid = Process.myPid();
        Object systemService = context.getSystemService("activity");
        j.e(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return null;
        }
        Iterator<T> it = runningAppProcesses.iterator();
        while (true) {
            if (!it.hasNext()) {
                t10 = null;
                break;
            }
            t10 = it.next();
            if (((ActivityManager.RunningAppProcessInfo) t10).pid == myPid) {
                z10 = true;
                continue;
            } else {
                z10 = false;
                continue;
            }
            if (z10) {
                break;
            }
        }
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) t10;
        if (runningAppProcessInfo != null) {
            return runningAppProcessInfo.processName;
        }
        return null;
    }

    public static final boolean b(Context context, a aVar) {
        boolean z10;
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(aVar, "configuration");
        String a10 = a(context);
        String c10 = aVar.c();
        if (c10 == null || c10.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return j.b(a10, aVar.c());
        }
        return j.b(a10, context.getApplicationInfo().processName);
    }
}
