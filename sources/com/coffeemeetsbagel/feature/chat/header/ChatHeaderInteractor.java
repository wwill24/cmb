package com.coffeemeetsbagel.feature.chat.header;

import b6.s;
import com.coffeemeetsbagel.match.j;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.NetworkPhoto;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.enums.PurchaseAttribution;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.uber.autodispose.p;
import com.uber.autodispose.t;
import java.util.Date;
import kotlin.jvm.functions.Function1;
import qj.w;
import s9.a;

public final class ChatHeaderInteractor extends s<j, k> {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final String f12840f;

    /* renamed from: g  reason: collision with root package name */
    public j f12841g;

    /* renamed from: h  reason: collision with root package name */
    public a f12842h;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public NetworkProfile f12843j;

    public ChatHeaderInteractor(String str) {
        kotlin.jvm.internal.j.g(str, "matchId");
        this.f12840f = str;
    }

    private final String R1(Bagel bagel) {
        Date date = DateUtils.getDate(bagel.getDecouplingDate());
        if (date != null) {
            return DateUtils.getFormattedUtcDate(date, DateUtils.DATE_PATTERN_FRIENDLY_SHORT_MONTH);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final Bagel S1(ChatHeaderInteractor chatHeaderInteractor) {
        kotlin.jvm.internal.j.g(chatHeaderInteractor, "this$0");
        return chatHeaderInteractor.W1().k(chatHeaderInteractor.f12840f);
    }

    /* access modifiers changed from: private */
    public static final void T1(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final boolean U1(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final void V1(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final boolean Y1(Bagel bagel) {
        if (X1().a("InstantLikeNewUsers.Android.Show.Android")) {
            int purchaseAttributionInteger = PurchaseAttribution.INSTANT_LIKE.getPurchaseAttributionInteger();
            Integer purchaseAttributionValue = bagel.getPurchaseAttributionValue();
            if (purchaseAttributionValue != null && purchaseAttributionInteger == purchaseAttributionValue.intValue() && !bagel.isPastDecouplingDate() && !bagel.isPairBlocked()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void Z1(Bagel bagel) {
        String str;
        boolean z10;
        NetworkPhoto profilePhoto;
        NetworkProfile profile = bagel.getProfile();
        if (profile == null || (profilePhoto = profile.getProfilePhoto()) == null) {
            str = null;
        } else {
            str = profilePhoto.getUrl();
        }
        if (str == null || str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            ((j) this.f7875e).n();
        } else {
            ((j) this.f7875e).m(str);
        }
    }

    /* access modifiers changed from: private */
    public final void a2(Bagel bagel) {
        if (Y1(bagel)) {
            ((j) this.f7875e).o(bagel.getProfile().getUserFirstName(), R1(bagel));
            return;
        }
        ((j) this.f7875e).p(bagel.isPastDecouplingDate(), R1(bagel));
    }

    /* access modifiers changed from: private */
    public final void b2(Bagel bagel) {
        PurchaseAttribution purchaseAttributionFromInteger;
        Integer purchaseAttributionValue = bagel.getPurchaseAttributionValue();
        if (purchaseAttributionValue != null && (purchaseAttributionFromInteger = PurchaseAttribution.purchaseAttributionFromInteger(purchaseAttributionValue)) != null) {
            kotlin.jvm.internal.j.f(purchaseAttributionFromInteger, "attribution");
            String userFirstName = bagel.getProfile().getUserFirstName();
            kotlin.jvm.internal.j.f(userFirstName, "bagel.profile.userFirstName");
            ((j) this.f7875e).q(purchaseAttributionFromInteger, userFirstName);
        }
    }

    public final j W1() {
        j jVar = this.f12841g;
        if (jVar != null) {
            return jVar;
        }
        kotlin.jvm.internal.j.y("bagelManager");
        return null;
    }

    public final a X1() {
        a aVar = this.f12842h;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("featureManager");
        return null;
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        ((t) w.A(new c(this)).K(dk.a.c()).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new d(new ChatHeaderInteractor$didBecomeActive$2(this)));
        ((p) W1().a().B(new e(new ChatHeaderInteractor$didBecomeActive$3(this))).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new f(new ChatHeaderInteractor$didBecomeActive$4(this)));
    }
}
