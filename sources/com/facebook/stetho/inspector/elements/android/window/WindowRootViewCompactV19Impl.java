package com.facebook.stetho.inspector.elements.android.window;

import android.view.View;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;

class WindowRootViewCompactV19Impl extends WindowRootViewCompat {
    private List<View> mRootViews;

    WindowRootViewCompactV19Impl() {
        try {
            Class<?> cls = Class.forName("android.view.WindowManagerGlobal");
            Object invoke = cls.getDeclaredMethod("getInstance", new Class[0]).invoke(cls, new Object[0]);
            Field declaredField = cls.getDeclaredField("mViews");
            declaredField.setAccessible(true);
            this.mRootViews = (List) declaredField.get(invoke);
            declaredField.setAccessible(false);
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException(e10);
        } catch (NoSuchMethodException e11) {
            throw new RuntimeException(e11);
        } catch (IllegalAccessException e12) {
            throw new RuntimeException(e12);
        } catch (InvocationTargetException e13) {
            throw new RuntimeException(e13);
        } catch (NoSuchFieldException e14) {
            throw new RuntimeException(e14);
        }
    }

    @NonNull
    public List<View> getRootViews() {
        return Collections.unmodifiableList(this.mRootViews);
    }
}
