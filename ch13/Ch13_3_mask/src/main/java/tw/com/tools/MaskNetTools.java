package tw.com.tools;

import java.io.IOException;
import java.util.function.Consumer;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MaskNetTools {
	private final static String MASK_URL = "https://raw.githubusercontent.com/kiang/pharmacies/master/json/points.json";
	public static void downloadMaskJson(Consumer<String> callBack) {
		OkHttpClient client = new OkHttpClient().newBuilder().build();
		Request okRequest = new Request.Builder().url(MASK_URL).build();
		Call call = client.newCall(okRequest);
		call.enqueue(new Callback() {
			@Override
			public void onResponse(Call arg0, Response arg1) throws IOException {
				String result = arg1.body().string();
				
				//System.out.println(result);
				callBack.accept(result);
			}
			
			@Override
			public void onFailure(Call arg0, IOException arg1) {
					
				System.out.println("Ex:"+arg1);
			}
			
		});
	}
	
	
//	public static void main(String[] args) {
//		MaskNetTools.downloadMaskJson(null);
//	}
}
