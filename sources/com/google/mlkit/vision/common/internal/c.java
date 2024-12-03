package com.google.mlkit.vision.common.internal;

import com.google.android.gms.tasks.OnFailureListener;

public final /* synthetic */ class c implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ c f21533a = new c();

    private /* synthetic */ c() {
    }

    public final void onFailure(Exception exc) {
        MobileVisionBase.f21515f.d("MobileVisionBase", "Error preloading model resource", exc);
    }
}
