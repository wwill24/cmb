package b0;

import android.graphics.Rect;
import android.util.Size;
import androidx.camera.video.g0;
import java.util.Comparator;

public final /* synthetic */ class x implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Rect f7721a;

    public /* synthetic */ x(Rect rect) {
        this.f7721a = rect;
    }

    public final int compare(Object obj, Object obj2) {
        return g0.o0(this.f7721a, (Size) obj, (Size) obj2);
    }
}
