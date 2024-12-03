package wf;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.appcompat.view.d;
import bf.b;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f24670a = {16842752, b.theme};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f24671b = {b.materialThemeOverlay};

    private static int a(@NonNull Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f24670a);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        if (resourceId != 0) {
            return resourceId;
        }
        return resourceId2;
    }

    private static int b(@NonNull Context context, AttributeSet attributeSet, int i10, int i11) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f24671b, i10, i11);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    @NonNull
    public static Context c(@NonNull Context context, AttributeSet attributeSet, int i10, int i11) {
        boolean z10;
        int b10 = b(context, attributeSet, i10, i11);
        if (!(context instanceof d) || ((d) context).c() != b10) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (b10 == 0 || z10) {
            return context;
        }
        d dVar = new d(context, b10);
        int a10 = a(context, attributeSet);
        if (a10 != 0) {
            dVar.getTheme().applyStyle(a10, true);
        }
        return dVar;
    }
}
