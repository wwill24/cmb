package j5;

import android.content.Context;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.feature.likepassflow.ActivityLikePassFlow;
import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import com.coffeemeetsbagel.models.NetworkProfile;
import java.util.HashMap;
import r7.b;
import z9.h;

public abstract class n extends b implements z9.b {

    /* renamed from: j  reason: collision with root package name */
    public static String f15614j = "profile";

    /* renamed from: d  reason: collision with root package name */
    public h f15615d;

    /* renamed from: e  reason: collision with root package name */
    public ModelProfileUpdateDelta f15616e;

    /* renamed from: f  reason: collision with root package name */
    public GestureDetector f15617f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15618g;

    /* renamed from: h  reason: collision with root package name */
    public NetworkProfile f15619h;

    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        public boolean onDown(MotionEvent motionEvent) {
            return super.onDown(motionEvent);
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            if (f10 < 0.0f && Math.abs(f10) > Math.abs(f11)) {
                n.this.R0();
            }
            return super.onFling(motionEvent, motionEvent2, f10, f11);
        }
    }

    private void U0(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", this.f15615d.o());
        hashMap.put("screen", Q0());
        hashMap.put("state", str);
        Bakery.w().z().j("Onboarding", hashMap);
    }

    /* access modifiers changed from: protected */
    public abstract String Q0();

    public void R0() {
        if (b0(true)) {
            S0();
        }
    }

    /* access modifiers changed from: protected */
    public void S0() {
        U0("Complete");
        this.f15615d.next();
    }

    public void T0() {
        h hVar = this.f15615d;
        if (hVar != null) {
            hVar.X(b0(false), this);
            U0("View");
        }
    }

    public abstract void V0();

    public void d() {
        ((ActivityLikePassFlow) getActivity()).next();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof h) {
            h hVar = (h) context;
            this.f15615d = hVar;
            this.f15616e = hVar.Y();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.f15619h = M0().j();
        } else {
            this.f15619h = (NetworkProfile) bundle.getSerializable(f15614j);
        }
        this.f15617f = new GestureDetector(getActivity(), new a());
        androidx.fragment.app.h activity = getActivity();
        if (activity instanceof h) {
            h hVar = (h) activity;
            this.f15615d = hVar;
            this.f15616e = hVar.Y();
        }
    }

    public void onResume() {
        super.onResume();
        if (getView() != null && this.f15615d != null) {
            this.f15618g = true;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(f15614j, this.f15619h);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f15618g = true;
        h hVar = this.f15615d;
        if (hVar != null) {
            hVar.Q(this);
        }
    }
}
