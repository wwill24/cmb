package com.coffeemeetsbagel.match_view;

import com.coffeemeetsbagel.models.ActivityReport;
import com.coffeemeetsbagel.utils.model.Optional;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GetActivityReportUseCase$invoke$1 extends Lambda implements Function2<Boolean, Optional<ActivityReport>, Pair<? extends Boolean, ? extends ActivityReport>> {

    /* renamed from: a  reason: collision with root package name */
    public static final GetActivityReportUseCase$invoke$1 f34602a = new GetActivityReportUseCase$invoke$1();

    GetActivityReportUseCase$invoke$1() {
        super(2);
    }

    /* renamed from: a */
    public final Pair<Boolean, ActivityReport> invoke(Boolean bool, Optional<ActivityReport> optional) {
        j.g(bool, "isUnlocked");
        j.g(optional, "activityReport");
        return new Pair<>(bool, optional.g());
    }
}
