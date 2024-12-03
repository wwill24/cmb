package com.coffeemeetsbagel.today_view.card.actioncards;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.Window;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.dialogs.b0;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.coffeemeetsbagel.models.dto.ActionCard;
import gk.f;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import o9.b;
import r7.h;

public final class ActionCardPresenter extends p<View> {

    /* renamed from: e  reason: collision with root package name */
    private final k6.a f37248e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final a f37249f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final PublishSubject<Unit> f37250g;

    /* renamed from: h  reason: collision with root package name */
    private final f f37251h = b.b(new ActionCardPresenter$progressDialog$2(this));

    /* renamed from: j  reason: collision with root package name */
    private final f f37252j = b.b(new ActionCardPresenter$boostedDialog$2(this));

    /* renamed from: k  reason: collision with root package name */
    private final f f37253k = b.b(new ActionCardPresenter$insufficientBeansDialog$2(this));

    public interface a {
        void k();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActionCardPresenter(k6.a aVar, a aVar2, PublishSubject<Unit> publishSubject) {
        super(aVar.getRoot());
        j.g(aVar, "binding");
        j.g(aVar2, "listener");
        j.g(publishSubject, "getBeanClicks");
        this.f37248e = aVar;
        this.f37249f = aVar2;
        this.f37250g = publishSubject;
    }

    private final void C() {
        q().show();
        if (q().getWindow() != null) {
            Window window = q().getWindow();
            j.d(window);
            window.setLayout(-2, -2);
        }
    }

    /* access modifiers changed from: private */
    public static final void n(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final SpannableString p(String str, String str2) {
        ImageSpan imageSpan;
        SpannableString spannableString = new SpannableString(str);
        if (str2 != null) {
            int g02 = (StringsKt__StringsKt.g0(str, str2, 0, false, 6, (Object) null) + str2.length()) - 1;
            Drawable drawable = androidx.core.content.a.getDrawable(this.f7869c.getContext(), R.drawable.ic_single_bean);
            j.d(drawable);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            drawable.mutate().setTint(-1);
            if (Build.VERSION.SDK_INT >= 29) {
                imageSpan = new ImageSpan(drawable, 2);
            } else {
                imageSpan = new ImageSpan(drawable);
            }
            spannableString.setSpan(imageSpan, g02, g02 + 1, 0);
        }
        return spannableString;
    }

    private final b q() {
        return (b) this.f37252j.getValue();
    }

    private final b0 r() {
        return (b0) this.f37253k.getValue();
    }

    private final h t() {
        return (h) this.f37251h.getValue();
    }

    private final void z(ActionCard actionCard) {
        com.coffeemeetsbagel.image_loader.b bVar = com.coffeemeetsbagel.image_loader.b.f13967a;
        Context context = this.f7869c.getContext();
        j.f(context, "view.context");
        ImageLoaderContract.a.a(bVar, context, actionCard.getImageUrl(), this.f37248e.f15672d, (Integer) null, Integer.valueOf(R.drawable.dog_with_tall_tail), (ImageLoaderContract.b) null, (List) null, (Map) null, (Function0) null, (Function1) null, (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0], 4064, (Object) null);
        this.f37248e.f15671c.setText(actionCard.getHeaderText());
        this.f37248e.f15673e.setText(actionCard.getMessageText());
    }

    public final void A(ActionCard actionCard, String str, String str2) {
        j.g(actionCard, "actionCard");
        j.g(str, "text");
        z(actionCard);
        this.f37248e.f15670b.setText(p(str, str2));
        this.f37248e.f15670b.setEnabled(true);
    }

    public final void B() {
        C();
    }

    public final void D() {
        r().show();
    }

    public final void E(boolean z10) {
        if (z10) {
            t().show();
        } else {
            t().dismiss();
        }
    }

    public final void F() {
        t().show();
    }

    public final void G() {
        V v10 = this.f7869c;
        j.f(v10, "view");
        sb.a.i(v10, R.string.generic_video_error);
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        ((com.uber.autodispose.p) this.f37248e.f15670b.a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new x(new ActionCardPresenter$didLoad$1(this)));
    }

    public final void o() {
        this.f37248e.f15670b.setEnabled(false);
    }

    public final void u() {
        r().dismiss();
    }

    public final void v() {
        t().hide();
    }

    public final void w(ActionCard actionCard) {
        j.g(actionCard, "actionCard");
        z(actionCard);
        this.f37248e.f15670b.setText(actionCard.getActionText());
        this.f37248e.f15670b.setEnabled(true);
    }

    public final void y(ActionCard actionCard) {
        j.g(actionCard, "actionCard");
        com.coffeemeetsbagel.image_loader.b bVar = com.coffeemeetsbagel.image_loader.b.f13967a;
        Context context = this.f7869c.getContext();
        j.f(context, "view.context");
        ImageLoaderContract.a.a(bVar, context, actionCard.getImageUrl(), this.f37248e.f15672d, (Integer) null, Integer.valueOf(R.drawable.dog_with_tall_tail), (ImageLoaderContract.b) null, (List) null, (Map) null, (Function0) null, (Function1) null, (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0], 4072, (Object) null);
        this.f37248e.f15670b.setVisibility(8);
        k6.a aVar = this.f37248e;
        aVar.f15671c.setText(aVar.getRoot().getResources().getString(R.string.youre_being_boosted));
        this.f37248e.f15673e.setText(this.f7869c.getResources().getString(R.string.eyes_on_you));
    }
}
