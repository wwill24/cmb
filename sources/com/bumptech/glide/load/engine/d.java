package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import i3.e;
import java.io.File;
import n3.a;

class d<DataType> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    private final i3.a<DataType> f9313a;

    /* renamed from: b  reason: collision with root package name */
    private final DataType f9314b;

    /* renamed from: c  reason: collision with root package name */
    private final e f9315c;

    d(i3.a<DataType> aVar, DataType datatype, e eVar) {
        this.f9313a = aVar;
        this.f9314b = datatype;
        this.f9315c = eVar;
    }

    public boolean a(@NonNull File file) {
        return this.f9313a.a(this.f9314b, file, this.f9315c);
    }
}
