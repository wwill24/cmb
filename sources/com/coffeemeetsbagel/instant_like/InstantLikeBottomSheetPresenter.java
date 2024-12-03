package com.coffeemeetsbagel.instant_like;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.view.View;
import b6.p;
import com.coffeemeetsbagel.models.Price;
import com.google.firebase.analytics.FirebaseAnalytics;
import fa.a;
import gk.f;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;
import r7.h;

public final class InstantLikeBottomSheetPresenter extends p<View> {

    /* renamed from: j  reason: collision with root package name */
    public static final b f14000j = new b((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final y9.a f14001e;

    /* renamed from: f  reason: collision with root package name */
    private final c f14002f;

    /* renamed from: g  reason: collision with root package name */
    private final String f14003g = InstantLikeBottomSheetPresenter.class.getSimpleName();

    /* renamed from: h  reason: collision with root package name */
    private final f f14004h = b.b(new InstantLikeBottomSheetPresenter$processDialog$2(this));

    public static final class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InstantLikeBottomSheetPresenter f14005a;

        a(InstantLikeBottomSheetPresenter instantLikeBottomSheetPresenter) {
            this.f14005a = instantLikeBottomSheetPresenter;
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            j.g(charSequence, "charSequence");
            if (charSequence.length() < 130) {
                this.f14005a.f14001e.f18777j.setVisibility(8);
                return;
            }
            this.f14005a.f14001e.f18777j.setVisibility(0);
            this.f14005a.f14001e.f18777j.setText(String.valueOf(140 - charSequence.length()));
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface c {
        void h();

        void k1(Price price, String str, String str2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InstantLikeBottomSheetPresenter(y9.a aVar, c cVar) {
        super(aVar.getRoot());
        j.g(aVar, "binding");
        j.g(cVar, "listener");
        this.f14001e = aVar;
        this.f14002f = cVar;
        aVar.f18771c.setOnClickListener(new v(this));
        aVar.f18778k.setRawInputType(1);
        aVar.f18778k.addTextChangedListener(new a(this));
    }

    /* access modifiers changed from: private */
    public static final void l(InstantLikeBottomSheetPresenter instantLikeBottomSheetPresenter, View view) {
        j.g(instantLikeBottomSheetPresenter, "this$0");
        instantLikeBottomSheetPresenter.f14002f.h();
    }

    private final CharSequence o(int i10) {
        ImageSpan imageSpan;
        String str = PropertyUtils.MAPPED_DELIM + i10 + " )";
        String str2 = this.f7869c.getResources().getString(e0.instant_like_send_instant_like) + ' ' + str;
        SpannableString spannableString = new SpannableString(str2);
        int g02 = (StringsKt__StringsKt.g0(str2, str, 0, false, 6, (Object) null) + str.length()) - 2;
        Drawable drawable = androidx.core.content.a.getDrawable(this.f7869c.getContext(), b0.ic_single_bean);
        j.d(drawable);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.mutate().setTint(-1);
        if (Build.VERSION.SDK_INT >= 29) {
            imageSpan = new ImageSpan(drawable, 2);
        } else {
            imageSpan = new ImageSpan(drawable);
        }
        spannableString.setSpan(imageSpan, g02, g02 + 1, 0);
        return spannableString;
    }

    private final h p() {
        return (h) this.f14004h.getValue();
    }

    private final void t(Price price, String str) {
        a.C0491a aVar = fa.a.f40771d;
        String str2 = this.f14003g;
        j.f(str2, "tag");
        aVar.a(str2, "setCtaPrimaryClickListener");
        this.f14001e.f18770b.setOnClickListener(new w(this, price, str));
    }

    /* access modifiers changed from: private */
    public static final void u(InstantLikeBottomSheetPresenter instantLikeBottomSheetPresenter, Price price, String str, View view) {
        j.g(instantLikeBottomSheetPresenter, "this$0");
        j.g(price, "$price");
        j.g(str, "$matchId");
        instantLikeBottomSheetPresenter.f14002f.k1(price, str, String.valueOf(instantLikeBottomSheetPresenter.f14001e.f18778k.getText()));
    }

    public final void q() {
        this.f14001e.f18773e.setVisibility(8);
        this.f14001e.f18770b.setEnabled(false);
    }

    public final void r(Price price, boolean z10, String str) {
        j.g(price, FirebaseAnalytics.Param.PRICE);
        j.g(str, "matchId");
        int freeItemCount = price.getFreeItemCount();
        this.f14001e.f18773e.setVisibility(0);
        this.f14001e.f18773e.setText(this.f7869c.getContext().getString(e0.instant_like_grant_count, new Object[]{Integer.valueOf(freeItemCount)}));
        if (freeItemCount > 0) {
            y9.a aVar = this.f14001e;
            aVar.f18773e.setBackground(androidx.core.content.a.getDrawable(aVar.getRoot().getContext(), b0.pill_accent));
            y9.a aVar2 = this.f14001e;
            aVar2.f18773e.setTextColor(androidx.core.content.a.getColor(aVar2.getRoot().getContext(), a0.main_color));
        } else {
            y9.a aVar3 = this.f14001e;
            aVar3.f18773e.setBackground(androidx.core.content.a.getDrawable(aVar3.getRoot().getContext(), b0.pill_light_gray));
            y9.a aVar4 = this.f14001e;
            aVar4.f18773e.setTextColor(androidx.core.content.a.getColor(aVar4.getRoot().getContext(), a0.dark_gray));
            this.f14001e.f18770b.setText(o(price.getBeans()));
        }
        this.f14001e.f18770b.setEnabled(true);
        t(price, str);
    }

    public final void v(boolean z10) {
        if (z10) {
            p().show();
        } else {
            p().hide();
        }
    }
}
