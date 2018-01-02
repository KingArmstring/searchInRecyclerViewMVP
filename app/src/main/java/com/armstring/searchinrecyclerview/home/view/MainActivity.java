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
    String[] names = {"algeria", "argentina", "armenia", "australia", "bahrain", "belgium", "bosnia", "brazil",
        "britain", "cameron", "canada", "chile", "china", "colombia", "cotedivoire", "croatia", "egypt", "emirates",
        "finland", "france", "gabon", "germany", "ghana", "greece", "guinea", "india", "indonesia", "iran", "iraq", "korea",
        "lybia", "mexico", "morocco", "netherlands", "newzealand", "nigeria", "norway", "oman", "pakistan", "palestine",
        "panama", "paraguay", "peru", "poland", "portugal", "qatar", "romania", "russia", "saudi", "spain",
        "sudan", "sweden", "switzerland", "tunisia", "turkey", "ukraine", "unitedstates", "venezuela", "yemen", "zimbabwe"};

    int[] imgs = {R.drawable.algeria, R.drawable.argentina, R.drawable.armenia, R.drawable.australia, R.drawable.bahrain,
        R.drawable.belgium, R.drawable.bosnia, R.drawable.brazil, R.drawable.britain, R.drawable.cameron, R.drawable.canada,
        R.drawable.chile, R.drawable.china, R.drawable.colombia, R.drawable.cotedivoire, R.drawable.croatia, R.drawable.egypt,
        R.drawable.emirates, R.drawable.finland, R.drawable.france, R.drawable.gabon, R.drawable.germany, R.drawable.ghana,
        R.drawable.greece, R.drawable.guinea, R.drawable.india, R.drawable.indonesia, R.drawable.iran, R.drawable.iraq,
        R.drawable.korea, R.drawable.lybia, R.drawable.mexico, R.drawable.morocco, R.drawable.netherlands, R.drawable.newzealand,
        R.drawable.nigeria, R.drawable.norway, R.drawable.oman, R.drawable.pakistan, R.drawable.palestine, R.drawable.panama,
        R.drawable.paraguay, R.drawable.peru, R.drawable.poland, R.drawable.portugal, R.drawable.qatar, R.drawable.romania,
        R.drawable.russia, R.drawable.saudi, R.drawable.spain, R.drawable.sudan, R.drawable.sweden, R.drawable.switzerland,
        R.drawable.tunisia, R.drawable.turkey, R.drawable.ukraine, R.drawable.unitedstates, R.drawable.venezuela,
        R.drawable.yemen, R.drawable.zimbabwe};

    private Toolbar toolbar;
    private RecyclerView countryList;
    private RecyclerAdapter adapter;
    private ArrayList<Country> countries = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.mainActivityToolbarId);
        setSupportActionBar(toolbar);
        countryList = (RecyclerView)findViewById(R.id.countriesListId);
        countryList.setLayoutManager(new LinearLayoutManager(this));
        countryList.setHasFixedSize(true);

        homePresenter = new HomePresenter();

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
    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
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
