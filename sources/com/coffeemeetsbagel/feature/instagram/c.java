package com.coffeemeetsbagel.feature.instagram;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.coffeemeetsbagel.feature.instagram.InstagramContract$Manager;
import com.coffeemeetsbagel.feature.instagram.a;
import com.coffeemeetsbagel.feature.instagram.api.models.InstagramMediaItem;
import com.coffeemeetsbagel.feature.instagram.b;
import com.coffeemeetsbagel.util.RequestCode;
import java.util.ArrayList;
import java.util.List;
import lc.l;

public class c implements InstagramContract$Manager {

    /* renamed from: a  reason: collision with root package name */
    private final a f13023a;

    /* renamed from: b  reason: collision with root package name */
    private final hb.c f13024b;

    /* renamed from: c  reason: collision with root package name */
    private List<InstagramContract$Manager.a> f13025c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private String f13026d;

    class a implements b.a<InstagramMediaItem[], InstagramContract$InstagramError> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.a f13027a;

        a(b.a aVar) {
            this.f13027a = aVar;
        }

        /* renamed from: b */
        public void a(InstagramMediaItem[] instagramMediaItemArr) {
            this.f13027a.a(instagramMediaItemArr);
        }

        public void c() {
            this.f13027a.c();
        }

        /* renamed from: e */
        public void d(InstagramContract$InstagramError instagramContract$InstagramError) {
            if (instagramContract$InstagramError == InstagramContract$InstagramError.NOT_AUTHORIZED) {
                c.this.e();
            }
            this.f13027a.d(instagramContract$InstagramError);
        }
    }

    public c(a aVar, hb.c cVar) {
        this.f13023a = aVar;
        this.f13024b = cVar;
        String r10 = cVar.r("KEY_INSTAGRAM_AUTH_TOKEN");
        this.f13026d = r10;
        aVar.c(r10);
    }

    /* access modifiers changed from: private */
    public void e() {
        boolean isLoggedIn = isLoggedIn();
        j("");
        if (isLoggedIn) {
            h();
        }
    }

    private void g() {
        ArrayList<InstagramContract$Manager.a> arrayList = new ArrayList<>();
        arrayList.addAll(this.f13025c);
        for (InstagramContract$Manager.a b10 : arrayList) {
            b10.b();
        }
    }

    private void h() {
        ArrayList<InstagramContract$Manager.a> arrayList = new ArrayList<>();
        arrayList.addAll(this.f13025c);
        for (InstagramContract$Manager.a a10 : arrayList) {
            a10.a();
        }
    }

    private void j(String str) {
        this.f13026d = str;
        this.f13023a.c(str);
        this.f13024b.w("KEY_INSTAGRAM_AUTH_TOKEN", str);
    }

    public String a() {
        return this.f13023a.a();
    }

    public InstagramContract$Manager.AuthUrlType b(String str) {
        if (!this.f13023a.b(str)) {
            String f10 = this.f13023a.f(str);
            if (!(!TextUtils.isEmpty(f10))) {
                return InstagramContract$Manager.AuthUrlType.NONE;
            }
            j(f10);
            g();
            return InstagramContract$Manager.AuthUrlType.USER_HAS_AUTHED;
        } else if (this.f13023a.g(str)) {
            return InstagramContract$Manager.AuthUrlType.USER_DENIED_AUTH;
        } else {
            return InstagramContract$Manager.AuthUrlType.AUTH_ERROR;
        }
    }

    public b<InstagramMediaItem[], InstagramContract$InstagramError> c(b.a<InstagramMediaItem[], InstagramContract$InstagramError> aVar) {
        return this.f13023a.e(new a(aVar));
    }

    public void clear() {
        e();
    }

    public void f(Activity activity) {
        if (l.a("com.instagram.android")) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://instagram.com/_u/coffeemeetsbagel/"));
                intent.setPackage("com.instagram.android");
                activity.startActivityForResult(intent, RequestCode.FOLLOW_INSTAGRAM);
                return;
            } catch (ActivityNotFoundException e10) {
                fa.a.i(e10);
            }
        }
        activity.startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse("https://instagram.com/_u/coffeemeetsbagel/")), RequestCode.FOLLOW_INSTAGRAM);
    }

    public void i(a.C0137a aVar) {
        this.f13023a.d(aVar);
    }

    public boolean isLoggedIn() {
        return !TextUtils.isEmpty(this.f13026d);
    }
}
