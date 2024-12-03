package com.coffeemeetsbagel.products.prompts.editor.presentation;

import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import com.coffeemeetsbagel.models.dto.Answer;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import gk.f;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;
import kotlin.jvm.internal.j;
import r7.h;

public final class PromptEditPresenter extends p<ViewGroup> {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final wa.a f35915e;

    /* renamed from: f  reason: collision with root package name */
    private final w f35916f;

    /* renamed from: g  reason: collision with root package name */
    private final PublishSubject<Unit> f35917g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f35918h;

    /* renamed from: j  reason: collision with root package name */
    private final f f35919j = b.b(new PromptEditPresenter$progressDialog$2(this));

    public static final class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PromptEditPresenter f35920a;

        a(PromptEditPresenter promptEditPresenter) {
            this.f35920a = promptEditPresenter;
        }

        public void afterTextChanged(Editable editable) {
            j.g(editable, "s");
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            j.g(charSequence, "s");
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            j.g(charSequence, "s");
            boolean z10 = true;
            boolean z11 = !j.b(charSequence.toString(), this.f35920a.f35918h);
            CmbButton cmbButton = this.f35920a.f35915e.f42102b;
            if (!(!r.w(charSequence)) || !z11) {
                z10 = false;
            }
            cmbButton.setEnabled(z10);
            this.f35920a.f35915e.f42104d.scrollTo(0, this.f35920a.f35915e.f42103c.getBottom());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PromptEditPresenter(wa.a aVar, w wVar, PublishSubject<Unit> publishSubject) {
        super(aVar.getRoot());
        j.g(aVar, "binding");
        j.g(wVar, "listener");
        j.g(publishSubject, "backNavClicks");
        this.f35915e = aVar;
        this.f35916f = wVar;
        this.f35917g = publishSubject;
    }

    private final h p() {
        return (h) this.f35919j.getValue();
    }

    /* access modifiers changed from: private */
    public static final void r(PromptEditPresenter promptEditPresenter, View view) {
        j.g(promptEditPresenter, "this$0");
        promptEditPresenter.f35917g.d(Unit.f32013a);
    }

    /* access modifiers changed from: private */
    public static final void t(PromptEditPresenter promptEditPresenter, QuestionWAnswers questionWAnswers, View view) {
        j.g(promptEditPresenter, "this$0");
        j.g(questionWAnswers, "$questionWAnswers");
        promptEditPresenter.w(questionWAnswers.e().getId());
    }

    private final void w(String str) {
        this.f35916f.G(str, String.valueOf(this.f35915e.f42103c.getText()));
    }

    public final boolean o() {
        boolean z10;
        String valueOf = String.valueOf(this.f35915e.f42103c.getText());
        if (valueOf.length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10 || j.b(valueOf, this.f35918h)) {
            return false;
        }
        return true;
    }

    public final void q(QuestionWAnswers questionWAnswers) {
        String str;
        j.g(questionWAnswers, "questionWAnswers");
        Answer answer = (Answer) CollectionsKt___CollectionsKt.P(questionWAnswers.d());
        if (answer != null) {
            str = answer.getTextValue();
        } else {
            str = null;
        }
        this.f35918h = str;
        Drawable b10 = e.a.b(((ViewGroup) this.f7869c).getContext(), R.drawable.ic_back);
        if (b10 != null) {
            androidx.core.graphics.drawable.a.n(b10, androidx.core.content.a.getColor(((ViewGroup) this.f7869c).getContext(), R.color.main_color));
        }
        this.f35915e.f42106f.setNavigationIcon(b10);
        this.f35915e.f42106f.setNavigationOnClickListener(new t(this));
        this.f35915e.f42105e.setText(questionWAnswers.e().getText());
        boolean z10 = false;
        this.f35915e.f42102b.setEnabled(false);
        this.f35915e.f42102b.setOnClickListener(new u(this, questionWAnswers));
        this.f35915e.f42103c.addTextChangedListener(new a(this));
        String placeholder = questionWAnswers.e().getPlaceholder();
        if (placeholder == null || placeholder.length() == 0) {
            z10 = true;
        }
        if (!z10) {
            this.f35915e.f42103c.setHint(placeholder);
        }
        String str2 = this.f35918h;
        if (str2 != null) {
            this.f35915e.f42103c.setText(str2);
        }
        this.f35915e.f42103c.requestFocus();
    }

    public final void u(int i10) {
        V v10 = this.f7869c;
        j.f(v10, "view");
        sb.a.f(v10, i10);
    }

    public final void v(boolean z10) {
        if (z10) {
            p().show();
        } else {
            p().dismiss();
        }
    }
}
