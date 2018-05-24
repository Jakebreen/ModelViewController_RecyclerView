package uk.co.jakebreen.modelviewcontroller_recyclerview.ui.common.controller;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import uk.co.jakebreen.modelviewcontroller_recyclerview.R;
import uk.co.jakebreen.modelviewcontroller_recyclerview.data.remote.ApiService;
import uk.co.jakebreen.modelviewcontroller_recyclerview.data.remote.ApiUtils;
import uk.co.jakebreen.modelviewcontroller_recyclerview.ui.common.view.RootViewImpl;
import uk.co.jakebreen.modelviewcontroller_recyclerview.ui.search.controller.SearchFragment;

public class MainActivity extends AppCompatActivity implements BaseFragment.FragmentCallback {

    private RootViewImpl mRootView;
    public static ApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Instantiate view
        mRootView = new RootViewImpl(this, null);
        // Get root view of associated activity
        setContentView(mRootView.getRootView());
        //
        if (savedInstanceState == null) {
            replaceFragment(SearchFragment.class, false, null);
        }

        mApiService = ApiUtils.getApiService();
    }


    @Override
    public void replaceFragment(Class<? extends Fragment> c, boolean addToBackStack, Bundle args) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment newFragment;

        // Instantiate new fragment
        try {
            newFragment = c.newInstance();
            if (args != null) newFragment.setArguments(args);
        } catch (InstantiationException e) {
            e.printStackTrace();
            return;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return;
        }

        // Add transaction onto backstack
        if (addToBackStack) {
            ft.addToBackStack(null);
        }

        // Change fragment
        ft.replace(R.id.frame, newFragment, c.getClass().getSimpleName());
        ft.commit();
    }
}
