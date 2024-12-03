package com.coffeemeetsbagel.feature_flag_toggle.interactor;

import android.widget.Filter;
import com.coffeemeetsbagel.features.models.FeatureFlag;
import java.util.ArrayList;
import java.util.List;

public class d extends Filter {

    /* renamed from: a  reason: collision with root package name */
    private final e f13473a;

    /* renamed from: b  reason: collision with root package name */
    private final List<FeatureFlag> f13474b;

    public d(e eVar, List<FeatureFlag> list) {
        ArrayList arrayList = new ArrayList();
        this.f13474b = arrayList;
        this.f13473a = eVar;
        arrayList.addAll(list);
    }

    public void a(List<FeatureFlag> list) {
        this.f13474b.clear();
        this.f13474b.addAll(list);
    }

    /* access modifiers changed from: protected */
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (charSequence == null || charSequence.length() <= 0) {
            filterResults.count = this.f13474b.size();
            filterResults.values = this.f13474b;
        } else {
            String upperCase = charSequence.toString().toUpperCase();
            ArrayList arrayList = new ArrayList();
            for (FeatureFlag next : this.f13474b) {
                if (next.getKey().toUpperCase().contains(upperCase)) {
                    arrayList.add(next);
                }
            }
            filterResults.count = arrayList.size();
            filterResults.values = arrayList;
        }
        return filterResults;
    }

    /* access modifiers changed from: protected */
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        this.f13473a.I((List) filterResults.values);
        this.f13473a.l();
    }
}
