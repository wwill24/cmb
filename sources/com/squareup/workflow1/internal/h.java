package com.squareup.workflow1.internal;

import com.squareup.workflow1.WorkflowIdentifier;
import com.squareup.workflow1.g;
import com.squareup.workflow1.k;
import com.squareup.workflow1.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import okio.Buffer;
import okio.ByteString;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\b\u0018\u0000 \u00072\u00020\u0001:\u0001\u0011B\u0019\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001aB'\b\u0016\u0012\u0012\u0010\u001b\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001cJ\"\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0003\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u000b\u001a\u00020\u0004HÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\u0014\u001a\u00020\u00108\u0000X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u00048\u0000X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/squareup/workflow1/internal/h;", "", "Lcom/squareup/workflow1/k;", "otherWorkflow", "", "otherName", "", "c", "Lokio/ByteString;", "d", "()Lokio/ByteString;", "toString", "", "hashCode", "other", "equals", "Lcom/squareup/workflow1/WorkflowIdentifier;", "a", "Lcom/squareup/workflow1/WorkflowIdentifier;", "()Lcom/squareup/workflow1/WorkflowIdentifier;", "identifier", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "name", "<init>", "(Lcom/squareup/workflow1/WorkflowIdentifier;Ljava/lang/String;)V", "workflow", "(Lcom/squareup/workflow1/k;Ljava/lang/String;)V", "wf1-workflow-runtime"}, k = 1, mv = {1, 6, 0})
public final class h {

    /* renamed from: c  reason: collision with root package name */
    public static final a f23135c = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final WorkflowIdentifier f23136a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23137b;

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/squareup/workflow1/internal/h$a;", "", "Lokio/ByteString;", "bytes", "Lcom/squareup/workflow1/internal/h;", "a", "<init>", "()V", "wf1-workflow-runtime"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final h a(ByteString byteString) {
            j.g(byteString, "bytes");
            Buffer buffer = new Buffer();
            buffer.K1(byteString);
            return new h(WorkflowIdentifier.f23065f.a(g.a(buffer)), g.b(buffer));
        }
    }

    public h(WorkflowIdentifier workflowIdentifier, String str) {
        j.g(workflowIdentifier, "identifier");
        j.g(str, "name");
        this.f23136a = workflowIdentifier;
        this.f23137b = str;
    }

    public final WorkflowIdentifier a() {
        return this.f23136a;
    }

    public final String b() {
        return this.f23137b;
    }

    public final boolean c(k<?, ?, ?> kVar, String str) {
        j.g(kVar, "otherWorkflow");
        j.g(str, "otherName");
        return j.b(this.f23136a, o.j(kVar)) && j.b(this.f23137b, str);
    }

    public final ByteString d() {
        ByteString e10 = this.f23136a.e();
        if (e10 == null) {
            return null;
        }
        Buffer buffer = new Buffer();
        g.c(buffer, e10);
        g.d(buffer, b());
        return buffer.y1();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return j.b(this.f23136a, hVar.f23136a) && j.b(this.f23137b, hVar.f23137b);
    }

    public int hashCode() {
        return (this.f23136a.hashCode() * 31) + this.f23137b.hashCode();
    }

    public String toString() {
        return "WorkflowNodeId(identifier=" + this.f23136a + ", name=" + this.f23137b + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public h(k<?, ?, ?> kVar, String str) {
        this(o.j(kVar), str);
        j.g(kVar, "workflow");
        j.g(str, "name");
    }
}
