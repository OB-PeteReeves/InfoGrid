package com.optimised_buildings_ltd.InfoGrid.data;

import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType
@NiagaraProperty(name = "signalStrength", type = "BInteger", defaultValue = "BInteger.DEFAULT")
@NiagaraProperty(name = "rssi", type = "BInteger", defaultValue = "BInteger.DEFAULT")
@NiagaraProperty(name = "cloudConnector", type = "BString", defaultValue = "BString.DEFAULT")
@NiagaraProperty(name = "transmissionMode", type = "BString", defaultValue = "BString.DEFAULT")
@NiagaraProperty(name = "updateTime", type = "BString", defaultValue = "BString.DEFAULT") //TODO MAYBE CHANGE THIS TO ABSTIME

public class BNetworkStatus extends BComponent {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.optimised_buildings_ltd.InfoGrid.data.BNetworkStatus(3533272664)1.0$ @*/
/* Generated Fri Jul 24 16:59:25 BST 2020 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "signalStrength"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code signalStrength} property.
   * @see #getSignalStrength
   * @see #setSignalStrength
   */
  public static final Property signalStrength = newProperty(0, ((BInteger)(BInteger.DEFAULT)).getInt(), null);
  
  /**
   * Get the {@code signalStrength} property.
   * @see #signalStrength
   */
  public int getSignalStrength() { return getInt(signalStrength); }
  
  /**
   * Set the {@code signalStrength} property.
   * @see #signalStrength
   */
  public void setSignalStrength(int v) { setInt(signalStrength, v, null); }

////////////////////////////////////////////////////////////////
// Property "rssi"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code rssi} property.
   * @see #getRssi
   * @see #setRssi
   */
  public static final Property rssi = newProperty(0, ((BInteger)(BInteger.DEFAULT)).getInt(), null);
  
  /**
   * Get the {@code rssi} property.
   * @see #rssi
   */
  public int getRssi() { return getInt(rssi); }
  
  /**
   * Set the {@code rssi} property.
   * @see #rssi
   */
  public void setRssi(int v) { setInt(rssi, v, null); }

////////////////////////////////////////////////////////////////
// Property "cloudConnector"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code cloudConnector} property.
   * @see #getCloudConnector
   * @see #setCloudConnector
   */
  public static final Property cloudConnector = newProperty(0, BString.DEFAULT, null);
  
  /**
   * Get the {@code cloudConnector} property.
   * @see #cloudConnector
   */
  public String getCloudConnector() { return getString(cloudConnector); }
  
  /**
   * Set the {@code cloudConnector} property.
   * @see #cloudConnector
   */
  public void setCloudConnector(String v) { setString(cloudConnector, v, null); }

////////////////////////////////////////////////////////////////
// Property "transmissionMode"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code transmissionMode} property.
   * @see #getTransmissionMode
   * @see #setTransmissionMode
   */
  public static final Property transmissionMode = newProperty(0, BString.DEFAULT, null);
  
  /**
   * Get the {@code transmissionMode} property.
   * @see #transmissionMode
   */
  public String getTransmissionMode() { return getString(transmissionMode); }
  
  /**
   * Set the {@code transmissionMode} property.
   * @see #transmissionMode
   */
  public void setTransmissionMode(String v) { setString(transmissionMode, v, null); }

////////////////////////////////////////////////////////////////
// Property "updateTime"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code updateTime} property.
   * @see #getUpdateTime
   * @see #setUpdateTime
   */
  public static final Property updateTime = newProperty(0, BString.DEFAULT, null);
  
  /**
   * Get the {@code updateTime} property.
   * @see #updateTime
   */
  public String getUpdateTime() { return getString(updateTime); }
  
  /**
   * Set the {@code updateTime} property.
   * @see #updateTime
   */
  public void setUpdateTime(String v) { setString(updateTime, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BNetworkStatus.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
}
