package com.squareup.workflow1.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u001e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000*F\b\u0007\u0010\t\u001a\u0004\b\u0000\u0010\u0006\"\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u00072\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007¨\u0006\n"}, d2 = {"Landroid/content/Context;", "Landroid/view/ViewGroup;", "container", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "a", "BindingT", "Lkotlin/Function3;", "", "ViewBindingInflater", "wf1-core-android"}, k = 2, mv = {1, 6, 0})
public final class g {
    public static final LayoutInflater a(Context context, ViewGroup viewGroup) {
        Context context2;
        j.g(context, "<this>");
        if (viewGroup == null || (context2 = viewGroup.getContext()) == null) {
            context2 = context;
        }
        return LayoutInflater.from(context2).cloneInContext(context);
    }
}
