package com.optimised_buildings_ltd.InfoGrid;

import com.tridium.ndriver.BNNetwork;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType


public class BInfoGridNetwork extends BNNetwork {

    public Type getDeviceType(){return BInfoGridDevice.TYPE;}

    public Type getDeviceFolderType() {return BInfoGridDeviceFolder.TYPE;}

    public String getNetworkName(){return this.getName();}


/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.optimised_buildings_ltd.InfoGrid.BInfoGridNetwork(2979906276)1.0$ @*/
/* Generated Fri Jul 24 13:21:27 BST 2020 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BInfoGridNetwork.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
}
