package l4;

import android.content.Context;
import com.clevertap.android.sdk.events.EventGroup;
import java.util.concurrent.Future;
import org.json.b;

public abstract class a {
    public abstract void b(Context context, EventGroup eventGroup);

    public abstract void c(b bVar, boolean z10);

    public abstract void d();

    public abstract Future<?> e(Context context, b bVar, int i10);
}
