package com.coffeemeetsbagel.likes_you;

import com.coffeemeetsbagel.likesyou.db.LikesYouGroupWithCards;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class LikesYouViewModel$fetchAndRenderLikesYouCards$disposable$4 extends Lambda implements Function1<Pair<? extends LikesYouGroupWithCards, ? extends Boolean>, Unit> {
    final /* synthetic */ String $groupId;
    final /* synthetic */ long $startTime;
    final /* synthetic */ String $tabName;
    final /* synthetic */ int $tabPosition;
    final /* synthetic */ LikesYouViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikesYouViewModel$fetchAndRenderLikesYouCards$disposable$4(long j10, LikesYouViewModel likesYouViewModel, String str, String str2, int i10) {
        super(1);
        this.$startTime = j10;
        this.this$0 = likesYouViewModel;
        this.$groupId = str;
        this.$tabName = str2;
        this.$tabPosition = i10;
    }

    /* access modifiers changed from: private */
    public static final int d(Function2 function2, Object obj, Object obj2) {
        j.g(function2, "$tmp0");
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    /* JADX WARNING: type inference failed for: r9v9, types: [com.coffeemeetsbagel.likes_you.presentation.LikesYouGridUiItem$c] */
    /* JADX WARNING: type inference failed for: r9v11, types: [com.coffeemeetsbagel.likes_you.presentation.LikesYouGridUiItem$c] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(kotlin.Pair<com.coffeemeetsbagel.likesyou.db.LikesYouGroupWithCards, java.lang.Boolean> r20) {
        /*
            r19 = this;
            r0 = r19
            java.lang.Object r1 = r20.a()
            com.coffeemeetsbagel.likesyou.db.LikesYouGroupWithCards r1 = (com.coffeemeetsbagel.likesyou.db.LikesYouGroupWithCards) r1
            java.lang.Object r2 = r20.b()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            long r3 = java.lang.System.currentTimeMillis()
            long r5 = r0.$startTime
            long r3 = r3 - r5
            fa.a$a r5 = fa.a.f40771d
            com.coffeemeetsbagel.likes_you.LikesYouViewModel r6 = r0.this$0
            java.lang.String r6 = r6.f34140u
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "time taken to fetch likes you is "
            r7.append(r8)
            r7.append(r3)
            java.lang.String r3 = " ms"
            r7.append(r3)
            java.lang.String r3 = r7.toString()
            r5.a(r6, r3)
            com.coffeemeetsbagel.likes_you.LikesYouViewModel r3 = r0.this$0
            java.lang.String r4 = "canSeeAllLikesYou"
            kotlin.jvm.internal.j.f(r2, r4)
            boolean r4 = r2.booleanValue()
            r3.f34143x = r4
            com.coffeemeetsbagel.likes_you.LikesYouViewModel r3 = r0.this$0
            java.lang.String r3 = r3.f34140u
            java.lang.String r4 = "Can user see all their likes?"
            r5.a(r3, r4)
            com.coffeemeetsbagel.models.entities.LikesYouGroupEntity r3 = r1.getGroup()
            java.util.List r3 = r3.getFreeProfileIds()
            java.util.List r4 = r1.getCards()
            com.coffeemeetsbagel.likes_you.LikesYouViewModel$fetchAndRenderLikesYouCards$disposable$4$sortedMatches$1 r5 = new com.coffeemeetsbagel.likes_you.LikesYouViewModel$fetchAndRenderLikesYouCards$disposable$4$sortedMatches$1
            r5.<init>(r3)
            com.coffeemeetsbagel.likes_you.k0 r3 = new com.coffeemeetsbagel.likes_you.k0
            r3.<init>(r5)
            java.util.List r3 = kotlin.collections.CollectionsKt___CollectionsKt.q0(r4, r3)
            com.coffeemeetsbagel.likes_you.LikesYouViewModel r4 = r0.this$0
            java.lang.String r5 = r0.$groupId
            java.util.ArrayList r6 = new java.util.ArrayList
            r7 = 10
            int r8 = kotlin.collections.r.t(r3, r7)
            r6.<init>(r8)
            java.util.Iterator r3 = r3.iterator()
            r8 = 0
            r9 = r8
        L_0x007e:
            boolean r10 = r3.hasNext()
            if (r10 == 0) goto L_0x00f3
            java.lang.Object r10 = r3.next()
            int r11 = r9 + 1
            if (r9 >= 0) goto L_0x008f
            kotlin.collections.q.s()
        L_0x008f:
            com.coffeemeetsbagel.models.entities.LikesYouCardEntity r10 = (com.coffeemeetsbagel.models.entities.LikesYouCardEntity) r10
            boolean r12 = r2.booleanValue()
            if (r12 == 0) goto L_0x00aa
            com.coffeemeetsbagel.likes_you.presentation.LikesYouGridUiItem$a r9 = com.coffeemeetsbagel.likes_you.presentation.LikesYouGridUiItem.f34264b
            bb.a r12 = r4.f34126g
            int r13 = com.coffeemeetsbagel.likes_you.t0.instant_like_instant_like
            java.lang.Object[] r14 = new java.lang.Object[r8]
            java.lang.String r12 = r12.a(r13, r14)
            com.coffeemeetsbagel.likes_you.presentation.LikesYouGridUiItem$c r9 = r9.a(r10, r12, r8)
            goto L_0x00ee
        L_0x00aa:
            com.coffeemeetsbagel.likes_you.presentation.MainGroups r12 = com.coffeemeetsbagel.likes_you.presentation.MainGroups.ALL
            java.lang.String r12 = r12.b()
            boolean r12 = kotlin.jvm.internal.j.b(r5, r12)
            if (r12 == 0) goto L_0x00d1
            com.coffeemeetsbagel.likes_you.presentation.LikesYouGridUiItem$a r12 = com.coffeemeetsbagel.likes_you.presentation.LikesYouGridUiItem.f34264b
            bb.a r13 = r4.f34126g
            int r14 = com.coffeemeetsbagel.likes_you.t0.instant_like_instant_like
            java.lang.Object[] r15 = new java.lang.Object[r8]
            java.lang.String r13 = r13.a(r14, r15)
            com.coffeemeetsbagel.models.enums.PurchaseAttribution r14 = r10.getPurchaseAttribution()
            boolean r9 = r4.n0(r14, r9)
            com.coffeemeetsbagel.likes_you.presentation.LikesYouGridUiItem$c r9 = r12.a(r10, r13, r9)
            goto L_0x00ee
        L_0x00d1:
            com.coffeemeetsbagel.likes_you.presentation.LikesYouGridUiItem$d r9 = new com.coffeemeetsbagel.likes_you.presentation.LikesYouGridUiItem$d
            java.lang.String r12 = r10.getImageUrl()
            if (r12 != 0) goto L_0x00db
            java.lang.String r12 = ""
        L_0x00db:
            r13 = r12
            java.lang.String r14 = r10.getProfileId()
            com.coffeemeetsbagel.models.enums.PurchaseAttribution r15 = r10.getPurchaseAttribution()
            r16 = 0
            r17 = 8
            r18 = 0
            r12 = r9
            r12.<init>(r13, r14, r15, r16, r17, r18)
        L_0x00ee:
            r6.add(r9)
            r9 = r11
            goto L_0x007e
        L_0x00f3:
            java.util.List r2 = r1.getPaywallCards()
            java.util.ArrayList r3 = new java.util.ArrayList
            int r4 = kotlin.collections.r.t(r2, r7)
            r3.<init>(r4)
            java.util.Iterator r2 = r2.iterator()
        L_0x0104:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x011a
            java.lang.Object r4 = r2.next()
            com.coffeemeetsbagel.models.entities.LikesYouPaywallCard r4 = (com.coffeemeetsbagel.models.entities.LikesYouPaywallCard) r4
            com.coffeemeetsbagel.likes_you.presentation.LikesYouGridUiItem$a r5 = com.coffeemeetsbagel.likes_you.presentation.LikesYouGridUiItem.f34264b
            com.coffeemeetsbagel.likes_you.presentation.LikesYouGridUiItem$d r4 = r5.b(r4)
            r3.add(r4)
            goto L_0x0104
        L_0x011a:
            boolean r2 = r6.isEmpty()
            r4 = 1
            r2 = r2 ^ r4
            if (r2 != 0) goto L_0x012c
            boolean r2 = r3.isEmpty()
            r2 = r2 ^ r4
            if (r2 == 0) goto L_0x012a
            goto L_0x012c
        L_0x012a:
            r2 = r8
            goto L_0x012d
        L_0x012c:
            r2 = r4
        L_0x012d:
            com.coffeemeetsbagel.likes_you.LikesYouViewModel r5 = r0.this$0
            boolean r5 = r5.f34143x
            if (r5 != 0) goto L_0x0147
            if (r2 == 0) goto L_0x0147
            java.lang.String r5 = r0.$groupId
            com.coffeemeetsbagel.likes_you.presentation.MainGroups r7 = com.coffeemeetsbagel.likes_you.presentation.MainGroups.ALL
            java.lang.String r7 = r7.b()
            boolean r5 = kotlin.jvm.internal.j.b(r5, r7)
            if (r5 != 0) goto L_0x0147
            r5 = r4
            goto L_0x0148
        L_0x0147:
            r5 = r8
        L_0x0148:
            if (r5 == 0) goto L_0x016c
            com.coffeemeetsbagel.likes_you.presentation.LikesYouGridUiItem$e r5 = new com.coffeemeetsbagel.likes_you.presentation.LikesYouGridUiItem$e
            r10 = 0
            com.coffeemeetsbagel.likes_you.LikesYouViewModel r7 = r0.this$0
            bb.a r7 = r7.f34126g
            int r9 = com.coffeemeetsbagel.likes_you.t0.likes_you_upsell_other_group
            java.lang.Object[] r11 = new java.lang.Object[r4]
            java.lang.String r12 = r0.$tabName
            r11[r8] = r12
            java.lang.String r11 = r7.a(r9, r11)
            int r12 = com.coffeemeetsbagel.likes_you.q0.ic_heart_lock
            r13 = 1
            r14 = 0
            r9 = r5
            r9.<init>(r10, r11, r12, r13, r14)
            java.util.List r5 = kotlin.collections.p.e(r5)
            goto L_0x0170
        L_0x016c:
            java.util.List r5 = kotlin.collections.q.j()
        L_0x0170:
            if (r2 == 0) goto L_0x0190
            com.coffeemeetsbagel.likes_you.LikesYouViewModel r2 = r0.this$0
            boolean r2 = r2.f34143x
            if (r2 == 0) goto L_0x0190
            java.lang.String r2 = r0.$groupId
            com.coffeemeetsbagel.likes_you.presentation.MainGroups r7 = com.coffeemeetsbagel.likes_you.presentation.MainGroups.MY_TYPE
            java.lang.String r7 = r7.b()
            boolean r2 = kotlin.jvm.internal.j.b(r2, r7)
            if (r2 == 0) goto L_0x0190
            int r2 = r6.size()
            r7 = 2
            if (r2 > r7) goto L_0x0190
            r8 = r4
        L_0x0190:
            if (r8 == 0) goto L_0x019d
            com.coffeemeetsbagel.likes_you.presentation.LikesYouGridUiItem$b r2 = new com.coffeemeetsbagel.likes_you.presentation.LikesYouGridUiItem$b
            r7 = 0
            r2.<init>(r7, r4, r7)
            java.util.List r2 = kotlin.collections.p.e(r2)
            goto L_0x01a1
        L_0x019d:
            java.util.List r2 = kotlin.collections.q.j()
        L_0x01a1:
            java.util.List r5 = kotlin.collections.CollectionsKt___CollectionsKt.h0(r5, r6)
            java.util.List r3 = kotlin.collections.CollectionsKt___CollectionsKt.h0(r5, r3)
            java.util.List r2 = kotlin.collections.CollectionsKt___CollectionsKt.h0(r3, r2)
            boolean r3 = r2.isEmpty()
            r3 = r3 ^ r4
            if (r3 == 0) goto L_0x01cb
            com.coffeemeetsbagel.likes_you.LikesYouViewModel r1 = r0.this$0
            androidx.lifecycle.t r1 = r1.f34135p
            com.coffeemeetsbagel.likes_you.LikesYouViewModel$b$c r3 = new com.coffeemeetsbagel.likes_you.LikesYouViewModel$b$c
            com.coffeemeetsbagel.likes_you.LikesYouViewModel r4 = r0.this$0
            boolean r4 = r4.f34143x
            int r5 = r0.$tabPosition
            r3.<init>(r4, r2, r5)
            r1.o(r3)
            goto L_0x0206
        L_0x01cb:
            com.coffeemeetsbagel.likes_you.g r2 = new com.coffeemeetsbagel.likes_you.g
            com.coffeemeetsbagel.models.entities.LikesYouGroupEntity r3 = r1.getGroup()
            java.lang.String r7 = r3.getEmptyStateAction()
            com.coffeemeetsbagel.models.entities.LikesYouGroupEntity r3 = r1.getGroup()
            java.lang.String r8 = r3.getEmptyStateCtaText()
            com.coffeemeetsbagel.models.entities.LikesYouGroupEntity r3 = r1.getGroup()
            java.lang.String r9 = r3.getEmptyStateDescription()
            com.coffeemeetsbagel.models.entities.LikesYouGroupEntity r3 = r1.getGroup()
            java.lang.String r10 = r3.getEmptyStateImageUrl()
            com.coffeemeetsbagel.models.entities.LikesYouGroupEntity r1 = r1.getGroup()
            java.lang.String r11 = r1.getEmptyStateTitleText()
            r6 = r2
            r6.<init>(r7, r8, r9, r10, r11)
            com.coffeemeetsbagel.likes_you.LikesYouViewModel r1 = r0.this$0
            boolean r3 = r1.f34143x
            java.lang.String r4 = r0.$groupId
            int r5 = r0.$tabPosition
            r1.k0(r2, r3, r4, r5)
        L_0x0206:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.likes_you.LikesYouViewModel$fetchAndRenderLikesYouCards$disposable$4.c(kotlin.Pair):void");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        c((Pair) obj);
        return Unit.f32013a;
    }
}
