package com.clevertap.android.sdk.product_config;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.j;
import com.clevertap.android.sdk.l;
import i4.b;

public class a {
    public static CTProductConfigController a(Context context, l lVar, CleverTapInstanceConfig cleverTapInstanceConfig, i4.a aVar, j jVar, b bVar) {
        String x10 = lVar.x();
        v4.b bVar2 = new v4.b(context, cleverTapInstanceConfig);
        return new CTProductConfigController(context, cleverTapInstanceConfig, aVar, jVar, bVar, new b(x10, cleverTapInstanceConfig, bVar2), bVar2);
    }
}
