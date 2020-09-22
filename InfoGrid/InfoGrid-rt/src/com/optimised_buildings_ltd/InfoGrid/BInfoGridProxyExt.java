package com.optimised_buildings_ltd.InfoGrid;

import com.optimised_buildings_ltd.InfoGrid.data.BNetworkStatus;
import com.optimised_buildings_ltd.InfoGrid.data.BBatteryStatus;
import com.optimised_buildings_ltd.InfoGrid.data.BReading;
import com.tridium.json.JSONArray;
import com.tridium.json.JSONObject;

import javax.baja.driver.point.BProxyExt;
import javax.baja.driver.point.BReadWriteMode;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.status.BStatusNumeric;
import javax.baja.sys.*;
import java.util.logging.Logger;

@NiagaraType
@NiagaraProperty(name = "pointId", type = "BString", defaultValue = "BString.DEFAULT")
@NiagaraAction(name = "readMessage", parameterType = "BString", defaultValue = "BString.DEFAULT")
@NiagaraProperty(name = "networkStatus", type = "BNetworkStatus", defaultValue = "new BNetworkStatus()")
@NiagaraProperty(name = "batteryStatus", type = "BBatteryStatus", defaultValue = "new BBatteryStatus()")
@NiagaraProperty(name = "reading", type = "BReading", defaultValue = "new BReading()")
@NiagaraProperty(name = "lastPoll", type = "BAbsTime", defaultValue = "BAbsTime.DEFAULT")

public class BInfoGridProxyExt extends BProxyExt {

    public boolean write(Context c) throws Exception {
        return false;
    }

    public void readSubscribed(Context cx){

    }

    public void readUnsubscribed(Context cx){

    }

    public Type getDeviceExtType(){
        return BInfoGridPointDeviceExt.TYPE;
    }

    public BReadWriteMode getMode(){
        return BReadWriteMode.make(0);
    }

    Logger logger = Logger.getLogger("ob.infogrid");

    public void doReadMessage(BString message){
        this.setLastPoll(BAbsTime.now());
        logger.fine(message.getString());
        JSONObject response = new JSONObject(message.getString());
        JSONArray results = response.getJSONArray("results");
        boolean foundNetwork = false; boolean foundBattery = false; boolean foundTemperature = false;
        for(int i = 0; i < results.length(); i++){
            try {
                JSONObject result = (JSONObject) results.get(i);
                String event_type = result.getString("event_type");
                if (event_type.contains("battery")) {
                    if (foundBattery) {
                        continue;
                    }
                    JSONObject event = result.getJSONObject("event");
                    JSONObject data = event.getJSONObject("data");
                    JSONObject batteryStatus = data.getJSONObject("batteryStatus");
                    this.attemptWrite(this.getBatteryStatus(), "percentage", batteryStatus.getInt("percentage"));
                    this.attemptWrite(this.getBatteryStatus(), "updateTime", batteryStatus.getInt("updateTime"));
                    foundBattery = true;
                } else if (event_type.contains("temperature")) {
                    if (foundTemperature) {
                        continue;
                    }
                    JSONObject event = result.getJSONObject("event");
                    JSONObject data = event.getJSONObject("data");
                    JSONObject temperature = data.getJSONObject("temperature");
                    this.attemptWrite(this.getReading(), "value", String.valueOf(temperature.getDouble("value")));
                    this.attemptWrite(this.getReading(), "updateTime", temperature.getString("updateTime"));
                    foundTemperature = true;
                } else if (event_type.contains("network")) {
                    if (foundNetwork) {
                        continue;
                    }
                    JSONObject event = result.getJSONObject("event");
                    JSONObject data = event.getJSONObject("data");
                    JSONObject networkStatus = data.getJSONObject("networkStatus");
                    this.attemptWrite(this.getNetworkStatus(), "signalStrength", networkStatus.getInt("signalStrength"));
                    this.attemptWrite(this.getNetworkStatus(), "transmissionMode", networkStatus.getString("transmissionMode"));
                    this.attemptWrite(this.getNetworkStatus(), "updateTime", networkStatus.getString("updateTime"));
                    this.attemptWrite(this.getNetworkStatus(), "rssi", networkStatus.getInt("rssi"));
                    JSONObject cloudConnectors = networkStatus.getJSONArray("cloudConnectors").getJSONObject(0);
                    this.attemptWrite(this.getNetworkStatus(), "cloudConnector", cloudConnectors.getString("id"));
                    foundNetwork = true;
                }
            } catch (Exception e){
                logger.warning(e.toString());
            }
            if(foundBattery && foundTemperature && foundNetwork){
                break;
            }
        }

        Double value = Double.parseDouble(this.getReading().getValue());
        BStatusNumeric val = new BStatusNumeric(value);
        this.readOk(val);
    }

