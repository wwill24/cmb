package com.coffeemeetsbagel;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import java.util.ArrayList;
import java.util.List;
import k6.n;
import k6.p;
import k6.r;

public class DataBinderMapperImpl extends e {

    /* renamed from: a  reason: collision with root package name */
    private static final SparseIntArray f10835a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(3);
        f10835a = sparseIntArray;
        sparseIntArray.put(R.layout.fragment_my_profile_details_dls, 1);
        sparseIntArray.put(R.layout.fragment_my_profile_details_edit_text_dls, 2);
        sparseIntArray.put(R.layout.fragment_my_profile_details_text_dls, 3);
    }

    public List<e> a() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    public ViewDataBinding b(f fVar, View view, int i10) {
        int i11 = f10835a.get(i10);
        if (i11 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        } else if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    return null;
                }
                if ("layout/fragment_my_profile_details_text_dls_0".equals(tag)) {
                    return new r(fVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_my_profile_details_text_dls is invalid. Received: " + tag);
            } else if ("layout/fragment_my_profile_details_edit_text_dls_0".equals(tag)) {
                return new p(fVar, view);
            } else {
                throw new IllegalArgumentException("The tag for fragment_my_profile_details_edit_text_dls is invalid. Received: " + tag);
            }
        } else if ("layout/fragment_my_profile_details_dls_0".equals(tag)) {
            return new n(fVar, view);
        } else {
            throw new IllegalArgumentException("The tag for fragment_my_profile_details_dls is invalid. Received: " + tag);
        }
    }

    public ViewDataBinding c(f fVar, View[] viewArr, int i10) {
        if (viewArr == null || viewArr.length == 0 || f10835a.get(i10) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
