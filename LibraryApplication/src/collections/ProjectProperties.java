package collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ProjectProperties<K,V> {

	private Map<K,V> props;
	
	public ProjectProperties(){
		props=new HashMap<K,V>();
	}
	
	public void setProperty(K key,V value){
		props.put(key, value);
	}
	
	public V getProperty(K key){
		return props.get(key);
	}
	
	public Set<K> getAllKeys(){
		return props.keySet();
	}
	
	public Collection<V> getAllValues(){
		return props.values();
	}
	
	public Collection<Entry<K,V>> getAllPairs(){
		return props.entrySet();
	}
	
	public static void main(String[] args) {
		
		ProjectProperties<String, Object> props=new ProjectProperties<String, Object>();
		
		props.setProperty("inputFilePath: ","c:\\");
		props.setProperty("CompanyHead","Zycus infotech");
		props.setProperty("reportFooter","Contact details: 022123456");
		
		System.out.println(props.getProperty("inputFilePath: "));
		System.out.println(props.getProperty("CompanyHead"));
		
		Set<String>keys=props.getAllKeys();
		for(String key:keys){
			System.out.println(keys);
		}
	
		for(Object o:props.getAllValues()){
			System.out.println(o);
		}
		for(Entry<String, Object> entry:props.getAllPairs()){
			System.out.println("key:"+entry.getKey());
			System.out.println("Value"+entry.getValue());
		}
	}
}