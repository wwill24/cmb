package com.coffeemeetsbagel.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import b6.n;
import com.coffeemeetsbagel.R;
import com.uber.autodispose.p;
import java.util.concurrent.TimeUnit;
import qj.q;
import sj.a;

public class g1 extends n {

    /* renamed from: d  reason: collision with root package name */
    private static float[] f13687d;

    /* renamed from: c  reason: collision with root package name */
    private ImageView[] f13688c;

    /* access modifiers changed from: private */
    public /* synthetic */ void D0(Long l10) throws Exception {
        long j10;
        Long valueOf = Long.valueOf(l10.longValue() % 4);
        for (int i10 = 0; i10 < 4; i10++) {
            ImageView imageView = this.f13688c[i10];
            long j11 = (long) i10;
            if (j11 - valueOf.longValue() < 0) {
                j10 = (j11 - valueOf.longValue()) + 4;
            } else {
                j10 = j11 - valueOf.longValue();
            }
            imageView.setAlpha(f13687d[(int) (j10 % 4)]);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f13687d = new float[]{1.0f, 0.2f, 0.2f, 0.2f};
        ((p) q.T(300, TimeUnit.MILLISECONDS).a0(a.a()).g(com.uber.autodispose.a.a(this))).c(new f1(this));
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_loading_dls, viewGroup, false);
        ImageView[] imageViewArr = new ImageView[4];
        this.f13688c = imageViewArr;
        imageViewArr[0] = (ImageView) inflate.findViewById(R.id.imageView_dot0);
        this.f13688c[1] = (ImageView) inflate.findViewById(R.id.imageView_dot1);
        this.f13688c[2] = (ImageView) inflate.findViewById(R.id.imageView_dot2);
        this.f13688c[3] = (ImageView) inflate.findViewById(R.id.imageView_dot3);
        return inflate;
    }
}
