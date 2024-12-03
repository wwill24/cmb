package q;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Range;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.q1;
import o.c0;

public class a implements q1 {

    /* renamed from: a  reason: collision with root package name */
    private final Range<Integer> f17072a;

    public a(@NonNull c0 c0Var) {
        this.f17072a = e((Range[]) c0Var.a(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES));
    }

    @NonNull
    private Range<Integer> b(@NonNull Range<Integer> range) {
        int intValue = range.getUpper().intValue();
        int intValue2 = range.getLower().intValue();
        if (range.getUpper().intValue() >= 1000) {
            intValue = range.getUpper().intValue() / 1000;
        }
        if (range.getLower().intValue() >= 1000) {
            intValue2 = range.getLower().intValue() / 1000;
        }
        return new Range<>(Integer.valueOf(intValue2), Integer.valueOf(intValue));
    }

    static boolean d(@NonNull c0 c0Var) {
        Integer num = (Integer) c0Var.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        if (num == null || num.intValue() != 2) {
            return false;
        }
        return true;
    }

    private Range<Integer> e(Range<Integer>[] rangeArr) {
        Range<Integer> range = null;
        if (!(rangeArr == null || rangeArr.length == 0)) {
            for (Range<Integer> b10 : rangeArr) {
                Range<Integer> b11 = b(b10);
                if (b11.getUpper().intValue() == 30 && (range == null || b11.getLower().intValue() < range.getLower().intValue())) {
                    range = b11;
                }
            }
        }
        return range;
    }

    public Range<Integer> c() {
        return this.f17072a;
    }
}
