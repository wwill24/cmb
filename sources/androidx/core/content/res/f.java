package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import t0.d;

final class f {
    private static a a(a aVar, int i10, int i11, boolean z10, int i12) {
        if (aVar != null) {
            return aVar;
        }
        if (z10) {
            return new a(i10, i12, i11);
        }
        return new a(i10, i11);
    }

    static Shader b(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        String name = xmlPullParser.getName();
        if (name.equals("gradient")) {
            Resources.Theme theme2 = theme;
            TypedArray i10 = m.i(resources, theme2, attributeSet, d.GradientColor);
            float f10 = m.f(i10, xmlPullParser2, "startX", d.GradientColor_android_startX, 0.0f);
            float f11 = m.f(i10, xmlPullParser2, "startY", d.GradientColor_android_startY, 0.0f);
            float f12 = m.f(i10, xmlPullParser2, "endX", d.GradientColor_android_endX, 0.0f);
            float f13 = m.f(i10, xmlPullParser2, "endY", d.GradientColor_android_endY, 0.0f);
            float f14 = m.f(i10, xmlPullParser2, "centerX", d.GradientColor_android_centerX, 0.0f);
            float f15 = m.f(i10, xmlPullParser2, "centerY", d.GradientColor_android_centerY, 0.0f);
            int g10 = m.g(i10, xmlPullParser2, "type", d.GradientColor_android_type, 0);
            int b10 = m.b(i10, xmlPullParser2, "startColor", d.GradientColor_android_startColor, 0);
            boolean h10 = m.h(xmlPullParser2, "centerColor");
            int b11 = m.b(i10, xmlPullParser2, "centerColor", d.GradientColor_android_centerColor, 0);
            int b12 = m.b(i10, xmlPullParser2, "endColor", d.GradientColor_android_endColor, 0);
            int g11 = m.g(i10, xmlPullParser2, "tileMode", d.GradientColor_android_tileMode, 0);
            float f16 = f14;
            float f17 = m.f(i10, xmlPullParser2, "gradientRadius", d.GradientColor_android_gradientRadius, 0.0f);
            i10.recycle();
            a a10 = a(c(resources, xmlPullParser, attributeSet, theme), b10, b12, h10, b11);
            if (g10 == 1) {
                float f18 = f16;
                if (f17 > 0.0f) {
                    int[] iArr = a10.f4558a;
                    return new RadialGradient(f18, f15, f17, iArr, a10.f4559b, d(g11));
                }
                throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
            } else if (g10 != 2) {
                return new LinearGradient(f10, f11, f12, f13, a10.f4558a, a10.f4559b, d(g11));
            } else {
                return new SweepGradient(f16, f15, a10.f4558a, a10.f4559b);
            }
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0080, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r10.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.core.content.res.f.a c(@androidx.annotation.NonNull android.content.res.Resources r9, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser r10, @androidx.annotation.NonNull android.util.AttributeSet r11, android.content.res.Resources.Theme r12) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            int r0 = r10.getDepth()
            r1 = 1
            int r0 = r0 + r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 20
            r2.<init>(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
        L_0x0012:
            int r3 = r10.next()
            if (r3 == r1) goto L_0x0081
            int r5 = r10.getDepth()
            if (r5 >= r0) goto L_0x0021
            r6 = 3
            if (r3 == r6) goto L_0x0081
        L_0x0021:
            r6 = 2
            if (r3 == r6) goto L_0x0025
            goto L_0x0012
        L_0x0025:
            if (r5 > r0) goto L_0x0012
            java.lang.String r3 = r10.getName()
            java.lang.String r5 = "item"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x0034
            goto L_0x0012
        L_0x0034:
            int[] r3 = t0.d.GradientColorItem
            android.content.res.TypedArray r3 = androidx.core.content.res.m.i(r9, r12, r11, r3)
            int r5 = t0.d.GradientColorItem_android_color
            boolean r6 = r3.hasValue(r5)
            int r7 = t0.d.GradientColorItem_android_offset
            boolean r8 = r3.hasValue(r7)
            if (r6 == 0) goto L_0x0066
            if (r8 == 0) goto L_0x0066
            r6 = 0
            int r5 = r3.getColor(r5, r6)
            r6 = 0
            float r6 = r3.getFloat(r7, r6)
            r3.recycle()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r4.add(r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r6)
            r2.add(r3)
            goto L_0x0012
        L_0x0066:
            org.xmlpull.v1.XmlPullParserException r9 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r10 = r10.getPositionDescription()
            r11.append(r10)
            java.lang.String r10 = ": <item> tag requires a 'color' attribute and a 'offset' attribute!"
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            r9.<init>(r10)
            throw r9
        L_0x0081:
            int r9 = r4.size()
            if (r9 <= 0) goto L_0x008d
            androidx.core.content.res.f$a r9 = new androidx.core.content.res.f$a
            r9.<init>((java.util.List<java.lang.Integer>) r4, (java.util.List<java.lang.Float>) r2)
            return r9
        L_0x008d:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.f.c(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):androidx.core.content.res.f$a");
    }

    private static Shader.TileMode d(int i10) {
        if (i10 == 1) {
            return Shader.TileMode.REPEAT;
        }
        if (i10 != 2) {
            return Shader.TileMode.CLAMP;
        }
        return Shader.TileMode.MIRROR;
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final int[] f4558a;

        /* renamed from: b  reason: collision with root package name */
        final float[] f4559b;

        a(@NonNull List<Integer> list, @NonNull List<Float> list2) {
            int size = list.size();
            this.f4558a = new int[size];
            this.f4559b = new float[size];
            for (int i10 = 0; i10 < size; i10++) {
                this.f4558a[i10] = list.get(i10).intValue();
                this.f4559b[i10] = list2.get(i10).floatValue();
            }
        }

        a(int i10, int i11) {
            this.f4558a = new int[]{i10, i11};
            this.f4559b = new float[]{0.0f, 1.0f};
        }

        a(int i10, int i11, int i12) {
            this.f4558a = new int[]{i10, i11, i12};
            this.f4559b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
