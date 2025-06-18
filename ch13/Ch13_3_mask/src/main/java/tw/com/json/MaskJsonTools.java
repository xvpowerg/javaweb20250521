package tw.com.json;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.com.beans.Mask;
import tw.com.tools.MaskNetTools;

public class MaskJsonTools {
	public static void maskJsonToObj(String maskJson,Consumer<List<Mask>> callBack) throws JsonMappingException, JsonProcessingException  {
		ObjectMapper objMapeer = new ObjectMapper();
		Map<String,Object> featuresMap =  objMapeer.readValue(maskJson, Map.class);
		List<Map<String,Object>>  features = (List)featuresMap.get("features");
		List<Mask> listMask = new ArrayList();
		for( Map<String,Object>  dataMap :features) {
			Map<String,Object> pMap = (Map) dataMap.get("properties");
			Mask mask = new Mask();
			mask.setId(pMap.get("id").toString());
			mask.setName(pMap.get("name").toString());
			mask.setMaskAdult(pMap.get("mask_adult").toString());
			mask.setMaskChild(pMap.get("mask_child").toString());
			listMask.add(mask);
		}
		//System.out.println(listMask);
		callBack.accept(listMask);
	}
	
	public static void main(String[] args) {
		
		MaskNetTools.downloadMaskJson(json->{
	
							try {
								MaskJsonTools.maskJsonToObj(json, null);
							} catch (JsonMappingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (JsonProcessingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			
		
			
			
		});
		
	}
}
