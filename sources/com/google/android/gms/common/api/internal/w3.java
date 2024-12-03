package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.collection.a;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.h;
import com.google.android.gms.internal.common.zzi;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public final class w3 extends Fragment implements j {

    /* renamed from: d  reason: collision with root package name */
    private static final WeakHashMap f38797d = new WeakHashMap();

    /* renamed from: a  reason: collision with root package name */
    private final Map f38798a = Collections.synchronizedMap(new a());
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f38799b = 0;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Bundle f38800c;

    public static w3 B0(h hVar) {
        w3 w3Var;
        WeakHashMap weakHashMap = f38797d;
        WeakReference weakReference = (WeakReference) weakHashMap.get(hVar);
        if (weakReference != null && (w3Var = (w3) weakReference.get()) != null) {
            return w3Var;
        }
        try {
            w3 w3Var2 = (w3) hVar.getSupportFragmentManager().j0("SupportLifecycleFragmentImpl");
            if (w3Var2 == null || w3Var2.isRemoving()) {
                w3Var2 = new w3();
                hVar.getSupportFragmentManager().p().e(w3Var2, "SupportLifecycleFragmentImpl").j();
            }
            weakHashMap.put(hVar, new WeakReference(w3Var2));
            return w3Var2;
        } catch (ClassCastException e10) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e10);
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback dump : this.f38798a.values()) {
            dump.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final /* synthetic */ Activity g0() {
        return getActivity();
    }

    public final void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        for (LifecycleCallback onActivityResult : this.f38798a.values()) {
            onActivityResult.onActivityResult(i10, i11, intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        Bundle bundle2;
        super.onCreate(bundle);
        this.f38799b = 1;
        this.f38800c = bundle;
        for (Map.Entry entry : this.f38798a.entrySet()) {
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
        this.f38799b = 5;
        for (LifecycleCallback onDestroy : this.f38798a.values()) {
            onDestroy.onDestroy();
        }
    }

    public final void onResume() {
        super.onResume();
        this.f38799b = 3;
        for (LifecycleCallback onResume : this.f38798a.values()) {
            onResume.onResume();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry entry : this.f38798a.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) entry.getValue()).onSaveInstanceState(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        this.f38799b = 2;
        for (LifecycleCallback onStart : this.f38798a.values()) {
            onStart.onStart();
        }
    }

    public final void onStop() {
        super.onStop();
        this.f38799b = 4;
        for (LifecycleCallback onStop : this.f38798a.values()) {
            onStop.onStop();
        }
    }

    public final void p(String str, @NonNull LifecycleCallback lifecycleCallback) {
        if (!this.f38798a.containsKey(str)) {
            this.f38798a.put(str, lifecycleCallback);
            if (this.f38799b > 0) {
                new zzi(Looper.getMainLooper()).post(new v3(this, lifecycleCallback, str));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("LifecycleCallback with tag " + str + " already added to this fragment.");
    }

    public final <T extends LifecycleCallback> T y(String str, Class<T> cls) {
        return (LifecycleCallback) cls.cast(this.f38798a.get(str));
    }
}
