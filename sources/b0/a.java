package b0;

import android.location.Location;
import androidx.annotation.NonNull;
import b0.c;
import java.io.File;

final class a extends c.b {

    /* renamed from: a  reason: collision with root package name */
    private final long f7674a;

    /* renamed from: b  reason: collision with root package name */
    private final Location f7675b;

    /* renamed from: c  reason: collision with root package name */
    private final File f7676c;

    static final class b extends c.b.a {

        /* renamed from: a  reason: collision with root package name */
        private Long f7677a;

        /* renamed from: b  reason: collision with root package name */
        private Location f7678b;

        /* renamed from: c  reason: collision with root package name */
        private File f7679c;

        b() {
        }

        /* access modifiers changed from: package-private */
        public c.b b() {
            String str = "";
            if (this.f7677a == null) {
                str = str + " fileSizeLimit";
            }
            if (this.f7679c == null) {
                str = str + " file";
            }
            if (str.isEmpty()) {
                return new a(this.f7677a.longValue(), this.f7678b, this.f7679c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* access modifiers changed from: package-private */
        public c.b.a c(File file) {
            if (file != null) {
                this.f7679c = file;
                return this;
            }
            throw new NullPointerException("Null file");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public c.b.a a(long j10) {
            this.f7677a = Long.valueOf(j10);
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    public long a() {
        return this.f7674a;
    }

    /* access modifiers changed from: package-private */
    public Location b() {
        return this.f7675b;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public File c() {
        return this.f7676c;
    }

    public boolean equals(Object obj) {
        Location location;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c.b)) {
            return false;
        }
        c.b bVar = (c.b) obj;
        if (this.f7674a != bVar.a() || ((location = this.f7675b) != null ? !location.equals(bVar.b()) : bVar.b() != null) || !this.f7676c.equals(bVar.c())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i10;
        long j10 = this.f7674a;
        int i11 = (((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003;
        Location location = this.f7675b;
        if (location == null) {
            i10 = 0;
        } else {
            i10 = location.hashCode();
        }
        return ((i11 ^ i10) * 1000003) ^ this.f7676c.hashCode();
    }

    public String toString() {
        return "FileOutputOptionsInternal{fileSizeLimit=" + this.f7674a + ", location=" + this.f7675b + ", file=" + this.f7676c + "}";
    }

    private a(long j10, Location location, File file) {
        this.f7674a = j10;
        this.f7675b = location;
        this.f7676c = file;
    }
}
