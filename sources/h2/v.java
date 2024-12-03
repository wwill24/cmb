package h2;

import android.os.PowerManager;
import java.util.WeakHashMap;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR'\u0010\n\u001a\u0012\u0012\b\u0012\u00060\u0003R\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lh2/v;", "", "Ljava/util/WeakHashMap;", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "", "b", "Ljava/util/WeakHashMap;", "a", "()Ljava/util/WeakHashMap;", "wakeLocks", "<init>", "()V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
final class v {

    /* renamed from: a  reason: collision with root package name */
    public static final v f15306a = new v();

    /* renamed from: b  reason: collision with root package name */
    private static final WeakHashMap<PowerManager.WakeLock, String> f15307b = new WeakHashMap<>();

    private v() {
    }

    public final WeakHashMap<PowerManager.WakeLock, String> a() {
        return f15307b;
    }
}
