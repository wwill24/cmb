package com.coffeemeetsbagel.subscription_dialog.variants_carousel;

import b6.s;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.uber.autodispose.t;
import dk.a;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

public final class VariantsCarouselInteractor extends s<k, l> {

    /* renamed from: f  reason: collision with root package name */
    public SubscriptionRepository f37080f;

    /* renamed from: g  reason: collision with root package name */
    public n f37081g;

    /* renamed from: h  reason: collision with root package name */
    private final String f37082h;

    public VariantsCarouselInteractor() {
        String simpleName = VariantsCarouselInteractor.class.getSimpleName();
        j.f(simpleName, "VariantsCarouselInteractor::class.java.simpleName");
        this.f37082h = simpleName;
    }

    /* access modifiers changed from: private */
    public static final void K1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void L1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void P1(java.util.List<vb.d> r14) {
        /*
            r13 = this;
            r0 = 10
            int r0 = kotlin.collections.r.t(r14, r0)
            int r0 = kotlin.collections.g0.e(r0)
            r1 = 16
            int r0 = vk.j.c(r0, r1)
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>(r0)
            java.util.Iterator r0 = r14.iterator()
        L_0x0019:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x002e
            java.lang.Object r2 = r0.next()
            r3 = r2
            vb.d r3 = (vb.d) r3
            java.lang.String r3 = r3.h()
            r1.put(r3, r2)
            goto L_0x0019
        L_0x002e:
            boolean r0 = r14 instanceof java.util.Collection
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x003c
            boolean r0 = r14.isEmpty()
            if (r0 == 0) goto L_0x003c
        L_0x003a:
            r0 = r3
            goto L_0x005d
        L_0x003c:
            java.util.Iterator r0 = r14.iterator()
        L_0x0040:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x003a
            java.lang.Object r4 = r0.next()
            vb.d r4 = (vb.d) r4
            java.lang.String r4 = r4.i()
            com.coffeemeetsbagel.store.domain.VariantUnits r5 = com.coffeemeetsbagel.store.domain.VariantUnits.WEEK
            java.lang.String r5 = r5.b()
            boolean r4 = kotlin.jvm.internal.j.b(r4, r5)
            if (r4 == 0) goto L_0x0040
            r0 = r2
        L_0x005d:
            java.util.Iterator r4 = r14.iterator()
        L_0x0061:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00c0
            java.lang.Object r5 = r4.next()
            r12 = r5
            vb.d r12 = (vb.d) r12
            java.lang.String r5 = r12.g()
            java.lang.Object r5 = r1.get(r5)
            r8 = r5
            vb.d r8 = (vb.d) r8
            com.coffeemeetsbagel.models.RewardPrice r7 = r12.e()     // Catch:{ MissingResourceException -> 0x0096 }
            if (r7 == 0) goto L_0x0061
            P r5 = r13.f7875e     // Catch:{ MissingResourceException -> 0x0096 }
            com.coffeemeetsbagel.subscription_dialog.variants_carousel.k r5 = (com.coffeemeetsbagel.subscription_dialog.variants_carousel.k) r5     // Catch:{ MissingResourceException -> 0x0096 }
            com.coffeemeetsbagel.subscription_dialog.variants_carousel.n r10 = r13.M1()     // Catch:{ MissingResourceException -> 0x0096 }
            if (r8 == 0) goto L_0x008e
            com.coffeemeetsbagel.models.RewardPrice r6 = r8.e()     // Catch:{ MissingResourceException -> 0x0096 }
            goto L_0x008f
        L_0x008e:
            r6 = 0
        L_0x008f:
            r9 = r6
            r6 = r12
            r11 = r0
            r5.k(r6, r7, r8, r9, r10, r11)     // Catch:{ MissingResourceException -> 0x0096 }
            goto L_0x0061
        L_0x0096:
            r14 = move-exception
            fa.a$a r0 = fa.a.f40771d
            java.lang.String r1 = r13.f37082h
            java.lang.String r2 = r12.h()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Failed to display variant "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = "."
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r0.c(r1, r2, r14)
            com.coffeemeetsbagel.subscription_dialog.variants_carousel.n r14 = r13.M1()
            r14.a()
            return
        L_0x00c0:
            boolean r0 = r14.isEmpty()
            r0 = r0 ^ r2
            if (r0 == 0) goto L_0x00db
            java.lang.Object r14 = r14.get(r3)
            vb.d r14 = (vb.d) r14
            com.coffeemeetsbagel.subscription_dialog.variants_carousel.n r0 = r13.M1()
            r0.b(r14)
            P r0 = r13.f7875e
            com.coffeemeetsbagel.subscription_dialog.variants_carousel.k r0 = (com.coffeemeetsbagel.subscription_dialog.variants_carousel.k) r0
            r0.q(r14)
        L_0x00db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.subscription_dialog.variants_carousel.VariantsCarouselInteractor.P1(java.util.List):void");
    }

    public final n M1() {
        n nVar = this.f37081g;
        if (nVar != null) {
            return nVar;
        }
        j.y("relay");
        return null;
    }

    public final SubscriptionRepository N1() {
        SubscriptionRepository subscriptionRepository = this.f37080f;
        if (subscriptionRepository != null) {
            return subscriptionRepository;
        }
        j.y("subscriptionRepository");
        return null;
    }

    public final String O1() {
        return this.f37082h;
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        ((t) N1().X().L().K(a.c()).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new g(new VariantsCarouselInteractor$didBecomeActive$1(this)), new h(new VariantsCarouselInteractor$didBecomeActive$2(this)));
    }
}
