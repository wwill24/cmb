package j3;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.NonNull;
import j3.e;
import java.io.IOException;

public final class m implements e<ParcelFileDescriptor> {

    /* renamed from: a  reason: collision with root package name */
    private final b f15579a;

    public static final class a implements e.a<ParcelFileDescriptor> {
        @NonNull
        public Class<ParcelFileDescriptor> a() {
            return ParcelFileDescriptor.class;
        }

        @NonNull
        /* renamed from: c */
        public e<ParcelFileDescriptor> b(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
            return new m(parcelFileDescriptor);
        }
    }

    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ParcelFileDescriptor f15580a;

        b(ParcelFileDescriptor parcelFileDescriptor) {
            this.f15580a = parcelFileDescriptor;
        }

        /* access modifiers changed from: package-private */
        public ParcelFileDescriptor a() throws IOException {
            try {
                Os.lseek(this.f15580a.getFileDescriptor(), 0, OsConstants.SEEK_SET);
                return this.f15580a;
            } catch (ErrnoException e10) {
                throw new IOException(e10);
            }
        }
    }

    public m(ParcelFileDescriptor parcelFileDescriptor) {
        this.f15579a = new b(parcelFileDescriptor);
    }

    public static boolean c() {
        return true;
    }

    public void b() {
    }

    @NonNull
    /* renamed from: d */
    public ParcelFileDescriptor a() throws IOException {
        return this.f15579a.a();
    }
}
