package com.coffeemeetsbagel.products.my_answers.presentation;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.google.android.gms.common.api.a;
import gk.f;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.j;
import lc.m;
import r7.h;

public final class MyAnswersPresenter extends p<View> {

    /* renamed from: e  reason: collision with root package name */
    private final MyAnswersAdapter f35834e;

    /* renamed from: f  reason: collision with root package name */
    private final MyAnswersLocation f35835f;

    /* renamed from: g  reason: collision with root package name */
    private int f35836g = a.e.API_PRIORITY_OTHER;

    /* renamed from: h  reason: collision with root package name */
    private final f f35837h = b.b(new MyAnswersPresenter$progressDialog$2(this));

    /* renamed from: j  reason: collision with root package name */
    private TextView f35838j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f35839k;

    /* renamed from: l  reason: collision with root package name */
    private CardView f35840l;

    /* renamed from: m  reason: collision with root package name */
    private RecyclerView f35841m;

    /* renamed from: n  reason: collision with root package name */
    private Button f35842n;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35843a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.coffeemeetsbagel.products.my_answers.presentation.MyAnswersLocation[] r0 = com.coffeemeetsbagel.products.my_answers.presentation.MyAnswersLocation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.products.my_answers.presentation.MyAnswersLocation r1 = com.coffeemeetsbagel.products.my_answers.presentation.MyAnswersLocation.PROFILE_READ_ONLY     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.products.my_answers.presentation.MyAnswersLocation r1 = com.coffeemeetsbagel.products.my_answers.presentation.MyAnswersLocation.PROFILE_EDIT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f35843a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.products.my_answers.presentation.MyAnswersPresenter.a.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MyAnswersPresenter(ViewStub viewStub, MyAnswersAdapter myAnswersAdapter, PublishSubject<Unit> publishSubject, MyAnswersLocation myAnswersLocation) {
        super(viewStub);
        j.g(viewStub, "viewStub");
        j.g(myAnswersAdapter, "adapter");
        j.g(publishSubject, "clickInput");
        j.g(myAnswersLocation, "layoutType");
        this.f35834e = myAnswersAdapter;
        this.f35835f = myAnswersLocation;
        viewStub.setLayoutResource(R.layout.rib_my_answers);
        View inflate = viewStub.inflate();
        j.f(inflate, "viewStub.inflate()");
        View findViewById = inflate.findViewById(R.id.add_prompt_card);
        j.f(findViewById, "inflatedView.findViewById(R.id.add_prompt_card)");
        this.f35840l = (CardView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.title);
        j.f(findViewById2, "inflatedView.findViewById(R.id.title)");
        this.f35838j = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.description);
        j.f(findViewById3, "inflatedView.findViewById(R.id.description)");
        this.f35839k = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.add_prompt_button);
        j.f(findViewById4, "inflatedView.findViewById(R.id.add_prompt_button)");
        Button button = (Button) findViewById4;
        this.f35842n = button;
        button.setOnClickListener(new i0(publishSubject));
        View findViewById5 = inflate.findViewById(R.id.prompts);
        j.f(findViewById5, "inflatedView.findViewById(R.id.prompts)");
        RecyclerView recyclerView = (RecyclerView) findViewById5;
        this.f35841m = recyclerView;
        recyclerView.setAdapter(myAnswersAdapter);
        o();
    }

    /* access modifiers changed from: private */
    public static final void k(PublishSubject publishSubject, View view) {
        j.g(publishSubject, "$clickInput");
        publishSubject.d(Unit.f32013a);
    }

    private final h n() {
        return (h) this.f35837h.getValue();
    }

    private final void o() {
        int i10;
        int i11 = a.f35843a[this.f35835f.ordinal()];
        if (i11 == 1) {
            i10 = 2;
        } else if (i11 == 2) {
            m mVar = m.f41114a;
            Context context = this.f7869c.getContext();
            j.f(context, "view.context");
            i10 = mVar.a(context, 16.0f);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        ViewGroup.LayoutParams layoutParams = this.f35840l.getLayoutParams();
        j.e(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.topMargin = i10;
        marginLayoutParams.setMarginStart(i10);
        marginLayoutParams.setMarginEnd(i10);
        if (i10 > 2) {
            this.f35841m.h(new u5.a(i10));
            int i12 = i10 / 2;
            this.f35841m.setPadding(i12, i12, i12, i12);
            return;
        }
        m mVar2 = m.f41114a;
        Context context2 = this.f7869c.getContext();
        j.f(context2, "view.context");
        marginLayoutParams.bottomMargin = mVar2.a(context2, 32.0f);
    }

    private final void r(int i10) {
        if (i10 < this.f35836g) {
            this.f35840l.setVisibility(0);
            TextView textView = null;
            if (i10 == 0) {
                TextView textView2 = this.f35838j;
                if (textView2 == null) {
                    j.y("addAnswerWidgetTitle");
                    textView2 = null;
                }
                textView2.setText(this.f7869c.getResources().getString(R.string.prompt_add_widget_title_empty));
                TextView textView3 = this.f35839k;
                if (textView3 == null) {
                    j.y("addAnswerWidgetDesc");
                } else {
                    textView = textView3;
                }
                textView.setText(this.f7869c.getResources().getString(R.string.prompt_add_widget_desc_empty));
                return;
            }
            TextView textView4 = this.f35838j;
            if (textView4 == null) {
                j.y("addAnswerWidgetTitle");
                textView4 = null;
            }
            textView4.setText(this.f7869c.getResources().getString(R.string.prompt_add_widget_title));
            TextView textView5 = this.f35839k;
            if (textView5 == null) {
                j.y("addAnswerWidgetDesc");
            } else {
                textView = textView5;
            }
            textView.setText(this.f7869c.getResources().getString(R.string.prompt_add_widget_desc));
            return;
        }
        this.f35840l.setVisibility(8);
    }

    public final void m(int i10) {
        this.f35834e.G(i10);
        r(this.f35834e.g());
    }

    public final void p(boolean z10) {
        if (z10) {
            n().show();
        } else {
            n().dismiss();
        }
    }

    public final void q(List<QuestionWAnswers> list, int i10) {
        j.g(list, "data");
        this.f35836g = i10;
        this.f35834e.J(list);
        r(list.size());
    }
}
