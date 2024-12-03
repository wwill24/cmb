package androidx.activity;

import android.view.View;
import kotlin.jvm.internal.j;

public final class p {
    public static final void a(View view, k kVar) {
        j.g(view, "<this>");
        j.g(kVar, "fullyDrawnReporterOwner");
        view.setTag(o.report_drawn, kVar);
    }
}
