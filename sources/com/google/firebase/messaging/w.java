package com.google.firebase.messaging;

import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageDownload f21139a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f21140b;

    public /* synthetic */ w(ImageDownload imageDownload, TaskCompletionSource taskCompletionSource) {
        this.f21139a = imageDownload;
        this.f21140b = taskCompletionSource;
    }

    public final void run() {
        this.f21139a.lambda$start$0(this.f21140b);
    }
}
