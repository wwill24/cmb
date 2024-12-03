package com.coffeemeetsbagel.products.prompts.selection.presentation;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import b6.p;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import gk.f;
import java.util.List;
import kotlin.jvm.internal.j;
import lc.m;
import r7.h;
import u5.a;
import wa.b;

public final class PromptSelectionPresenter extends p<ViewGroup> {

    /* renamed from: e  reason: collision with root package name */
    private final PromptSelectionAdapter f35968e;

    /* renamed from: f  reason: collision with root package name */
    private final f f35969f = b.b(new PromptSelectionPresenter$progressDialog$2(this));

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PromptSelectionPresenter(b bVar, PromptSelectionAdapter promptSelectionAdapter) {
        super(bVar.getRoot());
        j.g(bVar, "binding");
        j.g(promptSelectionAdapter, "adapter");
        this.f35968e = promptSelectionAdapter;
        bVar.f42108b.setAdapter(promptSelectionAdapter);
        bVar.f42108b.setLayoutManager(new GridLayoutManager(((ViewGroup) this.f7869c).getContext(), 2));
        m mVar = m.f41114a;
        Context context = ((ViewGroup) this.f7869c).getContext();
        j.f(context, "view.context");
        bVar.f42108b.h(new a(mVar.a(context, 16.0f)));
    }

    private final h k() {
        return (h) this.f35969f.getValue();
    }

    public final void l(int i10) {
        V v10 = this.f7869c;
        j.f(v10, "view");
        sb.a.f(v10, i10);
    }

    public final void m(boolean z10) {
        if (z10) {
            k().show();
        } else {
            k().dismiss();
        }
    }

    public final void n(List<QuestionWAnswers> list) {
        j.g(list, "data");
        this.f35968e.I(list);
    }
}
