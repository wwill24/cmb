package com.google.mlkit.vision.text.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.mlkit_vision_text_common.zzor;
import com.google.mlkit.common.sdkinternal.d;
import dh.c;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    private final k f21594a;

    /* renamed from: b  reason: collision with root package name */
    private final d f21595b;

    j(@NonNull k kVar, @NonNull d dVar) {
        this.f21594a = kVar;
        this.f21595b = dVar;
    }

    @NonNull
    public final c a(@NonNull dh.d dVar) {
        return new TextRecognizerImpl((b) this.f21594a.get(dVar), this.f21595b.a(dVar.a()), zzor.zzb(dVar.b()), dVar);
    }
}
