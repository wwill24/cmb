package androidx.emoji2.text;

import android.text.TextPaint;
import androidx.annotation.NonNull;
import androidx.core.graphics.c;
import androidx.emoji2.text.e;

class d implements e.d {

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal<StringBuilder> f5415b = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    private final TextPaint f5416a;

    d() {
        TextPaint textPaint = new TextPaint();
        this.f5416a = textPaint;
        textPaint.setTextSize(10.0f);
    }

    private static StringBuilder b() {
        ThreadLocal<StringBuilder> threadLocal = f5415b;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        return threadLocal.get();
    }

    public boolean a(@NonNull CharSequence charSequence, int i10, int i11, int i12) {
        StringBuilder b10 = b();
        b10.setLength(0);
        while (i10 < i11) {
            b10.append(charSequence.charAt(i10));
            i10++;
        }
        return c.a(this.f5416a, b10.toString());
    }
}
