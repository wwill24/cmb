package com.coffeemeetsbagel.new_user_experience.match_prefs;

import a7.a;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.j;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final a f35283a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f35284b;

    public d(a aVar) {
        j.g(aVar, "analyticsManager");
        this.f35283a = aVar;
    }

    public static /* synthetic */ void h(d dVar, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        dVar.g(str);
    }

    public final void a(boolean z10) {
        this.f35284b = z10;
    }

    public final void b(String str, boolean z10) {
        String str2;
        j.g(str, "currentSection");
        if (this.f35284b) {
            if (z10) {
                str2 = "Onboarding - %s - Hardware Back Button Tapped";
            } else {
                str2 = "Onboarding - %s - Back Button Tapped";
            }
            String str3 = "Preferences";
            if (!j.b(str3, str)) {
                str3 = String.format("%s - %s", Arrays.copyOf(new Object[]{str3, str}, 2));
                j.f(str3, "format(this, *args)");
            }
            String format2 = String.format(str2, Arrays.copyOf(new Object[]{str3}, 1));
            j.f(format2, "format(this, *args)");
            this.f35283a.d(format2);
        }
    }

    public final void c(String str) {
        j.g(str, "trackingName");
        String format2 = String.format("%s - %s", Arrays.copyOf(new Object[]{"Preferences", str}, 2));
        j.f(format2, "format(this, *args)");
        String format3 = String.format("Onboarding - %s - Close Tapped", Arrays.copyOf(new Object[]{format2}, 1));
        j.f(format3, "format(this, *args)");
        e(format3, h0.i());
    }

    public final void d(String str, String str2) {
        j.g(str, "action");
        if (this.f35284b) {
            boolean z10 = true;
            HashMap k10 = h0.k(new Pair("source", str2));
            String format2 = String.format("Onboarding - Preferences - %s", Arrays.copyOf(new Object[]{"Preferences Value Prompt"}, 1));
            j.f(format2, "format(this, *args)");
            if (str.length() <= 0) {
                z10 = false;
            }
            if (z10) {
                format2 = format2 + " - " + str;
            }
            this.f35283a.trackEvent(format2, k10);
        }
    }

    public final void e(String str, Map<String, String> map) {
        j.g(str, "eventName");
        j.g(map, "map");
        if (this.f35284b) {
            this.f35283a.trackEvent(str, map);
        }
    }

    public final void f(String str, Boolean bool) {
        boolean z10;
        String str2;
        if (this.f35284b) {
            if (str == null || !(!r.w(str))) {
                z10 = false;
            } else {
                z10 = true;
            }
            String str3 = "Preferences";
            if (z10) {
                str3 = String.format("%s - %s", Arrays.copyOf(new Object[]{str3, str}, 2));
                j.f(str3, "format(this, *args)");
            }
            HashMap hashMap = new HashMap();
            if (bool != null) {
                bool.booleanValue();
                if (bool.booleanValue()) {
                    str2 = "Y";
                } else {
                    str2 = "N";
                }
                hashMap.put("field_edited", str2);
            }
            a aVar = this.f35283a;
            String format2 = String.format("Onboarding - %s - Next Button Tapped", Arrays.copyOf(new Object[]{str3}, 1));
            j.f(format2, "format(this, *args)");
            aVar.trackEvent(format2, hashMap);
            return;
        }
        this.f35283a.d("Bagel Preferences - Edit Confirm Tapped");
    }

    public final void g(String str) {
        String str2;
        boolean z10;
        if (this.f35284b) {
            if (str == null || str.length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                a aVar = this.f35283a;
                String format2 = String.format("Onboarding - %s", Arrays.copyOf(new Object[]{"Preferences"}, 1));
                j.f(format2, "format(this, *args)");
                aVar.f(format2);
                return;
            }
            a aVar2 = this.f35283a;
            String format3 = String.format("Onboarding - Preferences - %s", Arrays.copyOf(new Object[]{str}, 1));
            j.f(format3, "format(this, *args)");
            aVar2.f(format3);
            return;
        }
        if (str == null) {
            str2 = "Bagel Preferences";
        } else {
            str2 = "Bagel Preferences - Edit";
        }
        this.f35283a.f(str2);
    }
}
