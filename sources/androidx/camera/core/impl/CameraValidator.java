package androidx.camera.core.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.core.r;
import androidx.camera.core.v1;

public final class CameraValidator {

    public static class CameraIdListIncorrectException extends Exception {
        public CameraIdListIncorrectException(String str, Throwable th2) {
            super(str, th2);
        }
    }

    public static void a(@NonNull Context context, @NonNull y yVar, r rVar) throws CameraIdListIncorrectException {
        Integer num;
        if (rVar != null) {
            try {
                num = rVar.d();
                if (num == null) {
                    v1.l("CameraValidator", "No lens facing info in the availableCamerasSelector, don't verify the camera lens facing.");
                    return;
                }
            } catch (IllegalStateException e10) {
                v1.d("CameraValidator", "Cannot get lens facing from the availableCamerasSelector don't verify the camera lens facing.", e10);
                return;
            }
        } else {
            num = null;
        }
        v1.a("CameraValidator", "Verifying camera lens facing on " + Build.DEVICE + ", lensFacingInteger: " + num);
        PackageManager packageManager = context.getPackageManager();
        try {
            if (packageManager.hasSystemFeature("android.hardware.camera") && (rVar == null || num.intValue() == 1)) {
                r.f2877c.e(yVar.a());
            }
            if (!packageManager.hasSystemFeature("android.hardware.camera.front")) {
                return;
            }
            if (rVar == null || num.intValue() == 0) {
                r.f2876b.e(yVar.a());
            }
        } catch (IllegalArgumentException e11) {
            v1.c("CameraValidator", "Camera LensFacing verification failed, existing cameras: " + yVar.a());
            throw new CameraIdListIncorrectException("Expected camera missing from device.", e11);
        }
    }
}
