package RestAssuredProject.RestAssuredProject;

import org.testng.annotations.DataProvider;

public class DataForTests {

	@DataProvider(name="TestData")
	public Object[][] dataForPost(){
//		Object[][] data = new Object[2][3];
//		data[0][0] ="Albert";
//		data[0][1] ="Einstein";
//		data[0][2] =2;
//		
//		data[1][0] ="Thomas";
//		data[1][1] ="Edision";
//		data[1][2] =1;
//		return data;
		
		return new Object[][] {
			{"Graham" , "Bell", 1},
			{"Nicolas", "Tesla", 2}
		};
		
	}
	
	

	@DataProvider( name="dataToDelete")
	public Object[] dataForDelete() {
		return new Object[] {
			15,16	
		};
	}
	
}
