package com.coffeemeetsbagel.products.prompts.editor.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.ViewGroup;
import b6.d;
import b6.u;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.dialogs.HorizontalPrimarySecondaryDialog;
import com.coffeemeetsbagel.products.prompts.editor.presentation.g;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class v extends u<ViewGroup, g.a, PromptEditInteractor> {

    /* renamed from: f  reason: collision with root package name */
    public static final a f35954f = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b implements HorizontalPrimarySecondaryDialog.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ v f35955a;

        b(v vVar) {
            this.f35955a = vVar;
        }

        public void a() {
            ((g.a) this.f35955a.e()).a().finish();
        }

        public void b() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(ViewGroup viewGroup, g.a aVar, PromptEditInteractor promptEditInteractor) {
        super(viewGroup, aVar, promptEditInteractor);
        j.g(viewGroup, "view");
        j.g(aVar, "component");
        j.g(promptEditInteractor, "interactor");
        Intent intent = aVar.a().getIntent();
        j.d(intent);
        Bundle extras = intent.getExtras();
        j.d(extras);
        Parcelable parcelable = extras.getParcelable("ARG_QNA");
        j.d(parcelable);
        promptEditInteractor.T1((QuestionWAnswers) parcelable);
    }

    /* access modifiers changed from: protected */
    public boolean h() {
        if (((PromptEditPresenter) ((PromptEditInteractor) f()).G1()).o()) {
            d<?, ?> a10 = ((g.a) e()).a();
            String string = a10.getString(R.string.prompt_discard_changes);
            j.f(string, "context.getString(R.string.prompt_discard_changes)");
            String string2 = a10.getString(R.string.prompt_discard_changes_message);
            j.f(string2, "context.getString(R.stri…_discard_changes_message)");
            String string3 = a10.getString(R.string.prompt_keep_editing);
            j.f(string3, "context.getString(R.string.prompt_keep_editing)");
            String string4 = a10.getString(R.string.prompt_discard);
            j.f(string4, "context.getString(R.string.prompt_discard)");
            new HorizontalPrimarySecondaryDialog(((g.a) e()).a(), new b(this), string, string2, string3, string4).show();
            return true;
        }
        ((g.a) e()).a().finish();
        return super.h();
    }

    public final void m() {
        h();
    }

    public final void n() {
        ((g.a) e()).a().setResult(41123);
        ((g.a) e()).a().finish();
    }
}
