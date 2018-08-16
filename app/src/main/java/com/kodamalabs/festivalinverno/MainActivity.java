package com.kodamalabs.festivalinverno;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

import com.kodamalabs.festivalinverno.fragments.CategoryFragment;
import com.kodamalabs.festivalinverno.fragments.FoodTruckFragment;
import com.kodamalabs.festivalinverno.fragments.LineUpFragment;
import com.kodamalabs.festivalinverno.fragments.SighteeingFragment;
import com.kodamalabs.festivalinverno.fragments.TownFragment;
import com.kodamalabs.festivalinverno.fragments.TurismFragment;
import com.kodamalabs.festivalinverno.mappers.FoodTruckMapper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.setDrawerListener(toggle);
    drawer.openDrawer(Gravity.LEFT);
    toggle.syncState();
    getSupportActionBar().setTitle("LineUp");

    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);
    refreshScreen(LineUpFragment.newInstance());

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
      getSupportActionBar().setTitle("Realização");
      refreshScreen(TownFragment.newInstance());
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @SuppressWarnings("StatementWithEmptyBody")
  @Override
  public boolean onNavigationItemSelected(MenuItem item) {
    int id = item.getItemId();

    Fragment fragment = null;

    if (id == R.id.nav_lineup) {
      fragment = LineUpFragment.newInstance();
      getSupportActionBar().setTitle("LineUp");
    } else if (id == R.id.nav_foodtruck) {
      fragment = FoodTruckFragment.newInstance();
      getSupportActionBar().setTitle("FoodTrucks");
    } else if (id == R.id.nav_turismo) {
      fragment = SighteeingFragment.newInstance();
      getSupportActionBar().setTitle("Turismo");
    }else if (id == R.id.nav_passeio) {
      fragment = TurismFragment.newInstance();
      getSupportActionBar().setTitle("Passeios");
    }else if (id == R.id.nav_servicos) {
      fragment = CategoryFragment.newInstance();
      getSupportActionBar().setTitle("Serviços");
    }

    if(fragment != null){
      refreshScreen(fragment);
    }
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }

  private void refreshScreen(Fragment fragment) {
    FragmentManager fragmentManager = getSupportFragmentManager();
    fragmentManager.beginTransaction()
        .replace(R.id.container, fragment)
        .commit();
  }
}
