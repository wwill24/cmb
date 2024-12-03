package com.coffeemeetsbagel.match;

import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.enums.BagelAction;
import kotlin.jvm.internal.j;
import qj.w;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final BagelRepository f34499a;

    /* renamed from: b  reason: collision with root package name */
    private final w f34500b;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f34501a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.coffeemeetsbagel.models.enums.BagelAction[] r0 = com.coffeemeetsbagel.models.enums.BagelAction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.models.enums.BagelAction r1 = com.coffeemeetsbagel.models.enums.BagelAction.LIKE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.models.enums.BagelAction r1 = com.coffeemeetsbagel.models.enums.BagelAction.PASS     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.coffeemeetsbagel.models.enums.BagelAction r1 = com.coffeemeetsbagel.models.enums.BagelAction.CHECK     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f34501a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.match.d.a.<clinit>():void");
        }
    }

    public d(BagelRepository bagelRepository, w wVar) {
        j.g(bagelRepository, "repository");
        j.g(wVar, "actedOnCache");
        this.f34499a = bagelRepository;
        this.f34500b = wVar;
    }

    /* access modifiers changed from: private */
    public static final void e(d dVar, Bagel bagel) {
        j.g(dVar, "this$0");
        j.g(bagel, "$bagel");
        dVar.f34500b.b(bagel.getId());
    }

    /* access modifiers changed from: private */
    public static final void f(d dVar, Bagel bagel) {
        j.g(dVar, "this$0");
        j.g(bagel, "$bagel");
        dVar.f34500b.b(bagel.getId());
    }

    /* access modifiers changed from: private */
    public static final void g(d dVar, Bagel bagel) {
        j.g(dVar, "this$0");
        j.g(bagel, "$bagel");
        dVar.f34500b.remove(bagel.getId());
    }

    public final w<Bagel> d(Bagel bagel, BagelAction bagelAction) {
        qj.a aVar;
        j.g(bagel, Extra.BAGEL);
        j.g(bagelAction, "bagelAction");
        int i10 = a.f34501a[bagelAction.ordinal()];
        if (i10 == 1) {
            aVar = qj.a.w(new a(this, bagel));
        } else if (i10 == 2) {
            aVar = qj.a.w(new b(this, bagel));
        } else if (i10 != 3) {
            aVar = qj.a.m();
        } else {
            aVar = qj.a.w(new c(this, bagel));
        }
        j.f(aVar, "when (bagelAction) {\n   …able.complete()\n        }");
        bagel.setAction(bagelAction.getId());
        w<Bagel> c10 = aVar.c(this.f34499a.i(bagel));
        j.f(c10, "firstStep\n            .a…ionOnBagel(bagelMutated))");
        return c10;
    }
}