    public void attemptWrite(BComponent target, String property, String value){
        try {
            target.setString(target.getProperty(property), value);
        } catch (Exception e){}
    }

    public void attemptWrite(BComponent target, String property, int value){
        try {
            target.setInt(target.getProperty(property), value);
        } catch (Exception e){}
    }


/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.optimised_buildings_ltd.InfoGrid.BInfoGridProxyExt(3932633055)1.0$ @*/
/* Generated Fri Jul 24 15:51:10 BST 2020 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "pointId"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code pointId} property.
   * @see #getPointId
   * @see #setPointId
   */
  public static final Property pointId = newProperty(0, BString.DEFAULT, null);
  
  /**
   * Get the {@code pointId} property.
   * @see #pointId
   */
  public String getPointId() { return getString(pointId); }
  
  /**
   * Set the {@code pointId} property.
   * @see #pointId
   */
  public void setPointId(String v) { setString(pointId, v, null); }

////////////////////////////////////////////////////////////////
// Property "networkStatus"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code networkStatus} property.
   * @see #getNetworkStatus
   * @see #setNetworkStatus
   */
  public static final Property networkStatus = newProperty(0, new BNetworkStatus(), null);
  
  /**
   * Get the {@code networkStatus} property.
   * @see #networkStatus
   */
  public BNetworkStatus getNetworkStatus() { return (BNetworkStatus)get(networkStatus); }
  
  /**
   * Set the {@code networkStatus} property.
   * @see #networkStatus
   */
  public void setNetworkStatus(BNetworkStatus v) { set(networkStatus, v, null); }

////////////////////////////////////////////////////////////////
// Property "batteryStatus"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code batteryStatus} property.
   * @see #getBatteryStatus
   * @see #setBatteryStatus
   */
  public static final Property batteryStatus = newProperty(0, new BBatteryStatus(), null);
  
  /**
   * Get the {@code batteryStatus} property.
   * @see #batteryStatus
   */
  public BBatteryStatus getBatteryStatus() { return (BBatteryStatus)get(batteryStatus); }
  
  /**
   * Set the {@code batteryStatus} property.
   * @see #batteryStatus
   */
  public void setBatteryStatus(BBatteryStatus v) { set(batteryStatus, v, null); }

////////////////////////////////////////////////////////////////
// Property "reading"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code reading} property.
   * @see #getReading
   * @see #setReading
   */
  public static final Property reading = newProperty(0, new BReading(), null);
  
  /**
   * Get the {@code reading} property.
   * @see #reading
   */
  public BReading getReading() { return (BReading)get(reading); }
  
  /**
   * Set the {@code reading} property.
   * @see #reading
   */
  public void setReading(BReading v) { set(reading, v, null); }

////////////////////////////////////////////////////////////////
// Property "lastPoll"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code lastPoll} property.
   * @see #getLastPoll
   * @see #setLastPoll
   */
  public static final Property lastPoll = newProperty(0, BAbsTime.DEFAULT, null);
  
  /**
   * Get the {@code lastPoll} property.
   * @see #lastPoll
   */
  public BAbsTime getLastPoll() { return (BAbsTime)get(lastPoll); }
  
  /**
   * Set the {@code lastPoll} property.
   * @see #lastPoll
   */
  public void setLastPoll(BAbsTime v) { set(lastPoll, v, null); }

////////////////////////////////////////////////////////////////
// Action "readMessage"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code readMessage} action.
   * @see #readMessage(BString parameter)
   */
  public static final Action readMessage = newAction(0, BString.DEFAULT, null);
  
  /**
   * Invoke the {@code readMessage} action.
   * @see #readMessage
   */
  public void readMessage(BString parameter) { invoke(readMessage, parameter, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BInfoGridProxyExt.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

}
