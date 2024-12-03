package uj;

import io.reactivex.internal.util.ExceptionHelper;

public final class a {
    public static RuntimeException a(Throwable th2) {
        throw ExceptionHelper.e(th2);
    }

    public static void b(Throwable th2) {
        if (th2 instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th2);
        } else if (th2 instanceof ThreadDeath) {
            throw ((ThreadDeath) th2);
        } else if (th2 instanceof LinkageError) {
            throw ((LinkageError) th2);
        }
    }
}
