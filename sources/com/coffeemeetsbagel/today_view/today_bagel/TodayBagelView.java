package com.coffeemeetsbagel.today_view.today_bagel;

import android.app.Dialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentManager;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.dialogs.b0;
import com.coffeemeetsbagel.dialogs.s;
import com.coffeemeetsbagel.models.entities.GenderType;
import com.coffeemeetsbagel.today_view.like_with_comment.LikeWithCommentBottomSheet;
import io.reactivex.subjects.PublishSubject;
import j5.x;
import kotlin.Unit;
import l9.d;
import lc.c;
import qj.q;
import r7.h;

public class TodayBagelView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private io.reactivex.subjects.a<x> f37421a = io.reactivex.subjects.a.C0();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final io.reactivex.subjects.a<Boolean> f37422b = io.reactivex.subjects.a.C0();

    /* renamed from: c  reason: collision with root package name */
    private PublishSubject<x> f37423c = PublishSubject.C0();

    /* renamed from: d  reason: collision with root package name */
    private PublishSubject<String> f37424d = PublishSubject.C0();

    /* renamed from: e  reason: collision with root package name */
    private PublishSubject<String> f37425e = PublishSubject.C0();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public io.reactivex.subjects.a<d> f37426f = io.reactivex.subjects.a.C0();

    /* renamed from: g  reason: collision with root package name */
    private io.reactivex.subjects.a<x> f37427g = io.reactivex.subjects.a.C0();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public io.reactivex.subjects.a<Integer> f37428h = io.reactivex.subjects.a.C0();

    /* renamed from: j  reason: collision with root package name */
    private h f37429j;

    /* renamed from: k  reason: collision with root package name */
    private d f37430k;

    /* renamed from: l  reason: collision with root package name */
    private b0 f37431l;

    /* renamed from: m  reason: collision with root package name */
    private s f37432m;

    class a implements l9.a {
        a() {
        }

        public void a(boolean z10) {
            TodayBagelView.this.f37422b.d(Boolean.valueOf(z10));
        }

        public void b(int i10, int i11) {
            TodayBagelView.this.f37426f.d(new d(i10, i11));
        }

        public void j(int i10) {
            TodayBagelView.this.f37428h.d(Integer.valueOf(i10));
        }
    }

    public TodayBagelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q(LikeWithCommentBottomSheet likeWithCommentBottomSheet, View view) {
        this.f37424d.d(likeWithCommentBottomSheet.J0());
        likeWithCommentBottomSheet.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit r() {
        this.f37423c.d(x.a());
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s(View view) {
        this.f37427g.d(x.a());
    }

    public q<d> A() {
        return this.f37426f.P();
    }

    public q<Boolean> B() {
        return this.f37422b;
    }

    public q<Integer> C() {
        return this.f37428h.P();
    }

    public q<x> g() {
        return this.f37421a.P();
    }

    /* access modifiers changed from: package-private */
    public q<x> h() {
        return this.f37423c.P();
    }

    public s i() {
        return this.f37432m;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        this.f37423c.d(x.a());
        c.h((Dialog) null);
    }

    /* access modifiers changed from: package-private */
    public void k() {
        c.i(null);
    }

    public void l() {
        c.h(this.f37432m);
    }

    public void m() {
        c.h(this.f37431l);
    }

    public void n() {
        c.h(this.f37429j);
    }

    public void o(Boolean bool) {
        d dVar = this.f37430k;
        if (dVar != null) {
            dVar.k(bool);
        }
    }

    /* access modifiers changed from: package-private */
    public q<String> p() {
        return this.f37425e.P();
    }

    public q<x> t() {
        return this.f37427g.P();
    }

    /* access modifiers changed from: package-private */
    public q<String> u() {
        return this.f37424d.P();
    }

    /* access modifiers changed from: package-private */
    public void v(FragmentManager fragmentManager, String str) {
        LikeWithCommentBottomSheet L0 = LikeWithCommentBottomSheet.L0(str);
        L0.R0(new c1(this, L0));
        L0.P0(new d1(this));
        L0.show(fragmentManager, "COMMENT_ON_LIKE_BOTTOM_SHEET");
    }

    public void w() {
        if (this.f37432m == null) {
            this.f37432m = new s(getContext(), (int) R.string.its_a_match, (int) R.string.you_liked_each_other, (int) R.string.start_chatting, (int) R.string.not_now, false);
        }
        this.f37432m.show();
        this.f37432m.setCancelable(false);
    }

    public void x() {
        b0 b0Var = new b0(getContext(), R.string.dialog_notenoughbeans_title, R.string.dialog_notenoughbeans_content, R.string.dialog_notenoughbeans_button_dls);
        this.f37431l = b0Var;
        b0Var.b(new b1(this));
        this.f37431l.show();
    }

    public void y() {
        if (this.f37429j == null) {
            this.f37429j = new h(getContext());
        }
        this.f37429j.show();
    }

    public void z(int i10, GenderType genderType, Boolean bool, int i11) {
        d dVar = new d(getContext(), i10, genderType, new a(), bool, i11);
        this.f37430k = dVar;
        dVar.show();
    }
}
