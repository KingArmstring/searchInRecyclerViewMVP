package com.armstring.searchinrecyclerview.home.view;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.armstring.searchinrecyclerview.R;
import com.armstring.searchinrecyclerview.home.HomeContract;
import com.armstring.searchinrecyclerview.home.adapter.RecyclerAdapter;
import com.armstring.searchinrecyclerview.beans.Country;
import com.armstring.searchinrecyclerview.home.presenter.HomePresenter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, HomeContract.HomeViewInterface{

    private HomeContract.HomePresenterInterface homePresenter;

    public static final String TAG = "Armstring";
    private String[] names;
    private int[] imgs;

    private Toolbar toolbar;
    private RecyclerView countryList;
    private RecyclerAdapter adapter;
    private ArrayList<Country> countries = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preparingTheUi();
    }

    private void preparingTheUi(){
        toolbar = (Toolbar)findViewById(R.id.mainActivityToolbarId);
        setSupportActionBar(toolbar);
        countryList = (RecyclerView)findViewById(R.id.countriesListId);
        countryList.setLayoutManager(new LinearLayoutManager(this));
        countryList.setHasFixedSize(true);
        homePresenter = new HomePresenter();
        names = homePresenter.getCountriesNames();
        imgs = homePresenter.getCountriesImages();
        putInTheList();
    }

    private void putInTheList(){
        for(int i = 0;i < names.length; i++){
            countries.add(new Country(names[i], imgs[i]));
        }
        adapter = new RecyclerAdapter(countries);
        countryList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuSearchItem = menu.findItem(R.id.actionSearchId);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuSearchItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    //on other hand this method will be only called if the user submits
    // the search query by clicking search of pressing the search icon.
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }


    //when the user enters data to the searchView this method will be invoked
    //this method performs once there is data in the search bar whether the user pressed submit or no.
    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();//accepting the text written in the search bar.
        ArrayList<Country> newList = new ArrayList<>();
        for(Country country: countries){
            String name = country.getName().toLowerCase();
            if(name.contains(newText)){
                newList.add(country);
            }
        }

        adapter.setFilter(newList);//
        return true;
    }
}
