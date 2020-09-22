package com.optimised_buildings_ltd.InfoGrid;

import com.tridium.ndriver.BNNetwork;
import com.tridium.ndriver.datatypes.BIpAddress;
import com.tridiumx.mqttClientDriver.BAbstractMqttDriverDevice;
import com.tridiumx.mqttClientDriver.BAbstractMqttDriverNetwork;

import javax.baja.collection.BITable;
import javax.baja.driver.BDevice;
import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import javax.baja.util.IFuture;
import javax.baja.util.Invocation;
import java.net.InetAddress;
import java.util.logging.Logger;

@NiagaraType
@NiagaraProperty(name = "accessKey", type = "BString", defaultValue = "BString.DEFAULT")
@NiagaraProperty(name = "secretKey", type = "BString", defaultValue = "BString.DEFAULT")
@NiagaraProperty(name = "bearerToken", type = "BString", defaultValue = "BString.DEFAULT")
@NiagaraProperty(name = "infoGridApi", type = "BInfoGridAPI", defaultValue = "new BInfoGridAPI()")
@NiagaraProperty(name = "console", type = "BString", defaultValue = "BString.DEFAULT", facets = @Facet(name = "\"multiLine\"", value = "true"))
@NiagaraProperty(name = "points", type = "BInfoGridPointDeviceExt", defaultValue = "new BInfoGridPointDeviceExt()")
@NiagaraAction(name = "pollData")

public class BInfoGridDevice extends BDevice {

    public void started(){
        if(Sys.getStation().isRunning()){
            Clock.schedulePeriodically(this.asComponent(),BRelTime.makeMinutes(2),this.getAction("pollData"),null);
        }
    }

    public Type getNetworkType(){return BInfoGridNetwork.TYPE;}

    public IFuture postAsync(Runnable r) {
        return ((BNNetwork)this.getNetwork()).postAsync(r);
    }

    protected IFuture postPing() {
        return this.postAsync(new Invocation(this, ping, (BValue)null, (Context)null));
    }

    public void doPing(){
        this.getInfoGridApi().doGetToken();
    }

    Logger logger = Logger.getLogger("ob.infogrid");

    public void doPollData(){
        String bql = "station:|" + this.asComponent().getSlotPath() + "|bql:select * from InfoGrid:InfoGridProxyExt";
        BITable result = (BITable) BOrd.make(bql).resolve().get();
        Cursor c = result.cursor();
        BInfoGridAPI api = this.getInfoGridApi();
        while(c.next()){
            BInfoGridProxyExt ext = (BInfoGridProxyExt)c.get();
            String pointId = ext.getPointId();
            try {
                ext.doReadMessage(api.doGetSensorData(BString.make(pointId)));
            } catch (Exception e){
                logger.warning("API Failure: " + ext.getSlotPath() + ", " + pointId + ", " + e.toString());
            }
        }
    }


/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.optimised_buildings_ltd.InfoGrid.BInfoGridDevice(4287543629)1.0$ @*/
/* Generated Fri Jul 24 14:47:25 BST 2020 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "accessKey"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code accessKey} property.
   * @see #getAccessKey
   * @see #setAccessKey
   */
  public static final Property accessKey = newProperty(0, BString.DEFAULT, null);
  
  /**
   * Get the {@code accessKey} property.
   * @see #accessKey
   */
  public String getAccessKey() { return getString(accessKey); }
  
  /**
   * Set the {@code accessKey} property.
   * @see #accessKey
   */
  public void setAccessKey(String v) { setString(accessKey, v, null); }

////////////////////////////////////////////////////////////////
// Property "secretKey"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code secretKey} property.
   * @see #getSecretKey
   * @see #setSecretKey
   */
  public static final Property secretKey = newProperty(0, BString.DEFAULT, null);
  
  /**
   * Get the {@code secretKey} property.
   * @see #secretKey
   */
  public String getSecretKey() { return getString(secretKey); }
  
  /**
   * Set the {@code secretKey} property.
   * @see #secretKey
   */
  public void setSecretKey(String v) { setString(secretKey, v, null); }

////////////////////////////////////////////////////////////////
// Property "bearerToken"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code bearerToken} property.
   * @see #getBearerToken
   * @see #setBearerToken
   */
  public static final Property bearerToken = newProperty(0, BString.DEFAULT, null);
  
  /**
   * Get the {@code bearerToken} property.
   * @see #bearerToken
   */
  public String getBearerToken() { return getString(bearerToken); }
  
  /**
   * Set the {@code bearerToken} property.
   * @see #bearerToken
   */
  public void setBearerToken(String v) { setString(bearerToken, v, null); }

////////////////////////////////////////////////////////////////
// Property "infoGridApi"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code infoGridApi} property.
   * @see #getInfoGridApi
   * @see #setInfoGridApi
   */
  public static final Property infoGridApi = newProperty(0, new BInfoGridAPI(), null);
  
  /**
   * Get the {@code infoGridApi} property.
   * @see #infoGridApi
   */
  public BInfoGridAPI getInfoGridApi() { return (BInfoGridAPI)get(infoGridApi); }
  
  /**
   * Set the {@code infoGridApi} property.
   * @see #infoGridApi
   */
  public void setInfoGridApi(BInfoGridAPI v) { set(infoGridApi, v, null); }

////////////////////////////////////////////////////////////////
// Property "console"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code console} property.
   * @see #getConsole
   * @see #setConsole
   */
  public static final Property console = newProperty(0, BString.DEFAULT, BFacets.make("multiLine", true));
  
  /**
   * Get the {@code console} property.
   * @see #console
   */
  public String getConsole() { return getString(console); }
  
  /**
   * Set the {@code console} property.
   * @see #console
   */
  public void setConsole(String v) { setString(console, v, null); }

////////////////////////////////////////////////////////////////
// Property "points"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code points} property.
   * @see #getPoints
   * @see #setPoints
   */
  public static final Property points = newProperty(0, new BInfoGridPointDeviceExt(), null);
  
  /**
   * Get the {@code points} property.
   * @see #points
   */
  public BInfoGridPointDeviceExt getPoints() { return (BInfoGridPointDeviceExt)get(points); }
  
  /**
   * Set the {@code points} property.
   * @see #points
   */
  public void setPoints(BInfoGridPointDeviceExt v) { set(points, v, null); }

////////////////////////////////////////////////////////////////
// Action "pollData"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code pollData} action.
   * @see #pollData()
   */
  public static final Action pollData = newAction(0, null);
  
  /**
   * Invoke the {@code pollData} action.
   * @see #pollData
   */
  public void pollData() { invoke(pollData, null, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BInfoGridDevice.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
}
