package com.coffeemeetsbagel.database.room_mappers;

import com.coffeemeetsbagel.database.CmbDatabase;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.entities.EthnicityType;
import com.coffeemeetsbagel.models.entities.GenderType;
import com.coffeemeetsbagel.models.entities.Height;
import com.coffeemeetsbagel.models.entities.ProfileEducationEntity;
import com.coffeemeetsbagel.models.entities.ProfileEntity;
import com.coffeemeetsbagel.models.entities.ReligionType;
import com.coffeemeetsbagel.models.util.DateUtils;
import fa.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final CmbDatabase f11978a;

    /* renamed from: b  reason: collision with root package name */
    private final String f11979b = "ProfileMapper";

    public c(CmbDatabase cmbDatabase) {
        j.g(cmbDatabase, "cmbDatabase");
        this.f11978a = cmbDatabase;
    }

    private final int a(NetworkProfile networkProfile) {
        if (networkProfile.getAge() > 0) {
            return networkProfile.getAge();
        }
        return DateUtils.getAgeFromBirthday(networkProfile.getBirthday());
    }

    private final ProfileEducationEntity b(NetworkProfile networkProfile, int i10) {
        String str;
        String str2;
        List<String> listSchools = networkProfile.getListSchools();
        ProfileEducationEntity profileEducationEntity = null;
        if (listSchools != null) {
            str = (String) CollectionsKt___CollectionsKt.Q(listSchools, i10);
        } else {
            str = null;
        }
        List<String> listDegrees = networkProfile.getListDegrees();
        if (listDegrees != null) {
            str2 = (String) CollectionsKt___CollectionsKt.Q(listDegrees, i10);
        } else {
            str2 = null;
        }
        if (!(str == null && str2 == null)) {
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            profileEducationEntity = new ProfileEducationEntity(str, str2);
        }
        return profileEducationEntity;
    }

    private final List<EthnicityType> c(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String fromApiKey : list) {
            EthnicityType fromApiKey2 = EthnicityType.Companion.fromApiKey(fromApiKey);
            if (fromApiKey2 != null) {
                arrayList.add(fromApiKey2);
            }
        }
        return CollectionsKt___CollectionsKt.F(arrayList);
    }

    private final Height d(NetworkProfile networkProfile) {
        if (networkProfile.getHeightCm() == 0 || (networkProfile.getHeightFeet() == 0 && networkProfile.getHeightInches() == 0)) {
            return null;
        }
        return new Height(networkProfile.getHeightCm(), networkProfile.getHeightFeet(), networkProfile.getHeightInches());
    }

    public final int e(List<? extends NetworkProfile> list) {
        j.g(list, "profiles");
        ArrayList arrayList = new ArrayList();
        for (NetworkProfile f10 : list) {
            ProfileEntity f11 = f(f10);
            if (f11 != null) {
                arrayList.add(f11);
            }
        }
        return this.f11978a.U().o(arrayList);
    }

    public final ProfileEntity f(NetworkProfile networkProfile) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        NetworkProfile networkProfile2 = networkProfile;
        j.g(networkProfile2, "profile");
        try {
            String id2 = networkProfile.getId();
            j.f(id2, "profile.id");
            int a10 = a(networkProfile);
            String city = networkProfile.getCity();
            if (city == null) {
                str = "";
            } else {
                str = city;
            }
            String country = networkProfile.getCountry();
            if (country == null) {
                str2 = "";
            } else {
                str2 = country;
            }
            ProfileEducationEntity b10 = b(networkProfile2, 0);
            String employer = networkProfile.getEmployer();
            if (employer == null) {
                str3 = "";
            } else {
                str3 = employer;
            }
            List<String> ethnicityAsApiParamsList = networkProfile.getEthnicityAsApiParamsList();
            j.f(ethnicityAsApiParamsList, "profile.ethnicityAsApiParamsList");
            List<EthnicityType> c10 = c(ethnicityAsApiParamsList);
            String userFirstName = networkProfile.getUserFirstName();
            if (userFirstName == null) {
                str4 = "";
            } else {
                str4 = userFirstName;
            }
            GenderType.Companion companion = GenderType.Companion;
            String gender = networkProfile.getGender();
            if (gender == null) {
                gender = "";
            }
            GenderType fromApiKey = companion.fromApiKey(gender);
            Height d10 = d(networkProfile);
            String userLastName = networkProfile.getUserLastName();
            if (userLastName == null) {
                str5 = "";
            } else {
                str5 = userLastName;
            }
            String occupation = networkProfile.getOccupation();
            if (occupation == null) {
                str6 = "";
            } else {
                str6 = occupation;
            }
            String str8 = "";
            ReligionType fromApiKey2 = ReligionType.Companion.fromApiKey(networkProfile.getReligionApiParam());
            ProfileEducationEntity b11 = b(networkProfile2, 1);
            String state = networkProfile.getState();
            if (state == null) {
                str7 = str8;
            } else {
                str7 = state;
            }
            return new ProfileEntity(id2, a10, str, str2, b10, str3, c10, str4, fromApiKey, d10, str5, str6, fromApiKey2, b11, str7);
        } catch (IllegalStateException e10) {
            a.C0491a aVar = a.f40771d;
            String str9 = this.f11979b;
            aVar.c(str9, "Failed to map Profile from network to db for profile " + networkProfile.getId(), e10);
            return null;
        }
    }
}
