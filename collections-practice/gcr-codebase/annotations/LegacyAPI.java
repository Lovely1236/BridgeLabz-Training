package annotations;

public class LegacyAPI{
	 @Deprecated
	 void oldFeature(){
		 System.out.println("Wait");
	 }
	 void newFeature(){
		 System.out.println("Your new feature");
	 }
	 public static void main(String[] args){
			LegacyAPI legacyAPI= new LegacyAPI();
			legacyAPI.oldFeature();
			legacyAPI.newFeature();
		}
}