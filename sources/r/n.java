package r;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.SurfaceConfig;
import java.util.ArrayList;
import java.util.List;
import q.l;
import q.o;

public class n {

    /* renamed from: a  reason: collision with root package name */
    private final o f17225a;

    public n() {
        this((o) l.a(o.class));
    }

    @NonNull
    public List<Size> a(@NonNull SurfaceConfig.ConfigType configType, @NonNull List<Size> list) {
        Size b10;
        o oVar = this.f17225a;
        if (oVar == null || (b10 = oVar.b(configType)) == null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(b10);
        for (Size next : list) {
            if (!next.equals(b10)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    n(o oVar) {
        this.f17225a = oVar;
    }
}
