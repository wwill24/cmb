package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

class w {
    static int a(RecyclerView.z zVar, t tVar, View view, View view2, RecyclerView.o oVar, boolean z10) {
        if (oVar.K() == 0 || zVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z10) {
            return Math.abs(oVar.i0(view) - oVar.i0(view2)) + 1;
        }
        return Math.min(tVar.n(), tVar.d(view2) - tVar.g(view));
    }

    static int b(RecyclerView.z zVar, t tVar, View view, View view2, RecyclerView.o oVar, boolean z10, boolean z11) {
        int i10;
        if (oVar.K() == 0 || zVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(oVar.i0(view), oVar.i0(view2));
        int max = Math.max(oVar.i0(view), oVar.i0(view2));
        if (z11) {
            i10 = Math.max(0, (zVar.b() - max) - 1);
        } else {
            i10 = Math.max(0, min);
        }
        if (!z10) {
            return i10;
        }
        return Math.round((((float) i10) * (((float) Math.abs(tVar.d(view2) - tVar.g(view))) / ((float) (Math.abs(oVar.i0(view) - oVar.i0(view2)) + 1)))) + ((float) (tVar.m() - tVar.g(view))));
    }

    static int c(RecyclerView.z zVar, t tVar, View view, View view2, RecyclerView.o oVar, boolean z10) {
        if (oVar.K() == 0 || zVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z10) {
            return zVar.b();
        }
        return (int) ((((float) (tVar.d(view2) - tVar.g(view))) / ((float) (Math.abs(oVar.i0(view) - oVar.i0(view2)) + 1))) * ((float) zVar.b()));
    }
}
