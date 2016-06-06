package dev.tae.com.routes.routeviews;

import android.content.Context;

/**
 * Created by TAE on 05/06/2016.
 */
public interface LocationInterfaces {
    void setLocation(Context context, int index, double[] gps, String startName, String endName);
}
