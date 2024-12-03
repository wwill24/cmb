package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.PointerIcon;
import androidx.annotation.NonNull;

public final class l0 {

    /* renamed from: a  reason: collision with root package name */
    private final PointerIcon f4874a;

    static class a {
        static PointerIcon a(Bitmap bitmap, float f10, float f11) {
            return PointerIcon.create(bitmap, f10, f11);
        }

        static PointerIcon b(Context context, int i10) {
            return PointerIcon.getSystemIcon(context, i10);
        }

        static PointerIcon c(Resources resources, int i10) {
            return PointerIcon.load(resources, i10);
        }
    }

    private l0(PointerIcon pointerIcon) {
        this.f4874a = pointerIcon;
    }

    @NonNull
    public static l0 b(@NonNull Context context, int i10) {
        return new l0(a.b(context, i10));
    }

    public Object a() {
        return this.f4874a;
    }
}
