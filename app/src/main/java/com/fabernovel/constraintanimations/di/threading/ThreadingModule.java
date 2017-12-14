package com.fabernovel.constraintanimations.di.threading;

import com.fabernovel.constraintanimations.utils.threading.JobExecutor;
import com.fabernovel.constraintanimations.utils.threading.PostExecutionThread;
import com.fabernovel.constraintanimations.utils.threading.ThreadExecutor;
import com.fabernovel.constraintanimations.utils.threading.UiThread;

import dagger.Module;
import dagger.Provides;

@Module
public class ThreadingModule {

    @Provides
    ThreadExecutor provideExecutor(JobExecutor instance) {
        return instance;
    }

    @Provides
    PostExecutionThread providePostThread(UiThread instance) {
        return instance;
    }
}
