package com.facebook.internal;

import android.graphics.Bitmap;
import com.facebook.internal.ImageRequest;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageRequest f37860a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Exception f37861b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f37862c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Bitmap f37863d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ImageRequest.Callback f37864e;

    public /* synthetic */ n(ImageRequest imageRequest, Exception exc, boolean z10, Bitmap bitmap, ImageRequest.Callback callback) {
        this.f37860a = imageRequest;
        this.f37861b = exc;
        this.f37862c = z10;
        this.f37863d = bitmap;
        this.f37864e = callback;
    }

    public final void run() {
        ImageDownloader.m124issueResponse$lambda4(this.f37860a, this.f37861b, this.f37862c, this.f37863d, this.f37864e);
    }
}
