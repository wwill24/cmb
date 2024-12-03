package bh;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.k;
import androidx.lifecycle.v;
import com.google.android.gms.common.api.e;
import com.google.android.gms.tasks.Task;
import java.io.Closeable;
import java.util.List;
import zg.a;

public interface d extends Closeable, k, e {
    @v(Lifecycle.Event.ON_DESTROY)
    void close();

    @NonNull
    Task<List<a>> i(@NonNull a aVar);
}
