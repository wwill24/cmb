package com.coffeemeetsbagel.feature.profile_completion_helper.ethnicity;

import android.view.View;
import com.coffeemeetsbagel.feature.likepassflow.RowItemView;
import com.coffeemeetsbagel.models.dto.Option;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EthnicityFragment f13250a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Option f13251b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RowItemView f13252c;

    public /* synthetic */ a(EthnicityFragment ethnicityFragment, Option option, RowItemView rowItemView) {
        this.f13250a = ethnicityFragment;
        this.f13251b = option;
        this.f13252c = rowItemView;
    }

    public final void onClick(View view) {
        EthnicityFragment$onCreateView$1.d(this.f13250a, this.f13251b, this.f13252c, view);
    }
}
