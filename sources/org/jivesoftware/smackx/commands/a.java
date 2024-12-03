package org.jivesoftware.smackx.commands;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdHocCommandManager f24201a;

    public /* synthetic */ a(AdHocCommandManager adHocCommandManager) {
        this.f24201a = adHocCommandManager;
    }

    public final void run() {
        this.f24201a.sessionSweeper();
    }
}
