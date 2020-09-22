package com.optimised_buildings_ltd.InfoGrid;

import javax.baja.control.BNumericPoint;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType
@NiagaraProperty(name = "proxyExt", type = "BInfoGridProxyExt", defaultValue = "new BInfoGridProxyExt()")

        public class BInfoGridNumericSensor extends BNumericPoint {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.optimised_buildings_ltd.InfoGrid.BInfoGridNumericSensor(591694974)1.0$ @*/
/* Generated Fri Jul 24 13:53:01 BST 2020 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "proxyExt"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code proxyExt} property.
   * @see #getProxyExt
   * @see #setProxyExt
   */
  public static final Property proxyExt = newProperty(0, new BInfoGridProxyExt(), null);
  
  /**
   * Get the {@code proxyExt} property.
   * @see #proxyExt
   */
  public BInfoGridProxyExt getProxyExt() { return (BInfoGridProxyExt)get(proxyExt); }
  
  /**
   * Set the {@code proxyExt} property.
   * @see #proxyExt
   */
  public void setProxyExt(BInfoGridProxyExt v) { set(proxyExt, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BInfoGridNumericSensor.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
}
