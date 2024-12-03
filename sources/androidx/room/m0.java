package androidx.room;

import android.content.Context;
import com.mparticle.identity.IdentityHttpResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import net.bytebuddy.implementation.MethodDelegation;
import q1.b;
import q1.c;
import t1.i;
import t1.j;
import u1.a;

@Metadata(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002BC\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b\u0012\u0006\u0010\"\u001a\u00020 \u0012\u0006\u0010%\u001a\u00020\u0001¢\u0006\u0004\b2\u00103J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0003H\u0017J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fR\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0017R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0019R\u001c\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010!R\u001a\u0010%\u001a\u00020\u00018\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010#\u001a\u0004\b\u0013\u0010$R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u0004\u0018\u00010\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8VX\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00064"}, d2 = {"Landroidx/room/m0;", "Lt1/j;", "Landroidx/room/f;", "", "writable", "", "f", "Ljava/io/File;", "destinationFile", "b", "databaseFile", "c", "enabled", "setWriteAheadLoggingEnabled", "close", "Landroidx/room/e;", "databaseConfiguration", "e", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "", "Ljava/lang/String;", "copyFromAssetPath", "Ljava/io/File;", "copyFromFile", "Ljava/util/concurrent/Callable;", "Ljava/io/InputStream;", "d", "Ljava/util/concurrent/Callable;", "copyFromInputStream", "", "I", "databaseVersion", "Lt1/j;", "()Lt1/j;", "delegate", "g", "Landroidx/room/e;", "h", "Z", "verified", "getDatabaseName", "()Ljava/lang/String;", "databaseName", "Lt1/i;", "n1", "()Lt1/i;", "writableDatabase", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;Ljava/util/concurrent/Callable;ILt1/j;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class m0 implements j, f {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6918a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6919b;

    /* renamed from: c  reason: collision with root package name */
    private final File f6920c;

    /* renamed from: d  reason: collision with root package name */
    private final Callable<InputStream> f6921d;

    /* renamed from: e  reason: collision with root package name */
    private final int f6922e;

    /* renamed from: f  reason: collision with root package name */
    private final j f6923f;

    /* renamed from: g  reason: collision with root package name */
    private e f6924g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f6925h;

    public m0(Context context, String str, File file, Callable<InputStream> callable, int i10, j jVar) {
        kotlin.jvm.internal.j.g(context, IdentityHttpResponse.CONTEXT);
        kotlin.jvm.internal.j.g(jVar, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        this.f6918a = context;
        this.f6919b = str;
        this.f6920c = file;
        this.f6921d = callable;
        this.f6922e = i10;
        this.f6923f = jVar;
    }

    private final void b(File file, boolean z10) throws IOException {
        ReadableByteChannel readableByteChannel;
        if (this.f6919b != null) {
            readableByteChannel = Channels.newChannel(this.f6918a.getAssets().open(this.f6919b));
            kotlin.jvm.internal.j.f(readableByteChannel, "newChannel(context.assets.open(copyFromAssetPath))");
        } else if (this.f6920c != null) {
            readableByteChannel = new FileInputStream(this.f6920c).getChannel();
            kotlin.jvm.internal.j.f(readableByteChannel, "FileInputStream(copyFromFile).channel");
        } else {
            Callable<InputStream> callable = this.f6921d;
            if (callable != null) {
                try {
                    readableByteChannel = Channels.newChannel(callable.call());
                    kotlin.jvm.internal.j.f(readableByteChannel, "newChannel(inputStream)");
                } catch (Exception e10) {
                    throw new IOException("inputStreamCallable exception on call", e10);
                }
            } else {
                throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
            }
        }
        File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.f6918a.getCacheDir());
        createTempFile.deleteOnExit();
        FileChannel channel = new FileOutputStream(createTempFile).getChannel();
        kotlin.jvm.internal.j.f(channel, "output");
        c.a(readableByteChannel, channel);
        File parentFile = file.getParentFile();
        if (parentFile == null || parentFile.exists() || parentFile.mkdirs()) {
            kotlin.jvm.internal.j.f(createTempFile, "intermediateFile");
            c(createTempFile, z10);
            if (!createTempFile.renameTo(file)) {
                throw new IOException("Failed to move intermediate file (" + createTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
            }
            return;
        }
        throw new IOException("Failed to create directories for " + file.getAbsolutePath());
    }

    private final void c(File file, boolean z10) {
        e eVar = this.f6924g;
        if (eVar == null) {
            kotlin.jvm.internal.j.y("databaseConfiguration");
            eVar = null;
        }
        eVar.getClass();
    }

    private final void f(boolean z10) {
        String databaseName = getDatabaseName();
        if (databaseName != null) {
            File databasePath = this.f6918a.getDatabasePath(databaseName);
            e eVar = this.f6924g;
            e eVar2 = null;
            if (eVar == null) {
                kotlin.jvm.internal.j.y("databaseConfiguration");
                eVar = null;
            }
            a aVar = new a(databaseName, this.f6918a.getFilesDir(), eVar.f6847s);
            try {
                a.c(aVar, false, 1, (Object) null);
                if (!databasePath.exists()) {
                    kotlin.jvm.internal.j.f(databasePath, "databaseFile");
                    b(databasePath, z10);
                    aVar.d();
                    return;
                }
                try {
                    kotlin.jvm.internal.j.f(databasePath, "databaseFile");
                    int c10 = b.c(databasePath);
                    if (c10 == this.f6922e) {
                        aVar.d();
                        return;
                    }
                    e eVar3 = this.f6924g;
                    if (eVar3 == null) {
                        kotlin.jvm.internal.j.y("databaseConfiguration");
                    } else {
                        eVar2 = eVar3;
                    }
                    if (eVar2.a(c10, this.f6922e)) {
                        aVar.d();
                        return;
                    }
                    if (this.f6918a.deleteDatabase(databaseName)) {
                        try {
                            b(databasePath, z10);
                        } catch (IOException unused) {
                        }
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Failed to delete database file (");
                        sb2.append(databaseName);
                        sb2.append(") for a copy destructive migration.");
                    }
                    aVar.d();
                } catch (IOException unused2) {
                    aVar.d();
                }
            } catch (IOException e10) {
                throw new RuntimeException("Unable to copy database file.", e10);
            } catch (Throwable th2) {
                aVar.d();
                throw th2;
            }
        } else {
            throw new IllegalStateException("Required value was null.".toString());
        }
    }

    public j a() {
        return this.f6923f;
    }

    public synchronized void close() {
        a().close();
        this.f6925h = false;
    }

    public final void e(e eVar) {
        kotlin.jvm.internal.j.g(eVar, "databaseConfiguration");
        this.f6924g = eVar;
    }

    public String getDatabaseName() {
        return a().getDatabaseName();
    }

    public i n1() {
        if (!this.f6925h) {
            f(true);
            this.f6925h = true;
        }
        return a().n1();
    }

    public void setWriteAheadLoggingEnabled(boolean z10) {
        a().setWriteAheadLoggingEnabled(z10);
    }
}
