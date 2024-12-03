package com.facebook.login;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceAuthDialog f37892a;

    public /* synthetic */ e(DeviceAuthDialog deviceAuthDialog) {
        this.f37892a = deviceAuthDialog;
    }

    public final void run() {
        DeviceAuthDialog.m157schedulePoll$lambda3(this.f37892a);
    }
}
