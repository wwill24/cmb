package n3;

import java.io.File;
import n3.a;

public class d implements a.C0176a {

    /* renamed from: a  reason: collision with root package name */
    private final long f16393a;

    /* renamed from: b  reason: collision with root package name */
    private final a f16394b;

    public interface a {
        File a();
    }

    public d(a aVar, long j10) {
        this.f16393a = j10;
        this.f16394b = aVar;
    }

    public a build() {
        File a10 = this.f16394b.a();
        if (a10 == null) {
            return null;
        }
        if (a10.mkdirs() || (a10.exists() && a10.isDirectory())) {
            return e.c(a10, this.f16393a);
        }
        return null;
    }
}
