package com.coffeemeetsbagel.shop.subscription_comparison;

import android.content.Context;
import android.content.res.Resources;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.coffeemeetsbagel.shop.subscription_comparison.i;
import com.mparticle.identity.IdentityHttpResponse;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.j;
import lc.l;
import vb.c;
import vb.d;

public final class SubscriptionCardPagerAdapter extends androidx.viewpager.widget.a {

    /* renamed from: c  reason: collision with root package name */
    private final Context f36599c;

    /* renamed from: d  reason: collision with root package name */
    private final vb.a f36600d;

    /* renamed from: e  reason: collision with root package name */
    private final i.a f36601e;

    /* renamed from: f  reason: collision with root package name */
    private final List<c> f36602f;

    /* renamed from: g  reason: collision with root package name */
    private final LayoutInflater f36603g;

    /* renamed from: h  reason: collision with root package name */
    private final Map<CardType, CountDownTimer> f36604h = new LinkedHashMap();

    private enum CardType {
        BASE,
        PREMIUM
    }

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36608a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.coffeemeetsbagel.shop.subscription_comparison.SubscriptionCardPagerAdapter$CardType[] r0 = com.coffeemeetsbagel.shop.subscription_comparison.SubscriptionCardPagerAdapter.CardType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.shop.subscription_comparison.SubscriptionCardPagerAdapter$CardType r1 = com.coffeemeetsbagel.shop.subscription_comparison.SubscriptionCardPagerAdapter.CardType.BASE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.shop.subscription_comparison.SubscriptionCardPagerAdapter$CardType r1 = com.coffeemeetsbagel.shop.subscription_comparison.SubscriptionCardPagerAdapter.CardType.PREMIUM     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f36608a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.shop.subscription_comparison.SubscriptionCardPagerAdapter.a.<clinit>():void");
        }
    }

    public static final class b extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f36609a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SubscriptionCardPagerAdapter f36610b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CardType f36611c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ViewGroup f36612d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ c f36613e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(TextView textView, SubscriptionCardPagerAdapter subscriptionCardPagerAdapter, CardType cardType, ViewGroup viewGroup, c cVar, long j10) {
            super(j10, 1000);
            this.f36609a = textView;
            this.f36610b = subscriptionCardPagerAdapter;
            this.f36611c = cardType;
            this.f36612d = viewGroup;
            this.f36613e = cVar;
        }

        public void onFinish() {
            this.f36610b.x(this.f36611c);
            this.f36610b.D(this.f36612d, this.f36611c, this.f36613e);
        }

        public void onTick(long j10) {
            String countdownTimerFromSeconds = DateUtils.getCountdownTimerFromSeconds((int) (j10 / 1000));
            TextView textView = this.f36609a;
            textView.setText(textView.getResources().getString(R.string.premium_upsell_sale_offer_ends, new Object[]{countdownTimerFromSeconds}));
        }
    }

    public SubscriptionCardPagerAdapter(Context context, vb.a aVar, i.a aVar2, List<c> list) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(aVar2, "onUpgradeListener");
        j.g(list, "bundles");
        this.f36599c = context;
        this.f36600d = aVar;
        this.f36601e = aVar2;
        this.f36602f = list;
        LayoutInflater from = LayoutInflater.from(context);
        j.f(from, "from(context)");
        this.f36603g = from;
    }

    private final Spanned A(c cVar) {
        String str;
        if (!cVar.l() || cVar.g() <= 0) {
            String string = this.f36599c.getString(R.string.upgrade_now);
            j.f(string, "context.getString(R.string.upgrade_now)");
            SpannedString valueOf = SpannedString.valueOf(string);
            j.f(valueOf, "valueOf(this)");
            return valueOf;
        }
        d e10 = cVar.e();
        String str2 = null;
        if (e10 != null) {
            str = e10.c();
        } else {
            str = null;
        }
        d h10 = cVar.h();
        if (h10 != null) {
            str2 = h10.c();
        }
        if (str2 == null) {
            str2 = "";
        }
        SpannableString spannableString = new SpannableString(this.f36599c.getString(R.string.upgrade_for, new Object[]{str2, str}));
        int b02 = StringsKt__StringsKt.b0(spannableString, str2, 0, false, 6, (Object) null);
        if (b02 >= 0) {
            spannableString.setSpan(new StrikethroughSpan(), b02, str2.length() + b02, 33);
        }
        return spannableString;
    }

    private final void B(TextView textView, CardType cardType, c cVar) {
        CardType cardType2;
        vb.a aVar;
        vb.a aVar2;
        vb.a aVar3;
        if ((cardType == CardType.PREMIUM && (aVar3 = this.f36600d) != null && aVar3.g() == 0) || (cardType == (cardType2 = CardType.BASE) && (aVar2 = this.f36600d) != null && aVar2.g() > 0)) {
            textView.setVisibility(8);
        } else if (cardType == cardType2 && (aVar = this.f36600d) != null && aVar.g() == 0) {
            textView.setVisibility(4);
        } else {
            textView.setVisibility(0);
            textView.setText(A(cVar));
            textView.setOnClickListener(new d(cardType, this));
        }
    }

    /* access modifiers changed from: private */
    public static final void C(CardType cardType, SubscriptionCardPagerAdapter subscriptionCardPagerAdapter, View view) {
        j.g(cardType, "$cardType");
        j.g(subscriptionCardPagerAdapter, "this$0");
        if (cardType == CardType.PREMIUM) {
            subscriptionCardPagerAdapter.f36601e.a();
        } else {
            subscriptionCardPagerAdapter.f36601e.b();
        }
    }

    /* access modifiers changed from: private */
    public final void D(ViewGroup viewGroup, CardType cardType, c cVar) {
        int i10 = a.f36608a[cardType.ordinal()];
        boolean z10 = true;
        if (i10 == 1) {
            viewGroup.setBackgroundResource(R.drawable.rounded_rectangle_main);
        } else if (i10 == 2) {
            viewGroup.setBackgroundResource(R.drawable.rounded_rectangle_main_dark);
        }
        viewGroup.setPadding(0, 0, 0, viewGroup.getResources().getDimensionPixelSize(R.dimen.baseline_3x));
        ((TextView) viewGroup.findViewById(R.id.title)).setText(cVar.d());
        String z11 = z(cardType);
        TextView textView = (TextView) viewGroup.findViewById(R.id.active_subscription_renewal);
        if (z11.length() <= 0) {
            z10 = false;
        }
        if (z10) {
            textView.setText(z11);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        ((TextView) viewGroup.findViewById(R.id.pill)).setVisibility(8);
        ((TextView) viewGroup.findViewById(R.id.countdown_timer)).setVisibility(8);
        ((TextView) viewGroup.findViewById(R.id.explanation)).setText(y(cardType, cVar));
        TextView textView2 = (TextView) viewGroup.findViewById(R.id.upgrade_subscription_button);
        j.f(textView2, "upgradeButton");
        B(textView2, cardType, cVar);
    }

    private final void E(ViewGroup viewGroup, CardType cardType, c cVar) {
        int i10 = a.f36608a[cardType.ordinal()];
        if (i10 == 1) {
            viewGroup.setBackgroundResource(R.drawable.subscription_card_background_main);
        } else if (i10 == 2) {
            viewGroup.setBackgroundResource(R.drawable.subscription_card_background_dark);
        }
        viewGroup.setPadding(0, 0, 0, 0);
        ((TextView) viewGroup.findViewById(R.id.title)).setText(this.f36599c.getResources().getString(R.string.bean_shop_subscription_sale_title, new Object[]{Integer.valueOf(cVar.f()), cVar.d()}));
        TextView textView = (TextView) viewGroup.findViewById(R.id.pill);
        textView.setVisibility(0);
        textView.setText(textView.getContext().getString(R.string.save, new Object[]{String.valueOf(cVar.f())}));
        F(viewGroup, cardType, cVar);
        TextView textView2 = (TextView) viewGroup.findViewById(R.id.upgrade_subscription_button);
        j.f(textView2, "upgradeButton");
        B(textView2, cardType, cVar);
    }

    private final void F(ViewGroup viewGroup, CardType cardType, c cVar) {
        int i10;
        TextView textView = (TextView) viewGroup.findViewById(R.id.explanation);
        textView.setText(textView.getContext().getString(R.string.bean_shop_subscription_sale_explanation));
        x(cardType);
        TextView textView2 = (TextView) viewGroup.findViewById(R.id.countdown_timer);
        if (cVar.g() <= 86400000) {
            i10 = 0;
        } else {
            i10 = (int) (cVar.g() / 86400000);
        }
        if (i10 == 0) {
            CountDownTimer start = new b(textView2, this, cardType, viewGroup, cVar, cVar.g()).start();
            Map<CardType, CountDownTimer> map = this.f36604h;
            j.f(start, "saleCountDown");
            map.put(cardType, start);
        } else if (i10 < 7) {
            textView2.setText(textView2.getContext().getString(R.string.offer_timer_week_less, new Object[]{Integer.valueOf(i10)}));
        } else {
            textView2.setText(R.string.offer_timer_week_plus);
        }
        textView2.invalidate();
    }

    /* access modifiers changed from: private */
    public final void x(CardType cardType) {
        CountDownTimer countDownTimer = this.f36604h.get(cardType);
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f36604h.remove(cardType);
    }

    private final String y(CardType cardType, c cVar) {
        String str;
        if (cardType == CardType.PREMIUM) {
            vb.a aVar = this.f36600d;
            if (aVar == null || aVar.g() > 0) {
                String string = this.f36599c.getString(R.string.bean_shop_subscription_sale_explanation);
                j.f(string, "context.getString(R.stri…ription_sale_explanation)");
                return string;
            } else if (this.f36600d.g() != 0) {
                return "";
            } else {
                String string2 = this.f36599c.getString(R.string.bean_shop_subscription_premium_explanation_subbed, new Object[]{cVar.d()});
                j.f(string2, "context.getString(\n     …le.name\n                )");
                return string2;
            }
        } else if (cardType != CardType.BASE) {
            return "";
        } else {
            vb.a aVar2 = this.f36600d;
            if (aVar2 == null) {
                String string3 = this.f36599c.getString(R.string.bean_shop_subscription_base_explanation);
                j.f(string3, "{\n                contex…xplanation)\n            }");
                return string3;
            }
            if (aVar2.g() > 0) {
                str = this.f36599c.getString(R.string.bean_shop_subscription_base_explanation_base_subbed, new Object[]{cVar.d()});
            } else {
                str = this.f36599c.getString(R.string.bean_shop_subscription_base_explanation_premium_subbed, new Object[]{cVar.d()});
            }
            j.f(str, "{\n                if (ac…          }\n            }");
            return str;
        }
    }

    private final String z(CardType cardType) {
        Boolean bool;
        String str;
        String str2;
        boolean z10;
        vb.a aVar = this.f36600d;
        if (aVar != null) {
            if (!(cardType == CardType.PREMIUM && aVar.g() == 0) && (cardType != CardType.BASE || aVar.g() <= 0)) {
                z10 = false;
            } else {
                z10 = true;
            }
            bool = Boolean.valueOf(z10);
        } else {
            bool = null;
        }
        if (!j.b(bool, Boolean.TRUE)) {
            return "";
        }
        vb.a aVar2 = this.f36600d;
        j.d(aVar2);
        boolean a10 = aVar2.a();
        Date localDate = DateUtils.getLocalDate(this.f36600d.d(), DateUtils.DATE_WITH_TIME_PATTERN);
        j.f(localDate, "getLocalDate(renewalStri…s.DATE_WITH_TIME_PATTERN)");
        if (l.f()) {
            str = DateUtils.DATE_PATTERN_NUMBERS_SLASHES_DEFAULT;
        } else {
            str = DateUtils.DATE_PATTERN_NUMBERS_SLASHES_NON_US;
        }
        String formattedDate = DateUtils.getFormattedDate(localDate, str);
        Resources resources = this.f36599c.getResources();
        if (a10) {
            str2 = resources.getString(R.string.will_renew_on, new Object[]{formattedDate});
        } else {
            str2 = resources.getString(R.string.bean_shop_subscription_renew, new Object[]{resources.getString(R.string.is_valid_until), formattedDate});
        }
        j.f(str2, "if (autoRenew) {\n       …          )\n            }");
        return str2;
    }

    public void b(ViewGroup viewGroup, int i10, Object obj) {
        j.g(viewGroup, "container");
        j.g(obj, "anyObject");
        viewGroup.removeView((View) obj);
    }

    public int e() {
        return Math.min(this.f36602f.size(), 2);
    }

    public Object i(ViewGroup viewGroup, int i10) {
        CardType cardType;
        Object obj;
        j.g(viewGroup, "container");
        View inflate = this.f36603g.inflate(R.layout.shop_subscription_card, viewGroup, false);
        j.e(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) inflate;
        if (i10 == 0) {
            cardType = CardType.PREMIUM;
        } else {
            cardType = CardType.BASE;
        }
        if (cardType == CardType.BASE) {
            obj = CollectionsKt___CollectionsKt.N(this.f36602f);
        } else {
            obj = CollectionsKt___CollectionsKt.Y(this.f36602f);
        }
        c cVar = (c) obj;
        if (!cVar.l() || cVar.g() <= 0) {
            D(viewGroup2, cardType, cVar);
        } else {
            E(viewGroup2, cardType, cVar);
        }
        viewGroup2.setId(View.generateViewId());
        viewGroup.addView(viewGroup2);
        return viewGroup2;
    }

    public boolean j(View view, Object obj) {
        j.g(view, "view");
        j.g(obj, "object");
        return j.b(view, obj);
    }
}
