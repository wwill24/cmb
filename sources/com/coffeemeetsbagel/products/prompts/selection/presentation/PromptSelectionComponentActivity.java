package com.coffeemeetsbagel.products.prompts.selection.presentation;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import b6.g;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.products.prompts.selection.presentation.n;
import com.mparticle.identity.IdentityHttpResponse;
import j5.t;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class PromptSelectionComponentActivity extends t<n, y> {

    /* renamed from: m  reason: collision with root package name */
    public static final a f35960m = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context) {
            j.g(context, IdentityHttpResponse.CONTEXT);
            return new Intent(context, PromptSelectionComponentActivity.class);
        }
    }

    /* access modifiers changed from: protected */
    public String K0() {
        return "ActivityPromptsComponentActivity";
    }

    /* access modifiers changed from: protected */
    public int Q0() {
        return R.string.prompt_add_a_prompt;
    }

    /* access modifiers changed from: protected */
    /* renamed from: S0 */
    public n G0() {
        return new n();
    }

    /* access modifiers changed from: protected */
    /* renamed from: T0 */
    public y H0(ViewGroup viewGroup) {
        j.g(viewGroup, "parentViewGroup");
        g A0 = ((n) this.f7848e).A0();
        j.f(A0, "dependencyFragment.component");
        return new h((n.a) A0).b(viewGroup);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        ((y) this.f7849f).n(i10, i11, intent);
    }
}
