package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import d.a;

public class u extends SeekBar {

    /* renamed from: a  reason: collision with root package name */
    private final v f1449a;

    public u(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.seekBarStyle);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f1449a.h();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f1449a.i();
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f1449a.g(canvas);
    }

    public u(@NonNull Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        c1.a(this, getContext());
        v vVar = new v(this);
        this.f1449a = vVar;
        vVar.c(attributeSet, i10);
    }
}
