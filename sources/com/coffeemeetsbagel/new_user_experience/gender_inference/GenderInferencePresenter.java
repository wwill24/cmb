package com.coffeemeetsbagel.new_user_experience.gender_inference;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import com.coffeemeetsbagel.cmb_views.CmbImageView;
import com.coffeemeetsbagel.cmb_views.CmbRadioGroup;
import com.coffeemeetsbagel.models.constants.ProfileConstants;
import com.coffeemeetsbagel.models.enums.InferredGenderOptions;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

public final class GenderInferencePresenter extends p<ViewGroup> {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final a f35031e;

    /* renamed from: f  reason: collision with root package name */
    private final String f35032f;

    /* renamed from: g  reason: collision with root package name */
    private final String f35033g;

    public interface a {
        void d();

        void f();

        void r1(InferredGenderOptions inferredGenderOptions);
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35034a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.coffeemeetsbagel.models.enums.InferredGenderOptions[] r0 = com.coffeemeetsbagel.models.enums.InferredGenderOptions.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.models.enums.InferredGenderOptions r1 = com.coffeemeetsbagel.models.enums.InferredGenderOptions.MEN     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.models.enums.InferredGenderOptions r1 = com.coffeemeetsbagel.models.enums.InferredGenderOptions.WOMEN     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f35034a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.new_user_experience.gender_inference.GenderInferencePresenter.b.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenderInferencePresenter(ViewGroup viewGroup, a aVar) {
        super(viewGroup);
        j.g(viewGroup, "view");
        j.g(aVar, "listener");
        this.f35031e = aVar;
        String string = viewGroup.getContext().getString(R.string.onboarding_save_error);
        j.f(string, "view.context.getString(R…ng.onboarding_save_error)");
        this.f35032f = string;
        String string2 = viewGroup.getContext().getString(R.string.error_updating_profile);
        j.f(string2, "view.context.getString(R…g.error_updating_profile)");
        this.f35033g = string2;
    }

    /* access modifiers changed from: private */
    public static final void o(GenderInferencePresenter genderInferencePresenter, View view) {
        j.g(genderInferencePresenter, "this$0");
        genderInferencePresenter.f35031e.d();
    }

    /* access modifiers changed from: private */
    public static final void p(GenderInferencePresenter genderInferencePresenter, View view) {
        j.g(genderInferencePresenter, "this$0");
        genderInferencePresenter.f35031e.f();
    }

    /* access modifiers changed from: private */
    public static final void q(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void r(GenderInferencePresenter genderInferencePresenter, View view) {
        j.g(genderInferencePresenter, "this$0");
        GenderInferenceWhyDialog genderInferenceWhyDialog = GenderInferenceWhyDialog.f35035a;
        Context context = ((ViewGroup) genderInferencePresenter.g()).getContext();
        j.f(context, "getView().context");
        genderInferenceWhyDialog.a(context);
    }

    /* access modifiers changed from: protected */
    public void d() {
        boolean z10;
        super.d();
        String str = t9.a.onboardingGenderInferenceHeader;
        j.f(str, "onboardingGenderInferenceHeader");
        if (str.length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            ((TextView) ((ViewGroup) this.f7869c).findViewById(R.id.message)).setText(t9.a.onboardingGenderInferenceHeader);
        }
        ((CmbButton) ((ViewGroup) this.f7869c).findViewById(R.id.onboarding_next_button)).setOnClickListener(new o(this));
        ((CmbImageView) ((ViewGroup) this.f7869c).findViewById(R.id.onboarding_back_button)).setOnClickListener(new p(this));
        ((CheckBox) ((ViewGroup) this.f7869c).findViewById(R.id.woman_checkbox)).setTag(InferredGenderOptions.WOMEN);
        ((CheckBox) ((ViewGroup) this.f7869c).findViewById(R.id.man_checkbox)).setTag(InferredGenderOptions.MEN);
        ((com.uber.autodispose.p) ((CmbRadioGroup) ((ViewGroup) this.f7869c).findViewById(R.id.option_list_container)).h().g(com.uber.autodispose.a.a(this))).c(new q(new GenderInferencePresenter$didLoad$3(this)));
        ((TextView) ((ViewGroup) this.f7869c).findViewById(R.id.see_more_identities)).setOnClickListener(new r(this));
    }

    public final void t() {
        ((CmbButton) ((ViewGroup) this.f7869c).findViewById(R.id.onboarding_next_button)).setEnabled(true);
    }

    public final String u() {
        return this.f35033g;
    }

    public final void v(InferredGenderOptions inferredGenderOptions) {
        j.g(inferredGenderOptions, ProfileConstants.Field.GENDER);
        int i10 = b.f35034a[inferredGenderOptions.ordinal()];
        if (i10 == 1) {
            ((CheckBox) ((ViewGroup) this.f7869c).findViewById(R.id.man_checkbox)).setChecked(true);
        } else if (i10 != 2) {
            fa.a.f40771d.a("GenderInferencePresenter", "No binary choice provided.");
        } else {
            ((CheckBox) ((ViewGroup) this.f7869c).findViewById(R.id.woman_checkbox)).setChecked(true);
        }
        if (inferredGenderOptions != InferredGenderOptions.NULL) {
            this.f35031e.r1(inferredGenderOptions);
        }
    }

    public final InferredGenderOptions w() {
        return (InferredGenderOptions) CollectionsKt___CollectionsKt.P(((CmbRadioGroup) ((ViewGroup) this.f7869c).findViewById(R.id.option_list_container)).getCheckedTags());
    }
}
