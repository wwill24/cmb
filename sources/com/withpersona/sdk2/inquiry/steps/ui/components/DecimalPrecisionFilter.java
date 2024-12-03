package com.withpersona.sdk2.inquiry.steps.ui.components;

import android.text.InputFilter;
import android.text.Spanned;
import gk.f;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.j;

public final class DecimalPrecisionFilter implements InputFilter {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final int f27563a;

    /* renamed from: b  reason: collision with root package name */
    private final f f27564b = b.b(new DecimalPrecisionFilter$pattern$2(this));

    public DecimalPrecisionFilter(int i10) {
        this.f27563a = i10;
    }

    private final Pattern b() {
        Object value = this.f27564b.getValue();
        j.f(value, "<get-pattern>(...)");
        return (Pattern) value;
    }

    public CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
        j.g(charSequence, "source");
        j.g(spanned, "dest");
        CharSequence subSequence = charSequence.subSequence(i10, i11);
        StringBuilder sb2 = new StringBuilder();
        boolean z10 = false;
        sb2.append(spanned.subSequence(0, i12));
        sb2.append(subSequence);
        sb2.append(spanned.subSequence(i13, spanned.length()));
        Matcher matcher = b().matcher(r.C(sb2.toString(), ',', '.', false, 4, (Object) null));
        j.f(matcher, "pattern.matcher(newVal)");
        if (matcher.matches()) {
            return null;
        }
        if (charSequence.length() == 0) {
            z10 = true;
        }
        if (z10) {
            return spanned.subSequence(i12, i13);
        }
        return "";
    }
}
