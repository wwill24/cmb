package com.withpersona.sdk2.inquiry.governmentid;

import android.view.View;
import androidx.lifecycle.g;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CameraScreenRunner f25766a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GovernmentIdWorkflow.Screen.CameraScreen f25767b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g f25768c;

    public /* synthetic */ d(CameraScreenRunner cameraScreenRunner, GovernmentIdWorkflow.Screen.CameraScreen cameraScreen, g gVar) {
        this.f25766a = cameraScreenRunner;
        this.f25767b = cameraScreen;
        this.f25768c = gVar;
    }

    public final void onClick(View view) {
        CameraScreenRunner.L(this.f25766a, this.f25767b, this.f25768c, view);
    }
}
