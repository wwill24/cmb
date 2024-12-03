package com.coffeemeetsbagel.bakery;

import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.metrics.Trace;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class g1 {

    /* renamed from: a  reason: collision with root package name */
    static Map<String, Trace> f11198a = new HashMap();

    public static void a(String str, String str2, String str3) {
        Trace trace = f11198a.get(str);
        if (trace != null) {
            trace.putAttribute(str2, str3);
        }
    }

    public static void b(String str, NetworkProfile networkProfile) {
        Trace trace;
        if (networkProfile != null && (trace = f11198a.get(str)) != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(DateUtils.getDate(networkProfile.getRegisteredDate()));
            trace.putAttribute("user_registration_year", String.valueOf(instance.get(1)));
        }
    }

    public static void c(String str) {
        f11198a.put(str, FirebasePerformance.startTrace(str));
    }

    public static void d(String str) {
        Trace trace = f11198a.get(str);
        if (trace != null) {
            trace.stop();
        }
        f11198a.remove(str);
    }
}
