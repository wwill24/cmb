package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import f4.j;
import j3.k;
import j3.m;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

interface c {

    public static final class a implements c {

        /* renamed from: a  reason: collision with root package name */
        private final k f9493a;

        /* renamed from: b  reason: collision with root package name */
        private final m3.b f9494b;

        /* renamed from: c  reason: collision with root package name */
        private final List<ImageHeaderParser> f9495c;

        a(InputStream inputStream, List<ImageHeaderParser> list, m3.b bVar) {
            this.f9494b = (m3.b) j.d(bVar);
            this.f9495c = (List) j.d(list);
            this.f9493a = new k(inputStream, bVar);
        }

        public Bitmap a(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeStream(this.f9493a.a(), (Rect) null, options);
        }

        public void b() {
            this.f9493a.c();
        }

        public int c() throws IOException {
            return com.bumptech.glide.load.a.b(this.f9495c, this.f9493a.a(), this.f9494b);
        }

        public ImageHeaderParser.ImageType d() throws IOException {
            return com.bumptech.glide.load.a.e(this.f9495c, this.f9493a.a(), this.f9494b);
        }
    }

    public static final class b implements c {

        /* renamed from: a  reason: collision with root package name */
        private final m3.b f9496a;

        /* renamed from: b  reason: collision with root package name */
        private final List<ImageHeaderParser> f9497b;

        /* renamed from: c  reason: collision with root package name */
        private final m f9498c;

        b(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, m3.b bVar) {
            this.f9496a = (m3.b) j.d(bVar);
            this.f9497b = (List) j.d(list);
            this.f9498c = new m(parcelFileDescriptor);
        }

        public Bitmap a(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeFileDescriptor(this.f9498c.a().getFileDescriptor(), (Rect) null, options);
        }

        public void b() {
        }

        public int c() throws IOException {
            return com.bumptech.glide.load.a.a(this.f9497b, this.f9498c, this.f9496a);
        }

        public ImageHeaderParser.ImageType d() throws IOException {
            return com.bumptech.glide.load.a.d(this.f9497b, this.f9498c, this.f9496a);
        }
    }

    Bitmap a(BitmapFactory.Options options) throws IOException;

    void b();

    int c() throws IOException;

    ImageHeaderParser.ImageType d() throws IOException;
}
