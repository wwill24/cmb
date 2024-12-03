package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import androidx.annotation.NonNull;
import d.a;

public class s extends RatingBar {

    /* renamed from: a  reason: collision with root package name */
    private final q f1440a;

    public s(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.ratingBarStyle);
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        Bitmap b10 = this.f1440a.b();
        if (b10 != null) {
            setMeasuredDimension(View.resolveSizeAndState(b10.getWidth() * getNumStars(), i10, 0), getMeasuredHeight());
        }
    }

    public s(@NonNull Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        c1.a(this, getContext());
        q qVar = new q(this);
        this.f1440a = qVar;
        qVar.c(attributeSet, i10);
    }
}
