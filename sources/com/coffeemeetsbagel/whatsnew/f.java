package com.coffeemeetsbagel.whatsnew;

import a7.a;
import androidx.lifecycle.f0;
import androidx.lifecycle.i0;
import kotlin.jvm.internal.j;

public final class f extends i0.a {

    /* renamed from: i  reason: collision with root package name */
    private a f37634i;

    public f(a aVar) {
        j.g(aVar, "analyticsManager");
        this.f37634i = aVar;
    }

    public <T extends f0> T b(Class<T> cls, m1.a aVar) {
        j.g(cls, "modelClass");
        j.g(aVar, "extras");
        return new WhatsNewViewModel(this.f37634i);
    }
}
