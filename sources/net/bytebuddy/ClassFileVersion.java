package net.bytebuddy;

import com.facebook.internal.ServerProtocol;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.utility.OpenedClassReader;
import net.bytebuddy.utility.nullability.MaybeNull;

public class ClassFileVersion implements Comparable<ClassFileVersion>, Serializable {
    private static final boolean ACCESS_CONTROLLER;
    protected static final int BASE_VERSION = 44;
    public static final ClassFileVersion JAVA_V1 = new ClassFileVersion(Opcodes.V1_1);
    public static final ClassFileVersion JAVA_V10 = new ClassFileVersion(54);
    public static final ClassFileVersion JAVA_V11 = new ClassFileVersion(55);
    public static final ClassFileVersion JAVA_V12 = new ClassFileVersion(56);
    public static final ClassFileVersion JAVA_V13 = new ClassFileVersion(57);
    public static final ClassFileVersion JAVA_V14 = new ClassFileVersion(58);
    public static final ClassFileVersion JAVA_V15 = new ClassFileVersion(59);
    public static final ClassFileVersion JAVA_V16 = new ClassFileVersion(60);
    public static final ClassFileVersion JAVA_V17 = new ClassFileVersion(61);
    public static final ClassFileVersion JAVA_V18 = new ClassFileVersion(62);
    public static final ClassFileVersion JAVA_V19 = new ClassFileVersion(63);
    public static final ClassFileVersion JAVA_V2 = new ClassFileVersion(46);
    public static final ClassFileVersion JAVA_V20 = new ClassFileVersion(64);
    public static final ClassFileVersion JAVA_V21 = new ClassFileVersion(65);
    public static final ClassFileVersion JAVA_V3 = new ClassFileVersion(47);
    public static final ClassFileVersion JAVA_V4 = new ClassFileVersion(48);
    public static final ClassFileVersion JAVA_V5 = new ClassFileVersion(49);
    public static final ClassFileVersion JAVA_V6 = new ClassFileVersion(50);
    public static final ClassFileVersion JAVA_V7 = new ClassFileVersion(51);
    public static final ClassFileVersion JAVA_V8 = new ClassFileVersion(52);
    public static final ClassFileVersion JAVA_V9 = new ClassFileVersion(53);
    private static final VersionLocator VERSION_LOCATOR = ((VersionLocator) doPrivileged(VersionLocator.Resolver.INSTANCE));
    private static final long serialVersionUID = 1;
    private final int versionNumber;

    protected interface VersionLocator {
        public static final String EARLY_ACCESS = "-ea";
        public static final String JAVA_VERSION = "java.version";

        @HashCodeAndEqualsPlugin.Enhance
        public static class Resolved implements VersionLocator {
            private final ClassFileVersion classFileVersion;

            protected Resolved(ClassFileVersion classFileVersion2) {
                this.classFileVersion = classFileVersion2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.classFileVersion.equals(((Resolved) obj).classFileVersion);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.classFileVersion.hashCode();
            }

            public ClassFileVersion resolve() {
                return this.classFileVersion;
            }
        }

        public enum Resolver implements PrivilegedAction<VersionLocator> {
            INSTANCE;

            @SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback.", value = {"REC_CATCH_EXCEPTION"})
            public VersionLocator run() {
                Class<?> cls;
                Method method;
                try {
                    cls = Class.forName(Runtime.class.getName() + "$Version");
                    method = cls.getMethod("feature", new Class[0]);
                } catch (NoSuchMethodException unused) {
                    method = cls.getMethod("major", new Class[0]);
                } catch (Throwable unused2) {
                    try {
                        String property = System.getProperty(VersionLocator.JAVA_VERSION);
                        if (property == null) {
                            throw new IllegalStateException("Java version property is not set");
                        } else if (property.equals("0")) {
                            return new Resolved(ClassFileVersion.JAVA_V6);
                        } else {
                            if (property.endsWith(VersionLocator.EARLY_ACCESS)) {
                                property = property.substring(0, property.length() - 3);
                            }
                            int[] iArr = {-1, 0, 0};
                            int i10 = 1;
                            while (i10 < 3) {
                                int indexOf = property.indexOf(46, iArr[i10 - 1] + 1);
                                iArr[i10] = indexOf;
                                if (indexOf != -1) {
                                    i10++;
                                } else {
                                    throw new IllegalStateException("This JVM's version string does not seem to be valid: " + property);
                                }
                            }
                            return new Resolved(ClassFileVersion.ofJavaVersion(Integer.parseInt(property.substring(iArr[1] + 1, iArr[2]))));
                        }
                    } catch (Throwable th2) {
                        return new Unresolved(th2.getMessage());
                    }
                }
                return new Resolved(ClassFileVersion.ofJavaVersion(((Integer) method.invoke(Runtime.class.getMethod(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, new Class[0]).invoke((Object) null, new Object[0]), new Object[0])).intValue()));
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Unresolved implements VersionLocator {
            private final String message;

            protected Unresolved(String str) {
                this.message = str;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.message.equals(((Unresolved) obj).message);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.message.hashCode();
            }

            public ClassFileVersion resolve() {
                throw new IllegalStateException("Failed to resolve the class file version of the current VM: " + this.message);
            }
        }

        ClassFileVersion resolve();
    }

