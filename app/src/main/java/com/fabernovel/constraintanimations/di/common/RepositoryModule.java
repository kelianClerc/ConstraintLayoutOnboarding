package com.fabernovel.constraintanimations.di.common;

import com.fabernovel.constraintanimations.core.boundary.ExampleRepository;
import com.fabernovel.constraintanimations.data.ExampleRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {
    @Provides @Singleton ExampleRepository provideExampleRepository(
        ExampleRepositoryImpl exampleRepository
    ) {
        return exampleRepository;
    }
}
