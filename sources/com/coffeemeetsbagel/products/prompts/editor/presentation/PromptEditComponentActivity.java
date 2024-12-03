package com.coffeemeetsbagel.products.prompts.editor.presentation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import b6.d;
import b6.g;
import com.coffeemeetsbagel.products.prompts.editor.presentation.l;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class PromptEditComponentActivity extends d<l, v> {

    /* renamed from: j  reason: collision with root package name */
    public static final a f35909j = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context, QuestionWAnswers questionWAnswers) {
            j.g(context, IdentityHttpResponse.CONTEXT);
            j.g(questionWAnswers, "question");
            Intent intent = new Intent(context, PromptEditComponentActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("ARG_QNA", questionWAnswers);
            intent.putExtras(bundle);
            return intent;
        }
    }

    /* access modifiers changed from: protected */
    public String K0() {
        return "";
    }

    /* access modifiers changed from: protected */
    /* renamed from: N0 */
    public l G0() {
        return new l();
    }

    /* access modifiers changed from: protected */
    /* renamed from: O0 */
    public v H0(ViewGroup viewGroup) {
        j.g(viewGroup, "parentViewGroup");
        g A0 = ((l) this.f7848e).A0();
        j.f(A0, "dependencyFragment.component");
        return new g((l.a) A0).b(viewGroup);
    }
}
