package com.coffeemeetsbagel.new_user_experience.biography;

import android.content.Context;
import android.text.Annotation;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.TextView;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import com.coffeemeetsbagel.cmb_views.CmbImageView;
import com.coffeemeetsbagel.cmb_views.CmbRadioGroup;
import com.coffeemeetsbagel.cmb_views.DelayAutoCompleteTextView;
import com.coffeemeetsbagel.dialogs.k0;
import com.coffeemeetsbagel.models.Resource;
import com.coffeemeetsbagel.models.School;
import com.coffeemeetsbagel.models.entities.Height;
import com.coffeemeetsbagel.new_user_experience.numberPickers.CentimeterHeightPicker;
import com.coffeemeetsbagel.view.e;
import f5.i;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import x1.k;
import x1.m;

public final class BiographyPresenter extends p<ViewGroup> {

    /* renamed from: e  reason: collision with root package name */
    private final a f34840e;

    /* renamed from: f  reason: collision with root package name */
    private ViewGroup f34841f;

    /* renamed from: g  reason: collision with root package name */
    private final String f34842g;

    /* renamed from: h  reason: collision with root package name */
    private final String f34843h;

    public interface a {
        static /* synthetic */ boolean z(a aVar, boolean z10, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    z10 = false;
                }
                return aVar.e1(z10);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: previous");
        }

        void P0();

        void R0(Resource resource);

        void T(Height height);

        void U(List<Resource> list);

        void W(String str);

        boolean e1(boolean z10);

        void m1(String str);

        void p0();

