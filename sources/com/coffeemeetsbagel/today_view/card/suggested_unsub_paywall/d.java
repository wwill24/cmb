package com.coffeemeetsbagel.today_view.card.suggested_unsub_paywall;

import android.view.View;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.today_view.card.suggested_unsub_paywall.SuggestedUnsubPaywallInteractor;
import gc.c;
import k6.b0;
import kotlin.jvm.internal.j;

public final class d extends p<View> {

    /* renamed from: e  reason: collision with root package name */
    private final b0 f37350e;

    /* renamed from: f  reason: collision with root package name */
    private final a f37351f;

    public interface a {
        void k();
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37352a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.coffeemeetsbagel.today_view.card.suggested_unsub_paywall.SuggestedUnsubPaywallInteractor$UnsubPaywall[] r0 = com.coffeemeetsbagel.today_view.card.suggested_unsub_paywall.SuggestedUnsubPaywallInteractor.UnsubPaywall.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.today_view.card.suggested_unsub_paywall.SuggestedUnsubPaywallInteractor$UnsubPaywall r1 = com.coffeemeetsbagel.today_view.card.suggested_unsub_paywall.SuggestedUnsubPaywallInteractor.UnsubPaywall.NO_LIKES     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.today_view.card.suggested_unsub_paywall.SuggestedUnsubPaywallInteractor$UnsubPaywall r1 = com.coffeemeetsbagel.today_view.card.suggested_unsub_paywall.SuggestedUnsubPaywallInteractor.UnsubPaywall.NO_VIEWS     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f37352a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.today_view.card.suggested_unsub_paywall.d.b.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(b0 b0Var, a aVar) {
        super(b0Var.getRoot());
        j.g(b0Var, "binding");
        j.g(aVar, "listener");
        this.f37350e = b0Var;
        this.f37351f = aVar;
    }

    /* access modifiers changed from: private */
    public static final void k(d dVar, View view) {
        j.g(dVar, "this$0");
        dVar.f37351f.k();
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        this.f37350e.f15702b.setOnClickListener(new c(this));
    }

    public final void l(SuggestedUnsubPaywallInteractor.UnsubPaywall unsubPaywall) {
        j.g(unsubPaywall, "paywall");
        int i10 = b.f37352a[unsubPaywall.ordinal()];
        if (i10 == 1) {
            this.f37350e.f15704d.setImageResource(R.drawable.purple_heart_with_small_hearts);
            this.f37350e.f15703c.setText(R.string.no_likes_left_empty_state_title);
            this.f37350e.f15705e.setText(R.string.no_likes_left_empty_state_description);
        } else if (i10 == 2) {
            this.f37350e.f15704d.setImageResource(R.drawable.basket_of_bagels);
            this.f37350e.f15703c.setText(R.string.no_views_left_empty_state_title);
            this.f37350e.f15705e.setText(R.string.no_views_left_empty_state_description);
        }
    }
}
