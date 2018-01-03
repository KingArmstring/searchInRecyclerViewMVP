package com.armstring.searchinrecyclerview.home.presenter;

import com.armstring.searchinrecyclerview.home.HomeContract;
import com.armstring.searchinrecyclerview.home.Model.HomeModel;
import com.armstring.searchinrecyclerview.home.view.MainActivity;



public class HomePresenter implements HomeContract.HomePresenterInterface {
    private HomeContract.HomeViewInterface homeView;
    private HomeContract.HomeModelInterface homeModel;



    public HomePresenter() {
        homeView = new MainActivity();//will be used to take search query to the model an come back with data.
        homeModel = new HomeModel(this);
    }

    /*
    public HomePresenter(Activity mainActivityInstance){
        this.homeView = mainActivityInstance;
    }

    public HomePresenter(HomeModel homeModelInstance){
        this.homeModel = homeModelInstance;
    }
     */


    public String[] getCountriesNames(){
        return homeModel.getNames();
    }

    public int[] getCountriesImages(){
        return homeModel.getImgs();
    }
}
