package dev.tae.com.routes.routeviews;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import dev.tae.com.routes.R;
import dev.tae.com.routes.constant.Constant;
import dev.tae.com.routes.model.Model;
import dev.tae.com.routes.observers.APIClass;
import retrofit.ErrorHandler;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.converter.GsonConverter;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by TAE on 05/06/2016.
 */
public class RouteView extends Fragment{

    private RecyclerView recyclerView;
    protected RouteViewAdapter routeViewAdapter;
    private CompositeSubscription subscription = new CompositeSubscription();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.route_view_layout, container, false);

            recyclerView = (RecyclerView) v.findViewById(R.id.list);
            recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            downloadData();
        return v;
    }

    private void downloadData(){
        RestAdapter.Builder rest;
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                .create();
        rest = new RestAdapter.Builder();
        rest.setEndpoint(Constant.baseURL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new GsonConverter(gson))
                .setErrorHandler(new ErrorHandler() {
                    @Override
                    public Throwable handleError(RetrofitError cause) {
                        Log.i("downloadData", cause.getMessage());
                        return null;
                    }
                })
                .build();

        APIClass api = rest.build().create(APIClass.class);
        subscription.add(api.getJourneys()
                        .observeOn(AndroidSchedulers.mainThread())
                                // .delay(5000, TimeUnit.MILLISECONDS)
                        .subscribeOn(Schedulers.io())
                        .subscribe(new rx.Observer<List<Model>>(){
                                       @Override
                                       public void onNext(List<Model> model) {
                                           if(recyclerView != null){
                                               routeViewAdapter = new RouteViewAdapter(getContext(), model);
                                               recyclerView.setAdapter(routeViewAdapter);
                                           }
                                       }

                                       @Override
                                       public void onCompleted() {

                                       }

                                       @Override
                                       public void onError(Throwable e) {
                                           Log.i("onError", e.getMessage());
                                       }
                                   }
                        )
        );
    }
}