    static {
        boolean z10 = false;
        try {
            Class.forName("java.security.AccessController", false, (ClassLoader) null);
            ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
        } catch (ClassNotFoundException unused) {
        } catch (SecurityException unused2) {
            z10 = true;
        }
        ACCESS_CONTROLLER = z10;
    }

    protected ClassFileVersion(int i10) {
        this.versionNumber = i10;
    }

    @AccessControllerPlugin.Enhance
    private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
    }

    public static ClassFileVersion latest() {
        return JAVA_V21;
    }

    public static ClassFileVersion of(Class<?> cls) throws IOException {
        return of(cls, ClassFileLocator.ForClassLoader.of(cls.getClassLoader()));
    }

    public static ClassFileVersion ofClassFile(byte[] bArr) {
        if (bArr.length >= 7) {
            return ofMinorMajor((bArr[7] & 255) | (bArr[6] << 8));
        }
        throw new IllegalArgumentException("Supplied byte array is too short to be a class file with " + bArr.length + " byte");
    }

    public static ClassFileVersion ofJavaVersion(int i10) {
        switch (i10) {
            case 1:
                return JAVA_V1;
            case 2:
                return JAVA_V2;
            case 3:
                return JAVA_V3;
            case 4:
                return JAVA_V4;
            case 5:
                return JAVA_V5;
            case 6:
                return JAVA_V6;
            case 7:
                return JAVA_V7;
            case 8:
                return JAVA_V8;
            case 9:
                return JAVA_V9;
            case 10:
                return JAVA_V10;
            case 11:
                return JAVA_V11;
            case 12:
                return JAVA_V12;
            case 13:
                return JAVA_V13;
            case 14:
                return JAVA_V14;
            case 15:
                return JAVA_V15;
            case 16:
                return JAVA_V16;
            case 17:
                return JAVA_V17;
            case 18:
                return JAVA_V18;
            case 19:
                return JAVA_V19;
            case 20:
                return JAVA_V20;
            case 21:
                return JAVA_V21;
            default:
                if (OpenedClassReader.EXPERIMENTAL && i10 > 0) {
                    return new ClassFileVersion(i10 + 44);
                }
                throw new IllegalArgumentException("Unknown Java version: " + i10);
        }
    }

