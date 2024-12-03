package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import j3.m;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class a {

    /* renamed from: com.bumptech.glide.load.a$a  reason: collision with other inner class name */
    class C0109a implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InputStream f9236a;

        C0109a(InputStream inputStream) {
            this.f9236a = inputStream;
        }

        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.c(this.f9236a);
            } finally {
                this.f9236a.reset();
            }
        }
    }

    class b implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ByteBuffer f9237a;

        b(ByteBuffer byteBuffer) {
            this.f9237a = byteBuffer;
        }

        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
            return imageHeaderParser.b(this.f9237a);
        }
    }

    class c implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f9238a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ m3.b f9239b;

        c(m mVar, m3.b bVar) {
            this.f9238a = mVar;
            this.f9239b = bVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x002a A[SYNTHETIC, Splitter:B:14:0x002a] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.bumptech.glide.load.ImageHeaderParser.ImageType a(com.bumptech.glide.load.ImageHeaderParser r5) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream r1 = new com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream     // Catch:{ all -> 0x0027 }
                java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0027 }
                j3.m r3 = r4.f9238a     // Catch:{ all -> 0x0027 }
                android.os.ParcelFileDescriptor r3 = r3.a()     // Catch:{ all -> 0x0027 }
                java.io.FileDescriptor r3 = r3.getFileDescriptor()     // Catch:{ all -> 0x0027 }
                r2.<init>(r3)     // Catch:{ all -> 0x0027 }
                m3.b r3 = r4.f9239b     // Catch:{ all -> 0x0027 }
                r1.<init>(r2, r3)     // Catch:{ all -> 0x0027 }
                com.bumptech.glide.load.ImageHeaderParser$ImageType r5 = r5.c(r1)     // Catch:{ all -> 0x0024 }
                r1.close()     // Catch:{ IOException -> 0x001e }
            L_0x001e:
                j3.m r0 = r4.f9238a
                r0.a()
                return r5
            L_0x0024:
                r5 = move-exception
                r0 = r1
                goto L_0x0028
            L_0x0027:
                r5 = move-exception
            L_0x0028:
                if (r0 == 0) goto L_0x002d
                r0.close()     // Catch:{ IOException -> 0x002d }
            L_0x002d:
                j3.m r0 = r4.f9238a
                r0.a()
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.a.c.a(com.bumptech.glide.load.ImageHeaderParser):com.bumptech.glide.load.ImageHeaderParser$ImageType");
        }
    }

    class d implements f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InputStream f9240a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ m3.b f9241b;

        d(InputStream inputStream, m3.b bVar) {
            this.f9240a = inputStream;
            this.f9241b = bVar;
        }

        public int a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.a(this.f9240a, this.f9241b);
            } finally {
                this.f9240a.reset();
            }
        }
    }

    class e implements f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f9242a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ m3.b f9243b;

        e(m mVar, m3.b bVar) {
            this.f9242a = mVar;
            this.f9243b = bVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x002c A[SYNTHETIC, Splitter:B:14:0x002c] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int a(com.bumptech.glide.load.ImageHeaderParser r5) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream r1 = new com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream     // Catch:{ all -> 0x0029 }
                java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0029 }
                j3.m r3 = r4.f9242a     // Catch:{ all -> 0x0029 }
                android.os.ParcelFileDescriptor r3 = r3.a()     // Catch:{ all -> 0x0029 }
                java.io.FileDescriptor r3 = r3.getFileDescriptor()     // Catch:{ all -> 0x0029 }
                r2.<init>(r3)     // Catch:{ all -> 0x0029 }
                m3.b r3 = r4.f9243b     // Catch:{ all -> 0x0029 }
                r1.<init>(r2, r3)     // Catch:{ all -> 0x0029 }
                m3.b r0 = r4.f9243b     // Catch:{ all -> 0x0026 }
                int r5 = r5.a(r1, r0)     // Catch:{ all -> 0x0026 }
                r1.close()     // Catch:{ IOException -> 0x0020 }
            L_0x0020:
                j3.m r0 = r4.f9242a
                r0.a()
                return r5
            L_0x0026:
                r5 = move-exception
                r0 = r1
                goto L_0x002a
            L_0x0029:
                r5 = move-exception
            L_0x002a:
                if (r0 == 0) goto L_0x002f
                r0.close()     // Catch:{ IOException -> 0x002f }
            L_0x002f:
                j3.m r0 = r4.f9242a
                r0.a()
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.a.e.a(com.bumptech.glide.load.ImageHeaderParser):int");
        }
    }

    private interface f {
        int a(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    private interface g {
        ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    public static int a(@NonNull List<ImageHeaderParser> list, @NonNull m mVar, @NonNull m3.b bVar) throws IOException {
        return c(list, new e(mVar, bVar));
    }

    public static int b(@NonNull List<ImageHeaderParser> list, InputStream inputStream, @NonNull m3.b bVar) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return c(list, new d(inputStream, bVar));
    }

    private static int c(@NonNull List<ImageHeaderParser> list, f fVar) throws IOException {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            int a10 = fVar.a(list.get(i10));
            if (a10 != -1) {
                return a10;
            }
        }
        return -1;
    }

    @NonNull
    public static ImageHeaderParser.ImageType d(@NonNull List<ImageHeaderParser> list, @NonNull m mVar, @NonNull m3.b bVar) throws IOException {
        return g(list, new c(mVar, bVar));
    }

    @NonNull
    public static ImageHeaderParser.ImageType e(@NonNull List<ImageHeaderParser> list, InputStream inputStream, @NonNull m3.b bVar) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return g(list, new C0109a(inputStream));
    }

    @NonNull
    public static ImageHeaderParser.ImageType f(@NonNull List<ImageHeaderParser> list, ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        return g(list, new b(byteBuffer));
    }

    @NonNull
    private static ImageHeaderParser.ImageType g(@NonNull List<ImageHeaderParser> list, g gVar) throws IOException {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            ImageHeaderParser.ImageType a10 = gVar.a(list.get(i10));
            if (a10 != ImageHeaderParser.ImageType.UNKNOWN) {
                return a10;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
