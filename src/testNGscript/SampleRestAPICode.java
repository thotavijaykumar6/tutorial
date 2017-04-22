package testNGscript;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.inject.matcher.Matcher;
 
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
 
import javax.security.auth.login.Configuration;
 
import org.hamcrest.Matchers;
//import common.RestAPIUtility;
 
//import rsa.utilities.RsaUtility;
 
public class SampleRestAPICode {
 
       private Response response = null;
       public static List shelffromCard = new ArrayList();
       public static List SHELF = new ArrayList();
      
       @Test(priority = 1)
       public void getCardInventory() {
              try {
                     Reporter.log("Sending the Retrieve Service Probe Request");
 
                     System.out.println(
                                  "TC #1 ---------------------------------------------------------------------------------------");
                     response = RestAssured.given()
                                  .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
                                  .header("Content-Type", "application/json;charset=UTF-8")
                                  .get("https://vzkoeuat.ebiz.verizon.com:7103/getEnCard/null/1243153/null/null");
                     // .get("https://vzkoeuat.ebiz.verizon.com:7103/getEnEquip/1086362/null/null/null");
 
                     String input = null;
                     System.out.println("Response Code:" + response.getStatusCode());
                    
                     String responseBody = response.getBody().asString();
                     System.out.println("Response Body:" + responseBody);
 
                     JsonPath jsonPath = new JsonPath(responseBody);
 
                     List cardId = jsonPath.getList("cardId.flatten()");
                     List subCardPartN = jsonPath.getList("subCardPartNum.flatten()");
                     List physicalShelfPosition = jsonPath.getList("physicalShelfPosition.flatten()");
                     List logicalShelf = jsonPath.getList("logicalShelf.flatten()");
                     List cardStatusName = jsonPath.getList("cardStatusName.flatten()");
                     List frame = jsonPath.getList("frame.flatten()");
                     List locationClli = jsonPath.getList("locationClli.flatten()");
                     List floor = jsonPath.getList("floor.flatten()");            
                     List logicalShel = jsonPath.getList("logicalShelf.flatten()");
                     List parentSlotName = jsonPath.getList("parentSlotName.flatten()");
                     List parentCardPartNum = jsonPath.getList("parentCardPartNum.flatten()");
                    
                     int subcardsize = 0;
                     boolean check1 = true;
                     boolean check2 = true;
                     boolean check3 = true;
                     boolean check4 = true;
                     boolean check5 = true;
                     boolean check6 = true;
                     boolean check7 = true;
                     boolean check8 = true;
                     boolean check9 = true;
                     boolean check10 = true;
                    
                     for (int i = 0; i < cardId.size(); i++) {
                           /*
                           * System.out.println("cardId: "+cardId.get(i));
                           * System.out.println("subCardPartNum: "+subCardPartNum.get(i));
                           * System.out.println("physicalShelfPosition: "
                           * +physicalShelfPosition.get(i)); System.out.println(
                           * "logical shelf: "+logicalShelf.get(i)); System.out.println(
                           * "Locatio CLLI: "+locationClli.get(i));
                           * parentSlotName
                           * parentCardPartNum
                           *Rack Alias Identifier
                            */
                    
 
                           if (!shelffromCard.contains(logicalShelf.get(i))) {
                                  shelffromCard.add(logicalShelf.get(i));
                           }
                           if (subCardPartN.get(i) != null) {
                                  subcardsize++;
                           }
 
                           if (!cardStatusName.get(i).equals("PRE_INVENTORY")) {
                                  check3 = false;
                                  System.out.println("Card status name for " + cardId.get(i) + "is not PRE_INVENTORY");
                           }
 
                           if (!frame.get(i).equals("02K.09")) {
                                  check4 = false;
                                  System.out.println("Frame " + frame.get(i) + "is not 02K.09");
                           }
 
                           if (!floor.get(i).equals("02")) {
                                  check5 = false;
                                  System.out.println("Floor for " + cardId.get(i) + "is not 02");
                           }
 
                           if (!locationClli.get(i).equals("DLLSTXJF")) {
                                  check6 = false;
                                  System.out.println("locationClli " + locationClli.get(i) + "is not DLLSTXJF");
                           }
                          
                           if (i == 0) {
                                  if (!(Integer.parseInt((String) logicalShel.get(0)) == 50)) {
                                         check8 = false;
                                         System.out.println("logicalShel position for cardid " + cardId.get(0) + " is not 50");
                                  }
                           }
                          
                           if (i == 0) {
                                  if (!(Integer.parseInt((String) physicalShelfPosition.get(0)) == 1)) {
                                         check1 = false;
                                         System.out.println("Physcal shelf position for cardid " + cardId.get(0) + " is not 1");
                                  }
                           }
                           if (i == 2) {
                                  if (!(Integer.parseInt((String) physicalShelfPosition.get(2)) == 4)) {
                                         check2 = false;
                                         System.out.println("Physical shelf position for cardid " + cardId.get(2) + " is not 4");
                                  }
                           }
                          
                           if (i == 7) {
                                  if (!(Integer.parseInt((String) parentSlotName.get(7)) == 8)) {
                                         check9 = false;
                                         System.out.println("parentSlotName for cardid " + cardId.get(7) + " is not 8");
                                  }
                           }
                          
                           if (!parentCardPartNum.get(7).equals("NTK760AA")) {
                                  check10 = false;
                                  System.out.println("parentCardPartNum " + parentCardPartNum.get(7) + "is not NTK760AA");
                           }
 
 
                     }
                     System.out.println("Total Cards :" + cardId.size());
                     System.out.println("Total Sub cards :" + subcardsize);
                     System.out.println("Value for CardiD0: " +  cardId.get(0));
                     System.out.println("Value for CardiD2: " +  cardId.get(2));
                     System.out.println("Value for CardiD7: " +  parentSlotName.get(7));
                     System.out.println("Value for C: " +  parentCardPartNum.get(7));
                     System.out.println("Value for Parent Slot Name: " +  cardId.get(7));
                     System.out.println("Check for -- Physical shelf position for cardid 20045232 is 1: " + check1);
                     System.out.println("Check for -- Physical shelf position for cardid 20045202 is 4: " + check2);
                     System.out.println("Check for -- cardStatusName as PRE_INVENTORY is: " + check3);
                     System.out.println("Check for -- Frame as 02K.09 is: " + check4);
                     System.out.println("Check for -- Floor as 02 is: " + check5);
                     System.out.println("Check for -- LocationCLLI as DLLSTXJF is: " + check6);
                     System.out.println("Check for -- logicalShel as 50 is: " + check8);
                     System.out.println("Check for -- parentSlotName as 8 is: " + check9);
                     System.out.println("Check for -- parentCardPartNum is: " + check10);
                                 
                     boolean res = false;
                     if (cardId.size() == 26 && subcardsize == 12 && check1 == true && check2 == true && check3 == true
                                  && check4 == true && check5 == true && check6 == true && check8 == true && check9 == true && check10 == true) {
                           res = true;
                     }
                     Assert.assertEquals(res, true);
              } catch (Exception e) {
                     Reporter.log("Json Request is not accepted by Rest Service" + e.getMessage());
              }
       }
 
