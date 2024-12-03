package com.coffeemeetsbagel.qna.data;

import fj.d;
import fk.a;
import ma.b;
import ma.f;
import ma.h;
import za.e;

public final class s implements d<QuestionRepository> {

    /* renamed from: a  reason: collision with root package name */
    private final a<f> f36282a;

    /* renamed from: b  reason: collision with root package name */
    private final a<za.d> f36283b;

    /* renamed from: c  reason: collision with root package name */
    private final a<b> f36284c;

    /* renamed from: d  reason: collision with root package name */
    private final a<e> f36285d;

    /* renamed from: e  reason: collision with root package name */
    private final a<h> f36286e;

    public s(a<f> aVar, a<za.d> aVar2, a<b> aVar3, a<e> aVar4, a<h> aVar5) {
        this.f36282a = aVar;
        this.f36283b = aVar2;
        this.f36284c = aVar3;
        this.f36285d = aVar4;
        this.f36286e = aVar5;
    }

    public static s a(a<f> aVar, a<za.d> aVar2, a<b> aVar3, a<e> aVar4, a<h> aVar5) {
        return new s(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static QuestionRepository c(f fVar, za.d dVar, b bVar, e eVar, h hVar) {
        return new QuestionRepository(fVar, dVar, bVar, eVar, hVar);
    }

    /* renamed from: b */
    public QuestionRepository get() {
        return c(this.f36282a.get(), this.f36283b.get(), this.f36284c.get(), this.f36285d.get(), this.f36286e.get());
    }
}
