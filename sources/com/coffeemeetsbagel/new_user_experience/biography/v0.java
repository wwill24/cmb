package com.coffeemeetsbagel.new_user_experience.biography;

import android.view.View;
import android.widget.AdapterView;
import com.coffeemeetsbagel.cmb_views.DelayAutoCompleteTextView;

public final /* synthetic */ class v0 implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DelayAutoCompleteTextView f34900a;

    public /* synthetic */ v0(DelayAutoCompleteTextView delayAutoCompleteTextView) {
        this.f34900a = delayAutoCompleteTextView;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
        BiographyPresenter.U(this.f34900a, adapterView, view, i10, j10);
    }
}
