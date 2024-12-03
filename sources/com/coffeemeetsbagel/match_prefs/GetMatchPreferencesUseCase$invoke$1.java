package com.coffeemeetsbagel.match_prefs;

import ja.b;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GetMatchPreferencesUseCase$invoke$1 extends Lambda implements Function2<b, b, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public static final GetMatchPreferencesUseCase$invoke$1 f34536a = new GetMatchPreferencesUseCase$invoke$1();

    GetMatchPreferencesUseCase$invoke$1() {
        super(2);
    }

    /* renamed from: a */
    public final Boolean invoke(b bVar, b bVar2) {
        j.g(bVar, "new");
        j.g(bVar2, "old");
        return Boolean.valueOf(j.b(bVar.q(), bVar2.q()) && bVar.x() == bVar2.x());
    }
}
