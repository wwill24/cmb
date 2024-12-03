package com.withpersona.sdk2.inquiry.selfie;

import androidx.camera.view.PreviewView;
import com.withpersona.sdk2.camera.CameraPreview;
import com.withpersona.sdk2.camera.SelfieDirectionFeed;
import com.withpersona.sdk2.camera.o;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import kotlin.jvm.internal.j;
import si.a;

public final class SelfieCameraScreenViewFactory$1$1$1$cameraController$1 implements o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f27209a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ CameraPreview f27210b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ SelfieDirectionFeed f27211c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ SelfieWorkflow.Screen.CameraScreen f27212d;

    SelfieCameraScreenViewFactory$1$1$1$cameraController$1(a aVar, CameraPreview cameraPreview, SelfieDirectionFeed selfieDirectionFeed, SelfieWorkflow.Screen.CameraScreen cameraScreen) {
        this.f27209a = aVar;
        this.f27210b = cameraPreview;
        this.f27211c = selfieDirectionFeed;
        this.f27212d = cameraScreen;
    }

    public void a() {
        PreviewView previewView = this.f27209a.f33814h;
        CameraPreview.CameraDirection cameraDirection = CameraPreview.CameraDirection.FRONT;
        CameraPreview cameraPreview = this.f27210b;
        j.f(previewView, "previewviewSelfieCamera");
        CameraPreview.f(cameraPreview, previewView, cameraDirection, this.f27211c, true, false, new SelfieCameraScreenViewFactory$1$1$1$cameraController$1$bind$1(this.f27212d), 16, (Object) null);
    }
}
