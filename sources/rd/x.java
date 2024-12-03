package rd;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.gtm.zzav;
import com.google.android.gms.internal.gtm.zzbi;
import com.google.android.gms.internal.gtm.zzbt;
import com.google.android.gms.internal.gtm.zzbx;
import com.google.android.gms.internal.gtm.zzex;
import com.google.android.gms.internal.gtm.zzfs;
import com.mparticle.kits.ReportingMessage;
import java.util.HashMap;
import java.util.Map;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

final class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Map f41882a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f41883b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f41884c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ long f41885d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ boolean f41886e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ boolean f41887f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ String f41888g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ d f41889h;

    x(d dVar, Map map, boolean z10, String str, long j10, boolean z11, boolean z12, String str2) {
        this.f41889h = dVar;
        this.f41882a = map;
        this.f41883b = z10;
        this.f41884c = str;
        this.f41885d = j10;
        this.f41886e = z11;
        this.f41887f = z12;
        this.f41888g = str2;
    }

    public final void run() {
        double d10;
        if (this.f41889h.f41845e.zzf()) {
            this.f41882a.put("sc", "start");
        }
        Map map = this.f41882a;
        b zzp = this.f41889h.zzp();
        p.j("getClientId can not be called from the main thread");
        String zzb = zzp.e().zzi().zzb();
        if (zzb != null && TextUtils.isEmpty((CharSequence) map.get("cid"))) {
            map.put("cid", zzb);
        }
        String str = (String) this.f41882a.get("sf");
        if (str != null) {
            try {
                d10 = Double.parseDouble(str);
            } catch (NumberFormatException unused) {
                d10 = 100.0d;
            }
            if (zzfs.zzj(d10, (String) this.f41882a.get("cid"))) {
                this.f41889h.zzG("Sampling enabled. Hit sampled out. sample rate", Double.valueOf(d10));
                return;
            }
        }
        zzbi k10 = this.f41889h.zzr();
        if (this.f41883b) {
            Map map2 = this.f41882a;
            boolean zzb2 = k10.zzb();
            if (!map2.containsKey("ate")) {
                map2.put("ate", true != zzb2 ? "0" : AppEventsConstants.EVENT_PARAM_VALUE_YES);
            }
            zzfs.zzg(this.f41882a, "adid", k10.zza());
        } else {
            this.f41882a.remove("ate");
            this.f41882a.remove("adid");
        }
        zzav zza = this.f41889h.zzu().zza();
        zzfs.zzg(this.f41882a, "an", zza.zzf());
        zzfs.zzg(this.f41882a, "av", zza.zzg());
        zzfs.zzg(this.f41882a, "aid", zza.zzd());
        zzfs.zzg(this.f41882a, "aiid", zza.zze());
        this.f41882a.put(ReportingMessage.MessageType.SCREEN_VIEW, AppEventsConstants.EVENT_PARAM_VALUE_YES);
        this.f41882a.put("_v", zzbt.zzb);
        zzfs.zzg(this.f41882a, XHTMLText.UL, this.f41889h.zzx().zza().zzd());
        zzfs.zzg(this.f41882a, "sr", this.f41889h.zzx().zzb());
        if (this.f41884c.equals("transaction") || this.f41884c.equals("item") || this.f41889h.f41844d.zza()) {
            long zza2 = zzfs.zza((String) this.f41882a.get("ht"));
            if (zza2 == 0) {
                zza2 = this.f41885d;
            }
            long j10 = zza2;
            if (this.f41886e) {
                this.f41889h.zzz().zzN("Dry run enabled. Would have sent hit", new zzex(this.f41889h, this.f41882a, j10, this.f41887f));
                return;
            }
            String str2 = (String) this.f41882a.get("cid");
            HashMap hashMap = new HashMap();
            zzfs.zzh(hashMap, "uid", this.f41882a);
            zzfs.zzh(hashMap, "an", this.f41882a);
            zzfs.zzh(hashMap, "aid", this.f41882a);
            zzfs.zzh(hashMap, "av", this.f41882a);
            zzfs.zzh(hashMap, "aiid", this.f41882a);
            p.k(str2);
            this.f41882a.put("_s", String.valueOf(this.f41889h.zzs().zza(new zzbx(0, str2, this.f41888g, !TextUtils.isEmpty((CharSequence) this.f41882a.get("adid")), 0, hashMap))));
            this.f41889h.zzs().zzh(new zzex(this.f41889h, this.f41882a, j10, this.f41887f));
            return;
        }
        this.f41889h.zzz().zzc(this.f41882a, "Too many hits sent too quickly, rate limiting invoked");
    }
}
