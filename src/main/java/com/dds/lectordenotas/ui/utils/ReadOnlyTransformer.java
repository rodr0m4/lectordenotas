package com.dds.lectordenotas.ui.utils;

import org.uqbar.arena.bindings.ValueTransformer;
import org.uqbar.arena.bindings.transformers.AbstractReadOnlyTransformer;

import java.util.function.Function;

public class ReadOnlyTransformer<M, V> implements ValueTransformer<M, V> {
    private final Function<M, V> modelToViewClosure;
    private final Class<M> modelType;
    private final Class<V> viewType;

    @Override
    public M viewToModel(V v) {
        // No anda AbstractReadOnlyTransformer wtf.
        return null;
    }

    @Override
    public V modelToView(M m) {
        return modelToViewClosure.apply(m);
    }

    @Override
    public Class<M> getModelType() {
        return modelType;
    }

    @Override
    public Class<V> getViewType() {
        return viewType;
    }

    private ReadOnlyTransformer(Function<M, V> modelToViewClosure, Class<M> modelType, Class<V> viewType) {
        this.modelToViewClosure = modelToViewClosure;
        this.modelType = modelType;
        this.viewType = viewType;
    }

    public static <M, V> ReadOnlyTransformer<M, V> fromClosure(Function<M, V> closure, Class<M> modelType, Class<V> viewType) {
        return new ReadOnlyTransformer(closure, modelType, viewType);
    }
}
