package parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class XMLParser {
	private String input;
	private String name;
	private Map<String,String> map = new HashMap<>();
	public XMLParser(String input){
		this.input=input;
		parse();
//		show();
	}
	public XMLParser(){

	}
	private void parse() {
		map.clear();
		int i = 0;
		while(i<input.length()&&input.charAt(i++)!='{');
		name = new String(input.toCharArray(),0,i-1);
		if(i==input.length()) {
			name = input;
			return;
		}
		input = input.replaceFirst(name, "");
		input = input.replaceFirst("\\{","");
		input = input.replaceFirst("\\}","");
		String[] temp = input.split(",");
		if(temp.length!=0) {
			for(String str:temp) {
				if(str.length()!=0) {
					int k = 0;
					str =str.replaceAll("'", "");
					while(str.charAt(k++)!=':');
					map.put(new String(str.toCharArray(),0,k-1),new String(str.toCharArray(),k,str.length()-k));
				}
				
			}
		}
		
		
	}
	private void show() {
		for(String key :map.keySet()) {
			System.out.println(key+" : "+map.get(key));
		}
	}
	public String get(String str) {
		if(map.containsKey(str)) {
			return map.get(str);
		}
		return null;
	}
	public void setInput(String input) {
		this.input = input;
		parse();
	}
	public String getName() {
		return name;
	}
}
