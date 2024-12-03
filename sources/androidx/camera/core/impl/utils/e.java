package androidx.camera.core.impl.utils;

import android.util.Size;
import androidx.annotation.NonNull;
import java.util.Comparator;

public final class e implements Comparator<Size> {

    /* renamed from: a  reason: collision with root package name */
    private boolean f2621a;

    public e() {
        this(false);
    }

    /* renamed from: a */
    public int compare(@NonNull Size size, @NonNull Size size2) {
        int signum = Long.signum((((long) size.getWidth()) * ((long) size.getHeight())) - (((long) size2.getWidth()) * ((long) size2.getHeight())));
        if (this.f2621a) {
            return signum * -1;
        }
        return signum;
    }

    public e(boolean z10) {
        this.f2621a = z10;
    }
}
