package com.withpersona.sdk2.inquiry.launchers;

import android.net.Uri;
import androidx.activity.result.c;
import androidx.activity.result.e;
import kotlin.jvm.internal.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final c<Uri> f26950a;

    /* renamed from: b  reason: collision with root package name */
    private final c<String[]> f26951b;

    /* renamed from: c  reason: collision with root package name */
    private final c<e> f26952c;

    public a(c<Uri> cVar, c<String[]> cVar2, c<e> cVar3) {
        j.g(cVar, "pictureLaunchResultLauncher");
        j.g(cVar2, "openDocumentsResultLauncher");
        j.g(cVar3, "selectFromPhotoLibraryLauncher");
        this.f26950a = cVar;
        this.f26951b = cVar2;
        this.f26952c = cVar3;
    }

    public final c<String[]> a() {
        return this.f26951b;
    }

    public final c<e> b() {
        return this.f26952c;
    }

    public final c<Uri> c() {
        return this.f26950a;
    }
}
