package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.n0;
import com.google.android.gms.common.api.a;
import d.j;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

class e0 {

    /* renamed from: l  reason: collision with root package name */
    private static final RectF f1245l = new RectF();
    @SuppressLint({"BanConcurrentHashMap"})

    /* renamed from: m  reason: collision with root package name */
    private static ConcurrentHashMap<String, Method> f1246m = new ConcurrentHashMap<>();
    @SuppressLint({"BanConcurrentHashMap"})

    /* renamed from: n  reason: collision with root package name */
    private static ConcurrentHashMap<String, Field> f1247n = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with root package name */
    private int f1248a = 0;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1249b = false;

    /* renamed from: c  reason: collision with root package name */
    private float f1250c = -1.0f;

    /* renamed from: d  reason: collision with root package name */
    private float f1251d = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    private float f1252e = -1.0f;

    /* renamed from: f  reason: collision with root package name */
    private int[] f1253f = new int[0];

    /* renamed from: g  reason: collision with root package name */
    private boolean f1254g = false;

    /* renamed from: h  reason: collision with root package name */
    private TextPaint f1255h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final TextView f1256i;

    /* renamed from: j  reason: collision with root package name */
    private final Context f1257j;

    /* renamed from: k  reason: collision with root package name */
    private final f f1258k;

    private static final class a {
        @NonNull
        static StaticLayout a(@NonNull CharSequence charSequence, @NonNull Layout.Alignment alignment, int i10, @NonNull TextView textView, @NonNull TextPaint textPaint) {
            return new StaticLayout(charSequence, textPaint, i10, alignment, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), textView.getIncludeFontPadding());
        }

