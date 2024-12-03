package q;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.q1;
import androidx.camera.core.v1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import o.c0;

public class e implements q1 {

    /* renamed from: a  reason: collision with root package name */
    private final List<Size> f17074a;

    public e(@NonNull c0 c0Var) {
        Size[] sizeArr;
        List<Size> list;
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) c0Var.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null) {
            v1.c("CamcorderProfileResolutionQuirk", "StreamConfigurationMap is null");
        }
        if (streamConfigurationMap != null) {
            sizeArr = streamConfigurationMap.getOutputSizes(34);
        } else {
            sizeArr = null;
        }
        if (sizeArr != null) {
            list = Arrays.asList((Size[]) sizeArr.clone());
        } else {
            list = Collections.emptyList();
        }
        this.f17074a = list;
        v1.a("CamcorderProfileResolutionQuirk", "mSupportedResolutions = " + list);
    }

    static boolean c(@NonNull c0 c0Var) {
        Integer num = (Integer) c0Var.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        if (num == null || num.intValue() != 2) {
            return false;
        }
        return true;
    }

    @NonNull
    public List<Size> b() {
        return new ArrayList(this.f17074a);
    }
}
