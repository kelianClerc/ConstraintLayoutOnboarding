package com.fabernovel.constraintanimations.app.example.presenter;

import android.support.annotation.StringRes;

import com.fabernovel.constraintanimations.app.example.ui.ExampleViewContract;
import com.fabernovel.constraintanimations.core.interactor.ExampleInteractor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import de.bechte.junit.runners.context.HierarchicalContextRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

@RunWith(HierarchicalContextRunner.class)
public class ExamplePresenterTest {

    @StringRes
    private static final int RESULT = 42;

    @Mock ExampleViewContract view;
    @Mock ExampleInteractor interactor;

    private ExamplePresenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new ExamplePresenter(view, interactor);
    }

    @Test
    public void onStart_should_executeInteractor() throws Exception {
        presenter.start();

        verify(interactor).execute(presenter);
    }

    @Test
    public void onResult_should_showMessage() throws Exception {
        presenter.onResult(RESULT);

        verify(view).showMessage(RESULT);
    }

    public class DidGetResult {

        @Before
        public void setUp() throws Exception {
            presenter.onResult(RESULT);
        }

        @Test
        public void onStart_shouldNot_executeInteractor() throws Exception {
            presenter.start();

            verifyZeroInteractions(interactor);
        }

    }
}
