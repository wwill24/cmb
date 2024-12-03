package q;

import android.os.Build;
import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.q1;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class o implements q1 {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, Range<Integer>> f17079a;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17080a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.camera.core.impl.SurfaceConfig$ConfigType[] r0 = androidx.camera.core.impl.SurfaceConfig.ConfigType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f17080a = r0
                androidx.camera.core.impl.SurfaceConfig$ConfigType r1 = androidx.camera.core.impl.SurfaceConfig.ConfigType.PRIV     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f17080a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.core.impl.SurfaceConfig$ConfigType r1 = androidx.camera.core.impl.SurfaceConfig.ConfigType.YUV     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f17080a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.camera.core.impl.SurfaceConfig$ConfigType r1 = androidx.camera.core.impl.SurfaceConfig.ConfigType.JPEG     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: q.o.a.<clinit>():void");
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f17079a = hashMap;
        hashMap.put("SM-T580", (Object) null);
        hashMap.put("SM-J710MN", new Range(21, 26));
        hashMap.put("SM-A320FL", (Object) null);
        hashMap.put("SM-G570M", (Object) null);
        hashMap.put("SM-G610F", (Object) null);
        hashMap.put("SM-G610M", new Range(21, 26));
    }

    private static boolean c() {
        boolean z10;
        if (!"samsung".equalsIgnoreCase(Build.BRAND) || !f17079a.containsKey(Build.MODEL.toUpperCase(Locale.US))) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            return false;
        }
        Range range = f17079a.get(Build.MODEL.toUpperCase(Locale.US));
        if (range == null) {
            return true;
        }
        return range.contains(Integer.valueOf(Build.VERSION.SDK_INT));
    }

    static boolean d() {
        return c();
    }

    public Size b(@NonNull SurfaceConfig.ConfigType configType) {
        if (!c()) {
            return null;
        }
        int i10 = a.f17080a[configType.ordinal()];
        if (i10 == 1) {
            return new Size(1920, 1080);
        }
        if (i10 == 2) {
            return new Size(1280, 720);
        }
        if (i10 != 3) {
            return null;
        }
        return new Size(3264, 1836);
    }
}
