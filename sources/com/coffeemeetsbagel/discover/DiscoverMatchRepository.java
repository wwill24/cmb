package com.coffeemeetsbagel.discover;

import ck.b;
import com.coffeemeetsbagel.models.GiveTake;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.RisingGiveTake;
import com.coffeemeetsbagel.models.util.DateUtils;
import hb.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;
import t7.a;

public final class DiscoverMatchRepository {

    /* renamed from: a  reason: collision with root package name */
    private final f f12166a;

    /* renamed from: b  reason: collision with root package name */
    private final a f12167b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final c f12168c;

    public DiscoverMatchRepository(f fVar, a aVar, c cVar) {
        j.g(fVar, "remote");
        j.g(aVar, "databaseManager");
        j.g(cVar, "sharedPrefs");
        this.f12166a = fVar;
        this.f12167b = aVar;
        this.f12168c = cVar;
    }

    /* access modifiers changed from: private */
    public static final void e(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final b0 f(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    public final w<List<NetworkProfile>> d() {
        w<R> v10 = b.f24947a.a(this.f12166a.a(this.f12168c.r("givetake_current_token")), this.f12166a.b(this.f12168c.r("risinggivetakes_current_token"))).K(dk.a.c()).r(new a(new DiscoverMatchRepository$refresh$1(this))).v(new b(new DiscoverMatchRepository$refresh$2(this)));
        j.f(v10, "fun refresh(): Single<Li…    }\n            }\n    }");
        return v10;
    }

    public final void g(List<? extends GiveTake> list) {
        boolean z10;
        if (list == null || list.isEmpty()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            ArrayList arrayList = new ArrayList();
            for (T next : list) {
                if (!((GiveTake) next).isBlocked()) {
                    arrayList.add(next);
                }
            }
            if (this.f12167b.f("give_ten", h6.c.c(), "give_ten_end_date == ?", new String[]{String.valueOf(DateUtils.getMillisFromUtc(((GiveTake) arrayList.get(0)).getEndDate()))}).size() == 0) {
                this.f12167b.j("give_ten", (String) null, (String[]) null);
            }
            this.f12167b.e("give_ten", arrayList);
            return;
        }
        this.f12167b.j("give_ten", (String) null, (String[]) null);
    }

    public final void h(List<? extends RisingGiveTake> list) {
        boolean z10;
        if (list == null || list.isEmpty()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            ArrayList arrayList = new ArrayList();
            for (T next : list) {
                if (!((RisingGiveTake) next).isBlocked()) {
                    arrayList.add(next);
                }
            }
            this.f12167b.e("rising_give_take", arrayList);
        }
    }
}
