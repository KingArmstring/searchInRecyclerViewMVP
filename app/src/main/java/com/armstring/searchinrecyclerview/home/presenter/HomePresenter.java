package com.armstring.searchinrecyclerview.home.presenter;

import com.armstring.searchinrecyclerview.home.HomeContract;
import com.armstring.searchinrecyclerview.home.Model.HomeModel;
import com.armstring.searchinrecyclerview.home.view.MainActivity;



public class HomePresenter implements HomeContract.HomePresenterInterface {
    private HomeContract.HomeViewInterface homeView;
    private HomeContract.HomeModelInterface homeModel;

    public HomePresenter() {
        homeView = new MainActivity();
        homeModel = new HomeModel(this);
    }
}
