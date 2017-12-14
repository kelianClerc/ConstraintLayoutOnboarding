package com.fabernovel.constraintanimations.app.singleviewmoving.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionManager;
import android.view.View;

import com.fabernovel.constraintanimations.R;
import com.fabernovel.constraintanimations.app.common.BaseActivity;
import com.fabernovel.constraintanimations.app.singleviewmoving.ui.SingleViewMovingViewContract;
import com.fabernovel.constraintanimations.di.ComponentManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SingleViewMovingActivity extends BaseActivity implements SingleViewMovingViewContract {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.constraint) ConstraintLayout constraint;

    private boolean hasActivated;
    private final ConstraintSet constraintSet1 = new ConstraintSet();
    private final ConstraintSet constraintSet2 = new ConstraintSet();
    private final ConstraintSet constraintSet3 = new ConstraintSet();
    private final ConstraintSet constraintSet4 = new ConstraintSet();
    private final ConstraintSet constraintSet5 = new ConstraintSet();
    int state;

    public static Intent makeIntent(Context context) {
        return new Intent(context, SingleViewMovingActivity.class);
    }

    @Override
    protected void injectDependencies() {
        ComponentManager.getLoggingComponent().inject(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupView();
        setupAnimation();
        setupToolbar();
    }

    private void setupView() {
        setContentView(R.layout.activity_single_moving);
        ButterKnife.bind(this);
    }

    private void setupAnimation() {
        constraintSet1.clone(constraint);
        constraintSet2.clone(this, R.layout.partial_single_view_0);
        constraintSet3.clone(this, R.layout.partial_single_view_1);
        constraintSet4.clone(this, R.layout.partial_single_view_2);
        constraintSet5.clone(this, R.layout.partial_single_view_3);
    }

    private void setupToolbar() {
        toolbar.setNavigationOnClickListener(getNavigationListener());
    }

    private View.OnClickListener getNavigationListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        };
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, R.anim.slide_down);
    }

    @OnClick(R.id.activate)
    public void onActivate() {
        state = (state + 1) % 5;
        animate();
    }

    private void animate() {
        TransitionManager.beginDelayedTransition(constraint);

        ConstraintSet toApply1;
        switch (state) {
            case 0:
                toApply1 = constraintSet1;
                break;
            case 1:
                toApply1 = constraintSet2;
                break;
            case 2:
                toApply1 = constraintSet3;
                break;
            case 3:
                toApply1 = constraintSet4;
                break;
            default:
                toApply1 = constraintSet5;
                break;
        }
        toApply1.applyTo(constraint);

        //TransitionManager.beginDelayedTransition(constraint);
        //toApply2.applyTo(constraint);
    }
}
