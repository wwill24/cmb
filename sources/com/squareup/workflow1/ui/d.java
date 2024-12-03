package com.squareup.workflow1.ui;

import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/squareup/workflow1/ui/d;", "", "", "c", "()Ljava/lang/String;", "compatibilityKey", "a", "wf1-core-common"}, k = 1, mv = {1, 6, 0})
public interface d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f23236a = a.f23237a;

    @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¨\u0006\b"}, d2 = {"Lcom/squareup/workflow1/ui/d$a;", "", "value", "", "name", "a", "<init>", "()V", "wf1-core-common"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ a f23237a = new a();

        private a() {
        }

        public static /* synthetic */ String b(a aVar, Object obj, String str, int i10, Object obj2) {
            if ((i10 & 2) != 0) {
                str = "";
            }
            return aVar.a(obj, str);
        }

        public final String a(Object obj, String str) {
            d dVar;
            boolean z10;
            String str2;
            j.g(obj, "value");
            j.g(str, "name");
            String str3 = null;
            if (obj instanceof d) {
                dVar = (d) obj;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                str3 = dVar.c();
            }
            if (str3 == null) {
                str3 = obj.getClass().getName();
            }
            if (str.length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                str2 = "";
            } else {
                str2 = j.p("+", str);
            }
            return j.p(str3, str2);
        }
    }

    String c();
}
