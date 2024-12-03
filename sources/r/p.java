package r;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.utils.e;
import java.util.ArrayList;
import java.util.Comparator;
import q.b0;
import q.l;

public class p {

    /* renamed from: b  reason: collision with root package name */
    private static final Size f17227b = new Size(320, 240);

    /* renamed from: c  reason: collision with root package name */
    private static final Comparator<Size> f17228c = new e();

    /* renamed from: a  reason: collision with root package name */
    private final b0 f17229a = ((b0) l.a(b0.class));

    @NonNull
    public Size[] a(@NonNull Size[] sizeArr) {
        if (this.f17229a == null || !b0.b()) {
            return sizeArr;
        }
        ArrayList arrayList = new ArrayList();
        for (Size size : sizeArr) {
            if (f17228c.compare(size, f17227b) >= 0) {
                arrayList.add(size);
            }
        }
        return (Size[]) arrayList.toArray(new Size[0]);
    }
}
