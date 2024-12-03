package com.google.firebase.auth.internal;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.browser.customtabs.d;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.List;

public final /* synthetic */ class zzay implements OnCompleteListener {
    public final /* synthetic */ GenericIdpActivity zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzay(GenericIdpActivity genericIdpActivity, String str) {
        this.zza = genericIdpActivity;
        this.zzb = str;
    }

    public final void onComplete(Task task) {
        Intent intent = new Intent("android.intent.action.VIEW");
        GenericIdpActivity genericIdpActivity = this.zza;
        ResolveInfo resolveActivity = genericIdpActivity.getPackageManager().resolveActivity(intent, 0);
        String str = this.zzb;
        if (resolveActivity != null) {
            List<ResolveInfo> queryIntentServices = genericIdpActivity.getPackageManager().queryIntentServices(new Intent("android.support.customtabs.action.CustomTabsService"), 0);
            if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                Intent intent2 = new Intent("android.intent.action.VIEW", (Uri) task.getResult());
                intent2.putExtra("com.android.browser.application_id", str);
                intent2.addFlags(1073741824);
                intent2.addFlags(268435456);
                genericIdpActivity.startActivity(intent2);
                return;
            }
            new d.a().a().a(genericIdpActivity, (Uri) task.getResult());
            return;
        }
        genericIdpActivity.zze(str, (Status) null);
    }
}
