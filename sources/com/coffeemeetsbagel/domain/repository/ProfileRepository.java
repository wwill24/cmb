package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.ProfileDtoImplementation;
import com.coffeemeetsbagel.models.body.BlockProfileRequest;
import com.coffeemeetsbagel.models.dto.ProfileDataContract;
import com.coffeemeetsbagel.models.dto.ProfileDataContractKt;
import com.coffeemeetsbagel.models.entities.ProfileEducationEntity;
import com.coffeemeetsbagel.models.entities.ReligionType;
import com.mparticle.kits.AppsFlyerKit;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import ma.g;
import okhttp3.v;
import okhttp3.z;
import qj.b0;
import qj.h;
import qj.w;
import u6.i;
import u6.k;
import x6.d;

public final class ProfileRepository {

    /* renamed from: a  reason: collision with root package name */
    private final k f12412a;

    /* renamed from: b  reason: collision with root package name */
    private final g f12413b;

    /* renamed from: c  reason: collision with root package name */
    private final i f12414c;

    /* renamed from: d  reason: collision with root package name */
    private final t6.a f12415d;

    public static final class a extends BaseRepository<List<? extends ProfileDataContract>, NetworkProfile> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ProfileRepository f12416a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List<String> f12417b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f12418c;

        a(ProfileRepository profileRepository, List<String> list, String str) {
            this.f12416a = profileRepository;
            this.f12417b = list;
            this.f12418c = str;
        }

        /* access modifiers changed from: protected */
        public w<NetworkProfile> f() {
            return this.f12416a.k().a(this.f12418c);
        }

        /* access modifiers changed from: protected */
        public h<List<ProfileDataContract>> m() {
            return this.f12416a.j().f(this.f12417b);
        }

        /* access modifiers changed from: protected */
        /* renamed from: q */
        public List<ProfileDataContract> n(NetworkProfile networkProfile) {
            j.g(networkProfile, "networkResponse");
            return p.e(this.f12416a.g().b(networkProfile));
        }

        /* access modifiers changed from: protected */
        /* renamed from: r */
        public void o(List<? extends ProfileDataContract> list) {
            j.g(list, "data");
            ArrayList arrayList = new ArrayList(r.t(list, 10));
            for (ProfileDataContract roomEntity : list) {
                arrayList.add(ProfileDataContractKt.toRoomEntity(roomEntity));
            }
            this.f12416a.j().c(arrayList);
        }

