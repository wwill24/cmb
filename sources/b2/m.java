package b2;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.a;
import androidx.work.impl.e0;
import java.util.Collections;
import java.util.List;

@SuppressLint({"AddedAbstractMethod"})
public abstract class m {
    protected m() {
    }

    @NonNull
    public static m c(@NonNull Context context) {
        return e0.j(context);
    }

    public static void d(@NonNull Context context, @NonNull a aVar) {
        e0.d(context, aVar);
    }

    @NonNull
    public final h a(@NonNull n nVar) {
        return b(Collections.singletonList(nVar));
    }

    @NonNull
    public abstract h b(@NonNull List<? extends n> list);
}
