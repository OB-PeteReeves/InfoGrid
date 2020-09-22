package com.optimised_buildings_ltd.InfoGrid.data;

import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType
@NiagaraProperty(name = "value", type = "BString", defaultValue = "BString.DEFAULT")
@NiagaraProperty(name = "updateTime", type = "BString", defaultValue = "BString.DEFAULT")

public class BReading extends BComponent {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.optimised_buildings_ltd.InfoGrid.data.BReading(2950717538)1.0$ @*/
/* Generated Fri Jul 24 14:11:23 BST 2020 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "value"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code value} property.
   * @see #getValue
   * @see #setValue
   */
  public static final Property value = newProperty(0, BString.DEFAULT, null);
  
  /**
   * Get the {@code value} property.
   * @see #value
   */
  public String getValue() { return getString(value); }
  
  /**
   * Set the {@code value} property.
   * @see #value
   */
  public void setValue(String v) { setString(value, v, null); }

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
  public static final Type TYPE = Sys.loadType(BReading.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
}
