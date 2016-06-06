package dev.tae.com.routes.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model {

    @SerializedName("journeyID")
    @Expose
    private Integer journeyID;
    @SerializedName("startLocality")
    @Expose
    private String startLocality;
    @SerializedName("startCoordinate")
    @Expose
    private StartCoordinate startCoordinate;
    @SerializedName("startDate")
    @Expose
    private StartDate startDate;
    @SerializedName("endLocality")
    @Expose
    private String endLocality;
    @SerializedName("endCoordinate")
    @Expose
    private EndCoordinate endCoordinate;
    @SerializedName("endDate")
    @Expose
    private EndDate endDate;
    @SerializedName("distance")
    @Expose
    private Integer distance;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("route")
    @Expose
    private String route;
    @SerializedName("invalidReason")
    @Expose
    private String invalidReason;

    /**
     *
     * @return
     * The journeyID
     */
    public Integer getJourneyID() {
        return journeyID;
    }

    /**
     *
     * @param journeyID
     * The journeyID
     */
    public void setJourneyID(Integer journeyID) {
        this.journeyID = journeyID;
    }

    /**
     *
     * @return
     * The startLocality
     */
    public String getStartLocality() {
        return startLocality;
    }

    /**
     *
     * @param startLocality
     * The startLocality
     */
    public void setStartLocality(String startLocality) {
        this.startLocality = startLocality;
    }

    /**
     *
     * @return
     * The startCoordinate
     */
    public StartCoordinate getStartCoordinate() {
        return startCoordinate;
    }

    /**
     *
     * @param startCoordinate
     * The startCoordinate
     */
    public void setStartCoordinate(StartCoordinate startCoordinate) {
        this.startCoordinate = startCoordinate;
    }

    /**
     *
     * @return
     * The startDate
     */
    public StartDate getStartDate() {
        return startDate;
    }

    /**
     *
     * @param startDate
     * The startDate
     */
    public void setStartDate(StartDate startDate) {
        this.startDate = startDate;
    }

    /**
     *
     * @return
     * The endLocality
     */
    public String getEndLocality() {
        return endLocality;
    }

    /**
     *
     * @param endLocality
     * The endLocality
     */
    public void setEndLocality(String endLocality) {
        this.endLocality = endLocality;
    }

    /**
     *
     * @return
     * The endCoordinate
     */
    public EndCoordinate getEndCoordinate() {
        return endCoordinate;
    }

    /**
     *
     * @param endCoordinate
     * The endCoordinate
     */
    public void setEndCoordinate(EndCoordinate endCoordinate) {
        this.endCoordinate = endCoordinate;
    }

    /**
     *
     * @return
     * The endDate
     */
    public EndDate getEndDate() {
        return endDate;
    }

    /**
     *
     * @param endDate
     * The endDate
     */
    public void setEndDate(EndDate endDate) {
        this.endDate = endDate;
    }

    /**
     *
     * @return
     * The distance
     */
    public Integer getDistance() {
        return distance;
    }

    /**
     *
     * @param distance
     * The distance
     */
    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    /**
     *
     * @return
     * The duration
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     *
     * @param duration
     * The duration
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     *
     * @return
     * The route
     */
    public String getRoute() {
        return route;
    }

    /**
     *
     * @param route
     * The route
     */
    public void setRoute(String route) {
        this.route = route;
    }

    /**
     *
     * @return
     * The invalidReason
     */
    public String getInvalidReason() {
        return invalidReason;
    }

    /**
     *
     * @param invalidReason
     * The invalidReason
     */
    public void setInvalidReason(String invalidReason) {
        this.invalidReason = invalidReason;
    }

}

