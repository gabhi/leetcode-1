// 数据结构设计, 存储不考虑 无限大，确保get --> O(1), query --> O(1)
// 栗子：
// Car registry
// (Toyota, Prius, Blue, VIN) 现在要实现add和get操作。
// Follow up:
// query (Toyota, Null, Blue, Null), should return all Toyota and Blue cars' VIN
// query (null, Prius, null, null), should return all Prius cars' VIN 

import java.util.*;
class CarRegistry {
	Map<String, List<String>> map = new HashMap<>();
	
	public void add(String brand, String model, String color, String vin) {
		String [] keys = {brand, model, color, brand + model, brand + color, model + color,  brand + model + color};
		for(String k : keys) {
			if(!map.containsKey(k)) {
				map.put(k, new ArrayList<String>());
			}
			map.get(k).add(vin);
		}
	}

	public List<String> query(String brand, String model, String color, String vin) {
		String key = token(brand) + token(model) + token(color) + token(vin);
		return map.get(key);
	}

	public String token(String k) {
		return k == null ? "" : k;
	}

	public static void main(String[] args) {
		CarRegistry carRegistry = new CarRegistry();
		carRegistry.add("Toyota", "Prius", "Blue", "123");
		carRegistry.add("Toyota", "Prius2", "Blue", "124");
		carRegistry.add("Toyota", "Prius3", "Black", "125");
		carRegistry.add("Toyota", "Prius", "Red", "126");
		carRegistry.add("Porsche", "Cayenne", "Blue", "321");
		// System.out.println(carRegistry.query("Toyota", null, "Blue", null));
		System.out.println(carRegistry.query (null, null, "Blue", null));
	}
}