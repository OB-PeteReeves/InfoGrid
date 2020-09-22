package com.optimised_buildings_ltd.InfoGrid;

import com.tridium.json.JSONObject;

import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

@NiagaraType
@NiagaraProperty(name = "sensorId", type = "BString", defaultValue = "BString.DEFAULT")
@NiagaraAction(name = "getToken")
@NiagaraAction(name = "getSensorData", parameterType = "BString", defaultValue = "BString.DEFAULT", returnType = "BString")
@NiagaraProperty(name = "console", type = "BString", defaultValue = "BString.DEFAULT", facets = @Facet(name = "\"multiLine\"", value = "true"))



public class BInfoGridAPI extends BComponent {

  public BString doGetSensorData(BString sensorId){
    HttpURLConnection connection = null;
    try {
      URL url = new URL("https://api.infogrid.io/v1/org/98/sensors/" + sensorId + "/vendor_events");
      connection = (HttpURLConnection)url.openConnection();
      connection.setRequestMethod("GET");
      connection.setRequestProperty("Content-Type","application/json");
      connection.setRequestProperty("Accept", "*/*");
      connection.setRequestProperty("Content-Language", "en-US");
      connection.setRequestProperty("Authorization","Bearer "+((BInfoGridDevice)this.getParent()).getBearerToken());

      connection.setUseCaches(false);
      connection.setDoOutput(true);

      //Send request
      /*
      DataOutputStream wr = new DataOutputStream (
              connection.getOutputStream());
      wr.writeBytes("{\n" +
              " \"access_key\": \""+this.getAccessKey()+"\", \n" +
              " \"secret_key\": \""+this.getSecretKey()+"\"\n" +
              "}");
      wr.close();

       */

      //Get Response
      InputStream is = connection.getInputStream();
      BufferedReader rd = new BufferedReader(new InputStreamReader(is));
      StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
      String line;
      while ((line = rd.readLine()) != null) {
        response.append(line);
        response.append('\r');
      }
      rd.close();

      JSONObject responseJSON = new JSONObject(response.toString());
      //this.setBearerToken(responseJSON.getString("access"));
      this.setConsole(responseJSON.toString());

    } catch (Exception e) {
      System.out.println(e.toString());
      this.setConsole(e.toString());
    } finally {
      if (connection != null) {
        connection.disconnect();
      }
    }
    return BString.make(this.getConsole());
  }

  public void doGetToken(){
    HttpURLConnection connection = null;
    try {
      URL url = new URL("https://api.infogrid.io/v1/auth/token/");
      connection = (HttpURLConnection)url.openConnection();
      connection.setRequestMethod("POST");
      connection.setRequestProperty("Content-Type","application/json");
      connection.setRequestProperty("Accept", "*/*");
      connection.setRequestProperty("Content-Language", "en-US");

      connection.setUseCaches(false);
      connection.setDoOutput(true);

      //Send request
      DataOutputStream wr = new DataOutputStream (
              connection.getOutputStream());
      wr.writeBytes("{\n" +
              " \"access_key\": \""+((BInfoGridDevice)this.getParent()).getAccessKey()+"\", \n" +
              " \"secret_key\": \""+((BInfoGridDevice)this.getParent()).getSecretKey()+"\"\n" +
              "}");
      wr.close();

      //Get Response
      InputStream is = connection.getInputStream();
      BufferedReader rd = new BufferedReader(new InputStreamReader(is));
      StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
      String line;
      while ((line = rd.readLine()) != null) {
        response.append(line);
        response.append('\r');
      }
      rd.close();

      JSONObject responseJSON = new JSONObject(response.toString());
      ((BInfoGridDevice)this.getParent()).setBearerToken(responseJSON.getString("access"));
      this.setConsole(responseJSON.toString());

    } catch (Exception e) {
      System.out.println(e.toString());
      this.setConsole(e.toString());
    } finally {
      if (connection != null) {
        connection.disconnect();
      }
    }
  }


    public String getParamsString(Map<String, String> params)
            throws UnsupportedEncodingException {
      StringBuilder result = new StringBuilder();

      for (Map.Entry<String, String> entry : params.entrySet()) {
        result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
        result.append("=");
        result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        result.append("&");
      }

      String resultString = result.toString();
      return resultString.length() > 0
              ? resultString.substring(0, resultString.length() - 1)
              : resultString;
    }


/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.optimised_buildings_ltd.InfoGrid.BInfoGridAPI(850466179)1.0$ @*/
/* Generated Fri Jul 24 13:34:28 BST 2020 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "sensorId"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code sensorId} property.
   * @see #getSensorId
   * @see #setSensorId
   */
  public static final Property sensorId = newProperty(0, BString.DEFAULT, null);
  
  /**
   * Get the {@code sensorId} property.
   * @see #sensorId
   */
  public String getSensorId() { return getString(sensorId); }
  
  /**
   * Set the {@code sensorId} property.
   * @see #sensorId
   */
  public void setSensorId(String v) { setString(sensorId, v, null); }

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
// Action "getToken"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code getToken} action.
   * @see #getToken()
   */
  public static final Action getToken = newAction(0, null);
  
  /**
   * Invoke the {@code getToken} action.
   * @see #getToken
   */
  public void getToken() { invoke(getToken, null, null); }

////////////////////////////////////////////////////////////////
// Action "getSensorData"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code getSensorData} action.
   * @see #getSensorData(BString parameter)
   */
  public static final Action getSensorData = newAction(0, BString.DEFAULT, null);
  
  /**
   * Invoke the {@code getSensorData} action.
   * @see #getSensorData
   */
  public BString getSensorData(BString parameter) { return (BString)invoke(getSensorData, parameter, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BInfoGridAPI.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
}
