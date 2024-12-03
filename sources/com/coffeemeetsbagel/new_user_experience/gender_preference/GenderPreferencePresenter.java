package com.coffeemeetsbagel.new_user_experience.gender_preference;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import com.coffeemeetsbagel.cmb_views.CmbImageView;
import com.coffeemeetsbagel.cmb_views.CmbRadioGroup;
import com.coffeemeetsbagel.models.entities.GenderType;
import fa.a;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

public final class GenderPreferencePresenter extends p<ViewGroup> {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final a f35057e;

    /* renamed from: f  reason: collision with root package name */
    private final String f35058f;

    public interface a {
        void d();

        void f();

        void o(GenderType genderType);
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35059a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.coffeemeetsbagel.models.entities.GenderType[] r0 = com.coffeemeetsbagel.models.entities.GenderType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.models.entities.GenderType r1 = com.coffeemeetsbagel.models.entities.GenderType.FEMALE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.models.entities.GenderType r1 = com.coffeemeetsbagel.models.entities.GenderType.MALE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.coffeemeetsbagel.models.entities.GenderType r1 = com.coffeemeetsbagel.models.entities.GenderType.BISEXUAL     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f35059a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.new_user_experience.gender_preference.GenderPreferencePresenter.b.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenderPreferencePresenter(ViewGroup viewGroup, a aVar) {
        super(viewGroup);
        j.g(viewGroup, "view");
        j.g(aVar, "listener");
        this.f35057e = aVar;
        String string = viewGroup.getContext().getString(R.string.onboarding_save_error);
        j.f(string, "view.context.getString(R…ng.onboarding_save_error)");
        this.f35058f = string;
    }

    /* access modifiers changed from: private */
    public static final void n(GenderPreferencePresenter genderPreferencePresenter, View view) {
        j.g(genderPreferencePresenter, "this$0");
        genderPreferencePresenter.f35057e.d();
    }

    /* access modifiers changed from: private */
    public static final void o(GenderPreferencePresenter genderPreferencePresenter, View view) {
        j.g(genderPreferencePresenter, "this$0");
        genderPreferencePresenter.f35057e.f();
    }

    /* access modifiers changed from: private */
    public static final void p(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: protected */
    public void d() {
        boolean z10;
        super.d();
        String str = t9.a.onboardingDealbreakersMessageGender;
        j.f(str, "onboardingDealbreakersMessageGender");
        if (str.length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            ((TextView) ((ViewGroup) this.f7869c).findViewById(R.id.message)).setText(t9.a.onboardingDealbreakersMessageGender);
        }
        ((CmbButton) ((ViewGroup) this.f7869c).findViewById(R.id.onboarding_next_button)).setOnClickListener(new h(this));
        ((CmbImageView) ((ViewGroup) this.f7869c).findViewById(R.id.onboarding_back_button)).setOnClickListener(new i(this));
        ((com.uber.autodispose.p) ((CmbRadioGroup) ((ViewGroup) this.f7869c).findViewById(R.id.option_list_container)).h().g(com.uber.autodispose.a.a(this))).c(new j(new GenderPreferencePresenter$didLoad$3(this)));
    }

    public final void q() {
        ((CmbButton) ((ViewGroup) this.f7869c).findViewById(R.id.onboarding_next_button)).setEnabled(true);
    }

    public final String r() {
        return this.f35058f;
    }

    public final void t(GenderType genderType) {
        j.g(genderType, "genderType");
        CmbRadioGroup cmbRadioGroup = (CmbRadioGroup) ((ViewGroup) this.f7869c).findViewById(R.id.option_list_container);
        CheckBox checkBox = (CheckBox) cmbRadioGroup.findViewById(R.id.woman_checkbox);
        CheckBox checkBox2 = (CheckBox) cmbRadioGroup.findViewById(R.id.man_checkbox);
        CheckBox checkBox3 = (CheckBox) cmbRadioGroup.findViewById(R.id.both_checkbox);
        checkBox.setTag(GenderType.FEMALE);
        checkBox2.setTag(GenderType.MALE);
        checkBox3.setTag(GenderType.BISEXUAL);
        int i10 = b.f35059a[genderType.ordinal()];
        if (i10 == 1) {
            checkBox.setChecked(true);
        } else if (i10 == 2) {
            checkBox2.setChecked(true);
        } else if (i10 != 3) {
            a.C0491a aVar = fa.a.f40771d;
            String simpleName = GenderPreferencePresenter.class.getSimpleName();
            j.f(simpleName, "this::class.java.simpleName");
            aVar.b(simpleName, "Unexpected selection: " + genderType);
        } else {
            checkBox3.setChecked(true);
        }
        if (genderType != GenderType.UNSPECIFIED) {
            this.f35057e.o(genderType);
        }
    }
}
