package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import androidx.annotation.NonNull;

public final class o extends i {

    /* renamed from: f  reason: collision with root package name */
    private static Paint f5499f;

    public o(@NonNull g gVar) {
        super(gVar);
    }

    @NonNull
    private static Paint c() {
        if (f5499f == null) {
            TextPaint textPaint = new TextPaint();
            f5499f = textPaint;
            textPaint.setColor(e.b().c());
            f5499f.setStyle(Paint.Style.FILL);
        }
        return f5499f;
    }

    public void draw(@NonNull Canvas canvas, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i10, int i11, float f10, int i12, int i13, int i14, @NonNull Paint paint) {
        if (e.b().i()) {
            canvas.drawRect(f10, (float) i12, f10 + ((float) b()), (float) i14, c());
        }
        a().a(canvas, f10, (float) i13, paint);
    }
}
