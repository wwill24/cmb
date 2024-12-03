package uc;

import com.facebook.appevents.internal.FileDownloadTask;
import com.facebook.appevents.ml.Model;
import com.facebook.appevents.ml.ModelManager;
import java.io.File;

public final /* synthetic */ class e implements FileDownloadTask.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ModelManager.TaskHandler f42024a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Model f42025b;

    public /* synthetic */ e(ModelManager.TaskHandler taskHandler, Model model) {
        this.f42024a = taskHandler;
        this.f42025b = model;
    }

    public final void onComplete(File file) {
        ModelManager.TaskHandler.Companion.m80execute$lambda1$lambda0(this.f42024a, this.f42025b, file);
    }
}
