package com.coffeemeetsbagel.token;

import com.google.android.gms.tasks.OnSuccessListener;

public final /* synthetic */ class c implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f37540a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f37541b;

    public /* synthetic */ c(g gVar, String str) {
        this.f37540a = gVar;
        this.f37541b = str;
    }

    public final void onSuccess(Object obj) {
        this.f37540a.D(this.f37541b, (String) obj);
    }
}
