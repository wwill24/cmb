package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.v1;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    private final Object f2713a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, CameraInternal> f2714b = new LinkedHashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Set<CameraInternal> f2715c = new HashSet();

    @NonNull
    public LinkedHashSet<CameraInternal> a() {
        LinkedHashSet<CameraInternal> linkedHashSet;
        synchronized (this.f2713a) {
            linkedHashSet = new LinkedHashSet<>(this.f2714b.values());
        }
        return linkedHashSet;
    }

    public void b(@NonNull w wVar) throws InitializationException {
        synchronized (this.f2713a) {
            try {
                for (String next : wVar.b()) {
                    v1.a("CameraRepository", "Added camera: " + next);
                    this.f2714b.put(next, wVar.a(next));
                }
            } catch (CameraUnavailableException e10) {
                throw new InitializationException(e10);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
