package we;

import com.google.android.gms.internal.measurement.zzu;
import com.google.android.gms.measurement.internal.i4;
import com.google.android.gms.measurement.internal.o4;
import java.util.concurrent.Callable;

public final /* synthetic */ class j implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o4 f42119a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f42120b;

    public /* synthetic */ j(o4 o4Var, String str) {
        this.f42119a = o4Var;
        this.f42120b = str;
    }

    public final Object call() {
        return new zzu("internal.appMetadata", new i4(this.f42119a, this.f42120b));
    }
}
