package h2;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import b2.f;
import org.jivesoftware.smack.sm.packet.StreamManagement;

public class n {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15289a = f.i("PackageManagerHelper");

    public static void a(@NonNull Context context, @NonNull Class<?> cls, boolean z10) {
        int i10;
        String str;
        String str2 = StreamManagement.Enabled.ELEMENT;
        try {
            PackageManager packageManager = context.getPackageManager();
            ComponentName componentName = new ComponentName(context, cls.getName());
            if (z10) {
                i10 = 1;
            } else {
                i10 = 2;
            }
            packageManager.setComponentEnabledSetting(componentName, i10, 1);
            f e10 = f.e();
            String str3 = f15289a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cls.getName());
            sb2.append(" ");
            if (z10) {
                str = str2;
            } else {
                str = "disabled";
            }
            sb2.append(str);
            e10.a(str3, sb2.toString());
        } catch (Exception e11) {
            f e12 = f.e();
            String str4 = f15289a;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(cls.getName());
            sb3.append("could not be ");
            if (!z10) {
                str2 = "disabled";
            }
            sb3.append(str2);
            e12.b(str4, sb3.toString(), e11);
        }
    }
}
