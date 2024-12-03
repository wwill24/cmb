package androidx.work.impl;

import android.content.Context;
import com.mparticle.identity.IdentityHttpResponse;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\b"}, d2 = {"Landroidx/work/impl/a;", "", "Landroid/content/Context;", "context", "Ljava/io/File;", "a", "<init>", "()V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f7416a = new a();

    private a() {
    }

    public final File a(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        File noBackupFilesDir = context.getNoBackupFilesDir();
        j.f(noBackupFilesDir, "context.noBackupFilesDir");
        return noBackupFilesDir;
    }
}
