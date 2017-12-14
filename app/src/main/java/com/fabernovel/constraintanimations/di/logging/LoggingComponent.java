package com.fabernovel.constraintanimations.di.logging;

import com.fabernovel.constraintanimations.app.common.BaseActivity;
import com.fabernovel.constraintanimations.app.common.BaseDialog;
import com.fabernovel.constraintanimations.app.common.BaseDialogFragment;
import com.fabernovel.constraintanimations.app.common.BaseFragment;
import com.fabernovel.constraintanimations.app.common.BaseIntentService;
import com.fabernovel.constraintanimations.app.common.BaseService;
import com.fabernovel.constraintanimations.utils.aspect.TracerAspect;

import dagger.Subcomponent;

@Subcomponent
public interface LoggingComponent {
    void inject(BaseActivity injected);
    void inject(BaseDialog injected);
    void inject(BaseDialogFragment injected);
    void inject(BaseFragment injected);
    void inject(BaseIntentService injected);
    void inject(BaseService injected);

    void inject(TracerAspect tracerAspect);

    @Subcomponent.Builder
    interface Builder {
        LoggingComponent build();
    }
}
