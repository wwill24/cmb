package com.coffeemeetsbagel.database.room_mappers;

import com.coffeemeetsbagel.database.CmbDatabase;
import com.coffeemeetsbagel.database.daos.h;
import com.coffeemeetsbagel.models.ActivityReport;
import com.coffeemeetsbagel.models.entities.ActivityReportEntity;
import com.coffeemeetsbagel.models.util.DateUtils;
import fa.a;
import j$.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final C0129a f11975b = new C0129a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final CmbDatabase f11976a;

    /* renamed from: com.coffeemeetsbagel.database.room_mappers.a$a  reason: collision with other inner class name */
    public static final class C0129a {
        private C0129a() {
        }

        public /* synthetic */ C0129a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final ActivityReportEntity d(ActivityReport activityReport) {
            OffsetDateTime offsetDateTime;
            try {
                offsetDateTime = DateUtils.getOffsetDateTimeForFormattedUtcDateTime(activityReport.getExpirationDate());
            } catch (Exception e10) {
                a.C0491a aVar = fa.a.f40771d;
                String simpleName = a.class.getSimpleName();
                j.f(simpleName, "ActivityReportMapper::class.java.simpleName");
                aVar.c(simpleName, "Failed to parse expiration date: \"" + activityReport.getExpirationDate() + '\"', e10);
                offsetDateTime = OffsetDateTime.now().plusDays(1);
            }
            OffsetDateTime offsetDateTime2 = offsetDateTime;
            String profileId = activityReport.getProfileId();
            Float avgResponseTime = activityReport.getAvgResponseTime();
            Float chatInitiationLevel = activityReport.getChatInitiationLevel();
            Boolean hasLoggedInRecently = activityReport.getHasLoggedInRecently();
            Float overallChatActivity = activityReport.getOverallChatActivity();
            j.f(offsetDateTime2, "expDate");
            return new ActivityReportEntity(profileId, hasLoggedInRecently, overallChatActivity, chatInitiationLevel, avgResponseTime, offsetDateTime2);
        }

        public final ActivityReport b(ActivityReportEntity activityReportEntity) {
            j.g(activityReportEntity, "ar");
            String profileId = activityReportEntity.getProfileId();
            Float avgResponseTime = activityReportEntity.getAvgResponseTime();
            return new ActivityReport(profileId, activityReportEntity.getHasLoggedInRecently(), activityReportEntity.getOverallChatActivity(), activityReportEntity.getChatInitiationLevel(), avgResponseTime, DateUtils.getFormattedUtcDateTimeFromOffsetDateTime(activityReportEntity.getExpirationDate()));
        }

        public final List<ActivityReport> c(List<ActivityReportEntity> list) {
            j.g(list, "ars");
            ArrayList arrayList = new ArrayList(r.t(list, 10));
            for (ActivityReportEntity b10 : list) {
                arrayList.add(a.f11975b.b(b10));
            }
            return arrayList;
        }
    }

    public a(CmbDatabase cmbDatabase) {
        j.g(cmbDatabase, "cmbDatabase");
        this.f11976a = cmbDatabase;
    }

    public final int a(List<ActivityReport> list) {
        j.g(list, "reports");
        h G = this.f11976a.G();
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (ActivityReport a10 : list) {
            arrayList.add(f11975b.d(a10));
        }
        return G.o(arrayList);
    }
}
