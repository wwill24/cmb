package com.leanplum.migration.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/leanplum/migration/model/MigrationState;", "", "(Ljava/lang/String;I)V", "useCleverTap", "", "useLeanplum", "Undefined", "LeanplumOnly", "CleverTapOnly", "Duplicate", "Companion", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
public enum MigrationState {
    Undefined,
    LeanplumOnly,
    CleverTapOnly,
    Duplicate;
    
    public static final Companion Companion = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/leanplum/migration/model/MigrationState$Companion;", "", "()V", "from", "Lcom/leanplum/migration/model/MigrationState;", "state", "", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MigrationState from(String str) {
            j.g(str, "state");
            int hashCode = str.hashCode();
            if (hashCode != 3185) {
                if (hashCode != 3460) {
                    if (hashCode == 103121368 && str.equals("lp+ct")) {
                        return MigrationState.Duplicate;
                    }
                } else if (str.equals("lp")) {
                    return MigrationState.LeanplumOnly;
                }
            } else if (str.equals("ct")) {
                return MigrationState.CleverTapOnly;
            }
            return MigrationState.Undefined;
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] iArr = new int[MigrationState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[MigrationState.Undefined.ordinal()] = 1;
            iArr[MigrationState.LeanplumOnly.ordinal()] = 2;
            MigrationState migrationState = MigrationState.Duplicate;
            iArr[migrationState.ordinal()] = 3;
            int[] iArr2 = new int[MigrationState.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[MigrationState.CleverTapOnly.ordinal()] = 1;
            iArr2[migrationState.ordinal()] = 2;
        }
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    public static final MigrationState from(String str) {
        return Companion.from(str);
    }

    public final boolean useCleverTap() {
        int i10 = WhenMappings.$EnumSwitchMapping$1[ordinal()];
        return i10 == 1 || i10 == 2;
    }

    public final boolean useLeanplum() {
        int i10 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        return i10 == 1 || i10 == 2 || i10 == 3;
    }
}
