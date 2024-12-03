package com.coffeemeetsbagel.feature.chatlist;

import android.database.Cursor;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import f6.a2;
import f7.a;
import java.util.Optional;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;
import u6.e;

public final class GetBagelUseCase {

    /* renamed from: a  reason: collision with root package name */
    private final a f12889a;

    /* renamed from: b  reason: collision with root package name */
    private final a2 f12890b;

    /* renamed from: c  reason: collision with root package name */
    private final e f12891c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final ProfileRepositoryV2 f12892d;

    public GetBagelUseCase(a aVar, a2 a2Var, e eVar, ProfileRepositoryV2 profileRepositoryV2) {
        j.g(aVar, "bagelCursorUtils");
        j.g(a2Var, "databaseOpenHelper");
        j.g(eVar, "connectionDetailsDao");
        j.g(profileRepositoryV2, "profileRepositoryV2");
        this.f12889a = aVar;
        this.f12890b = a2Var;
        this.f12891c = eVar;
        this.f12892d = profileRepositoryV2;
    }

    private final Cursor d(String str) {
        Cursor query = this.f12890b.getReadableDatabase().query("(select * from bagel) ", (String[]) null, "bagel_id = ?", new String[]{str}, (String) null, (String) null, (String) null);
        j.f(query, "databaseOpenHelper.reada…           null\n        )");
        return query;
    }

    /* access modifiers changed from: private */
    public static final Optional f(GetBagelUseCase getBagelUseCase, String str) {
        j.g(getBagelUseCase, "this$0");
        j.g(str, "$matchId");
        Cursor d10 = getBagelUseCase.d(str);
        if (!d10.moveToFirst()) {
            return Optional.empty();
        }
        Bagel c10 = getBagelUseCase.f12889a.c(d10, false);
        e eVar = getBagelUseCase.f12891c;
        String profileId = c10.getProfileId();
        j.f(profileId, "bagel.profileId");
        c10.setConnectionDetails(eVar.c(profileId));
        if (!d10.isClosed()) {
            d10.close();
        }
        return Optional.of(c10);
    }

    /* access modifiers changed from: private */
    public static final b0 g(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    public final w<Optional<Bagel>> e(String str) {
        j.g(str, "matchId");
        w<Optional<Bagel>> v10 = w.A(new w0(this, str)).K(dk.a.c()).v(new x0(new GetBagelUseCase$invoke$2(this)));
        j.f(v10, "operator fun invoke(matc…    }\n            }\n    }");
        return v10;
    }
}
