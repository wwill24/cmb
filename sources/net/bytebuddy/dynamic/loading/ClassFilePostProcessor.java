package net.bytebuddy.dynamic.loading;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.AllPermission;
import java.security.CodeSource;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.ProtectionDomain;
import java.util.Collections;
import java.util.Enumeration;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface ClassFilePostProcessor {

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForClassFileTransformer implements ClassFilePostProcessor {
        protected static final ProtectionDomain ALL_PRIVILEGES = new ProtectionDomain((CodeSource) null, new AllPermissionsCollection());
        @AlwaysNull
        private static final Class<?> UNLOADED_TYPE = null;
        private final ClassFileTransformer classFileTransformer;

        @HashCodeAndEqualsPlugin.Enhance
        protected static class AllPermissionsCollection extends PermissionCollection {
            private static final long serialVersionUID = 1;

            protected AllPermissionsCollection() {
            }

            public void add(Permission permission) {
                throw new UnsupportedOperationException("add");
            }

            public Enumeration<Permission> elements() {
                return Collections.enumeration(Collections.singleton(new AllPermission()));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass();
            }

            public int hashCode() {
                return getClass().hashCode();
            }

            public boolean implies(Permission permission) {
                return true;
            }
        }

        public ForClassFileTransformer(ClassFileTransformer classFileTransformer2) {
            this.classFileTransformer = classFileTransformer2;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.classFileTransformer.equals(((ForClassFileTransformer) obj).classFileTransformer);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.classFileTransformer.hashCode();
        }

        public byte[] transform(@MaybeNull ClassLoader classLoader, String str, @MaybeNull ProtectionDomain protectionDomain, byte[] bArr) {
            try {
                ClassFileTransformer classFileTransformer2 = this.classFileTransformer;
                String replace = str.replace('.', '/');
                Class<?> cls = UNLOADED_TYPE;
                if (protectionDomain == null) {
                    protectionDomain = ALL_PRIVILEGES;
                }
                byte[] transform = classFileTransformer2.transform(classLoader, replace, cls, protectionDomain, bArr);
                if (transform == null) {
                    return bArr;
                }
                return transform;
            } catch (IllegalClassFormatException e10) {
                throw new IllegalStateException("Failed to transform " + str, e10);
            }
        }
    }

    public enum NoOp implements ClassFilePostProcessor {
        INSTANCE;

        public byte[] transform(@MaybeNull ClassLoader classLoader, String str, @MaybeNull ProtectionDomain protectionDomain, byte[] bArr) {
            return bArr;
        }
    }

    byte[] transform(@MaybeNull ClassLoader classLoader, String str, @MaybeNull ProtectionDomain protectionDomain, byte[] bArr);
}
