package com.withpersona.sdk2.inquiry.governmentid;

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
import com.withpersona.sdk2.camera.GovernmentIdFeed;
import com.withpersona.sdk2.camera.NoSuitableCameraError;
import com.withpersona.sdk2.camera.camera2.Camera2Controller;
import com.withpersona.sdk2.camera.camera2.Camera2PreviewView;
import com.withpersona.sdk2.camera.camera2.CameraDirection;
import com.withpersona.sdk2.camera.camera2.d;
import com.withpersona.sdk2.camera.camera2.e;
import com.withpersona.sdk2.camera.camera2.f;
import com.withpersona.sdk2.camera.g;
import com.withpersona.sdk2.camera.t;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import pk.o;

public final class GovernmentIdCameraScreenViewFactory implements r<GovernmentIdWorkflow.Screen.CameraScreen> {

    /* renamed from: a  reason: collision with root package name */
    private final GovernmentIdFeed f25350a;

    /* renamed from: b  reason: collision with root package name */
    private final CameraPreview f25351b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ c<GovernmentIdWorkflow.Screen.CameraScreen> f25352c;

    public GovernmentIdCameraScreenViewFactory(final GovernmentIdFeed governmentIdFeed, final CameraPreview cameraPreview) {
        j.g(governmentIdFeed, "governmentIdFeed");
        j.g(cameraPreview, "cameraPreview");
        this.f25350a = governmentIdFeed;
        this.f25351b = cameraPreview;
        this.f25352c = new c<>(l.b(GovernmentIdWorkflow.Screen.CameraScreen.class), new o<GovernmentIdWorkflow.Screen.CameraScreen, p, Context, ViewGroup, View>() {

            /* renamed from: com.withpersona.sdk2.inquiry.governmentid.GovernmentIdCameraScreenViewFactory$1$a */
            public static final class a implements com.withpersona.sdk2.camera.o {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ ki.a f25353a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ GovernmentIdWorkflow.Screen.CameraScreen f25354b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ CameraPreview f25355c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ GovernmentIdFeed f25356d;

                a(ki.a aVar, GovernmentIdWorkflow.Screen.CameraScreen cameraScreen, CameraPreview cameraPreview, GovernmentIdFeed governmentIdFeed) {
                    this.f25353a = aVar;
                    this.f25354b = cameraScreen;
                    this.f25355c = cameraPreview;
                    this.f25356d = governmentIdFeed;
                }

                public void a() {
                    PreviewView previewView = this.f25353a.f31939y;
                    CameraPreview.CameraDirection cameraDirection = CameraPreview.CameraDirection.BACK;
                    Function1<Throwable, Unit> w10 = this.f25354b.w();
                    CameraPreview cameraPreview = this.f25355c;
                    j.f(previewView, "previewView");
                    CameraPreview.f(cameraPreview, previewView, cameraDirection, this.f25356d, true, false, w10, 16, (Object) null);
                }
            }

            /* renamed from: a */
            public final View g(GovernmentIdWorkflow.Screen.CameraScreen cameraScreen, p pVar, Context context, ViewGroup viewGroup) {
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
                GovernmentIdFeed governmentIdFeed = governmentIdFeed;
                CameraPreview cameraPreview = cameraPreview;
                ki.a c10 = ki.a.c(cloneInContext);
                if (cameraScreen.F()) {
                    Context applicationContext = context.getApplicationContext();
                    j.f(applicationContext, "context.applicationContext");
                    f a10 = e.a(applicationContext, CameraDirection.BACK);
                    if (a10 == null) {
                        cameraScreen.w().invoke(new NoSuitableCameraError());
                        Camera2PreviewView camera2PreviewView = c10.f31923c;
                        j.f(camera2PreviewView, "camera2Preview");
                        gVar = new t(camera2PreviewView);
                    } else {
                        Context applicationContext2 = context.getApplicationContext();
                        j.f(applicationContext2, "context.applicationContext");
                        Camera2PreviewView camera2PreviewView2 = c10.f31923c;
                        j.f(camera2PreviewView2, "camera2Preview");
                        gVar = new Camera2Controller(new d(applicationContext2, a10, camera2PreviewView2, governmentIdFeed));
                    }
                } else {
                    Context applicationContext3 = context.getApplicationContext();
                    j.f(applicationContext3, "context.applicationContext");
                    PreviewView previewView = c10.f31939y;
                    j.f(previewView, "previewView");
                    gVar = new CameraXController(applicationContext3, cameraPreview, previewView, new a(c10, cameraScreen, cameraPreview, governmentIdFeed));
                }
                ConstraintLayout b10 = c10.getRoot();
                j.f(b10, "root");
                j.f(c10, "this");
                com.squareup.workflow1.ui.t.a(b10, cameraScreen, pVar, new GovernmentIdCameraScreenViewFactory$1$1$1$1(new CameraScreenRunner(c10, gVar, governmentIdFeed)));
                ConstraintLayout b11 = c10.getRoot();
                j.f(b11, "from(container?.context …         }.root\n        }");
                return b11;
            }
        });
    }

    /* renamed from: b */
    public View a(GovernmentIdWorkflow.Screen.CameraScreen cameraScreen, p pVar, Context context, ViewGroup viewGroup) {
        j.g(cameraScreen, "initialRendering");
        j.g(pVar, "initialViewEnvironment");
        j.g(context, "contextForNewView");
        return this.f25352c.a(cameraScreen, pVar, context, viewGroup);
    }

    public wk.c<? super GovernmentIdWorkflow.Screen.CameraScreen> getType() {
        return this.f25352c.getType();
    }
}
