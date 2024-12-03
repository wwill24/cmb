package h2;

import android.content.Context;
import android.os.PowerManager;
import b2.f;
import com.mparticle.identity.IdentityHttpResponse;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u001c\u0010\u0006\u001a\u00060\u0004R\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u001a\u0006\u0010\b\u001a\u00020\u0007\"\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Landroid/content/Context;", "context", "", "tag", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "b", "", "a", "Ljava/lang/String;", "TAG", "work-runtime_release"}, k = 2, mv = {1, 7, 1})
public final class u {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15305a;

    static {
        String i10 = f.i("WakeLocks");
        j.f(i10, "tagWithPrefix(\"WakeLocks\")");
        f15305a = i10;
    }

    public static final void a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        v vVar = v.f15306a;
        synchronized (vVar) {
            linkedHashMap.putAll(vVar.a());
            Unit unit = Unit.f32013a;
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) entry.getKey();
            String str = (String) entry.getValue();
            boolean z10 = true;
            if (wakeLock == null || !wakeLock.isHeld()) {
                z10 = false;
            }
            if (z10) {
                f.e().k(f15305a, "WakeLock held for " + str);
            }
        }
    }

    public static final PowerManager.WakeLock b(Context context, String str) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(str, "tag");
        Object systemService = context.getApplicationContext().getSystemService("power");
        j.e(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        String str2 = "WorkManager: " + str;
        PowerManager.WakeLock newWakeLock = ((PowerManager) systemService).newWakeLock(1, str2);
        v vVar = v.f15306a;
        synchronized (vVar) {
            String put = vVar.a().put(newWakeLock, str2);
        }
        j.f(newWakeLock, "wakeLock");
        return newWakeLock;
    }
}
