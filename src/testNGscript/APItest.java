package testNGscript;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class APItest {

	
	private Response response = null;
	private String responseBody;
	private JsonPath jsonPath;
	
	
	@BeforeTest
	public void responseSet(){
		response = RestAssured.given()
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
                .header("Content-Type", "application/json;charset=UTF-8")
                .get("https://vzkoeuat.ebiz.verizon.com:7103/getCardSpec/231473");
		
		responseBody = response.getBody().asString();
		jsonPath = new JsonPath(responseBody);
	}
	
	@Test(priority = 1)
	public void cardSpec(){
		
		
		System.out.println("CARD SPECIFICATION DTO LIST -->");
		Reporter.log("CARD SPECIFICATION DTO LIST -->");
		
		String cardSpecName = jsonPath.getString("cardSpecificationDTO.name");
		String cardSpecManf = jsonPath.getString("cardSpecificationDTO.manufacturer");
		String cardSpecPartNum = jsonPath.getString("cardSpecificationDTO.partNum");
		String cardSpecCardType = jsonPath.getString("cardSpecificationDTO.cardType");
		String cardSpecDesc = jsonPath.getString("cardSpecificationDTO.description");
		String cardSpecSlots = jsonPath.getString("cardSpecificationDTO.slotsOccupied");
		String cardSpecStatus = jsonPath.getString("cardSpecificationDTO.specStatus");
		String cardSpecHeight = jsonPath.getString("cardSpecificationDTO.height");
		String cardSpecWidth = jsonPath.getString("cardSpecificationDTO.width");
		String cardSpecDepth = jsonPath.getString("cardSpecificationDTO.depth");
		String cardSpecLastModified = jsonPath.getString("cardSpecificationDTO.lastModifiedBy");
		
		
		
		
		boolean check0 = true;
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
		
		
		//List<String> cardSpecName1 = jsonPath.getList("portSpecificationDTOList.portName");
		
		if (!cardSpecName.equals("MODULE 12 PACK SM SCU ADAPT W/O PIGTAIL")) {
            check0 = false;
            System.out.println("cardSpecificationDTO Name Actual: "+cardSpecName+"  Expected: MODULE 12 PACK SM SCU ADAPT W/O PIGTAIL");
            Reporter.log("cardSpecificationDTO Name Actual: "+cardSpecName+"  Expected: MODULE 12 PACK SM SCU ADAPT W/O PIGTAIL");
		}
		
		if (!cardSpecManf.equals("ADC")) {
            check1 = false;
            System.out.println("cardSpecificationDTO Manufacturer Actual: "+cardSpecManf+"  Expected: ADC");
            Reporter.log("cardSpecificationDTO Manufacturer Actual: "+cardSpecManf+"  Expected: ADC");
		}
		
		if (!cardSpecPartNum.equals("LSX-12P")) {
            check2 = false;
            System.out.println("cardSpecificationDTO PartNum Manufacturer Actual: "+cardSpecPartNum+"  Expected: LSX-12P");
            Reporter.log("cardSpecificationDTO Name Actual: "+cardSpecName+"  Expected: MODULE 12 PACK SM SCU ADAPT W/O PIGTAIL");
		}
		
		if (!cardSpecCardType.equals("default")) {
            check3 = false;
            System.out.println("cardSpecificationDTO Card Type Actual: "+cardSpecCardType+"  Expected: default");
            Reporter.log("cardSpecificationDTO Name Actual: "+cardSpecName+"  Expected: MODULE 12 PACK SM SCU ADAPT W/O PIGTAIL");
		}
		
		if (!cardSpecDesc.equals("MODULE 12 PACK SM SCU ADAPT W/O PIGTAIL")) {
            check4 = false;
            System.out.println("cardSpecificationDTO Desciption Actual: "+cardSpecDesc+"  Expected: MODULE 12 PACK SM SCU ADAPT W/O PIGTAIL");
            Reporter.log("cardSpecificationDTO Name Actual: "+cardSpecName+"  Expected: MODULE 12 PACK SM SCU ADAPT W/O PIGTAIL");
		}
		
		if (!cardSpecSlots.equals("1")) {
            check5 = false;
            System.out.println("cardSpecificationDTO Slots Actual: "+cardSpecSlots+"  Expected: 1");
            Reporter.log("cardSpecificationDTO Name Actual: "+cardSpecName+"  Expected: MODULE 12 PACK SM SCU ADAPT W/O PIGTAIL");
		}
		
		if (!cardSpecStatus.equals("AVAILABLE")) {
            check6 = false;
            System.out.println("cardSpecificationDTO Status Actual: "+cardSpecStatus+"  Expected: AVAILABLE");
            Reporter.log("cardSpecificationDTO Name Actual: "+cardSpecName+"  Expected: MODULE 12 PACK SM SCU ADAPT W/O PIGTAIL");
		}
		
		if (!cardSpecHeight.equals("8")) {
            check7 = false;
            System.out.println("cardSpecificationDTO Height Actual: "+cardSpecHeight+"  Expected: 8");
            Reporter.log("cardSpecificationDTO Name Actual: "+cardSpecName+"  Expected: MODULE 12 PACK SM SCU ADAPT W/O PIGTAIL");
		}
		
		if (!cardSpecWidth.equals("1.3")) {
            check8 = false;
            System.out.println("cardSpecificationDTO Width Actual: "+cardSpecWidth+"  Expected: 1.3");
            Reporter.log("cardSpecificationDTO Name Actual: "+cardSpecName+"  Expected: MODULE 12 PACK SM SCU ADAPT W/O PIGTAIL");
		}
		
		if (!cardSpecDepth.equals("1.5")) {
            check9 = false;
            System.out.println("cardSpecificationDTO Depth Actual: "+cardSpecDepth+"  Expected: 1.5");
            Reporter.log("cardSpecificationDTO Name Actual: "+cardSpecName+"  Expected: MODULE 12 PACK SM SCU ADAPT W/O PIGTAIL");
		}
		
		if (!cardSpecLastModified.equals("ICOE")) {
            check10 = false;
            System.out.println("cardSpecificationDTO Last Modified Actual: "+cardSpecLastModified+"  Expected: ICOE");
            Reporter.log("cardSpecificationDTO Name Actual: "+cardSpecName+"  Expected: MODULE 12 PACK SM SCU ADAPT W/O PIGTAIL");
		}
		
		
		System.out.println("==========================================================================================");
		
		
		
		boolean res = true;
		if(check0 == false || check1 == false || check2 == false || check3 == false || check4 == false || check5 == false || 
				check6 == false || check7 == false || check8 == false || check9 == false || check10 == false){
			res = false;
		}
		
		//System.out.println(check1+"  check res "+res);
		
	
		
		Assert.assertEquals(res, true);
		
		
		
		
		
	}
	
	
	
	@Test(priority = 2)
	public void portSpec(){
		
		boolean[] check = new boolean[168];
		Arrays.fill(check, true);
		int j=0;
		
		
		
		System.out.println("==========================================================================================");
		Reporter.log("==========================================================================================");
		
		List<String> portSpecificationDTOListPortName = jsonPath.getList("portSpecificationDTOList.portName");
		List<String> portSpecificationDTOListPortType = jsonPath.getList("portSpecificationDTOList.portType");
		List<String> portSpecificationDTOListTpType = jsonPath.getList("portSpecificationDTOList.tpType");
		List<String> portSpecificationDTOListConnectorType = jsonPath.getList("portSpecificationDTOList.connectorType");
		List<String> portSpecificationDTOListBandWidth = jsonPath.getList("portSpecificationDTOList.bandwidth");
		List<String> portSpecificationDTOListCardPartNumber = jsonPath.getList("portSpecificationDTOList.cardPartNumber");
		List<String> portSpecificationDTOListDirection = jsonPath.getList("portSpecificationDTOList.direction");
		
		System.out.println("PORT SPECIFICATION DTO LIST -->");
		Reporter.log("PORT SPECIFICATION DTO LIST -->");
		
		for(int i=0;i<24;i++){
		
			System.out.println("Response "+(i+1)+" Mismatch details:");
			Reporter.log("Response "+(i+1)+" Mismatch details:");
			if(i%2==0){
			if (!portSpecificationDTOListPortName.get(i).equals((i/2+1)+"-FRONT")) {
	            check[j] = false; j++;
	            System.out.println("portSpecificationDTOListPortName Actual: "+portSpecificationDTOListPortName.get(i)+"  Expected: "+(i/2+1)+"-FRONT");
	            Reporter.log("portSpecificationDTOListPortName Actual: "+portSpecificationDTOListPortName.get(i)+"  Expected: "+(i/2+1)+"-FRONT");
			}
			}else{
				if (!portSpecificationDTOListPortName.get(i).equals((i/2+1)+"-BACK")) {
		            check[j] = false; j++;
		            System.out.println("portSpecificationDTOListPortName Actual: "+portSpecificationDTOListPortName.get(i)+"  Expected: "+(i/2+1)+"-BACK");
		            Reporter.log("portSpecificationDTOListPortName Actual: "+portSpecificationDTOListPortName.get(i)+"  Expected: "+(i/2+1)+"-BACK");
				}
			}
			
			if (!portSpecificationDTOListPortType.get(i).equals("MPO FIBE")) {
				check[j] = false; j++;
	            System.out.println("portSpecificationDTOListPortType Actual: "+portSpecificationDTOListPortType.get(i)+"  Expected: MPO FIBE");
	            Reporter.log("portSpecificationDTOListPortType Actual: "+portSpecificationDTOListPortType.get(i)+"  Expected: MPO FIBE");
			}
			
			if (!portSpecificationDTOListTpType.get(i).equals("Physical")) {
				check[j] = false; j++;
	            System.out.println("portSpecificationDTOListTpType Actual: "+portSpecificationDTOListTpType.get(i)+"  Expected: Physical");
	            Reporter.log("portSpecificationDTOListTpType Actual: "+portSpecificationDTOListTpType.get(i)+"  Expected: Physical");
			}
			
			if (!portSpecificationDTOListConnectorType.get(i).equals("SC")) {
				check[j] = false; j++;
	            System.out.println("portSpecificationDTOListConnectorType Actual: "+portSpecificationDTOListConnectorType.get(i)+"  Expected: SC");
	            Reporter.log("portSpecificationDTOListConnectorType Actual: "+portSpecificationDTOListConnectorType.get(i)+"  Expected: SC");
			}
			
			if (!portSpecificationDTOListBandWidth.get(i).equals("OPTIC")) {
				check[j] = false; j++;
	            System.out.println("portSpecificationDTOListBandWidth Actual: "+portSpecificationDTOListBandWidth.get(i)+"  Expected: OPTIC");
	            Reporter.log("portSpecificationDTOListBandWidth Actual: "+portSpecificationDTOListBandWidth.get(i)+"  Expected: OPTIC");
			}
			
			if (!portSpecificationDTOListCardPartNumber.get(i).equals("LSX-12P7")) {
				check[j] = false; j++;
	            System.out.println("portSpecificationDTOListCardPartNumber Actual: "+portSpecificationDTOListCardPartNumber.get(i)+"  Expected: LSX-12P7");
	            Reporter.log("portSpecificationDTOListCardPartNumber Actual: "+portSpecificationDTOListCardPartNumber.get(i)+"  Expected: LSX-12P7");
			}
			
			if (!portSpecificationDTOListDirection.get(i).equals("BOTH")) {
				check[j] = false; j++;
	            System.out.println("portSpecificationDTOListDirection Actual: "+portSpecificationDTOListDirection.get(i)+"  Expected: BOTH");
	            Reporter.log("portSpecificationDTOListDirection Actual: "+portSpecificationDTOListDirection.get(i)+"  Expected: BOTH");
			}
			
			System.out.println("----------------------------------------------------------------------------------");
			Reporter.log("----------------------------------------------------------------------------------");
			
		}
		
		boolean res = true;
		
		for(boolean c: check){
			if(c==false)
				res=false;
		}
		
		Assert.assertEquals(res, true);
		
		
		
		
		
	}

}
