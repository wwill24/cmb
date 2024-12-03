package dh;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.k;
import androidx.lifecycle.v;
import com.google.android.gms.common.api.e;
import com.google.android.gms.tasks.Task;
import java.io.Closeable;
import zg.a;

public interface c extends Closeable, k, e {
    @v(Lifecycle.Event.ON_DESTROY)
    void close();

    @NonNull
    Task<a> i(@NonNull a aVar);
}
