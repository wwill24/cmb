package w6;

import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.entities.IcebreakersEntity;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.coffeemeetsbagel.profile.i;
import j$.time.Instant;
import j$.time.OffsetDateTime;
import j$.time.ZoneOffset;
import ja.b;
import ja.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;

public final class a {
    private static final OffsetDateTime a(String str) {
        boolean z10;
        if (str == null || str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return null;
        }
        Long millisFromUtc = DateUtils.getMillisFromUtc(str);
        j.f(millisFromUtc, "birthdayEpoch");
        return OffsetDateTime.ofInstant(Instant.ofEpochMilli(millisFromUtc.longValue()), ZoneOffset.UTC);
    }

    private static final IcebreakersEntity b(List<String> list) {
        String str;
        String str2;
        String str3 = "";
        if (!(!list.isEmpty()) || list.get(0) == null) {
            str = str3;
        } else {
            String str4 = list.get(0);
            j.d(str4);
            str = str4;
        }
        if (1 >= list.size() || list.get(1) == null) {
            str2 = str3;
        } else {
            String str5 = list.get(1);
            j.d(str5);
            str2 = str5;
        }
        if (2 < list.size() && list.get(2) != null) {
            String str6 = list.get(2);
            j.d(str6);
            str3 = str6;
        }
        return new IcebreakersEntity(str, str2, str3);
    }

    public static final b c(c cVar) {
        j.g(cVar, "<this>");
        String s10 = cVar.s();
        String b10 = cVar.b();
        String i10 = cVar.i();
        boolean y10 = cVar.y();
        OffsetDateTime u10 = cVar.u();
        long d10 = cVar.d();
        OffsetDateTime e10 = cVar.e();
        ja.a o10 = cVar.o();
        String p10 = cVar.p();
        boolean r10 = cVar.r();
        String h10 = cVar.h();
        OffsetDateTime g10 = cVar.g();
        String n10 = cVar.n();
        List<String> w10 = cVar.w();
        String t10 = cVar.t();
        i iVar = r1;
        b bVar = r2;
        i iVar2 = new i(cVar.l().getFirstIcebreaker(), cVar.l().getSecondIcebreaker(), cVar.l().getThirdIcebreaker());
        b bVar2 = new b(s10, b10, i10, y10, u10, d10, e10, o10, p10, r10, h10, g10, n10, w10, t10, iVar, cVar.c(), cVar.a(), cVar.k(), cVar.j(), cVar.f(), cVar.q(), cVar.m(), cVar.x(), cVar.v());
        return bVar;
    }

    public static final c d(NetworkProfile networkProfile) {
        boolean z10;
        OffsetDateTime offsetDateTime;
        OffsetDateTime offsetDateTime2;
        j.g(networkProfile, "<this>");
        String id2 = networkProfile.getId();
        j.f(id2, "this.id");
        String appsFlyerId = networkProfile.getAppsFlyerId();
        String userEmail = networkProfile.getUserEmail();
        boolean isEligibleForFreeTrial = networkProfile.isEligibleForFreeTrial();
        String registeredDate = networkProfile.getRegisteredDate();
        boolean z11 = false;
        if (registeredDate == null || registeredDate.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            offsetDateTime = null;
        } else {
            offsetDateTime = DateUtils.getOffsetDateTimeForFormattedUtcDateTime(networkProfile.getRegisteredDate());
        }
        long beans = networkProfile.getBeans();
        OffsetDateTime a10 = a(networkProfile.getBirthday());
        ja.a aVar = new ja.a(Integer.valueOf(networkProfile.getCriteriaAgeFrom()), Integer.valueOf(networkProfile.getCriteriaAgeTo()), networkProfile.getCriteriaEthnicity(), networkProfile.getCriteriaGender(), networkProfile.getCriteriaReligion(), networkProfile.getCriteriaDistanceMiles(), networkProfile.getCriteriaDistanceKm(), Integer.valueOf(networkProfile.getCriteriaHeightFeetFrom()), Integer.valueOf(networkProfile.getCriteriaHeightFeetTo()), Integer.valueOf(networkProfile.getCriteriaHeightInchesFrom()), Integer.valueOf(networkProfile.getCriteriaHeightInchesTo()), Integer.valueOf(networkProfile.getCriteriaHeightCentimetersFrom()), Integer.valueOf(networkProfile.getCriteriaHeightCentimetersTo()));
        String matchRegionName = networkProfile.getMatchRegionName();
        boolean isOnHold = networkProfile.isOnHold();
        String textReason = networkProfile.getTextReason();
        String reactivateDate = networkProfile.getReactivateDate();
        if (reactivateDate == null || reactivateDate.length() == 0) {
            z11 = true;
        }
        if (z11) {
            offsetDateTime2 = null;
        } else {
            offsetDateTime2 = DateUtils.getOffsetDateTimeForFormattedUtcDateTime(networkProfile.getReactivateDate());
        }
        String location = networkProfile.getLocation();
        List<String> viewedCoachmarks = networkProfile.getViewedCoachmarks();
        if (viewedCoachmarks == null) {
            viewedCoachmarks = q.j();
        }
        List<String> list = viewedCoachmarks;
        String personalReferralCode = networkProfile.getPersonalReferralCode();
        ArrayList<String> icebreakers = networkProfile.getIcebreakers();
        j.f(icebreakers, "this.icebreakers");
        return new c(id2, appsFlyerId, userEmail, isEligibleForFreeTrial, offsetDateTime, beans, a10, aVar, matchRegionName, isOnHold, textReason, offsetDateTime2, location, list, personalReferralCode, b(icebreakers), networkProfile.getBadgeCount(), networkProfile.getAttendanceAwardDaysForNewUser(), networkProfile.hasPrioritizedLikes(), networkProfile.hasActiveBoost(), networkProfile.getBoostReportId(), networkProfile.getNumRisingBagels(), networkProfile.getUserLastName(), networkProfile.getZipcode(), networkProfile.isHeightUnitMetric());
    }
}
