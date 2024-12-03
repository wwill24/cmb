package n3;

import android.content.Context;
import java.io.File;
import n3.d;

public final class f extends d {

    class a implements d.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f16400a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f16401b;

        a(Context context, String str) {
            this.f16400a = context;
            this.f16401b = str;
        }

        public File a() {
            File cacheDir = this.f16400a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            if (this.f16401b != null) {
                return new File(cacheDir, this.f16401b);
            }
            return cacheDir;
        }
    }

    public f(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public f(Context context, String str, long j10) {
        super(new a(context, str), j10);
    }
}
