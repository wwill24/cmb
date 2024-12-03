package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import org.xmlpull.v1.XmlPullParser;

public class m {
    public static boolean a(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i10, boolean z10) {
        if (!h(xmlPullParser, str)) {
            return z10;
        }
        return typedArray.getBoolean(i10, z10);
    }

    public static int b(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i10, int i11) {
        if (!h(xmlPullParser, str)) {
            return i11;
        }
        return typedArray.getColor(i10, i11);
    }

    public static ColorStateList c(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, Resources.Theme theme, @NonNull String str, int i10) {
        if (!h(xmlPullParser, str)) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i10, typedValue);
        int i11 = typedValue.type;
        if (i11 == 2) {
            throw new UnsupportedOperationException("Failed to resolve attribute at index " + i10 + ": " + typedValue);
        } else if (i11 < 28 || i11 > 31) {
            return c.d(typedArray.getResources(), typedArray.getResourceId(i10, 0), theme);
        } else {
            return d(typedValue);
        }
    }

    @NonNull
    private static ColorStateList d(@NonNull TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    public static d e(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, Resources.Theme theme, @NonNull String str, int i10, int i11) {
        if (h(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i10, typedValue);
            int i12 = typedValue.type;
            if (i12 >= 28 && i12 <= 31) {
                return d.b(typedValue.data);
            }
            d g10 = d.g(typedArray.getResources(), typedArray.getResourceId(i10, 0), theme);
            if (g10 != null) {
                return g10;
            }
        }
        return d.b(i11);
    }

    public static float f(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i10, float f10) {
        if (!h(xmlPullParser, str)) {
            return f10;
        }
        return typedArray.getFloat(i10, f10);
    }

    public static int g(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i10, int i11) {
        if (!h(xmlPullParser, str)) {
            return i11;
        }
        return typedArray.getInt(i10, i11);
    }

    public static boolean h(@NonNull XmlPullParser xmlPullParser, @NonNull String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    @NonNull
    public static TypedArray i(@NonNull Resources resources, Resources.Theme theme, @NonNull AttributeSet attributeSet, @NonNull int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
