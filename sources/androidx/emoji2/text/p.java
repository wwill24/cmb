package androidx.emoji2.text;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.annotation.NonNull;
import androidx.core.text.d;
import java.util.stream.IntStream;

class p implements Spannable {

    /* renamed from: a  reason: collision with root package name */
    private boolean f5500a = false;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private Spannable f5501b;

    private static class a {
        static IntStream a(CharSequence charSequence) {
            return charSequence.chars();
        }

        static IntStream b(CharSequence charSequence) {
            return charSequence.codePoints();
        }
    }

    static class b {
        b() {
        }

        /* access modifiers changed from: package-private */
        public boolean a(CharSequence charSequence) {
            return charSequence instanceof d;
        }
    }

    static class c extends b {
        c() {
        }

        /* access modifiers changed from: package-private */
        public boolean a(CharSequence charSequence) {
            return (charSequence instanceof PrecomputedText) || (charSequence instanceof d);
        }
    }

    p(@NonNull Spannable spannable) {
        this.f5501b = spannable;
    }

    private void a() {
        Spannable spannable = this.f5501b;
        if (!this.f5500a && c().a(spannable)) {
            this.f5501b = new SpannableString(spannable);
        }
        this.f5500a = true;
    }

    static b c() {
        if (Build.VERSION.SDK_INT < 28) {
            return new b();
        }
        return new c();
    }

    /* access modifiers changed from: package-private */
    public Spannable b() {
        return this.f5501b;
    }

    public char charAt(int i10) {
        return this.f5501b.charAt(i10);
    }

    @NonNull
    public IntStream chars() {
        return a.a(this.f5501b);
    }

    @NonNull
    public IntStream codePoints() {
        return a.b(this.f5501b);
    }

    public int getSpanEnd(Object obj) {
        return this.f5501b.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        return this.f5501b.getSpanFlags(obj);
    }

    public int getSpanStart(Object obj) {
        return this.f5501b.getSpanStart(obj);
    }

    public <T> T[] getSpans(int i10, int i11, Class<T> cls) {
        return this.f5501b.getSpans(i10, i11, cls);
    }

    public int length() {
        return this.f5501b.length();
    }

    public int nextSpanTransition(int i10, int i11, Class cls) {
        return this.f5501b.nextSpanTransition(i10, i11, cls);
    }

    public void removeSpan(Object obj) {
        a();
        this.f5501b.removeSpan(obj);
    }

    public void setSpan(Object obj, int i10, int i11, int i12) {
        a();
        this.f5501b.setSpan(obj, i10, i11, i12);
    }

    @NonNull
    public CharSequence subSequence(int i10, int i11) {
        return this.f5501b.subSequence(i10, i11);
    }

    @NonNull
    public String toString() {
        return this.f5501b.toString();
    }

    p(@NonNull CharSequence charSequence) {
        this.f5501b = new SpannableString(charSequence);
    }
}