        static int b(@NonNull TextView textView) {
            return textView.getMaxLines();
        }
    }

    private static final class b {
        static boolean a(@NonNull View view) {
            return view.isInLayout();
        }
    }

    private static final class c {
        @NonNull
        static StaticLayout a(@NonNull CharSequence charSequence, @NonNull Layout.Alignment alignment, int i10, int i11, @NonNull TextView textView, @NonNull TextPaint textPaint, @NonNull f fVar) {
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i10);
            StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i11 == -1) {
                i11 = a.e.API_PRIORITY_OTHER;
            }
            hyphenationFrequency.setMaxLines(i11);
            try {
                fVar.a(obtain, textView);
            } catch (ClassCastException unused) {
            }
            return obtain.build();
        }
    }

    private static class d extends f {
        d() {
        }

        /* access modifiers changed from: package-private */
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) e0.m(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    private static class e extends d {
        e() {
        }

        /* access modifiers changed from: package-private */
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        /* access modifiers changed from: package-private */
        public boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    private static class f {
        f() {
        }

        /* access modifiers changed from: package-private */
        public void a(StaticLayout.Builder builder, TextView textView) {
            throw null;
        }

        /* access modifiers changed from: package-private */
        public boolean b(TextView textView) {
            return ((Boolean) e0.m(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    e0(@NonNull TextView textView) {
        this.f1256i = textView;
        this.f1257j = textView.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            this.f1258k = new e();
        } else {
            this.f1258k = new d();
        }
    }

    private int[] b(int[] iArr) {
        if (r0 == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            if (i10 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i10)) < 0) {
                arrayList.add(Integer.valueOf(i10));
            }
        }
        if (r0 == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i11 = 0; i11 < size; i11++) {
            iArr2[i11] = ((Integer) arrayList.get(i11)).intValue();
        }
        return iArr2;
    }

    private void c() {
        this.f1248a = 0;
        this.f1251d = -1.0f;
        this.f1252e = -1.0f;
        this.f1250c = -1.0f;
        this.f1253f = new int[0];
        this.f1249b = false;
    }

    private int e(RectF rectF) {
        int length = this.f1253f.length;
        if (length != 0) {
            int i10 = 0;
            int i11 = 1;
            int i12 = length - 1;
            while (true) {
                int i13 = i11;
                int i14 = i10;
                i10 = i13;
                while (i10 <= i12) {
                    int i15 = (i10 + i12) / 2;
                    if (x(this.f1253f[i15], rectF)) {
                        i11 = i15 + 1;
                    } else {
                        i14 = i15 - 1;
                        i12 = i14;
                    }
                }
                return this.f1253f[i14];
            }
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    private static Method k(@NonNull String str) {
        try {
            Method method = f1246m.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                f1246m.put(str, method);
            }
            return method;
        } catch (Exception unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to retrieve TextView#");
            sb2.append(str);
            sb2.append("() method");
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
        r2 = new java.lang.StringBuilder();
        r2.append("Failed to invoke TextView#");
        r2.append(r3);
        r2.append("() method");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        return r4;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> T m(@androidx.annotation.NonNull java.lang.Object r2, @androidx.annotation.NonNull java.lang.String r3, @androidx.annotation.NonNull T r4) {
        /*
            java.lang.reflect.Method r0 = k(r3)     // Catch:{ Exception -> 0x000e }
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x000e }
            java.lang.Object r4 = r0.invoke(r2, r1)     // Catch:{ Exception -> 0x000e }
            goto L_0x0020
        L_0x000c:
            r2 = move-exception
            goto L_0x0021
        L_0x000e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x000c }
            r2.<init>()     // Catch:{ all -> 0x000c }
            java.lang.String r0 = "Failed to invoke TextView#"
            r2.append(r0)     // Catch:{ all -> 0x000c }
            r2.append(r3)     // Catch:{ all -> 0x000c }
            java.lang.String r3 = "() method"
            r2.append(r3)     // Catch:{ all -> 0x000c }
        L_0x0020:
            return r4
        L_0x0021:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.e0.m(java.lang.Object, java.lang.String, java.lang.Object):java.lang.Object");
    }

    private void s(float f10) {
        if (f10 != this.f1256i.getPaint().getTextSize()) {
            this.f1256i.getPaint().setTextSize(f10);
            boolean a10 = b.a(this.f1256i);
            if (this.f1256i.getLayout() != null) {
                this.f1249b = false;
                try {
                    Method k10 = k("nullLayouts");
                    if (k10 != null) {
                        k10.invoke(this.f1256i, new Object[0]);
                    }
                } catch (Exception unused) {
                }
                if (!a10) {
                    this.f1256i.requestLayout();
                } else {
                    this.f1256i.forceLayout();
                }
                this.f1256i.invalidate();
            }
        }
    }

    private boolean u() {
        if (!y() || this.f1248a != 1) {
            this.f1249b = false;
        } else {
            if (!this.f1254g || this.f1253f.length == 0) {
                int floor = ((int) Math.floor((double) ((this.f1252e - this.f1251d) / this.f1250c))) + 1;
                int[] iArr = new int[floor];
                for (int i10 = 0; i10 < floor; i10++) {
                    iArr[i10] = Math.round(this.f1251d + (((float) i10) * this.f1250c));
                }
                this.f1253f = b(iArr);
            }
            this.f1249b = true;
        }
        return this.f1249b;
    }

    private void v(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i10 = 0; i10 < length; i10++) {
                iArr[i10] = typedArray.getDimensionPixelSize(i10, -1);
            }
            this.f1253f = b(iArr);
            w();
        }
    }

    private boolean w() {
        boolean z10;
        int[] iArr = this.f1253f;
        int length = iArr.length;
        if (length > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f1254g = z10;
        if (z10) {
            this.f1248a = 1;
            this.f1251d = (float) iArr[0];
            this.f1252e = (float) iArr[length - 1];
            this.f1250c = -1.0f;
        }
        return z10;
    }

    private boolean x(int i10, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f1256i.getText();
        TransformationMethod transformationMethod = this.f1256i.getTransformationMethod();
        if (!(transformationMethod == null || (transformation = transformationMethod.getTransformation(text, this.f1256i)) == null)) {
            text = transformation;
        }
        int b10 = a.b(this.f1256i);
        l(i10);
        StaticLayout d10 = d(text, (Layout.Alignment) m(this.f1256i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), b10);
        if ((b10 == -1 || (d10.getLineCount() <= b10 && d10.getLineEnd(d10.getLineCount() - 1) == text.length())) && ((float) d10.getHeight()) <= rectF.bottom) {
            return true;
        }
        return false;
    }

    private boolean y() {
        return !(this.f1256i instanceof i);
    }

    private void z(float f10, float f11, float f12) throws IllegalArgumentException {
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f10 + "px) is less or equal to (0px)");
        } else if (f11 <= f10) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f11 + "px) is less or equal to minimum auto-size text size (" + f10 + "px)");
        } else if (f12 > 0.0f) {
            this.f1248a = 1;
            this.f1251d = f10;
            this.f1252e = f11;
            this.f1250c = f12;
            this.f1254g = false;
        } else {
            throw new IllegalArgumentException("The auto-size step granularity (" + f12 + "px) is less or equal to (0px)");
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        int i10;
        if (n()) {
            if (this.f1249b) {
                if (this.f1256i.getMeasuredHeight() > 0 && this.f1256i.getMeasuredWidth() > 0) {
                    if (this.f1258k.b(this.f1256i)) {
                        i10 = 1048576;
                    } else {
                        i10 = (this.f1256i.getMeasuredWidth() - this.f1256i.getTotalPaddingLeft()) - this.f1256i.getTotalPaddingRight();
                    }
                    int height = (this.f1256i.getHeight() - this.f1256i.getCompoundPaddingBottom()) - this.f1256i.getCompoundPaddingTop();
                    if (i10 > 0 && height > 0) {
                        RectF rectF = f1245l;
                        synchronized (rectF) {
                            rectF.setEmpty();
                            rectF.right = (float) i10;
                            rectF.bottom = (float) height;
                            float e10 = (float) e(rectF);
                            if (e10 != this.f1256i.getTextSize()) {
                                t(0, e10);
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f1249b = true;
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public StaticLayout d(@NonNull CharSequence charSequence, @NonNull Layout.Alignment alignment, int i10, int i11) {
        return c.a(charSequence, alignment, i10, i11, this.f1256i, this.f1255h, this.f1258k);
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return Math.round(this.f1252e);
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return Math.round(this.f1251d);
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return Math.round(this.f1250c);
    }

    /* access modifiers changed from: package-private */
    public int[] i() {
        return this.f1253f;
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return this.f1248a;
    }

    /* access modifiers changed from: package-private */
    public void l(int i10) {
        TextPaint textPaint = this.f1255h;
        if (textPaint == null) {
            this.f1255h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f1255h.set(this.f1256i.getPaint());
        this.f1255h.setTextSize((float) i10);
    }

    /* access modifiers changed from: package-private */
    public boolean n() {
        return y() && this.f1248a != 0;
    }

    /* access modifiers changed from: package-private */
    public void o(AttributeSet attributeSet, int i10) {
        float f10;
        float f11;
        float f12;
        int resourceId;
        Context context = this.f1257j;
        int[] iArr = j.AppCompatTextView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        TextView textView = this.f1256i;
        n0.q0(textView, textView.getContext(), iArr, attributeSet, obtainStyledAttributes, i10, 0);
        int i11 = j.AppCompatTextView_autoSizeTextType;
        if (obtainStyledAttributes.hasValue(i11)) {
            this.f1248a = obtainStyledAttributes.getInt(i11, 0);
        }
        int i12 = j.AppCompatTextView_autoSizeStepGranularity;
        if (obtainStyledAttributes.hasValue(i12)) {
            f10 = obtainStyledAttributes.getDimension(i12, -1.0f);
        } else {
            f10 = -1.0f;
        }
        int i13 = j.AppCompatTextView_autoSizeMinTextSize;
        if (obtainStyledAttributes.hasValue(i13)) {
            f11 = obtainStyledAttributes.getDimension(i13, -1.0f);
        } else {
            f11 = -1.0f;
        }
        int i14 = j.AppCompatTextView_autoSizeMaxTextSize;
        if (obtainStyledAttributes.hasValue(i14)) {
            f12 = obtainStyledAttributes.getDimension(i14, -1.0f);
        } else {
            f12 = -1.0f;
        }
        int i15 = j.AppCompatTextView_autoSizePresetSizes;
        if (obtainStyledAttributes.hasValue(i15) && (resourceId = obtainStyledAttributes.getResourceId(i15, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            v(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (!y()) {
            this.f1248a = 0;
        } else if (this.f1248a == 1) {
            if (!this.f1254g) {
                DisplayMetrics displayMetrics = this.f1257j.getResources().getDisplayMetrics();
                if (f11 == -1.0f) {
                    f11 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (f12 == -1.0f) {
                    f12 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (f10 == -1.0f) {
                    f10 = 1.0f;
                }
                z(f11, f12, f10);
            }
            u();
        }
    }

    /* access modifiers changed from: package-private */
    public void p(int i10, int i11, int i12, int i13) throws IllegalArgumentException {
        if (y()) {
            DisplayMetrics displayMetrics = this.f1257j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(i13, (float) i10, displayMetrics), TypedValue.applyDimension(i13, (float) i11, displayMetrics), TypedValue.applyDimension(i13, (float) i12, displayMetrics));
            if (u()) {
                a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void q(@NonNull int[] iArr, int i10) throws IllegalArgumentException {
        if (y()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i10 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f1257j.getResources().getDisplayMetrics();
                    for (int i11 = 0; i11 < length; i11++) {
                        iArr2[i11] = Math.round(TypedValue.applyDimension(i10, (float) iArr[i11], displayMetrics));
                    }
                }
                this.f1253f = b(iArr2);
                if (!w()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f1254g = false;
            }
            if (u()) {
                a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void r(int i10) {
        if (!y()) {
            return;
        }
        if (i10 == 0) {
            c();
        } else if (i10 == 1) {
            DisplayMetrics displayMetrics = this.f1257j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (u()) {
                a();
            }
        } else {
            throw new IllegalArgumentException("Unknown auto-size text type: " + i10);
        }
    }

    /* access modifiers changed from: package-private */
    public void t(int i10, float f10) {
        Resources resources;
        Context context = this.f1257j;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        s(TypedValue.applyDimension(i10, f10, resources.getDisplayMetrics()));
    }
}
