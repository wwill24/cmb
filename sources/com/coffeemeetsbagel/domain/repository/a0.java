package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.dto.MatchContext;
import kotlin.jvm.internal.j;
import qj.h;
import u6.f;

public class a0 {

    /* renamed from: a  reason: collision with root package name */
    private final f f12468a;

    public a0(f fVar) {
        j.g(fVar, "matchContextDao");
        this.f12468a = fVar;
    }

    public final h<MatchContext> a(String str) {
        j.g(str, "matchId");
        return this.f12468a.a(str);
    }
}
