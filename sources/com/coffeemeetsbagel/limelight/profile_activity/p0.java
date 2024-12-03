package com.coffeemeetsbagel.limelight.profile_activity;

import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import b6.u;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.chat.details.ChatActivity;
import com.coffeemeetsbagel.limelight.profile_activity.r;
import com.coffeemeetsbagel.match.MatchIdAttribution;
import com.coffeemeetsbagel.match_view.MatchViewInteractor;
import com.coffeemeetsbagel.match_view.m;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.constants.Extra;
import kotlin.jvm.internal.j;
import qj.q;
import sb.a;

public final class p0 extends u<View, r.a, LikesYouMatchContainerInteractor> {

    /* renamed from: f  reason: collision with root package name */
    private final FrameLayout f34464f;

    /* renamed from: g  reason: collision with root package name */
    private u<?, ?, ?> f34465g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p0(FrameLayout frameLayout, r.a aVar, LikesYouMatchContainerInteractor likesYouMatchContainerInteractor, FrameLayout frameLayout2) {
        super(frameLayout, aVar, likesYouMatchContainerInteractor);
        j.g(frameLayout, "layout");
        j.g(aVar, "component");
        j.g(likesYouMatchContainerInteractor, "interactor");
        j.g(frameLayout2, "profilePlaceholder");
        this.f34464f = frameLayout2;
    }

    private final void n() {
        u uVar = this.f34465g;
        if (uVar != null) {
            this.f34464f.addView(uVar.l());
            a(uVar);
        }
    }

    public final void m(Bagel bagel) {
        j.g(bagel, Extra.BAGEL);
        Intent intent = new Intent(((r.a) e()).n(), ChatActivity.class);
        intent.putExtra(Extra.BAGEL, bagel);
        ((r.a) e()).n().startActivity(intent);
    }

    public final void o(int i10, MatchIdAttribution matchIdAttribution, int i11, int i12, MatchViewInteractor.b bVar, q<Boolean> qVar, String str, String str2) {
        j.g(matchIdAttribution, "matchIdAttribution");
        j.g(bVar, "listener");
        j.g(qVar, "matchIsSeen");
        j.g(str2, "matchToMe");
        m mVar = r2;
        b6.j e10 = e();
        j.f(e10, "component");
        m mVar2 = new m((m.c) e10);
        FrameLayout frameLayout = this.f34464f;
        Integer valueOf = Integer.valueOf(i10);
        String d10 = matchIdAttribution.d();
        this.f34465g = mVar.b(frameLayout, false, valueOf, false, matchIdAttribution, d10, true, "Limelight", false, bVar, qVar, i11, i12, true, str, str2);
        n();
    }

    public final void p(int i10) {
        View view;
        if (((r.a) e()).n() instanceof ActivityMain) {
            view = ((r.a) e()).n().getWindow().getDecorView().findViewById(R.id.main_coordinator_layout);
            j.f(view, "{\n            component.…dinator_layout)\n        }");
        } else {
            view = ((r.a) e()).n().getWindow().getDecorView().findViewById(16908290);
            j.f(view, "{\n            component.…d.R.id.content)\n        }");
        }
        a.l(view, i10, 6000);
    }
}
