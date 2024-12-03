package u1;

import android.annotation.SuppressLint;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0007B!\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0011¨\u0006\u0019"}, d2 = {"Lu1/a;", "", "", "processLock", "", "b", "d", "a", "Z", "Ljava/io/File;", "Ljava/io/File;", "lockFile", "Ljava/util/concurrent/locks/Lock;", "c", "Ljava/util/concurrent/locks/Lock;", "threadLock", "Ljava/nio/channels/FileChannel;", "Ljava/nio/channels/FileChannel;", "lockChannel", "", "name", "lockDir", "<init>", "(Ljava/lang/String;Ljava/io/File;Z)V", "e", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1})
public final class a {

    /* renamed from: e  reason: collision with root package name */
    public static final C0210a f17943e = new C0210a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final Map<String, Lock> f17944f = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f17945a;

    /* renamed from: b  reason: collision with root package name */
    private final File f17946b;
    @SuppressLint({"SyntheticAccessor"})

    /* renamed from: c  reason: collision with root package name */
    private final Lock f17947c;

    /* renamed from: d  reason: collision with root package name */
    private FileChannel f17948d;

    @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lu1/a$a;", "", "", "key", "Ljava/util/concurrent/locks/Lock;", "b", "TAG", "Ljava/lang/String;", "", "threadLocksMap", "Ljava/util/Map;", "<init>", "()V", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: u1.a$a  reason: collision with other inner class name */
    public static final class C0210a {
        private C0210a() {
        }

        public /* synthetic */ C0210a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final Lock b(String str) {
            Lock lock;
            synchronized (a.f17944f) {
                Map a10 = a.f17944f;
                Object obj = a10.get(str);
                if (obj == null) {
                    obj = new ReentrantLock();
                    a10.put(str, obj);
                }
                lock = (Lock) obj;
            }
            return lock;
        }
    }

    public a(String str, File file, boolean z10) {
        File file2;
        j.g(str, "name");
        this.f17945a = z10;
        if (file != null) {
            file2 = new File(file, str + ".lck");
        } else {
            file2 = null;
        }
        this.f17946b = file2;
        this.f17947c = f17943e.b(str);
    }

    public static /* synthetic */ void c(a aVar, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = aVar.f17945a;
        }
        aVar.b(z10);
    }

    public final void b(boolean z10) {
        this.f17947c.lock();
        if (z10) {
            try {
                File file = this.f17946b;
                if (file != null) {
                    File parentFile = file.getParentFile();
                    if (parentFile != null) {
                        parentFile.mkdirs();
                    }
                    FileChannel channel = new FileOutputStream(this.f17946b).getChannel();
                    channel.lock();
                    this.f17948d = channel;
                    return;
                }
                throw new IOException("No lock directory was provided.");
            } catch (IOException unused) {
                this.f17948d = null;
            }
        }
    }

    public final void d() {
        try {
            FileChannel fileChannel = this.f17948d;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (IOException unused) {
        }
        this.f17947c.unlock();
    }
}
