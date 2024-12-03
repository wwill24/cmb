package androidx.work;

import android.net.Network;
import android.net.Uri;
import androidx.annotation.NonNull;
import b2.c;
import b2.i;
import b2.o;
import i2.b;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

public final class WorkerParameters {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private UUID f7355a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private b f7356b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private Set<String> f7357c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private a f7358d;

    /* renamed from: e  reason: collision with root package name */
    private int f7359e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private Executor f7360f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private b f7361g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private o f7362h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private i f7363i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private c f7364j;

    /* renamed from: k  reason: collision with root package name */
    private int f7365k;

    public static class a {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public List<String> f7366a = Collections.emptyList();
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public List<Uri> f7367b = Collections.emptyList();

        /* renamed from: c  reason: collision with root package name */
        public Network f7368c;
    }

    public WorkerParameters(@NonNull UUID uuid, @NonNull b bVar, @NonNull Collection<String> collection, @NonNull a aVar, int i10, int i11, @NonNull Executor executor, @NonNull b bVar2, @NonNull o oVar, @NonNull i iVar, @NonNull c cVar) {
        this.f7355a = uuid;
        this.f7356b = bVar;
        this.f7357c = new HashSet(collection);
        this.f7358d = aVar;
        this.f7359e = i10;
        this.f7365k = i11;
        this.f7360f = executor;
        this.f7361g = bVar2;
        this.f7362h = oVar;
        this.f7363i = iVar;
        this.f7364j = cVar;
    }

    @NonNull
    public Executor a() {
        return this.f7360f;
    }

    @NonNull
    public c b() {
        return this.f7364j;
    }

    @NonNull
    public UUID c() {
        return this.f7355a;
    }

    @NonNull
    public b d() {
        return this.f7356b;
    }

    @NonNull
    public o e() {
        return this.f7362h;
    }
}
