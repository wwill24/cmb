package com.coffeemeetsbagel.match_view;

import com.coffeemeetsbagel.utils.model.Optional;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import vb.a;

final class GetActivityReportUseCase$getUnlockedValue$1 extends Lambda implements Function1<Optional<a>, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public static final GetActivityReportUseCase$getUnlockedValue$1 f34601a = new GetActivityReportUseCase$getUnlockedValue$1();

    GetActivityReportUseCase$getUnlockedValue$1() {
        super(1);
    }

    /* renamed from: a */
    public final Boolean invoke(Optional<a> optional) {
        j.g(optional, "subscription");
        return Boolean.valueOf(optional.d());
    }
}
