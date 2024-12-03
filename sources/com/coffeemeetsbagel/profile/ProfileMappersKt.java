package com.coffeemeetsbagel.profile;

import com.coffeemeetsbagel.models.Height;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.entities.EthnicityType;
import com.coffeemeetsbagel.models.entities.GenderType;
import com.coffeemeetsbagel.models.entities.ProfileEducationEntity;
import com.coffeemeetsbagel.models.entities.ProfileEntity;
import com.coffeemeetsbagel.models.entities.ReligionType;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.mparticle.kits.AppsFlyerKit;
import ja.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;

public final class ProfileMappersKt {
    private static final void a(NetworkProfile networkProfile, b bVar) {
        String str;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        String str2;
        String str3;
        int i18;
        networkProfile.setAppsFlyerId(bVar.d());
        networkProfile.setUserEmail(bVar.k());
        networkProfile.setEligibleForFreeTrial(bVar.A());
        String str4 = null;
        if (bVar.w() == null) {
            str = null;
        } else {
            str = DateUtils.getFormattedUtcDateTimeFromOffsetDateTime(bVar.w());
        }
        networkProfile.setRegisteredDate(str);
        Integer a10 = bVar.q().a();
        int i19 = 18;
        if (a10 != null) {
            i10 = a10.intValue();
        } else {
            i10 = 18;
        }
        networkProfile.setCriteriaAgeFrom(i10);
        Integer b10 = bVar.q().b();
        int i20 = 99;
        if (b10 != null) {
            i11 = b10.intValue();
        } else {
            i11 = 99;
        }
        networkProfile.setCriteriaAgeTo(i11);
        networkProfile.setCriteriaEthnicity(bVar.q().c());
        networkProfile.setCriteriaGender(bVar.q().d());
        networkProfile.setCriteriaReligion(bVar.q().m());
        networkProfile.setCriteriaDistanceMiles(bVar.q().l());
        networkProfile.setCriteriaDistanceKm(bVar.q().k());
        Integer g10 = bVar.q().g();
        int i21 = 4;
        if (g10 != null) {
            i12 = g10.intValue();
        } else {
            i12 = 4;
        }
        networkProfile.setCriteriaHeightFeetFrom(i12);
        Integer h10 = bVar.q().h();
        int i22 = 8;
        if (h10 != null) {
            i13 = h10.intValue();
        } else {
            i13 = 8;
        }
        networkProfile.setCriteriaHeightFeetTo(i13);
        Integer i23 = bVar.q().i();
        if (i23 != null) {
            i14 = i23.intValue();
        } else {
            i14 = 0;
        }
        networkProfile.setCriteriaHeightInchesFrom(i14);
        Integer j10 = bVar.q().j();
        int i24 = 11;
        if (j10 != null) {
            i15 = j10.intValue();
        } else {
            i15 = 11;
        }
        networkProfile.setCriteriaHeightInchesTo(i15);
        Integer e10 = bVar.q().e();
        int i25 = 122;
        if (e10 != null) {
            i16 = e10.intValue();
        } else {
            i16 = 122;
        }
        networkProfile.setCriteriaHeightCentimetersFrom(i16);
        Integer f10 = bVar.q().f();
        int i26 = Height.CENTIMETRES_MAX;
        if (f10 != null) {
            i17 = f10.intValue();
        } else {
            i17 = 272;
        }
        networkProfile.setCriteriaHeightCentimetersTo(i17);
        networkProfile.setMatchRegionName(bVar.r());
        networkProfile.setOnHold(bVar.t());
        networkProfile.setTextReason(bVar.j());
        if (bVar.i() == null) {
            str2 = null;
        } else {
            str2 = DateUtils.getFormattedUtcDateTimeFromOffsetDateTime(bVar.i());
        }
        networkProfile.setReactivateDate(str2);
        networkProfile.setLocation(bVar.p());
        networkProfile.setViewedCoachmarks(bVar.y());
        networkProfile.setPeronalReferralCode(bVar.v());
        networkProfile.setIcebreakers(q.f(bVar.n().a(), bVar.n().b(), bVar.n().c()));
        networkProfile.setBadgeCount(bVar.e());
        networkProfile.setAttendanceAwardDaysForNewUser(bVar.c());
        networkProfile.setHasPrioritizedLikes(bVar.m());
        networkProfile.setHasActiveBoost(bVar.l());
        networkProfile.setBoostReportId(bVar.h());
        networkProfile.setNumRisingBagels(bVar.s());
        networkProfile.setUserLastName(bVar.o());
        networkProfile.setZipcode(bVar.z());
        networkProfile.setHeightUnitIsMetric(bVar.x());
        networkProfile.setBeans(bVar.f());
        if (bVar.g() == null) {
            str3 = null;
        } else {
            str3 = DateUtils.getFormattedUtcDateTimeFromOffsetDateTime(bVar.g());
        }
        networkProfile.setBirthday(str3);
        Integer a11 = bVar.q().a();
        if (a11 != null) {
            i19 = a11.intValue();
        }
        networkProfile.setCriteriaAgeFrom(i19);
        Integer b11 = bVar.q().b();
        if (b11 != null) {
            i20 = b11.intValue();
        }
        networkProfile.setCriteriaAgeTo(i20);
        networkProfile.setCriteriaEthnicity(bVar.q().c());
        networkProfile.setCriteriaGender(bVar.q().d());
        networkProfile.setCriteriaReligion(bVar.q().m());
        networkProfile.setCriteriaDistanceMiles(bVar.q().l());
        networkProfile.setCriteriaDistanceKm(bVar.q().k());
        Integer g11 = bVar.q().g();
        if (g11 != null) {
            i21 = g11.intValue();
        }
        networkProfile.setCriteriaHeightFeetFrom(i21);
        Integer h11 = bVar.q().h();
        if (h11 != null) {
            i22 = h11.intValue();
        }
        networkProfile.setCriteriaHeightFeetTo(i22);
        Integer i27 = bVar.q().i();
        if (i27 != null) {
            i18 = i27.intValue();
        } else {
            i18 = 0;
        }
        networkProfile.setCriteriaHeightInchesFrom(i18);
        Integer j11 = bVar.q().j();
        if (j11 != null) {
            i24 = j11.intValue();
        }
        networkProfile.setCriteriaHeightInchesTo(i24);
        Integer e11 = bVar.q().e();
        if (e11 != null) {
            i25 = e11.intValue();
        }
        networkProfile.setCriteriaHeightCentimetersFrom(i25);
        Integer f11 = bVar.q().f();
        if (f11 != null) {
            i26 = f11.intValue();
        }
        networkProfile.setCriteriaHeightCentimetersTo(i26);
        networkProfile.setMatchRegionName(bVar.r());
        networkProfile.setOnHold(bVar.t());
        networkProfile.setTextReason(bVar.j());
        if (bVar.i() != null) {
            str4 = DateUtils.getFormattedUtcDateTimeFromOffsetDateTime(bVar.i());
        }
        networkProfile.setReactivateDate(str4);
        networkProfile.setLocation(bVar.p());
        networkProfile.setViewedCoachmarks(bVar.y());
        networkProfile.setPeronalReferralCode(bVar.v());
        networkProfile.setIcebreakers(q.f(bVar.n().a(), bVar.n().b(), bVar.n().c()));
        networkProfile.setBadgeCount(bVar.e());
        networkProfile.setAttendanceAwardDaysForNewUser(bVar.c());
        networkProfile.setHasPrioritizedLikes(bVar.m());
        networkProfile.setHasActiveBoost(bVar.l());
        networkProfile.setBoostReportId(bVar.h());
        networkProfile.setNumRisingBagels(bVar.s());
        networkProfile.setUserLastName(bVar.o());
        networkProfile.setZipcode(bVar.z());
        networkProfile.setHeightUnitIsMetric(bVar.x());
    }

