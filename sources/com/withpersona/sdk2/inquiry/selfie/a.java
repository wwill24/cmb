package com.withpersona.sdk2.inquiry.selfie;

import android.view.View;
import androidx.lifecycle.g;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ si.a f27398a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f27399b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CameraScreenRunner f27400c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SelfieWorkflow.Screen.CameraScreen.a f27401d;

    public /* synthetic */ a(si.a aVar, g gVar, CameraScreenRunner cameraScreenRunner, SelfieWorkflow.Screen.CameraScreen.a aVar2) {
        this.f27398a = aVar;
        this.f27399b = gVar;
        this.f27400c = cameraScreenRunner;
        this.f27401d = aVar2;
    }

    public final void onClick(View view) {
        CameraScreenRunner.s(this.f27398a, this.f27399b, this.f27400c, this.f27401d, view);
    }
}
