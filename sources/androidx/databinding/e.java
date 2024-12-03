package androidx.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.List;

public abstract class e {
    @NonNull
    public List<e> a() {
        return Collections.emptyList();
    }

    public abstract ViewDataBinding b(f fVar, View view, int i10);

    public abstract ViewDataBinding c(f fVar, View[] viewArr, int i10);
}
