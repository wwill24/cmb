package n3;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final int f16403a;

    /* renamed from: b  reason: collision with root package name */
    private final int f16404b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f16405c;

    /* renamed from: d  reason: collision with root package name */
    private final int f16406d;

    public static final class a {

        /* renamed from: i  reason: collision with root package name */
        static final int f16407i = (Build.VERSION.SDK_INT < 26 ? 4 : 1);

        /* renamed from: a  reason: collision with root package name */
        final Context f16408a;

        /* renamed from: b  reason: collision with root package name */
        ActivityManager f16409b;

        /* renamed from: c  reason: collision with root package name */
        c f16410c;

        /* renamed from: d  reason: collision with root package name */
        float f16411d = 2.0f;

        /* renamed from: e  reason: collision with root package name */
        float f16412e = ((float) f16407i);

        /* renamed from: f  reason: collision with root package name */
        float f16413f = 0.4f;

        /* renamed from: g  reason: collision with root package name */
        float f16414g = 0.33f;

        /* renamed from: h  reason: collision with root package name */
        int f16415h = 4194304;

        public a(Context context) {
            this.f16408a = context;
            this.f16409b = (ActivityManager) context.getSystemService("activity");
            this.f16410c = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= 26 && i.e(this.f16409b)) {
                this.f16412e = 0.0f;
            }
        }

        public i a() {
            return new i(this);
        }
    }

    private static final class b implements c {

        /* renamed from: a  reason: collision with root package name */
        private final DisplayMetrics f16416a;

        b(DisplayMetrics displayMetrics) {
            this.f16416a = displayMetrics;
        }

        public int a() {
            return this.f16416a.heightPixels;
        }

        public int b() {
            return this.f16416a.widthPixels;
        }
    }

    interface c {
        int a();

        int b();
    }

    i(a aVar) {
        int i10;
        boolean z10;
        this.f16405c = aVar.f16408a;
        if (e(aVar.f16409b)) {
            i10 = aVar.f16415h / 2;
        } else {
            i10 = aVar.f16415h;
        }
        this.f16406d = i10;
        int c10 = c(aVar.f16409b, aVar.f16413f, aVar.f16414g);
        float b10 = (float) (aVar.f16410c.b() * aVar.f16410c.a() * 4);
        int round = Math.round(aVar.f16412e * b10);
        int round2 = Math.round(b10 * aVar.f16411d);
        int i11 = c10 - i10;
        int i12 = round2 + round;
        if (i12 <= i11) {
            this.f16404b = round2;
            this.f16403a = round;
        } else {
            float f10 = (float) i11;
            float f11 = aVar.f16412e;
            float f12 = aVar.f16411d;
            float f13 = f10 / (f11 + f12);
            this.f16404b = Math.round(f12 * f13);
            this.f16403a = Math.round(f13 * aVar.f16412e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Calculation complete, Calculated memory cache size: ");
            sb2.append(f(this.f16404b));
            sb2.append(", pool size: ");
            sb2.append(f(this.f16403a));
            sb2.append(", byte array size: ");
            sb2.append(f(i10));
            sb2.append(", memory class limited? ");
            if (i12 > c10) {
                z10 = true;
            } else {
                z10 = false;
            }
            sb2.append(z10);
            sb2.append(", max size: ");
            sb2.append(f(c10));
            sb2.append(", memoryClass: ");
            sb2.append(aVar.f16409b.getMemoryClass());
            sb2.append(", isLowMemoryDevice: ");
            sb2.append(e(aVar.f16409b));
        }
    }

    private static int c(ActivityManager activityManager, float f10, float f11) {
        boolean e10 = e(activityManager);
        float memoryClass = (float) (activityManager.getMemoryClass() * 1024 * 1024);
        if (e10) {
            f10 = f11;
        }
        return Math.round(memoryClass * f10);
    }

    @TargetApi(19)
    static boolean e(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    private String f(int i10) {
        return Formatter.formatFileSize(this.f16405c, (long) i10);
    }

    public int a() {
        return this.f16406d;
    }

    public int b() {
        return this.f16403a;
    }

    public int d() {
        return this.f16404b;
    }
}
