package com.bumptech.glide.integration.okhttp3;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.Registry;
import com.bumptech.glide.c;
import com.bumptech.glide.d;
import com.bumptech.glide.integration.okhttp3.b;
import java.io.InputStream;
import p3.g;
import z3.b;

@Deprecated
public class OkHttpGlideModule implements b {
    public void a(@NonNull Context context, @NonNull d dVar) {
    }

    public void b(Context context, c cVar, Registry registry) {
        registry.r(g.class, InputStream.class, new b.a());
    }
}
