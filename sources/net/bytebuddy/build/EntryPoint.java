package net.bytebuddy.build;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.dynamic.scaffold.inline.MethodNameTransformer;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface EntryPoint {

    public enum Default implements EntryPoint {
        REBASE {
            public ByteBuddy byteBuddy(ClassFileVersion classFileVersion) {
                return new ByteBuddy(classFileVersion);
            }

            public DynamicType.Builder<?> transform(TypeDescription typeDescription, ByteBuddy byteBuddy, ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer) {
                return byteBuddy.rebase(typeDescription, classFileLocator, methodNameTransformer);
            }
        },
        REDEFINE {
            public ByteBuddy byteBuddy(ClassFileVersion classFileVersion) {
                return new ByteBuddy(classFileVersion);
            }

            public DynamicType.Builder<?> transform(TypeDescription typeDescription, ByteBuddy byteBuddy, ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer) {
                return byteBuddy.redefine(typeDescription, classFileLocator);
            }
        },
        REDEFINE_LOCAL {
            public ByteBuddy byteBuddy(ClassFileVersion classFileVersion) {
                return new ByteBuddy(classFileVersion).with((Implementation.Context.Factory) Implementation.Context.Disabled.Factory.INSTANCE);
            }

            public DynamicType.Builder<?> transform(TypeDescription typeDescription, ByteBuddy byteBuddy, ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer) {
                return byteBuddy.redefine(typeDescription, classFileLocator).ignoreAlso((ElementMatcher<? super MethodDescription>) ElementMatchers.not(ElementMatchers.isDeclaredBy(typeDescription)));
            }
        },
        DECORATE {
            public ByteBuddy byteBuddy(ClassFileVersion classFileVersion) {
                return new ByteBuddy(classFileVersion).with((MethodGraph.Compiler) MethodGraph.Compiler.ForDeclaredMethods.INSTANCE).with((Implementation.Context.Factory) Implementation.Context.Disabled.Factory.INSTANCE);
            }

            public DynamicType.Builder<?> transform(TypeDescription typeDescription, ByteBuddy byteBuddy, ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer) {
                return byteBuddy.decorate(typeDescription, classFileLocator);
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Unvalidated implements EntryPoint {
        private final EntryPoint delegate;

        public Unvalidated(EntryPoint entryPoint) {
            this.delegate = entryPoint;
        }

        public ByteBuddy byteBuddy(ClassFileVersion classFileVersion) {
            return this.delegate.byteBuddy(classFileVersion).with(TypeValidation.DISABLED);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.delegate.equals(((Unvalidated) obj).delegate);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.delegate.hashCode();
        }

        public DynamicType.Builder<?> transform(TypeDescription typeDescription, ByteBuddy byteBuddy, ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer) {
            return this.delegate.transform(typeDescription, byteBuddy, classFileLocator, methodNameTransformer);
        }
    }

    ByteBuddy byteBuddy(ClassFileVersion classFileVersion);

    DynamicType.Builder<?> transform(TypeDescription typeDescription, ByteBuddy byteBuddy, ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer);
}