    private static final com.coffeemeetsbagel.models.entities.Height b(NetworkProfile networkProfile) {
        if (networkProfile.getHeightCm() == 0 || (networkProfile.getHeightFeet() == 0 && networkProfile.getHeightInches() == 0)) {
            return null;
        }
        return new com.coffeemeetsbagel.models.entities.Height(networkProfile.getHeightCm(), networkProfile.getHeightFeet(), networkProfile.getHeightInches());
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.coffeemeetsbagel.models.entities.ProfileEntity c(com.coffeemeetsbagel.models.NetworkProfile r23) {
        /*
            java.lang.String r0 = "<this>"
            r1 = r23
            kotlin.jvm.internal.j.g(r1, r0)
            java.util.List r0 = r23.getListSchools()
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L_0x0016
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.Q(r0, r3)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0017
        L_0x0016:
            r0 = r2
        L_0x0017:
            r4 = 1
            if (r0 == 0) goto L_0x0023
            boolean r0 = kotlin.text.r.w(r0)
            if (r0 == 0) goto L_0x0021
            goto L_0x0023
        L_0x0021:
            r0 = r3
            goto L_0x0024
        L_0x0023:
            r0 = r4
        L_0x0024:
            if (r0 != 0) goto L_0x0067
            java.util.List r0 = r23.getListDegrees()
            if (r0 == 0) goto L_0x0033
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.Q(r0, r3)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0034
        L_0x0033:
            r0 = r2
        L_0x0034:
            if (r0 == 0) goto L_0x003f
            boolean r0 = kotlin.text.r.w(r0)
            if (r0 == 0) goto L_0x003d
            goto L_0x003f
        L_0x003d:
            r0 = r3
            goto L_0x0040
        L_0x003f:
            r0 = r4
        L_0x0040:
            if (r0 != 0) goto L_0x0067
            com.coffeemeetsbagel.models.entities.ProfileEducationEntity r0 = new com.coffeemeetsbagel.models.entities.ProfileEducationEntity
            java.util.List r5 = r23.getListSchools()
            java.lang.Object r5 = r5.get(r3)
            java.lang.String r6 = "this.listSchools[0]"
            kotlin.jvm.internal.j.f(r5, r6)
            java.lang.String r5 = (java.lang.String) r5
            java.util.List r6 = r23.getListDegrees()
            java.lang.Object r6 = r6.get(r3)
            java.lang.String r7 = "this.listDegrees[0]"
            kotlin.jvm.internal.j.f(r6, r7)
            java.lang.String r6 = (java.lang.String) r6
            r0.<init>(r5, r6)
            r12 = r0
            goto L_0x0068
        L_0x0067:
            r12 = r2
        L_0x0068:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r5 = r3
        L_0x006e:
            r6 = 3
            java.lang.String r7 = ""
            if (r5 >= r6) goto L_0x0094
            java.util.ArrayList r6 = r23.getIcebreakers()
            int r6 = r6.size()
            if (r6 <= r5) goto L_0x008e
            java.util.ArrayList r6 = r23.getIcebreakers()
            java.lang.Object r6 = r6.get(r5)
            java.lang.String r7 = "this.icebreakers[i]"
            kotlin.jvm.internal.j.f(r6, r7)
            r0.add(r6)
            goto L_0x0091
        L_0x008e:
            r0.add(r7)
        L_0x0091:
            int r5 = r5 + 1
            goto L_0x006e
        L_0x0094:
            java.util.List r0 = r23.getListSchools()
            if (r0 == 0) goto L_0x00a1
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.Q(r0, r4)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x00a2
        L_0x00a1:
            r0 = r2
        L_0x00a2:
            if (r0 == 0) goto L_0x00ad
            boolean r0 = kotlin.text.r.w(r0)
            if (r0 == 0) goto L_0x00ab
            goto L_0x00ad
        L_0x00ab:
            r0 = r3
            goto L_0x00ae
        L_0x00ad:
            r0 = r4
        L_0x00ae:
            if (r0 != 0) goto L_0x00ef
            java.util.List r0 = r23.getListDegrees()
            if (r0 == 0) goto L_0x00bd
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.Q(r0, r4)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x00be
        L_0x00bd:
            r0 = r2
        L_0x00be:
            if (r0 == 0) goto L_0x00c9
            boolean r0 = kotlin.text.r.w(r0)
            if (r0 == 0) goto L_0x00c7
            goto L_0x00c9
        L_0x00c7:
            r0 = r3
            goto L_0x00ca
        L_0x00c9:
            r0 = r4
        L_0x00ca:
            if (r0 != 0) goto L_0x00ef
            com.coffeemeetsbagel.models.entities.ProfileEducationEntity r2 = new com.coffeemeetsbagel.models.entities.ProfileEducationEntity
            java.util.List r0 = r23.getListSchools()
            java.lang.Object r0 = r0.get(r4)
            java.lang.String r5 = "this.listSchools[1]"
            kotlin.jvm.internal.j.f(r0, r5)
            java.lang.String r0 = (java.lang.String) r0
            java.util.List r5 = r23.getListDegrees()
            java.lang.Object r5 = r5.get(r4)
            java.lang.String r6 = "this.listDegrees[1]"
            kotlin.jvm.internal.j.f(r5, r6)
            java.lang.String r5 = (java.lang.String) r5
            r2.<init>(r0, r5)
        L_0x00ef:
            r21 = r2
            int r0 = r23.getAge()
            if (r0 <= 0) goto L_0x00fc
            int r0 = r23.getAge()
            goto L_0x0104
        L_0x00fc:
            java.lang.String r0 = r23.getBirthday()
            int r0 = com.coffeemeetsbagel.models.util.DateUtils.getAgeFromBirthday(r0)
        L_0x0104:
            r9 = r0
            java.lang.String r8 = r23.getId()
            java.lang.String r0 = "this.id"
            kotlin.jvm.internal.j.f(r8, r0)
            java.lang.String r0 = r23.getCity()
            if (r0 != 0) goto L_0x0116
            r10 = r7
            goto L_0x0117
        L_0x0116:
            r10 = r0
        L_0x0117:
            java.lang.String r0 = r23.getCountry()
            if (r0 != 0) goto L_0x011f
            r11 = r7
            goto L_0x0120
        L_0x011f:
            r11 = r0
        L_0x0120:
            java.lang.String r0 = r23.getEmployer()
            if (r0 != 0) goto L_0x0128
            r13 = r7
            goto L_0x0129
        L_0x0128:
            r13 = r0
        L_0x0129:
            java.lang.String r0 = r23.getEthnicity()
            if (r0 == 0) goto L_0x0135
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0136
        L_0x0135:
            r3 = r4
        L_0x0136:
            if (r3 == 0) goto L_0x013e
            java.util.List r0 = kotlin.collections.q.j()
            r14 = r0
            goto L_0x016d
        L_0x013e:
            java.lang.String r0 = r23.getEthnicity()
            java.util.List r0 = com.coffeemeetsbagel.models.util.StringUtils.splitStringByComma(r0)
            java.lang.String r2 = "splitStringByComma(this.ethnicity)"
            kotlin.jvm.internal.j.f(r0, r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x0154:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x016c
            java.lang.Object r3 = r0.next()
            java.lang.String r3 = (java.lang.String) r3
            com.coffeemeetsbagel.models.entities.EthnicityType$Companion r4 = com.coffeemeetsbagel.models.entities.EthnicityType.Companion
            com.coffeemeetsbagel.models.entities.EthnicityType r3 = r4.fromApiKey(r3)
            if (r3 == 0) goto L_0x0154
            r2.add(r3)
            goto L_0x0154
        L_0x016c:
            r14 = r2
        L_0x016d:
            java.lang.String r0 = r23.getUserFirstName()
            if (r0 != 0) goto L_0x0175
            r15 = r7
            goto L_0x0176
        L_0x0175:
            r15 = r0
        L_0x0176:
            com.coffeemeetsbagel.models.entities.GenderType$Companion r0 = com.coffeemeetsbagel.models.entities.GenderType.Companion
            java.lang.String r2 = r23.getGender()
            if (r2 != 0) goto L_0x017f
            r2 = r7
        L_0x017f:
            com.coffeemeetsbagel.models.entities.GenderType r16 = r0.fromApiKey(r2)
            com.coffeemeetsbagel.models.entities.Height r17 = b(r23)
            java.lang.String r0 = r23.getUserLastName()
            if (r0 != 0) goto L_0x0190
            r18 = r7
            goto L_0x0192
        L_0x0190:
            r18 = r0
        L_0x0192:
            java.lang.String r0 = r23.getOccupation()
            if (r0 != 0) goto L_0x019b
            r19 = r7
            goto L_0x019d
        L_0x019b:
            r19 = r0
        L_0x019d:
            com.coffeemeetsbagel.models.entities.ReligionType$Companion r0 = com.coffeemeetsbagel.models.entities.ReligionType.Companion
            java.lang.String r2 = r23.getReligionApiParam()
            com.coffeemeetsbagel.models.entities.ReligionType r20 = r0.fromApiKey(r2)
            java.lang.String r0 = r23.getState()
            if (r0 != 0) goto L_0x01b0
            r22 = r7
            goto L_0x01b2
        L_0x01b0:
            r22 = r0
        L_0x01b2:
            com.coffeemeetsbagel.models.entities.ProfileEntity r0 = new com.coffeemeetsbagel.models.entities.ProfileEntity
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.profile.ProfileMappersKt.c(com.coffeemeetsbagel.models.NetworkProfile):com.coffeemeetsbagel.models.entities.ProfileEntity");
    }

    public static final l d(ProfileEntity profileEntity) {
        n nVar;
        j.g(profileEntity, "<this>");
        String id2 = profileEntity.getId();
        int age = profileEntity.getAge();
        String city = profileEntity.getCity();
        String country = profileEntity.getCountry();
        ProfileEducationEntity education = profileEntity.getEducation();
        n nVar2 = null;
        if (education != null) {
            nVar = e(education);
        } else {
            nVar = null;
        }
        String employer = profileEntity.getEmployer();
        List<EthnicityType> ethnicities = profileEntity.getEthnicities();
        String firstName = profileEntity.getFirstName();
        GenderType gender = profileEntity.getGender();
        com.coffeemeetsbagel.models.entities.Height height = profileEntity.getHeight();
        String lastName = profileEntity.getLastName();
        String occupation = profileEntity.getOccupation();
        ReligionType religion = profileEntity.getReligion();
        ProfileEducationEntity secondaryEducation = profileEntity.getSecondaryEducation();
        if (secondaryEducation != null) {
            nVar2 = e(secondaryEducation);
        }
        return new l(id2, age, city, country, nVar, employer, ethnicities, firstName, gender, height, lastName, occupation, religion, nVar2, profileEntity.getState());
    }

    private static final n e(ProfileEducationEntity profileEducationEntity) {
        return new n(profileEducationEntity.getSchool(), profileEducationEntity.getDegreeId());
    }

    public static final NetworkProfile f(ProfileEntity profileEntity) {
        j.g(profileEntity, "<this>");
        return g(d(profileEntity), (b) null);
    }

    public static final NetworkProfile g(l lVar, b bVar) {
        int i10;
        float f10;
        String str;
        j.g(lVar, "<this>");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        n d10 = lVar.d();
        if (d10 != null) {
            arrayList.add(d10.b());
            arrayList2.add(d10.a());
        }
        n n10 = lVar.n();
        if (n10 != null) {
            arrayList.add(n10.b());
            arrayList2.add(n10.a());
        }
        NetworkProfile networkProfile = new NetworkProfile();
        networkProfile.setId(lVar.j());
        networkProfile.setAge(lVar.a());
        networkProfile.setCity(lVar.b());
        networkProfile.setCountry(lVar.c());
        networkProfile.setListSchools(arrayList);
        networkProfile.setListDegrees(arrayList2);
        networkProfile.setEmployer(lVar.e());
        networkProfile.setEthnicity(CollectionsKt___CollectionsKt.W(lVar.f(), AppsFlyerKit.COMMA, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, ProfileMappersKt$toNetwork$3$1.f36025a, 30, (Object) null));
        networkProfile.setUserFirstName(lVar.g());
        networkProfile.setGender(lVar.h().getApiKey());
        com.coffeemeetsbagel.models.entities.Height i11 = lVar.i();
        int i12 = 0;
        if (i11 != null) {
            i10 = i11.getHeightFeet();
        } else {
            i10 = 0;
        }
        networkProfile.setHeightFeet(i10);
        com.coffeemeetsbagel.models.entities.Height i13 = lVar.i();
        if (i13 != null) {
            i12 = i13.getHeightInches();
        }
        networkProfile.setHeightInches(i12);
        com.coffeemeetsbagel.models.entities.Height i14 = lVar.i();
        if (i14 != null) {
            f10 = (float) i14.getHeightCm();
        } else {
            f10 = 0.0f;
        }
        networkProfile.setHeightCm(f10);
        networkProfile.setUserLastName(lVar.k());
        networkProfile.setOccupation(lVar.l());
        ReligionType m10 = lVar.m();
        if (m10 != null) {
            str = m10.getApiKey();
        } else {
            str = null;
        }
        networkProfile.setReligion(str);
        networkProfile.setState(lVar.o());
        if (bVar != null) {
            a(networkProfile, bVar);
        }
        return networkProfile;
    }
}
