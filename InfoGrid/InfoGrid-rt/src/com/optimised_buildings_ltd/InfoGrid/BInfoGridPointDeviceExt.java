package com.optimised_buildings_ltd.InfoGrid;

import javax.baja.driver.point.BPointDeviceExt;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType

public class BInfoGridPointDeviceExt extends BPointDeviceExt {

    public Type getDeviceType(){
        return BInfoGridDevice.TYPE;
    }

    public Type getProxyExtType(){
        return BInfoGridProxyExt.TYPE;
    }

    public Type getPointFolderType(){
        return BInfoGridPointFolder.TYPE;
    }


/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.optimised_buildings_ltd.InfoGrid.BInfoGridPointDeviceExt(2979906276)1.0$ @*/
/* Generated Fri Jul 24 13:49:11 BST 2020 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BInfoGridPointDeviceExt.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
}
