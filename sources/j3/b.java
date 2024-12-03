package j3;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import j3.d;
import java.io.IOException;

public abstract class b<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f15552a;

    /* renamed from: b  reason: collision with root package name */
    private final AssetManager f15553b;

    /* renamed from: c  reason: collision with root package name */
    private T f15554c;

    public b(AssetManager assetManager, String str) {
        this.f15553b = assetManager;
        this.f15552a = str;
    }

    public void b() {
        T t10 = this.f15554c;
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

    public void d(@NonNull Priority priority, @NonNull d.a<? super T> aVar) {
        try {
            T f10 = f(this.f15553b, this.f15552a);
            this.f15554c = f10;
            aVar.f(f10);
        } catch (IOException e10) {
            Log.isLoggable("AssetPathFetcher", 3);
            aVar.c(e10);
        }
    }

    @NonNull
    public DataSource e() {
        return DataSource.LOCAL;
    }

    /* access modifiers changed from: protected */
    public abstract T f(AssetManager assetManager, String str) throws IOException;
}
