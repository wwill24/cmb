package com.coffeemeetsbagel.stickers;

import com.coffeemeetsbagel.models.StickerNetwork;
import dk.a;
import hb.c;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;
import u6.n;

public final class StickerRepository {

    /* renamed from: a  reason: collision with root package name */
    private final d f36666a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final n f36667b;

    /* renamed from: c  reason: collision with root package name */
    private final c f36668c;

    /* renamed from: d  reason: collision with root package name */
    private final int f36669d;

    /* renamed from: e  reason: collision with root package name */
    private final int f36670e = 3600000;

    public StickerRepository(d dVar, n nVar, c cVar, int i10) {
        j.g(dVar, "remote");
        j.g(nVar, "local");
        j.g(cVar, "sharedPrefs");
        this.f36666a = dVar;
        this.f36667b = nVar;
        this.f36668c = cVar;
        this.f36669d = i10;
    }

    /* access modifiers changed from: private */
    public final w<List<StickerNetwork>> f() {
        w<R> D = this.f36666a.a().D(new b(new StickerRepository$fetchFromRemote$1(this)));
        j.f(D, "private fun fetchFromRem…ckers\n            }\n    }");
        return D;
    }

    /* access modifiers changed from: private */
    public static final List g(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final b0 i(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final boolean j() {
        if (this.f36668c.l("last_sticker_sync_app_version") < this.f36669d) {
            return true;
        }
        if (System.currentTimeMillis() - this.f36668c.t("last_sticker_sync") >= ((long) (this.f36670e * 24))) {
            return true;
        }
        return false;
    }

    public final w<List<StickerNetwork>> h() {
        w<R> v10 = this.f36667b.a().K(a.c()).v(new a(new StickerRepository$getStickers$1(this)));
        j.f(v10, "fun getStickers(): Singl…    }\n            }\n    }");
        return v10;
    }
}
