package androidx.core.content.res;

import android.graphics.Typeface;
import androidx.core.content.res.h;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h.f f4571a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Typeface f4572b;

    public /* synthetic */ j(h.f fVar, Typeface typeface) {
        this.f4571a = fVar;
        this.f4572b = typeface;
    }

    public final void run() {
        this.f4571a.g(this.f4572b);
    }
}