       @Test(priority = 2)
       public void getShelfInventory() {
              try {
                     Reporter.log("Sending the Retrive Service Probe Request");
                     System.out.println(
                                  "TC #2 ---------------------------------------------------------------------------------------");
 
                     response = RestAssured.given()
                                  .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
                                  .header("Content-Type", "application/json;charset=UTF-8")
                                  .get("https://vzkoeuat.ebiz.verizon.com:7103/getEnShelf/null/1243153/null/null");
                     // .get("https://vzkoeuat.ebiz.verizon.com:7103/getEnEquip/1086362/null/null/null");
 
                     String input = null;
                     System.out.println("Response Code:" + response.getStatusCode());
 
                     String responseBody = response.getBody().asString();
                     System.out.println("Response Body:" + responseBody);
 
                     JsonPath jsonPath = new JsonPath(responseBody);
 
                     List logicalShelf = jsonPath.getList("logicalShelf.flatten()");
                     List frame = jsonPath.getList("frame.flatten()");
                     List assetOwner = jsonPath.getList("assetOwner.flatten()");
                     List floor = jsonPath.getList("floor.flatten()");
                     List physicalShelf = jsonPath.getList("physicalShelf.flatten()");
                     List targetId = jsonPath.getList("targetId.flatten()");
                     List checkPhyiscalShelf = new ArrayList();
                     List checktargetId = new ArrayList();
 
                     checkPhyiscalShelf.add("4");
                     checkPhyiscalShelf.add("1");
                     checkPhyiscalShelf.add("2");
                     checkPhyiscalShelf.add("5");
 
                     checktargetId.add("null");
                     checktargetId.add("DLLSTXJF-02000K09I");
                     checktargetId.add("DLLSTXJF-02000K09J");
                     checktargetId.add("null");
 
                     boolean check1 = true;
                     boolean check2 = true;
                     boolean check3 = true;
                     boolean check4 = true;
                     boolean check5 = true;
 
                     for (int i = 0; i < logicalShelf.size(); i++) {
                           /*
                           * System.out.println("logicalShelf: "+logicalShelf.get(i));
                           * System.out.println("frame: "+frame.get(i));
                           * System.out.println("assetOwner: "+assetOwner.get(i));
                           * System.out.println("floor: "+floor.get(i));
                           * System.out.println("physicalShelf: "+physicalShelf.get(i));
                           * System.out.println("Check physicalShelf: "
                           * +checkPhyiscalShelf.get(i)); System.out.println("targetId: "
                           * +targetId.get(i));
                           */
 
                           if (!frame.get(i).equals("02K.09")) {
                                  check1 = false;
                                  System.out.println("frame is not 02K.09 for: " + frame.get(i));
                           }
 
                           if (!floor.get(i).equals("02")) {
                                  check2 = false;
                                  System.out.println("floor is not 02 for: " + floor.get(i));
                           }
 
                           if (!assetOwner.get(i).equals("One Network Out Of Franchise")) {
                                  check3 = false;
                                  System.out.println("assetOwner is not One Network Out Of Franchise for: " + assetOwner.get(i));
                           }
 
                           if (!physicalShelf.get(i).equals(checkPhyiscalShelf.get(i))) {
                                  check4 = false;
                                  System.out.println("Physical shelf data is not correct for: " + physicalShelf.get(i));
                           }
 
                           if (targetId.get(i) != null) {
                                  if (!checktargetId.get(i).equals(targetId.get(i))) {
                                         check5 = false;
                                         System.out.println("Target ID data is not correct for: " + targetId.get(i));
                                  }
                           }
                     }
                     SHELF = logicalShelf;
                     System.out.println("Total Shelfs :" + logicalShelf.size());
                     System.out.println("Check for -- Frame as 02K.09 is: " + check1);
                     System.out.println("Check for -- Floor as 02 is: " + check2);
                     System.out.println("Check for -- AssetOwner as One Network Out Of Franchise is: " + check3);
                     System.out.println("Check for --Physical Shelf is: " + check4);
                     System.out.println("Check for -- TargetID is: " + check5);
 
                     boolean res = false;
                     if (logicalShelf.size() == 4 && check1 == true && check2 == true && check3 == true && check4 == true
                                  && check5 == true) {
                           res = true;
                     }
                     Assert.assertEquals(res, true);
              } catch (Exception e) {
                     Reporter.log("Json Request is not accepted by Rest Service" + e.getMessage());
              }
 
       }
 
