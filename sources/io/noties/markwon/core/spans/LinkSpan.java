package io.noties.markwon.core.spans;

import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import androidx.annotation.NonNull;
import ij.c;
import jj.a;

public class LinkSpan extends URLSpan {

    /* renamed from: a  reason: collision with root package name */
    private final a f30066a;

    /* renamed from: b  reason: collision with root package name */
    private final String f30067b;

    /* renamed from: c  reason: collision with root package name */
    private final c f30068c;

    public LinkSpan(@NonNull a aVar, @NonNull String str, @NonNull c cVar) {
        super(str);
        this.f30066a = aVar;
        this.f30067b = str;
        this.f30068c = cVar;
    }

    public void onClick(View view) {
        this.f30068c.a(view, this.f30067b);
    }

    public void updateDrawState(@NonNull TextPaint textPaint) {
        this.f30066a.f(textPaint);
    }
}
