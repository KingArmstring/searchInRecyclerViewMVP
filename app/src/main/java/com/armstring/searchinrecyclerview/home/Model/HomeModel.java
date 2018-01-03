package com.armstring.searchinrecyclerview.home.Model;

import com.armstring.searchinrecyclerview.R;
import com.armstring.searchinrecyclerview.home.HomeContract;

/**
 * Created by Darkwood on 1/2/2018.
 */

public class HomeModel implements HomeContract.HomeModelInterface {
    private HomeContract.HomePresenterInterface homePresenter;

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

    public HomeModel(HomeContract.HomePresenterInterface homePresenter) {
        this.homePresenter = homePresenter;
    }

    public String[] getNames() {
        return names;
    }

    public int[] getImgs() {
        return imgs;
    }
}
