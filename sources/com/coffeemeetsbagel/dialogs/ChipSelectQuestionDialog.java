package com.coffeemeetsbagel.dialogs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.dialogs.question_chips.QuestionGroupAdapter;
import com.coffeemeetsbagel.models.dto.Location;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.j;
import com.mparticle.identity.IdentityHttpResponse;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import tj.a;

public final class ChipSelectQuestionDialog extends b {

    /* renamed from: d  reason: collision with root package name */
    private final String f12039d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final QuestionGroupType f12040e;

    /* renamed from: f  reason: collision with root package name */
    private final j f12041f;

    /* renamed from: g  reason: collision with root package name */
    private final SaveAnswerUseCase f12042g;

    /* renamed from: h  reason: collision with root package name */
    private final String f12043h;

    /* renamed from: j  reason: collision with root package name */
    public RecyclerView f12044j;

    /* renamed from: k  reason: collision with root package name */
    private final QuestionGroupAdapter f12045k;

    /* renamed from: l  reason: collision with root package name */
    private final a f12046l = new a();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChipSelectQuestionDialog(Context context, String str, QuestionGroupType questionGroupType, j jVar, SaveAnswerUseCase saveAnswerUseCase) {
        super(context, (String) null, (String) null);
        kotlin.jvm.internal.j.g(context, IdentityHttpResponse.CONTEXT);
        kotlin.jvm.internal.j.g(str, "profileId");
        kotlin.jvm.internal.j.g(questionGroupType, "questionGroupType");
        kotlin.jvm.internal.j.g(jVar, "getQuestionsUseCase");
        kotlin.jvm.internal.j.g(saveAnswerUseCase, "saveAnswerUseCase");
        this.f12039d = str;
        this.f12040e = questionGroupType;
        this.f12041f = jVar;
        this.f12042g = saveAnswerUseCase;
        String simpleName = ChipSelectQuestionDialog.class.getSimpleName();
        kotlin.jvm.internal.j.f(simpleName, "ChipSelectQuestionDialog::class.java.simpleName");
        this.f12043h = simpleName;
        QuestionGroupAdapter questionGroupAdapter = new QuestionGroupAdapter(context);
        this.f12045k = questionGroupAdapter;
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
        }
        q().setAdapter(questionGroupAdapter);
        q().h(new i(context, 1));
    }

    /* access modifiers changed from: private */
    public static final void n(ChipSelectQuestionDialog chipSelectQuestionDialog) {
        kotlin.jvm.internal.j.g(chipSelectQuestionDialog, "this$0");
        fa.a.f40771d.a(chipSelectQuestionDialog.f12043h, "Saved selection.");
    }

    /* access modifiers changed from: private */
    public static final void o(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Integer t(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (Integer) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void u(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void v(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: protected */
    public View b(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.chip_select_question_dialog, viewGroup, false);
        kotlin.jvm.internal.j.e(inflate, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        s((RecyclerView) inflate);
        return q();
    }

    public void dismiss() {
        for (Map.Entry next : this.f12045k.J().entrySet()) {
            List list = (List) next.getValue();
            kotlin.jvm.internal.j.f(SaveAnswerUseCase.d(this.f12042g, list, (String) null, (String) next.getKey(), this.f12040e.getQuestionGroupApiString(), (Integer) null, (Float) null, (Float) null, (Float) null, false, (Location) null, 1010, (Object) null).f(new f(this), new g(new ChipSelectQuestionDialog$dismiss$1$disposable$2(this))), "override fun dismiss() {…gDisposable.clear()\n    }");
        }
        super.dismiss();
        this.f12046l.e();
    }

    public final QuestionGroupAdapter p() {
        return this.f12045k;
    }

    public final RecyclerView q() {
        RecyclerView recyclerView = this.f12044j;
        if (recyclerView != null) {
            return recyclerView;
        }
        kotlin.jvm.internal.j.y("recyclerView");
        return null;
    }

    public final String r() {
        return this.f12043h;
    }

    public final void s(RecyclerView recyclerView) {
        kotlin.jvm.internal.j.g(recyclerView, "<set-?>");
        this.f12044j = recyclerView;
    }

    public void show() {
        super.show();
        this.f12046l.a(this.f12045k.P().W(new h(ChipSelectQuestionDialog$show$counterDisposable$1.f12047a)).c(new i(new ChipSelectQuestionDialog$show$counterDisposable$2(this))));
        this.f12046l.a(this.f12041f.a(this.f12039d, this.f12040e, true).a0(sj.a.a()).c(new j(new ChipSelectQuestionDialog$show$loadDisposable$1(this))));
    }
}
