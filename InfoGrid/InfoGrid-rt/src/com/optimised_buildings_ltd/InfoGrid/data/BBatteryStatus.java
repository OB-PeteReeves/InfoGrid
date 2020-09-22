package com.optimised_buildings_ltd.InfoGrid.data;

import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType
@NiagaraProperty(name = "percentage", type = "BInteger", defaultValue = "BInteger.DEFAULT")
@NiagaraProperty(name = "updateTime", type = "BString", defaultValue = "BString.DEFAULT")

public class BBatteryStatus extends BComponent {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.optimised_buildings_ltd.InfoGrid.data.BNetworkStatus(432947632)1.0$ @*/
/* Generated Fri Jul 24 14:08:47 BST 2020 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "percentage"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code percentage} property.
   * @see #getPercentage
   * @see #setPercentage
   */
  public static final Property percentage = newProperty(0, ((BInteger)(BInteger.DEFAULT)).getInt(), null);
  
  /**
   * Get the {@code percentage} property.
   * @see #percentage
   */
  public int getPercentage() { return getInt(percentage); }
  
  /**
   * Set the {@code percentage} property.
   * @see #percentage
   */
  public void setPercentage(int v) { setInt(percentage, v, null); }

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
  public static final Type TYPE = Sys.loadType(BBatteryStatus.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
}
