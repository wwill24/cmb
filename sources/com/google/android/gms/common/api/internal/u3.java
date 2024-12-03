package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.collection.a;
import com.google.android.gms.internal.common.zzi;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public final class u3 extends Fragment implements j {

    /* renamed from: d  reason: collision with root package name */
    private static final WeakHashMap f38777d = new WeakHashMap();

    /* renamed from: a  reason: collision with root package name */
    private final Map f38778a = Collections.synchronizedMap(new a());
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f38779b = 0;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Bundle f38780c;

    public static u3 c(Activity activity) {
        u3 u3Var;
        WeakHashMap weakHashMap = f38777d;
        WeakReference weakReference = (WeakReference) weakHashMap.get(activity);
        if (weakReference != null && (u3Var = (u3) weakReference.get()) != null) {
            return u3Var;
        }
        try {
            u3 u3Var2 = (u3) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (u3Var2 == null || u3Var2.isRemoving()) {
                u3Var2 = new u3();
                activity.getFragmentManager().beginTransaction().add(u3Var2, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            weakHashMap.put(activity, new WeakReference(u3Var2));
            return u3Var2;
        } catch (ClassCastException e10) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e10);
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback dump : this.f38778a.values()) {
            dump.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final Activity g0() {
        return getActivity();
    }

    public final void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        for (LifecycleCallback onActivityResult : this.f38778a.values()) {
            onActivityResult.onActivityResult(i10, i11, intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        Bundle bundle2;
        super.onCreate(bundle);
        this.f38779b = 1;
        this.f38780c = bundle;
        for (Map.Entry entry : this.f38778a.entrySet()) {
            LifecycleCallback lifecycleCallback = (LifecycleCallback) entry.getValue();
            if (bundle != null) {
                bundle2 = bundle.getBundle((String) entry.getKey());
            } else {
                bundle2 = null;
            }
            lifecycleCallback.onCreate(bundle2);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f38779b = 5;
        for (LifecycleCallback onDestroy : this.f38778a.values()) {
            onDestroy.onDestroy();
        }
    }

    public final void onResume() {
        super.onResume();
        this.f38779b = 3;
        for (LifecycleCallback onResume : this.f38778a.values()) {
            onResume.onResume();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry entry : this.f38778a.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) entry.getValue()).onSaveInstanceState(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        this.f38779b = 2;
        for (LifecycleCallback onStart : this.f38778a.values()) {
            onStart.onStart();
        }
    }

    public final void onStop() {
        super.onStop();
        this.f38779b = 4;
        for (LifecycleCallback onStop : this.f38778a.values()) {
            onStop.onStop();
        }
    }

    public final void p(String str, @NonNull LifecycleCallback lifecycleCallback) {
        if (!this.f38778a.containsKey(str)) {
            this.f38778a.put(str, lifecycleCallback);
            if (this.f38779b > 0) {
                new zzi(Looper.getMainLooper()).post(new t3(this, lifecycleCallback, str));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("LifecycleCallback with tag " + str + " already added to this fragment.");
    }

    public final <T extends LifecycleCallback> T y(String str, Class<T> cls) {
        return (LifecycleCallback) cls.cast(this.f38778a.get(str));
    }
}
