package p3;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import i3.e;
import java.io.InputStream;
import p3.n;

public class s<Data> implements n<Integer, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final n<Uri, Data> f16981a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f16982b;

    public static final class a implements o<Integer, AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f16983a;

        public a(Resources resources) {
            this.f16983a = resources;
        }

        public void a() {
        }

        public n<Integer, AssetFileDescriptor> c(r rVar) {
            return new s(this.f16983a, rVar.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    public static class b implements o<Integer, ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f16984a;

        public b(Resources resources) {
            this.f16984a = resources;
        }

        public void a() {
        }

        @NonNull
        public n<Integer, ParcelFileDescriptor> c(r rVar) {
            return new s(this.f16984a, rVar.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static class c implements o<Integer, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f16985a;

        public c(Resources resources) {
            this.f16985a = resources;
        }

        public void a() {
        }

        @NonNull
        public n<Integer, InputStream> c(r rVar) {
            return new s(this.f16985a, rVar.d(Uri.class, InputStream.class));
        }
    }

    public static class d implements o<Integer, Uri> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f16986a;

        public d(Resources resources) {
            this.f16986a = resources;
        }

        public void a() {
        }

        @NonNull
        public n<Integer, Uri> c(r rVar) {
            return new s(this.f16986a, v.c());
        }
    }

    public s(Resources resources, n<Uri, Data> nVar) {
        this.f16982b = resources;
        this.f16981a = nVar;
    }

    private Uri d(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f16982b.getResourcePackageName(num.intValue()) + '/' + this.f16982b.getResourceTypeName(num.intValue()) + '/' + this.f16982b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException unused) {
            if (!Log.isLoggable("ResourceLoader", 5)) {
                return null;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Received invalid resource id: ");
            sb2.append(num);
            return null;
        }
    }

    /* renamed from: c */
    public n.a<Data> b(@NonNull Integer num, int i10, int i11, @NonNull e eVar) {
        Uri d10 = d(num);
        if (d10 == null) {
            return null;
        }
        return this.f16981a.b(d10, i10, i11, eVar);
    }

    /* renamed from: e */
    public boolean a(@NonNull Integer num) {
        return true;
    }
}
