package com.coffeemeetsbagel.profile;

import com.coffeemeetsbagel.models.constants.ProfileConstants;
import com.coffeemeetsbagel.models.entities.EthnicityType;
import com.coffeemeetsbagel.models.entities.GenderType;
import com.coffeemeetsbagel.models.entities.Height;
import com.coffeemeetsbagel.models.entities.ReligionType;
import com.leanplum.internal.Constants;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    private final String f36103a;

    /* renamed from: b  reason: collision with root package name */
    private final int f36104b;

    /* renamed from: c  reason: collision with root package name */
    private final String f36105c;

    /* renamed from: d  reason: collision with root package name */
    private final String f36106d;

    /* renamed from: e  reason: collision with root package name */
    private final n f36107e;

    /* renamed from: f  reason: collision with root package name */
    private final String f36108f;

    /* renamed from: g  reason: collision with root package name */
    private final List<EthnicityType> f36109g;

    /* renamed from: h  reason: collision with root package name */
    private final String f36110h;

    /* renamed from: i  reason: collision with root package name */
    private final GenderType f36111i;

    /* renamed from: j  reason: collision with root package name */
    private final Height f36112j;

    /* renamed from: k  reason: collision with root package name */
    private final String f36113k;

    /* renamed from: l  reason: collision with root package name */
    private final String f36114l;

    /* renamed from: m  reason: collision with root package name */
    private final ReligionType f36115m;

    /* renamed from: n  reason: collision with root package name */
    private final n f36116n;

    /* renamed from: o  reason: collision with root package name */
    private final String f36117o;

    public l(String str, int i10, String str2, String str3, n nVar, String str4, List<? extends EthnicityType> list, String str5, GenderType genderType, Height height, String str6, String str7, ReligionType religionType, n nVar2, String str8) {
        String str9 = str3;
        String str10 = str4;
        List<? extends EthnicityType> list2 = list;
        String str11 = str5;
        GenderType genderType2 = genderType;
        String str12 = str6;
        String str13 = str7;
        String str14 = str8;
        j.g(str, "id");
        j.g(str2, Constants.Keys.CITY);
        j.g(str9, "country");
        j.g(str10, ProfileConstants.Field.USER_EMPLOYER);
        j.g(list2, "ethnicities");
        j.g(str11, "firstName");
        j.g(genderType2, ProfileConstants.Field.GENDER);
        j.g(str12, "lastName");
        j.g(str13, ProfileConstants.Field.USER_OCCUPATION);
        j.g(str14, "state");
        this.f36103a = str;
        this.f36104b = i10;
        this.f36105c = str2;
        this.f36106d = str9;
        this.f36107e = nVar;
        this.f36108f = str10;
        this.f36109g = list2;
        this.f36110h = str11;
        this.f36111i = genderType2;
        this.f36112j = height;
        this.f36113k = str12;
        this.f36114l = str13;
        this.f36115m = religionType;
        this.f36116n = nVar2;
        this.f36117o = str14;
    }

    public final int a() {
        return this.f36104b;
    }

    public final String b() {
        return this.f36105c;
    }

    public final String c() {
        return this.f36106d;
    }

    public final n d() {
        return this.f36107e;
    }

    public final String e() {
        return this.f36108f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return j.b(this.f36103a, lVar.f36103a) && this.f36104b == lVar.f36104b && j.b(this.f36105c, lVar.f36105c) && j.b(this.f36106d, lVar.f36106d) && j.b(this.f36107e, lVar.f36107e) && j.b(this.f36108f, lVar.f36108f) && j.b(this.f36109g, lVar.f36109g) && j.b(this.f36110h, lVar.f36110h) && this.f36111i == lVar.f36111i && j.b(this.f36112j, lVar.f36112j) && j.b(this.f36113k, lVar.f36113k) && j.b(this.f36114l, lVar.f36114l) && this.f36115m == lVar.f36115m && j.b(this.f36116n, lVar.f36116n) && j.b(this.f36117o, lVar.f36117o);
    }

    public final List<EthnicityType> f() {
        return this.f36109g;
    }

    public final String g() {
        return this.f36110h;
    }

    public final GenderType h() {
        return this.f36111i;
    }

    public int hashCode() {
        int hashCode = ((((((this.f36103a.hashCode() * 31) + Integer.hashCode(this.f36104b)) * 31) + this.f36105c.hashCode()) * 31) + this.f36106d.hashCode()) * 31;
        n nVar = this.f36107e;
        int i10 = 0;
        int hashCode2 = (((((((((hashCode + (nVar == null ? 0 : nVar.hashCode())) * 31) + this.f36108f.hashCode()) * 31) + this.f36109g.hashCode()) * 31) + this.f36110h.hashCode()) * 31) + this.f36111i.hashCode()) * 31;
        Height height = this.f36112j;
        int hashCode3 = (((((hashCode2 + (height == null ? 0 : height.hashCode())) * 31) + this.f36113k.hashCode()) * 31) + this.f36114l.hashCode()) * 31;
        ReligionType religionType = this.f36115m;
        int hashCode4 = (hashCode3 + (religionType == null ? 0 : religionType.hashCode())) * 31;
        n nVar2 = this.f36116n;
        if (nVar2 != null) {
            i10 = nVar2.hashCode();
        }
        return ((hashCode4 + i10) * 31) + this.f36117o.hashCode();
    }

    public final Height i() {
        return this.f36112j;
    }

    public final String j() {
        return this.f36103a;
    }

    public final String k() {
        return this.f36113k;
    }

    public final String l() {
        return this.f36114l;
    }

    public final ReligionType m() {
        return this.f36115m;
    }

    public final n n() {
        return this.f36116n;
    }

    public final String o() {
        return this.f36117o;
    }

    public String toString() {
        return "Profile(id=" + this.f36103a + ", age=" + this.f36104b + ", city=" + this.f36105c + ", country=" + this.f36106d + ", education=" + this.f36107e + ", employer=" + this.f36108f + ", ethnicities=" + this.f36109g + ", firstName=" + this.f36110h + ", gender=" + this.f36111i + ", height=" + this.f36112j + ", lastName=" + this.f36113k + ", occupation=" + this.f36114l + ", religion=" + this.f36115m + ", secondaryEducation=" + this.f36116n + ", state=" + this.f36117o + PropertyUtils.MAPPED_DELIM2;
    }
}
