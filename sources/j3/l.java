package j3;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import j3.d;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class l<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f15576a;

    /* renamed from: b  reason: collision with root package name */
    private final ContentResolver f15577b;

    /* renamed from: c  reason: collision with root package name */
    private T f15578c;

    public l(ContentResolver contentResolver, Uri uri) {
        this.f15577b = contentResolver;
        this.f15576a = uri;
    }

    public void b() {
        T t10 = this.f15578c;
        if (t10 != null) {
            try {
                c(t10);
            } catch (IOException unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void c(T t10) throws IOException;

    public void cancel() {
    }

    public final void d(@NonNull Priority priority, @NonNull d.a<? super T> aVar) {
        try {
            T f10 = f(this.f15576a, this.f15577b);
            this.f15578c = f10;
            aVar.f(f10);
        } catch (FileNotFoundException e10) {
            Log.isLoggable("LocalUriFetcher", 3);
            aVar.c(e10);
        }
    }

    @NonNull
    public DataSource e() {
        return DataSource.LOCAL;
    }

    /* access modifiers changed from: protected */
    public abstract T f(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;
}
