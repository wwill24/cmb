package a3;

import android.content.Context;
import android.util.Pair;
import androidx.annotation.NonNull;
import c3.f;
import com.airbnb.lottie.h;
import com.airbnb.lottie.i0;
import com.airbnb.lottie.network.FileExtension;
import com.airbnb.lottie.p;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private final f f131a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final e f132b;

    public g(f fVar, @NonNull e eVar) {
        this.f131a = fVar;
        this.f132b = eVar;
    }

    private h a(Context context, @NonNull String str, String str2) {
        f fVar;
        Pair<FileExtension, InputStream> a10;
        i0<h> i0Var;
        if (str2 == null || (fVar = this.f131a) == null || (a10 = fVar.a(str)) == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension) a10.first;
        InputStream inputStream = (InputStream) a10.second;
        if (fileExtension == FileExtension.ZIP) {
            i0Var = p.y(context, new ZipInputStream(inputStream), str2);
        } else {
            i0Var = p.o(inputStream, str2);
        }
        if (i0Var.b() != null) {
            return i0Var.b();
        }
        return null;
    }

    @NonNull
    private i0<h> b(Context context, @NonNull String str, String str2) {
        boolean z10;
        f.a("Fetching " + str);
        c cVar = null;
        try {
            cVar = this.f132b.a(str);
            if (cVar.isSuccessful()) {
                i0<h> d10 = d(context, str, cVar.l0(), cVar.g0(), str2);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Completed fetch from network. Success: ");
                if (d10.b() != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                sb2.append(z10);
                f.a(sb2.toString());
                try {
                    cVar.close();
                } catch (IOException e10) {
                    f.d("LottieFetchResult close failed ", e10);
                }
                return d10;
            }
            i0<h> i0Var = new i0<>((Throwable) new IllegalArgumentException(cVar.j()));
            try {
                cVar.close();
            } catch (IOException e11) {
                f.d("LottieFetchResult close failed ", e11);
            }
            return i0Var;
        } catch (Exception e12) {
            i0<h> i0Var2 = new i0<>((Throwable) e12);
            if (cVar != null) {
                try {
                    cVar.close();
                } catch (IOException e13) {
                    f.d("LottieFetchResult close failed ", e13);
                }
            }
            return i0Var2;
        } catch (Throwable th2) {
            if (cVar != null) {
                try {
                    cVar.close();
                } catch (IOException e14) {
                    f.d("LottieFetchResult close failed ", e14);
                }
            }
            throw th2;
        }
    }

    @NonNull
    private i0<h> d(Context context, @NonNull String str, @NonNull InputStream inputStream, String str2, String str3) throws IOException {
        i0<h> i0Var;
        FileExtension fileExtension;
        f fVar;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (str2.contains("application/zip") || str2.contains("application/x-zip") || str2.contains("application/x-zip-compressed") || str.split("\\?")[0].endsWith(".lottie")) {
            f.a("Handling zip response.");
            FileExtension fileExtension2 = FileExtension.ZIP;
            i0Var = f(context, str, inputStream, str3);
            fileExtension = fileExtension2;
        } else {
            f.a("Received json response.");
            fileExtension = FileExtension.JSON;
            i0Var = e(str, inputStream, str3);
        }
        if (!(str3 == null || i0Var.b() == null || (fVar = this.f131a) == null)) {
            fVar.e(str, fileExtension);
        }
        return i0Var;
    }

    @NonNull
    private i0<h> e(@NonNull String str, @NonNull InputStream inputStream, String str2) throws IOException {
        f fVar;
        if (str2 == null || (fVar = this.f131a) == null) {
            return p.o(inputStream, (String) null);
        }
        return p.o(new FileInputStream(fVar.f(str, inputStream, FileExtension.JSON).getAbsolutePath()), str);
    }

    @NonNull
    private i0<h> f(Context context, @NonNull String str, @NonNull InputStream inputStream, String str2) throws IOException {
        f fVar;
        if (str2 == null || (fVar = this.f131a) == null) {
            return p.y(context, new ZipInputStream(inputStream), (String) null);
        }
        return p.y(context, new ZipInputStream(new FileInputStream(fVar.f(str, inputStream, FileExtension.ZIP))), str);
    }

    @NonNull
    public i0<h> c(Context context, @NonNull String str, String str2) {
        h a10 = a(context, str, str2);
        if (a10 != null) {
            return new i0<>(a10);
        }
        f.a("Animation for " + str + " not found in cache. Fetching from network.");
        return b(context, str, str2);
    }
}
