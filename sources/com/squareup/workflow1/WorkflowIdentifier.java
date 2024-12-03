package com.squareup.workflow1;

import gk.f;
import java.io.EOFException;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.sequences.Sequence;
import okio.Buffer;
import okio.ByteString;
import org.apache.commons.beanutils.PropertyUtils;
import wk.c;
import wk.m;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001\fB1\b\u0000\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0000\u0012\u0012\b\u0002\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00008\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0019\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00000\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001b¨\u0006 "}, d2 = {"Lcom/squareup/workflow1/WorkflowIdentifier;", "", "Lokio/ByteString;", "e", "", "toString", "other", "", "equals", "", "hashCode", "Lwk/a;", "a", "Lwk/a;", "type", "b", "Lcom/squareup/workflow1/WorkflowIdentifier;", "proxiedIdentifier", "Lkotlin/Function0;", "c", "Lkotlin/jvm/functions/Function0;", "description", "d", "Lgk/f;", "()Ljava/lang/String;", "typeName", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/Sequence;", "proxiedIdentifiers", "<init>", "(Lwk/a;Lcom/squareup/workflow1/WorkflowIdentifier;Lkotlin/jvm/functions/Function0;)V", "f", "wf1-workflow-core"}, k = 1, mv = {1, 6, 0})
public final class WorkflowIdentifier {

    /* renamed from: f  reason: collision with root package name */
    public static final a f23065f = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final wk.a f23066a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final WorkflowIdentifier f23067b;

    /* renamed from: c  reason: collision with root package name */
    private final Function0<String> f23068c;

    /* renamed from: d  reason: collision with root package name */
    private final f f23069d;

    /* renamed from: e  reason: collision with root package name */
    private final Sequence<WorkflowIdentifier> f23070e;

    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\b¨\u0006\f"}, d2 = {"Lcom/squareup/workflow1/WorkflowIdentifier$a;", "", "Lokio/ByteString;", "bytes", "Lcom/squareup/workflow1/WorkflowIdentifier;", "a", "", "NO_PROXY_IDENTIFIER_TAG", "B", "PROXY_IDENTIFIER_TAG", "<init>", "()V", "wf1-workflow-core"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WorkflowIdentifier a(ByteString byteString) {
            WorkflowIdentifier a10;
            j.g(byteString, "bytes");
            Buffer buffer = new Buffer();
            buffer.K1(byteString);
            try {
                String b10 = g.b(buffer);
                byte readByte = buffer.readByte();
                if (readByte == 0) {
                    a10 = null;
                } else if (readByte == 1) {
                    a10 = WorkflowIdentifier.f23065f.a(buffer.y1());
                } else {
                    throw new IllegalArgumentException("Invalid WorkflowIdentifier");
                }
                return new WorkflowIdentifier(ok.a.c(Class.forName(b10)), a10, (Function0) null, 4, (DefaultConstructorMarker) null);
            } catch (EOFException unused) {
                throw new IllegalArgumentException("Invalid WorkflowIdentifier");
            }
        }
    }

    public WorkflowIdentifier(wk.a aVar, WorkflowIdentifier workflowIdentifier, Function0<String> function0) {
        j.g(aVar, "type");
        this.f23066a = aVar;
        this.f23067b = workflowIdentifier;
        this.f23068c = function0;
        if ((aVar instanceof c) || ((aVar instanceof m) && (((m) aVar).a() instanceof c))) {
            this.f23069d = b.a(LazyThreadSafetyMode.PUBLICATION, new WorkflowIdentifier$typeName$2(this));
            this.f23070e = SequencesKt__SequencesKt.e(this, WorkflowIdentifier$proxiedIdentifiers$1.f23071a);
            return;
        }
        throw new IllegalArgumentException(j.p("Expected type to be either a KClass or a KType with a KClass classifier, but was ", aVar).toString());
    }

    /* access modifiers changed from: private */
    public final String d() {
        Object value = this.f23069d.getValue();
        j.f(value, "<get-typeName>(...)");
        return (String) value;
    }

    public final ByteString e() {
        ByteString byteString = null;
        if (!(this.f23066a instanceof c)) {
            return null;
        }
        WorkflowIdentifier workflowIdentifier = this.f23067b;
        if (workflowIdentifier != null) {
            ByteString e10 = workflowIdentifier.e();
            if (e10 == null) {
                return null;
            }
            byteString = e10;
        }
        Buffer buffer = new Buffer();
        g.d(buffer, d());
        if (byteString != null) {
            buffer.writeByte(1);
            buffer.K1(byteString);
        } else {
            buffer.writeByte(0);
        }
        return buffer.y1();
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof WorkflowIdentifier)) {
                return false;
            }
            WorkflowIdentifier workflowIdentifier = (WorkflowIdentifier) obj;
            if (!j.b(this.f23066a, workflowIdentifier.f23066a) || !j.b(this.f23067b, workflowIdentifier.f23067b)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i10;
        int hashCode = this.f23066a.hashCode() * 31;
        WorkflowIdentifier workflowIdentifier = this.f23067b;
        if (workflowIdentifier == null) {
            i10 = 0;
        } else {
            i10 = workflowIdentifier.hashCode();
        }
        return hashCode + i10;
    }

    public String toString() {
        String str;
        Function0<String> function0 = this.f23068c;
        if (function0 == null) {
            str = null;
        } else {
            str = function0.invoke();
        }
        if (str != null) {
            return str;
        }
        String p10 = SequencesKt___SequencesKt.p(this.f23070e, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, WorkflowIdentifier$toString$1.f23072a, 31, (Object) null);
        return "WorkflowIdentifier(" + p10 + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WorkflowIdentifier(wk.a aVar, WorkflowIdentifier workflowIdentifier, Function0 function0, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, (i10 & 2) != 0 ? null : workflowIdentifier, (i10 & 4) != 0 ? null : function0);
    }
}
