package androidx.core.text;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.NonNull;
import androidx.core.util.c;

public class d implements Spannable {

    /* renamed from: d  reason: collision with root package name */
    private static final Object f4709d = new Object();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Spannable f4710a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final a f4711b;

    /* renamed from: c  reason: collision with root package name */
    private final PrecomputedText f4712c;

    @NonNull
    public a a() {
        return this.f4711b;
    }

    public PrecomputedText b() {
        Spannable spannable = this.f4710a;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    public char charAt(int i10) {
        return this.f4710a.charAt(i10);
    }

    public int getSpanEnd(Object obj) {
        return this.f4710a.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        return this.f4710a.getSpanFlags(obj);
    }

    public int getSpanStart(Object obj) {
        return this.f4710a.getSpanStart(obj);
    }

    public <T> T[] getSpans(int i10, int i11, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 29) {
            return this.f4712c.getSpans(i10, i11, cls);
        }
        return this.f4710a.getSpans(i10, i11, cls);
    }

    public int length() {
        return this.f4710a.length();
    }

    public int nextSpanTransition(int i10, int i11, Class cls) {
        return this.f4710a.nextSpanTransition(i10, i11, cls);
    }

    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.f4712c.removeSpan(obj);
        } else {
            this.f4710a.removeSpan(obj);
        }
    }

    public void setSpan(Object obj, int i10, int i11, int i12) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.f4712c.setSpan(obj, i10, i11, i12);
        } else {
            this.f4710a.setSpan(obj, i10, i11, i12);
        }
    }

    public CharSequence subSequence(int i10, int i11) {
        return this.f4710a.subSequence(i10, i11);
    }

    @NonNull
    public String toString() {
        return this.f4710a.toString();
    }

    public static final class a {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final TextPaint f4713a;

        /* renamed from: b  reason: collision with root package name */
        private final TextDirectionHeuristic f4714b;

        /* renamed from: c  reason: collision with root package name */
        private final int f4715c;

        /* renamed from: d  reason: collision with root package name */
        private final int f4716d;

        /* renamed from: e  reason: collision with root package name */
        final PrecomputedText.Params f4717e;

        /* renamed from: androidx.core.text.d$a$a  reason: collision with other inner class name */
        public static class C0042a {
            @NonNull

            /* renamed from: a  reason: collision with root package name */
            private final TextPaint f4718a;

            /* renamed from: b  reason: collision with root package name */
            private TextDirectionHeuristic f4719b = TextDirectionHeuristics.FIRSTSTRONG_LTR;

            /* renamed from: c  reason: collision with root package name */
            private int f4720c = 1;

            /* renamed from: d  reason: collision with root package name */
            private int f4721d = 1;

            public C0042a(@NonNull TextPaint textPaint) {
                this.f4718a = textPaint;
            }

            @NonNull
            public a a() {
                return new a(this.f4718a, this.f4719b, this.f4720c, this.f4721d);
            }

            public C0042a b(int i10) {
                this.f4720c = i10;
                return this;
            }

            public C0042a c(int i10) {
                this.f4721d = i10;
                return this;
            }

            public C0042a d(@NonNull TextDirectionHeuristic textDirectionHeuristic) {
                this.f4719b = textDirectionHeuristic;
                return this;
            }
        }

        a(@NonNull TextPaint textPaint, @NonNull TextDirectionHeuristic textDirectionHeuristic, int i10, int i11) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f4717e = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i10).setHyphenationFrequency(i11).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.f4717e = null;
            }
            this.f4713a = textPaint;
            this.f4714b = textDirectionHeuristic;
            this.f4715c = i10;
            this.f4716d = i11;
        }

        public boolean a(@NonNull a aVar) {
            if (this.f4715c != aVar.b() || this.f4716d != aVar.c() || this.f4713a.getTextSize() != aVar.e().getTextSize() || this.f4713a.getTextScaleX() != aVar.e().getTextScaleX() || this.f4713a.getTextSkewX() != aVar.e().getTextSkewX() || this.f4713a.getLetterSpacing() != aVar.e().getLetterSpacing() || !TextUtils.equals(this.f4713a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()) || this.f4713a.getFlags() != aVar.e().getFlags() || !this.f4713a.getTextLocales().equals(aVar.e().getTextLocales())) {
                return false;
            }
            if (this.f4713a.getTypeface() == null) {
                if (aVar.e().getTypeface() != null) {
                    return false;
                }
                return true;
            } else if (!this.f4713a.getTypeface().equals(aVar.e().getTypeface())) {
                return false;
            } else {
                return true;
            }
        }

        public int b() {
            return this.f4715c;
        }

        public int c() {
            return this.f4716d;
        }

        public TextDirectionHeuristic d() {
            return this.f4714b;
        }

        @NonNull
        public TextPaint e() {
            return this.f4713a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (a(aVar) && this.f4714b == aVar.d()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return c.b(Float.valueOf(this.f4713a.getTextSize()), Float.valueOf(this.f4713a.getTextScaleX()), Float.valueOf(this.f4713a.getTextSkewX()), Float.valueOf(this.f4713a.getLetterSpacing()), Integer.valueOf(this.f4713a.getFlags()), this.f4713a.getTextLocales(), this.f4713a.getTypeface(), Boolean.valueOf(this.f4713a.isElegantTextHeight()), this.f4714b, Integer.valueOf(this.f4715c), Integer.valueOf(this.f4716d));
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("{");
            sb2.append("textSize=" + this.f4713a.getTextSize());
            sb2.append(", textScaleX=" + this.f4713a.getTextScaleX());
            sb2.append(", textSkewX=" + this.f4713a.getTextSkewX());
            int i10 = Build.VERSION.SDK_INT;
            sb2.append(", letterSpacing=" + this.f4713a.getLetterSpacing());
            sb2.append(", elegantTextHeight=" + this.f4713a.isElegantTextHeight());
            sb2.append(", textLocale=" + this.f4713a.getTextLocales());
            sb2.append(", typeface=" + this.f4713a.getTypeface());
            if (i10 >= 26) {
                sb2.append(", variationSettings=" + this.f4713a.getFontVariationSettings());
            }
            sb2.append(", textDir=" + this.f4714b);
            sb2.append(", breakStrategy=" + this.f4715c);
            sb2.append(", hyphenationFrequency=" + this.f4716d);
            sb2.append("}");
            return sb2.toString();
        }

        public a(@NonNull PrecomputedText.Params params) {
            this.f4713a = params.getTextPaint();
            this.f4714b = params.getTextDirection();
            this.f4715c = params.getBreakStrategy();
            this.f4716d = params.getHyphenationFrequency();
            this.f4717e = Build.VERSION.SDK_INT < 29 ? null : params;
        }
    }
}
