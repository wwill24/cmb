package androidx.room;

import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import t1.j;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B3\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u0006\u0010\u0014\u001a\u00020\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0016\u0010\f\u001a\u0004\u0018\u00010\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Landroidx/room/n0;", "Lt1/j$c;", "Lt1/j$b;", "configuration", "Lt1/j;", "a", "", "Ljava/lang/String;", "mCopyFromAssetPath", "Ljava/io/File;", "b", "Ljava/io/File;", "mCopyFromFile", "Ljava/util/concurrent/Callable;", "Ljava/io/InputStream;", "c", "Ljava/util/concurrent/Callable;", "mCopyFromInputStream", "d", "Lt1/j$c;", "mDelegate", "<init>", "(Ljava/lang/String;Ljava/io/File;Ljava/util/concurrent/Callable;Lt1/j$c;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class n0 implements j.c {

    /* renamed from: a  reason: collision with root package name */
    private final String f6927a;

    /* renamed from: b  reason: collision with root package name */
    private final File f6928b;

    /* renamed from: c  reason: collision with root package name */
    private final Callable<InputStream> f6929c;

    /* renamed from: d  reason: collision with root package name */
    private final j.c f6930d;

    public n0(String str, File file, Callable<InputStream> callable, j.c cVar) {
        kotlin.jvm.internal.j.g(cVar, "mDelegate");
        this.f6927a = str;
        this.f6928b = file;
        this.f6929c = callable;
        this.f6930d = cVar;
    }

    public j a(j.b bVar) {
        kotlin.jvm.internal.j.g(bVar, "configuration");
        return new m0(bVar.f17637a, this.f6927a, this.f6928b, this.f6929c, bVar.f17639c.f17635a, this.f6930d.a(bVar));
    }
}