        void w1(Resource resource);
    }

    public static final class b extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BiographyPresenter f34844a;

        b(BiographyPresenter biographyPresenter) {
            this.f34844a = biographyPresenter;
        }

        public void onClick(View view) {
            j.g(view, "p0");
            this.f34844a.z().P0();
        }

        public void updateDrawState(TextPaint textPaint) {
            j.g(textPaint, "ds");
            textPaint.setUnderlineText(false);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BiographyPresenter(ViewGroup viewGroup, a aVar) {
        super(viewGroup);
        j.g(viewGroup, "view");
        j.g(aVar, "listener");
        this.f34840e = aVar;
        String string = viewGroup.getResources().getString(R.string.onboarding_save_error);
        j.f(string, "view.resources.getString…ng.onboarding_save_error)");
        this.f34842g = string;
        String string2 = viewGroup.getContext().getString(R.string.name_input_error);
        j.f(string2, "view.context.getString(R.string.name_input_error)");
        this.f34843h = string2;
    }

    public static /* synthetic */ void D(BiographyPresenter biographyPresenter, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        biographyPresenter.C(z10);
    }

    /* access modifiers changed from: private */
    public static final void E(BiographyPresenter biographyPresenter, View view) {
        j.g(biographyPresenter, "this$0");
        biographyPresenter.f34840e.p0();
    }

    /* access modifiers changed from: private */
    public static final void G(BiographyPresenter biographyPresenter, CmbRadioGroup cmbRadioGroup, View view) {
        j.g(biographyPresenter, "this$0");
        biographyPresenter.f34840e.w1((Resource) CollectionsKt___CollectionsKt.P(cmbRadioGroup.getCheckedTags()));
    }

    /* access modifiers changed from: private */
    public static final void I(BiographyPresenter biographyPresenter, CmbRadioGroup cmbRadioGroup, View view) {
        j.g(biographyPresenter, "this$0");
        biographyPresenter.f34840e.U(cmbRadioGroup.getCheckedTags());
    }

    /* access modifiers changed from: private */
    public static final void L(NumberPicker numberPicker, NumberPicker numberPicker2, BiographyPresenter biographyPresenter, View view) {
        j.g(biographyPresenter, "this$0");
        biographyPresenter.f34840e.T(new Height(0, numberPicker.getValue(), numberPicker2.getValue()));
    }

    /* access modifiers changed from: private */
    public static final void N(CentimeterHeightPicker centimeterHeightPicker, BiographyPresenter biographyPresenter, View view) {
        j.g(biographyPresenter, "this$0");
        biographyPresenter.f34840e.T(new Height(centimeterHeightPicker.getValue(), 0, 0));
    }

    /* access modifiers changed from: private */
    public static final void P(BiographyPresenter biographyPresenter, EditText editText, View view) {
        j.g(biographyPresenter, "this$0");
        biographyPresenter.f34840e.m1(editText.getText().toString());
    }

    /* access modifiers changed from: private */
    public static final void S(BiographyPresenter biographyPresenter, CmbRadioGroup cmbRadioGroup, View view) {
        j.g(biographyPresenter, "this$0");
        biographyPresenter.f34840e.R0((Resource) CollectionsKt___CollectionsKt.P(cmbRadioGroup.getCheckedTags()));
    }

    /* access modifiers changed from: private */
    public static final void U(DelayAutoCompleteTextView delayAutoCompleteTextView, AdapterView adapterView, View view, int i10, long j10) {
        Object itemAtPosition = adapterView.getItemAtPosition(i10);
        j.e(itemAtPosition, "null cannot be cast to non-null type com.coffeemeetsbagel.models.School");
        delayAutoCompleteTextView.setText(((School) itemAtPosition).getName());
    }

    /* access modifiers changed from: private */
    public static final void V(BiographyPresenter biographyPresenter, DelayAutoCompleteTextView delayAutoCompleteTextView, View view) {
        j.g(biographyPresenter, "this$0");
        biographyPresenter.f34840e.W(delayAutoCompleteTextView.getText().toString());
    }

    private final void X(ViewGroup viewGroup) {
        ((ViewGroup) this.f7869c).removeAllViews();
        x1.p.e(new k((ViewGroup) this.f7869c, viewGroup), new m(8388613));
    }

    private final void Y(ViewGroup viewGroup) {
        ((ViewGroup) this.f7869c).removeAllViews();
        x1.p.e(new k((ViewGroup) this.f7869c, viewGroup), new m(8388611));
    }

    private final ViewGroup u(Integer num) {
        View inflate = LayoutInflater.from(((ViewGroup) this.f7869c).getContext()).inflate(R.layout.component_onboarding_biography_template, (ViewGroup) this.f7869c, false);
        j.e(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) inflate;
        if (num != null) {
            num.intValue();
            ViewStub viewStub = (ViewStub) viewGroup.findViewById(R.id.stub);
            viewStub.setLayoutResource(num.intValue());
            viewStub.inflate();
        }
        CmbImageView cmbImageView = (CmbImageView) viewGroup.findViewById(R.id.onboarding_back_button);
        cmbImageView.setClickable(true);
        ((com.uber.autodispose.p) cmbImageView.c().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new x0(new BiographyPresenter$createTemplate$2(this)));
        cmbImageView.setVisibility(0);
        ((ImageView) viewGroup.findViewById(R.id.onboarding_close_button)).setVisibility(8);
        return viewGroup;
    }

    /* access modifiers changed from: private */
    public static final void v(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    public final String A() {
        return this.f34842g;
    }

    public final void B() {
        ((ViewGroup) this.f7869c).removeView(this.f34841f);
        this.f34841f = null;
    }

    public final void C(boolean z10) {
        View inflate = LayoutInflater.from(((ViewGroup) this.f7869c).getContext()).inflate(R.layout.component_onboarding_biography, (ViewGroup) this.f7869c, false);
        j.e(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) inflate;
        if (z10) {
            X(viewGroup);
        } else {
            Y(viewGroup);
        }
        ((TextView) viewGroup.findViewById(R.id.biography_message)).setText(t9.a.onboardingBiographyHeader);
        ((CmbButton) viewGroup.findViewById(R.id.next_button)).setOnClickListener(new o0(this));
        TextView textView = (TextView) ((ViewGroup) this.f7869c).findViewById(R.id.message);
        if (textView != null) {
            textView.setText(t9.a.onboardingBiographyHeader);
        }
    }

    public final void F(List<Resource> list, String str, boolean z10) {
        ViewGroup u10 = u(Integer.valueOf(R.layout.component_onboarding_vertical_list_container));
        ((TextView) u10.findViewById(R.id.message)).setText(R.string.onboarding_biography_education_degree);
        TextView textView = (TextView) u10.findViewById(R.id.sub_message);
        textView.setVisibility(0);
        textView.setText(R.string.onboarding_biography_education_degree_sub_header);
        LinearLayout linearLayout = (LinearLayout) u10.findViewById(R.id.content_container);
        CmbRadioGroup cmbRadioGroup = (CmbRadioGroup) u10.findViewById(R.id.vertical_list_content_container);
        cmbRadioGroup.setMaxOptions(1);
        LayoutInflater from = LayoutInflater.from(linearLayout.getContext());
        if (list != null) {
            for (Resource resource : list) {
                View inflate = from.inflate(R.layout.cmb_radio_group_checkbox, linearLayout, false);
                j.e(inflate, "null cannot be cast to non-null type android.widget.CheckBox");
                CheckBox checkBox = (CheckBox) inflate;
                checkBox.setText(resource.getValue());
                checkBox.setChecked(j.b(resource.getKey(), str));
                cmbRadioGroup.b(checkBox, resource);
            }
        }
        ((CmbButton) u10.findViewById(R.id.next_button)).setOnClickListener(new q0(this, cmbRadioGroup));
        if (z10) {
            X(u10);
        } else {
            Y(u10);
        }
    }

    public final void H(List<Resource> list, List<String> list2, boolean z10) {
        j.g(list2, "selected");
        ViewGroup u10 = u(Integer.valueOf(R.layout.component_onboarding_vertical_list_container));
        ((TextView) u10.findViewById(R.id.message)).setText(R.string.onboarding_biography_ethnicity_detail);
        LinearLayout linearLayout = (LinearLayout) u10.findViewById(R.id.vertical_list_content_container);
        CmbRadioGroup cmbRadioGroup = (CmbRadioGroup) u10.findViewById(R.id.vertical_list_content_container);
        LayoutInflater from = LayoutInflater.from(linearLayout.getContext());
        if (list != null) {
            for (Resource resource : list) {
                View inflate = from.inflate(R.layout.cmb_radio_group_checkbox, linearLayout, false);
                j.e(inflate, "null cannot be cast to non-null type android.widget.CheckBox");
                CheckBox checkBox = (CheckBox) inflate;
                checkBox.setText(resource.getValue());
                checkBox.setChecked(list2.contains(resource.getValue()));
                cmbRadioGroup.b(checkBox, resource);
            }
        }
        ((CmbButton) u10.findViewById(R.id.next_button)).setOnClickListener(new r0(this, cmbRadioGroup));
        if (z10) {
            X(u10);
        } else {
            Y(u10);
        }
    }

    public final void J() {
        TextView textView = (TextView) ((ViewGroup) this.f7869c).findViewById(R.id.gdpr);
        if (textView != null) {
            textView.setVisibility(0);
        }
        CharSequence text = ((ViewGroup) this.f7869c).getContext().getText(R.string.onboarding_biography_gdpr);
        j.e(text, "null cannot be cast to non-null type android.text.SpannedString");
        SpannedString spannedString = (SpannedString) text;
        Annotation[] annotationArr = (Annotation[]) spannedString.getSpans(0, spannedString.length(), Annotation.class);
        b bVar = new b(this);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(androidx.core.content.a.getColor(((ViewGroup) this.f7869c).getContext(), R.color.main_color));
        SpannableString spannableString = new SpannableString(spannedString);
        spannableString.setSpan(bVar, spannedString.getSpanStart(annotationArr[0]), spannedString.getSpanEnd(annotationArr[0]), 33);
        spannableString.setSpan(foregroundColorSpan, spannedString.getSpanStart(annotationArr[0]), spannedString.getSpanEnd(annotationArr[0]), 33);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void K(Integer num, Integer num2, int i10, int i11, boolean z10) {
        int i12;
        ViewGroup u10 = u(Integer.valueOf(R.layout.component_onboarding_biography_height_imperial));
        ((TextView) u10.findViewById(R.id.message)).setText(R.string.onboarding_biography_height_detail);
        NumberPicker numberPicker = (NumberPicker) u10.findViewById(R.id.height_picker_feet);
        NumberPicker numberPicker2 = (NumberPicker) u10.findViewById(R.id.height_picker_inches);
        if (num != null) {
            numberPicker.setValue(num.intValue());
            if (num2 != null) {
                i12 = num2.intValue();
            } else {
                i12 = 0;
            }
            numberPicker2.setValue(i12);
        } else {
            numberPicker.setValue(i10);
            numberPicker2.setValue(i11);
        }
        ((CmbButton) u10.findViewById(R.id.next_button)).setOnClickListener(new s0(numberPicker, numberPicker2, this));
        if (z10) {
            X(u10);
        } else {
            Y(u10);
        }
    }

    public final void M(Integer num, int i10, boolean z10) {
        ViewGroup u10 = u(Integer.valueOf(R.layout.component_onboarding_biography_height_metric));
        ((TextView) u10.findViewById(R.id.message)).setText(R.string.onboarding_biography_height_detail);
        CentimeterHeightPicker centimeterHeightPicker = (CentimeterHeightPicker) u10.findViewById(R.id.height_picker_centimetres);
        if (num != null) {
            i10 = num.intValue();
        }
        centimeterHeightPicker.setValue(i10);
        ((CmbButton) u10.findViewById(R.id.next_button)).setOnClickListener(new t0(centimeterHeightPicker, this));
        if (z10) {
            X(u10);
        } else {
            Y(u10);
        }
    }

    public final void O(String str, String str2, boolean z10) {
        boolean z11;
        ViewGroup u10 = u(Integer.valueOf(R.layout.onboarding_biography_occupation));
        ((TextView) u10.findViewById(R.id.message)).setText(t9.a.onboardingOccupationTitle);
        TextView textView = (TextView) u10.findViewById(R.id.subtitle);
        String str3 = t9.a.onboardingOccupationSubtitle;
        j.f(str3, "onboardingOccupationSubtitle");
        if (str3.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            textView.setVisibility(0);
            textView.setText(t9.a.onboardingOccupationSubtitle);
        } else {
            textView.setVisibility(8);
        }
        EditText editText = (EditText) u10.findViewById(R.id.text_input);
        if (str2 != null) {
            editText.setHint(str2);
        }
        if (str != null) {
            editText.setText(str);
        }
        ((CmbButton) u10.findViewById(R.id.next_button)).setOnClickListener(new u0(this, editText));
        if (z10) {
            X(u10);
        } else {
            Y(u10);
        }
    }

    public final void Q() {
        TextView textView;
        if (this.f34841f == null) {
            View inflate = LayoutInflater.from(((ViewGroup) this.f7869c).getContext()).inflate(R.layout.onboarding_loading, (ViewGroup) this.f7869c, false);
            j.e(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) inflate;
            this.f34841f = viewGroup;
            if (!(viewGroup == null || (textView = (TextView) viewGroup.findViewById(R.id.loading_message)) == null)) {
                textView.setText(R.string.onboarding_biography_loading);
            }
        }
        try {
            ((ViewGroup) this.f7869c).addView(this.f34841f);
        } catch (IllegalStateException unused) {
        }
    }

    public final void R(List<Resource> list, String str, boolean z10) {
        ViewGroup u10 = u(Integer.valueOf(R.layout.component_onboarding_vertical_list_container));
        ((TextView) u10.findViewById(R.id.message)).setText(R.string.onboarding_biography_religion_detail);
        LinearLayout linearLayout = (LinearLayout) u10.findViewById(R.id.vertical_list_content_container);
        CmbRadioGroup cmbRadioGroup = (CmbRadioGroup) u10.findViewById(R.id.vertical_list_content_container);
        cmbRadioGroup.setMaxOptions(1);
        LayoutInflater from = LayoutInflater.from(linearLayout.getContext());
        if (list != null) {
            for (Resource resource : list) {
                View inflate = from.inflate(R.layout.cmb_radio_group_checkbox, linearLayout, false);
                j.e(inflate, "null cannot be cast to non-null type android.widget.CheckBox");
                CheckBox checkBox = (CheckBox) inflate;
                checkBox.setText(resource.getValue());
                checkBox.setChecked(j.b(resource.getValue(), str));
                cmbRadioGroup.b(checkBox, resource);
            }
        }
        ((CmbButton) u10.findViewById(R.id.next_button)).setOnClickListener(new p0(this, cmbRadioGroup));
        if (z10) {
            X(u10);
        } else {
            Y(u10);
        }
    }

    public final void T(String str, boolean z10) {
        ViewGroup u10 = u(Integer.valueOf(R.layout.component_biography_school_name));
        ((TextView) u10.findViewById(R.id.message)).setText(R.string.onboarding_biography_education_school_name);
        TextView textView = (TextView) u10.findViewById(R.id.sub_message);
        textView.setVisibility(0);
        textView.setText(R.string.onboarding_biography_education_school_name_sub_header);
        DelayAutoCompleteTextView delayAutoCompleteTextView = (DelayAutoCompleteTextView) u10.findViewById(R.id.school_name_input);
        delayAutoCompleteTextView.setAdapter(new i());
        delayAutoCompleteTextView.setLoadingIndicator((ProgressBar) u10.findViewById(R.id.school_name_progress_bar));
        delayAutoCompleteTextView.setOnItemClickListener(new v0(delayAutoCompleteTextView));
        j.f(delayAutoCompleteTextView, "autoCompleteTextView");
        e.d(delayAutoCompleteTextView, new BiographyPresenter$showSchoolName$2(delayAutoCompleteTextView));
        if (str != null) {
            delayAutoCompleteTextView.setText(str);
        }
        ((CmbButton) u10.findViewById(R.id.next_button)).setOnClickListener(new w0(this, delayAutoCompleteTextView));
        if (z10) {
            X(u10);
        } else {
            Y(u10);
        }
    }

    public final void W(k0.a aVar, boolean z10) {
        j.g(aVar, "listener");
        Context context = ((ViewGroup) this.f7869c).getContext();
        j.f(context, "view.context");
        k0 k0Var = new k0(aVar, context);
        if (z10) {
            k0Var.c(R.string.onboarding_biography_degree_skip_dialog);
        } else {
            k0Var.c(R.string.onboarding_biography_skip_dialog);
        }
        k0Var.show();
    }

    public final void w(List<School> list) {
        j.g(list, "schoolList");
        ListAdapter adapter = ((DelayAutoCompleteTextView) ((ViewGroup) this.f7869c).findViewById(R.id.school_name_input)).getAdapter();
        j.e(adapter, "null cannot be cast to non-null type com.coffeemeetsbagel.adapters.SchoolsAutoCompleteAdapter");
        ((i) adapter).c(list);
    }

    public final String y() {
        return this.f34843h;
    }

    public final a z() {
        return this.f34840e;
    }
}
