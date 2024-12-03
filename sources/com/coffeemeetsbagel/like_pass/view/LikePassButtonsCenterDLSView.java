package com.coffeemeetsbagel.like_pass.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import ba.b;
import ba.c;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.mparticle.identity.IdentityHttpResponse;
import fa.a;
import gk.f;
import j5.x;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import qj.q;

public final class LikePassButtonsCenterDLSView extends LinearLayout implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f14064a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<MatchActionType> f14065b;

    /* renamed from: c  reason: collision with root package name */
    private final f f14066c;

    /* renamed from: d  reason: collision with root package name */
    private final f f14067d;

    /* renamed from: e  reason: collision with root package name */
    private final f f14068e;

    /* renamed from: f  reason: collision with root package name */
    private final f f14069f;

    /* renamed from: g  reason: collision with root package name */
    private final f f14070g;

    /* renamed from: h  reason: collision with root package name */
    private final f f14071h;

    /* renamed from: j  reason: collision with root package name */
    private final f f14072j;

    /* renamed from: k  reason: collision with root package name */
    private final f f14073k;

    /* renamed from: l  reason: collision with root package name */
    private final LinkedHashSet<MatchActionType> f14074l;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f14075a;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|1|2|3|4|5|6|7|8|9|10|11|12|13|15) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.coffeemeetsbagel.like_pass.view.MatchActionType[] r0 = com.coffeemeetsbagel.like_pass.view.MatchActionType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.like_pass.view.MatchActionType r1 = com.coffeemeetsbagel.like_pass.view.MatchActionType.LIKE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.like_pass.view.MatchActionType r1 = com.coffeemeetsbagel.like_pass.view.MatchActionType.PASS     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.coffeemeetsbagel.like_pass.view.MatchActionType r1 = com.coffeemeetsbagel.like_pass.view.MatchActionType.COMMENT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.coffeemeetsbagel.like_pass.view.MatchActionType r1 = com.coffeemeetsbagel.like_pass.view.MatchActionType.INSTANT_LIKE     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.coffeemeetsbagel.like_pass.view.MatchActionType r1 = com.coffeemeetsbagel.like_pass.view.MatchActionType.FLOWER     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.coffeemeetsbagel.like_pass.view.MatchActionType r1 = com.coffeemeetsbagel.like_pass.view.MatchActionType.SEND_FLOWER     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                f14075a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.like_pass.view.LikePassButtonsCenterDLSView.a.<clinit>():void");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LikePassButtonsCenterDLSView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        j.g(context, IdentityHttpResponse.CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LikePassButtonsCenterDLSView(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    private final void c(boolean z10) {
        int i10;
        int i11;
        int i12;
        a.C0491a aVar = fa.a.f40771d;
        String str = this.f14064a;
        j.f(str, "tag");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("making Pass button small? ");
        sb2.append(!z10);
        aVar.a(str, sb2.toString());
        if (z10) {
            i10 = b.fab_size;
        } else {
            i10 = b.small_fab_size;
        }
        Resources resources = getResources();
        if (z10) {
            i11 = b.fab_size;
        } else {
            i11 = b.small_fab_size;
        }
        int dimensionPixelSize = resources.getDimensionPixelSize(i11);
        Resources resources2 = getResources();
        if (z10) {
            i12 = b.spacer_2;
        } else {
            i12 = b.spacer_3;
        }
        int dimensionPixelSize2 = resources2.getDimensionPixelSize(i12);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i10, i10);
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = dimensionPixelSize;
        layoutParams.bottomMargin = dimensionPixelSize2;
        layoutParams.rightMargin = getResources().getDimensionPixelSize(b.spacer_3);
        layoutParams.gravity = 81;
        getPassButton().setLayoutParams(layoutParams);
        getPassButton().setCustomSize(dimensionPixelSize);
    }

    private final CharSequence d(long j10) {
        String str;
        Drawable drawable;
        ImageSpan imageSpan;
        int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
        if (i10 == 0) {
            str = "1  ";
        } else {
            str = j10 + "  ";
        }
        if (i10 == 0) {
            drawable = androidx.core.content.a.getDrawable(getView().getContext(), c.flower);
        } else {
            drawable = androidx.core.content.a.getDrawable(getView().getContext(), c.ic_single_bean);
        }
        int V = StringsKt__StringsKt.V(str);
        j.d(drawable);
        drawable.setBounds(1, 1, 32, 32);
        drawable.mutate().setTint(-1);
        if (Build.VERSION.SDK_INT >= 29) {
            imageSpan = new ImageSpan(drawable, 2);
        } else {
            imageSpan = new ImageSpan(drawable);
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(imageSpan, V, V + 1, 0);
        return spannableString;
    }

    private final MatchActionFab getCommentButton() {
        return (MatchActionFab) this.f14069f.getValue();
    }

    private final MatchActionFab getFlowerButton() {
        return (MatchActionFab) this.f14070g.getValue();
    }

    private final InstantLikeFab getInstantLikeButton() {
        return (InstantLikeFab) this.f14067d.getValue();
    }

    private final MatchActionFab getLikeButton() {
        return (MatchActionFab) this.f14068e.getValue();
    }

    private final MatchActionFab getPassButton() {
        return (MatchActionFab) this.f14066c.getValue();
    }

    private final CmbTextView getPriceText() {
        return (CmbTextView) this.f14073k.getValue();
    }

    private final CustomFabLikeButton getSendFlowerButton() {
        return (CustomFabLikeButton) this.f14072j.getValue();
    }

    private final SendFlowerButtonContainerView getSendFlowerButtonContainer() {
        return (SendFlowerButtonContainerView) this.f14071h.getValue();
    }

    private final void setButtonsClickableAndEnabled(boolean z10) {
        getLikeButton().setClickable(z10);
        getPassButton().setClickable(z10);
        getCommentButton().setClickable(z10);
        getInstantLikeButton().setClickable(z10);
        getInstantLikeButton().setEnabled(z10);
    }

    public void a(List<? extends MatchActionType> list, Long l10) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        j.g(list, "buttons");
        a.C0491a aVar = fa.a.f40771d;
        String str = this.f14064a;
        j.f(str, "tag");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("showButtons - ");
        boolean z14 = false;
        sb2.append(j.c(list.toArray(new MatchActionType[0])));
        aVar.a(str, sb2.toString());
        this.f14074l.clear();
        for (MatchActionType matchActionType : list) {
            this.f14074l.add(matchActionType);
            switch (a.f14075a[matchActionType.ordinal()]) {
                case 1:
                    getLikeButton().a();
                    break;
                case 2:
                    getPassButton().a();
                    break;
                case 3:
                    getCommentButton().a();
                    break;
                case 4:
                    getInstantLikeButton().a();
                    break;
                case 5:
                    getFlowerButton().setVisibility(0);
                    break;
                case 6:
                    getSendFlowerButtonContainer().setVisibility(0);
                    if (l10 == null) {
                        break;
                    } else {
                        getPriceText().setText(d(l10.longValue()));
                        break;
                    }
            }
        }
        for (MatchActionType next : this.f14065b) {
            if (true ^ this.f14074l.contains(next)) {
                switch (a.f14075a[next.ordinal()]) {
                    case 1:
                        getLikeButton().setVisibility(8);
                        break;
                    case 2:
                        getPassButton().setVisibility(8);
                        break;
                    case 3:
                        getCommentButton().setVisibility(8);
                        break;
                    case 4:
                        getInstantLikeButton().setVisibility(8);
                        break;
                    case 5:
                        getFlowerButton().setVisibility(8);
                        break;
                    case 6:
                        getSendFlowerButtonContainer().setVisibility(8);
                        break;
                }
            }
        }
        if (list.size() == 2) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (list.size() == 3 && list.get(1) == MatchActionType.INSTANT_LIKE) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (list.size() == 3 && list.get(1) == MatchActionType.FLOWER) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (list.size() == 3 && list.get(1) == MatchActionType.SEND_FLOWER) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z10 || z11 || z12 || z13) {
            z14 = true;
        }
        c(z14);
    }

    public q<x> b(MatchActionType matchActionType) {
        j.g(matchActionType, SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE);
        setButtonsClickableAndEnabled(false);
        switch (a.f14075a[matchActionType.ordinal()]) {
            case 1:
                return e();
            case 2:
                return f();
            case 3:
                q<x> A = getCommentButton().A();
                j.f(A, "commentButton.clicks()");
                return A;
            case 4:
                q<x> A2 = getInstantLikeButton().A();
                j.f(A2, "instantLikeButton.clicks()");
                return A2;
            case 5:
                q<x> A3 = getFlowerButton().A();
                j.f(A3, "flowerButton.clicks()");
                return A3;
            case 6:
                q<x> g10 = getSendFlowerButton().g();
                j.f(g10, "sendFlowerButton.clicks()");
                return g10;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final q<x> e() {
        q<x> A = getLikeButton().A();
        j.f(A, "likeButton.clicks()");
        return A;
    }

    public final q<x> f() {
        q<x> A = getPassButton().A();
        j.f(A, "passButton.clicks()");
        return A;
    }

    public View getView() {
        return this;
    }

    public void setCommentButtonImageResource(int i10) {
        getCommentButton().setImageResource(i10);
    }

    public /* bridge */ /* synthetic */ void setIsEnabled(Boolean bool) {
        setIsEnabled(bool.booleanValue());
    }

    public void setLikeButtonImageResource(int i10) {
        getLikeButton().setImageResource(i10);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LikePassButtonsCenterDLSView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        j.g(context, IdentityHttpResponse.CONTEXT);
        this.f14064a = LikePassButtonsCenterDLSView.class.getSimpleName();
        this.f14065b = n0.i(MatchActionType.PASS, MatchActionType.INSTANT_LIKE, MatchActionType.LIKE, MatchActionType.COMMENT, MatchActionType.FLOWER, MatchActionType.SEND_FLOWER);
        this.f14066c = b.b(new LikePassButtonsCenterDLSView$passButton$2(this));
        this.f14067d = b.b(new LikePassButtonsCenterDLSView$instantLikeButton$2(this));
        this.f14068e = b.b(new LikePassButtonsCenterDLSView$likeButton$2(this));
        this.f14069f = b.b(new LikePassButtonsCenterDLSView$commentButton$2(this));
        this.f14070g = b.b(new LikePassButtonsCenterDLSView$flowerButton$2(this));
        this.f14071h = b.b(new LikePassButtonsCenterDLSView$sendFlowerButtonContainer$2(this));
        this.f14072j = b.b(new LikePassButtonsCenterDLSView$sendFlowerButton$2(this));
        this.f14073k = b.b(new LikePassButtonsCenterDLSView$priceText$2(this));
        this.f14074l = new LinkedHashSet<>();
    }

    public void setIsEnabled(boolean z10) {
        int i10;
        setButtonsClickableAndEnabled(z10);
        if (z10) {
            i10 = androidx.core.content.a.getColor(getContext(), ba.a.main_color);
        } else {
            i10 = androidx.core.content.a.getColor(getContext(), ba.a.gray);
        }
        getLikeButton().setColorFilter(i10);
        getCommentButton().setColorFilter(i10);
        getInstantLikeButton().setColorFilter(i10);
        getFlowerButton().setColorFilter(i10);
    }
}
