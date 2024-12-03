package rd;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.gtm.zzbe;
import com.google.android.gms.internal.gtm.zzbi;
import com.google.android.gms.internal.gtm.zzbv;
import java.util.ListIterator;

public class e extends n<e> {

    /* renamed from: d  reason: collision with root package name */
    private final zzbv f41847d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f41848e;

    public e(zzbv zzbv) {
        super(zzbv.zzd(), zzbv.zzr());
        this.f41847d = zzbv;
    }

    /* access modifiers changed from: protected */
    public final void a(k kVar) {
        zzbe zzbe = (zzbe) kVar.b(zzbe.class);
        if (TextUtils.isEmpty(zzbe.zze())) {
            zzbe.zzj(this.f41847d.zzi().zzb());
        }
        if (this.f41848e && TextUtils.isEmpty(zzbe.zzd())) {
            zzbi zze = this.f41847d.zze();
            zzbe.zzi(zze.zza());
            zzbe.zzh(zze.zzb());
        }
    }

    public final k d() {
        k kVar = new k(this.f41868b);
        kVar.g(this.f41847d.zzh().zza());
        kVar.g(this.f41847d.zzk().zza());
        c(kVar);
        return kVar;
    }

    /* access modifiers changed from: package-private */
    public final zzbv e() {
        return this.f41847d;
    }

    public final void f(String str) {
        p.g(str);
        Uri b10 = f.b(str);
        ListIterator<w> listIterator = this.f41868b.f().listIterator();
        while (listIterator.hasNext()) {
            if (b10.equals(listIterator.next().zzb())) {
                listIterator.remove();
            }
        }
        this.f41868b.f().add(new f(this.f41847d, str));
    }

    public final void g(boolean z10) {
        this.f41848e = z10;
    }
}
