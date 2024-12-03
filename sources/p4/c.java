package p4;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.l;
import w4.d;

public class c {
    public static b a(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, l lVar, d dVar) {
        b bVar;
        if (new g(context, cleverTapInstanceConfig, lVar).h()) {
            bVar = new e(cleverTapInstanceConfig);
        } else {
            bVar = new a(context, cleverTapInstanceConfig, lVar, dVar);
        }
        cleverTapInstanceConfig.A("ON_USER_LOGIN", "Repo provider: " + bVar.getClass().getSimpleName());
        return bVar;
    }
}
