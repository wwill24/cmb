package u9;

import android.content.Intent;
import android.os.Bundle;
import c6.a;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.models.constants.Extra;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.jvm.internal.j;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f18027a = new d();

    private d() {
    }

    public final int a(Intent intent) {
        boolean z10;
        j.g(intent, SDKConstants.PARAM_INTENT);
        Bundle extras = intent.getExtras();
        boolean z11 = false;
        if (extras != null) {
            z10 = extras.getBoolean(Extra.IS_CONNECTED);
        } else {
            z10 = false;
        }
        Bundle extras2 = intent.getExtras();
        if (extras2 != null) {
            z11 = extras2.getBoolean(Extra.WAS_REPORTED);
        }
        if (z10) {
            if (z11) {
                return R.string.report_post_connection_success_confirmation;
            }
            return R.string.hide_post_connection_success_confirmation;
        } else if (z11) {
            return R.string.report_pre_connection_success_confirmation;
        } else {
            return R.string.hide_pre_connection_success_confirmation;
        }
    }

    public final int b(a aVar) {
        j.g(aVar, "activityResult");
        Intent a10 = aVar.a();
        j.f(a10, "activityResult.data");
        return a(a10);
    }
}
