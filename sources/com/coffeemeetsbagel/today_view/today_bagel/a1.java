package com.coffeemeetsbagel.today_view.today_bagel;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import androidx.fragment.app.FragmentManager;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.dialogs.DialogPrimarySecondaryVertical;
import com.coffeemeetsbagel.dialogs.a0;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.models.entities.GenderType;
import j5.x;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import qj.q;

public class a1 extends p<TodayBagelView> {

    /* renamed from: e  reason: collision with root package name */
    private final a f37435e;

    /* renamed from: f  reason: collision with root package name */
    private final s9.a f37436f;

    /* renamed from: g  reason: collision with root package name */
    private final a7.a f37437g;

    interface a {
        void W0();

        void b(String str);

        void b1();

        void c();

        void i();

        void i0(String str);

        void j(int i10);

        void p1(Boolean bool);

        void u1();

        void v(d dVar);
    }

    public a1(TodayBagelView todayBagelView, a aVar, s9.a aVar2, a7.a aVar3) {
        super(todayBagelView);
        this.f37435e = aVar;
        this.f37436f = aVar2;
        this.f37437g = aVar3;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C(x xVar) throws Exception {
        L();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D(x xVar) throws Exception {
        this.f37435e.c();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E(x xVar) throws Exception {
        K();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F(x xVar) throws Exception {
        ((TodayBagelView) this.f7869c).l();
        this.f37435e.b1();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void G(x xVar) throws Exception {
        ((TodayBagelView) this.f7869c).l();
        this.f37435e.u1();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit H(String str) {
        this.f37435e.i0(str);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit I() {
        this.f37435e.p1(Boolean.TRUE);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit J() {
        this.f37435e.p1(Boolean.TRUE);
        return null;
    }

    private void K() {
        this.f37435e.i();
    }

    private void L() {
        this.f37435e.W0();
    }

    private CharSequence v(long j10) {
        ImageSpan imageSpan;
        String str = j10 + " ";
        String string = ((TodayBagelView) this.f7869c).getContext().getString(R.string.skip_the_line_primary_cta, new Object[]{str});
        int lastIndexOf = (string.lastIndexOf(str) + str.length()) - 1;
        Drawable drawable = androidx.core.content.a.getDrawable(((TodayBagelView) this.f7869c).getContext(), R.drawable.ic_single_bean);
        drawable.setBounds(0, 4, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.mutate().setTint(-1);
        if (Build.VERSION.SDK_INT >= 29) {
            imageSpan = new ImageSpan(drawable, 2);
        } else {
            imageSpan = new ImageSpan(drawable);
        }
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(imageSpan, lastIndexOf, lastIndexOf + 1, 0);
        return spannableString;
    }

    /* access modifiers changed from: private */
    public void w(Boolean bool) {
        this.f37435e.p1(bool);
    }

    /* access modifiers changed from: private */
    public void y(int i10) {
        this.f37435e.j(i10);
    }

    public void A() {
        ((TodayBagelView) this.f7869c).n();
    }

    public void B(Boolean bool) {
        ((TodayBagelView) this.f7869c).o(bool);
    }

    /* access modifiers changed from: package-private */
    public void M(FragmentManager fragmentManager, String str) {
        ((TodayBagelView) this.f7869c).v(fragmentManager, str);
    }

    public void N() {
        ((TodayBagelView) this.f7869c).w();
        ((com.uber.autodispose.p) ((TodayBagelView) this.f7869c).i().a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new x0(this));
        ((com.uber.autodispose.p) ((TodayBagelView) this.f7869c).i().b().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new y0(this));
    }

    public void O(String str) {
        DialogPrimarySecondaryVertical.f12065a.a(((TodayBagelView) this.f7869c).getContext(), DialogPrimarySecondaryVertical.PrimaryCtaStyle.NORMAL, Integer.valueOf(R.drawable.ic_instant_like), R.string.instant_like_popular_profile_title, R.string.instant_like_popular_profile_text, R.string.instant_like_popular_profile_cta, new z0(this, str), Integer.valueOf(R.string.instant_like_popular_profile_2nd_cta), new p0(this), new q0(this));
    }

    public void P() {
        ((TodayBagelView) this.f7869c).x();
    }

    public void Q() {
        ((TodayBagelView) this.f7869c).y();
    }

    public void R(a0.a aVar, Price price, Function0<Unit> function0) {
        CharSequence charSequence;
        String string = ((TodayBagelView) this.f7869c).getContext().getString(R.string.stand_out_with_flowers);
        String string2 = ((TodayBagelView) this.f7869c).getContext().getString(R.string.send_flowers_description);
        String string3 = ((TodayBagelView) this.f7869c).getContext().getString(R.string.cancel);
        if (price.getFreeItemCount() > 0) {
            charSequence = ((TodayBagelView) this.f7869c).getContext().getString(R.string.skip_the_line_primary_cta, new Object[]{((TodayBagelView) this.f7869c).getContext().getString(R.string.free_caps)});
        } else {
            charSequence = v((long) price.getBeans());
        }
        a0.f12077d.a(((TodayBagelView) this.f7869c).getContext(), string, string2, charSequence, string3, false, aVar, function0);
    }

    public void S(a0.a aVar, Boolean bool, int i10, int i11, Function0<Unit> function0) {
        CharSequence charSequence;
        int i12 = i11;
        String string = ((TodayBagelView) this.f7869c).getContext().getString(R.string.skip_the_line_title);
        String string2 = ((TodayBagelView) this.f7869c).getContext().getString(R.string.skip_the_line_message, new Object[]{Integer.valueOf(i10)});
        String string3 = ((TodayBagelView) this.f7869c).getContext().getString(R.string.skip_the_line_secondary_cta);
        if (i12 == 0) {
            charSequence = ((TodayBagelView) this.f7869c).getContext().getString(R.string.skip_the_line_primary_cta, new Object[]{((TodayBagelView) this.f7869c).getContext().getString(R.string.free_caps)});
        } else {
            charSequence = v((long) i12);
        }
        String str = string2;
        a0.f12077d.a(((TodayBagelView) this.f7869c).getContext(), string, str, charSequence, string3, bool.booleanValue(), aVar, function0);
    }

    public void T(int i10, GenderType genderType, Boolean bool, int i11) {
        ((TodayBagelView) this.f7869c).z(i10, genderType, bool, i11);
    }

    public void U(d dVar) {
        this.f37435e.v(dVar);
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        ((com.uber.autodispose.p) ((TodayBagelView) this.f7869c).g().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new o0(this));
        ((com.uber.autodispose.p) ((TodayBagelView) this.f7869c).h().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new r0(this));
        a aVar = this.f37435e;
        Objects.requireNonNull(aVar);
        ((com.uber.autodispose.p) q.Y(((TodayBagelView) g()).u(), ((TodayBagelView) g()).p()).p0(1000, TimeUnit.MILLISECONDS).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new s0(aVar));
        ((com.uber.autodispose.p) ((TodayBagelView) this.f7869c).A().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new t0(this));
        ((com.uber.autodispose.p) ((TodayBagelView) this.f7869c).t().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new u0(this));
        ((com.uber.autodispose.p) ((TodayBagelView) this.f7869c).B().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new v0(this));
        ((com.uber.autodispose.p) ((TodayBagelView) this.f7869c).C().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new w0(this));
    }

    /* access modifiers changed from: protected */
    public void i() {
        super.i();
        ((TodayBagelView) this.f7869c).k();
    }

    /* access modifiers changed from: package-private */
    public void u() {
        ((TodayBagelView) this.f7869c).j();
    }

    public void z() {
        ((TodayBagelView) this.f7869c).m();
    }
}
