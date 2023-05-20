package CameraRentalApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class userInfo {
	
	private String user;
	private String pass;
	private double walletamt = 1000;
	private List<cameraDetails> myCameras = new ArrayList<cameraDetails>();
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public double getWalletamt() {
		return walletamt;
	}
	public void setWalletamt(double walletamt) {
		this.walletamt = this.walletamt + walletamt ;
	}
	
	
	public List<cameraDetails> getMyCameras() {
		return myCameras;
	}
	public void setMyCameras(List<cameraDetails> myCameras) {
		this.myCameras = myCameras;
	}
	public void addAmt() {
	
}
	public void checkUser(String username, String password) {
		String User = "admin";
		String Pass = "admin123";
		if (User.equals(username) && Pass.equals(password)) {		
			System.out.println("\n" + "Login Successful" + "\n");
		}
		else {
			System.err.println("Invaild Credtials");
			System.exit(0);
		}
		
	}
	
	public List<cameraDetails> viewMyCameras(){
		
		return myCameras;
	}
	
}
