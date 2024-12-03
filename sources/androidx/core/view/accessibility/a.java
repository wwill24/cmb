package androidx.core.view.accessibility;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;

public final class a extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    private final int f4751a;

    /* renamed from: b  reason: collision with root package name */
    private final k f4752b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4753c;

    public a(int i10, @NonNull k kVar, int i11) {
        this.f4751a = i10;
        this.f4752b = kVar;
        this.f4753c = i11;
    }

    public void onClick(@NonNull View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f4751a);
        this.f4752b.Q(this.f4753c, bundle);
    }
}
