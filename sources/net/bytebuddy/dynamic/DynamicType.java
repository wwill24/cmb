package net.bytebuddy.dynamic;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.modifier.FieldManifestation;
import net.bytebuddy.description.modifier.MethodManifestation;
import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.description.modifier.Ownership;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.RecordComponentDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.description.type.TypeVariableToken;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.Transformer;
import net.bytebuddy.dynamic.TypeResolutionStrategy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import net.bytebuddy.dynamic.scaffold.ClassWriterStrategy;
import net.bytebuddy.dynamic.scaffold.FieldRegistry;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.dynamic.scaffold.MethodRegistry;
import net.bytebuddy.dynamic.scaffold.RecordComponentRegistry;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.dynamic.scaffold.TypeWriter;
import net.bytebuddy.implementation.EqualsMethod;
import net.bytebuddy.implementation.FieldAccessor;
import net.bytebuddy.implementation.HashCodeMethod;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.LoadedTypeInitializer;
import net.bytebuddy.implementation.ToStringMethod;
import net.bytebuddy.implementation.attribute.AnnotationRetention;
import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
import net.bytebuddy.implementation.attribute.FieldAttributeAppender;
import net.bytebuddy.implementation.attribute.MethodAttributeAppender;
import net.bytebuddy.implementation.attribute.RecordComponentAttributeAppender;
import net.bytebuddy.implementation.attribute.TypeAttributeAppender;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.matcher.LatentMatcher;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.FileSystem;
import net.bytebuddy.utility.nullability.MaybeNull;
import net.bytebuddy.utility.visitor.ContextClassVisitor;

public interface DynamicType extends ClassFileLocator {

    public interface Builder<T> {

        public static abstract class AbstractBase<S> implements Builder<S> {

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class Adapter<U> extends UsingTypeWriter<U> {
                protected final AnnotationRetention annotationRetention;
                protected final AnnotationValueFilter.Factory annotationValueFilterFactory;
                protected final AsmVisitorWrapper asmVisitorWrapper;
                protected final AuxiliaryType.NamingStrategy auxiliaryTypeNamingStrategy;
                protected final List<? extends DynamicType> auxiliaryTypes;
                protected final ClassFileVersion classFileVersion;
                protected final ClassWriterStrategy classWriterStrategy;
                protected final FieldRegistry fieldRegistry;
                protected final LatentMatcher<? super MethodDescription> ignoredMethods;
                protected final Implementation.Context.Factory implementationContextFactory;
                protected final InstrumentedType.WithFlexibleName instrumentedType;
                protected final MethodGraph.Compiler methodGraphCompiler;
                protected final MethodRegistry methodRegistry;
                protected final RecordComponentRegistry recordComponentRegistry;
                protected final TypeAttributeAppender typeAttributeAppender;
                protected final TypeValidation typeValidation;
                protected final VisibilityBridgeStrategy visibilityBridgeStrategy;

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                protected class InnerTypeDefinitionForMethodAdapter extends Delegator<U> implements InnerTypeDefinition<U> {
                    private final MethodDescription.InDefinedShape methodDescription;

                    protected InnerTypeDefinitionForMethodAdapter(MethodDescription.InDefinedShape inDefinedShape) {
                        this.methodDescription = inDefinedShape;
                    }

                    public Builder<U> asAnonymousType() {
                        Adapter adapter = Adapter.this;
                        Adapter adapter2 = adapter;
                        InstrumentedType.WithFlexibleName withAnonymousClass = adapter.instrumentedType.withDeclaringType(TypeDescription.UNDEFINED).withEnclosingMethod(this.methodDescription).withAnonymousClass(true);
                        Adapter adapter3 = Adapter.this;
                        Adapter adapter4 = adapter2;
                        Adapter adapter5 = adapter3;
                        return adapter4.materialize(withAnonymousClass, adapter3.fieldRegistry, adapter3.methodRegistry, adapter3.recordComponentRegistry, adapter3.typeAttributeAppender, adapter3.asmVisitorWrapper, adapter3.classFileVersion, adapter3.auxiliaryTypeNamingStrategy, adapter3.annotationValueFilterFactory, adapter3.annotationRetention, adapter3.implementationContextFactory, adapter3.methodGraphCompiler, adapter3.typeValidation, adapter3.visibilityBridgeStrategy, adapter5.classWriterStrategy, adapter5.ignoredMethods, adapter5.auxiliaryTypes);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        InnerTypeDefinitionForMethodAdapter innerTypeDefinitionForMethodAdapter = (InnerTypeDefinitionForMethodAdapter) obj;
                        return this.methodDescription.equals(innerTypeDefinitionForMethodAdapter.methodDescription) && Adapter.this.equals(Adapter.this);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.methodDescription.hashCode()) * 31) + Adapter.this.hashCode();
                    }

                    /* access modifiers changed from: protected */
                    public Builder<U> materialize() {
                        Adapter adapter = Adapter.this;
                        Adapter adapter2 = adapter;
                        InstrumentedType.WithFlexibleName withLocalClass = adapter.instrumentedType.withDeclaringType(TypeDescription.UNDEFINED).withEnclosingMethod(this.methodDescription).withLocalClass(true);
                        Adapter adapter3 = Adapter.this;
                        Adapter adapter4 = adapter2;
                        Adapter adapter5 = adapter3;
                        return adapter4.materialize(withLocalClass, adapter3.fieldRegistry, adapter3.methodRegistry, adapter3.recordComponentRegistry, adapter3.typeAttributeAppender, adapter3.asmVisitorWrapper, adapter3.classFileVersion, adapter3.auxiliaryTypeNamingStrategy, adapter3.annotationValueFilterFactory, adapter3.annotationRetention, adapter3.implementationContextFactory, adapter3.methodGraphCompiler, adapter3.typeValidation, adapter3.visibilityBridgeStrategy, adapter5.classWriterStrategy, adapter5.ignoredMethods, adapter5.auxiliaryTypes);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                protected class InnerTypeDefinitionForTypeAdapter extends Delegator<U> implements InnerTypeDefinition.ForType<U> {
                    private final TypeDescription typeDescription;

                    protected InnerTypeDefinitionForTypeAdapter(TypeDescription typeDescription2) {
                        this.typeDescription = typeDescription2;
                    }

                    public Builder<U> asAnonymousType() {
                        Adapter adapter = Adapter.this;
                        Adapter adapter2 = adapter;
                        InstrumentedType.WithFlexibleName withAnonymousClass = adapter.instrumentedType.withDeclaringType(TypeDescription.UNDEFINED).withEnclosingType(this.typeDescription).withAnonymousClass(true);
                        Adapter adapter3 = Adapter.this;
                        Adapter adapter4 = adapter2;
                        Adapter adapter5 = adapter3;
                        return adapter4.materialize(withAnonymousClass, adapter3.fieldRegistry, adapter3.methodRegistry, adapter3.recordComponentRegistry, adapter3.typeAttributeAppender, adapter3.asmVisitorWrapper, adapter3.classFileVersion, adapter3.auxiliaryTypeNamingStrategy, adapter3.annotationValueFilterFactory, adapter3.annotationRetention, adapter3.implementationContextFactory, adapter3.methodGraphCompiler, adapter3.typeValidation, adapter3.visibilityBridgeStrategy, adapter5.classWriterStrategy, adapter5.ignoredMethods, adapter5.auxiliaryTypes);
                    }

                    public Builder<U> asMemberType() {
                        Adapter adapter = Adapter.this;
                        Adapter adapter2 = adapter;
                        InstrumentedType.WithFlexibleName withLocalClass = adapter.instrumentedType.withDeclaringType(this.typeDescription).withEnclosingType(this.typeDescription).withAnonymousClass(false).withLocalClass(false);
                        Adapter adapter3 = Adapter.this;
                        Adapter adapter4 = adapter2;
                        Adapter adapter5 = adapter3;
                        return adapter4.materialize(withLocalClass, adapter3.fieldRegistry, adapter3.methodRegistry, adapter3.recordComponentRegistry, adapter3.typeAttributeAppender, adapter3.asmVisitorWrapper, adapter3.classFileVersion, adapter3.auxiliaryTypeNamingStrategy, adapter3.annotationValueFilterFactory, adapter3.annotationRetention, adapter3.implementationContextFactory, adapter3.methodGraphCompiler, adapter3.typeValidation, adapter3.visibilityBridgeStrategy, adapter5.classWriterStrategy, adapter5.ignoredMethods, adapter5.auxiliaryTypes);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        InnerTypeDefinitionForTypeAdapter innerTypeDefinitionForTypeAdapter = (InnerTypeDefinitionForTypeAdapter) obj;
                        return this.typeDescription.equals(innerTypeDefinitionForTypeAdapter.typeDescription) && Adapter.this.equals(Adapter.this);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.typeDescription.hashCode()) * 31) + Adapter.this.hashCode();
                    }

