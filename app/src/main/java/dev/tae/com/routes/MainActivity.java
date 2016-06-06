package dev.tae.com.routes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import dev.tae.com.routes.maps.MapLocations;
import dev.tae.com.routes.routeviews.LocationInterfaces;
import dev.tae.com.routes.routeviews.RouteView;
import dev.tae.com.routes.routeviews.RouteViewFragment;

public class MainActivity extends AppCompatActivity implements LocationInterfaces {
    private int index;
    private double[] gps;
    private String startName, endName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(index ==0){
            switchFrag(0);
        }else if(index == 1){
            switchFrag(1);
        }
    }

    private void switchFrag(int index){
        Fragment fragment = null;
        Bundle bundle = new Bundle();
        switch(index){
            case 0:
                fragment = new RouteViewFragment();
                break;
            case 1:
                bundle.putDoubleArray("gps", this.gps);
                bundle.putString("startName", this.startName);
                bundle.putString("endName", this.endName);
                Intent intent = new Intent(this, MapLocations.class);
                intent.putExtras(bundle);
                fragment = null;
                startActivity(intent);
                break;
            default:
                fragment = new RouteView();
                break;
        }
        if(fragment != null){

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.main_content, fragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void setLocation(Context context, int index, double[] gps, String startName, String endName) {
        this.index = index;
        this.gps = gps;
        this.startName = startName;
        this.endName = endName;
        if(this.index == 1){
            switchFrag(1);
        }
    }
}
