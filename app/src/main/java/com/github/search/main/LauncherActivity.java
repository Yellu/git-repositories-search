package com.github.search.main;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.github.search.R;
import com.github.search.main.ContributorDetailsFragment;
import com.github.search.event.ContributorDetailsEvent;
import com.github.search.event.ProjectLinkEvent;
import com.github.search.event.RepoDetailsEvent;
import com.github.search.main.HomeFragment;
import com.github.search.main.RepoDetailsFragment;
import com.github.search.main.WebViewFragment;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by yellappa on 17/1/18.
 */

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.repo, new HomeFragment())
                .commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Subscribe
    public void launchRepoDetails(RepoDetailsEvent repoDetailsEvent){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.repo, new RepoDetailsFragment())
                .addToBackStack(null)
                .commit();
    }

    @Subscribe
    public void launchContributorDetails(ContributorDetailsEvent contributorDetailsEvent){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.repo, new ContributorDetailsFragment())
                .addToBackStack(null)
                .commit();
    }

    @Subscribe
    public void launchProjectDetails(ProjectLinkEvent projectLinkEvent){
        Bundle argsBundle = new Bundle();
        argsBundle.putString("projectLink", projectLinkEvent.getUrl());
        WebViewFragment webViewFragment = new WebViewFragment();
        webViewFragment.setArguments(argsBundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.repo, webViewFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