       @Test(priority = 3)
       public void getShelfandCardInventory() {
              boolean check = true;
 
              Collections.sort(SHELF);
              Collections.sort(shelffromCard);
              int count1 = shelffromCard.size();
              int count2 = SHELF.size();
              if (count1 == count2) {
                     System.out.println(
                                  "TC #3 ---------------------------------------------------------------------------------------");
                     System.out.println("Shelf count from CARD and SHELF is matching");
                     for (int i = 0; i < SHELF.size(); i++) {
                           // System.out.println("SHELF: "+SHELF.get(i));
                           // System.out.println("shelffromCard: "+shelffromCard.get(i));
 
                           if (!SHELF.get(i).equals(shelffromCard.get(i))) {
                                  check = false;
                                  System.out.println("Shelf data is not correct for: " + SHELF.get(i));
                           }
                     }
              } else {
                     System.out.println("Shelf count from CARD and SHELF is not matching");
              }
              System.out.println("Check for -- Shelf data from CARD service and SHELF service is: " + check);
              Assert.assertEquals(check, true);
       }
 
       @Test(priority = 4)
       public void getPortWiringInventory() {
              try {
                     Reporter.log("Sending the Retrive Service Probe Request");
 
                     System.out.println(
                                  "TC #4 ---------------------------------------------------------------------------------------");
                     response = RestAssured.given()
                                  .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
                                  .header("Content-Type", "application/json;charset=UTF-8")
                                  .get("https://vzkoeuat.ebiz.verizon.com:7103/getEnPortWiring/null/1243153/null/null");
                     // .get("https://vzkoeuat.ebiz.verizon.com:7103/getEnEquip/1086362/null/null/null");
 
                     String input = null;
                     System.out.println("Response Code:" + response.getStatusCode());
 
                     String responseBody = response.getBody().asString();
                     System.out.println("Response Body:" + responseBody);
 
                     JsonPath jsonPath = new JsonPath(responseBody);
 
                     List fm_clli = jsonPath.getList("fm_clli.flatten()");
                     List fm_bfno = jsonPath.getList("fm_bfno.flatten()");
                     List fm_sfno = jsonPath.getList("fm_sfno.flatten()");
                     List to_bfno = jsonPath.getList("to_bfno.flatten()");
                     List fm_parentSlotName = jsonPath.getList("fm_parentSlotName.flatten()");
                     List to_clli = jsonPath.getList("to_clli.flatten()");
                     List to_sfno = jsonPath.getList("to_sfno.flatten()");
                     List to_parentSlotName = jsonPath.getList("to_parentSlotName.flatten()");
                     List fm_port = jsonPath.getList("fm_port.flatten()");
                     List to_port = jsonPath.getList("to_port.flatten()");
                     List conn_status = jsonPath.getList("conn_status.flatten()");
 
                     boolean check1 = true;
                     boolean check2 = true;
                     boolean check3 = true;
                     boolean check4 = true;
                     boolean check5 = true;
                     boolean check6 = true;
                     boolean check7 = true;
                     boolean check8 = true;
                     boolean check9 = true;
                     boolean check10 = true;
                     boolean check11 = true;
 
                     for (int i = 0; i < fm_clli.size(); i++) {
 
                           if (!fm_clli.get(i).equals("DLLSTXJF") && to_clli.get(i).equals("DLLSTXJF")) {
                                  check1 = false;
                                  System.out.println("fm_clli or to_clli for " + fm_clli.get(i) + "is not DLLSTXJF");
                           }
 
                           if (!fm_bfno.get(i).equals("02K.09") && to_bfno.get(i).equals("02K.09")) {
                                  check2 = false;
                                  System.out.println("fm_bfno or to_bfno " + fm_bfno.get(i) + "is not 02K.09");
                           }
 
                           if (i == 0 || i == 1) {
                                  if (!fm_sfno.get(i).equals("1")) {
                                         check3 = false;
                                         System.out.println("fm_sfno for " + fm_sfno.get(i) + "is not 1");
                                  }
 
                                  if (!fm_parentSlotName.get(i).equals("6")) {
                                         check4 = false;
                                         System.out.println("fm_parentSlotName for " + fm_parentSlotName.get(i) + "is not 6");
                                  }
                           }
                           if (i == 0) {
 
                                  if (!fm_port.get(i).equals("05 LINEOUT")) {
                                         check8 = false;
                                         System.out.println("fm_port for " + fm_port.get(i) + "is not 05 LINEOUT");
                                  }
 
                                  if (!to_port.get(i).equals("000001-BACK")) {
                                         check9 = false;
                                         System.out.println("to_port for " + to_port.get(i) + "is not 000001-BACK");
                                  }
                           }
 
                           if (i == 1) {
 
                                  if (!fm_port.get(i).equals("08 LINE IN")) {
                                         check10 = false;
                                         System.out.println("fm_port for " + fm_port.get(i) + "is not 08 LINE IN");
                                  }
 
                                  if (!to_port.get(i).equals("000001-FRONT")) {
                                         check11 = false;
                                         System.out.println("to_port for " + to_port.get(i) + "is not 000001-FRONT");
                                  }
                           }
 
                           if (!to_sfno.get(i).equals("4")) {
                                  check5 = false;
                                  System.out.println("to_sfno for " + to_sfno.get(i) + "is not 4");
                           }
 
                           if (!to_parentSlotName.get(i).equals("1")) {
                                  check6 = false;
                                  System.out.println("to_parentSlotName for " + to_parentSlotName.get(i) + "is not 1");
                           }
 
                           if (!conn_status.get(i).equals("ENEN")) {
                                  check7 = false;
                                  System.out.println("conn_status for " + conn_status.get(i) + "is not ENEN");
                           }
                     }
                     System.out.println("Total Port Wiring: " + fm_clli.size());
                     System.out.println("Check for -- fm_clli or to_clli as DLLSTXJF: " + check1);
                     System.out.println("Check for -- fm_bfno or to_bfno is  02K.09: " + check2);
                     System.out.println("Check for -- to_sfno as 4: " + check5);
                     System.out.println("Check for -- fm_parentSlotName as 1: " + check6);
                     System.out.println("Check for -- conn_status as ENEN: " + check7);
 
                     System.out.println("Check for -- fm_sfno as 1 for port wiring 1 and 2: " + check3);
                     System.out.println("Check for -- fm_parentSlotName as 6 for port wiring 1 and 2: " + check4);
                     System.out.println("Check for -- fm_port as 05 LINEOUT for port wiring 1 : " + check8);
                     System.out.println("Check for -- to_port as 000001-BACK for port wiring 1: " + check9);
                     System.out.println("Check for -- fm_port as 08 LINE IN for port wiring 2 : " + check10);
                     System.out.println("Check for -- to_port as 000001-FRONT for port wiring 2: " + check11);
 
                     boolean res = false;
                     if (fm_clli.size() == 16 && check1 == true && check2 == true && check5 == true && check6 == true
                                  && check7 == true && check8 == true && check9 == true) {
                           res = true;
                     }
                     Assert.assertEquals(res, true);
              } catch (Exception e) {
                     Reporter.log("Json Request is not accepted by Rest Service" + e.getMessage());
              }
 
       }
 
