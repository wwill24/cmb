package android.view;

import android.annotation.NonNull;
import android.annotation.Nullable;
import android.graphics.Rect;
import java.util.List;

public final /* synthetic */ class DisplayCutout {
    static {
        throw new NoClassDefFoundError();
    }

    @Deprecated
    public /* synthetic */ DisplayCutout(@Nullable Rect rect, @Nullable List<Rect> list) {
    }

    @NonNull
    public native /* synthetic */ List<Rect> getBoundingRects();

    public native /* synthetic */ int getSafeInsetBottom();

    public native /* synthetic */ int getSafeInsetLeft();

    public native /* synthetic */ int getSafeInsetRight();

    public native /* synthetic */ int getSafeInsetTop();

    public native /* synthetic */ int hashCode();
}
