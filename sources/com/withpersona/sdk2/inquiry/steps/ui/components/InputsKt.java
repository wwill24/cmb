package com.withpersona.sdk2.inquiry.steps.ui.components;

import aj.b;
import aj.c;
import aj.h;
import aj.i;
import aj.l;
import aj.q;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputLayout;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.ui.TextControllerControlEditTextKt;
import com.squareup.workflow1.ui.k;
import com.withpersona.sdk2.inquiry.steps.ui.e;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$TextBasedTextColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;
import kotlin.sequences.Sequence;
import ti.n;
import ti.p;

public final class InputsKt {

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27572a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f27573b;

        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|(2:31|32)|33|35) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|35) */
        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|35) */
        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|35) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0055 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0067 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x007b */
        static {
            /*
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputText$InputType[] r0 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputText.InputType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputText$InputType r2 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputText.InputType.TEXT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputText$InputType r3 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputText.InputType.EMAIL     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputText$InputType r4 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputText.InputType.NUMBER_PAD     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f27572a = r0
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputText$AutofillHint[] r0 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputText.AutofillHint.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputText$AutofillHint r4 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputText.AutofillHint.NAME     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputText$AutofillHint r1 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputText.AutofillHint.NAME_FIRST     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputText$AutofillHint r1 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputText.AutofillHint.NAME_MIDDLE     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputText$AutofillHint r1 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputText.AutofillHint.NAME_LAST     // Catch:{ NoSuchFieldError -> 0x004c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004c }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004c }
            L_0x004c:
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputText$AutofillHint r1 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputText.AutofillHint.EMAIL     // Catch:{ NoSuchFieldError -> 0x0055 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0055 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0055 }
            L_0x0055:
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputText$AutofillHint r1 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputText.AutofillHint.ADDRESS_LINE_1     // Catch:{ NoSuchFieldError -> 0x005e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputText$AutofillHint r1 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputText.AutofillHint.ADDRESS_LINE_2     // Catch:{ NoSuchFieldError -> 0x0067 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0067 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0067 }
            L_0x0067:
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputText$AutofillHint r1 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputText.AutofillHint.CITY     // Catch:{ NoSuchFieldError -> 0x0071 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0071 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputText$AutofillHint r1 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputText.AutofillHint.COUNTRY     // Catch:{ NoSuchFieldError -> 0x007b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007b }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007b }
            L_0x007b:
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputText$AutofillHint r1 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputText.AutofillHint.POSTAL_CODE     // Catch:{ NoSuchFieldError -> 0x0085 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0085 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0085 }
            L_0x0085:
                f27573b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.components.InputsKt.a.<clinit>():void");
        }
    }

    public static final ConstraintLayout g(Context context, UiComponent.InputAddress inputAddress) {
        String str;
        String str2;
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(inputAddress, "component");
        c c10 = c.c(LayoutInflater.from(context));
        UiComponent.InputAddress.Attributes F = inputAddress.z();
        if (F != null) {
            k n10 = inputAddress.n();
            EditText editText = c10.f24837c.getEditText();
            j.d(editText);
            TextControllerControlEditTextKt.b(n10, editText);
            k r10 = inputAddress.r();
            EditText editText2 = c10.f24842h.getEditText();
            j.d(editText2);
            TextControllerControlEditTextKt.b(r10, editText2);
            k d10 = inputAddress.d();
            EditText editText3 = c10.f24836b.getEditText();
            j.d(editText3);
            TextControllerControlEditTextKt.b(d10, editText3);
            k f10 = inputAddress.f();
            EditText editText4 = c10.f24841g.getEditText();
            j.d(editText4);
            TextControllerControlEditTextKt.b(f10, editText4);
            k e10 = inputAddress.e();
            EditText editText5 = c10.f24840f.getEditText();
            j.d(editText5);
            TextControllerControlEditTextKt.b(e10, editText5);
            String p10 = F.p();
            if (p10 != null) {
                c10.f24837c.setHint((CharSequence) p10);
            }
            String q10 = F.q();
            if (q10 != null) {
                c10.f24842h.setHint((CharSequence) q10);
            }
            String m10 = F.m();
            if (m10 != null) {
                c10.f24836b.setHint((CharSequence) m10);
            }
            boolean b10 = j.b(F.D(), "US");
            TextInputLayout textInputLayout = c10.f24841g;
            if (b10) {
                str = F.s();
            } else {
                str = F.r();
            }
            textInputLayout.setHint((CharSequence) str);
            TextInputLayout textInputLayout2 = c10.f24840f;
            if (b10) {
                str2 = F.o();
            } else {
                str2 = F.n();
            }
            textInputLayout2.setHint((CharSequence) str2);
            String l10 = F.l();
            if (l10 != null) {
                c10.f24839e.setText(l10);
            }
        }
        c10.getRoot().setTag(c10);
        TextView textView = c10.f24839e;
        j.f(textView, "addressLabel");
        com.withpersona.sdk2.inquiry.shared.ui.k.b(textView, new InputsKt$inputAddressView$1$2(inputAddress, c10));
        TextInputLayout textInputLayout3 = c10.f24837c;
        j.f(textInputLayout3, "addressField");
        com.withpersona.sdk2.inquiry.shared.ui.k.b(textInputLayout3, new InputsKt$inputAddressView$1$3(inputAddress, c10));
        TextInputLayout textInputLayout4 = c10.f24842h;
        j.f(textInputLayout4, "addressSuite");
        com.withpersona.sdk2.inquiry.shared.ui.k.b(textInputLayout4, new InputsKt$inputAddressView$1$4(inputAddress, c10));
        TextInputLayout textInputLayout5 = c10.f24836b;
        j.f(textInputLayout5, "addressCity");
        com.withpersona.sdk2.inquiry.shared.ui.k.b(textInputLayout5, new InputsKt$inputAddressView$1$5(inputAddress, c10));
        TextInputLayout textInputLayout6 = c10.f24841g;
        j.f(textInputLayout6, "addressSubdivision");
        com.withpersona.sdk2.inquiry.shared.ui.k.b(textInputLayout6, new InputsKt$inputAddressView$1$6(inputAddress, c10));
        TextInputLayout textInputLayout7 = c10.f24840f;
        j.f(textInputLayout7, "addressPostalCode");
        com.withpersona.sdk2.inquiry.shared.ui.k.b(textInputLayout7, new InputsKt$inputAddressView$1$7(inputAddress, c10));
        c10.getRoot().setTag(c10);
        ConstraintLayout b11 = c10.getRoot();
        j.f(b11, "inflate(LayoutInflater.f… root.tag = this\n  }.root");
        return b11;
    }

    public static final MaterialCheckBox h(Context context, UiComponent.InputCheckbox inputCheckbox) {
        String str;
        boolean z10;
        AttributeStyles$TextBasedTextColorStyle i10;
        StyleElements.SimpleElementColor a10;
        StyleElements.SimpleElementColorValue a11;
        String a12;
        Boolean i11;
        UiComponent.InputCheckbox inputCheckbox2 = inputCheckbox;
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(inputCheckbox2, "component");
        h c10 = h.c(LayoutInflater.from(context));
        MaterialCheckBox materialCheckBox = c10.f24860b;
        UiComponent.InputCheckbox.Attributes E = inputCheckbox.z();
        if (E != null) {
            str = E.h();
        } else {
            str = null;
        }
        materialCheckBox.setText(str);
        MaterialCheckBox materialCheckBox2 = c10.f24860b;
        UiComponent.InputCheckbox.Attributes E2 = inputCheckbox.z();
        if (E2 == null || (i11 = E2.i()) == null) {
            z10 = false;
        } else {
            z10 = i11.booleanValue();
        }
        materialCheckBox2.setChecked(z10);
        c10.f24860b.setOnCheckedChangeListener(new h(inputCheckbox2));
        UiComponent.InputCheckbox.InputCheckboxComponentStyle F = inputCheckbox.F();
        if (!(F == null || (i10 = F.i()) == null || (a10 = i10.a()) == null || (a11 = a10.a()) == null || (a12 = a11.a()) == null)) {
            int i12 = com.withpersona.sdk2.inquiry.steps.ui.c.colorOnSurface;
            int[] iArr = new int[3];
            iArr[0] = androidx.core.graphics.a.l(n.d(context, i12, (TypedValue) null, false, 6, (Object) null), (int) (androidx.core.content.res.h.g(context.getResources(), e.material_emphasis_disabled) * ((float) 255)));
            int[] iArr2 = iArr;
            iArr2[1] = n.d(context, i12, (TypedValue) null, false, 6, (Object) null);
            iArr2[2] = Color.parseColor(a12);
            c10.f24860b.setButtonTintList(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{-16842912}, new int[]{16842912}}, iArr2));
        }
        MaterialCheckBox b10 = c10.getRoot();
        j.f(b10, "root");
        com.withpersona.sdk2.inquiry.shared.ui.k.b(b10, new InputsKt$inputCheckboxView$1$3(inputCheckbox2, c10));
        MaterialCheckBox b11 = c10.getRoot();
        j.f(b11, "inflate(LayoutInflater.f…edStyle)\n    }\n  }\n}.root");
        return b11;
    }

    /* access modifiers changed from: private */
    public static final void i(UiComponent.InputCheckbox inputCheckbox, CompoundButton compoundButton, boolean z10) {
        j.g(inputCheckbox, "$component");
        inputCheckbox.j().b(z10);
    }

    public static final ConstraintLayout j(Context context, UiComponent.InputConfirmationCode inputConfirmationCode) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(inputConfirmationCode, "component");
        b c10 = b.c(LayoutInflater.from(context));
        List m10 = q.m(c10.f24831b.getEditText(), c10.f24833d.getEditText(), c10.f24834e.getEditText(), c10.f24832c.getEditText());
        for (IndexedValue indexedValue : CollectionsKt___CollectionsKt.D0(m10)) {
            int a10 = indexedValue.a();
            EditText editText = (EditText) indexedValue.b();
            EditText editText2 = (EditText) CollectionsKt___CollectionsKt.Q(m10, a10 - 1);
            EditText editText3 = (EditText) CollectionsKt___CollectionsKt.Q(m10, a10 + 1);
            if (editText != null) {
                p.a(editText, new InputsKt$inputConfirmationCode$1$1$1(m10, editText, editText2, editText3, inputConfirmationCode, c10));
            }
            if (editText2 != null) {
                t(editText, new InputsKt$inputConfirmationCode$1$1$2(editText2));
            }
            v(editText);
        }
        ConstraintLayout b10 = c10.getRoot();
        j.f(b10, "root");
        Sequence<TextInputLayout> i10 = SequencesKt___SequencesKt.i(ViewGroupKt.a(b10), InputsKt$inputConfirmationCode$lambda$32$$inlined$filterIsInstance$1.f27571a);
        j.e(i10, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        for (TextInputLayout textInputLayout : i10) {
            com.withpersona.sdk2.inquiry.shared.ui.k.b(textInputLayout, new InputsKt$inputConfirmationCode$1$2(inputConfirmationCode, textInputLayout));
        }
        ConstraintLayout b11 = c10.getRoot();
        j.f(b11, "inflate(LayoutInflater.f…\n      }\n    }\n  }\n}.root");
        return b11;
    }

    /* JADX WARNING: type inference failed for: r2v4, types: [android.widget.EditText] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.constraintlayout.widget.ConstraintLayout k(android.content.Context r13, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputDate r14) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.j.g(r13, r0)
            java.lang.String r0 = "component"
            kotlin.jvm.internal.j.g(r14, r0)
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r13)
            aj.e r0 = aj.e.c(r0)
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputDate$Attributes r1 = r14.z()
            if (r1 == 0) goto L_0x015e
            android.widget.TextView r2 = r0.f24848b
            java.lang.String r3 = r1.f()
            r2.setText(r3)
            java.util.List r2 = r1.k()
            if (r2 != 0) goto L_0x002b
            java.util.List r2 = kotlin.collections.q.j()
        L_0x002b:
            xi.a r3 = new xi.a
            int r4 = com.withpersona.sdk2.inquiry.steps.ui.h.pi2_ui_date_list_item
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputDateComponentStyle r5 = r14.D()
            r6 = 0
            if (r5 == 0) goto L_0x0041
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputSelectComponentStyle r5 = r5.i()
            if (r5 == 0) goto L_0x0041
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.TextBasedComponentStyle r5 = r5.w()
            goto L_0x0042
        L_0x0041:
            r5 = r6
        L_0x0042:
            r3.<init>(r13, r4, r2, r5)
            com.google.android.material.textfield.TextInputLayout r13 = r0.f24851e
            android.widget.EditText r13 = r13.getEditText()
            boolean r4 = r13 instanceof android.widget.AutoCompleteTextView
            if (r4 == 0) goto L_0x0052
            android.widget.AutoCompleteTextView r13 = (android.widget.AutoCompleteTextView) r13
            goto L_0x0053
        L_0x0052:
            r13 = r6
        L_0x0053:
            r4 = 0
            if (r13 == 0) goto L_0x007e
            r13.setAdapter(r3)
            java.lang.String r3 = r1.h()
            r13.setText(r3, r4)
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputDateComponentStyle r3 = r14.D()
            if (r3 == 0) goto L_0x007e
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$DateSelectBackgroundColorStyle r3 = r3.a()
            if (r3 == 0) goto L_0x007e
            java.lang.String r3 = r3.d()
            if (r3 == 0) goto L_0x007e
            android.graphics.drawable.ColorDrawable r5 = new android.graphics.drawable.ColorDrawable
            int r3 = android.graphics.Color.parseColor(r3)
            r5.<init>(r3)
            r13.setDropDownBackgroundDrawable(r5)
        L_0x007e:
            com.google.android.material.textfield.TextInputLayout r13 = r0.f24849c
            java.lang.String r3 = r1.g()
            r13.setHint((java.lang.CharSequence) r3)
            com.google.android.material.textfield.TextInputLayout r13 = r0.f24849c
            android.widget.EditText r13 = r13.getEditText()
            if (r13 != 0) goto L_0x0090
            goto L_0x0093
        L_0x0090:
            r13.setTransformationMethod(r6)
        L_0x0093:
            com.google.android.material.textfield.TextInputLayout r13 = r0.f24852f
            java.lang.String r3 = r1.i()
            r13.setHint((java.lang.CharSequence) r3)
            com.google.android.material.textfield.TextInputLayout r13 = r0.f24852f
            android.widget.EditText r13 = r13.getEditText()
            if (r13 != 0) goto L_0x00a5
            goto L_0x00a8
        L_0x00a5:
            r13.setTransformationMethod(r6)
        L_0x00a8:
            java.lang.String r13 = r1.j()
            if (r13 == 0) goto L_0x0113
            int r1 = r13.length()
            r3 = 1
            if (r1 != 0) goto L_0x00b7
            r1 = r3
            goto L_0x00b8
        L_0x00b7:
            r1 = r4
        L_0x00b8:
            if (r1 == 0) goto L_0x00bc
            r7 = r6
            goto L_0x00bd
        L_0x00bc:
            r7 = r13
        L_0x00bd:
            if (r7 == 0) goto L_0x0113
            char[] r8 = new char[r3]
            r13 = 45
            r8[r4] = r13
            r9 = 0
            r10 = 0
            r11 = 6
            r12 = 0
            java.util.List r13 = kotlin.text.StringsKt__StringsKt.B0(r7, r8, r9, r10, r11, r12)
            com.google.android.material.textfield.TextInputLayout r1 = r0.f24852f
            android.widget.EditText r1 = r1.getEditText()
            if (r1 == 0) goto L_0x00de
            java.lang.Object r5 = r13.get(r4)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r1.setText(r5)
        L_0x00de:
            java.lang.Object r1 = r13.get(r3)
            java.lang.String r1 = (java.lang.String) r1
            int r1 = java.lang.Integer.parseInt(r1)
            int r1 = r1 - r3
            java.lang.Object r1 = r2.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            com.google.android.material.textfield.TextInputLayout r2 = r0.f24851e
            android.widget.EditText r2 = r2.getEditText()
            boolean r3 = r2 instanceof android.widget.AutoCompleteTextView
            if (r3 == 0) goto L_0x00fc
            r6 = r2
            android.widget.AutoCompleteTextView r6 = (android.widget.AutoCompleteTextView) r6
        L_0x00fc:
            if (r6 == 0) goto L_0x0101
            r6.setText(r1, r4)
        L_0x0101:
            com.google.android.material.textfield.TextInputLayout r1 = r0.f24849c
            android.widget.EditText r1 = r1.getEditText()
            if (r1 == 0) goto L_0x0113
            r2 = 2
            java.lang.Object r13 = r13.get(r2)
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r1.setText(r13)
        L_0x0113:
            android.widget.TextView r13 = r0.f24848b
            java.lang.String r1 = "dateLabel"
            kotlin.jvm.internal.j.f(r13, r1)
            com.withpersona.sdk2.inquiry.steps.ui.components.InputsKt$inputDateView$1$1$4 r1 = new com.withpersona.sdk2.inquiry.steps.ui.components.InputsKt$inputDateView$1$1$4
            r1.<init>(r14, r0)
            com.withpersona.sdk2.inquiry.shared.ui.k.b(r13, r1)
            android.widget.TextView r13 = r0.f24850d
            java.lang.String r1 = "errorLabel"
            kotlin.jvm.internal.j.f(r13, r1)
            com.withpersona.sdk2.inquiry.steps.ui.components.InputsKt$inputDateView$1$1$5 r1 = new com.withpersona.sdk2.inquiry.steps.ui.components.InputsKt$inputDateView$1$1$5
            r1.<init>(r14, r0)
            com.withpersona.sdk2.inquiry.shared.ui.k.b(r13, r1)
            com.google.android.material.textfield.TextInputLayout r13 = r0.f24851e
            java.lang.String r1 = "month"
            kotlin.jvm.internal.j.f(r13, r1)
            com.withpersona.sdk2.inquiry.steps.ui.components.InputsKt$inputDateView$1$1$6 r1 = new com.withpersona.sdk2.inquiry.steps.ui.components.InputsKt$inputDateView$1$1$6
            r1.<init>(r14, r0)
            com.withpersona.sdk2.inquiry.shared.ui.k.b(r13, r1)
            com.google.android.material.textfield.TextInputLayout r13 = r0.f24849c
            java.lang.String r1 = "day"
            kotlin.jvm.internal.j.f(r13, r1)
            com.withpersona.sdk2.inquiry.steps.ui.components.InputsKt$inputDateView$1$1$7 r1 = new com.withpersona.sdk2.inquiry.steps.ui.components.InputsKt$inputDateView$1$1$7
            r1.<init>(r14, r0)
            com.withpersona.sdk2.inquiry.shared.ui.k.b(r13, r1)
            com.google.android.material.textfield.TextInputLayout r13 = r0.f24852f
            java.lang.String r1 = "year"
            kotlin.jvm.internal.j.f(r13, r1)
            com.withpersona.sdk2.inquiry.steps.ui.components.InputsKt$inputDateView$1$1$8 r1 = new com.withpersona.sdk2.inquiry.steps.ui.components.InputsKt$inputDateView$1$1$8
            r1.<init>(r14, r0)
            com.withpersona.sdk2.inquiry.shared.ui.k.b(r13, r1)
        L_0x015e:
            androidx.constraintlayout.widget.ConstraintLayout r13 = r0.getRoot()
            java.lang.String r1 = "root"
            kotlin.jvm.internal.j.f(r13, r1)
            com.withpersona.sdk2.inquiry.steps.ui.components.InputsKt$inputDateView$1$2 r1 = new com.withpersona.sdk2.inquiry.steps.ui.components.InputsKt$inputDateView$1$2
            r1.<init>(r14, r0)
            com.withpersona.sdk2.inquiry.shared.ui.k.b(r13, r1)
            androidx.constraintlayout.widget.ConstraintLayout r13 = r0.getRoot()
            r13.setTag(r0)
            androidx.constraintlayout.widget.ConstraintLayout r13 = r0.getRoot()
            java.lang.String r14 = "inflate(LayoutInflater.f…\n  root.tag = this\n}.root"
            kotlin.jvm.internal.j.f(r13, r14)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.components.InputsKt.k(android.content.Context, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputDate):androidx.constraintlayout.widget.ConstraintLayout");
    }

    public static final TextInputLayout l(Context context, UiComponent.InputNumber inputNumber) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(inputNumber, "component");
        i c10 = i.c(LayoutInflater.from(context));
        UiComponent.InputNumber.Attributes E = inputNumber.z();
        if (E != null) {
            k a10 = inputNumber.a();
            EditText editText = c10.f24862b.getEditText();
            j.d(editText);
            TextControllerControlEditTextKt.b(a10, editText);
            String h10 = E.h();
            if (h10 != null) {
                c10.f24862b.setHint((CharSequence) h10);
            }
            String i10 = E.i();
            if (i10 != null) {
                c10.f24862b.setPlaceholderText(i10);
            }
            Integer j10 = E.j();
            if (j10 != null) {
                int intValue = j10.intValue();
                EditText editText2 = c10.f24862b.getEditText();
                if (editText2 != null) {
                    editText2.setFilters((InputFilter[]) new DecimalPrecisionFilter[]{new DecimalPrecisionFilter(intValue)});
                }
            }
        }
        TextInputLayout textInputLayout = c10.f24862b;
        j.f(textInputLayout, "inputLayout");
        com.withpersona.sdk2.inquiry.shared.ui.k.b(textInputLayout, new InputsKt$inputNumberView$1$2(inputNumber, c10));
        TextInputLayout b10 = c10.getRoot();
        j.f(b10, "inflate(LayoutInflater.f…(styles)\n    }\n  }\n}.root");
        return b10;
    }

    public static final TextInputLayout m(Context context, UiComponent.InputPhoneNumber inputPhoneNumber) {
        EditText editText;
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(inputPhoneNumber, "component");
        aj.j c10 = aj.j.c(LayoutInflater.from(context));
        UiComponent.InputPhoneNumber.Attributes E = inputPhoneNumber.z();
        if (E != null) {
            String j10 = E.j();
            if (!(j10 == null || (editText = c10.f24864b.getEditText()) == null)) {
                editText.setText(j10);
            }
            String h10 = E.h();
            if (h10 != null) {
                c10.f24864b.setHint((CharSequence) h10);
            }
            String i10 = E.i();
            if (i10 != null) {
                c10.f24864b.setPlaceholderText(i10);
            }
            EditText editText2 = c10.f24864b.getEditText();
            if (editText2 != null) {
                k a10 = inputPhoneNumber.a();
                j.f(editText2, "editText");
                TextControllerControlEditTextKt.b(a10, editText2);
                editText2.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
            }
        }
        TextInputLayout textInputLayout = c10.f24864b;
        j.f(textInputLayout, "inputLayout");
        com.withpersona.sdk2.inquiry.shared.ui.k.b(textInputLayout, new InputsKt$inputPhoneNumberView$1$2(inputPhoneNumber, c10));
        TextInputLayout b10 = c10.getRoot();
        j.f(b10, "inflate(LayoutInflater.f…(styles)\n    }\n  }\n}.root");
        return b10;
    }

    public static final LinearLayout n(Context context, UiComponent.InputRadioGroup inputRadioGroup) {
        List<UiComponent.InputRadioGroup.Option> list;
        String str;
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(inputRadioGroup, "component");
        aj.k c10 = aj.k.c(LayoutInflater.from(context));
        UiComponent.InputRadioGroup.Attributes E = inputRadioGroup.z();
        if (E == null || (list = E.i()) == null) {
            list = q.j();
        }
        Iterator<UiComponent.InputRadioGroup.Option> it = list.iterator();
        while (true) {
            str = null;
            boolean z10 = false;
            if (!it.hasNext()) {
                break;
            }
            UiComponent.InputRadioGroup.Option next = it.next();
            UiComponent.InputRadioGroup.Attributes E2 = inputRadioGroup.z();
            if (E2 != null) {
                str = E2.j();
            }
            aj.a c11 = aj.a.c(LayoutInflater.from(context));
            c11.getRoot().setText(next.a());
            MaterialRadioButton b10 = c11.getRoot();
            j.f(b10, "root");
            com.withpersona.sdk2.inquiry.shared.ui.k.b(b10, new InputsKt$inputRadioGroup$1$1$1(inputRadioGroup, c11, c10));
            c10.f24866b.addView(c11.getRoot());
            if (str != null && t.a1(str)) {
                z10 = true;
            }
            if (z10 && j.b(next.c(), str)) {
                c11.getRoot().setChecked(true);
            }
        }
        c10.f24866b.setOnCheckedChangeListener(new f(c10, inputRadioGroup));
        UiComponent.InputRadioGroup.Attributes E3 = inputRadioGroup.z();
        if (E3 != null) {
            str = E3.h();
        }
        if (str != null) {
            c10.f24868d.setVisibility(0);
            c10.f24868d.setText(inputRadioGroup.z().h());
            LinearLayout b11 = c10.getRoot();
            j.f(b11, "root");
            com.withpersona.sdk2.inquiry.shared.ui.k.b(b11, new InputsKt$inputRadioGroup$1$3(inputRadioGroup, c10));
        } else {
            c10.f24868d.setVisibility(8);
        }
        LinearLayout b12 = c10.getRoot();
        j.f(b12, "root");
        com.withpersona.sdk2.inquiry.shared.ui.k.b(b12, new InputsKt$inputRadioGroup$1$4(inputRadioGroup, c10));
        LinearLayout b13 = c10.getRoot();
        j.f(b13, "inflate(LayoutInflater.f…gins(it)\n    }\n  }\n}.root");
        return b13;
    }

    /* access modifiers changed from: private */
    public static final void o(aj.k kVar, UiComponent.InputRadioGroup inputRadioGroup, RadioGroup radioGroup, int i10) {
        List<UiComponent.InputRadioGroup.Option> i11;
        T t10;
        CharSequence charSequence;
        j.g(kVar, "$this_apply");
        j.g(inputRadioGroup, "$component");
        MaterialRadioButton materialRadioButton = (MaterialRadioButton) kVar.f24866b.findViewById(i10);
        UiComponent.InputRadioGroup.Attributes E = inputRadioGroup.z();
        String str = null;
        if (!(E == null || (i11 = E.i()) == null)) {
            Iterator<T> it = i11.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t10 = null;
                    break;
                }
                t10 = it.next();
                String a10 = ((UiComponent.InputRadioGroup.Option) t10).a();
                if (materialRadioButton != null) {
                    charSequence = materialRadioButton.getText();
                } else {
                    charSequence = null;
                }
                if (j.b(a10, charSequence)) {
                    break;
                }
            }
            UiComponent.InputRadioGroup.Option option = (UiComponent.InputRadioGroup.Option) t10;
            if (option != null) {
                str = option.c();
            }
        }
        if (str != null) {
            inputRadioGroup.a().d(str);
        }
    }

    public static final TextInputLayout p(Context context, UiComponent.InputMaskedText inputMaskedText) {
        boolean z10;
        String i10;
        EditText editText;
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(inputMaskedText, "component");
        q c10 = q.c(LayoutInflater.from(context));
        UiComponent.InputMaskedText.Attributes E = inputMaskedText.z();
        if (E != null) {
            String k10 = E.k();
            if (!(k10 == null || (editText = c10.getRoot().getEditText()) == null)) {
                editText.setText(k10);
            }
            String h10 = E.h();
            if (h10 != null) {
                c10.getRoot().setHint((CharSequence) h10);
            }
            String j10 = E.j();
            if (j10 != null) {
                c10.getRoot().setPlaceholderText(j10);
            }
        }
        UiComponent.InputMaskedText.Attributes E2 = inputMaskedText.z();
        if (E2 != null) {
            z10 = j.b(E2.l(), Boolean.TRUE);
        } else {
            z10 = false;
        }
        if (z10) {
            c10.getRoot().setEndIconMode(1);
            c10.getRoot().setEndIconContentDescription((CharSequence) "show text");
            EditText editText2 = c10.getRoot().getEditText();
            if (editText2 != null) {
                editText2.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
        UiComponent.InputMaskedText.Attributes E3 = inputMaskedText.z();
        if (!(E3 == null || (i10 = E3.i()) == null)) {
            EditText editText3 = c10.getRoot().getEditText();
            if (editText3 != null) {
                editText3.setFilters((InputFilter[]) new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(i10.length())});
            }
            EditText editText4 = c10.getRoot().getEditText();
            if (editText4 != null) {
                editText4.addTextChangedListener(new i(i10));
            }
        }
        EditText editText5 = c10.getRoot().getEditText();
        if (editText5 != null) {
            k a10 = inputMaskedText.a();
            j.f(editText5, "editText");
            TextControllerControlEditTextKt.b(a10, editText5);
        }
        TextInputLayout b10 = c10.getRoot();
        j.f(b10, "root");
        com.withpersona.sdk2.inquiry.shared.ui.k.b(b10, new InputsKt$inputSecureText$1$4(inputMaskedText, c10));
        TextInputLayout b11 = c10.getRoot();
        j.f(b11, "inflate(LayoutInflater.f…(styles)\n    }\n  }\n}.root");
        return b11;
    }

    public static final TextInputLayout q(Context context, UiComponent.InputText inputText) {
        String str;
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(inputText, "component");
        l c10 = l.c(LayoutInflater.from(context));
        UiComponent.InputText.Attributes E = inputText.z();
        if (E != null) {
            k a10 = inputText.a();
            EditText editText = c10.f24870b.getEditText();
            j.d(editText);
            TextControllerControlEditTextKt.b(a10, editText);
            String j10 = E.j();
            if (j10 != null) {
                c10.f24870b.setHint((CharSequence) j10);
            }
            String k10 = E.k();
            if (k10 != null) {
                c10.f24870b.setPlaceholderText(k10);
            }
            int x10 = x(E.i());
            EditText editText2 = c10.f24870b.getEditText();
            if (editText2 != null) {
                editText2.setInputType(x10);
            }
            if (Build.VERSION.SDK_INT >= 26) {
                UiComponent.InputText.AutofillHint g10 = E.g();
                if (g10 != null) {
                    str = y(g10);
                } else {
                    str = null;
                }
                c10.f24870b.setAutofillHints(new String[]{str});
            }
        }
        TextInputLayout textInputLayout = c10.f24870b;
        j.f(textInputLayout, "inputLayout");
        com.withpersona.sdk2.inquiry.shared.ui.k.b(textInputLayout, new InputsKt$inputTextView$1$2(inputText, c10));
        TextInputLayout b10 = c10.getRoot();
        j.f(b10, "inflate(LayoutInflater.f…(styles)\n    }\n  }\n}.root");
        return b10;
    }

    /* access modifiers changed from: private */
    public static final void r(String str, List<? extends EditText> list) {
        if (str.length() >= list.size()) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                int length = (str.length() - list.size()) + i10;
                EditText editText = (EditText) list.get(i10);
                if (editText != null) {
                    editText.setText(String.valueOf(str.charAt(length)));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void s(EditText editText, String str) {
        if (editText.getSelectionStart() == 1) {
            editText.setText(String.valueOf(t.d1(str)));
        } else {
            editText.setText(String.valueOf(t.e1(str)));
        }
    }

    private static final void t(EditText editText, Function0<Unit> function0) {
        if (editText != null) {
            editText.setOnKeyListener(new g(editText, function0));
        }
    }

    /* access modifiers changed from: private */
    public static final boolean u(EditText editText, Function0 function0, View view, int i10, KeyEvent keyEvent) {
        boolean z10;
        j.g(function0, "$moveToPreviousEditText");
        if (i10 == 67 && keyEvent.getAction() == 0) {
            Editable text = editText.getText();
            j.f(text, "editText.text");
            if (text.length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                function0.invoke();
                return true;
            }
        }
        return false;
    }

    private static final void v(EditText editText) {
        if (editText != null) {
            editText.setOnFocusChangeListener(new e(editText));
        }
    }

    /* access modifiers changed from: private */
    public static final void w(EditText editText, View view, boolean z10) {
        if (z10) {
            Editable text = editText.getText();
            editText.setSelection(text != null ? text.length() : 0);
        }
    }

    private static final int x(UiComponent.InputText.InputType inputType) {
        int i10 = a.f27572a[inputType.ordinal()];
        if (i10 == 1) {
            return 1;
        }
        if (i10 == 2) {
            return 32;
        }
        if (i10 == 3) {
            return 2;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final String y(UiComponent.InputText.AutofillHint autofillHint) {
        switch (a.f27573b[autofillHint.ordinal()]) {
            case 1:
                return "personName";
            case 2:
                return "personGivenName";
            case 3:
                return "personMiddleName";
            case 4:
                return "personFamilyName";
            case 5:
                return "emailAddress";
            case 6:
                return "streetAddress";
            case 7:
                return "extendedAddress";
            case 8:
                return "addressLocality";
            case 9:
                return "addressCountry";
            case 10:
                return "postalCode";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
