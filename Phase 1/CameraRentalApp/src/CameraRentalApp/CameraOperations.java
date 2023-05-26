package CameraRentalApp;

import java.util.*;

public class CameraOperations {

	List<cameraDetails> camlist = new ArrayList<cameraDetails>();
	
		public void addCameras(cameraDetails cm) {
			
			
		
			camlist.add(cm);			
}
		public void defaultCameras()
		{
			cameraDetails existing0 = new cameraDetails();
			cameraDetails existing1= new cameraDetails();
			cameraDetails existing2 = new cameraDetails();
			cameraDetails existing3 = new cameraDetails();
			cameraDetails existing4 = new cameraDetails();
			cameraDetails existing5 = new cameraDetails();
			cameraDetails existing6 = new cameraDetails();
			cameraDetails existing7 = new cameraDetails();
			cameraDetails existing8 = new cameraDetails();
			cameraDetails existing9 = new cameraDetails();
			
			existing0.setCamId(1); existing0.setBrand("Samsung"); existing0.setModel("DS123"); existing0.setRent(500); existing0.setStatus("Available");
			existing1.setCamId(2); existing1.setBrand("Sony"); existing1.setModel("HD214"); existing1.setRent(500); existing1.setStatus("Available");
			existing2.setCamId(3); existing2.setBrand("Nikon"); existing2.setModel("DSLR-D7"); existing2.setRent(700); existing2.setStatus("Available");
			existing3.setCamId(4); existing3.setBrand("Canon"); existing3.setModel("XLR"); existing3.setRent(600); existing3.setStatus("Available");
			existing4.setCamId(5); existing4.setBrand("Fujitsu"); existing4.setModel("L123"); existing4.setRent(550); existing4.setStatus("Available");
			existing5.setCamId(6); existing5.setBrand("Sony"); existing5.setModel("Digital"); existing5.setRent(800); existing5.setStatus("Available");
			existing6.setCamId(7); existing6.setBrand("Samsung"); existing6.setModel("XPL"); existing6.setRent(750); existing6.setStatus("Available");
			existing7.setCamId(8); existing7.setBrand("LG"); existing7.setModel("HD226"); existing7.setRent(500); existing7.setStatus("Available");
			existing8.setCamId(9); existing8.setBrand("Canon"); existing8.setModel("J5"); existing8.setRent(1000); existing8.setStatus("Available");
			existing9.setCamId(10); existing9.setBrand("Chroma"); existing9.setModel("HDR123"); existing9.setRent(1200); existing9.setStatus("Available");
			
			camlist.add(existing0);
	 		camlist.add(existing1);
	 		camlist.add(existing2);
	 		camlist.add(existing3);
	 		camlist.add(existing4);
	 		camlist.add(existing5);
	 		camlist.add(existing6);
	 		camlist.add(existing7);
	 		camlist.add(existing8);
	 		camlist.add(existing9);
			
			
			
		}
		
		
		
		public List<cameraDetails> viewAllCameras(){
			
			return camlist;
		}
		
		public boolean removeCamera(int camId)
		{
			boolean b = false;
			for (cameraDetails cds : camlist)
			{
				if(cds.getCamId()==camId)
				{
					camlist.remove(cds);
					b = true;
					break;
				}
			}
			return b;
		}
}