package dev.tae.com.routes.observers;


import java.util.List;

import dev.tae.com.routes.model.Model;
import retrofit.http.GET;
import retrofit.http.Headers;
import rx.Observable;

/**
 * Created by TAE on 03/06/2016.
 */
public interface APIClass {
    @Headers({
            "Accept-Tenant: uk",
            "Accept-Language: en-GB",
            "Authorization: Basic V3VuZWxsaVRlc3RVc2VyOnJlc1V0c2VUaWxsZW51Vw",
            "Host: wunelliuat.com"
    })
    @GET("/testingtalent/journeys")
    Observable<List<Model>> getJourneys();
}