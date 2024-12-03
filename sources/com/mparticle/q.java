package com.mparticle;

import com.mparticle.internal.d;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\t¨\u0006\r"}, d2 = {"Lcom/mparticle/q;", "Lcom/mparticle/Configuration;", "Lcom/mparticle/internal/d;", "Ljava/lang/Class;", "configures", "kitFrameworkWrapper", "", "a", "Lcom/mparticle/p;", "Lcom/mparticle/p;", "kitsLoadedListener", "<init>", "(Lcom/mparticle/p;)V", "android-core_release"}, k = 1, mv = {1, 7, 1})
public final class q implements Configuration<d> {

    /* renamed from: a  reason: collision with root package name */
    private p f22632a;

    public q(p pVar) {
        j.g(pVar, "kitsLoadedListener");
        this.f22632a = pVar;
    }

    /* renamed from: a */
    public void apply(d dVar) {
        j.g(dVar, "kitFrameworkWrapper");
        dVar.a(this.f22632a);
    }

    public Class<d> configures() {
        return d.class;
    }
}
