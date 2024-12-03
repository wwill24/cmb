package com.coffeemeetsbagel.likes_you;

import com.coffeemeetsbagel.likesyou.LikesYouNetworkGroup;
import com.coffeemeetsbagel.likesyou.NetworkContextualRecommendation;
import com.coffeemeetsbagel.likesyou.NetworkEmptyState;
import com.coffeemeetsbagel.models.entities.LikesYouGroupEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final i f34204a = new i();

    private i() {
    }

    public final List<LikesYouGroupEntity> a(List<LikesYouNetworkGroup> list) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        List<LikesYouNetworkGroup> list2 = list;
        j.g(list2, "networkGroups");
        ArrayList arrayList = new ArrayList(r.t(list2, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            LikesYouNetworkGroup likesYouNetworkGroup = (LikesYouNetworkGroup) it.next();
            String id2 = likesYouNetworkGroup.getId();
            String name = likesYouNetworkGroup.getName();
            int count = likesYouNetworkGroup.getCount();
            int groupOrdinal = likesYouNetworkGroup.getGroupOrdinal();
            List<String> freeProfileIds = likesYouNetworkGroup.getFreeProfileIds();
            Integer maxDisplayCount = likesYouNetworkGroup.getMaxDisplayCount();
            NetworkContextualRecommendation contextualRecommendation = likesYouNetworkGroup.getContextualRecommendation();
            if (contextualRecommendation != null) {
                str = contextualRecommendation.getIconUrl();
            } else {
                str = null;
            }
            NetworkContextualRecommendation contextualRecommendation2 = likesYouNetworkGroup.getContextualRecommendation();
            if (contextualRecommendation2 != null) {
                str2 = contextualRecommendation2.getTitleText();
            } else {
                str2 = null;
            }
            NetworkContextualRecommendation contextualRecommendation3 = likesYouNetworkGroup.getContextualRecommendation();
            if (contextualRecommendation3 != null) {
                str3 = contextualRecommendation3.getDescriptionText();
            } else {
                str3 = null;
            }
            NetworkEmptyState emptyState = likesYouNetworkGroup.getEmptyState();
            if (emptyState != null) {
                str4 = emptyState.getAction();
            } else {
                str4 = null;
            }
            NetworkEmptyState emptyState2 = likesYouNetworkGroup.getEmptyState();
            if (emptyState2 != null) {
                str5 = emptyState2.getCallToActionText();
            } else {
                str5 = null;
            }
            NetworkEmptyState emptyState3 = likesYouNetworkGroup.getEmptyState();
            if (emptyState3 != null) {
                str6 = emptyState3.getDescriptionText();
            } else {
                str6 = null;
            }
            NetworkEmptyState emptyState4 = likesYouNetworkGroup.getEmptyState();
            if (emptyState4 != null) {
                str7 = emptyState4.getImageUrl();
            } else {
                str7 = null;
            }
            NetworkEmptyState emptyState5 = likesYouNetworkGroup.getEmptyState();
            if (emptyState5 != null) {
                str8 = emptyState5.getTitleText();
            } else {
                str8 = null;
            }
            Iterator<T> it2 = it;
            LikesYouGroupEntity likesYouGroupEntity = r3;
            LikesYouGroupEntity likesYouGroupEntity2 = new LikesYouGroupEntity(id2, name, count, groupOrdinal, freeProfileIds, maxDisplayCount, str, str2, str3, str4, str5, str6, str7, str8);
            arrayList.add(likesYouGroupEntity);
            it = it2;
        }
        return arrayList;
    }
}