    public static ClassFileVersion ofJavaVersionString(String str) {
        String str2;
        if (str.equals("1.1")) {
            return JAVA_V1;
        }
        if (str.equals("1.2")) {
            return JAVA_V2;
        }
        if (str.equals("1.3")) {
            return JAVA_V3;
        }
        if (str.equals("1.4")) {
            return JAVA_V4;
        }
        if (str.equals("1.5") || str.equals("5")) {
            return JAVA_V5;
        }
        if (str.equals("1.6") || str.equals("6")) {
            return JAVA_V6;
        }
        if (str.equals("1.7") || str.equals("7")) {
            return JAVA_V7;
        }
        if (str.equals("1.8") || str.equals("8")) {
            return JAVA_V8;
        }
        if (str.equals("1.9") || str.equals("9")) {
            return JAVA_V9;
        }
        if (str.equals("1.10") || str.equals("10")) {
            return JAVA_V10;
        }
        if (str.equals("1.11") || str.equals("11")) {
            return JAVA_V11;
        }
        if (str.equals("1.12") || str.equals("12")) {
            return JAVA_V12;
        }
        if (str.equals("1.13") || str.equals("13")) {
            return JAVA_V13;
        }
        if (str.equals("1.14") || str.equals("14")) {
            return JAVA_V14;
        }
        if (str.equals("1.15") || str.equals("15")) {
            return JAVA_V15;
        }
        if (str.equals("1.16") || str.equals("16")) {
            return JAVA_V16;
        }
        if (str.equals("1.17") || str.equals("17")) {
            return JAVA_V17;
        }
        if (str.equals("1.18") || str.equals("18")) {
            return JAVA_V18;
        }
        if (str.equals("1.19") || str.equals("19")) {
            return JAVA_V19;
        }
        if (str.equals("1.20") || str.equals("20")) {
            return JAVA_V20;
        }
        if (str.equals("1.21") || str.equals("21")) {
            return JAVA_V21;
        }
        if (OpenedClassReader.EXPERIMENTAL) {
            try {
                if (str.startsWith("1.")) {
                    str2 = str.substring(2);
                } else {
                    str2 = str;
                }
                int parseInt = Integer.parseInt(str2);
                if (parseInt > 0) {
                    return new ClassFileVersion(parseInt + 44);
                }
            } catch (NumberFormatException unused) {
            }
        }
        throw new IllegalArgumentException("Unknown Java version string: " + str);
    }

    public static ClassFileVersion ofMinorMajor(int i10) {
        ClassFileVersion classFileVersion = new ClassFileVersion(i10);
        if (classFileVersion.getMajorVersion() > 44) {
            return classFileVersion;
        }
        throw new IllegalArgumentException("Class version " + i10 + " is not valid");
    }

    public static ClassFileVersion ofThisVm() {
        return VERSION_LOCATOR.resolve();
    }

    public ClassFileVersion asPreviewVersion() {
        return new ClassFileVersion(this.versionNumber | Opcodes.V_PREVIEW);
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this.versionNumber == ((ClassFileVersion) obj).versionNumber) {
            return true;
        }
        return false;
    }

    public int getJavaVersion() {
        return getMajorVersion() - 44;
    }

    public short getMajorVersion() {
        return (short) (this.versionNumber & 255);
    }

    public int getMinorMajorVersion() {
        return this.versionNumber;
    }

    public short getMinorVersion() {
        return (short) (this.versionNumber >> 16);
    }

    public int hashCode() {
        return this.versionNumber;
    }

    public boolean isAtLeast(ClassFileVersion classFileVersion) {
        return compareTo(classFileVersion) > -1;
    }

    public boolean isAtMost(ClassFileVersion classFileVersion) {
        return compareTo(classFileVersion) < 1;
    }

    public boolean isGreaterThan(ClassFileVersion classFileVersion) {
        return compareTo(classFileVersion) > 0;
    }

    public boolean isLessThan(ClassFileVersion classFileVersion) {
        return compareTo(classFileVersion) < 0;
    }

    public boolean isPreviewVersion() {
        return (this.versionNumber & Opcodes.V_PREVIEW) == -65536;
    }

    public String toString() {
        return "Java " + getJavaVersion() + " (" + getMinorMajorVersion() + ")";
    }

    public static ClassFileVersion of(Class<?> cls, ClassFileLocator classFileLocator) throws IOException {
        return of(TypeDescription.ForLoadedType.of(cls), classFileLocator);
    }

    @SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback.", value = {"REC_CATCH_EXCEPTION"})
    public static ClassFileVersion ofThisVm(ClassFileVersion classFileVersion) {
        try {
            return ofThisVm();
        } catch (Exception unused) {
            return classFileVersion;
        }
    }

    public int compareTo(ClassFileVersion classFileVersion) {
        short s10;
        short s11;
        if (getMajorVersion() == classFileVersion.getMajorVersion()) {
            s11 = getMinorVersion();
            s10 = classFileVersion.getMinorVersion();
        } else {
            s11 = getMajorVersion();
            s10 = classFileVersion.getMajorVersion();
        }
        return Integer.signum(s11 - s10);
    }

    public static ClassFileVersion of(TypeDescription typeDescription, ClassFileLocator classFileLocator) throws IOException {
        return ofClassFile(classFileLocator.locate(typeDescription.getName()).resolve());
    }
}
