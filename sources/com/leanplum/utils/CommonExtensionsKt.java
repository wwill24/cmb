package com.leanplum.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.leanplum.internal.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"getLeanplumPrefs", "Landroid/content/SharedPreferences;", "Landroid/content/Context;", "AndroidSDKCore_release"}, k = 2, mv = {1, 4, 2})
public final class CommonExtensionsKt {
    public static final SharedPreferences getLeanplumPrefs(Context context) {
        j.g(context, "$this$getLeanplumPrefs");
        return context.getSharedPreferences(Constants.Defaults.LEANPLUM, 0);
    }
}
