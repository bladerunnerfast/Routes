package dev.tae.com.routes.routeviews;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.tae.com.routes.R;

/**
 * Created by TAE on 05/06/2016.
 */
public class RouteViewFragment extends Fragment {
    private double startLat, startLng, endLat, endLng;
    private Bundle bundle;
    private int index;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.route_view_container_layout, container, false);
        bundle = getArguments();
        if(bundle != null){
            index = bundle.getInt("index");
            startLat = bundle.getDouble("startLat");
            startLng = bundle.getDouble("startLng");
            endLat = bundle.getDouble("endLat");
            endLng = bundle.getDouble("endLng");
        }
        if(index == 0){
            switchFrag(0);
        }
        return v;
    }

    private void switchFrag(int index){
        Fragment fragment = null;
        bundle = new Bundle();
        switch(index){
            case 0:
                fragment = new RouteView();
                break;
            default:
                fragment = new RouteView();
                break;
        }
        if(fragment != null){

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.route_frag_holder, fragment);
            fragmentTransaction.commit();
        }
    }
}
