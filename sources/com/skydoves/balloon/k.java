package com.skydoves.balloon;

import android.content.Context;
import android.content.SharedPreferences;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final a f22806a = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static volatile k f22807b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static SharedPreferences f22808c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final k a(Context context) {
            j.g(context, IdentityHttpResponse.CONTEXT);
            k a10 = k.f22807b;
            if (a10 == null) {
                synchronized (this) {
                    a10 = k.f22807b;
                    if (a10 == null) {
                        a10 = new k((DefaultConstructorMarker) null);
                        k.f22807b = a10;
                        SharedPreferences sharedPreferences = context.getSharedPreferences("com.skydoves.balloon", 0);
                        j.f(sharedPreferences, "context.getSharedPrefere…n\", Context.MODE_PRIVATE)");
                        k.f22808c = sharedPreferences;
                    }
                }
            }
            return a10;
        }

        public final String b(String str) {
            j.g(str, "name");
            return "SHOWED_UP" + str;
        }
    }

    private k() {
    }

    public /* synthetic */ k(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final int d(String str) {
        SharedPreferences sharedPreferences = f22808c;
        if (sharedPreferences == null) {
            j.y("sharedPreferenceManager");
            sharedPreferences = null;
        }
        return sharedPreferences.getInt(f22806a.b(str), 0);
    }

    private final void e(String str, int i10) {
        SharedPreferences sharedPreferences = f22808c;
        if (sharedPreferences == null) {
            j.y("sharedPreferenceManager");
            sharedPreferences = null;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        j.f(edit, "editor");
        edit.putInt(f22806a.b(str), i10);
        edit.apply();
    }

    public final void f(String str) {
        j.g(str, "name");
        e(str, d(str) + 1);
    }

    public final boolean g(String str, int i10) {
        j.g(str, "name");
        return d(str) < i10;
    }
}
