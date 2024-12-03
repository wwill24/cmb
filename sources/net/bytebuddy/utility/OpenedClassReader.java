package net.bytebuddy.utility;

import com.facebook.internal.ServerProtocol;
import java.security.AccessController;
import java.security.PrivilegedAction;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.jar.asm.ClassReader;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

public class OpenedClassReader {
    private static final boolean ACCESS_CONTROLLER;
    public static final int ASM_API = Opcodes.ASM9;
    public static final boolean EXPERIMENTAL;
    public static final String EXPERIMENTAL_PROPERTY = "net.bytebuddy.experimental";

    static {
        boolean z10 = false;
        try {
            Class.forName("java.security.AccessController", false, (ClassLoader) null);
            ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
        } catch (ClassNotFoundException unused) {
            ACCESS_CONTROLLER = false;
        } catch (SecurityException unused2) {
            ACCESS_CONTROLLER = true;
        }
        try {
            z10 = Boolean.parseBoolean((String) doPrivileged(new GetSystemPropertyAction(EXPERIMENTAL_PROPERTY)));
        } catch (Exception unused3) {
        }
        EXPERIMENTAL = z10;
    }

    private OpenedClassReader() {
        throw new UnsupportedOperationException("This class is a utility class and not supposed to be instantiated");
    }

    @AccessControllerPlugin.Enhance
    private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
    }

    public static ClassReader of(byte[] bArr) {
        ClassFileVersion ofClassFile = ClassFileVersion.ofClassFile(bArr);
        ClassFileVersion latest = ClassFileVersion.latest();
        if (!ofClassFile.isGreaterThan(latest)) {
            return new ClassReader(bArr);
        }
        if (EXPERIMENTAL) {
            bArr[6] = (byte) (latest.getMajorVersion() >>> 8);
            bArr[7] = (byte) latest.getMajorVersion();
            ClassReader classReader = new ClassReader(bArr);
            bArr[6] = (byte) (ofClassFile.getMajorVersion() >>> 8);
            bArr[7] = (byte) ofClassFile.getMajorVersion();
            return classReader;
        }
        throw new IllegalArgumentException(ofClassFile + " is not supported by the current version of Byte Buddy which officially supports " + latest + " - update Byte Buddy or set " + EXPERIMENTAL_PROPERTY + " as a VM property");
    }
}
