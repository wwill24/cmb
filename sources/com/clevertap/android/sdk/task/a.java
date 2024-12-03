package com.clevertap.android.sdk.task;

import com.clevertap.android.sdk.CleverTapInstanceConfig;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, b> f10794a = Collections.synchronizedMap(new HashMap());

    public static b a(CleverTapInstanceConfig cleverTapInstanceConfig) {
        if (cleverTapInstanceConfig != null) {
            Map<String, b> map = f10794a;
            b bVar = map.get(cleverTapInstanceConfig.e());
            if (bVar == null) {
                synchronized (a.class) {
                    bVar = map.get(cleverTapInstanceConfig.e());
                    if (bVar == null) {
                        bVar = new b(cleverTapInstanceConfig);
                        map.put(cleverTapInstanceConfig.e(), bVar);
                    }
                }
            }
            return bVar;
        }
        throw new IllegalArgumentException("Can't create task for null config");
    }
}
