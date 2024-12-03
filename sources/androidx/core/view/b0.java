package androidx.core.view;

import android.view.MotionEvent;
import androidx.annotation.NonNull;

public final class b0 {
    @Deprecated
    public static int a(MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }

    public static boolean b(@NonNull MotionEvent motionEvent, int i10) {
        return (motionEvent.getSource() & i10) == i10;
    }
}
