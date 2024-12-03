package f0;

import android.media.MediaFormat;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.q1;
import com.facebook.appevents.internal.ViewHierarchyConstants;

public class j implements q1 {
    private static boolean b() {
        return "Huawei".equalsIgnoreCase(Build.BRAND) && "mha-l29".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean c() {
        return "lge".equalsIgnoreCase(Build.BRAND) && "lg-k430".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean d() {
        return "motorola".equalsIgnoreCase(Build.BRAND) && "moto c".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean e() {
        return "Nokia".equalsIgnoreCase(Build.BRAND) && "Nokia 1".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean f() {
        return "positivo".equalsIgnoreCase(Build.BRAND) && "twist 2 pro".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean g() {
        return "Xiaomi".equalsIgnoreCase(Build.BRAND) && "redmi note 4".equalsIgnoreCase(Build.MODEL);
    }

    private boolean i(@NonNull MediaFormat mediaFormat) {
        return mediaFormat.getString("mime").contains("video/");
    }

    private static boolean j() {
        return "LGE".equalsIgnoreCase(Build.BRAND) && "LG-X230".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean k() {
        if (!"infinix".equalsIgnoreCase(Build.BRAND) || !"infinix x650".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    static boolean l() {
        if (e() || d() || k() || j() || b() || f() || g() || c()) {
            return true;
        }
        return false;
    }

    public boolean h(@NonNull MediaFormat mediaFormat) {
        if (e() || d() || k() || j() || f()) {
            return "video/mp4v-es".equals(mediaFormat.getString("mime"));
        }
        if (b() && i(mediaFormat)) {
            int integer = mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
            int integer2 = mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
            if (integer == 3840 && integer2 == 2160) {
                return true;
            }
            return false;
        } else if ((!g() && !c()) || !"video/avc".equals(mediaFormat.getString("mime"))) {
            return false;
        } else {
            int integer3 = mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
            int integer4 = mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
            if (integer3 == 1920 && integer4 == 1080) {
                return true;
            }
            return false;
        }
    }
}
