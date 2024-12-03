package net.bytebuddy.build;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.build.CachedReturnPlugin;

@SuppressFBWarnings(justification = "Name is chosen to optimize for simple lookup", value = {"NM_CLASS_NAMING_CONVENTION"})
class CachedReturnPlugin$Advice$long {
    private CachedReturnPlugin$Advice$long() {
        throw new UnsupportedOperationException("This class is merely an advice template and should not be instantiated");
    }

    @Advice.OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
    protected static long enter(@CachedReturnPlugin.CacheField long j10) {
        return j10;
    }

    @Advice.OnMethodExit
    @SuppressFBWarnings(justification = "Advice method serves as a template", value = {"UC_USELESS_VOID_METHOD", "DLS_DEAD_LOCAL_STORE"})
    protected static void exit(@Advice.Return(readOnly = false) long j10, @CachedReturnPlugin.CacheField long j11) {
    }
}
