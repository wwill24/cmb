package com.leanplum.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.leanplum.Leanplum;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import tk.d;
import wk.l;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00022\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0002R\u0014\u0010\u000b\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/leanplum/utils/StringPreference;", "Ltk/d;", "", "", "thisRef", "Lwk/l;", "property", "getValue", "value", "", "setValue", "key", "Ljava/lang/String;", "defaultValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
public final class StringPreference implements d<Object, String> {
    private final String defaultValue;
    private final String key;

    public StringPreference(String str, String str2) {
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(str2, "defaultValue");
        this.key = str;
        this.defaultValue = str2;
    }

    public String getValue(Object obj, l<?> lVar) {
        SharedPreferences leanplumPrefs;
        j.g(obj, "thisRef");
        j.g(lVar, "property");
        Context context = Leanplum.getContext();
        if (context == null || (leanplumPrefs = CommonExtensionsKt.getLeanplumPrefs(context)) == null) {
            return this.defaultValue;
        }
        String string = leanplumPrefs.getString(this.key, this.defaultValue);
        return string != null ? string : this.defaultValue;
    }

    public void setValue(Object obj, l<?> lVar, String str) {
        SharedPreferences leanplumPrefs;
        j.g(obj, "thisRef");
        j.g(lVar, "property");
        j.g(str, "value");
        Context context = Leanplum.getContext();
        if (context != null && (leanplumPrefs = CommonExtensionsKt.getLeanplumPrefs(context)) != null) {
            leanplumPrefs.edit().putString(this.key, str).apply();
        }
    }
}
