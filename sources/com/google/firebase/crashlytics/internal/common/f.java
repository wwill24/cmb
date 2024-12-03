package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class f implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SessionReportingCoordinator f21014a;

    public /* synthetic */ f(SessionReportingCoordinator sessionReportingCoordinator) {
        this.f21014a = sessionReportingCoordinator;
    }

    public final Object then(Task task) {
        return Boolean.valueOf(this.f21014a.onReportSendComplete(task));
    }
}
