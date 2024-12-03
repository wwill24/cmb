package com.leanplum.actions;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\b\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/leanplum/actions/MessageDisplayChoice;", "", "type", "Lcom/leanplum/actions/MessageDisplayChoice$Type;", "delaySeconds", "", "(Lcom/leanplum/actions/MessageDisplayChoice$Type;I)V", "getDelaySeconds", "()I", "getType", "()Lcom/leanplum/actions/MessageDisplayChoice$Type;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "Type", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
public final class MessageDisplayChoice {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int delaySeconds;
    private final Type type;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u00020\u0004H\u0007J\b\u0010\t\u001a\u00020\u0004H\u0007¨\u0006\n"}, d2 = {"Lcom/leanplum/actions/MessageDisplayChoice$Companion;", "", "()V", "delay", "Lcom/leanplum/actions/MessageDisplayChoice;", "delaySeconds", "", "delayIndefinitely", "discard", "show", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MessageDisplayChoice delay(int i10) {
            return new MessageDisplayChoice(Type.DELAY, i10, (DefaultConstructorMarker) null);
        }

        public final MessageDisplayChoice delayIndefinitely() {
            return delay(0);
        }

        public final MessageDisplayChoice discard() {
            return new MessageDisplayChoice(Type.DISCARD, 0, 2, (DefaultConstructorMarker) null);
        }

        public final MessageDisplayChoice show() {
            return new MessageDisplayChoice(Type.SHOW, 0, 2, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/leanplum/actions/MessageDisplayChoice$Type;", "", "(Ljava/lang/String;I)V", "SHOW", "DISCARD", "DELAY", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
    public enum Type {
        SHOW,
        DISCARD,
        DELAY
    }

    private MessageDisplayChoice(Type type2, int i10) {
        this.type = type2;
        this.delaySeconds = i10;
    }

    public static /* synthetic */ MessageDisplayChoice copy$default(MessageDisplayChoice messageDisplayChoice, Type type2, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            type2 = messageDisplayChoice.type;
        }
        if ((i11 & 2) != 0) {
            i10 = messageDisplayChoice.delaySeconds;
        }
        return messageDisplayChoice.copy(type2, i10);
    }

    public static final MessageDisplayChoice delay(int i10) {
        return Companion.delay(i10);
    }

    public static final MessageDisplayChoice delayIndefinitely() {
        return Companion.delayIndefinitely();
    }

    public static final MessageDisplayChoice discard() {
        return Companion.discard();
    }

    public static final MessageDisplayChoice show() {
        return Companion.show();
    }

    public final Type component1() {
        return this.type;
    }

    public final int component2() {
        return this.delaySeconds;
    }

    public final MessageDisplayChoice copy(Type type2, int i10) {
        j.g(type2, "type");
        return new MessageDisplayChoice(type2, i10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageDisplayChoice)) {
            return false;
        }
        MessageDisplayChoice messageDisplayChoice = (MessageDisplayChoice) obj;
        return j.b(this.type, messageDisplayChoice.type) && this.delaySeconds == messageDisplayChoice.delaySeconds;
    }

    public final int getDelaySeconds() {
        return this.delaySeconds;
    }

    public final Type getType() {
        return this.type;
    }

    public int hashCode() {
        Type type2 = this.type;
        return ((type2 != null ? type2.hashCode() : 0) * 31) + this.delaySeconds;
    }

    public String toString() {
        return "MessageDisplayChoice(type=" + this.type + ", delaySeconds=" + this.delaySeconds + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ MessageDisplayChoice(Type type2, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(type2, (i11 & 2) != 0 ? 0 : i10);
    }

    public /* synthetic */ MessageDisplayChoice(Type type2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(type2, i10);
    }
}
