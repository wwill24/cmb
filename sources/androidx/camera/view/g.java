package androidx.camera.view;

import android.view.View;

public final /* synthetic */ class g implements View.OnLayoutChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreviewView f3487a;

    public /* synthetic */ g(PreviewView previewView) {
        this.f3487a = previewView;
    }

    public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        this.f3487a.d(view, i10, i11, i12, i13, i14, i15, i16, i17);
    }
}
