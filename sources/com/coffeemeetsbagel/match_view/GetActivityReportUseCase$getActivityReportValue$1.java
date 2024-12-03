package com.coffeemeetsbagel.match_view;

import com.coffeemeetsbagel.database.room_mappers.a;
import com.coffeemeetsbagel.models.ActivityReport;
import com.coffeemeetsbagel.models.entities.ActivityReportEntity;
import com.coffeemeetsbagel.utils.model.Optional;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GetActivityReportUseCase$getActivityReportValue$1 extends Lambda implements Function1<List<? extends ActivityReportEntity>, Optional<ActivityReport>> {

    /* renamed from: a  reason: collision with root package name */
    public static final GetActivityReportUseCase$getActivityReportValue$1 f34600a = new GetActivityReportUseCase$getActivityReportValue$1();

    GetActivityReportUseCase$getActivityReportValue$1() {
        super(1);
    }

    /* renamed from: a */
    public final Optional<ActivityReport> invoke(List<ActivityReportEntity> list) {
        j.g(list, "entities");
        if (!list.isEmpty()) {
            return Optional.e(a.f11975b.c(list).get(0));
        }
        return Optional.a();
    }
}
