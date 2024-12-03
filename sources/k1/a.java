package k1;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.SparseArray;
import com.coffeemeetsbagel.models.util.DateUtils;

@Deprecated
public abstract class a extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final SparseArray<PowerManager.WakeLock> f15644a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private static int f15645b = 1;

    public static boolean b(Intent intent) {
        int intExtra = intent.getIntExtra("androidx.contentpager.content.wakelockid", 0);
        if (intExtra == 0) {
            return false;
        }
        SparseArray<PowerManager.WakeLock> sparseArray = f15644a;
        synchronized (sparseArray) {
            PowerManager.WakeLock wakeLock = sparseArray.get(intExtra);
            if (wakeLock != null) {
                wakeLock.release();
                sparseArray.remove(intExtra);
                return true;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("No active wake lock id #");
            sb2.append(intExtra);
            return true;
        }
    }

    public static ComponentName c(Context context, Intent intent) {
        SparseArray<PowerManager.WakeLock> sparseArray = f15644a;
        synchronized (sparseArray) {
            int i10 = f15645b;
            int i11 = i10 + 1;
            f15645b = i11;
            if (i11 <= 0) {
                f15645b = 1;
            }
            intent.putExtra("androidx.contentpager.content.wakelockid", i10);
            ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "androidx.core:wake:" + startService.flattenToShortString());
            newWakeLock.setReferenceCounted(false);
            newWakeLock.acquire(DateUtils.MILLIS_IN_MINUTE);
            sparseArray.put(i10, newWakeLock);
            return startService;
        }
    }
}
