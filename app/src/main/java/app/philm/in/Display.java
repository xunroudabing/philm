package app.philm.in;

import com.google.common.base.Preconditions;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;

import app.philm.in.fragments.LibraryListFragment;
import app.philm.in.fragments.LoginFragment;
import app.philm.in.fragments.TrendingListFragment;

public class Display {

    private final Activity mActivity;

    public Display(Activity activity) {
        mActivity = Preconditions.checkNotNull(activity, "activity cannot be null");
    }

    public void showLibrary() {
        LibraryListFragment fragment = new LibraryListFragment();

        mActivity.getFragmentManager().beginTransaction()
                .replace(R.id.fragment_main, fragment)
                .commit();

        setActionBarTitle(R.string.library_title);
    }

    public void showTrending() {
        TrendingListFragment fragment = new TrendingListFragment();

        mActivity.getFragmentManager().beginTransaction()
                .replace(R.id.fragment_main, fragment)
                .commit();

        setActionBarTitle(R.string.trending_title);
    }

    public void showLogin() {
        LoginFragment fragment = new LoginFragment();

        mActivity.getFragmentManager().beginTransaction()
                .replace(R.id.fragment_main, fragment)
                .commit();
    }

    public void closeDrawerLayout() {
        DrawerLayout drawerLayout = (DrawerLayout) mActivity.findViewById(R.id.drawer_layout);
        if (drawerLayout != null) {
            drawerLayout.closeDrawers();
        }
    }

    private void setActionBarTitle(int titleResId) {
        mActivity.getActionBar().setTitle(titleResId);
    }

}
