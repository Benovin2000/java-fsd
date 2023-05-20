package CameraRentalApp;

import java.util.*;

public class CameraMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		boolean x = true;
		// Validating login creds
		userInfo uinfo = new userInfo();
		CameraOperations co = new CameraOperations();
		cameraDetails cd = null;
		co.defaultCameras();
		System.out.println("+-------------------------------+");
		System.out.println("| Welcome to camera rental app	|");
		System.out.println("+-------------------------------+");
		System.out.println("Please login to continue");
		System.out.println("Username - ");
		String username = sc.next();
		System.out.println("Password -");
		String password = sc.next();
		uinfo.checkUser(username, password);
		// Main menu
		while (x) {
			//x = false;
			System.out.println("1. My Camera " + "\n" + "2. Rent a camera " + "\n" + "3. View all cameras " + "\n"
					+ "4. My wallet " + "\n" + "5. Exit ");
			choice = sc.nextInt();
			// sub menu
			switch (choice) {
			case 1:
				//Adding Cameras
				System.out.println("1. Add " + "\n" + "2. Remove " + "\n" + "3. View My Cameras " + "\n"
						+ "4. Go to previous menu "); {
				int choice1 = sc.nextInt();
				switch (choice1) {
				case 1:

					System.out.println("Enter the camera id - ");
					int id = sc.nextInt();
					System.out.println("Enter the camera brand - ");
					String brand = sc.next();
					System.out.println("Enter the camera model - ");
					String model = sc.next();
					System.out.println("Enter the camera rent - ");
					double rent = sc.nextDouble();
					String status = "Available";
					cd = new cameraDetails(id, brand, model, rent, status);
					co.addCameras(cd);
					System.out.println("Your camera has been successfully added to the list");
					break;
				case 2:
					//Removing a Camera
					System.out.println("Camera Id" + "\t" + "Brand" + "\t" + "\t" + "Model" + "\t" + "\t" + "Price(Per Day)" + "\t" + "Status");
					System.out.println();
					viewAllCameras(co);
					System.out.println();
					System.out.println("Enter the Camera ID to remove");
					int id1 = sc.nextInt();
					boolean b  = co.removeCamera(id1);
					if (b == true)
					{
						System.out.println("Camera Successfully Removed from list");
					}
					else {
						System.out.println("Camera not found");
					}
					break;
				case 3:
					// Viewing Cameras
					System.out.println("Camera Id" + "\t" + "Brand" + "\t" + "\t" + "Model" + "\t" + "\t" + "Price(Per Day)" + "\t" + "Status");
					System.out.println();
					viewAllCameras(co);
					break;
				case 4:
					// Back to Previous menu
					x = true;
					break;
				}
			}
				break;

			case 2:
				// Rent a Camera
				System.out.println("Following is the list of available Cameras -");
				System.out.println();
				System.out.println("Camera Id" + "\t" + "Brand" + "\t" + "\t" + "Model" + "\t" + "\t" + "Price(Per Day)" + "\t" + "Status");
				System.out.println();
				viewAllCameras(co);
				System.out.println("Enter the camera ID you want to rent - ");
				int id = sc.nextInt();
				if (addToRentedCamera(id, co, uinfo))
				{
				List<cameraDetails> c_all = uinfo.viewMyCameras();
				Collections.sort(c_all);
				for (cameraDetails cds : c_all) {
					System.out.println(cds.getCamId() + "\t" + cds.getBrand() + "\t" + cds.getModel() + "\t" + cds.getRent()
							+ "\t" + cds.getStatus());
				}
				}
				break;
			case 3: 
				// Viewing all Cameras
			{
				System.out.println();
				System.out.println("Camera Id" + "\t" + "Brand" + "\t" + "\t" + "Model" + "\t" + "\t" + "Price(Per Day)" + "\t" + "Status");
				System.out.println();
				viewAllCameras(co);
				System.out.println();
				break;
			}
				
				
			case 4: 
				// My Wallet 
			{
				System.out.println("Your current wallet balance is - INR. " + uinfo.getWalletamt());
				System.out.println("Do you want to Deposit more amount into your wallet? (1.YES 2.NO) - ");
				choice = sc.nextInt();
				if (choice == 1) {
					System.out.println("Enter the amount (INR) - ");
					uinfo.setWalletamt(sc.nextDouble());
					System.out.println("You wallet balance updated sucessfully. Current wallet balance - INR. "
							+ uinfo.getWalletamt());
				}

				break;
			}
			case 5:
				// Exit Program
				System.out.println("Thank you. Exititng the App....");
				System.exit(0);
				break;
			}
		}

	}
	// Method for viewing Cameras
	public static void viewAllCameras(CameraOperations co)
	{
	List<cameraDetails> c_all = co.viewAllCameras();
	Collections.sort(c_all);
	for (cameraDetails cds : c_all) {
		System.out.println(cds.getCamId() + "\t" + "\t" + cds.getBrand() + "\t" + "\t" + cds.getModel() + "\t" + "\t" + cds.getRent()
				+ "\t" + "\t" + cds.getStatus());
	}
	}
	// Method for Renting Cameras
	public static boolean addToRentedCamera(int camId, CameraOperations co, userInfo uinfo)
	{
		List<cameraDetails> c_all = co.viewAllCameras();
		List<cameraDetails> temp  = new ArrayList<cameraDetails>();
		boolean b = false;
		for (cameraDetails cds : c_all)
		{
			if(cds.getCamId()==camId)
			{
				if(cds.getRent() <= uinfo.getWalletamt())
				{
					uinfo.setWalletamt(- cds.getRent());
					cds.setStatus("Rented");
					temp.add(cds);
					uinfo.setMyCameras(temp);
					temp.remove(cds);
				
				System.out.println("Your transaction for camera - " + cds.getBrand() + "	" + cds.getModel() + " with rent INR. " + cds.getRent() + " has been added successfully");
				
				b = true;
				break;
				}
				else {
					System.err.println("Error : Transaction failed due to Insufficent wallet balance. Please deposit the amount to your wallet");
				}
			}
		}
		return b;
	}

}
