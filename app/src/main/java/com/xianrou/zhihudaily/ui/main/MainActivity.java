package com.xianrou.zhihudaily.ui.main;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.xianrou.zhihudaily.R;
import com.xianrou.zhihudaily.base.BaseActivity;
import com.xianrou.zhihudaily.uitls.FragmentFactory;

import butterknife.BindView;

public class MainActivity extends BaseActivity
		implements NavigationView.OnNavigationItemSelectedListener {

	@BindView(R.id.container)
	FrameLayout container;
	@BindView(R.id.nav_view)
	NavigationView navView;
	@BindView(R.id.drawer_layout)
	DrawerLayout drawerLayout;

	@Override
	protected void initViews() {

		navView.setNavigationItemSelectedListener(this);
		selectFragment(FragmentFactory.ZHIHU);
	}

	private void selectFragment(int position) {
		loadFragment(R.id.container, FragmentFactory.getInstance().getFragment(position));
	}

	public void setDrawerToggle(Toolbar toolbar) {
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
				MainActivity.this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
		drawerLayout.addDrawerListener(toggle);
		toggle.syncState();
	}

	@Override
	protected void initData() {
	}

	@Override
	protected int getContentId() {
		return R.layout.activity_main;
	}

	@Override
	public void onBackPressed() {
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		if (drawer.isDrawerOpen(GravityCompat.START)) {
			drawer.closeDrawer(GravityCompat.START);
		} else {
			super.onBackPressed();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@SuppressWarnings("StatementWithEmptyBody")
	@Override
	public boolean onNavigationItemSelected(MenuItem item) {
		// Handle navigation view item clicks here.
		int id = item.getItemId();

		if (id == R.id.nav_camera) {
			selectFragment(FragmentFactory.ZHIHU);
		} else if (id == R.id.nav_gallery) {

		} else if (id == R.id.nav_slideshow) {

		} else if (id == R.id.nav_manage) {

		} else if (id == R.id.nav_favorite) {
			selectFragment(FragmentFactory.FAVORITY);
		} else if (id == R.id.nav_send) {

		}

		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawer.closeDrawer(GravityCompat.START);
		return true;
	}
}
