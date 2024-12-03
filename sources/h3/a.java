package h3;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import f4.c;
import f4.j;
import j3.d;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.e;
import okhttp3.f;
import okhttp3.y;
import p3.g;

public class a implements d<InputStream>, f {

    /* renamed from: a  reason: collision with root package name */
    private final e.a f15331a;

    /* renamed from: b  reason: collision with root package name */
    private final g f15332b;

    /* renamed from: c  reason: collision with root package name */
    private InputStream f15333c;

    /* renamed from: d  reason: collision with root package name */
    private b0 f15334d;

    /* renamed from: e  reason: collision with root package name */
    private d.a<? super InputStream> f15335e;

    /* renamed from: f  reason: collision with root package name */
    private volatile e f15336f;

    public a(e.a aVar, g gVar) {
        this.f15331a = aVar;
        this.f15332b = gVar;
    }

    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }

    public void b() {
        try {
            InputStream inputStream = this.f15333c;
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException unused) {
        }
        b0 b0Var = this.f15334d;
        if (b0Var != null) {
            b0Var.close();
        }
        this.f15335e = null;
    }

    public void cancel() {
        e eVar = this.f15336f;
        if (eVar != null) {
            eVar.cancel();
        }
    }

    public void d(@NonNull Priority priority, @NonNull d.a<? super InputStream> aVar) {
        y.a q10 = new y.a().q(this.f15332b.f());
        for (Map.Entry next : this.f15332b.c().entrySet()) {
            q10.a((String) next.getKey(), (String) next.getValue());
        }
        y b10 = q10.b();
        this.f15335e = aVar;
        this.f15336f = this.f15331a.a(b10);
        this.f15336f.P(this);
    }

    @NonNull
    public DataSource e() {
        return DataSource.REMOTE;
    }

    public void onFailure(@NonNull e eVar, @NonNull IOException iOException) {
        Log.isLoggable("OkHttpFetcher", 3);
        this.f15335e.c(iOException);
    }

    public void onResponse(@NonNull e eVar, @NonNull a0 a0Var) {
        this.f15334d = a0Var.a();
        if (a0Var.isSuccessful()) {
            InputStream b10 = c.b(this.f15334d.byteStream(), ((b0) j.d(this.f15334d)).contentLength());
            this.f15333c = b10;
            this.f15335e.f(b10);
            return;
        }
        this.f15335e.c(new HttpException(a0Var.u(), a0Var.f()));
    }
}
