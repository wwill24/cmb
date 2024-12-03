package com.coffeemeetsbagel.school.data;

import android.content.res.Resources;
import fj.d;
import fk.a;
import hb.c;

public final class i implements d<SchoolRepository> {

    /* renamed from: a  reason: collision with root package name */
    private final a<c> f36370a;

    /* renamed from: b  reason: collision with root package name */
    private final a<Resources> f36371b;

    /* renamed from: c  reason: collision with root package name */
    private final a<eb.a> f36372c;

    public i(a<c> aVar, a<Resources> aVar2, a<eb.a> aVar3) {
        this.f36370a = aVar;
        this.f36371b = aVar2;
        this.f36372c = aVar3;
    }

    public static i a(a<c> aVar, a<Resources> aVar2, a<eb.a> aVar3) {
        return new i(aVar, aVar2, aVar3);
    }

    public static SchoolRepository c(c cVar, Resources resources, eb.a aVar) {
        return new SchoolRepository(cVar, resources, aVar);
    }

    /* renamed from: b */
    public SchoolRepository get() {
        return c(this.f36370a.get(), this.f36371b.get(), this.f36372c.get());
    }
}
