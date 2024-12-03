package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CaptureResult;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.CameraCaptureMetaData$AeState;
import androidx.camera.core.impl.CameraCaptureMetaData$AfMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AfState;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbState;
import androidx.camera.core.impl.CameraCaptureMetaData$FlashState;
import androidx.camera.core.impl.a2;
import androidx.camera.core.impl.p;
import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.v1;
import java.nio.BufferUnderflowException;

public class e implements p {

    /* renamed from: a  reason: collision with root package name */
    private final a2 f1726a;

    /* renamed from: b  reason: collision with root package name */
    private final CaptureResult f1727b;

    public e(@NonNull a2 a2Var, @NonNull CaptureResult captureResult) {
        this.f1726a = a2Var;
        this.f1727b = captureResult;
    }

    @NonNull
    public CameraCaptureMetaData$FlashState a() {
        Integer num = (Integer) this.f1727b.get(CaptureResult.FLASH_STATE);
        if (num == null) {
            return CameraCaptureMetaData$FlashState.UNKNOWN;
        }
        int intValue = num.intValue();
        if (intValue == 0 || intValue == 1) {
            return CameraCaptureMetaData$FlashState.NONE;
        }
        if (intValue == 2) {
            return CameraCaptureMetaData$FlashState.READY;
        }
        if (intValue == 3 || intValue == 4) {
            return CameraCaptureMetaData$FlashState.FIRED;
        }
        v1.c("C2CameraCaptureResult", "Undefined flash state: " + num);
        return CameraCaptureMetaData$FlashState.UNKNOWN;
    }

    public void b(@NonNull ExifData.b bVar) {
        super.b(bVar);
        Rect rect = (Rect) this.f1727b.get(CaptureResult.SCALER_CROP_REGION);
        if (rect != null) {
            bVar.j(rect.width()).i(rect.height());
        }
        try {
            Integer num = (Integer) this.f1727b.get(CaptureResult.JPEG_ORIENTATION);
            if (num != null) {
                bVar.m(num.intValue());
            }
        } catch (BufferUnderflowException unused) {
            v1.l("C2CameraCaptureResult", "Failed to get JPEG orientation.");
        }
        Long l10 = (Long) this.f1727b.get(CaptureResult.SENSOR_EXPOSURE_TIME);
        if (l10 != null) {
            bVar.f(l10.longValue());
        }
        Float f10 = (Float) this.f1727b.get(CaptureResult.LENS_APERTURE);
        if (f10 != null) {
            bVar.l(f10.floatValue());
        }
        Integer num2 = (Integer) this.f1727b.get(CaptureResult.SENSOR_SENSITIVITY);
        if (num2 != null) {
            Integer num3 = (Integer) this.f1727b.get(CaptureResult.CONTROL_POST_RAW_SENSITIVITY_BOOST);
            if (num3 != null) {
                num2 = Integer.valueOf(num2.intValue() * ((int) (((float) num3.intValue()) / 100.0f)));
            }
            bVar.k(num2.intValue());
        }
        Float f11 = (Float) this.f1727b.get(CaptureResult.LENS_FOCAL_LENGTH);
        if (f11 != null) {
            bVar.h(f11.floatValue());
        }
        Integer num4 = (Integer) this.f1727b.get(CaptureResult.CONTROL_AWB_MODE);
        if (num4 != null) {
            ExifData.WhiteBalanceMode whiteBalanceMode = ExifData.WhiteBalanceMode.AUTO;
            if (num4.intValue() == 0) {
                whiteBalanceMode = ExifData.WhiteBalanceMode.MANUAL;
            }
            bVar.n(whiteBalanceMode);
        }
    }

    @NonNull
    public a2 c() {
        return this.f1726a;
    }

    @NonNull
    public CaptureResult d() {
        return this.f1727b;
    }

