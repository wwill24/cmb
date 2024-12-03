package com.coffeemeetsbagel.token;

import android.content.SharedPreferences;
import android.text.TextUtils;
import b6.w;
import com.coffeemeetsbagel.models.StoreTokenRequest;
import com.google.firebase.messaging.FirebaseMessaging;
import com.uber.autodispose.p;
import d7.c;
import la.a;

public class g extends w {

    /* renamed from: d  reason: collision with root package name */
    private final a f37546d;

    /* renamed from: e  reason: collision with root package name */
    private final SharedPreferences f37547e;

    /* renamed from: f  reason: collision with root package name */
    private final FirebaseMessaging f37548f;

    /* renamed from: g  reason: collision with root package name */
    private final c f37549g;

    public g(a aVar, SharedPreferences sharedPreferences, FirebaseMessaging firebaseMessaging, c cVar) {
        this.f37546d = aVar;
        this.f37547e = sharedPreferences;
        this.f37548f = firebaseMessaging;
        this.f37549g = cVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B(String str, a aVar) throws Exception {
        this.f37547e.edit().putString("DEVICE_TOKEN_KEY", str).apply();
        v();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C(Throwable th2) throws Exception {
        fa.a.i(th2);
        v();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if ((TextUtils.isEmpty(str) || !str.equals(str2)) && this.f37549g.isLoggedIn() && this.f37549g.e() != null) {
            ((p) this.f37546d.a(new StoreTokenRequest(str2)).e0(5).m0(dk.a.c()).g(com.uber.autodispose.a.a(this))).b(new e(this, str2), new f(this));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E(Exception exc) {
        fa.a.i(exc);
        v();
    }

    public void start() {
        super.start();
        this.f37548f.getToken().addOnSuccessListener(new c(this, this.f37547e.getString("DEVICE_TOKEN_KEY", ""))).addOnFailureListener(new d(this));
    }
}
