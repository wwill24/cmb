package androidx.databinding.library.baseAdapters;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import java.util.ArrayList;
import java.util.List;

public class DataBinderMapperImpl extends e {

    /* renamed from: a  reason: collision with root package name */
    private static final SparseIntArray f4997a = new SparseIntArray(0);

    public List<e> a() {
        return new ArrayList(0);
    }

    public ViewDataBinding b(f fVar, View view, int i10) {
        if (f4997a.get(i10) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public ViewDataBinding c(f fVar, View[] viewArr, int i10) {
        if (viewArr == null || viewArr.length == 0 || f4997a.get(i10) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
