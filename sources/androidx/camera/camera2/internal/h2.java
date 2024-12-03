package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.y1;
import java.util.ArrayList;
import java.util.List;

public final class h2 {
    @NonNull
    public static List<y1> a(int i10, boolean z10, boolean z11) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(d());
        if (i10 == 0 || i10 == 1 || i10 == 3) {
            arrayList.addAll(f());
        }
        if (i10 == 1 || i10 == 3) {
            arrayList.addAll(c());
        }
        if (z10) {
            arrayList.addAll(g());
        }
        if (z11 && i10 == 0) {
            arrayList.addAll(b());
        }
        if (i10 == 3) {
            arrayList.addAll(e());
        }
        return arrayList;
    }

    @NonNull
    public static List<y1> b() {
        ArrayList arrayList = new ArrayList();
        y1 y1Var = new y1();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.PREVIEW;
        y1Var.a(SurfaceConfig.a(configType, configSize));
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.MAXIMUM;
        y1Var.a(SurfaceConfig.a(configType, configSize2));
        arrayList.add(y1Var);
        y1 y1Var2 = new y1();
        y1Var2.a(SurfaceConfig.a(configType, configSize));
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        y1Var2.a(SurfaceConfig.a(configType2, configSize2));
        arrayList.add(y1Var2);
        y1 y1Var3 = new y1();
        y1Var3.a(SurfaceConfig.a(configType2, configSize));
        y1Var3.a(SurfaceConfig.a(configType2, configSize2));
        arrayList.add(y1Var3);
        return arrayList;
    }

    @NonNull
    public static List<y1> c() {
        ArrayList arrayList = new ArrayList();
        y1 y1Var = new y1();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.PREVIEW;
        y1Var.a(SurfaceConfig.a(configType, configSize));
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.MAXIMUM;
        y1Var.a(SurfaceConfig.a(configType, configSize2));
        arrayList.add(y1Var);
        y1 y1Var2 = new y1();
        y1Var2.a(SurfaceConfig.a(configType, configSize));
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        y1Var2.a(SurfaceConfig.a(configType2, configSize2));
        arrayList.add(y1Var2);
        y1 y1Var3 = new y1();
        y1Var3.a(SurfaceConfig.a(configType2, configSize));
        y1Var3.a(SurfaceConfig.a(configType2, configSize2));
        arrayList.add(y1Var3);
        y1 y1Var4 = new y1();
        y1Var4.a(SurfaceConfig.a(configType, configSize));
        y1Var4.a(SurfaceConfig.a(configType, configSize));
        y1Var4.a(SurfaceConfig.a(SurfaceConfig.ConfigType.JPEG, configSize2));
        arrayList.add(y1Var4);
        y1 y1Var5 = new y1();
        SurfaceConfig.ConfigSize configSize3 = SurfaceConfig.ConfigSize.VGA;
        y1Var5.a(SurfaceConfig.a(configType2, configSize3));
        y1Var5.a(SurfaceConfig.a(configType, configSize));
        y1Var5.a(SurfaceConfig.a(configType2, configSize2));
        arrayList.add(y1Var5);
        y1 y1Var6 = new y1();
        y1Var6.a(SurfaceConfig.a(configType2, configSize3));
        y1Var6.a(SurfaceConfig.a(configType2, configSize));
        y1Var6.a(SurfaceConfig.a(configType2, configSize2));
        arrayList.add(y1Var6);
        return arrayList;
    }

    @NonNull
    public static List<y1> d() {
        ArrayList arrayList = new ArrayList();
        y1 y1Var = new y1();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.MAXIMUM;
        y1Var.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(y1Var);
        y1 y1Var2 = new y1();
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.JPEG;
        y1Var2.a(SurfaceConfig.a(configType2, configSize));
        arrayList.add(y1Var2);
        y1 y1Var3 = new y1();
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.YUV;
        y1Var3.a(SurfaceConfig.a(configType3, configSize));
        arrayList.add(y1Var3);
        y1 y1Var4 = new y1();
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.PREVIEW;
        y1Var4.a(SurfaceConfig.a(configType, configSize2));
        y1Var4.a(SurfaceConfig.a(configType2, configSize));
        arrayList.add(y1Var4);
        y1 y1Var5 = new y1();
        y1Var5.a(SurfaceConfig.a(configType3, configSize2));
        y1Var5.a(SurfaceConfig.a(configType2, configSize));
        arrayList.add(y1Var5);
        y1 y1Var6 = new y1();
        y1Var6.a(SurfaceConfig.a(configType, configSize2));
        y1Var6.a(SurfaceConfig.a(configType, configSize2));
        arrayList.add(y1Var6);
        y1 y1Var7 = new y1();
        y1Var7.a(SurfaceConfig.a(configType, configSize2));
        y1Var7.a(SurfaceConfig.a(configType3, configSize2));
        arrayList.add(y1Var7);
        y1 y1Var8 = new y1();
        y1Var8.a(SurfaceConfig.a(configType, configSize2));
        y1Var8.a(SurfaceConfig.a(configType3, configSize2));
        y1Var8.a(SurfaceConfig.a(configType2, configSize));
        arrayList.add(y1Var8);
        return arrayList;
    }

    @NonNull
    public static List<y1> e() {
        ArrayList arrayList = new ArrayList();
        y1 y1Var = new y1();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.PREVIEW;
        y1Var.a(SurfaceConfig.a(configType, configSize));
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.VGA;
        y1Var.a(SurfaceConfig.a(configType, configSize2));
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        SurfaceConfig.ConfigSize configSize3 = SurfaceConfig.ConfigSize.MAXIMUM;
        y1Var.a(SurfaceConfig.a(configType2, configSize3));
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.RAW;
        y1Var.a(SurfaceConfig.a(configType3, configSize3));
        arrayList.add(y1Var);
        y1 y1Var2 = new y1();
        y1Var2.a(SurfaceConfig.a(configType, configSize));
        y1Var2.a(SurfaceConfig.a(configType, configSize2));
        y1Var2.a(SurfaceConfig.a(SurfaceConfig.ConfigType.JPEG, configSize3));
        y1Var2.a(SurfaceConfig.a(configType3, configSize3));
        arrayList.add(y1Var2);
        return arrayList;
    }

    @NonNull
    public static List<y1> f() {
        ArrayList arrayList = new ArrayList();
        y1 y1Var = new y1();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.PREVIEW;
        y1Var.a(SurfaceConfig.a(configType, configSize));
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.RECORD;
        y1Var.a(SurfaceConfig.a(configType, configSize2));
        arrayList.add(y1Var);
        y1 y1Var2 = new y1();
        y1Var2.a(SurfaceConfig.a(configType, configSize));
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        y1Var2.a(SurfaceConfig.a(configType2, configSize2));
        arrayList.add(y1Var2);
        y1 y1Var3 = new y1();
        y1Var3.a(SurfaceConfig.a(configType2, configSize));
        y1Var3.a(SurfaceConfig.a(configType2, configSize2));
        arrayList.add(y1Var3);
        y1 y1Var4 = new y1();
        y1Var4.a(SurfaceConfig.a(configType, configSize));
        y1Var4.a(SurfaceConfig.a(configType, configSize2));
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.JPEG;
        y1Var4.a(SurfaceConfig.a(configType3, configSize2));
        arrayList.add(y1Var4);
        y1 y1Var5 = new y1();
        y1Var5.a(SurfaceConfig.a(configType, configSize));
        y1Var5.a(SurfaceConfig.a(configType2, configSize2));
        y1Var5.a(SurfaceConfig.a(configType3, configSize2));
        arrayList.add(y1Var5);
        y1 y1Var6 = new y1();
        y1Var6.a(SurfaceConfig.a(configType2, configSize));
        y1Var6.a(SurfaceConfig.a(configType2, configSize));
        y1Var6.a(SurfaceConfig.a(configType3, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(y1Var6);
        return arrayList;
    }

    @NonNull
    public static List<y1> g() {
        ArrayList arrayList = new ArrayList();
        y1 y1Var = new y1();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.RAW;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.MAXIMUM;
        y1Var.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(y1Var);
        y1 y1Var2 = new y1();
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.PREVIEW;
        y1Var2.a(SurfaceConfig.a(configType2, configSize2));
        y1Var2.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(y1Var2);
        y1 y1Var3 = new y1();
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.YUV;
        y1Var3.a(SurfaceConfig.a(configType3, configSize2));
        y1Var3.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(y1Var3);
        y1 y1Var4 = new y1();
        y1Var4.a(SurfaceConfig.a(configType2, configSize2));
        y1Var4.a(SurfaceConfig.a(configType2, configSize2));
        y1Var4.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(y1Var4);
        y1 y1Var5 = new y1();
        y1Var5.a(SurfaceConfig.a(configType2, configSize2));
        y1Var5.a(SurfaceConfig.a(configType3, configSize2));
        y1Var5.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(y1Var5);
        y1 y1Var6 = new y1();
        y1Var6.a(SurfaceConfig.a(configType3, configSize2));
        y1Var6.a(SurfaceConfig.a(configType3, configSize2));
        y1Var6.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(y1Var6);
        y1 y1Var7 = new y1();
        y1Var7.a(SurfaceConfig.a(configType2, configSize2));
        SurfaceConfig.ConfigType configType4 = SurfaceConfig.ConfigType.JPEG;
        y1Var7.a(SurfaceConfig.a(configType4, configSize));
        y1Var7.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(y1Var7);
        y1 y1Var8 = new y1();
        y1Var8.a(SurfaceConfig.a(configType3, configSize2));
        y1Var8.a(SurfaceConfig.a(configType4, configSize));
        y1Var8.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(y1Var8);
        return arrayList;
    }
}