        /* access modifiers changed from: protected */
        /* renamed from: s */
        public boolean p(List<? extends ProfileDataContract> list) {
            return list == null || list.isEmpty();
        }
    }

    public ProfileRepository(k kVar, g gVar, i iVar) {
        j.g(kVar, "profileDao");
        j.g(gVar, "profileNetworkService");
        j.g(iVar, "photoDao");
        this.f12412a = kVar;
        this.f12413b = gVar;
        this.f12414c = iVar;
        this.f12415d = new t6.a(kVar, iVar);
    }

    /* access modifiers changed from: private */
    public static final String f(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (String) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final d i(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (d) function1.invoke(obj);
    }

    private final w<Integer> l(ProfileDataContract profileDataContract, ModelProfileUpdateDelta modelProfileUpdateDelta) {
        z d10 = z.d(v.g("application/json"), modelProfileUpdateDelta.flush());
        g gVar = this.f12413b;
        j.f(d10, "requestBody");
        w<R> K = gVar.b(d10).v(new k0(new ProfileRepository$saveDeltaAndProfile$1(this, profileDataContract))).K(dk.a.c());
        j.f(K, "private fun saveDeltaAnd…On(Schedulers.io())\n    }");
        return K;
    }

    /* access modifiers changed from: private */
    public static final b0 m(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final b0 q(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    public final w<String> e(String str, String str2, String str3) {
        j.g(str, "profileId");
        w<R> K = this.f12413b.c(str, new BlockProfileRequest(str2, str3)).D(new l0(ProfileRepository$blockProfile$1.f12419a)).K(dk.a.c());
        j.f(K, "profileNetworkService.bl…scribeOn(Schedulers.io())");
        return K;
    }

    public final t6.a g() {
        return this.f12415d;
    }

    public final h<d<ProfileDataContract>> h(String str) {
        j.g(str, "id");
        h<d<ProfileDataContract>> Y = new a(this, p.e(str), str).j().Y(new j0(ProfileRepository$getProfile$2.f12420a));
        j.f(Y, "fun getProfile(id: Strin…act?>\n            }\n    }");
        return Y;
    }

    public final k j() {
        return this.f12412a;
    }

    public final g k() {
        return this.f12413b;
    }

    public final w<Integer> n(ProfileDtoImplementation profileDtoImplementation) {
        String str;
        String str2;
        String str3;
        String degreeId;
        j.g(profileDtoImplementation, "profile");
        ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
        ProfileEducationEntity education = profileDtoImplementation.getEducation();
        String str4 = "";
        if (education == null || (str = education.getSchool()) == null) {
            str = str4;
        }
        ProfileEducationEntity education2 = profileDtoImplementation.getEducation();
        if (education2 == null || (str2 = education2.getDegreeId()) == null) {
            str2 = str4;
        }
        ProfileEducationEntity secondaryEducation = profileDtoImplementation.getSecondaryEducation();
        if (secondaryEducation == null || (str3 = secondaryEducation.getSchool()) == null) {
            str3 = str4;
        }
        ProfileEducationEntity secondaryEducation2 = profileDtoImplementation.getSecondaryEducation();
        if (!(secondaryEducation2 == null || (degreeId = secondaryEducation2.getDegreeId()) == null)) {
            str4 = degreeId;
        }
        modelProfileUpdateDelta.updateEducation(str, str2, str3, str4);
        return l(profileDtoImplementation, modelProfileUpdateDelta);
    }

    public final w<Integer> o(ProfileDtoImplementation profileDtoImplementation) {
        j.g(profileDtoImplementation, "profile");
        ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
        modelProfileUpdateDelta.updateEthnicity(CollectionsKt___CollectionsKt.W(profileDtoImplementation.getEthnicities(), AppsFlyerKit.COMMA, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, ProfileRepository$saveEthnicities$1.f12421a, 30, (Object) null));
        return l(profileDtoImplementation, modelProfileUpdateDelta);
    }

    public final w<Integer> p(ProfileDtoImplementation profileDtoImplementation) {
        j.g(profileDtoImplementation, "profile");
        ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
        modelProfileUpdateDelta.updateGender(profileDtoImplementation.getGender().getApiKey());
        z d10 = z.d(v.g("application/json"), modelProfileUpdateDelta.flush());
        g gVar = this.f12413b;
        j.f(d10, "requestBody");
        w<R> K = gVar.b(d10).v(new i0(new ProfileRepository$saveGender$1(this, profileDtoImplementation))).K(dk.a.c());
        j.f(K, "fun saveGender(profile: …On(Schedulers.io())\n    }");
        return K;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final qj.w<java.lang.Integer> r(com.coffeemeetsbagel.models.ProfileDtoImplementation r5) {
        /*
            r4 = this;
            java.lang.String r0 = "profile"
            kotlin.jvm.internal.j.g(r5, r0)
            com.coffeemeetsbagel.models.entities.Height r0 = r5.getHeight()
            r1 = 0
            if (r0 == 0) goto L_0x0011
            int r0 = r0.getHeightCm()
            goto L_0x0012
        L_0x0011:
            r0 = r1
        L_0x0012:
            if (r0 <= 0) goto L_0x0026
            r0 = 1
            com.coffeemeetsbagel.models.Height r2 = new com.coffeemeetsbagel.models.Height
            com.coffeemeetsbagel.models.entities.Height r3 = r5.getHeight()
            if (r3 == 0) goto L_0x0021
            int r1 = r3.getHeightCm()
        L_0x0021:
            r2.<init>(r1)
            r1 = r0
            goto L_0x0043
        L_0x0026:
            com.coffeemeetsbagel.models.Height r2 = new com.coffeemeetsbagel.models.Height
            com.coffeemeetsbagel.models.entities.Height r0 = r5.getHeight()
            if (r0 == 0) goto L_0x0033
            int r0 = r0.getHeightFeet()
            goto L_0x0034
        L_0x0033:
            r0 = r1
        L_0x0034:
            com.coffeemeetsbagel.models.entities.Height r3 = r5.getHeight()
            if (r3 == 0) goto L_0x003f
            int r3 = r3.getHeightInches()
            goto L_0x0040
        L_0x003f:
            r3 = r1
        L_0x0040:
            r2.<init>(r0, r3)
        L_0x0043:
            com.coffeemeetsbagel.models.ModelProfileUpdateDelta r0 = new com.coffeemeetsbagel.models.ModelProfileUpdateDelta
            r0.<init>()
            r0.updateHeight(r2, r1)
            qj.w r5 = r4.l(r5, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.domain.repository.ProfileRepository.r(com.coffeemeetsbagel.models.ProfileDtoImplementation):qj.w");
    }

    public final w<Integer> s(ProfileDtoImplementation profileDtoImplementation) {
        j.g(profileDtoImplementation, "profile");
        ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
        modelProfileUpdateDelta.updateOccupation(profileDtoImplementation.getOccupation());
        return l(profileDtoImplementation, modelProfileUpdateDelta);
    }

    public final w<Integer> t(ProfileDtoImplementation profileDtoImplementation) {
        String str;
        j.g(profileDtoImplementation, "profile");
        ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
        ReligionType religion = profileDtoImplementation.getReligion();
        if (religion == null || (str = religion.getApiKey()) == null) {
            str = "";
        }
        modelProfileUpdateDelta.updateReligion(str);
        return l(profileDtoImplementation, modelProfileUpdateDelta);
    }

    public final w<Integer> u(ProfileDtoImplementation profileDtoImplementation) {
        j.g(profileDtoImplementation, "profile");
        ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
        modelProfileUpdateDelta.updateUserFirstAndLastName(new androidx.core.util.d(profileDtoImplementation.getFirstName(), profileDtoImplementation.getLastName()));
        return l(profileDtoImplementation, modelProfileUpdateDelta);
    }
}
