package he;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.h;
import com.mparticle.kits.AppsFlyerKit;
import java.util.Locale;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f40921a;

    /* renamed from: b  reason: collision with root package name */
    private final String f40922b;

    /* renamed from: c  reason: collision with root package name */
    private final h f40923c;

    /* renamed from: d  reason: collision with root package name */
    private final int f40924d;

    public a(@NonNull String str, @NonNull String... strArr) {
        String str2;
        if (r0 == 0) {
            str2 = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            for (String str3 : strArr) {
                if (sb2.length() > 1) {
                    sb2.append(AppsFlyerKit.COMMA);
                }
                sb2.append(str3);
            }
            sb2.append("] ");
            str2 = sb2.toString();
        }
        this.f40922b = str2;
        this.f40921a = str;
        this.f40923c = new h(str);
        int i10 = 2;
        while (i10 <= 7 && !Log.isLoggable(this.f40921a, i10)) {
            i10++;
        }
        this.f40924d = i10;
    }

    public void a(@NonNull String str, @NonNull Object... objArr) {
        if (f(3)) {
            d(str, objArr);
        }
    }

    public void b(@NonNull String str, @NonNull Throwable th2, @NonNull Object... objArr) {
        d(str, objArr);
    }

    public void c(@NonNull String str, @NonNull Object... objArr) {
        d(str, objArr);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public String d(@NonNull String str, @NonNull Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.f40922b.concat(str);
    }

    public void e(@NonNull String str, @NonNull Object... objArr) {
        d(str, objArr);
    }

    public boolean f(int i10) {
        return this.f40924d <= i10;
    }

    public void g(@NonNull String str, @NonNull Object... objArr) {
        if (f(2)) {
            d(str, objArr);
        }
    }

    public void h(@NonNull String str, @NonNull Object... objArr) {
        d(str, objArr);
    }

    public void i(@NonNull String str, @NonNull Throwable th2, @NonNull Object... objArr) {
        Log.wtf(this.f40921a, d(str, objArr), th2);
    }

    public void j(@NonNull Throwable th2) {
        Log.wtf(this.f40921a, th2);
    }
}