       @Test(priority = 5)
       public void getRackInventory() {
              try {
                     Reporter.log("Sending the Retrive Service Probe Request");
 
                     System.out.println(
                                  "TC #5 ---------------------------------------------------------------------------------------");
                     response = RestAssured.given()
                                  .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
                                  .header("Content-Type", "application/json;charset=UTF-8")
                                  .get("https://vzkoeuat.ebiz.verizon.com:7103/getEnRack/null/1243153/null/null");
 
                     String input = null;
                     System.out.println("Response Code:" + response.getStatusCode());
 
                     String responseBody = response.getBody().asString();
                     System.out.println("Response Body:" + responseBody);
 
                     JsonPath jsonPath = new JsonPath(responseBody);
 
                     List clli = jsonPath.getList("clli.flatten()");
                     List assetOwner = jsonPath.getList("assetOwner.flatten()");
                     List container = jsonPath.getList("container.flatten()");
                     List frame = jsonPath.getList("frame.flatten()");
                     List checktframe = new ArrayList();
 
                     checktframe.add("12.12");
//                   checktframe.add("011.05");
 
                     boolean check1 = true;
                     boolean check2 = true;
                     boolean check3 = true;
                     boolean check4 = true;
 
                     for (int i = 0; i < clli.size(); i++) {
 
                           if (!clli.get(i).equals("BFLONYHE")) {
                                  check1 = false;
                                  System.out.println("CLLI for " + clli.get(i) + "is not BFLONYHE");
                           }
 
                           if (!assetOwner.get(i).equals("One Network Out Of Franchise")) {
                                  check2 = false;
                                  System.out.println("assetOwner for " + assetOwner.get(i) + "is not One Network Out Of Franchise");
                           }
 
                           if (!container.get(i).equals("RACK")) {
                                  check3 = false;
                                  System.out.println("container for " + container.get(i) + "is not RACK");
                           }
 
                           if (!frame.get(i).equals(checktframe.get(i))) {
                                  check4 = false;
                                  System.out.println("frame for " + frame.get(i) + "is not matching with " + checktframe.get(i));
                           }
 
                     }
                     System.out.println("Total Racks: " + clli.size());
                     System.out.println("Check for -- CLLI as BFLONYHE: " + check1);
                     System.out.println("Check for -- AssetOwner as One Network Out Of Franchise: " + check2);
                     System.out.println("Check for -- Container as RACK: " + check3);
                     System.out.println(
                                  "Check for -- Frame for Rack #1 as 12.12" + check4);
       //                         "Check for -- Frame for Rack #1 as 12.12, Frame for Rack #2 as 011.05: "+ check4);
                     boolean res = false;
                     if (clli.size() == 3 && check1 == true && check2 == true && check3 == true && check4 == true) {
                           res = true;
                     }
                     Assert.assertEquals(res, true);
              } catch (Exception e) {
                     Reporter.log("Json Request is not accepted by Rest Service" + e.getMessage());
              }
 
       }
 
}
