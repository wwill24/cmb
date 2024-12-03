package jf;

import android.content.res.ColorStateList;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.a;
import java.util.Arrays;

public final class b {
    public static Drawable a(Drawable drawable, Drawable drawable2) {
        int i10;
        int i11;
        if (drawable == null) {
            return drawable2;
        }
        if (drawable2 == null) {
            return drawable;
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable, drawable2});
        if (drawable2.getIntrinsicWidth() == -1 || drawable2.getIntrinsicHeight() == -1) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            i10 = drawable.getIntrinsicHeight();
            i11 = intrinsicWidth;
        } else if (drawable2.getIntrinsicWidth() > drawable.getIntrinsicWidth() || drawable2.getIntrinsicHeight() > drawable.getIntrinsicHeight()) {
            float intrinsicWidth2 = ((float) drawable2.getIntrinsicWidth()) / ((float) drawable2.getIntrinsicHeight());
            if (intrinsicWidth2 >= ((float) drawable.getIntrinsicWidth()) / ((float) drawable.getIntrinsicHeight())) {
                i11 = drawable.getIntrinsicWidth();
                i10 = (int) (((float) i11) / intrinsicWidth2);
            } else {
                i10 = drawable.getIntrinsicHeight();
                i11 = (int) (intrinsicWidth2 * ((float) i10));
            }
        } else {
            i11 = drawable2.getIntrinsicWidth();
            i10 = drawable2.getIntrinsicHeight();
        }
        layerDrawable.setLayerSize(1, i11, i10);
        layerDrawable.setLayerGravity(1, 17);
        return layerDrawable;
    }

    public static Drawable b(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode) {
        return c(drawable, colorStateList, mode, false);
    }

    private static Drawable c(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode, boolean z10) {
        if (drawable == null) {
            return null;
        }
        if (colorStateList != null) {
            drawable = a.r(drawable).mutate();
            if (mode != null) {
                a.p(drawable, mode);
            }
        } else if (z10) {
            drawable.mutate();
        }
        return drawable;
    }

    @NonNull
    public static int[] d(@NonNull int[] iArr) {
        for (int i10 = 0; i10 < iArr.length; i10++) {
            int i11 = iArr[i10];
            if (i11 == 16842912) {
                return iArr;
            }
            if (i11 == 0) {
                int[] iArr2 = (int[]) iArr.clone();
                iArr2[i10] = 16842912;
                return iArr2;
            }
        }
        int[] copyOf = Arrays.copyOf(iArr, iArr.length + 1);
        copyOf[iArr.length] = 16842912;
        return copyOf;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003f A[Catch:{ IOException | XmlPullParserException -> 0x0047 }] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0014 A[Catch:{ IOException | XmlPullParserException -> 0x0047 }] */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.AttributeSet e(@androidx.annotation.NonNull android.content.Context r3, int r4, @androidx.annotation.NonNull java.lang.CharSequence r5) {
        /*
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            android.content.res.XmlResourceParser r3 = r3.getXml(r4)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
        L_0x0008:
            int r0 = r3.next()     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            r1 = 2
            if (r0 == r1) goto L_0x0012
            r2 = 1
            if (r0 != r2) goto L_0x0008
        L_0x0012:
            if (r0 != r1) goto L_0x003f
            java.lang.String r0 = r3.getName()     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            boolean r0 = android.text.TextUtils.equals(r0, r5)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            if (r0 == 0) goto L_0x0023
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r3)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            return r3
        L_0x0023:
            org.xmlpull.v1.XmlPullParserException r3 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            r0.<init>()     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            java.lang.String r1 = "Must have a <"
            r0.append(r1)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            r0.append(r5)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            java.lang.String r5 = "> start tag"
            r0.append(r5)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            java.lang.String r5 = r0.toString()     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            r3.<init>(r5)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            throw r3     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
        L_0x003f:
            org.xmlpull.v1.XmlPullParserException r3 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            java.lang.String r5 = "No start tag found"
            r3.<init>(r5)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            throw r3     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
        L_0x0047:
            r3 = move-exception
            goto L_0x004a
        L_0x0049:
            r3 = move-exception
        L_0x004a:
            android.content.res.Resources$NotFoundException r5 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Can't load badge resource ID #0x"
            r0.append(r1)
            java.lang.String r4 = java.lang.Integer.toHexString(r4)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r5.<init>(r4)
            r5.initCause(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: jf.b.e(android.content.Context, int, java.lang.CharSequence):android.util.AttributeSet");
    }

    public static void f(@NonNull Outline outline, @NonNull Path path) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            outline.setPath(path);
        } else if (i10 >= 29) {
            try {
                outline.setConvexPath(path);
            } catch (IllegalArgumentException unused) {
            }
        } else if (path.isConvex()) {
            outline.setConvexPath(path);
        }
    }

    public static void g(@NonNull Drawable drawable, int i10) {
        boolean z10;
        if (i10 != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            a.n(drawable, i10);
        } else {
            a.o(drawable, (ColorStateList) null);
        }
    }

    public static PorterDuffColorFilter h(@NonNull Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
    }
}
