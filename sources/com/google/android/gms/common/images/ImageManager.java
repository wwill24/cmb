package com.google.android.gms.common.images;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.base.zam;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public final class ImageManager {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Object f38904a = new Object();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static HashSet f38905b = new HashSet();

    @KeepName
    private final class ImageReceiver extends ResultReceiver {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f38906a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final ArrayList f38907b;

        public final void onReceiveResult(int i10, Bundle bundle) {
            ImageManager.i((ImageManager) null).execute(new a((ImageManager) null, this.f38906a, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    static /* bridge */ /* synthetic */ Context a(ImageManager imageManager) {
        throw null;
    }

    static /* bridge */ /* synthetic */ Handler b(ImageManager imageManager) {
        throw null;
    }

    static /* bridge */ /* synthetic */ zam c(ImageManager imageManager) {
        throw null;
    }

    static /* bridge */ /* synthetic */ Map f(ImageManager imageManager) {
        throw null;
    }

    static /* bridge */ /* synthetic */ Map g(ImageManager imageManager) {
        throw null;
    }

    static /* bridge */ /* synthetic */ Map h(ImageManager imageManager) {
        throw null;
    }

    static /* bridge */ /* synthetic */ ExecutorService i(ImageManager imageManager) {
        throw null;
    }
}
