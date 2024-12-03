package net.bytebuddy.dynamic.scaffold;

import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.jar.asm.ClassReader;
import net.bytebuddy.jar.asm.ClassWriter;
import net.bytebuddy.pool.TypePool;

public interface ClassWriterStrategy {

    public enum Default implements ClassWriterStrategy {
        CONSTANT_POOL_RETAINING {
            public ClassWriter resolve(int i10, TypePool typePool, ClassReader classReader) {
                return new FrameComputingClassWriter(classReader, i10, typePool);
            }
        },
        CONSTANT_POOL_DISCARDING {
            public ClassWriter resolve(int i10, TypePool typePool, ClassReader classReader) {
                return resolve(i10, typePool);
            }
        };

        public ClassWriter resolve(int i10, TypePool typePool) {
            return new FrameComputingClassWriter(i10, typePool);
        }
    }

    ClassWriter resolve(int i10, TypePool typePool);

    ClassWriter resolve(int i10, TypePool typePool, ClassReader classReader);

    public static class FrameComputingClassWriter extends ClassWriter {
        private final TypePool typePool;

        public FrameComputingClassWriter(int i10, TypePool typePool2) {
            super(i10);
            this.typePool = typePool2;
        }

        /* access modifiers changed from: protected */
        public String getCommonSuperClass(String str, String str2) {
            Class<Object> cls = Object.class;
            TypeDescription resolve = this.typePool.describe(str.replace('/', '.')).resolve();
            TypeDescription resolve2 = this.typePool.describe(str2.replace('/', '.')).resolve();
            if (resolve.isAssignableFrom(resolve2)) {
                return resolve.getInternalName();
            }
            if (resolve.isAssignableTo(resolve2)) {
                return resolve2.getInternalName();
            }
            if (resolve.isInterface() || resolve2.isInterface()) {
                return TypeDescription.ForLoadedType.of(cls).getInternalName();
            }
            do {
                TypeDescription.Generic superClass = resolve.getSuperClass();
                if (superClass == null) {
                    return TypeDescription.ForLoadedType.of(cls).getInternalName();
                }
                resolve = superClass.asErasure();
            } while (!resolve.isAssignableFrom(resolve2));
            return resolve.getInternalName();
        }

        public FrameComputingClassWriter(ClassReader classReader, int i10, TypePool typePool2) {
            super(classReader, i10);
            this.typePool = typePool2;
        }
    }
}
