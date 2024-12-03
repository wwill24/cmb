package rd;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.gtm.zzbs;
import com.google.android.gms.internal.gtm.zzbv;
import com.google.android.gms.internal.gtm.zzfr;
import java.util.HashMap;

final class y extends zzbs {

    /* renamed from: a  reason: collision with root package name */
    private boolean f41890a;

    /* renamed from: b  reason: collision with root package name */
    private int f41891b;

    /* renamed from: c  reason: collision with root package name */
    private long f41892c = -1;

    /* renamed from: d  reason: collision with root package name */
    private boolean f41893d;

    /* renamed from: e  reason: collision with root package name */
    private long f41894e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ d f41895f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected y(d dVar, zzbv zzbv) {
        super(zzbv);
        this.f41895f = dVar;
    }

    private final void zzg() {
        if (this.f41892c >= 0 || this.f41890a) {
            zzp().s(this.f41895f.f41845e);
        } else {
            zzp().t(this.f41895f.f41845e);
        }
    }

    public final void b(Activity activity) {
        String str;
        if (this.f41891b == 0 && zzC().b() >= this.f41894e + Math.max(1000, this.f41892c)) {
            this.f41893d = true;
        }
        this.f41891b++;
        if (this.f41890a) {
            Intent intent = activity.getIntent();
            if (intent != null) {
                this.f41895f.f(intent.getData());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("&t", "screenview");
            d dVar = this.f41895f;
            if (dVar.f41846f != null) {
                zzfr E = this.f41895f.f41846f;
                str = activity.getClass().getCanonicalName();
                String str2 = E.zzg.get(str);
                if (str2 != null) {
                    str = str2;
                }
            } else {
                str = activity.getClass().getCanonicalName();
            }
            dVar.e("&cd", str);
            if (TextUtils.isEmpty((CharSequence) hashMap.get("&dr"))) {
                p.k(activity);
                Intent intent2 = activity.getIntent();
                String str3 = null;
                if (intent2 != null) {
                    String stringExtra = intent2.getStringExtra("android.intent.extra.REFERRER_NAME");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        str3 = stringExtra;
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    hashMap.put("&dr", str3);
                }
            }
            this.f41895f.c(hashMap);
        }
    }

    public final void c(Activity activity) {
        int i10 = this.f41891b - 1;
        this.f41891b = i10;
        int max = Math.max(0, i10);
        this.f41891b = max;
        if (max == 0) {
            this.f41894e = zzC().b();
        }
    }

    public final void e(boolean z10) {
        this.f41890a = z10;
        zzg();
    }

    /* access modifiers changed from: protected */
    public final void zzd() {
    }

    public final synchronized boolean zzf() {
        boolean z10;
        z10 = this.f41893d;
        this.f41893d = false;
        return z10;
    }
}
