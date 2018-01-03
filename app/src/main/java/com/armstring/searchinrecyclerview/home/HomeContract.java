package com.armstring.searchinrecyclerview.home;

/**
 * Created by Darkwood on 1/2/2018.
 */

public interface HomeContract {
    interface HomeViewInterface{

    }
    interface HomePresenterInterface{
        public String[] getCountriesNames();
        public int[] getCountriesImages();
    }
    interface HomeModelInterface{
        public String[] getNames();
        public int[] getImgs();
    }
}
