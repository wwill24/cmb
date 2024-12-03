package com.coffeemeetsbagel.services;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.i;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.responses.ResponseGeneric;
import com.coffeemeetsbagel.transport.SuccessStatus;
import java.io.Serializable;
import lc.k;

public class ProfileUpdateJobIntentService extends gb.a {

    /* renamed from: e  reason: collision with root package name */
    k f36377e;

    /* renamed from: f  reason: collision with root package name */
    ProfileManager f36378f;

    public interface a {
        ProfileManager d();

        k q0();
    }

    interface b {
        void a(ProfileUpdateJobIntentService profileUpdateJobIntentService);
    }

    public static void c(Context context, Intent intent) {
        i.enqueueWork(context, (Class<?>) ProfileUpdateJobIntentService.class, 1000, intent);
    }

    public void onCreate() {
        super.onCreate();
        a.a().b(Bakery.j()).a().a(this);
    }

    /* access modifiers changed from: protected */
    public void onHandleWork(@NonNull Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            this.f36377e.a(new IllegalArgumentException("No extras provided"));
            return;
        }
        ResultReceiver resultReceiver = (ResultReceiver) extras.get("ResultReceiver");
        if (resultReceiver == null) {
            this.f36377e.a(new IllegalArgumentException("No result receiver provided"));
            return;
        }
        String string = extras.getString("JSON_STRING_DATA");
        boolean z10 = intent.getExtras().getBoolean(Extra.SHOULD_ADD_TO_REQUEST_QUEUE);
        if (TextUtils.isEmpty(extras.getString(Extra.PROFILE_ID, (String) null))) {
            a(resultReceiver, new CmbErrorCode("No profile ID could be attached to the request"));
            return;
        }
        try {
            ResponseGeneric B0 = this.f36378f.B0(string, z10);
            if (B0.isSuccessful()) {
                b(resultReceiver, new SuccessStatus("Profile Updated Successfully"), (Serializable) null);
            } else {
                a(resultReceiver, B0.getErrorCode());
            }
        } catch (Exception e10) {
            a(resultReceiver, new CmbErrorCode(e10.getMessage()));
        }
    }
}