                    /* access modifiers changed from: protected */
                    public Builder<U> materialize() {
                        Adapter adapter = Adapter.this;
                        Adapter adapter2 = adapter;
                        InstrumentedType.WithFlexibleName withLocalClass = adapter.instrumentedType.withDeclaringType(TypeDescription.UNDEFINED).withEnclosingType(this.typeDescription).withLocalClass(true);
                        Adapter adapter3 = Adapter.this;
                        Adapter adapter4 = adapter2;
                        Adapter adapter5 = adapter3;
                        return adapter4.materialize(withLocalClass, adapter3.fieldRegistry, adapter3.methodRegistry, adapter3.recordComponentRegistry, adapter3.typeAttributeAppender, adapter3.asmVisitorWrapper, adapter3.classFileVersion, adapter3.auxiliaryTypeNamingStrategy, adapter3.annotationValueFilterFactory, adapter3.annotationRetention, adapter3.implementationContextFactory, adapter3.methodGraphCompiler, adapter3.typeValidation, adapter3.visibilityBridgeStrategy, adapter5.classWriterStrategy, adapter5.ignoredMethods, adapter5.auxiliaryTypes);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                protected class MethodDefinitionAdapter extends MethodDefinition.ParameterDefinition.Initial.AbstractBase<U> {
                    /* access modifiers changed from: private */
                    public final MethodDescription.Token token;

                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    protected class AnnotationAdapter extends MethodDefinition.AbstractBase.Adapter<U> {
                        protected AnnotationAdapter(MethodDefinitionAdapter methodDefinitionAdapter, MethodRegistry.Handler handler) {
                            this(handler, MethodAttributeAppender.ForInstrumentedMethod.INCLUDING_RECEIVER, Transformer.NoOp.make());
                        }

                        public MethodDefinition<U> annotateMethod(Collection<? extends AnnotationDescription> collection) {
                            MethodDefinitionAdapter methodDefinitionAdapter = MethodDefinitionAdapter.this;
                            return new AnnotationAdapter(this.handler, this.methodAttributeAppenderFactory, this.transformer);
                        }

                        public MethodDefinition<U> annotateParameter(int i10, Collection<? extends AnnotationDescription> collection) {
                            ArrayList arrayList = new ArrayList(MethodDefinitionAdapter.this.token.getParameterTokens());
                            arrayList.set(i10, new ParameterDescription.Token(((ParameterDescription.Token) MethodDefinitionAdapter.this.token.getParameterTokens().get(i10)).getType(), CompoundList.of(((ParameterDescription.Token) MethodDefinitionAdapter.this.token.getParameterTokens().get(i10)).getAnnotations(), (AnnotationList) new ArrayList(collection)), ((ParameterDescription.Token) MethodDefinitionAdapter.this.token.getParameterTokens().get(i10)).getName(), ((ParameterDescription.Token) MethodDefinitionAdapter.this.token.getParameterTokens().get(i10)).getModifiers()));
                            MethodDefinitionAdapter methodDefinitionAdapter = MethodDefinitionAdapter.this;
                            return new AnnotationAdapter(this.handler, this.methodAttributeAppenderFactory, this.transformer);
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (!super.equals(obj)) {
                                return false;
                            }
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && MethodDefinitionAdapter.this.equals(MethodDefinitionAdapter.this);
                        }

                        public int hashCode() {
                            return (super.hashCode() * 31) + MethodDefinitionAdapter.this.hashCode();
                        }

                        /* access modifiers changed from: protected */
                        public MethodDefinition<U> materialize(MethodRegistry.Handler handler, MethodAttributeAppender.Factory factory, Transformer<MethodDescription> transformer) {
                            return new AnnotationAdapter(handler, factory, transformer);
                        }

                        public MethodDefinition<U> receiverType(TypeDescription.Generic generic) {
                            MethodDefinitionAdapter methodDefinitionAdapter = MethodDefinitionAdapter.this;
                            return new AnnotationAdapter(this.handler, this.methodAttributeAppenderFactory, this.transformer);
                        }

                        /* access modifiers changed from: protected */
                        public Builder<U> materialize() {
                            MethodDefinitionAdapter methodDefinitionAdapter = MethodDefinitionAdapter.this;
                            Adapter adapter = Adapter.this;
                            Adapter adapter2 = adapter;
                            InstrumentedType.WithFlexibleName withMethod = adapter.instrumentedType.withMethod(methodDefinitionAdapter.token);
                            MethodDefinitionAdapter methodDefinitionAdapter2 = MethodDefinitionAdapter.this;
                            Adapter adapter3 = Adapter.this;
                            FieldRegistry fieldRegistry = adapter3.fieldRegistry;
                            MethodRegistry prepend = adapter3.methodRegistry.prepend(new LatentMatcher.ForMethodToken(methodDefinitionAdapter2.token), this.handler, this.methodAttributeAppenderFactory, this.transformer);
                            Adapter adapter4 = Adapter.this;
                            return adapter2.materialize(withMethod, fieldRegistry, prepend, adapter4.recordComponentRegistry, adapter4.typeAttributeAppender, adapter4.asmVisitorWrapper, adapter4.classFileVersion, adapter4.auxiliaryTypeNamingStrategy, adapter4.annotationValueFilterFactory, adapter4.annotationRetention, adapter4.implementationContextFactory, adapter4.methodGraphCompiler, adapter4.typeValidation, adapter4.visibilityBridgeStrategy, adapter4.classWriterStrategy, adapter4.ignoredMethods, adapter4.auxiliaryTypes);
                        }

                        protected AnnotationAdapter(MethodRegistry.Handler handler, MethodAttributeAppender.Factory factory, Transformer<MethodDescription> transformer) {
                            super(handler, factory, transformer);
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    protected class ParameterAnnotationAdapter extends MethodDefinition.ParameterDefinition.Annotatable.AbstractBase.Adapter<U> {
                        private final ParameterDescription.Token token;

                        protected ParameterAnnotationAdapter(ParameterDescription.Token token2) {
                            this.token = token2;
                        }

                        public MethodDefinition.ParameterDefinition.Annotatable<U> annotateParameter(Collection<? extends AnnotationDescription> collection) {
                            return new ParameterAnnotationAdapter(new ParameterDescription.Token(this.token.getType(), CompoundList.of(this.token.getAnnotations(), (AnnotationList) new ArrayList(collection)), this.token.getName(), this.token.getModifiers()));
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || getClass() != obj.getClass()) {
                                return false;
                            }
                            ParameterAnnotationAdapter parameterAnnotationAdapter = (ParameterAnnotationAdapter) obj;
                            return this.token.equals(parameterAnnotationAdapter.token) && MethodDefinitionAdapter.this.equals(MethodDefinitionAdapter.this);
                        }

                        public int hashCode() {
                            return (((getClass().hashCode() * 31) + this.token.hashCode()) * 31) + MethodDefinitionAdapter.this.hashCode();
                        }

                        /* access modifiers changed from: protected */
                        public MethodDefinition.ParameterDefinition<U> materialize() {
                            MethodDefinitionAdapter methodDefinitionAdapter = MethodDefinitionAdapter.this;
                            return new MethodDefinitionAdapter(new MethodDescription.Token(methodDefinitionAdapter.token.getName(), MethodDefinitionAdapter.this.token.getModifiers(), MethodDefinitionAdapter.this.token.getTypeVariableTokens(), MethodDefinitionAdapter.this.token.getReturnType(), CompoundList.of(MethodDefinitionAdapter.this.token.getParameterTokens(), this.token), MethodDefinitionAdapter.this.token.getExceptionTypes(), MethodDefinitionAdapter.this.token.getAnnotations(), MethodDefinitionAdapter.this.token.getDefaultValue(), MethodDefinitionAdapter.this.token.getReceiverType()));
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    protected class SimpleParameterAnnotationAdapter extends MethodDefinition.ParameterDefinition.Simple.Annotatable.AbstractBase.Adapter<U> {
                        private final ParameterDescription.Token token;

                        protected SimpleParameterAnnotationAdapter(ParameterDescription.Token token2) {
                            this.token = token2;
                        }

                        public MethodDefinition.ParameterDefinition.Simple.Annotatable<U> annotateParameter(Collection<? extends AnnotationDescription> collection) {
                            return new SimpleParameterAnnotationAdapter(new ParameterDescription.Token(this.token.getType(), CompoundList.of(this.token.getAnnotations(), (AnnotationList) new ArrayList(collection)), this.token.getName(), this.token.getModifiers()));
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || getClass() != obj.getClass()) {
                                return false;
                            }
                            SimpleParameterAnnotationAdapter simpleParameterAnnotationAdapter = (SimpleParameterAnnotationAdapter) obj;
                            return this.token.equals(simpleParameterAnnotationAdapter.token) && MethodDefinitionAdapter.this.equals(MethodDefinitionAdapter.this);
                        }

                        public int hashCode() {
                            return (((getClass().hashCode() * 31) + this.token.hashCode()) * 31) + MethodDefinitionAdapter.this.hashCode();
                        }

                        /* access modifiers changed from: protected */
                        public MethodDefinition.ParameterDefinition.Simple<U> materialize() {
                            MethodDefinitionAdapter methodDefinitionAdapter = MethodDefinitionAdapter.this;
                            return new MethodDefinitionAdapter(new MethodDescription.Token(methodDefinitionAdapter.token.getName(), MethodDefinitionAdapter.this.token.getModifiers(), MethodDefinitionAdapter.this.token.getTypeVariableTokens(), MethodDefinitionAdapter.this.token.getReturnType(), CompoundList.of(MethodDefinitionAdapter.this.token.getParameterTokens(), this.token), MethodDefinitionAdapter.this.token.getExceptionTypes(), MethodDefinitionAdapter.this.token.getAnnotations(), MethodDefinitionAdapter.this.token.getDefaultValue(), MethodDefinitionAdapter.this.token.getReceiverType()));
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    protected class TypeVariableAnnotationAdapter extends MethodDefinition.TypeVariableDefinition.Annotatable.AbstractBase.Adapter<U> {
                        private final TypeVariableToken token;

                        protected TypeVariableAnnotationAdapter(TypeVariableToken typeVariableToken) {
                            this.token = typeVariableToken;
                        }

                        public MethodDefinition.TypeVariableDefinition.Annotatable<U> annotateTypeVariable(Collection<? extends AnnotationDescription> collection) {
                            return new TypeVariableAnnotationAdapter(new TypeVariableToken(this.token.getSymbol(), this.token.getBounds(), CompoundList.of(this.token.getAnnotations(), (AnnotationList) new ArrayList(collection))));
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || getClass() != obj.getClass()) {
                                return false;
                            }
                            TypeVariableAnnotationAdapter typeVariableAnnotationAdapter = (TypeVariableAnnotationAdapter) obj;
                            return this.token.equals(typeVariableAnnotationAdapter.token) && MethodDefinitionAdapter.this.equals(MethodDefinitionAdapter.this);
                        }

                        public int hashCode() {
                            return (((getClass().hashCode() * 31) + this.token.hashCode()) * 31) + MethodDefinitionAdapter.this.hashCode();
                        }

                        /* access modifiers changed from: protected */
                        public MethodDefinition.ParameterDefinition<U> materialize() {
                            MethodDefinitionAdapter methodDefinitionAdapter = MethodDefinitionAdapter.this;
                            return new MethodDefinitionAdapter(new MethodDescription.Token(methodDefinitionAdapter.token.getName(), MethodDefinitionAdapter.this.token.getModifiers(), CompoundList.of(MethodDefinitionAdapter.this.token.getTypeVariableTokens(), this.token), MethodDefinitionAdapter.this.token.getReturnType(), MethodDefinitionAdapter.this.token.getParameterTokens(), MethodDefinitionAdapter.this.token.getExceptionTypes(), MethodDefinitionAdapter.this.token.getAnnotations(), MethodDefinitionAdapter.this.token.getDefaultValue(), MethodDefinitionAdapter.this.token.getReceiverType()));
                        }
                    }

                    protected MethodDefinitionAdapter(MethodDescription.Token token2) {
                        this.token = token2;
                    }

                    private MethodDefinition.ReceiverTypeDefinition<U> materialize(MethodRegistry.Handler handler) {
                        return new AnnotationAdapter(this, handler);
                    }

                    public MethodDefinition.ReceiverTypeDefinition<U> defaultValue(AnnotationValue<?, ?> annotationValue) {
                        return new MethodDefinitionAdapter(new MethodDescription.Token(this.token.getName(), ModifierContributor.Resolver.of(MethodManifestation.ABSTRACT).resolve(this.token.getModifiers()), this.token.getTypeVariableTokens(), this.token.getReturnType(), this.token.getParameterTokens(), this.token.getExceptionTypes(), this.token.getAnnotations(), annotationValue, this.token.getReceiverType())).materialize(new MethodRegistry.Handler.ForAnnotationValue(annotationValue));
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        MethodDefinitionAdapter methodDefinitionAdapter = (MethodDefinitionAdapter) obj;
                        return this.token.equals(methodDefinitionAdapter.token) && Adapter.this.equals(Adapter.this);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.token.hashCode()) * 31) + Adapter.this.hashCode();
                    }

                    public MethodDefinition.ReceiverTypeDefinition<U> intercept(Implementation implementation) {
                        return materialize(new MethodRegistry.Handler.ForImplementation(implementation));
                    }

                    public MethodDefinition.ExceptionDefinition<U> throwing(Collection<? extends TypeDefinition> collection) {
                        return new MethodDefinitionAdapter(new MethodDescription.Token(this.token.getName(), this.token.getModifiers(), this.token.getTypeVariableTokens(), this.token.getReturnType(), this.token.getParameterTokens(), CompoundList.of(this.token.getExceptionTypes(), (TypeList.Generic) new TypeList.Generic.Explicit((List<? extends TypeDefinition>) new ArrayList(collection))), this.token.getAnnotations(), this.token.getDefaultValue(), this.token.getReceiverType()));
                    }

                    public MethodDefinition.TypeVariableDefinition.Annotatable<U> typeVariable(String str, Collection<? extends TypeDefinition> collection) {
                        return new TypeVariableAnnotationAdapter(new TypeVariableToken(str, new TypeList.Generic.Explicit((List<? extends TypeDefinition>) new ArrayList(collection))));
                    }

                    public MethodDefinition.ParameterDefinition.Annotatable<U> withParameter(TypeDefinition typeDefinition, String str, int i10) {
                        return new ParameterAnnotationAdapter(new ParameterDescription.Token(typeDefinition.asGenericType(), str, Integer.valueOf(i10)));
                    }

                    public MethodDefinition.ReceiverTypeDefinition<U> withoutCode() {
                        int i10;
                        Adapter adapter = Adapter.this;
                        String name = this.token.getName();
                        if ((this.token.getModifiers() & 256) == 0) {
                            i10 = ModifierContributor.Resolver.of(MethodManifestation.ABSTRACT).resolve(this.token.getModifiers());
                        } else {
                            i10 = this.token.getModifiers();
                        }
                        return new MethodDefinitionAdapter(new MethodDescription.Token(name, i10, this.token.getTypeVariableTokens(), this.token.getReturnType(), this.token.getParameterTokens(), this.token.getExceptionTypes(), this.token.getAnnotations(), this.token.getDefaultValue(), this.token.getReceiverType())).materialize(MethodRegistry.Handler.ForAbstractMethod.INSTANCE);
                    }

                    public MethodDefinition.ParameterDefinition.Simple.Annotatable<U> withParameter(TypeDefinition typeDefinition) {
                        return new SimpleParameterAnnotationAdapter(new ParameterDescription.Token(typeDefinition.asGenericType()));
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                protected class MethodMatchAdapter extends MethodDefinition.ImplementationDefinition.AbstractBase<U> {
                    /* access modifiers changed from: private */
                    public final LatentMatcher<? super MethodDescription> matcher;

                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    protected class AnnotationAdapter extends MethodDefinition.AbstractBase.Adapter<U> {
                        protected AnnotationAdapter(MethodMatchAdapter methodMatchAdapter, MethodRegistry.Handler handler) {
                            this(handler, MethodAttributeAppender.NoOp.INSTANCE, Transformer.NoOp.make());
                        }

                        public MethodDefinition<U> annotateMethod(Collection<? extends AnnotationDescription> collection) {
                            return new AnnotationAdapter(this.handler, new MethodAttributeAppender.Factory.Compound(this.methodAttributeAppenderFactory, new MethodAttributeAppender.Explicit(new ArrayList(collection))), this.transformer);
                        }

                        public MethodDefinition<U> annotateParameter(int i10, Collection<? extends AnnotationDescription> collection) {
                            return new AnnotationAdapter(this.handler, new MethodAttributeAppender.Factory.Compound(this.methodAttributeAppenderFactory, new MethodAttributeAppender.Explicit(i10, (List<? extends AnnotationDescription>) new ArrayList(collection))), this.transformer);
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (!super.equals(obj)) {
                                return false;
                            }
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && MethodMatchAdapter.this.equals(MethodMatchAdapter.this);
                        }

                        public int hashCode() {
                            return (super.hashCode() * 31) + MethodMatchAdapter.this.hashCode();
                        }

                        /* access modifiers changed from: protected */
                        public MethodDefinition<U> materialize(MethodRegistry.Handler handler, MethodAttributeAppender.Factory factory, Transformer<MethodDescription> transformer) {
                            return new AnnotationAdapter(handler, factory, transformer);
                        }

                        public MethodDefinition<U> receiverType(TypeDescription.Generic generic) {
                            return new AnnotationAdapter(this.handler, new MethodAttributeAppender.Factory.Compound(this.methodAttributeAppenderFactory, new MethodAttributeAppender.ForReceiverType(generic)), this.transformer);
                        }

                        protected AnnotationAdapter(MethodRegistry.Handler handler, MethodAttributeAppender.Factory factory, Transformer<MethodDescription> transformer) {
                            super(handler, factory, transformer);
                        }

                        /* access modifiers changed from: protected */
                        public Builder<U> materialize() {
                            MethodMatchAdapter methodMatchAdapter = MethodMatchAdapter.this;
                            Adapter adapter = Adapter.this;
                            Adapter adapter2 = adapter;
                            InstrumentedType.WithFlexibleName withFlexibleName = adapter.instrumentedType;
                            FieldRegistry fieldRegistry = adapter.fieldRegistry;
                            MethodRegistry prepend = adapter.methodRegistry.prepend(methodMatchAdapter.matcher, this.handler, this.methodAttributeAppenderFactory, this.transformer);
                            Adapter adapter3 = Adapter.this;
                            return adapter2.materialize(withFlexibleName, fieldRegistry, prepend, adapter3.recordComponentRegistry, adapter3.typeAttributeAppender, adapter3.asmVisitorWrapper, adapter3.classFileVersion, adapter3.auxiliaryTypeNamingStrategy, adapter3.annotationValueFilterFactory, adapter3.annotationRetention, adapter3.implementationContextFactory, adapter3.methodGraphCompiler, adapter3.typeValidation, adapter3.visibilityBridgeStrategy, adapter3.classWriterStrategy, adapter3.ignoredMethods, adapter3.auxiliaryTypes);
                        }
                    }

                    protected MethodMatchAdapter(LatentMatcher<? super MethodDescription> latentMatcher) {
                        this.matcher = latentMatcher;
                    }

                    private MethodDefinition.ReceiverTypeDefinition<U> materialize(MethodRegistry.Handler handler) {
                        return new AnnotationAdapter(this, handler);
                    }

                    public MethodDefinition.ReceiverTypeDefinition<U> defaultValue(AnnotationValue<?, ?> annotationValue) {
                        return materialize(new MethodRegistry.Handler.ForAnnotationValue(annotationValue));
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        MethodMatchAdapter methodMatchAdapter = (MethodMatchAdapter) obj;
                        return this.matcher.equals(methodMatchAdapter.matcher) && Adapter.this.equals(Adapter.this);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.matcher.hashCode()) * 31) + Adapter.this.hashCode();
                    }

                    public MethodDefinition.ReceiverTypeDefinition<U> intercept(Implementation implementation) {
                        return materialize(new MethodRegistry.Handler.ForImplementation(implementation));
                    }

                    public MethodDefinition.ReceiverTypeDefinition<U> withoutCode() {
                        return materialize(MethodRegistry.Handler.ForAbstractMethod.INSTANCE);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                protected class OptionalMethodMatchAdapter extends Delegator<U> implements MethodDefinition.ImplementationDefinition.Optional<U> {
                    private final TypeList.Generic interfaces;

                    protected OptionalMethodMatchAdapter(TypeList.Generic generic) {
                        this.interfaces = generic;
                    }

                    private MethodDefinition.ImplementationDefinition<U> interfaceType() {
                        ElementMatcher.Junction none = ElementMatchers.none();
                        for (TypeDescription isSuperTypeOf : this.interfaces.asErasures()) {
                            none = none.or(ElementMatchers.isSuperTypeOf(isSuperTypeOf));
                        }
                        return materialize().invokable((ElementMatcher<? super MethodDescription>) ElementMatchers.isDeclaredBy((ElementMatcher<? super TypeDescription>) ElementMatchers.isInterface().and(none)));
                    }

                    public MethodDefinition.ReceiverTypeDefinition<U> defaultValue(AnnotationValue<?, ?> annotationValue) {
                        return interfaceType().defaultValue(annotationValue);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        OptionalMethodMatchAdapter optionalMethodMatchAdapter = (OptionalMethodMatchAdapter) obj;
                        return this.interfaces.equals(optionalMethodMatchAdapter.interfaces) && Adapter.this.equals(Adapter.this);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.interfaces.hashCode()) * 31) + Adapter.this.hashCode();
                    }

                    public MethodDefinition.ReceiverTypeDefinition<U> intercept(Implementation implementation) {
                        return interfaceType().intercept(implementation);
                    }

                    /* access modifiers changed from: protected */
                    public Builder<U> materialize() {
                        Adapter adapter = Adapter.this;
                        Adapter adapter2 = adapter;
                        InstrumentedType.WithFlexibleName withInterfaces = adapter.instrumentedType.withInterfaces(this.interfaces);
                        Adapter adapter3 = Adapter.this;
                        Adapter adapter4 = adapter2;
                        Adapter adapter5 = adapter3;
                        return adapter4.materialize(withInterfaces, adapter3.fieldRegistry, adapter3.methodRegistry, adapter3.recordComponentRegistry, adapter3.typeAttributeAppender, adapter3.asmVisitorWrapper, adapter3.classFileVersion, adapter3.auxiliaryTypeNamingStrategy, adapter3.annotationValueFilterFactory, adapter3.annotationRetention, adapter3.implementationContextFactory, adapter3.methodGraphCompiler, adapter3.typeValidation, adapter3.visibilityBridgeStrategy, adapter5.classWriterStrategy, adapter5.ignoredMethods, adapter5.auxiliaryTypes);
                    }

                    public MethodDefinition.ReceiverTypeDefinition<U> withoutCode() {
                        return interfaceType().withoutCode();
                    }

                    public <V> MethodDefinition.ReceiverTypeDefinition<U> defaultValue(V v10, Class<? extends V> cls) {
                        return interfaceType().defaultValue(v10, cls);
                    }
                }

                protected class RecordComponentMatchAdapter extends RecordComponentDefinition.Optional.AbstractBase<U> {
                    private final LatentMatcher<? super RecordComponentDescription> matcher;
                    private final RecordComponentAttributeAppender.Factory recordComponentAttributeAppenderFactory;
                    private final Transformer<RecordComponentDescription> transformer;

                    protected RecordComponentMatchAdapter(Adapter adapter, LatentMatcher<? super RecordComponentDescription> latentMatcher) {
                        this(latentMatcher, RecordComponentAttributeAppender.NoOp.INSTANCE, Transformer.NoOp.make());
                    }

                    public RecordComponentDefinition.Optional<U> annotateRecordComponent(Collection<? extends AnnotationDescription> collection) {
                        return attribute(new RecordComponentAttributeAppender.Explicit(new ArrayList(collection)));
                    }

                    public RecordComponentDefinition.Optional<U> attribute(RecordComponentAttributeAppender.Factory factory) {
                        return new RecordComponentMatchAdapter(this.matcher, new RecordComponentAttributeAppender.Factory.Compound(this.recordComponentAttributeAppenderFactory, factory), this.transformer);
                    }

                    /* access modifiers changed from: protected */
                    public Builder<U> materialize() {
                        Adapter adapter = Adapter.this;
                        Adapter adapter2 = adapter;
                        InstrumentedType.WithFlexibleName withFlexibleName = adapter.instrumentedType;
                        FieldRegistry fieldRegistry = adapter.fieldRegistry;
                        MethodRegistry methodRegistry = adapter.methodRegistry;
                        RecordComponentRegistry prepend = adapter.recordComponentRegistry.prepend(this.matcher, this.recordComponentAttributeAppenderFactory, this.transformer);
                        Adapter adapter3 = Adapter.this;
                        Adapter adapter4 = adapter2;
                        Adapter adapter5 = adapter3;
                        return adapter4.materialize(withFlexibleName, fieldRegistry, methodRegistry, prepend, adapter3.typeAttributeAppender, adapter3.asmVisitorWrapper, adapter3.classFileVersion, adapter3.auxiliaryTypeNamingStrategy, adapter3.annotationValueFilterFactory, adapter3.annotationRetention, adapter3.implementationContextFactory, adapter3.methodGraphCompiler, adapter3.typeValidation, adapter3.visibilityBridgeStrategy, adapter5.classWriterStrategy, adapter5.ignoredMethods, adapter5.auxiliaryTypes);
                    }

                    public RecordComponentDefinition.Optional<U> transform(Transformer<RecordComponentDescription> transformer2) {
                        return new RecordComponentMatchAdapter(this.matcher, this.recordComponentAttributeAppenderFactory, new Transformer.Compound((Transformer<S>[]) new Transformer[]{this.transformer, transformer2}));
                    }

                    protected RecordComponentMatchAdapter(LatentMatcher<? super RecordComponentDescription> latentMatcher, RecordComponentAttributeAppender.Factory factory, Transformer<RecordComponentDescription> transformer2) {
                        this.matcher = latentMatcher;
                        this.recordComponentAttributeAppenderFactory = factory;
                        this.transformer = transformer2;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                protected class TypeVariableDefinitionAdapter extends TypeVariableDefinition.AbstractBase<U> {
                    private final TypeVariableToken token;

                    protected TypeVariableDefinitionAdapter(TypeVariableToken typeVariableToken) {
                        this.token = typeVariableToken;
                    }

                    public TypeVariableDefinition<U> annotateTypeVariable(Collection<? extends AnnotationDescription> collection) {
                        return new TypeVariableDefinitionAdapter(new TypeVariableToken(this.token.getSymbol(), this.token.getBounds(), CompoundList.of(this.token.getAnnotations(), (AnnotationList) new ArrayList(collection))));
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        TypeVariableDefinitionAdapter typeVariableDefinitionAdapter = (TypeVariableDefinitionAdapter) obj;
                        return this.token.equals(typeVariableDefinitionAdapter.token) && Adapter.this.equals(Adapter.this);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.token.hashCode()) * 31) + Adapter.this.hashCode();
                    }

                    /* access modifiers changed from: protected */
                    public Builder<U> materialize() {
                        Adapter adapter = Adapter.this;
                        Adapter adapter2 = adapter;
                        InstrumentedType.WithFlexibleName withTypeVariable = adapter.instrumentedType.withTypeVariable(this.token);
                        Adapter adapter3 = Adapter.this;
                        Adapter adapter4 = adapter2;
                        Adapter adapter5 = adapter3;
                        return adapter4.materialize(withTypeVariable, adapter3.fieldRegistry, adapter3.methodRegistry, adapter3.recordComponentRegistry, adapter3.typeAttributeAppender, adapter3.asmVisitorWrapper, adapter3.classFileVersion, adapter3.auxiliaryTypeNamingStrategy, adapter3.annotationValueFilterFactory, adapter3.annotationRetention, adapter3.implementationContextFactory, adapter3.methodGraphCompiler, adapter3.typeValidation, adapter3.visibilityBridgeStrategy, adapter5.classWriterStrategy, adapter5.ignoredMethods, adapter5.auxiliaryTypes);
                    }
                }

                protected Adapter(InstrumentedType.WithFlexibleName withFlexibleName, FieldRegistry fieldRegistry2, MethodRegistry methodRegistry2, RecordComponentRegistry recordComponentRegistry2, TypeAttributeAppender typeAttributeAppender2, AsmVisitorWrapper asmVisitorWrapper2, ClassFileVersion classFileVersion2, AuxiliaryType.NamingStrategy namingStrategy, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention2, Implementation.Context.Factory factory2, MethodGraph.Compiler compiler, TypeValidation typeValidation2, VisibilityBridgeStrategy visibilityBridgeStrategy2, ClassWriterStrategy classWriterStrategy2, LatentMatcher<? super MethodDescription> latentMatcher, List<? extends DynamicType> list) {
                    this.instrumentedType = withFlexibleName;
                    this.fieldRegistry = fieldRegistry2;
                    this.methodRegistry = methodRegistry2;
                    this.recordComponentRegistry = recordComponentRegistry2;
                    this.typeAttributeAppender = typeAttributeAppender2;
                    this.asmVisitorWrapper = asmVisitorWrapper2;
                    this.classFileVersion = classFileVersion2;
                    this.auxiliaryTypeNamingStrategy = namingStrategy;
                    this.annotationValueFilterFactory = factory;
                    this.annotationRetention = annotationRetention2;
                    this.implementationContextFactory = factory2;
                    this.methodGraphCompiler = compiler;
                    this.typeValidation = typeValidation2;
                    this.visibilityBridgeStrategy = visibilityBridgeStrategy2;
                    this.classWriterStrategy = classWriterStrategy2;
                    this.ignoredMethods = latentMatcher;
                    this.auxiliaryTypes = list;
                }

                public Builder<U> annotateType(Collection<? extends AnnotationDescription> collection) {
                    InstrumentedType.WithFlexibleName withAnnotations = this.instrumentedType.withAnnotations(new ArrayList(collection));
                    InstrumentedType.WithFlexibleName withFlexibleName = withAnnotations;
                    return materialize(withFlexibleName, this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes);
                }

                public Builder<U> attribute(TypeAttributeAppender typeAttributeAppender2) {
                    InstrumentedType.WithFlexibleName withFlexibleName = this.instrumentedType;
                    FieldRegistry fieldRegistry2 = this.fieldRegistry;
                    MethodRegistry methodRegistry2 = this.methodRegistry;
                    RecordComponentRegistry recordComponentRegistry2 = this.recordComponentRegistry;
                    TypeAttributeAppender.Compound compound = r6;
                    TypeAttributeAppender.Compound compound2 = new TypeAttributeAppender.Compound(this.typeAttributeAppender, typeAttributeAppender2);
                    InstrumentedType.WithFlexibleName withFlexibleName2 = withFlexibleName;
                    return materialize(withFlexibleName2, fieldRegistry2, methodRegistry2, recordComponentRegistry2, compound, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes);
                }

                public Builder<U> declaredTypes(Collection<? extends TypeDescription> collection) {
                    InstrumentedType.WithFlexibleName withDeclaredTypes = this.instrumentedType.withDeclaredTypes(new TypeList.Explicit((List<? extends TypeDescription>) new ArrayList(collection)));
                    InstrumentedType.WithFlexibleName withFlexibleName = withDeclaredTypes;
                    return materialize(withFlexibleName, this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes);
                }

                public MethodDefinition.ParameterDefinition.Initial<U> defineConstructor(int i10) {
                    return new MethodDefinitionAdapter(new MethodDescription.Token(i10));
                }

                public FieldDefinition.Optional.Valuable<U> defineField(String str, TypeDefinition typeDefinition, int i10) {
                    return new FieldDefinitionAdapter(this, new FieldDescription.Token(str, i10, typeDefinition.asGenericType()));
                }

                public MethodDefinition.ParameterDefinition.Initial<U> defineMethod(String str, TypeDefinition typeDefinition, int i10) {
                    return new MethodDefinitionAdapter(new MethodDescription.Token(str, i10, typeDefinition.asGenericType()));
                }

                public RecordComponentDefinition.Optional<U> defineRecordComponent(String str, TypeDefinition typeDefinition) {
                    return new RecordComponentDefinitionAdapter(this, new RecordComponentDescription.Token(str, typeDefinition.asGenericType()));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Adapter adapter = (Adapter) obj;
                    return this.annotationRetention.equals(adapter.annotationRetention) && this.typeValidation.equals(adapter.typeValidation) && this.instrumentedType.equals(adapter.instrumentedType) && this.fieldRegistry.equals(adapter.fieldRegistry) && this.methodRegistry.equals(adapter.methodRegistry) && this.recordComponentRegistry.equals(adapter.recordComponentRegistry) && this.typeAttributeAppender.equals(adapter.typeAttributeAppender) && this.asmVisitorWrapper.equals(adapter.asmVisitorWrapper) && this.classFileVersion.equals(adapter.classFileVersion) && this.auxiliaryTypeNamingStrategy.equals(adapter.auxiliaryTypeNamingStrategy) && this.annotationValueFilterFactory.equals(adapter.annotationValueFilterFactory) && this.implementationContextFactory.equals(adapter.implementationContextFactory) && this.methodGraphCompiler.equals(adapter.methodGraphCompiler) && this.visibilityBridgeStrategy.equals(adapter.visibilityBridgeStrategy) && this.classWriterStrategy.equals(adapter.classWriterStrategy) && this.ignoredMethods.equals(adapter.ignoredMethods) && this.auxiliaryTypes.equals(adapter.auxiliaryTypes);
                }

                public FieldDefinition.Valuable<U> field(LatentMatcher<? super FieldDescription> latentMatcher) {
                    return new FieldMatchAdapter(this, latentMatcher);
                }

                public int hashCode() {
                    return (((((((((((((((((((((((((((((((((getClass().hashCode() * 31) + this.instrumentedType.hashCode()) * 31) + this.fieldRegistry.hashCode()) * 31) + this.methodRegistry.hashCode()) * 31) + this.recordComponentRegistry.hashCode()) * 31) + this.typeAttributeAppender.hashCode()) * 31) + this.asmVisitorWrapper.hashCode()) * 31) + this.classFileVersion.hashCode()) * 31) + this.auxiliaryTypeNamingStrategy.hashCode()) * 31) + this.annotationValueFilterFactory.hashCode()) * 31) + this.annotationRetention.hashCode()) * 31) + this.implementationContextFactory.hashCode()) * 31) + this.methodGraphCompiler.hashCode()) * 31) + this.typeValidation.hashCode()) * 31) + this.visibilityBridgeStrategy.hashCode()) * 31) + this.classWriterStrategy.hashCode()) * 31) + this.ignoredMethods.hashCode()) * 31) + this.auxiliaryTypes.hashCode();
                }

                public Builder<U> ignoreAlso(LatentMatcher<? super MethodDescription> latentMatcher) {
                    InstrumentedType.WithFlexibleName withFlexibleName = this.instrumentedType;
                    FieldRegistry fieldRegistry2 = this.fieldRegistry;
                    MethodRegistry methodRegistry2 = this.methodRegistry;
                    RecordComponentRegistry recordComponentRegistry2 = this.recordComponentRegistry;
                    TypeAttributeAppender typeAttributeAppender2 = this.typeAttributeAppender;
                    AsmVisitorWrapper asmVisitorWrapper2 = this.asmVisitorWrapper;
                    ClassFileVersion classFileVersion2 = this.classFileVersion;
                    AuxiliaryType.NamingStrategy namingStrategy = this.auxiliaryTypeNamingStrategy;
                    AnnotationValueFilter.Factory factory = this.annotationValueFilterFactory;
                    AnnotationRetention annotationRetention2 = this.annotationRetention;
                    Implementation.Context.Factory factory2 = this.implementationContextFactory;
                    MethodGraph.Compiler compiler = this.methodGraphCompiler;
                    TypeValidation typeValidation2 = this.typeValidation;
                    VisibilityBridgeStrategy visibilityBridgeStrategy2 = this.visibilityBridgeStrategy;
                    InstrumentedType.WithFlexibleName withFlexibleName2 = withFlexibleName;
                    ClassWriterStrategy classWriterStrategy2 = this.classWriterStrategy;
                    LatentMatcher.Disjunction disjunction = r0;
                    FieldRegistry fieldRegistry3 = fieldRegistry2;
                    MethodRegistry methodRegistry3 = methodRegistry2;
                    LatentMatcher.Disjunction disjunction2 = new LatentMatcher.Disjunction((LatentMatcher<? super S>[]) new LatentMatcher[]{this.ignoredMethods, latentMatcher});
                    return materialize(withFlexibleName2, fieldRegistry3, methodRegistry3, recordComponentRegistry2, typeAttributeAppender2, asmVisitorWrapper2, classFileVersion2, namingStrategy, factory, annotationRetention2, factory2, compiler, typeValidation2, visibilityBridgeStrategy2, classWriterStrategy2, disjunction, this.auxiliaryTypes);
                }

                public MethodDefinition.ImplementationDefinition.Optional<U> implement(Collection<? extends TypeDefinition> collection) {
                    return new OptionalMethodMatchAdapter(new TypeList.Generic.Explicit((List<? extends TypeDefinition>) new ArrayList(collection)));
                }

                public Builder<U> initializer(ByteCodeAppender byteCodeAppender) {
                    InstrumentedType.WithFlexibleName withInitializer = this.instrumentedType.withInitializer(byteCodeAppender);
                    InstrumentedType.WithFlexibleName withFlexibleName = withInitializer;
                    return materialize(withFlexibleName, this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes);
                }

                public InnerTypeDefinition.ForType<U> innerTypeOf(TypeDescription typeDescription) {
                    return new InnerTypeDefinitionForTypeAdapter(typeDescription);
                }

                public MethodDefinition.ImplementationDefinition<U> invokable(LatentMatcher<? super MethodDescription> latentMatcher) {
                    return new MethodMatchAdapter(latentMatcher);
                }

                /* access modifiers changed from: protected */
                public abstract Builder<U> materialize(InstrumentedType.WithFlexibleName withFlexibleName, FieldRegistry fieldRegistry2, MethodRegistry methodRegistry2, RecordComponentRegistry recordComponentRegistry2, TypeAttributeAppender typeAttributeAppender2, AsmVisitorWrapper asmVisitorWrapper2, ClassFileVersion classFileVersion2, AuxiliaryType.NamingStrategy namingStrategy, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention2, Implementation.Context.Factory factory2, MethodGraph.Compiler compiler, TypeValidation typeValidation2, VisibilityBridgeStrategy visibilityBridgeStrategy2, ClassWriterStrategy classWriterStrategy2, LatentMatcher<? super MethodDescription> latentMatcher, List<? extends DynamicType> list);

                public Builder<U> merge(Collection<? extends ModifierContributor.ForType> collection) {
                    InstrumentedType.WithFlexibleName withModifiers = this.instrumentedType.withModifiers(ModifierContributor.Resolver.of(collection).resolve(this.instrumentedType.getModifiers()));
                    InstrumentedType.WithFlexibleName withFlexibleName = withModifiers;
                    return materialize(withFlexibleName, this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes);
                }

                public Builder<U> modifiers(int i10) {
                    InstrumentedType.WithFlexibleName withModifiers = this.instrumentedType.withModifiers(i10);
                    InstrumentedType.WithFlexibleName withFlexibleName = withModifiers;
                    return materialize(withFlexibleName, this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes);
                }

                public Builder<U> name(String str) {
                    InstrumentedType.WithFlexibleName withName = this.instrumentedType.withName(str);
                    InstrumentedType.WithFlexibleName withFlexibleName = withName;
                    return materialize(withFlexibleName, this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes);
                }

                public Builder<U> nestHost(TypeDescription typeDescription) {
                    InstrumentedType.WithFlexibleName withNestHost = this.instrumentedType.withNestHost(typeDescription);
                    InstrumentedType.WithFlexibleName withFlexibleName = withNestHost;
                    return materialize(withFlexibleName, this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes);
                }

                public Builder<U> nestMembers(Collection<? extends TypeDescription> collection) {
                    InstrumentedType.WithFlexibleName withNestMembers = this.instrumentedType.withNestMembers(new TypeList.Explicit((List<? extends TypeDescription>) new ArrayList(collection)));
                    InstrumentedType.WithFlexibleName withFlexibleName = withNestMembers;
                    return materialize(withFlexibleName, this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes);
                }

                public Builder<U> permittedSubclass(Collection<? extends TypeDescription> collection) {
                    InstrumentedType.WithFlexibleName withPermittedSubclasses = this.instrumentedType.withPermittedSubclasses(new TypeList.Explicit((List<? extends TypeDescription>) new ArrayList(collection)));
                    InstrumentedType.WithFlexibleName withFlexibleName = withPermittedSubclasses;
                    return materialize(withFlexibleName, this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes);
                }

                public RecordComponentDefinition<U> recordComponent(LatentMatcher<? super RecordComponentDescription> latentMatcher) {
                    return new RecordComponentMatchAdapter(this, latentMatcher);
                }

                public Builder<U> require(Collection<DynamicType> collection) {
                    InstrumentedType.WithFlexibleName withFlexibleName = this.instrumentedType;
                    FieldRegistry fieldRegistry2 = this.fieldRegistry;
                    InstrumentedType.WithFlexibleName withFlexibleName2 = withFlexibleName;
                    return materialize(withFlexibleName2, fieldRegistry2, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, CompoundList.of(this.auxiliaryTypes, (List<? extends DynamicType>) new ArrayList(collection)));
                }

                public Builder<U> suffix(String str) {
                    return name(this.instrumentedType.getName() + "$" + str);
                }

                public TypeDescription toTypeDescription() {
                    return this.instrumentedType;
                }

                public Builder<U> topLevelType() {
                    InstrumentedType.WithFlexibleName withFlexibleName = this.instrumentedType;
                    TypeDescription typeDescription = TypeDescription.UNDEFINED;
                    InstrumentedType.WithFlexibleName withLocalClass = withFlexibleName.withDeclaringType(typeDescription).withEnclosingType(typeDescription).withLocalClass(false);
                    InstrumentedType.WithFlexibleName withFlexibleName2 = withLocalClass;
                    return materialize(withFlexibleName2, this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes);
                }

                public Builder<U> transform(ElementMatcher<? super TypeDescription.Generic> elementMatcher, Transformer<TypeVariableToken> transformer) {
                    InstrumentedType.WithFlexibleName withTypeVariables = this.instrumentedType.withTypeVariables(elementMatcher, transformer);
                    InstrumentedType.WithFlexibleName withFlexibleName = withTypeVariables;
                    return materialize(withFlexibleName, this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes);
                }

                public TypeVariableDefinition<U> typeVariable(String str, Collection<? extends TypeDefinition> collection) {
                    return new TypeVariableDefinitionAdapter(new TypeVariableToken(str, new TypeList.Generic.Explicit((List<? extends TypeDefinition>) new ArrayList(collection))));
                }

                public Builder<U> unsealed() {
                    InstrumentedType.WithFlexibleName withPermittedSubclasses = this.instrumentedType.withPermittedSubclasses(TypeList.UNDEFINED);
                    InstrumentedType.WithFlexibleName withFlexibleName = withPermittedSubclasses;
                    return materialize(withFlexibleName, this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes);
                }

                public Builder<U> visit(AsmVisitorWrapper asmVisitorWrapper2) {
                    InstrumentedType.WithFlexibleName withFlexibleName = this.instrumentedType;
                    FieldRegistry fieldRegistry2 = this.fieldRegistry;
                    MethodRegistry methodRegistry2 = this.methodRegistry;
                    RecordComponentRegistry recordComponentRegistry2 = this.recordComponentRegistry;
                    TypeAttributeAppender typeAttributeAppender2 = this.typeAttributeAppender;
                    AsmVisitorWrapper.Compound compound = r7;
                    AsmVisitorWrapper.Compound compound2 = new AsmVisitorWrapper.Compound(this.asmVisitorWrapper, asmVisitorWrapper2);
                    InstrumentedType.WithFlexibleName withFlexibleName2 = withFlexibleName;
                    return materialize(withFlexibleName2, fieldRegistry2, methodRegistry2, recordComponentRegistry2, typeAttributeAppender2, compound, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes);
                }

                public Builder<U> initializer(LoadedTypeInitializer loadedTypeInitializer) {
                    InstrumentedType.WithFlexibleName withInitializer = this.instrumentedType.withInitializer(loadedTypeInitializer);
                    InstrumentedType.WithFlexibleName withFlexibleName = withInitializer;
                    return materialize(withFlexibleName, this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes);
                }

                public InnerTypeDefinition<U> innerTypeOf(MethodDescription.InDefinedShape inDefinedShape) {
                    return inDefinedShape.isTypeInitializer() ? new InnerTypeDefinitionForTypeAdapter(inDefinedShape.getDeclaringType()) : new InnerTypeDefinitionForMethodAdapter(inDefinedShape);
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                protected class FieldDefinitionAdapter extends FieldDefinition.Optional.Valuable.AbstractBase.Adapter<U> {
                    private final FieldDescription.Token token;

                    protected FieldDefinitionAdapter(Adapter adapter, FieldDescription.Token token2) {
                        this(FieldAttributeAppender.ForInstrumentedField.INSTANCE, Transformer.NoOp.make(), FieldDescription.NO_DEFAULT_VALUE, token2);
                    }

                    public FieldDefinition.Optional<U> annotateField(Collection<? extends AnnotationDescription> collection) {
                        return new FieldDefinitionAdapter(this.fieldAttributeAppenderFactory, this.transformer, this.defaultValue, new FieldDescription.Token(this.token.getName(), this.token.getModifiers(), this.token.getType(), CompoundList.of(this.token.getAnnotations(), (AnnotationList) new ArrayList(collection))));
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        FieldDefinitionAdapter fieldDefinitionAdapter = (FieldDefinitionAdapter) obj;
                        return this.token.equals(fieldDefinitionAdapter.token) && Adapter.this.equals(Adapter.this);
                    }

                    public int hashCode() {
                        return (((super.hashCode() * 31) + this.token.hashCode()) * 31) + Adapter.this.hashCode();
                    }

                    /* access modifiers changed from: protected */
                    public Builder<U> materialize() {
                        Adapter adapter = Adapter.this;
                        Adapter adapter2 = adapter;
                        InstrumentedType.WithFlexibleName withField = adapter.instrumentedType.withField(this.token);
                        FieldRegistry prepend = Adapter.this.fieldRegistry.prepend(new LatentMatcher.ForFieldToken(this.token), this.fieldAttributeAppenderFactory, this.defaultValue, this.transformer);
                        Adapter adapter3 = Adapter.this;
                        Adapter adapter4 = adapter2;
                        Adapter adapter5 = adapter3;
                        return adapter4.materialize(withField, prepend, adapter3.methodRegistry, adapter3.recordComponentRegistry, adapter3.typeAttributeAppender, adapter3.asmVisitorWrapper, adapter3.classFileVersion, adapter3.auxiliaryTypeNamingStrategy, adapter3.annotationValueFilterFactory, adapter3.annotationRetention, adapter3.implementationContextFactory, adapter3.methodGraphCompiler, adapter3.typeValidation, adapter3.visibilityBridgeStrategy, adapter5.classWriterStrategy, adapter5.ignoredMethods, adapter5.auxiliaryTypes);
                    }

                    protected FieldDefinitionAdapter(FieldAttributeAppender.Factory factory, Transformer<FieldDescription> transformer, @MaybeNull Object obj, FieldDescription.Token token2) {
                        super(factory, transformer, obj);
                        this.token = token2;
                    }

                    /* access modifiers changed from: protected */
                    public FieldDefinition.Optional<U> materialize(FieldAttributeAppender.Factory factory, Transformer<FieldDescription> transformer, @MaybeNull Object obj) {
                        return new FieldDefinitionAdapter(factory, transformer, obj, this.token);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                protected class FieldMatchAdapter extends FieldDefinition.Optional.Valuable.AbstractBase.Adapter<U> {
                    private final LatentMatcher<? super FieldDescription> matcher;

                    protected FieldMatchAdapter(Adapter adapter, LatentMatcher<? super FieldDescription> latentMatcher) {
                        this(FieldAttributeAppender.NoOp.INSTANCE, Transformer.NoOp.make(), FieldDescription.NO_DEFAULT_VALUE, latentMatcher);
                    }

                    public FieldDefinition.Optional<U> annotateField(Collection<? extends AnnotationDescription> collection) {
                        return attribute(new FieldAttributeAppender.Explicit(new ArrayList(collection)));
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        FieldMatchAdapter fieldMatchAdapter = (FieldMatchAdapter) obj;
                        return this.matcher.equals(fieldMatchAdapter.matcher) && Adapter.this.equals(Adapter.this);
                    }

                    public int hashCode() {
                        return (((super.hashCode() * 31) + this.matcher.hashCode()) * 31) + Adapter.this.hashCode();
                    }

                    /* access modifiers changed from: protected */
                    public Builder<U> materialize() {
                        Adapter adapter = Adapter.this;
                        Adapter adapter2 = adapter;
                        InstrumentedType.WithFlexibleName withFlexibleName = adapter.instrumentedType;
                        FieldRegistry prepend = adapter.fieldRegistry.prepend(this.matcher, this.fieldAttributeAppenderFactory, this.defaultValue, this.transformer);
                        Adapter adapter3 = Adapter.this;
                        Adapter adapter4 = adapter2;
                        Adapter adapter5 = adapter3;
                        return adapter4.materialize(withFlexibleName, prepend, adapter3.methodRegistry, adapter3.recordComponentRegistry, adapter3.typeAttributeAppender, adapter3.asmVisitorWrapper, adapter3.classFileVersion, adapter3.auxiliaryTypeNamingStrategy, adapter3.annotationValueFilterFactory, adapter3.annotationRetention, adapter3.implementationContextFactory, adapter3.methodGraphCompiler, adapter3.typeValidation, adapter3.visibilityBridgeStrategy, adapter5.classWriterStrategy, adapter5.ignoredMethods, adapter5.auxiliaryTypes);
                    }

                    protected FieldMatchAdapter(FieldAttributeAppender.Factory factory, Transformer<FieldDescription> transformer, @MaybeNull Object obj, LatentMatcher<? super FieldDescription> latentMatcher) {
                        super(factory, transformer, obj);
                        this.matcher = latentMatcher;
                    }

                    /* access modifiers changed from: protected */
                    public FieldDefinition.Optional<U> materialize(FieldAttributeAppender.Factory factory, Transformer<FieldDescription> transformer, @MaybeNull Object obj) {
                        return new FieldMatchAdapter(factory, transformer, obj, this.matcher);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                protected class RecordComponentDefinitionAdapter extends RecordComponentDefinition.Optional.AbstractBase<U> {
                    private final RecordComponentAttributeAppender.Factory recordComponentAttributeAppenderFactory;
                    private final RecordComponentDescription.Token token;
                    private final Transformer<RecordComponentDescription> transformer;

                    protected RecordComponentDefinitionAdapter(Adapter adapter, RecordComponentDescription.Token token2) {
                        this(RecordComponentAttributeAppender.ForInstrumentedRecordComponent.INSTANCE, Transformer.NoOp.make(), token2);
                    }

                    public RecordComponentDefinition.Optional<U> annotateRecordComponent(Collection<? extends AnnotationDescription> collection) {
                        return new RecordComponentDefinitionAdapter(this.recordComponentAttributeAppenderFactory, this.transformer, new RecordComponentDescription.Token(this.token.getName(), this.token.getType(), CompoundList.of(this.token.getAnnotations(), (AnnotationList) new ArrayList(collection))));
                    }

                    public RecordComponentDefinition.Optional<U> attribute(RecordComponentAttributeAppender.Factory factory) {
                        return new RecordComponentDefinitionAdapter(new RecordComponentAttributeAppender.Factory.Compound(this.recordComponentAttributeAppenderFactory, factory), this.transformer, this.token);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        RecordComponentDefinitionAdapter recordComponentDefinitionAdapter = (RecordComponentDefinitionAdapter) obj;
                        return this.recordComponentAttributeAppenderFactory.equals(recordComponentDefinitionAdapter.recordComponentAttributeAppenderFactory) && this.token.equals(recordComponentDefinitionAdapter.token) && this.transformer.equals(recordComponentDefinitionAdapter.transformer) && Adapter.this.equals(Adapter.this);
                    }

                    public int hashCode() {
                        return (((((((getClass().hashCode() * 31) + this.recordComponentAttributeAppenderFactory.hashCode()) * 31) + this.token.hashCode()) * 31) + this.transformer.hashCode()) * 31) + Adapter.this.hashCode();
                    }

                    /* access modifiers changed from: protected */
                    public Builder<U> materialize() {
                        Adapter adapter = Adapter.this;
                        Adapter adapter2 = adapter;
                        InstrumentedType.WithFlexibleName withRecordComponent = adapter.instrumentedType.withRecordComponent(this.token);
                        Adapter adapter3 = Adapter.this;
                        FieldRegistry fieldRegistry = adapter3.fieldRegistry;
                        MethodRegistry methodRegistry = adapter3.methodRegistry;
                        RecordComponentRegistry prepend = adapter3.recordComponentRegistry.prepend(new LatentMatcher.ForRecordComponentToken(this.token), this.recordComponentAttributeAppenderFactory, this.transformer);
                        Adapter adapter4 = Adapter.this;
                        Adapter adapter5 = adapter2;
                        Adapter adapter6 = adapter4;
                        return adapter5.materialize(withRecordComponent, fieldRegistry, methodRegistry, prepend, adapter4.typeAttributeAppender, adapter4.asmVisitorWrapper, adapter4.classFileVersion, adapter4.auxiliaryTypeNamingStrategy, adapter4.annotationValueFilterFactory, adapter4.annotationRetention, adapter4.implementationContextFactory, adapter4.methodGraphCompiler, adapter4.typeValidation, adapter4.visibilityBridgeStrategy, adapter6.classWriterStrategy, adapter6.ignoredMethods, adapter6.auxiliaryTypes);
                    }

                    public RecordComponentDefinition.Optional<U> transform(Transformer<RecordComponentDescription> transformer2) {
                        return new RecordComponentDefinitionAdapter(this.recordComponentAttributeAppenderFactory, new Transformer.Compound((Transformer<S>[]) new Transformer[]{this.transformer, transformer2}), this.token);
                    }

                    protected RecordComponentDefinitionAdapter(RecordComponentAttributeAppender.Factory factory, Transformer<RecordComponentDescription> transformer2, RecordComponentDescription.Token token2) {
                        this.recordComponentAttributeAppenderFactory = factory;
                        this.transformer = transformer2;
                        this.token = token2;
                    }
                }
            }

            public static abstract class Delegator<U> extends AbstractBase<U> {
                public Builder<U> annotateType(Collection<? extends AnnotationDescription> collection) {
                    return materialize().annotateType(collection);
                }

                public Builder<U> attribute(TypeAttributeAppender typeAttributeAppender) {
                    return materialize().attribute(typeAttributeAppender);
                }

                public Builder<U> declaredTypes(Collection<? extends TypeDescription> collection) {
                    return materialize().declaredTypes(collection);
                }

                public RecordComponentDefinition.Optional<U> define(RecordComponentDescription recordComponentDescription) {
                    return materialize().define(recordComponentDescription);
                }

                public MethodDefinition.ParameterDefinition.Initial<U> defineConstructor(int i10) {
                    return materialize().defineConstructor(i10);
                }

                public FieldDefinition.Optional.Valuable<U> defineField(String str, TypeDefinition typeDefinition, int i10) {
                    return materialize().defineField(str, typeDefinition, i10);
                }

                public MethodDefinition.ParameterDefinition.Initial<U> defineMethod(String str, TypeDefinition typeDefinition, int i10) {
                    return materialize().defineMethod(str, typeDefinition, i10);
                }

                public RecordComponentDefinition.Optional<U> defineRecordComponent(String str, TypeDefinition typeDefinition) {
                    return materialize().defineRecordComponent(str, typeDefinition);
                }

                public FieldDefinition.Valuable<U> field(LatentMatcher<? super FieldDescription> latentMatcher) {
                    return materialize().field(latentMatcher);
                }

                public Builder<U> ignoreAlso(ElementMatcher<? super MethodDescription> elementMatcher) {
                    return materialize().ignoreAlso(elementMatcher);
                }

                public MethodDefinition.ImplementationDefinition.Optional<U> implement(Collection<? extends TypeDefinition> collection) {
                    return materialize().implement(collection);
                }

                public Builder<U> initializer(LoadedTypeInitializer loadedTypeInitializer) {
                    return materialize().initializer(loadedTypeInitializer);
                }

                public InnerTypeDefinition.ForType<U> innerTypeOf(TypeDescription typeDescription) {
                    return materialize().innerTypeOf(typeDescription);
                }

                public MethodDefinition.ImplementationDefinition<U> invokable(LatentMatcher<? super MethodDescription> latentMatcher) {
                    return materialize().invokable(latentMatcher);
                }

                public Unloaded<U> make() {
                    return materialize().make();
                }

                /* access modifiers changed from: protected */
                public abstract Builder<U> materialize();

                public Builder<U> merge(Collection<? extends ModifierContributor.ForType> collection) {
                    return materialize().merge(collection);
                }

                public Builder<U> modifiers(int i10) {
                    return materialize().modifiers(i10);
                }

                public Builder<U> name(String str) {
                    return materialize().name(str);
                }

                public Builder<U> nestHost(TypeDescription typeDescription) {
                    return materialize().nestHost(typeDescription);
                }

                public Builder<U> nestMembers(Collection<? extends TypeDescription> collection) {
                    return materialize().nestMembers(collection);
                }

                public Builder<U> permittedSubclass(Collection<? extends TypeDescription> collection) {
                    return materialize().permittedSubclass(collection);
                }

                public RecordComponentDefinition<U> recordComponent(ElementMatcher<? super RecordComponentDescription> elementMatcher) {
                    return materialize().recordComponent(elementMatcher);
                }

                public Builder<U> require(Collection<DynamicType> collection) {
                    return materialize().require(collection);
                }

                public Builder<U> suffix(String str) {
                    return materialize().suffix(str);
                }

                public TypeDescription toTypeDescription() {
                    return materialize().toTypeDescription();
                }

                public Builder<U> topLevelType() {
                    return materialize().topLevelType();
                }

                public Builder<U> transform(ElementMatcher<? super TypeDescription.Generic> elementMatcher, Transformer<TypeVariableToken> transformer) {
                    return materialize().transform(elementMatcher, transformer);
                }

                public TypeVariableDefinition<U> typeVariable(String str, Collection<? extends TypeDefinition> collection) {
                    return materialize().typeVariable(str, collection);
                }

                public Builder<U> unsealed() {
                    return materialize().unsealed();
                }

                public Builder<U> visit(AsmVisitorWrapper asmVisitorWrapper) {
                    return materialize().visit(asmVisitorWrapper);
                }

                public ContextClassVisitor wrap(ClassVisitor classVisitor, int i10, int i11) {
                    return materialize().wrap(classVisitor, i10, i11);
                }

                public Builder<U> ignoreAlso(LatentMatcher<? super MethodDescription> latentMatcher) {
                    return materialize().ignoreAlso(latentMatcher);
                }

                public Builder<U> initializer(ByteCodeAppender byteCodeAppender) {
                    return materialize().initializer(byteCodeAppender);
                }

                public InnerTypeDefinition<U> innerTypeOf(MethodDescription.InDefinedShape inDefinedShape) {
                    return materialize().innerTypeOf(inDefinedShape);
                }

                public Unloaded<U> make(TypeResolutionStrategy typeResolutionStrategy) {
                    return materialize().make(typeResolutionStrategy);
                }

                public RecordComponentDefinition<U> recordComponent(LatentMatcher<? super RecordComponentDescription> latentMatcher) {
                    return materialize().recordComponent(latentMatcher);
                }

                public ContextClassVisitor wrap(ClassVisitor classVisitor, TypePool typePool, int i10, int i11) {
                    return materialize().wrap(classVisitor, typePool, i10, i11);
                }

                public Unloaded<U> make(TypePool typePool) {
                    return materialize().make(typePool);
                }

                public Unloaded<U> make(TypeResolutionStrategy typeResolutionStrategy, TypePool typePool) {
                    return materialize().make(typeResolutionStrategy, typePool);
                }
            }

            public static abstract class UsingTypeWriter<U> extends AbstractBase<U> {
                public Unloaded<U> make(TypeResolutionStrategy typeResolutionStrategy) {
                    return toTypeWriter().make(typeResolutionStrategy.resolve());
                }

                /* access modifiers changed from: protected */
                public abstract TypeWriter<U> toTypeWriter();

                /* access modifiers changed from: protected */
                public abstract TypeWriter<U> toTypeWriter(TypePool typePool);

                public ContextClassVisitor wrap(ClassVisitor classVisitor, int i10, int i11) {
                    return toTypeWriter().wrap(classVisitor, i10, i11);
                }

                public Unloaded<U> make(TypeResolutionStrategy typeResolutionStrategy, TypePool typePool) {
                    return toTypeWriter(typePool).make(typeResolutionStrategy.resolve());
                }

                public ContextClassVisitor wrap(ClassVisitor classVisitor, TypePool typePool, int i10, int i11) {
                    return toTypeWriter(typePool).wrap(classVisitor, i10, i11);
                }
            }

            public Builder<S> annotateType(Annotation... annotationArr) {
                return annotateType((List<? extends Annotation>) Arrays.asList(annotationArr));
            }

            public MethodDefinition.ImplementationDefinition<S> constructor(ElementMatcher<? super MethodDescription> elementMatcher) {
                return invokable(ElementMatchers.isConstructor().and(elementMatcher));
            }

            public Builder<S> declaredTypes(Class<?>... clsArr) {
                return declaredTypes((List<? extends Class<?>>) Arrays.asList(clsArr));
            }

            public RecordComponentDefinition.Optional<S> define(RecordComponentDescription recordComponentDescription) {
                return defineRecordComponent(recordComponentDescription.getActualName(), (TypeDefinition) recordComponentDescription.getType());
            }

            public MethodDefinition.ParameterDefinition.Initial<S> defineConstructor(ModifierContributor.ForMethod... forMethodArr) {
                return defineConstructor((Collection<? extends ModifierContributor.ForMethod>) Arrays.asList(forMethodArr));
            }

            public FieldDefinition.Optional.Valuable<S> defineField(String str, Type type, ModifierContributor.ForField... forFieldArr) {
                return defineField(str, type, (Collection<? extends ModifierContributor.ForField>) Arrays.asList(forFieldArr));
            }

            public MethodDefinition.ParameterDefinition.Initial<S> defineMethod(String str, Type type, ModifierContributor.ForMethod... forMethodArr) {
                return defineMethod(str, type, (Collection<? extends ModifierContributor.ForMethod>) Arrays.asList(forMethodArr));
            }

            public FieldDefinition.Optional<S> defineProperty(String str, Type type) {
                return defineProperty(str, (TypeDefinition) TypeDefinition.Sort.describe(type));
            }

            public RecordComponentDefinition.Optional<S> defineRecordComponent(String str, Type type) {
                return defineRecordComponent(str, (TypeDefinition) TypeDefinition.Sort.describe(type));
            }

            public FieldDefinition.Valuable<S> field(ElementMatcher<? super FieldDescription> elementMatcher) {
                return field((LatentMatcher<? super FieldDescription>) new LatentMatcher.Resolved(elementMatcher));
            }

            public Builder<S> ignoreAlso(ElementMatcher<? super MethodDescription> elementMatcher) {
                return ignoreAlso((LatentMatcher<? super MethodDescription>) new LatentMatcher.Resolved(elementMatcher));
            }

            public MethodDefinition.ImplementationDefinition.Optional<S> implement(Type... typeArr) {
                return implement((List<? extends Type>) Arrays.asList(typeArr));
            }

            public InnerTypeDefinition.ForType<S> innerTypeOf(Class<?> cls) {
                return innerTypeOf(TypeDescription.ForLoadedType.of(cls));
            }

            public MethodDefinition.ImplementationDefinition<S> invokable(ElementMatcher<? super MethodDescription> elementMatcher) {
                return invokable((LatentMatcher<? super MethodDescription>) new LatentMatcher.Resolved(elementMatcher));
            }

            public Unloaded<S> make(TypePool typePool) {
                return make(TypeResolutionStrategy.Passive.INSTANCE, typePool);
            }

            public Builder<S> merge(ModifierContributor.ForType... forTypeArr) {
                return merge((Collection<? extends ModifierContributor.ForType>) Arrays.asList(forTypeArr));
            }

            public MethodDefinition.ImplementationDefinition<S> method(ElementMatcher<? super MethodDescription> elementMatcher) {
                return invokable(ElementMatchers.isMethod().and(elementMatcher));
            }

            public Builder<S> modifiers(ModifierContributor.ForType... forTypeArr) {
                return modifiers((Collection<? extends ModifierContributor.ForType>) Arrays.asList(forTypeArr));
            }

            public Builder<S> nestHost(Class<?> cls) {
                return nestHost(TypeDescription.ForLoadedType.of(cls));
            }

            public Builder<S> nestMembers(Class<?>... clsArr) {
                return nestMembers((List<? extends Class<?>>) Arrays.asList(clsArr));
            }

            public Builder<S> noNestMate() {
                return nestHost(TargetType.DESCRIPTION);
            }

            public Builder<S> permittedSubclass(Class<?>... clsArr) {
                return permittedSubclass((List<? extends Class<?>>) Arrays.asList(clsArr));
            }

            public RecordComponentDefinition<S> recordComponent(ElementMatcher<? super RecordComponentDescription> elementMatcher) {
                return recordComponent((LatentMatcher<? super RecordComponentDescription>) new LatentMatcher.Resolved(elementMatcher));
            }

            public Builder<S> require(TypeDescription typeDescription, byte[] bArr) {
                return require(typeDescription, bArr, LoadedTypeInitializer.NoOp.INSTANCE);
            }

            public FieldDefinition.Optional<S> serialVersionUid(long j10) {
                return defineField("serialVersionUID", (Type) Long.TYPE, Visibility.PRIVATE, FieldManifestation.FINAL, Ownership.STATIC).value(j10);
            }

            public TypeVariableDefinition<S> typeVariable(String str) {
                return typeVariable(str, TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class));
            }

            public Builder<S> withHashCodeEquals() {
                return method(ElementMatchers.isHashCode()).intercept(HashCodeMethod.usingDefaultOffset().withIgnoredFields(ElementMatchers.isSynthetic())).method(ElementMatchers.isEquals()).intercept(EqualsMethod.isolated().withIgnoredFields(ElementMatchers.isSynthetic()));
            }

            public Builder<S> withToString() {
                return method(ElementMatchers.isToString()).intercept(ToStringMethod.prefixedBySimpleClassName());
            }

            public ContextClassVisitor wrap(ClassVisitor classVisitor) {
                return wrap(classVisitor, 0, 0);
            }

            public Builder<S> annotateType(List<? extends Annotation> list) {
                return annotateType((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
            }

            public Builder<S> declaredTypes(TypeDescription... typeDescriptionArr) {
                return declaredTypes((Collection<? extends TypeDescription>) Arrays.asList(typeDescriptionArr));
            }

            public FieldDefinition.Optional.Valuable<S> define(Field field) {
                return define((FieldDescription) new FieldDescription.ForLoadedField(field));
            }

            public MethodDefinition.ParameterDefinition.Initial<S> defineConstructor(Collection<? extends ModifierContributor.ForMethod> collection) {
                return defineConstructor(ModifierContributor.Resolver.of(collection).resolve());
            }

            public FieldDefinition.Optional.Valuable<S> defineField(String str, Type type, Collection<? extends ModifierContributor.ForField> collection) {
                return defineField(str, type, ModifierContributor.Resolver.of(collection).resolve());
            }

            public MethodDefinition.ParameterDefinition.Initial<S> defineMethod(String str, Type type, Collection<? extends ModifierContributor.ForMethod> collection) {
                return defineMethod(str, type, ModifierContributor.Resolver.of(collection).resolve());
            }

            public FieldDefinition.Optional<S> defineProperty(String str, Type type, boolean z10) {
                return defineProperty(str, (TypeDefinition) TypeDefinition.Sort.describe(type), z10);
            }

            public MethodDefinition.ImplementationDefinition.Optional<S> implement(List<? extends Type> list) {
                return implement((Collection<? extends TypeDefinition>) new TypeList.Generic.ForLoadedTypes(list));
            }

            public InnerTypeDefinition<S> innerTypeOf(Method method) {
                return innerTypeOf((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(method));
            }

            public Unloaded<S> make() {
                return make((TypeResolutionStrategy) TypeResolutionStrategy.Passive.INSTANCE);
            }

            public Builder<S> modifiers(Collection<? extends ModifierContributor.ForType> collection) {
                return modifiers(ModifierContributor.Resolver.of(collection).resolve());
            }

            public Builder<S> nestMembers(TypeDescription... typeDescriptionArr) {
                return nestMembers((Collection<? extends TypeDescription>) Arrays.asList(typeDescriptionArr));
            }

            public Builder<S> permittedSubclass(TypeDescription... typeDescriptionArr) {
                return permittedSubclass((Collection<? extends TypeDescription>) Arrays.asList(typeDescriptionArr));
            }

            public Builder<S> require(TypeDescription typeDescription, byte[] bArr, LoadedTypeInitializer loadedTypeInitializer) {
                return require(new Default(typeDescription, bArr, loadedTypeInitializer, Collections.emptyList()));
            }

            public TypeVariableDefinition<S> typeVariable(String str, Type... typeArr) {
                return typeVariable(str, (List<? extends Type>) Arrays.asList(typeArr));
            }

            public ContextClassVisitor wrap(ClassVisitor classVisitor, TypePool typePool) {
                return wrap(classVisitor, typePool, 0, 0);
            }

            public Builder<S> annotateType(AnnotationDescription... annotationDescriptionArr) {
                return annotateType((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
            }

            public Builder<S> declaredTypes(List<? extends Class<?>> list) {
                return declaredTypes((Collection<? extends TypeDescription>) new TypeList.ForLoadedTypes(list));
            }

            public FieldDefinition.Optional.Valuable<S> define(FieldDescription fieldDescription) {
                return defineField(fieldDescription.getName(), (TypeDefinition) fieldDescription.getType(), fieldDescription.getModifiers());
            }

            public FieldDefinition.Optional.Valuable<S> defineField(String str, Type type, int i10) {
                return defineField(str, (TypeDefinition) TypeDefinition.Sort.describe(type), i10);
            }

            public MethodDefinition.ParameterDefinition.Initial<S> defineMethod(String str, Type type, int i10) {
                return defineMethod(str, (TypeDefinition) TypeDefinition.Sort.describe(type), i10);
            }

            public FieldDefinition.Optional<S> defineProperty(String str, TypeDefinition typeDefinition) {
                return defineProperty(str, typeDefinition, false);
            }

            public MethodDefinition.ImplementationDefinition.Optional<S> implement(TypeDefinition... typeDefinitionArr) {
                return implement((Collection<? extends TypeDefinition>) Arrays.asList(typeDefinitionArr));
            }

            public InnerTypeDefinition<S> innerTypeOf(Constructor<?> constructor) {
                return innerTypeOf((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedConstructor(constructor));
            }

            public Builder<S> nestMembers(List<? extends Class<?>> list) {
                return nestMembers((Collection<? extends TypeDescription>) new TypeList.ForLoadedTypes(list));
            }

            public Builder<S> permittedSubclass(List<? extends Class<?>> list) {
                return permittedSubclass((Collection<? extends TypeDescription>) new TypeList.ForLoadedTypes(list));
            }

            public Builder<S> require(DynamicType... dynamicTypeArr) {
                return require((Collection<DynamicType>) Arrays.asList(dynamicTypeArr));
            }

            public TypeVariableDefinition<S> typeVariable(String str, List<? extends Type> list) {
                return typeVariable(str, (Collection<? extends TypeDefinition>) new TypeList.Generic.ForLoadedTypes(list));
            }

            public MethodDefinition.ImplementationDefinition<S> define(Method method) {
                return define((MethodDescription) new MethodDescription.ForLoadedMethod(method));
            }

            public FieldDefinition.Optional.Valuable<S> defineField(String str, TypeDefinition typeDefinition, ModifierContributor.ForField... forFieldArr) {
                return defineField(str, typeDefinition, (Collection<? extends ModifierContributor.ForField>) Arrays.asList(forFieldArr));
            }

            public MethodDefinition.ParameterDefinition.Initial<S> defineMethod(String str, TypeDefinition typeDefinition, ModifierContributor.ForMethod... forMethodArr) {
                return defineMethod(str, typeDefinition, (Collection<? extends ModifierContributor.ForMethod>) Arrays.asList(forMethodArr));
            }

            public FieldDefinition.Optional<S> defineProperty(String str, TypeDefinition typeDefinition, boolean z10) {
                Builder builder;
                FieldManifestation fieldManifestation;
                if (str.length() == 0) {
                    throw new IllegalArgumentException("A bean property cannot have an empty name");
                } else if (!typeDefinition.represents(Void.TYPE)) {
                    if (!z10) {
                        builder = defineMethod("set" + Character.toUpperCase(str.charAt(0)) + str.substring(1), (Type) Void.TYPE, Visibility.PUBLIC).withParameters(typeDefinition).intercept(FieldAccessor.ofField(str));
                        fieldManifestation = FieldManifestation.PLAIN;
                    } else {
                        fieldManifestation = FieldManifestation.FINAL;
                        builder = this;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(typeDefinition.represents(Boolean.TYPE) ? "is" : "get");
                    sb2.append(Character.toUpperCase(str.charAt(0)));
                    sb2.append(str.substring(1));
                    return builder.defineMethod(sb2.toString(), typeDefinition, Visibility.PUBLIC).intercept(FieldAccessor.ofField(str)).defineField(str, typeDefinition, Visibility.PRIVATE, fieldManifestation);
                } else {
                    throw new IllegalArgumentException("A bean property cannot have a void type");
                }
            }

            public TypeVariableDefinition<S> typeVariable(String str, TypeDefinition... typeDefinitionArr) {
                return typeVariable(str, (Collection<? extends TypeDefinition>) Arrays.asList(typeDefinitionArr));
            }

            public MethodDefinition.ImplementationDefinition<S> define(Constructor<?> constructor) {
                return define((MethodDescription) new MethodDescription.ForLoadedConstructor(constructor));
            }

            public FieldDefinition.Optional.Valuable<S> defineField(String str, TypeDefinition typeDefinition, Collection<? extends ModifierContributor.ForField> collection) {
                return defineField(str, typeDefinition, ModifierContributor.Resolver.of(collection).resolve());
            }

            public MethodDefinition.ParameterDefinition.Initial<S> defineMethod(String str, TypeDefinition typeDefinition, Collection<? extends ModifierContributor.ForMethod> collection) {
                return defineMethod(str, typeDefinition, ModifierContributor.Resolver.of(collection).resolve());
            }

            public MethodDefinition.ImplementationDefinition<S> define(MethodDescription methodDescription) {
                MethodDefinition.ParameterDefinition.Initial initial;
                MethodDefinition.ParameterDefinition parameterDefinition;
                if (methodDescription.isConstructor()) {
                    initial = defineConstructor(methodDescription.getModifiers());
                } else {
                    initial = defineMethod(methodDescription.getInternalName(), (TypeDefinition) methodDescription.getReturnType(), methodDescription.getModifiers());
                }
                ParameterList<?> parameters = methodDescription.getParameters();
                if (parameters.hasExplicitMetaData()) {
                    Iterator<E> it = parameters.iterator();
                    MethodDefinition.ParameterDefinition parameterDefinition2 = initial;
                    while (it.hasNext()) {
                        ParameterDescription parameterDescription = (ParameterDescription) it.next();
                        parameterDefinition2 = parameterDefinition2.withParameter((TypeDefinition) parameterDescription.getType(), parameterDescription.getName(), parameterDescription.getModifiers());
                    }
                    parameterDefinition = parameterDefinition2;
                } else {
                    parameterDefinition = initial.withParameters((Collection<? extends TypeDefinition>) parameters.asTypeList());
                }
                MethodDefinition.TypeVariableDefinition throwing = parameterDefinition.throwing((Collection<? extends TypeDefinition>) methodDescription.getExceptionTypes());
                for (TypeDescription.Generic generic : methodDescription.getTypeVariables()) {
                    throwing = throwing.typeVariable(generic.getSymbol(), (Collection<? extends TypeDefinition>) generic.getUpperBounds());
                }
                return throwing;
            }
        }

        public interface FieldDefinition<S> {

            public interface Optional<U> extends FieldDefinition<U>, Builder<U> {

                public static abstract class AbstractBase<U> extends AbstractBase.Delegator<U> implements Optional<U> {
                    public Optional<U> annotateField(Annotation... annotationArr) {
                        return annotateField((List<? extends Annotation>) Arrays.asList(annotationArr));
                    }

                    public Optional<U> annotateField(List<? extends Annotation> list) {
                        return annotateField((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
                    }

                    public Optional<U> annotateField(AnnotationDescription... annotationDescriptionArr) {
                        return annotateField((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
                    }
                }

                public interface Valuable<V> extends Valuable<V>, Optional<V> {

                    public static abstract class AbstractBase<U> extends AbstractBase<U> implements Valuable<U> {

                        @HashCodeAndEqualsPlugin.Enhance
                        private static abstract class Adapter<V> extends AbstractBase<V> {
                            @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                            @MaybeNull
                            protected final Object defaultValue;
                            protected final FieldAttributeAppender.Factory fieldAttributeAppenderFactory;
                            protected final Transformer<FieldDescription> transformer;

                            protected Adapter(FieldAttributeAppender.Factory factory, Transformer<FieldDescription> transformer2, @MaybeNull Object obj) {
                                this.fieldAttributeAppenderFactory = factory;
                                this.transformer = transformer2;
                                this.defaultValue = obj;
                            }

                            public Optional<V> attribute(FieldAttributeAppender.Factory factory) {
                                return materialize(new FieldAttributeAppender.Factory.Compound(this.fieldAttributeAppenderFactory, factory), this.transformer, this.defaultValue);
                            }

                            /* access modifiers changed from: protected */
                            public Optional<V> defaultValue(Object obj) {
                                return materialize(this.fieldAttributeAppenderFactory, this.transformer, obj);
                            }

                            /* JADX WARNING: Removed duplicated region for block: B:23:0x003d A[RETURN] */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public boolean equals(@net.bytebuddy.utility.nullability.MaybeNull java.lang.Object r5) {
                                /*
                                    r4 = this;
                                    r0 = 1
                                    if (r4 != r5) goto L_0x0004
                                    return r0
                                L_0x0004:
                                    r1 = 0
                                    if (r5 != 0) goto L_0x0008
                                    return r1
                                L_0x0008:
                                    java.lang.Class r2 = r4.getClass()
                                    java.lang.Class r3 = r5.getClass()
                                    if (r2 == r3) goto L_0x0013
                                    return r1
                                L_0x0013:
                                    net.bytebuddy.implementation.attribute.FieldAttributeAppender$Factory r2 = r4.fieldAttributeAppenderFactory
                                    net.bytebuddy.dynamic.DynamicType$Builder$FieldDefinition$Optional$Valuable$AbstractBase$Adapter r5 = (net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional.Valuable.AbstractBase.Adapter) r5
                                    net.bytebuddy.implementation.attribute.FieldAttributeAppender$Factory r3 = r5.fieldAttributeAppenderFactory
                                    boolean r2 = r2.equals(r3)
                                    if (r2 != 0) goto L_0x0020
                                    return r1
                                L_0x0020:
                                    net.bytebuddy.dynamic.Transformer<net.bytebuddy.description.field.FieldDescription> r2 = r4.transformer
                                    net.bytebuddy.dynamic.Transformer<net.bytebuddy.description.field.FieldDescription> r3 = r5.transformer
                                    boolean r2 = r2.equals(r3)
                                    if (r2 != 0) goto L_0x002b
                                    return r1
                                L_0x002b:
                                    java.lang.Object r2 = r4.defaultValue
                                    java.lang.Object r5 = r5.defaultValue
                                    if (r5 == 0) goto L_0x003a
                                    if (r2 == 0) goto L_0x003c
                                    boolean r5 = r2.equals(r5)
                                    if (r5 != 0) goto L_0x003d
                                    return r1
                                L_0x003a:
                                    if (r2 == 0) goto L_0x003d
                                L_0x003c:
                                    return r1
                                L_0x003d:
                                    return r0
                                */
                                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional.Valuable.AbstractBase.Adapter.equals(java.lang.Object):boolean");
                            }

                            public int hashCode() {
                                int hashCode = ((((getClass().hashCode() * 31) + this.fieldAttributeAppenderFactory.hashCode()) * 31) + this.transformer.hashCode()) * 31;
                                Object obj = this.defaultValue;
                                return obj != null ? hashCode + obj.hashCode() : hashCode;
                            }

                            /* access modifiers changed from: protected */
                            public abstract Optional<V> materialize(FieldAttributeAppender.Factory factory, Transformer<FieldDescription> transformer2, @MaybeNull Object obj);

                            public Optional<V> transform(Transformer<FieldDescription> transformer2) {
                                return materialize(this.fieldAttributeAppenderFactory, new Transformer.Compound((Transformer<S>[]) new Transformer[]{this.transformer, transformer2}), this.defaultValue);
                            }
                        }

                        /* access modifiers changed from: protected */
                        public abstract Optional<U> defaultValue(Object obj);

                        public Optional<U> value(boolean z10) {
                            return defaultValue(Integer.valueOf(z10 ? 1 : 0));
                        }

                        public Optional<U> value(int i10) {
                            return defaultValue(Integer.valueOf(i10));
                        }

                        public Optional<U> value(long j10) {
                            return defaultValue(Long.valueOf(j10));
                        }

                        public Optional<U> value(float f10) {
                            return defaultValue(Float.valueOf(f10));
                        }

                        public Optional<U> value(double d10) {
                            return defaultValue(Double.valueOf(d10));
                        }

                        public Optional<U> value(String str) {
                            if (str != null) {
                                return defaultValue(str);
                            }
                            throw new IllegalArgumentException("Cannot define 'null' as constant value");
                        }
                    }
                }
            }

            public interface Valuable<U> extends FieldDefinition<U> {
                Optional<U> value(double d10);

                Optional<U> value(float f10);

                Optional<U> value(int i10);

                Optional<U> value(long j10);

                Optional<U> value(String str);

                Optional<U> value(boolean z10);
            }

            Optional<S> annotateField(Collection<? extends AnnotationDescription> collection);

            Optional<S> annotateField(List<? extends Annotation> list);

            Optional<S> annotateField(Annotation... annotationArr);

            Optional<S> annotateField(AnnotationDescription... annotationDescriptionArr);

            Optional<S> attribute(FieldAttributeAppender.Factory factory);

            Optional<S> transform(Transformer<FieldDescription> transformer);
        }

        public interface InnerTypeDefinition<S> extends Builder<S> {

            public interface ForType<U> extends InnerTypeDefinition<U> {
                Builder<U> asMemberType();
            }

            Builder<S> asAnonymousType();
        }

        public interface MethodDefinition<S> extends Builder<S> {

            public static abstract class AbstractBase<U> extends AbstractBase.Delegator<U> implements MethodDefinition<U> {

                @HashCodeAndEqualsPlugin.Enhance
                protected static abstract class Adapter<V> extends ReceiverTypeDefinition.AbstractBase<V> {
                    protected final MethodRegistry.Handler handler;
                    protected final MethodAttributeAppender.Factory methodAttributeAppenderFactory;
                    protected final Transformer<MethodDescription> transformer;

                    protected Adapter(MethodRegistry.Handler handler2, MethodAttributeAppender.Factory factory, Transformer<MethodDescription> transformer2) {
                        this.handler = handler2;
                        this.methodAttributeAppenderFactory = factory;
                        this.transformer = transformer2;
                    }

                    public MethodDefinition<V> attribute(MethodAttributeAppender.Factory factory) {
                        return materialize(this.handler, new MethodAttributeAppender.Factory.Compound(this.methodAttributeAppenderFactory, factory), this.transformer);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Adapter adapter = (Adapter) obj;
                        return this.handler.equals(adapter.handler) && this.methodAttributeAppenderFactory.equals(adapter.methodAttributeAppenderFactory) && this.transformer.equals(adapter.transformer);
                    }

                    public int hashCode() {
                        return (((((getClass().hashCode() * 31) + this.handler.hashCode()) * 31) + this.methodAttributeAppenderFactory.hashCode()) * 31) + this.transformer.hashCode();
                    }

                    /* access modifiers changed from: protected */
                    public abstract MethodDefinition<V> materialize(MethodRegistry.Handler handler2, MethodAttributeAppender.Factory factory, Transformer<MethodDescription> transformer2);

                    public MethodDefinition<V> transform(Transformer<MethodDescription> transformer2) {
                        return materialize(this.handler, this.methodAttributeAppenderFactory, new Transformer.Compound((Transformer<S>[]) new Transformer[]{this.transformer, transformer2}));
                    }
                }

                public MethodDefinition<U> annotateMethod(Annotation... annotationArr) {
                    return annotateMethod((List<? extends Annotation>) Arrays.asList(annotationArr));
                }

                public MethodDefinition<U> annotateParameter(int i10, Annotation... annotationArr) {
                    return annotateParameter(i10, (List<? extends Annotation>) Arrays.asList(annotationArr));
                }

                public MethodDefinition<U> annotateMethod(List<? extends Annotation> list) {
                    return annotateMethod((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
                }

                public MethodDefinition<U> annotateParameter(int i10, List<? extends Annotation> list) {
                    return annotateParameter(i10, (Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
                }

                public MethodDefinition<U> annotateMethod(AnnotationDescription... annotationDescriptionArr) {
                    return annotateMethod((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
                }

                public MethodDefinition<U> annotateParameter(int i10, AnnotationDescription... annotationDescriptionArr) {
                    return annotateParameter(i10, (Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
                }
            }

            public interface ExceptionDefinition<U> extends TypeVariableDefinition<U> {

                public static abstract class AbstractBase<V> extends TypeVariableDefinition.AbstractBase<V> implements ExceptionDefinition<V> {
                    public ExceptionDefinition<V> throwing(Type... typeArr) {
                        return throwing((List<? extends Type>) Arrays.asList(typeArr));
                    }

                    public ExceptionDefinition<V> throwing(List<? extends Type> list) {
                        return throwing((Collection<? extends TypeDefinition>) new TypeList.Generic.ForLoadedTypes(list));
                    }

                    public ExceptionDefinition<V> throwing(TypeDefinition... typeDefinitionArr) {
                        return throwing((Collection<? extends TypeDefinition>) Arrays.asList(typeDefinitionArr));
                    }
                }

                ExceptionDefinition<U> throwing(Collection<? extends TypeDefinition> collection);

                ExceptionDefinition<U> throwing(List<? extends Type> list);

                ExceptionDefinition<U> throwing(Type... typeArr);

                ExceptionDefinition<U> throwing(TypeDefinition... typeDefinitionArr);
            }

            public interface ImplementationDefinition<U> {

                public static abstract class AbstractBase<V> implements ImplementationDefinition<V> {
                    public <W> ReceiverTypeDefinition<V> defaultValue(W w10, Class<? extends W> cls) {
                        return defaultValue(AnnotationDescription.ForLoadedAnnotation.asValue(w10, cls));
                    }
                }

                public interface Optional<V> extends ImplementationDefinition<V>, Builder<V> {
                }

                <W> ReceiverTypeDefinition<U> defaultValue(W w10, Class<? extends W> cls);

                ReceiverTypeDefinition<U> defaultValue(AnnotationValue<?, ?> annotationValue);

                ReceiverTypeDefinition<U> intercept(Implementation implementation);

                ReceiverTypeDefinition<U> withoutCode();
            }

            public interface ParameterDefinition<U> extends ExceptionDefinition<U> {

                public static abstract class AbstractBase<V> extends ExceptionDefinition.AbstractBase<V> implements ParameterDefinition<V> {
                    public Annotatable<V> withParameter(Type type, String str, ModifierContributor.ForParameter... forParameterArr) {
                        return withParameter(type, str, (Collection<? extends ModifierContributor.ForParameter>) Arrays.asList(forParameterArr));
                    }

                    public Annotatable<V> withParameter(Type type, String str, Collection<? extends ModifierContributor.ForParameter> collection) {
                        return withParameter(type, str, ModifierContributor.Resolver.of(collection).resolve());
                    }

                    public Annotatable<V> withParameter(Type type, String str, int i10) {
                        return withParameter((TypeDefinition) TypeDefinition.Sort.describe(type), str, i10);
                    }

                    public Annotatable<V> withParameter(TypeDefinition typeDefinition, String str, ModifierContributor.ForParameter... forParameterArr) {
                        return withParameter(typeDefinition, str, (Collection<? extends ModifierContributor.ForParameter>) Arrays.asList(forParameterArr));
                    }

                    public Annotatable<V> withParameter(TypeDefinition typeDefinition, String str, Collection<? extends ModifierContributor.ForParameter> collection) {
                        return withParameter(typeDefinition, str, ModifierContributor.Resolver.of(collection).resolve());
                    }
                }

                public interface Annotatable<V> extends ParameterDefinition<V> {

                    public static abstract class AbstractBase<W> extends AbstractBase<W> implements Annotatable<W> {

                        protected static abstract class Adapter<X> extends AbstractBase<X> {
                            protected Adapter() {
                            }

                            public ReceiverTypeDefinition<X> defaultValue(AnnotationValue<?, ?> annotationValue) {
                                return materialize().defaultValue(annotationValue);
                            }

                            public ReceiverTypeDefinition<X> intercept(Implementation implementation) {
                                return materialize().intercept(implementation);
                            }

                            /* access modifiers changed from: protected */
                            public abstract ParameterDefinition<X> materialize();

                            public ExceptionDefinition<X> throwing(Collection<? extends TypeDefinition> collection) {
                                return materialize().throwing(collection);
                            }

                            public TypeVariableDefinition.Annotatable<X> typeVariable(String str, Collection<? extends TypeDefinition> collection) {
                                return materialize().typeVariable(str, collection);
                            }

                            public Annotatable<X> withParameter(TypeDefinition typeDefinition, String str, int i10) {
                                return materialize().withParameter(typeDefinition, str, i10);
                            }

                            public ReceiverTypeDefinition<X> withoutCode() {
                                return materialize().withoutCode();
                            }

                            public <V> ReceiverTypeDefinition<X> defaultValue(V v10, Class<? extends V> cls) {
                                return materialize().defaultValue(v10, cls);
                            }
                        }

                        public Annotatable<W> annotateParameter(Annotation... annotationArr) {
                            return annotateParameter((List<? extends Annotation>) Arrays.asList(annotationArr));
                        }

                        public Annotatable<W> annotateParameter(List<? extends Annotation> list) {
                            return annotateParameter((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
                        }

                        public Annotatable<W> annotateParameter(AnnotationDescription... annotationDescriptionArr) {
                            return annotateParameter((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
                        }
                    }

                    Annotatable<V> annotateParameter(Collection<? extends AnnotationDescription> collection);

                    Annotatable<V> annotateParameter(List<? extends Annotation> list);

                    Annotatable<V> annotateParameter(Annotation... annotationArr);

                    Annotatable<V> annotateParameter(AnnotationDescription... annotationDescriptionArr);
                }

                public interface Initial<V> extends ParameterDefinition<V>, Simple<V> {

                    public static abstract class AbstractBase<W> extends AbstractBase<W> implements Initial<W> {
                        public Simple.Annotatable<W> withParameter(Type type) {
                            return withParameter((TypeDefinition) TypeDefinition.Sort.describe(type));
                        }

                        public ExceptionDefinition<W> withParameters(Type... typeArr) {
                            return withParameters((List<? extends Type>) Arrays.asList(typeArr));
                        }

                        public ExceptionDefinition<W> withParameters(List<? extends Type> list) {
                            return withParameters((Collection<? extends TypeDefinition>) new TypeList.Generic.ForLoadedTypes(list));
                        }

                        public ExceptionDefinition<W> withParameters(TypeDefinition... typeDefinitionArr) {
                            return withParameters((Collection<? extends TypeDefinition>) Arrays.asList(typeDefinitionArr));
                        }

                        public ExceptionDefinition<W> withParameters(Collection<? extends TypeDefinition> collection) {
                            Simple simple = this;
                            for (TypeDefinition withParameter : collection) {
                                simple = simple.withParameter(withParameter);
                            }
                            return simple;
                        }
                    }

                    ExceptionDefinition<V> withParameters(Collection<? extends TypeDefinition> collection);

                    ExceptionDefinition<V> withParameters(List<? extends Type> list);

                    ExceptionDefinition<V> withParameters(Type... typeArr);

                    ExceptionDefinition<V> withParameters(TypeDefinition... typeDefinitionArr);
                }

                public interface Simple<V> extends ExceptionDefinition<V> {

                    public static abstract class AbstractBase<W> extends ExceptionDefinition.AbstractBase<W> implements Simple<W> {
                        public Annotatable<W> withParameter(Type type) {
                            return withParameter((TypeDefinition) TypeDefinition.Sort.describe(type));
                        }
                    }

                    public interface Annotatable<V> extends Simple<V> {

                        public static abstract class AbstractBase<W> extends AbstractBase<W> implements Annotatable<W> {

                            protected static abstract class Adapter<X> extends AbstractBase<X> {
                                protected Adapter() {
                                }

                                public ReceiverTypeDefinition<X> defaultValue(AnnotationValue<?, ?> annotationValue) {
                                    return materialize().defaultValue(annotationValue);
                                }

                                public ReceiverTypeDefinition<X> intercept(Implementation implementation) {
                                    return materialize().intercept(implementation);
                                }

                                /* access modifiers changed from: protected */
                                public abstract Simple<X> materialize();

                                public ExceptionDefinition<X> throwing(Collection<? extends TypeDefinition> collection) {
                                    return materialize().throwing(collection);
                                }

                                public TypeVariableDefinition.Annotatable<X> typeVariable(String str, Collection<? extends TypeDefinition> collection) {
                                    return materialize().typeVariable(str, collection);
                                }

                                public Annotatable<X> withParameter(TypeDefinition typeDefinition) {
                                    return materialize().withParameter(typeDefinition);
                                }

                                public ReceiverTypeDefinition<X> withoutCode() {
                                    return materialize().withoutCode();
                                }

                                public <V> ReceiverTypeDefinition<X> defaultValue(V v10, Class<? extends V> cls) {
                                    return materialize().defaultValue(v10, cls);
                                }
                            }

                            public Annotatable<W> annotateParameter(Annotation... annotationArr) {
                                return annotateParameter((List<? extends Annotation>) Arrays.asList(annotationArr));
                            }

                            public Annotatable<W> annotateParameter(List<? extends Annotation> list) {
                                return annotateParameter((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
                            }

                            public Annotatable<W> annotateParameter(AnnotationDescription... annotationDescriptionArr) {
                                return annotateParameter((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
                            }
                        }

                        Annotatable<V> annotateParameter(Collection<? extends AnnotationDescription> collection);

                        Annotatable<V> annotateParameter(List<? extends Annotation> list);

                        Annotatable<V> annotateParameter(Annotation... annotationArr);

                        Annotatable<V> annotateParameter(AnnotationDescription... annotationDescriptionArr);
                    }

                    Annotatable<V> withParameter(Type type);

                    Annotatable<V> withParameter(TypeDefinition typeDefinition);
                }

                Annotatable<U> withParameter(Type type, String str, int i10);

                Annotatable<U> withParameter(Type type, String str, Collection<? extends ModifierContributor.ForParameter> collection);

                Annotatable<U> withParameter(Type type, String str, ModifierContributor.ForParameter... forParameterArr);

                Annotatable<U> withParameter(TypeDefinition typeDefinition, String str, int i10);

                Annotatable<U> withParameter(TypeDefinition typeDefinition, String str, Collection<? extends ModifierContributor.ForParameter> collection);

                Annotatable<U> withParameter(TypeDefinition typeDefinition, String str, ModifierContributor.ForParameter... forParameterArr);
            }

            public interface ReceiverTypeDefinition<U> extends MethodDefinition<U> {

                public static abstract class AbstractBase<V> extends AbstractBase<V> implements ReceiverTypeDefinition<V> {
                    public MethodDefinition<V> receiverType(AnnotatedElement annotatedElement) {
                        return receiverType(TypeDefinition.Sort.describeAnnotated(annotatedElement));
                    }
                }

                MethodDefinition<U> receiverType(AnnotatedElement annotatedElement);

                MethodDefinition<U> receiverType(TypeDescription.Generic generic);
            }

            public interface TypeVariableDefinition<U> extends ImplementationDefinition<U> {

                public static abstract class AbstractBase<V> extends ImplementationDefinition.AbstractBase<V> implements TypeVariableDefinition<V> {
                    public Annotatable<V> typeVariable(String str) {
                        return typeVariable(str, (List<? extends Type>) Collections.singletonList(Object.class));
                    }

                    public Annotatable<V> typeVariable(String str, Type... typeArr) {
                        return typeVariable(str, (List<? extends Type>) Arrays.asList(typeArr));
                    }

                    public Annotatable<V> typeVariable(String str, List<? extends Type> list) {
                        return typeVariable(str, (Collection<? extends TypeDefinition>) new TypeList.Generic.ForLoadedTypes(list));
                    }

                    public Annotatable<V> typeVariable(String str, TypeDefinition... typeDefinitionArr) {
                        return typeVariable(str, (Collection<? extends TypeDefinition>) Arrays.asList(typeDefinitionArr));
                    }
                }

                public interface Annotatable<V> extends TypeVariableDefinition<V> {

                    public static abstract class AbstractBase<W> extends AbstractBase<W> implements Annotatable<W> {

                        protected static abstract class Adapter<X> extends AbstractBase<X> {
                            protected Adapter() {
                            }

                            public ReceiverTypeDefinition<X> defaultValue(AnnotationValue<?, ?> annotationValue) {
                                return materialize().defaultValue(annotationValue);
                            }

                            public ReceiverTypeDefinition<X> intercept(Implementation implementation) {
                                return materialize().intercept(implementation);
                            }

                            /* access modifiers changed from: protected */
                            public abstract ParameterDefinition<X> materialize();

                            public Annotatable<X> typeVariable(String str, Collection<? extends TypeDefinition> collection) {
                                return materialize().typeVariable(str, collection);
                            }

                            public ReceiverTypeDefinition<X> withoutCode() {
                                return materialize().withoutCode();
                            }

                            public <V> ReceiverTypeDefinition<X> defaultValue(V v10, Class<? extends V> cls) {
                                return materialize().defaultValue(v10, cls);
                            }
                        }

                        public Annotatable<W> annotateTypeVariable(Annotation... annotationArr) {
                            return annotateTypeVariable((List<? extends Annotation>) Arrays.asList(annotationArr));
                        }

                        public Annotatable<W> annotateTypeVariable(List<? extends Annotation> list) {
                            return annotateTypeVariable((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
                        }

                        public Annotatable<W> annotateTypeVariable(AnnotationDescription... annotationDescriptionArr) {
                            return annotateTypeVariable((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
                        }
                    }

                    Annotatable<V> annotateTypeVariable(Collection<? extends AnnotationDescription> collection);

                    Annotatable<V> annotateTypeVariable(List<? extends Annotation> list);

                    Annotatable<V> annotateTypeVariable(Annotation... annotationArr);

                    Annotatable<V> annotateTypeVariable(AnnotationDescription... annotationDescriptionArr);
                }

                Annotatable<U> typeVariable(String str);

                Annotatable<U> typeVariable(String str, Collection<? extends TypeDefinition> collection);

                Annotatable<U> typeVariable(String str, List<? extends Type> list);

                Annotatable<U> typeVariable(String str, Type... typeArr);

                Annotatable<U> typeVariable(String str, TypeDefinition... typeDefinitionArr);
            }

            MethodDefinition<S> annotateMethod(Collection<? extends AnnotationDescription> collection);

            MethodDefinition<S> annotateMethod(List<? extends Annotation> list);

            MethodDefinition<S> annotateMethod(Annotation... annotationArr);

            MethodDefinition<S> annotateMethod(AnnotationDescription... annotationDescriptionArr);

            MethodDefinition<S> annotateParameter(int i10, Collection<? extends AnnotationDescription> collection);

            MethodDefinition<S> annotateParameter(int i10, List<? extends Annotation> list);

            MethodDefinition<S> annotateParameter(int i10, Annotation... annotationArr);

            MethodDefinition<S> annotateParameter(int i10, AnnotationDescription... annotationDescriptionArr);

            MethodDefinition<S> attribute(MethodAttributeAppender.Factory factory);

            MethodDefinition<S> transform(Transformer<MethodDescription> transformer);
        }

        public interface RecordComponentDefinition<S> {

            public interface Optional<U> extends RecordComponentDefinition<U>, Builder<U> {

                public static abstract class AbstractBase<U> extends AbstractBase.Delegator<U> implements Optional<U> {
                    public Optional<U> annotateRecordComponent(Annotation... annotationArr) {
                        return annotateRecordComponent((List<? extends Annotation>) Arrays.asList(annotationArr));
                    }

                    public Optional<U> annotateRecordComponent(List<? extends Annotation> list) {
                        return annotateRecordComponent((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
                    }

                    public Optional<U> annotateRecordComponent(AnnotationDescription... annotationDescriptionArr) {
                        return annotateRecordComponent((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
                    }
                }
            }

            Optional<S> annotateRecordComponent(Collection<? extends AnnotationDescription> collection);

            Optional<S> annotateRecordComponent(List<? extends Annotation> list);

            Optional<S> annotateRecordComponent(Annotation... annotationArr);

            Optional<S> annotateRecordComponent(AnnotationDescription... annotationDescriptionArr);

            Optional<S> attribute(RecordComponentAttributeAppender.Factory factory);

            Optional<S> transform(Transformer<RecordComponentDescription> transformer);
        }

        public interface TypeVariableDefinition<S> extends Builder<S> {

            public static abstract class AbstractBase<U> extends AbstractBase.Delegator<U> implements TypeVariableDefinition<U> {
                public TypeVariableDefinition<U> annotateTypeVariable(Annotation... annotationArr) {
                    return annotateTypeVariable((List<? extends Annotation>) Arrays.asList(annotationArr));
                }

                public TypeVariableDefinition<U> annotateTypeVariable(List<? extends Annotation> list) {
                    return annotateTypeVariable((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
                }

                public TypeVariableDefinition<U> annotateTypeVariable(AnnotationDescription... annotationDescriptionArr) {
                    return annotateTypeVariable((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
                }
            }

            TypeVariableDefinition<S> annotateTypeVariable(Collection<? extends AnnotationDescription> collection);

            TypeVariableDefinition<S> annotateTypeVariable(List<? extends Annotation> list);

            TypeVariableDefinition<S> annotateTypeVariable(Annotation... annotationArr);

            TypeVariableDefinition<S> annotateTypeVariable(AnnotationDescription... annotationDescriptionArr);
        }

        Builder<T> annotateType(Collection<? extends AnnotationDescription> collection);

        Builder<T> annotateType(List<? extends Annotation> list);

        Builder<T> annotateType(Annotation... annotationArr);

        Builder<T> annotateType(AnnotationDescription... annotationDescriptionArr);

        Builder<T> attribute(TypeAttributeAppender typeAttributeAppender);

        MethodDefinition.ImplementationDefinition<T> constructor(ElementMatcher<? super MethodDescription> elementMatcher);

        Builder<T> declaredTypes(Collection<? extends TypeDescription> collection);

        Builder<T> declaredTypes(List<? extends Class<?>> list);

        Builder<T> declaredTypes(Class<?>... clsArr);

        Builder<T> declaredTypes(TypeDescription... typeDescriptionArr);

        FieldDefinition.Optional.Valuable<T> define(Field field);

        FieldDefinition.Optional.Valuable<T> define(FieldDescription fieldDescription);

        MethodDefinition.ImplementationDefinition<T> define(Constructor<?> constructor);

        MethodDefinition.ImplementationDefinition<T> define(Method method);

        MethodDefinition.ImplementationDefinition<T> define(MethodDescription methodDescription);

        RecordComponentDefinition.Optional<T> define(RecordComponentDescription recordComponentDescription);

        MethodDefinition.ParameterDefinition.Initial<T> defineConstructor(int i10);

        MethodDefinition.ParameterDefinition.Initial<T> defineConstructor(Collection<? extends ModifierContributor.ForMethod> collection);

        MethodDefinition.ParameterDefinition.Initial<T> defineConstructor(ModifierContributor.ForMethod... forMethodArr);

        FieldDefinition.Optional.Valuable<T> defineField(String str, Type type, int i10);

        FieldDefinition.Optional.Valuable<T> defineField(String str, Type type, Collection<? extends ModifierContributor.ForField> collection);

        FieldDefinition.Optional.Valuable<T> defineField(String str, Type type, ModifierContributor.ForField... forFieldArr);

        FieldDefinition.Optional.Valuable<T> defineField(String str, TypeDefinition typeDefinition, int i10);

        FieldDefinition.Optional.Valuable<T> defineField(String str, TypeDefinition typeDefinition, Collection<? extends ModifierContributor.ForField> collection);

        FieldDefinition.Optional.Valuable<T> defineField(String str, TypeDefinition typeDefinition, ModifierContributor.ForField... forFieldArr);

        MethodDefinition.ParameterDefinition.Initial<T> defineMethod(String str, Type type, int i10);

        MethodDefinition.ParameterDefinition.Initial<T> defineMethod(String str, Type type, Collection<? extends ModifierContributor.ForMethod> collection);

        MethodDefinition.ParameterDefinition.Initial<T> defineMethod(String str, Type type, ModifierContributor.ForMethod... forMethodArr);

        MethodDefinition.ParameterDefinition.Initial<T> defineMethod(String str, TypeDefinition typeDefinition, int i10);

        MethodDefinition.ParameterDefinition.Initial<T> defineMethod(String str, TypeDefinition typeDefinition, Collection<? extends ModifierContributor.ForMethod> collection);

        MethodDefinition.ParameterDefinition.Initial<T> defineMethod(String str, TypeDefinition typeDefinition, ModifierContributor.ForMethod... forMethodArr);

        FieldDefinition.Optional<T> defineProperty(String str, Type type);

        FieldDefinition.Optional<T> defineProperty(String str, Type type, boolean z10);

        FieldDefinition.Optional<T> defineProperty(String str, TypeDefinition typeDefinition);

        FieldDefinition.Optional<T> defineProperty(String str, TypeDefinition typeDefinition, boolean z10);

        RecordComponentDefinition.Optional<T> defineRecordComponent(String str, Type type);

        RecordComponentDefinition.Optional<T> defineRecordComponent(String str, TypeDefinition typeDefinition);

        FieldDefinition.Valuable<T> field(ElementMatcher<? super FieldDescription> elementMatcher);

        FieldDefinition.Valuable<T> field(LatentMatcher<? super FieldDescription> latentMatcher);

        Builder<T> ignoreAlso(ElementMatcher<? super MethodDescription> elementMatcher);

        Builder<T> ignoreAlso(LatentMatcher<? super MethodDescription> latentMatcher);

        MethodDefinition.ImplementationDefinition.Optional<T> implement(Collection<? extends TypeDefinition> collection);

        MethodDefinition.ImplementationDefinition.Optional<T> implement(List<? extends Type> list);

        MethodDefinition.ImplementationDefinition.Optional<T> implement(Type... typeArr);

        MethodDefinition.ImplementationDefinition.Optional<T> implement(TypeDefinition... typeDefinitionArr);

        Builder<T> initializer(LoadedTypeInitializer loadedTypeInitializer);

        Builder<T> initializer(ByteCodeAppender byteCodeAppender);

        InnerTypeDefinition.ForType<T> innerTypeOf(Class<?> cls);

        InnerTypeDefinition.ForType<T> innerTypeOf(TypeDescription typeDescription);

        InnerTypeDefinition<T> innerTypeOf(Constructor<?> constructor);

        InnerTypeDefinition<T> innerTypeOf(Method method);

        InnerTypeDefinition<T> innerTypeOf(MethodDescription.InDefinedShape inDefinedShape);

        MethodDefinition.ImplementationDefinition<T> invokable(ElementMatcher<? super MethodDescription> elementMatcher);

        MethodDefinition.ImplementationDefinition<T> invokable(LatentMatcher<? super MethodDescription> latentMatcher);

        Unloaded<T> make();

        Unloaded<T> make(TypeResolutionStrategy typeResolutionStrategy);

        Unloaded<T> make(TypeResolutionStrategy typeResolutionStrategy, TypePool typePool);

        Unloaded<T> make(TypePool typePool);

        Builder<T> merge(Collection<? extends ModifierContributor.ForType> collection);

        Builder<T> merge(ModifierContributor.ForType... forTypeArr);

        MethodDefinition.ImplementationDefinition<T> method(ElementMatcher<? super MethodDescription> elementMatcher);

        Builder<T> modifiers(int i10);

        Builder<T> modifiers(Collection<? extends ModifierContributor.ForType> collection);

        Builder<T> modifiers(ModifierContributor.ForType... forTypeArr);

        Builder<T> name(String str);

        Builder<T> nestHost(Class<?> cls);

        Builder<T> nestHost(TypeDescription typeDescription);

        Builder<T> nestMembers(Collection<? extends TypeDescription> collection);

        Builder<T> nestMembers(List<? extends Class<?>> list);

        Builder<T> nestMembers(Class<?>... clsArr);

        Builder<T> nestMembers(TypeDescription... typeDescriptionArr);

        Builder<T> noNestMate();

        Builder<T> permittedSubclass(Collection<? extends TypeDescription> collection);

        Builder<T> permittedSubclass(List<? extends Class<?>> list);

        Builder<T> permittedSubclass(Class<?>... clsArr);

        Builder<T> permittedSubclass(TypeDescription... typeDescriptionArr);

        RecordComponentDefinition<T> recordComponent(ElementMatcher<? super RecordComponentDescription> elementMatcher);

        RecordComponentDefinition<T> recordComponent(LatentMatcher<? super RecordComponentDescription> latentMatcher);

        Builder<T> require(Collection<DynamicType> collection);

        Builder<T> require(TypeDescription typeDescription, byte[] bArr);

        Builder<T> require(TypeDescription typeDescription, byte[] bArr, LoadedTypeInitializer loadedTypeInitializer);

        Builder<T> require(DynamicType... dynamicTypeArr);

        FieldDefinition.Optional<T> serialVersionUid(long j10);

        Builder<T> suffix(String str);

        TypeDescription toTypeDescription();

        Builder<T> topLevelType();

        Builder<T> transform(ElementMatcher<? super TypeDescription.Generic> elementMatcher, Transformer<TypeVariableToken> transformer);

        TypeVariableDefinition<T> typeVariable(String str);

        TypeVariableDefinition<T> typeVariable(String str, Collection<? extends TypeDefinition> collection);

        TypeVariableDefinition<T> typeVariable(String str, List<? extends Type> list);

        TypeVariableDefinition<T> typeVariable(String str, Type... typeArr);

        TypeVariableDefinition<T> typeVariable(String str, TypeDefinition... typeDefinitionArr);

        Builder<T> unsealed();

        Builder<T> visit(AsmVisitorWrapper asmVisitorWrapper);

        Builder<T> withHashCodeEquals();

        Builder<T> withToString();

        ContextClassVisitor wrap(ClassVisitor classVisitor);

        ContextClassVisitor wrap(ClassVisitor classVisitor, int i10, int i11);

        ContextClassVisitor wrap(ClassVisitor classVisitor, TypePool typePool);

        ContextClassVisitor wrap(ClassVisitor classVisitor, TypePool typePool, int i10, int i11);
    }

    public interface Loaded<T> extends DynamicType {
        Map<TypeDescription, Class<?>> getAllLoaded();

        Class<? extends T> getLoaded();

        Map<TypeDescription, Class<?>> getLoadedAuxiliaryTypes();
    }

    public interface Unloaded<T> extends DynamicType {
        Unloaded<T> include(List<? extends DynamicType> list);

        Unloaded<T> include(DynamicType... dynamicTypeArr);

        Loaded<T> load(@MaybeNull ClassLoader classLoader);

        <S extends ClassLoader> Loaded<T> load(@MaybeNull S s10, ClassLoadingStrategy<? super S> classLoadingStrategy);
    }

    Map<TypeDescription, byte[]> getAllTypes();

    Map<TypeDescription, byte[]> getAuxiliaryTypes();

    byte[] getBytes();

    Map<TypeDescription, LoadedTypeInitializer> getLoadedTypeInitializers();

    TypeDescription getTypeDescription();

    boolean hasAliveLoadedTypeInitializers();

    File inject(File file) throws IOException;

    File inject(File file, File file2) throws IOException;

    Map<TypeDescription, File> saveIn(File file) throws IOException;

    File toJar(File file) throws IOException;

    File toJar(File file, Manifest manifest) throws IOException;

    @HashCodeAndEqualsPlugin.Enhance
    public static class Default implements DynamicType {
        private static final int BUFFER_SIZE = 1024;
        private static final String CLASS_FILE_EXTENSION = ".class";
        private static final int END_OF_FILE = -1;
        private static final int FROM_BEGINNING = 0;
        private static final String MANIFEST_VERSION = "1.0";
        private static final String TEMP_SUFFIX = "tmp";
        protected final List<? extends DynamicType> auxiliaryTypes;
        protected final byte[] binaryRepresentation;
        protected final LoadedTypeInitializer loadedTypeInitializer;
        protected final TypeDescription typeDescription;

        @HashCodeAndEqualsPlugin.Enhance
        protected static class Loaded<T> extends Default implements Loaded<T> {
            private final Map<TypeDescription, Class<?>> loadedTypes;

            protected Loaded(TypeDescription typeDescription, byte[] bArr, LoadedTypeInitializer loadedTypeInitializer, List<? extends DynamicType> list, Map<TypeDescription, Class<?>> map) {
                super(typeDescription, bArr, loadedTypeInitializer, list);
                this.loadedTypes = map;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.loadedTypes.equals(((Loaded) obj).loadedTypes);
            }

            public Map<TypeDescription, Class<?>> getAllLoaded() {
                return new HashMap(this.loadedTypes);
            }

            public Class<? extends T> getLoaded() {
                return this.loadedTypes.get(this.typeDescription);
            }

            public Map<TypeDescription, Class<?>> getLoadedAuxiliaryTypes() {
                HashMap hashMap = new HashMap(this.loadedTypes);
                hashMap.remove(this.typeDescription);
                return hashMap;
            }

            public int hashCode() {
                return (super.hashCode() * 31) + this.loadedTypes.hashCode();
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Unloaded<T> extends Default implements Unloaded<T> {
            private final TypeResolutionStrategy.Resolved typeResolutionStrategy;

            public Unloaded(TypeDescription typeDescription, byte[] bArr, LoadedTypeInitializer loadedTypeInitializer, List<? extends DynamicType> list, TypeResolutionStrategy.Resolved resolved) {
                super(typeDescription, bArr, loadedTypeInitializer, list);
                this.typeResolutionStrategy = resolved;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.typeResolutionStrategy.equals(((Unloaded) obj).typeResolutionStrategy);
            }

            public int hashCode() {
                return (super.hashCode() * 31) + this.typeResolutionStrategy.hashCode();
            }

            public Unloaded<T> include(DynamicType... dynamicTypeArr) {
                return include((List<? extends DynamicType>) Arrays.asList(dynamicTypeArr));
            }

            public Loaded<T> load(@MaybeNull ClassLoader classLoader) {
                if (classLoader instanceof InjectionClassLoader) {
                    InjectionClassLoader injectionClassLoader = (InjectionClassLoader) classLoader;
                    if (!injectionClassLoader.isSealed()) {
                        return load(injectionClassLoader, InjectionClassLoader.Strategy.INSTANCE);
                    }
                }
                return load(classLoader, ClassLoadingStrategy.Default.WRAPPER);
            }

            public Unloaded<T> include(List<? extends DynamicType> list) {
                return new Unloaded(this.typeDescription, this.binaryRepresentation, this.loadedTypeInitializer, CompoundList.of(this.auxiliaryTypes, list), this.typeResolutionStrategy);
            }

            public <S extends ClassLoader> Loaded<T> load(@MaybeNull S s10, ClassLoadingStrategy<? super S> classLoadingStrategy) {
                return new Loaded(this.typeDescription, this.binaryRepresentation, this.loadedTypeInitializer, this.auxiliaryTypes, this.typeResolutionStrategy.initialize(this, s10, classLoadingStrategy));
            }
        }

        @SuppressFBWarnings(justification = "The array is not modified by class contract.", value = {"EI_EXPOSE_REP2"})
        public Default(TypeDescription typeDescription2, byte[] bArr, LoadedTypeInitializer loadedTypeInitializer2, List<? extends DynamicType> list) {
            this.typeDescription = typeDescription2;
            this.binaryRepresentation = bArr;
            this.loadedTypeInitializer = loadedTypeInitializer2;
            this.auxiliaryTypes = list;
        }

        private File doInject(File file, File file2) throws IOException {
            JarOutputStream jarOutputStream;
            JarInputStream jarInputStream = new JarInputStream(new FileInputStream(file));
            try {
                if (!file2.isFile()) {
                    if (!file2.createNewFile()) {
                        throw new IllegalArgumentException("Could not create file: " + file2);
                    }
                }
                Manifest manifest = jarInputStream.getManifest();
                if (manifest == null) {
                    jarOutputStream = new JarOutputStream(new FileOutputStream(file2));
                } else {
                    jarOutputStream = new JarOutputStream(new FileOutputStream(file2), manifest);
                }
                Map<TypeDescription, byte[]> auxiliaryTypes2 = getAuxiliaryTypes();
                HashMap hashMap = new HashMap();
                for (Map.Entry next : auxiliaryTypes2.entrySet()) {
                    hashMap.put(((TypeDescription) next.getKey()).getInternalName() + ".class", next.getValue());
                }
                hashMap.put(this.typeDescription.getInternalName() + ".class", this.binaryRepresentation);
                while (true) {
                    JarEntry nextJarEntry = jarInputStream.getNextJarEntry();
                    if (nextJarEntry == null) {
                        break;
                    }
                    byte[] bArr = (byte[]) hashMap.remove(nextJarEntry.getName());
                    if (bArr == null) {
                        jarOutputStream.putNextEntry(nextJarEntry);
                        byte[] bArr2 = new byte[1024];
                        while (true) {
                            int read = jarInputStream.read(bArr2);
                            if (read == -1) {
                                break;
                            }
                            jarOutputStream.write(bArr2, 0, read);
                        }
                    } else {
                        jarOutputStream.putNextEntry(new JarEntry(nextJarEntry.getName()));
                        jarOutputStream.write(bArr);
                    }
                    jarInputStream.closeEntry();
                    jarOutputStream.closeEntry();
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    jarOutputStream.putNextEntry(new JarEntry((String) entry.getKey()));
                    jarOutputStream.write((byte[]) entry.getValue());
                    jarOutputStream.closeEntry();
                }
                jarOutputStream.close();
                jarInputStream.close();
                return file2;
            } catch (Throwable th2) {
                jarInputStream.close();
                throw th2;
            }
        }

        public void close() {
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Default defaultR = (Default) obj;
            return this.typeDescription.equals(defaultR.typeDescription) && Arrays.equals(this.binaryRepresentation, defaultR.binaryRepresentation) && this.loadedTypeInitializer.equals(defaultR.loadedTypeInitializer) && this.auxiliaryTypes.equals(defaultR.auxiliaryTypes);
        }

        public Map<TypeDescription, byte[]> getAllTypes() {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(this.typeDescription, this.binaryRepresentation);
            for (DynamicType allTypes : this.auxiliaryTypes) {
                linkedHashMap.putAll(allTypes.getAllTypes());
            }
            return linkedHashMap;
        }

        public Map<TypeDescription, byte[]> getAuxiliaryTypes() {
            HashMap hashMap = new HashMap();
            for (DynamicType dynamicType : this.auxiliaryTypes) {
                hashMap.put(dynamicType.getTypeDescription(), dynamicType.getBytes());
                hashMap.putAll(dynamicType.getAuxiliaryTypes());
            }
            return hashMap;
        }

        @SuppressFBWarnings(justification = "The array is not modified by class contract.", value = {"EI_EXPOSE_REP"})
        public byte[] getBytes() {
            return this.binaryRepresentation;
        }

        public Map<TypeDescription, LoadedTypeInitializer> getLoadedTypeInitializers() {
            HashMap hashMap = new HashMap();
            for (DynamicType loadedTypeInitializers : this.auxiliaryTypes) {
                hashMap.putAll(loadedTypeInitializers.getLoadedTypeInitializers());
            }
            hashMap.put(this.typeDescription, this.loadedTypeInitializer);
            return hashMap;
        }

        public TypeDescription getTypeDescription() {
            return this.typeDescription;
        }

        public boolean hasAliveLoadedTypeInitializers() {
            for (LoadedTypeInitializer isAlive : getLoadedTypeInitializers().values()) {
                if (isAlive.isAlive()) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (((((((getClass().hashCode() * 31) + this.typeDescription.hashCode()) * 31) + Arrays.hashCode(this.binaryRepresentation)) * 31) + this.loadedTypeInitializer.hashCode()) * 31) + this.auxiliaryTypes.hashCode();
        }

        public File inject(File file, File file2) throws IOException {
            if (file.equals(file2)) {
                return inject(file);
            }
            return doInject(file, file2);
        }

        public ClassFileLocator.Resolution locate(String str) throws IOException {
            if (this.typeDescription.getName().equals(str)) {
                return new ClassFileLocator.Resolution.Explicit(this.binaryRepresentation);
            }
            for (DynamicType locate : this.auxiliaryTypes) {
                ClassFileLocator.Resolution locate2 = locate.locate(str);
                if (locate2.isResolved()) {
                    return locate2;
                }
            }
            return new ClassFileLocator.Resolution.Illegal(str);
        }

        /* JADX INFO: finally extract failed */
        public Map<TypeDescription, File> saveIn(File file) throws IOException {
            HashMap hashMap = new HashMap();
            File file2 = new File(file, this.typeDescription.getName().replace('.', File.separatorChar) + ".class");
            if (file2.getParentFile() == null || file2.getParentFile().isDirectory() || file2.getParentFile().mkdirs()) {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    fileOutputStream.write(this.binaryRepresentation);
                    fileOutputStream.close();
                    hashMap.put(this.typeDescription, file2);
                    for (DynamicType saveIn : this.auxiliaryTypes) {
                        hashMap.putAll(saveIn.saveIn(file));
                    }
                    return hashMap;
                } catch (Throwable th2) {
                    fileOutputStream.close();
                    throw th2;
                }
            } else {
                throw new IllegalArgumentException("Could not create directory: " + file2.getParentFile());
            }
        }

        public File toJar(File file) throws IOException {
            Manifest manifest = new Manifest();
            manifest.getMainAttributes().put(Attributes.Name.MANIFEST_VERSION, "1.0");
            return toJar(file, manifest);
        }

        public File inject(File file) throws IOException {
            FileSystem.getInstance().move(doInject(file, File.createTempFile(file.getName(), TEMP_SUFFIX)), file);
            return file;
        }

        public File toJar(File file, Manifest manifest) throws IOException {
            if (file.isFile() || file.createNewFile()) {
                JarOutputStream jarOutputStream = new JarOutputStream(new FileOutputStream(file), manifest);
                try {
                    for (Map.Entry next : getAuxiliaryTypes().entrySet()) {
                        jarOutputStream.putNextEntry(new JarEntry(((TypeDescription) next.getKey()).getInternalName() + ".class"));
                        jarOutputStream.write((byte[]) next.getValue());
                        jarOutputStream.closeEntry();
                    }
                    jarOutputStream.putNextEntry(new JarEntry(this.typeDescription.getInternalName() + ".class"));
                    jarOutputStream.write(this.binaryRepresentation);
                    jarOutputStream.closeEntry();
                    return file;
                } finally {
                    jarOutputStream.close();
                }
            } else {
                throw new IllegalArgumentException("Could not create file: " + file);
            }
        }
    }
}
