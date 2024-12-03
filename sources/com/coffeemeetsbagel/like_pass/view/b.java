package com.coffeemeetsbagel.like_pass.view;

import android.view.View;
import j5.x;
import java.util.List;
import qj.q;

public interface b {
    void a(List<MatchActionType> list, Long l10);

    q<x> b(MatchActionType matchActionType);

    View getView();

    void setCommentButtonImageResource(int i10);

    void setIsEnabled(Boolean bool);

    void setLikeButtonImageResource(int i10);
}
