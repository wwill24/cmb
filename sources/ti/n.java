package ti;

import android.content.Context;
import android.util.TypedValue;
import com.withpersona.sdk2.inquiry.shared.ResourceType;
import kotlin.jvm.internal.j;

public final class n {
    public static final boolean a(Context context, int i10, TypedValue typedValue, boolean z10) {
        j.g(context, "<this>");
        j.g(typedValue, "typedValue");
        context.getTheme().resolveAttribute(i10, typedValue, z10);
        if (typedValue.type != 18 || typedValue.data == 0) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean b(Context context, int i10, TypedValue typedValue, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            typedValue = new TypedValue();
        }
        if ((i11 & 4) != 0) {
            z10 = true;
        }
        return a(context, i10, typedValue, z10);
    }

    public static final int c(Context context, int i10, TypedValue typedValue, boolean z10) {
        j.g(context, "<this>");
        j.g(typedValue, "typedValue");
        context.getTheme().resolveAttribute(i10, typedValue, z10);
        return typedValue.data;
    }

    public static /* synthetic */ int d(Context context, int i10, TypedValue typedValue, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            typedValue = new TypedValue();
        }
        if ((i11 & 4) != 0) {
            z10 = true;
        }
        return c(context, i10, typedValue, z10);
    }

    public static final Integer e(Context context, int i10, TypedValue typedValue, boolean z10) {
        j.g(context, "<this>");
        j.g(typedValue, "typedValue");
        context.getTheme().resolveAttribute(i10, typedValue, z10);
        if (typedValue.type == 0) {
            return null;
        }
        return Integer.valueOf(typedValue.resourceId);
    }

    public static /* synthetic */ Integer f(Context context, int i10, TypedValue typedValue, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            typedValue = new TypedValue();
        }
        if ((i11 & 4) != 0) {
            z10 = true;
        }
        return e(context, i10, typedValue, z10);
    }

    public static final Integer g(Context context, String str, ResourceType resourceType) {
        j.g(context, "<this>");
        j.g(str, "resourceName");
        j.g(resourceType, "resourceType");
        int identifier = context.getResources().getIdentifier(b.b(str), resourceType.name(), context.getResources().getResourcePackageName(h.pi2_dummy_package_resource));
        if (identifier > 0) {
            return Integer.valueOf(identifier);
        }
        return null;
    }
}
