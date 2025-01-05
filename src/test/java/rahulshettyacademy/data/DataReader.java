package rahulshettyacademy.data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	
	public List<HashMap<String, String>> getjsondata(String Filepath) throws IOException {   //json to hashmap ga convert
		//read json to string
		@SuppressWarnings("deprecation")
		String jsoncontent =FileUtils.readFileToString(new File(Filepath));
		
		ObjectMapper mapper= new ObjectMapper();
		List<HashMap<String, String>>	data= mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String, String>>>(){});
		return data;
	}

}