    @NonNull
    public CameraCaptureMetaData$AfState e() {
        Integer num = (Integer) this.f1727b.get(CaptureResult.CONTROL_AF_STATE);
        if (num == null) {
            return CameraCaptureMetaData$AfState.UNKNOWN;
        }
        switch (num.intValue()) {
            case 0:
                return CameraCaptureMetaData$AfState.INACTIVE;
            case 1:
            case 3:
                return CameraCaptureMetaData$AfState.SCANNING;
            case 2:
                return CameraCaptureMetaData$AfState.PASSIVE_FOCUSED;
            case 4:
                return CameraCaptureMetaData$AfState.LOCKED_FOCUSED;
            case 5:
                return CameraCaptureMetaData$AfState.LOCKED_NOT_FOCUSED;
            case 6:
                return CameraCaptureMetaData$AfState.PASSIVE_NOT_FOCUSED;
            default:
                v1.c("C2CameraCaptureResult", "Undefined af state: " + num);
                return CameraCaptureMetaData$AfState.UNKNOWN;
        }
    }

    @NonNull
    public CameraCaptureMetaData$AwbState f() {
        Integer num = (Integer) this.f1727b.get(CaptureResult.CONTROL_AWB_STATE);
        if (num == null) {
            return CameraCaptureMetaData$AwbState.UNKNOWN;
        }
        int intValue = num.intValue();
        if (intValue == 0) {
            return CameraCaptureMetaData$AwbState.INACTIVE;
        }
        if (intValue == 1) {
            return CameraCaptureMetaData$AwbState.METERING;
        }
        if (intValue == 2) {
            return CameraCaptureMetaData$AwbState.CONVERGED;
        }
        if (intValue == 3) {
            return CameraCaptureMetaData$AwbState.LOCKED;
        }
        v1.c("C2CameraCaptureResult", "Undefined awb state: " + num);
        return CameraCaptureMetaData$AwbState.UNKNOWN;
    }

    @NonNull
    public CameraCaptureMetaData$AeState g() {
        Integer num = (Integer) this.f1727b.get(CaptureResult.CONTROL_AE_STATE);
        if (num == null) {
            return CameraCaptureMetaData$AeState.UNKNOWN;
        }
        int intValue = num.intValue();
        if (intValue == 0) {
            return CameraCaptureMetaData$AeState.INACTIVE;
        }
        if (intValue != 1) {
            if (intValue == 2) {
                return CameraCaptureMetaData$AeState.CONVERGED;
            }
            if (intValue == 3) {
                return CameraCaptureMetaData$AeState.LOCKED;
            }
            if (intValue == 4) {
                return CameraCaptureMetaData$AeState.FLASH_REQUIRED;
            }
            if (intValue != 5) {
                v1.c("C2CameraCaptureResult", "Undefined ae state: " + num);
                return CameraCaptureMetaData$AeState.UNKNOWN;
            }
        }
        return CameraCaptureMetaData$AeState.SEARCHING;
    }

    public long getTimestamp() {
        Long l10 = (Long) this.f1727b.get(CaptureResult.SENSOR_TIMESTAMP);
        if (l10 == null) {
            return -1;
        }
        return l10.longValue();
    }

    @NonNull
    public CameraCaptureMetaData$AfMode h() {
        Integer num = (Integer) this.f1727b.get(CaptureResult.CONTROL_AF_MODE);
        if (num == null) {
            return CameraCaptureMetaData$AfMode.UNKNOWN;
        }
        int intValue = num.intValue();
        if (intValue != 0) {
            if (intValue == 1 || intValue == 2) {
                return CameraCaptureMetaData$AfMode.ON_MANUAL_AUTO;
            }
            if (intValue == 3 || intValue == 4) {
                return CameraCaptureMetaData$AfMode.ON_CONTINUOUS_AUTO;
            }
            if (intValue != 5) {
                v1.c("C2CameraCaptureResult", "Undefined af mode: " + num);
                return CameraCaptureMetaData$AfMode.UNKNOWN;
            }
        }
        return CameraCaptureMetaData$AfMode.OFF;
    }

    public e(@NonNull CaptureResult captureResult) {
        this(a2.a(), captureResult);
    }
}
