package com.withpersona.sdk2.inquiry.selfie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.camera.view.PreviewView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.ui.c;
import com.squareup.workflow1.ui.p;
import com.squareup.workflow1.ui.r;
import com.withpersona.sdk2.camera.CameraPreview;
import com.withpersona.sdk2.camera.CameraXController;
import com.withpersona.sdk2.camera.NoSuitableCameraError;
import com.withpersona.sdk2.camera.SelfieDirectionFeed;
import com.withpersona.sdk2.camera.camera2.Camera2Controller;
import com.withpersona.sdk2.camera.camera2.Camera2PreviewView;
import com.withpersona.sdk2.camera.camera2.CameraDirection;
import com.withpersona.sdk2.camera.camera2.d;
import com.withpersona.sdk2.camera.camera2.e;
import com.withpersona.sdk2.camera.camera2.f;
import com.withpersona.sdk2.camera.g;
import com.withpersona.sdk2.camera.t;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import pk.o;
import si.a;

public final class SelfieCameraScreenViewFactory implements r<SelfieWorkflow.Screen.CameraScreen> {

    /* renamed from: a  reason: collision with root package name */
    private final CameraPreview f27206a;

    /* renamed from: b  reason: collision with root package name */
    private final SelfieDirectionFeed f27207b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ c<SelfieWorkflow.Screen.CameraScreen> f27208c;

    public SelfieCameraScreenViewFactory(final CameraPreview cameraPreview, final SelfieDirectionFeed selfieDirectionFeed) {
        j.g(cameraPreview, "cameraPreview");
        j.g(selfieDirectionFeed, "selfieDirectionFeed");
        this.f27206a = cameraPreview;
        this.f27207b = selfieDirectionFeed;
        this.f27208c = new c<>(l.b(SelfieWorkflow.Screen.CameraScreen.class), new o<SelfieWorkflow.Screen.CameraScreen, p, Context, ViewGroup, View>() {
            /* renamed from: a */
            public final View g(SelfieWorkflow.Screen.CameraScreen cameraScreen, p pVar, Context context, ViewGroup viewGroup) {
                Context context2;
                g gVar;
                j.g(cameraScreen, "initialRendering");
                j.g(pVar, "initialViewEnvironment");
                j.g(context, IdentityHttpResponse.CONTEXT);
                if (viewGroup != null) {
                    context2 = viewGroup.getContext();
                } else {
                    context2 = null;
                }
                if (context2 == null) {
                    context2 = context;
                }
                LayoutInflater cloneInContext = LayoutInflater.from(context2).cloneInContext(context);
                SelfieDirectionFeed selfieDirectionFeed = selfieDirectionFeed;
                CameraPreview cameraPreview = cameraPreview;
                a c10 = a.c(cloneInContext);
                if (cameraScreen.g()) {
                    Context applicationContext = context.getApplicationContext();
                    j.f(applicationContext, "context.applicationContext");
                    f a10 = e.a(applicationContext, CameraDirection.FRONT);
                    if (a10 == null) {
                        cameraScreen.d().invoke(new NoSuitableCameraError());
                        Camera2PreviewView camera2PreviewView = c10.f33809c;
                        j.f(camera2PreviewView, "camera2Preview");
                        gVar = new t(camera2PreviewView);
                    } else {
                        Context applicationContext2 = context.getApplicationContext();
                        j.f(applicationContext2, "context.applicationContext");
                        Camera2PreviewView camera2PreviewView2 = c10.f33809c;
                        j.f(camera2PreviewView2, "camera2Preview");
                        gVar = new Camera2Controller(new d(applicationContext2, a10, camera2PreviewView2, selfieDirectionFeed));
                    }
                } else {
                    Context applicationContext3 = context.getApplicationContext();
                    j.f(applicationContext3, "context.applicationContext");
                    PreviewView previewView = c10.f33814h;
                    j.f(previewView, "previewviewSelfieCamera");
                    gVar = new CameraXController(applicationContext3, cameraPreview, previewView, new SelfieCameraScreenViewFactory$1$1$1$cameraController$1(c10, cameraPreview, selfieDirectionFeed, cameraScreen));
                }
                ConstraintLayout b10 = c10.getRoot();
                j.f(b10, "root");
                j.f(c10, "this");
                com.squareup.workflow1.ui.t.a(b10, cameraScreen, pVar, new SelfieCameraScreenViewFactory$1$1$1$1(new CameraScreenRunner(c10, gVar)));
                ConstraintLayout b11 = c10.getRoot();
                j.f(b11, "from(container?.context …         }.root\n        }");
                return b11;
            }
        });
    }

    /* renamed from: b */
    public View a(SelfieWorkflow.Screen.CameraScreen cameraScreen, p pVar, Context context, ViewGroup viewGroup) {
        j.g(cameraScreen, "initialRendering");
        j.g(pVar, "initialViewEnvironment");
        j.g(context, "contextForNewView");
        return this.f27208c.a(cameraScreen, pVar, context, viewGroup);
    }

    public wk.c<? super SelfieWorkflow.Screen.CameraScreen> getType() {
        return this.f27208c.getType();
    }
}
