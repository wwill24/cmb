package io.sentry;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class v {

    /* renamed from: b  reason: collision with root package name */
    private static final v f31730b = new v();

    /* renamed from: a  reason: collision with root package name */
    private final List<a> f31731a = new CopyOnWriteArrayList();

    @ApiStatus.Internal
    public interface a {
    }

    private v() {
    }

    public static v a() {
        return f31730b;
    }

    public void b(a aVar) {
        this.f31731a.add(aVar);
    }
}
