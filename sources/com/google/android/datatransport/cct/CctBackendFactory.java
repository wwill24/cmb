package com.google.android.datatransport.cct;

import androidx.annotation.Keep;
import fd.c;
import fd.f;
import fd.k;

@Keep
public class CctBackendFactory implements c {
    public k create(f fVar) {
        return new d(fVar.b(), fVar.e(), fVar.d());
    }
}
