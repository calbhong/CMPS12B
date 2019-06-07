public class DictionaryTest{
	public static void main (String[] args){
		String v;
		Dictionary D = new Dictionary();
		//isEmpty() test
		System.out.println("Empty? " + D.isEmpty());
		//size() test
		System.out.println("Size:" + D.size());
		//insert() test
		D.insert("1","a");
		D.insert("2","b");
		D.insert("3","c");	
		//lookup & error testing 
		v = D.lookup("1");
		System.out.println("key=1 "+(v==null?"not found":("value="+v)));
		v = D.lookup("3");
		System.out.println("key=3 "+(v==null?"not found":("value="+v)));
		v = D.lookup("7");
		System.out.println("key=7 "+(v==null?"not found":("value="+v)));
		//delete() test
		D.delete("1");
		D.delete("3");
		System.out.println(D);
	}
}