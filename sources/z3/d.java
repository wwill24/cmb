package z3;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Context f18831a;

    public d(Context context) {
        this.f18831a = context;
    }

    private static b b(String str) {
        try {
            Class<?> cls = Class.forName(str);
            Object obj = null;
            try {
                obj = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (InstantiationException e10) {
                c(cls, e10);
            } catch (IllegalAccessException e11) {
                c(cls, e11);
            } catch (NoSuchMethodException e12) {
                c(cls, e12);
            } catch (InvocationTargetException e13) {
                c(cls, e13);
            }
            if (obj instanceof b) {
                return (b) obj;
            }
            throw new RuntimeException("Expected instanceof GlideModule, but found: " + obj);
        } catch (ClassNotFoundException e14) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e14);
        }
    }

    private static void c(Class<?> cls, Exception exc) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, exc);
    }

    public List<b> a() {
        Log.isLoggable("ManifestParser", 3);
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.f18831a.getPackageManager().getApplicationInfo(this.f18831a.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                Log.isLoggable("ManifestParser", 3);
                return arrayList;
            }
            if (Log.isLoggable("ManifestParser", 2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Got app info metadata: ");
                sb2.append(applicationInfo.metaData);
            }
            for (String next : applicationInfo.metaData.keySet()) {
                if ("GlideModule".equals(applicationInfo.metaData.get(next))) {
                    arrayList.add(b(next));
                    if (Log.isLoggable("ManifestParser", 3)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Loaded Glide module: ");
                        sb3.append(next);
                    }
                }
            }
            Log.isLoggable("ManifestParser", 3);
            return arrayList;
        } catch (PackageManager.NameNotFoundException e10) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e10);
        }
    }
}
