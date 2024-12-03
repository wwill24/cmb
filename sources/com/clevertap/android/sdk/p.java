package com.clevertap.android.sdk;

import com.clevertap.android.sdk.CleverTapAPI;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    private int f10677a;

    p(int i10) {
        this.f10677a = i10;
    }

    public static void a(String str) {
        i();
        CleverTapAPI.LogLevel.INFO.a();
    }

    public static void b(String str, String str2) {
        if (i() > CleverTapAPI.LogLevel.INFO.a()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CleverTap:");
            sb2.append(str);
        }
    }

    public static void c(String str, String str2, Throwable th2) {
        if (i() > CleverTapAPI.LogLevel.INFO.a()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CleverTap:");
            sb2.append(str);
        }
    }

    public static void d(String str, Throwable th2) {
        i();
        CleverTapAPI.LogLevel.INFO.a();
    }

    private int h() {
        return this.f10677a;
    }

    private static int i() {
        return CleverTapAPI.t();
    }

    public static void j(String str) {
        i();
        CleverTapAPI.LogLevel.INFO.a();
    }

    public static void k(String str, Throwable th2) {
        i();
        CleverTapAPI.LogLevel.INFO.a();
    }

    public static void o(String str) {
        i();
        CleverTapAPI.LogLevel.DEBUG.a();
    }

    public static void p(String str, String str2) {
        if (i() > CleverTapAPI.LogLevel.DEBUG.a()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CleverTap:");
            sb2.append(str);
        }
    }

    public static void q(String str, String str2, Throwable th2) {
        if (i() > CleverTapAPI.LogLevel.DEBUG.a()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CleverTap:");
            sb2.append(str);
        }
    }

    public static void r(String str, Throwable th2) {
        i();
        CleverTapAPI.LogLevel.DEBUG.a();
    }

    public void e(String str) {
        i();
        CleverTapAPI.LogLevel.INFO.a();
    }

    public void f(String str, String str2) {
        if (i() <= CleverTapAPI.LogLevel.INFO.a()) {
            return;
        }
        if (str2.length() > 4000) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CleverTap:");
            sb2.append(str);
            str2.substring(0, 4000);
            f(str, str2.substring(4000));
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("CleverTap:");
        sb3.append(str);
    }

    public void g(String str, String str2, Throwable th2) {
        if (i() > CleverTapAPI.LogLevel.INFO.a()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CleverTap:");
            sb2.append(str);
        }
    }

    public void l(String str) {
        h();
        CleverTapAPI.LogLevel.INFO.a();
    }

    public void m(String str, String str2) {
        if (h() >= CleverTapAPI.LogLevel.INFO.a()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CleverTap:");
            sb2.append(str);
        }
    }

    public void n(int i10) {
        this.f10677a = i10;
    }

    public void s(String str) {
        i();
        CleverTapAPI.LogLevel.DEBUG.a();
    }

    public void t(String str, String str2) {
        if (i() <= CleverTapAPI.LogLevel.DEBUG.a()) {
            return;
        }
        if (str2.length() > 4000) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CleverTap:");
            sb2.append(str);
            str2.substring(0, 4000);
            t(str, str2.substring(4000));
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("CleverTap:");
        sb3.append(str);
    }

    public void u(String str, String str2, Throwable th2) {
        if (i() > CleverTapAPI.LogLevel.DEBUG.a()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CleverTap:");
            sb2.append(str);
        }
    }

    public void v(String str, Throwable th2) {
        i();
        CleverTapAPI.LogLevel.DEBUG.a();
    }
}
