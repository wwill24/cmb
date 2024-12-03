package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import i3.b;
import j3.d;

interface e {

    public interface a {
        void a(b bVar, Exception exc, d<?> dVar, DataSource dataSource);

        void b(b bVar, Object obj, d<?> dVar, DataSource dataSource, b bVar2);

        void c();
    }

    void cancel();

    boolean d();
}
