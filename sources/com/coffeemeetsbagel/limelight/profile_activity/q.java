package com.coffeemeetsbagel.limelight.profile_activity;

import android.widget.FrameLayout;
import b6.u;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.limelight.profile_activity.LikesYouMatchContainerInteractor;
import com.coffeemeetsbagel.limelight.profile_activity.j;
import com.coffeemeetsbagel.limelight.profile_activity.r;
import com.coffeemeetsbagel.match.MatchIdAttribution;
import java.util.List;

public final class q extends b6.q<j.a, LikesYouBrowserInteractor> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(j.a aVar, LikesYouBrowserInteractor likesYouBrowserInteractor) {
        super(aVar, likesYouBrowserInteractor);
        kotlin.jvm.internal.j.g(aVar, "component");
        kotlin.jvm.internal.j.g(likesYouBrowserInteractor, "interactor");
    }

    /* access modifiers changed from: private */
    public static final void o(q qVar, u uVar, List list, String str, MatchIdAttribution matchIdAttribution, LikesYouMatchContainerInteractor.b bVar) {
        kotlin.jvm.internal.j.g(qVar, "this$0");
        kotlin.jvm.internal.j.g(list, "$profileIds");
        kotlin.jvm.internal.j.g(str, "$screenSource");
        kotlin.jvm.internal.j.g(matchIdAttribution, "$currentProfileIdAttribution");
        kotlin.jvm.internal.j.g(bVar, "$actionListener");
        qVar.b(uVar);
        FrameLayout frameLayout = (FrameLayout) ((j.a) qVar.e()).i().findViewById(R.id.main_content);
        frameLayout.removeView(uVar.l());
        b6.j e10 = qVar.e();
        kotlin.jvm.internal.j.f(e10, "component");
        r rVar = new r((r.c) e10);
        kotlin.jvm.internal.j.f(frameLayout, "parentViewGroup");
        p0 b10 = rVar.b(frameLayout, list, str, matchIdAttribution, bVar);
        qVar.a(b10);
        frameLayout.addView(b10.l());
    }

    public final void m() {
        ((j.a) e()).i().finish();
    }

    /* JADX WARNING: type inference failed for: r13v0, types: [b6.u<?, ?, ?>, b6.u] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n(java.lang.String r9, java.util.List<java.lang.String> r10, com.coffeemeetsbagel.match.MatchIdAttribution r11, com.coffeemeetsbagel.limelight.profile_activity.LikesYouMatchContainerInteractor.b r12, b6.u<?, ?, ?> r13) {
        /*
            r8 = this;
            java.lang.String r0 = "screenSource"
            kotlin.jvm.internal.j.g(r9, r0)
            java.lang.String r0 = "profileIds"
            kotlin.jvm.internal.j.g(r10, r0)
            java.lang.String r0 = "currentProfileIdAttribution"
            kotlin.jvm.internal.j.g(r11, r0)
            java.lang.String r0 = "actionListener"
            kotlin.jvm.internal.j.g(r12, r0)
            if (r13 == 0) goto L_0x0033
            com.coffeemeetsbagel.limelight.profile_activity.p r0 = new com.coffeemeetsbagel.limelight.profile_activity.p
            r1 = r0
            r2 = r8
            r3 = r13
            r4 = r10
            r5 = r9
            r6 = r11
            r7 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7)
            ua.a r1 = ua.a.f41949a
            android.view.View r13 = r13.l()
            java.lang.String r2 = "currentChildRouter.view"
            kotlin.jvm.internal.j.f(r13, r2)
            r1.a(r13, r0)
            kotlin.Unit r13 = kotlin.Unit.f32013a
            goto L_0x0034
        L_0x0033:
            r13 = 0
        L_0x0034:
            if (r13 != 0) goto L_0x0071
            b6.j r13 = r8.e()
            com.coffeemeetsbagel.limelight.profile_activity.j$a r13 = (com.coffeemeetsbagel.limelight.profile_activity.j.a) r13
            android.app.Activity r13 = r13.i()
            r0 = 2131297147(0x7f09037b, float:1.821223E38)
            android.view.View r13 = r13.findViewById(r0)
            android.widget.FrameLayout r13 = (android.widget.FrameLayout) r13
            com.coffeemeetsbagel.limelight.profile_activity.r r0 = new com.coffeemeetsbagel.limelight.profile_activity.r
            b6.j r1 = r8.e()
            java.lang.String r2 = "component"
            kotlin.jvm.internal.j.f(r1, r2)
            com.coffeemeetsbagel.limelight.profile_activity.r$c r1 = (com.coffeemeetsbagel.limelight.profile_activity.r.c) r1
            r0.<init>(r1)
            java.lang.String r1 = "parentViewGroup"
            kotlin.jvm.internal.j.f(r13, r1)
            r1 = r13
            r2 = r10
            r3 = r9
            r4 = r11
            r5 = r12
            com.coffeemeetsbagel.limelight.profile_activity.p0 r9 = r0.b(r1, r2, r3, r4, r5)
            r8.a(r9)
            android.view.View r9 = r9.l()
            r13.addView(r9)
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.limelight.profile_activity.q.n(java.lang.String, java.util.List, com.coffeemeetsbagel.match.MatchIdAttribution, com.coffeemeetsbagel.limelight.profile_activity.LikesYouMatchContainerInteractor$b, b6.u):void");
    }
}
