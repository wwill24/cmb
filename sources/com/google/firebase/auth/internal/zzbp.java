package com.google.firebase.auth.internal;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.p003firebaseauthapi.zzab;
import com.google.android.gms.internal.p003firebaseauthapi.zzac;
import com.google.android.gms.internal.p003firebaseauthapi.zzaha;
import com.google.android.gms.internal.p003firebaseauthapi.zzj;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.Recaptcha;
import com.google.android.recaptcha.RecaptchaTasksClient;
import java.util.List;

final class zzbp implements Continuation {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbr zzb;

    zzbp(zzbr zzbr, String str) {
        this.zzb = zzbr;
        this.zza = str;
    }

    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        String str;
        if (!task.isSuccessful()) {
            return Tasks.forException(new zzbo((String) p.k(((Exception) p.k(task.getException())).getMessage())));
        }
        zzaha zzaha = (zzaha) task.getResult();
        String zzb2 = zzaha.zzb();
        if (zzac.zzd(zzb2)) {
            return Tasks.forException(new zzbo("No Recaptcha Enterprise siteKey configured for tenant/project ".concat(String.valueOf(this.zza))));
        }
        List zzd = zzab.zzb(zzj.zzb('/')).zzd(zzb2);
        if (zzd.size() != 4) {
            str = null;
        } else {
            str = (String) zzd.get(3);
        }
        if (TextUtils.isEmpty(str)) {
            return Tasks.forException(new Exception("Invalid siteKey format ".concat(String.valueOf(zzb2))));
        }
        if (Log.isLoggable("RecaptchaHandler", 4)) {
            "Successfully obtained site key for tenant ".concat(String.valueOf(this.zza));
        }
        this.zzb.zze = zzaha;
        Task<RecaptchaTasksClient> tasksClient = Recaptcha.getTasksClient((Application) this.zzb.zzb.getApplicationContext(), str);
        zzbr zzbr = this.zzb;
        zzbr.zza.put(this.zza, tasksClient);
        return tasksClient;
    }
}
