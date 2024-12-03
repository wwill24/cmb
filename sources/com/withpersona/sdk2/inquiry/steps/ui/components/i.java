package com.withpersona.sdk2.inquiry.steps.ui.components;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.jvm.internal.j;

final class i implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    private final String f27583a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f27584b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f27585c;

    public i(String str) {
        j.g(str, "mask");
        this.f27583a = str;
    }

    public void afterTextChanged(Editable editable) {
        j.g(editable, "editable");
        if (!this.f27584b && !this.f27585c) {
            this.f27584b = true;
            int length = editable.length();
            if (length < this.f27583a.length()) {
                if (this.f27583a.charAt(length) != '#') {
                    editable.append(this.f27583a.charAt(length));
                } else if (true ^ r.w(editable)) {
                    int i10 = length - 1;
                    if (this.f27583a.charAt(i10) != '#') {
                        editable.insert(i10, this.f27583a, i10, length);
                    }
                }
            }
            this.f27584b = false;
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        j.g(charSequence, "charSequence");
        this.f27585c = i11 > i12;
    }

    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        j.g(charSequence, "charSequence");
    }
}
