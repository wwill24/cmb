package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.resource.bitmap.a;
import f4.h;
import i3.e;
import i3.f;
import java.io.IOException;
import java.io.InputStream;
import l3.c;
import m3.b;

public class d implements f<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final a f9499a;

    /* renamed from: b  reason: collision with root package name */
    private final b f9500b;

    static class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        private final RecyclableBufferedInputStream f9501a;

        /* renamed from: b  reason: collision with root package name */
        private final f4.d f9502b;

        a(RecyclableBufferedInputStream recyclableBufferedInputStream, f4.d dVar) {
            this.f9501a = recyclableBufferedInputStream;
            this.f9502b = dVar;
        }

        public void a(m3.d dVar, Bitmap bitmap) throws IOException {
            IOException a10 = this.f9502b.a();
            if (a10 != null) {
                if (bitmap != null) {
                    dVar.c(bitmap);
                }
                throw a10;
            }
        }

        public void b() {
            this.f9501a.b();
        }
    }

    public d(a aVar, b bVar) {
        this.f9499a = aVar;
        this.f9500b = bVar;
    }

    /* renamed from: c */
    public c<Bitmap> a(@NonNull InputStream inputStream, int i10, int i11, @NonNull e eVar) throws IOException {
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        boolean z10;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z10 = false;
        } else {
            z10 = true;
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.f9500b);
        }
        f4.d b10 = f4.d.b(recyclableBufferedInputStream);
        try {
            return this.f9499a.g(new h(b10), i10, i11, eVar, new a(recyclableBufferedInputStream, b10));
        } finally {
            b10.c();
            if (z10) {
                recyclableBufferedInputStream.c();
            }
        }
    }

    /* renamed from: d */
    public boolean b(@NonNull InputStream inputStream, @NonNull e eVar) {
        return this.f9499a.p(inputStream);
    }
}
