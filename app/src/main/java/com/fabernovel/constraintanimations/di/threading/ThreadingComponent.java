package com.fabernovel.constraintanimations.di.threading;

import com.fabernovel.constraintanimations.utils.aspect.ThreadingAspect;

import dagger.Subcomponent;

@Subcomponent(modules = ThreadingModule.class)
public interface ThreadingComponent {
    void inject(ThreadingAspect aspect);
}
