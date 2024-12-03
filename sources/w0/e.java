package w0;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.NonNull;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final b f18160a;

    private static final class a implements b {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        final InputContentInfo f18161a;

        a(@NonNull Object obj) {
            this.f18161a = (InputContentInfo) obj;
        }

        @NonNull
        public Object a() {
            return this.f18161a;
        }

        @NonNull
        public Uri b() {
            return this.f18161a.getContentUri();
        }

        public void c() {
            this.f18161a.requestPermission();
        }

        public Uri d() {
            return this.f18161a.getLinkUri();
        }

        @NonNull
        public ClipDescription getDescription() {
            return this.f18161a.getDescription();
        }
    }

    private interface b {
        Object a();

        @NonNull
        Uri b();

        void c();

        Uri d();

        @NonNull
        ClipDescription getDescription();
    }

    private e(@NonNull b bVar) {
        this.f18160a = bVar;
    }

    public static e f(Object obj) {
        if (obj == null) {
            return null;
        }
        return new e(new a(obj));
    }

    @NonNull
    public Uri a() {
        return this.f18160a.b();
    }

    @NonNull
    public ClipDescription b() {
        return this.f18160a.getDescription();
    }

    public Uri c() {
        return this.f18160a.d();
    }

    public void d() {
        this.f18160a.c();
    }

    public Object e() {
        return this.f18160a.a();
    }
}
