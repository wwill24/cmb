package com.squareup.workflow1.ui;

import androidx.lifecycle.a0;
import com.squareup.workflow1.RenderWorkflowKt;
import com.squareup.workflow1.TreeSnapshot;
import com.squareup.workflow1.e;
import com.squareup.workflow1.k;
import com.squareup.workflow1.m;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.flow.p;
import kotlinx.coroutines.flow.r;
import kotlinx.coroutines.k0;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a\u0001\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00020\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2$\b\u0002\u0010\u0012\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"PropsT", "OutputT", "RenderingT", "Lcom/squareup/workflow1/k;", "workflow", "Lkotlinx/coroutines/k0;", "scope", "Lkotlinx/coroutines/flow/r;", "props", "Landroidx/lifecycle/a0;", "savedStateHandle", "", "Lcom/squareup/workflow1/m;", "interceptors", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "", "onOutput", "a", "(Lcom/squareup/workflow1/k;Lkotlinx/coroutines/k0;Lkotlinx/coroutines/flow/r;Landroidx/lifecycle/a0;Ljava/util/List;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/r;", "wf1-core-android"}, k = 2, mv = {1, 6, 0})
public final class AndroidRenderWorkflowKt {
    public static final <PropsT, OutputT, RenderingT> r<RenderingT> a(k<? super PropsT, ? extends OutputT, ? extends RenderingT> kVar, k0 k0Var, r<? extends PropsT> rVar, a0 a0Var, List<? extends m> list, Function2<? super OutputT, ? super c<? super Unit>, ? extends Object> function2) {
        TreeSnapshot treeSnapshot;
        PickledTreesnapshot pickledTreesnapshot;
        j.g(kVar, "workflow");
        j.g(k0Var, "scope");
        j.g(rVar, "props");
        j.g(list, "interceptors");
        j.g(function2, "onOutput");
        if (a0Var == null || (pickledTreesnapshot = (PickledTreesnapshot) a0Var.e("com.squareup.workflow1.ui.renderWorkflowIn-snapshot")) == null) {
            treeSnapshot = null;
        } else {
            treeSnapshot = pickledTreesnapshot.a();
        }
        r<e<RenderingT>> a10 = RenderWorkflowKt.a(kVar, k0Var, rVar, treeSnapshot, list, function2);
        return d.F(new AndroidRenderWorkflowKt$renderWorkflowIn$$inlined$map$1(d.D(a10, new AndroidRenderWorkflowKt$renderWorkflowIn$4(a0Var, (c<? super AndroidRenderWorkflowKt$renderWorkflowIn$4>) null))), k0Var, p.f32480a.a(), a10.getValue().a());
    }
}
