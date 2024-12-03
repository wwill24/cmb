package l8;

import android.content.Context;
import com.coffeemeetsbagel.experiment.r;
import com.coffeemeetsbagel.feature.bagel.s;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import d7.g;
import d7.l;
import fj.d;
import fk.a;
import hb.c;
import r7.f;

public final class k1 implements d<h> {

    /* renamed from: a  reason: collision with root package name */
    private final a<ProfileRepositoryV2> f16135a;

    /* renamed from: b  reason: collision with root package name */
    private final a<s> f16136b;

    /* renamed from: c  reason: collision with root package name */
    private final a<Context> f16137c;

    /* renamed from: d  reason: collision with root package name */
    private final a<n8.s> f16138d;

    /* renamed from: e  reason: collision with root package name */
    private final a<g> f16139e;

    /* renamed from: f  reason: collision with root package name */
    private final a<c> f16140f;

    /* renamed from: g  reason: collision with root package name */
    private final a<ProfileManager> f16141g;

    /* renamed from: h  reason: collision with root package name */
    private final a<o2> f16142h;

    /* renamed from: i  reason: collision with root package name */
    private final a<l> f16143i;

    /* renamed from: j  reason: collision with root package name */
    private final a<f> f16144j;

    /* renamed from: k  reason: collision with root package name */
    private final a<i5.a> f16145k;

    /* renamed from: l  reason: collision with root package name */
    private final a<a7.a> f16146l;

    /* renamed from: m  reason: collision with root package name */
    private final a<r> f16147m;

    public k1(a<ProfileRepositoryV2> aVar, a<s> aVar2, a<Context> aVar3, a<n8.s> aVar4, a<g> aVar5, a<c> aVar6, a<ProfileManager> aVar7, a<o2> aVar8, a<l> aVar9, a<f> aVar10, a<i5.a> aVar11, a<a7.a> aVar12, a<r> aVar13) {
        this.f16135a = aVar;
        this.f16136b = aVar2;
        this.f16137c = aVar3;
        this.f16138d = aVar4;
        this.f16139e = aVar5;
        this.f16140f = aVar6;
        this.f16141g = aVar7;
        this.f16142h = aVar8;
        this.f16143i = aVar9;
        this.f16144j = aVar10;
        this.f16145k = aVar11;
        this.f16146l = aVar12;
        this.f16147m = aVar13;
    }

    public static k1 a(a<ProfileRepositoryV2> aVar, a<s> aVar2, a<Context> aVar3, a<n8.s> aVar4, a<g> aVar5, a<c> aVar6, a<ProfileManager> aVar7, a<o2> aVar8, a<l> aVar9, a<f> aVar10, a<i5.a> aVar11, a<a7.a> aVar12, a<r> aVar13) {
        return new k1(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10, aVar11, aVar12, aVar13);
    }

    public static h c(ProfileRepositoryV2 profileRepositoryV2, s sVar, Context context, n8.s sVar2, g gVar, c cVar, ProfileManager profileManager, o2 o2Var, l lVar, f fVar, i5.a aVar, a7.a aVar2, r rVar) {
        return (h) fj.g.e(i1.b(profileRepositoryV2, sVar, context, sVar2, gVar, cVar, profileManager, o2Var, lVar, fVar, aVar, aVar2, rVar));
    }

    /* renamed from: b */
    public h get() {
        return c(this.f16135a.get(), this.f16136b.get(), this.f16137c.get(), this.f16138d.get(), this.f16139e.get(), this.f16140f.get(), this.f16141g.get(), this.f16142h.get(), this.f16143i.get(), this.f16144j.get(), this.f16145k.get(), this.f16146l.get(), this.f16147m.get());
    }
}
