package com.withpersona.sdk2.inquiry.ui;

import android.graphics.Bitmap;
import com.squareup.workflow1.h;
import com.squareup.workflow1.i;
import com.squareup.workflow1.j;
import com.squareup.workflow1.l;
import com.squareup.workflow1.o;
import com.withpersona.sdk2.inquiry.steps.ui.components.a;
import com.withpersona.sdk2.inquiry.steps.ui.components.k;
import com.withpersona.sdk2.inquiry.steps.ui.components.m;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$UiStepStyle;
import com.withpersona.sdk2.inquiry.ui.UiState;
import com.withpersona.sdk2.inquiry.ui.UiWorkflow;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.l;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.flow.b;

final class UiWorkflow$render$2 extends Lambda implements Function1<UiComponent, Unit> {
    final /* synthetic */ h<UiWorkflow.a, UiState, UiWorkflow.b, UiWorkflow.c>.a $context;
    final /* synthetic */ UiState $renderState;
    final /* synthetic */ UiWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UiWorkflow$render$2(h<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b, ? extends UiWorkflow.c>.a aVar, UiWorkflow uiWorkflow, UiState uiState) {
        super(1);
        this.$context = aVar;
        this.this$0 = uiWorkflow;
        this.$renderState = uiState;
    }

    public final void a(final UiComponent uiComponent) {
        Class<j> cls = j.class;
        Class<String> cls2 = String.class;
        kotlin.jvm.internal.j.g(uiComponent, "component");
        if (uiComponent instanceof m) {
            h<UiWorkflow.a, UiState, UiWorkflow.b, UiWorkflow.c>.a aVar = this.$context;
            i iVar = new i(l.k(cls2), ((m) uiComponent).a().a());
            String A = uiComponent.A();
            final UiWorkflow uiWorkflow = this.this$0;
            final UiState uiState = this.$renderState;
            o.l(aVar, iVar, l.l(cls, KTypeProjection.f32152c.a(l.k(cls2))), A, new Function1<String, com.squareup.workflow1.l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>>() {
                /* renamed from: a */
                public final com.squareup.workflow1.l<UiWorkflow.a, UiState, UiWorkflow.b> invoke(final String str) {
                    kotlin.jvm.internal.j.g(str, "newText");
                    final UiWorkflow uiWorkflow = uiWorkflow;
                    final UiState uiState = uiState;
                    final UiComponent uiComponent = uiComponent;
                    return Workflows__StatefulWorkflowKt.d(uiWorkflow, (String) null, new Function1<com.squareup.workflow1.l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c, Unit>() {
                        public final void a(com.squareup.workflow1.l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c cVar) {
                            kotlin.jvm.internal.j.g(cVar, "$this$action");
                            UiState uiState = uiState;
                            UiWorkflow uiWorkflow = uiWorkflow;
                            List<UiComponent> components = ((UiState.Displaying) uiState).getComponents();
                            UiComponent uiComponent = uiComponent;
                            cVar.e(UiState.Displaying.c((UiState.Displaying) uiState, uiWorkflow.m(components, uiComponent, ((m) uiComponent).k(str)), (String) null, (List) null, (StepStyles$UiStepStyle) null, (String) null, 30, (Object) null));
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            a((l.c) obj);
                            return Unit.f32013a;
                        }
                    }, 1, (Object) null);
                }
            });
        } else if (uiComponent instanceof com.withpersona.sdk2.inquiry.steps.ui.components.j) {
            h<UiWorkflow.a, UiState, UiWorkflow.b, UiWorkflow.c>.a aVar2 = this.$context;
            i iVar2 = new i(kotlin.jvm.internal.l.k(cls2), ((com.withpersona.sdk2.inquiry.steps.ui.components.j) uiComponent).a().a());
            String A2 = uiComponent.A();
            final UiWorkflow uiWorkflow2 = this.this$0;
            final UiState uiState2 = this.$renderState;
            o.l(aVar2, iVar2, kotlin.jvm.internal.l.l(cls, KTypeProjection.f32152c.a(kotlin.jvm.internal.l.k(cls2))), A2, new Function1<String, com.squareup.workflow1.l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>>() {
                /* renamed from: a */
                public final com.squareup.workflow1.l<UiWorkflow.a, UiState, UiWorkflow.b> invoke(final String str) {
                    kotlin.jvm.internal.j.g(str, "newText");
                    final UiWorkflow uiWorkflow = uiWorkflow2;
                    final UiState uiState = uiState2;
                    final UiComponent uiComponent = uiComponent;
                    return Workflows__StatefulWorkflowKt.d(uiWorkflow, (String) null, new Function1<com.squareup.workflow1.l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c, Unit>() {
                        public final void a(com.squareup.workflow1.l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c cVar) {
                            kotlin.jvm.internal.j.g(cVar, "$this$action");
                            UiState uiState = uiState;
                            UiWorkflow uiWorkflow = uiWorkflow;
                            List<UiComponent> components = ((UiState.Displaying) uiState).getComponents();
                            UiComponent uiComponent = uiComponent;
                            cVar.e(UiState.Displaying.c((UiState.Displaying) uiState, uiWorkflow.m(components, uiComponent, ((com.withpersona.sdk2.inquiry.steps.ui.components.j) uiComponent).c(StringsKt__StringsKt.C0(str, new String[]{com.withpersona.sdk2.inquiry.steps.ui.components.j.f27586r.a()}, false, 0, 6, (Object) null))), (String) null, (List) null, (StepStyles$UiStepStyle) null, (String) null, 30, (Object) null));
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            a((l.c) obj);
                            return Unit.f32013a;
                        }
                    }, 1, (Object) null);
                }
            });
        } else if (uiComponent instanceof a) {
            final UiWorkflow uiWorkflow3 = this.this$0;
            final UiState uiState3 = this.$renderState;
            AnonymousClass3 r52 = new Function1<String, com.squareup.workflow1.l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>>() {
                /* renamed from: a */
                public final com.squareup.workflow1.l<UiWorkflow.a, UiState, UiWorkflow.b> invoke(final String str) {
                    kotlin.jvm.internal.j.g(str, "newText");
                    final UiWorkflow uiWorkflow = uiWorkflow3;
                    final UiState uiState = uiState3;
                    final UiComponent uiComponent = uiComponent;
                    return Workflows__StatefulWorkflowKt.d(uiWorkflow, (String) null, new Function1<com.squareup.workflow1.l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c, Unit>() {
                        public final void a(com.squareup.workflow1.l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c cVar) {
                            kotlin.jvm.internal.j.g(cVar, "$this$action");
                            UiState uiState = uiState;
                            UiWorkflow uiWorkflow = uiWorkflow;
                            List<UiComponent> components = ((UiState.Displaying) uiState).getComponents();
                            UiComponent uiComponent = uiComponent;
                            cVar.e(UiState.Displaying.c((UiState.Displaying) uiState, uiWorkflow.m(components, uiComponent, ((a) uiComponent).u(str).P(str)), (String) null, (List) null, (StepStyles$UiStepStyle) null, (String) null, 30, (Object) null));
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            a((l.c) obj);
                            return Unit.f32013a;
                        }
                    }, 1, (Object) null);
                }
            };
            KTypeProjection.a aVar3 = KTypeProjection.f32152c;
            o.l(this.$context, new i(kotlin.jvm.internal.l.k(cls2), ((a) uiComponent).n().a()), kotlin.jvm.internal.l.l(cls, aVar3.a(kotlin.jvm.internal.l.k(cls2))), uiComponent.A() + "UpdateAddressStreet1", r52);
            a aVar4 = (a) uiComponent;
            final UiWorkflow uiWorkflow4 = this.this$0;
            final UiState uiState4 = this.$renderState;
            o.l(this.$context, new i(kotlin.jvm.internal.l.k(cls2), aVar4.r().a()), kotlin.jvm.internal.l.l(cls, aVar3.a(kotlin.jvm.internal.l.k(cls2))), uiComponent.A() + "UpdateAddressStreet2", new Function1<String, com.squareup.workflow1.l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>>() {
                /* renamed from: a */
                public final com.squareup.workflow1.l<UiWorkflow.a, UiState, UiWorkflow.b> invoke(final String str) {
                    kotlin.jvm.internal.j.g(str, "newText");
                    final UiWorkflow uiWorkflow = uiWorkflow4;
                    final UiState uiState = uiState4;
                    final UiComponent uiComponent = uiComponent;
                    return Workflows__StatefulWorkflowKt.d(uiWorkflow, (String) null, new Function1<com.squareup.workflow1.l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c, Unit>() {
                        public final void a(com.squareup.workflow1.l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c cVar) {
                            kotlin.jvm.internal.j.g(cVar, "$this$action");
                            UiState uiState = uiState;
                            UiWorkflow uiWorkflow = uiWorkflow;
                            List<UiComponent> components = ((UiState.Displaying) uiState).getComponents();
                            UiComponent uiComponent = uiComponent;
                            cVar.e(UiState.Displaying.c((UiState.Displaying) uiState, uiWorkflow.m(components, uiComponent, ((a) uiComponent).i(str)), (String) null, (List) null, (StepStyles$UiStepStyle) null, (String) null, 30, (Object) null));
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            a((l.c) obj);
                            return Unit.f32013a;
                        }
                    }, 1, (Object) null);
                }
            });
            final UiWorkflow uiWorkflow5 = this.this$0;
            final UiState uiState5 = this.$renderState;
            o.l(this.$context, new i(kotlin.jvm.internal.l.k(cls2), aVar4.d().a()), kotlin.jvm.internal.l.l(cls, aVar3.a(kotlin.jvm.internal.l.k(cls2))), uiComponent.A() + "UpdateAddressCity", new Function1<String, com.squareup.workflow1.l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>>() {
                /* renamed from: a */
                public final com.squareup.workflow1.l<UiWorkflow.a, UiState, UiWorkflow.b> invoke(final String str) {
                    kotlin.jvm.internal.j.g(str, "newText");
                    final UiWorkflow uiWorkflow = uiWorkflow5;
                    final UiState uiState = uiState5;
                    final UiComponent uiComponent = uiComponent;
                    return Workflows__StatefulWorkflowKt.d(uiWorkflow, (String) null, new Function1<com.squareup.workflow1.l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c, Unit>() {
                        public final void a(com.squareup.workflow1.l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c cVar) {
                            kotlin.jvm.internal.j.g(cVar, "$this$action");
                            UiState uiState = uiState;
                            UiWorkflow uiWorkflow = uiWorkflow;
                            List<UiComponent> components = ((UiState.Displaying) uiState).getComponents();
                            UiComponent uiComponent = uiComponent;
                            cVar.e(UiState.Displaying.c((UiState.Displaying) uiState, uiWorkflow.m(components, uiComponent, ((a) uiComponent).m(str)), (String) null, (List) null, (StepStyles$UiStepStyle) null, (String) null, 30, (Object) null));
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            a((l.c) obj);
                            return Unit.f32013a;
                        }
                    }, 1, (Object) null);
                }
            });
            final UiWorkflow uiWorkflow6 = this.this$0;
            final UiState uiState6 = this.$renderState;
            o.l(this.$context, new i(kotlin.jvm.internal.l.k(cls2), aVar4.f().a()), kotlin.jvm.internal.l.l(cls, aVar3.a(kotlin.jvm.internal.l.k(cls2))), uiComponent.A() + "UpdateAddressSubdivision", new Function1<String, com.squareup.workflow1.l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>>() {
                /* renamed from: a */
                public final com.squareup.workflow1.l<UiWorkflow.a, UiState, UiWorkflow.b> invoke(final String str) {
                    kotlin.jvm.internal.j.g(str, "newText");
                    final UiWorkflow uiWorkflow = uiWorkflow6;
                    final UiState uiState = uiState6;
                    final UiComponent uiComponent = uiComponent;
                    return Workflows__StatefulWorkflowKt.d(uiWorkflow, (String) null, new Function1<com.squareup.workflow1.l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c, Unit>() {
                        public final void a(com.squareup.workflow1.l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c cVar) {
                            kotlin.jvm.internal.j.g(cVar, "$this$action");
                            UiState uiState = uiState;
                            UiWorkflow uiWorkflow = uiWorkflow;
                            List<UiComponent> components = ((UiState.Displaying) uiState).getComponents();
                            UiComponent uiComponent = uiComponent;
                            cVar.e(UiState.Displaying.c((UiState.Displaying) uiState, uiWorkflow.m(components, uiComponent, ((a) uiComponent).x(str)), (String) null, (List) null, (StepStyles$UiStepStyle) null, (String) null, 30, (Object) null));
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            a((l.c) obj);
                            return Unit.f32013a;
                        }
                    }, 1, (Object) null);
                }
            });
            final UiWorkflow uiWorkflow7 = this.this$0;
            final UiState uiState7 = this.$renderState;
            o.l(this.$context, new i(kotlin.jvm.internal.l.k(cls2), aVar4.e().a()), kotlin.jvm.internal.l.l(cls, aVar3.a(kotlin.jvm.internal.l.k(cls2))), uiComponent.A() + "UpdateAddressPostalCode", new Function1<String, com.squareup.workflow1.l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>>() {
                /* renamed from: a */
                public final com.squareup.workflow1.l<UiWorkflow.a, UiState, UiWorkflow.b> invoke(final String str) {
                    kotlin.jvm.internal.j.g(str, "newText");
                    final UiWorkflow uiWorkflow = uiWorkflow7;
                    final UiState uiState = uiState7;
                    final UiComponent uiComponent = uiComponent;
                    return Workflows__StatefulWorkflowKt.d(uiWorkflow, (String) null, new Function1<com.squareup.workflow1.l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c, Unit>() {
                        public final void a(com.squareup.workflow1.l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c cVar) {
                            kotlin.jvm.internal.j.g(cVar, "$this$action");
                            UiState uiState = uiState;
                            UiWorkflow uiWorkflow = uiWorkflow;
                            List<UiComponent> components = ((UiState.Displaying) uiState).getComponents();
                            UiComponent uiComponent = uiComponent;
                            cVar.e(UiState.Displaying.c((UiState.Displaying) uiState, uiWorkflow.m(components, uiComponent, ((a) uiComponent).s(str)), (String) null, (List) null, (StepStyles$UiStepStyle) null, (String) null, 30, (Object) null));
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            a((l.c) obj);
                            return Unit.f32013a;
                        }
                    }, 1, (Object) null);
                }
            });
        } else if (uiComponent instanceof k) {
            h<UiWorkflow.a, UiState, UiWorkflow.b, UiWorkflow.c>.a aVar5 = this.$context;
            b<Boolean> a10 = ((k) uiComponent).j().a();
            Class cls3 = Boolean.TYPE;
            i iVar3 = new i(kotlin.jvm.internal.l.k(cls3), a10);
            String A3 = uiComponent.A();
            final UiWorkflow uiWorkflow8 = this.this$0;
            final UiState uiState8 = this.$renderState;
            o.l(aVar5, iVar3, kotlin.jvm.internal.l.l(cls, KTypeProjection.f32152c.a(kotlin.jvm.internal.l.k(cls3))), A3, new Function1<Boolean, com.squareup.workflow1.l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>>() {
                public final com.squareup.workflow1.l<UiWorkflow.a, UiState, UiWorkflow.b> a(final boolean z10) {
                    final UiWorkflow uiWorkflow = uiWorkflow8;
                    final UiState uiState = uiState8;
                    final UiComponent uiComponent = uiComponent;
                    return Workflows__StatefulWorkflowKt.d(uiWorkflow, (String) null, new Function1<com.squareup.workflow1.l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c, Unit>() {
                        public final void a(com.squareup.workflow1.l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c cVar) {
                            kotlin.jvm.internal.j.g(cVar, "$this$action");
                            UiState uiState = uiState;
                            UiWorkflow uiWorkflow = uiWorkflow;
                            List<UiComponent> components = ((UiState.Displaying) uiState).getComponents();
                            UiComponent uiComponent = uiComponent;
                            cVar.e(UiState.Displaying.c((UiState.Displaying) uiState, uiWorkflow.m(components, uiComponent, ((k) uiComponent).g(z10)), (String) null, (List) null, (StepStyles$UiStepStyle) null, (String) null, 30, (Object) null));
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            a((l.c) obj);
                            return Unit.f32013a;
                        }
                    }, 1, (Object) null);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return a(((Boolean) obj).booleanValue());
                }
            });
        } else if (uiComponent instanceof com.withpersona.sdk2.inquiry.steps.ui.components.l) {
            h<UiWorkflow.a, UiState, UiWorkflow.b, UiWorkflow.c>.a aVar6 = this.$context;
            i iVar4 = new i(kotlin.jvm.internal.l.k(cls2), ((com.withpersona.sdk2.inquiry.steps.ui.components.l) uiComponent).a().a());
            String A4 = uiComponent.A();
            final UiWorkflow uiWorkflow9 = this.this$0;
            final UiState uiState9 = this.$renderState;
            o.l(aVar6, iVar4, kotlin.jvm.internal.l.l(cls, KTypeProjection.f32152c.a(kotlin.jvm.internal.l.k(cls2))), A4, new Function1<String, com.squareup.workflow1.l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>>() {
                /* renamed from: a */
                public final com.squareup.workflow1.l<UiWorkflow.a, UiState, UiWorkflow.b> invoke(final String str) {
                    kotlin.jvm.internal.j.g(str, "newValue");
                    final UiWorkflow uiWorkflow = uiWorkflow9;
                    final UiState uiState = uiState9;
                    final UiComponent uiComponent = uiComponent;
                    return Workflows__StatefulWorkflowKt.d(uiWorkflow, (String) null, new Function1<com.squareup.workflow1.l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c, Unit>() {
                        public final void a(com.squareup.workflow1.l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c cVar) {
                            kotlin.jvm.internal.j.g(cVar, "$this$action");
                            UiState uiState = uiState;
                            UiWorkflow uiWorkflow = uiWorkflow;
                            List<UiComponent> components = ((UiState.Displaying) uiState).getComponents();
                            UiComponent uiComponent = uiComponent;
                            cVar.e(UiState.Displaying.c((UiState.Displaying) uiState, uiWorkflow.m(components, uiComponent, ((com.withpersona.sdk2.inquiry.steps.ui.components.l) uiComponent).q(p.i(str))), (String) null, (List) null, (StepStyles$UiStepStyle) null, (String) null, 30, (Object) null));
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            a((l.c) obj);
                            return Unit.f32013a;
                        }
                    }, 1, (Object) null);
                }
            });
        } else if (uiComponent instanceof com.withpersona.sdk2.inquiry.steps.ui.components.b) {
            h<UiWorkflow.a, UiState, UiWorkflow.b, UiWorkflow.c>.a aVar7 = this.$context;
            i iVar5 = new i(kotlin.jvm.internal.l.e(Bitmap.class), ((com.withpersona.sdk2.inquiry.steps.ui.components.b) uiComponent).h().a());
            String A5 = uiComponent.A();
            final UiWorkflow uiWorkflow10 = this.this$0;
            final UiState uiState10 = this.$renderState;
            o.l(aVar7, iVar5, kotlin.jvm.internal.l.l(cls, KTypeProjection.f32152c.a(kotlin.jvm.internal.l.e(Bitmap.class))), A5, new Function1<Bitmap, com.squareup.workflow1.l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>>() {
                /* renamed from: a */
                public final com.squareup.workflow1.l<UiWorkflow.a, UiState, UiWorkflow.b> invoke(final Bitmap bitmap) {
                    final UiWorkflow uiWorkflow = uiWorkflow10;
                    final UiState uiState = uiState10;
                    final UiComponent uiComponent = uiComponent;
                    return Workflows__StatefulWorkflowKt.d(uiWorkflow, (String) null, new Function1<com.squareup.workflow1.l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c, Unit>() {
                        public final void a(com.squareup.workflow1.l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c cVar) {
                            kotlin.jvm.internal.j.g(cVar, "$this$action");
                            UiState uiState = uiState;
                            UiWorkflow uiWorkflow = uiWorkflow;
                            List<UiComponent> components = ((UiState.Displaying) uiState).getComponents();
                            UiComponent uiComponent = uiComponent;
                            cVar.e(UiState.Displaying.c((UiState.Displaying) uiState, uiWorkflow.m(components, uiComponent, ((com.withpersona.sdk2.inquiry.steps.ui.components.b) uiComponent).o(bitmap)), (String) null, (List) null, (StepStyles$UiStepStyle) null, (String) null, 30, (Object) null));
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            a((l.c) obj);
                            return Unit.f32013a;
                        }
                    }, 1, (Object) null);
                }
            });
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((UiComponent) obj);
        return Unit.f32013a;
    }
}
