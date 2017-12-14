package com.fabernovel.constraintanimations.app.main.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.text.Html;
import android.widget.TextView;

import com.fabernovel.constraintanimations.R;
import com.fabernovel.constraintanimations.app.common.BaseActivity;
import com.fabernovel.constraintanimations.app.main.presenter.MainPresenter;
import com.fabernovel.constraintanimations.app.main.ui.MainViewContract;
import com.fabernovel.constraintanimations.utils.theme.ThemeUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainViewContract {

    @Inject MainPresenter presenter;

    @BindView(R.id.readme) TextView readMe;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ThemeUtils.ensureRuntimeTheme(this);
        super.onCreate(savedInstanceState);
        setupView();
    }

    private void setupView() {
        setContentView(R.layout.activity_example);
        ButterKnife.bind(this);
    }

    @Override protected void onStart() {
        super.onStart();
        presenter.start();
    }

    @Override protected void onStop() {
        super.onStop();
        presenter.stop();
    }

    @Override public void showMessage(@StringRes int message) {
        readMe.setText(Html.fromHtml(getString(message)));
    }
}
