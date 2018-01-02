package com.armstring.searchinrecyclerview.home.Model;

import com.armstring.searchinrecyclerview.home.HomeContract;

/**
 * Created by Darkwood on 1/2/2018.
 */

public class HomeModel implements HomeContract.HomeModelInterface {
    private HomeContract.HomePresenterInterface homePresenter;

    public HomeModel(HomeContract.HomePresenterInterface homePresenter) {
        this.homePresenter = homePresenter;
    }
}
