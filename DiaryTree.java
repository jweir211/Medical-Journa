import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DiaryTree {
	
	public AppointmentNode root;
	public AppointmentNode head;
	private int indent = 0;
	private int lastOperation = 0;
	
	public DiaryTree() {
		root = null;
		head = null;
	}
	
	public static void main(String[] args) {
		DiaryTree run = new DiaryTree();
		
		run.runTests();
	}
	public void runTests() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			Date date3 = dateFormat.parse("01/12/2002");
			Date date1 = dateFormat.parse("01/11/2001");
			Date date2 = dateFormat.parse("01/11/2002");
			Date date4 = dateFormat.parse("30/06/2014");
			
			clearDiary(root);
			
			insertAppointment(23, date1, 13.20, 16.30, "nisejob");

			insertAppointment(43, date2, 12.15, 15.30, "nusejob");

			insertAppointment(102, date3, 11.11, 14.30, "nosejob");

			insertAppointment(773, date4, 8.15, 11.30, "nesejob");
			printDiary(root);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void insertAppointment(int appID, Date date, double startTime, double endTime, String treatment) {
		boolean duplicate = false;
		
			AppointmentNode  newNode = new AppointmentNode(appID, date, startTime, endTime, treatment);
		AppointmentNode current;
		//if root is null will just add newNode to tree
		if(root==null) {
			root=newNode;
		}
		else
		{	
			//current node will be made = to the root 
			current = root;

			while(current != null) {
				//previous node set to current node
				newNode.setPrevious(current);
				
				if(newNode.getAppID()<current.getAppID()){
					//will retrieve value of left branch if value of new id is less than current ID 
					current = current.getLeft();
				}
				else if (newNode.getAppID()>current.getAppID()) {
					current = current.getRight();
				}
				else {
					//will ensure that a duplicate value has not been entered
					duplicate = true;
					break;
				}
			}
			
			
			if(newNode.getAppID()<newNode.getPrevious().getAppID()) {
				//if the new node is less than the previous nodes id it will set the left branch to the newNode
				newNode.getPrevious().setLeft(newNode);
			}
			else if(newNode.getAppID()>newNode.getPrevious().getAppID()) {
				//same but greater than and right branch
				newNode.getPrevious().setRight(newNode);
			}
			else {
				//will ensure that a duplicate value has not been entered
				duplicate = true;
			}
		}
		
		//if there is a duplicate value entered output a message saying that that value already exists, if not a node added message will be outputted
		if(duplicate==true) {
			System.out.println("The ID you entered already exists");
		}
		else
		{
			System.out.println("new node added");
			lastOperation = 1;
			head = newNode;
		}
	}
	
	public void newTree() {
	}
	
	public void printDiary(AppointmentNode print) {
			int i;
			if (print!=null) {
				indent+=200;
				printDiary(print.getRight());
				for(i=200; i<indent;i=i+200)
					System.out.print("\t");
				System.out.println("Appointment ID: "+ print.getAppID() + " Date: "+ print.getDate() + " Start Time: "+ print.getStartTime()  + " End Time: "  + print.getEndTime() + " Treatment: " + print.getTreatment());
				printDiary(print.getLeft());
				indent-=200;

			}
	}
	
	public void findAppointment(int findID) {
		
		AppointmentNode foundNode = root;
		boolean found = false;
		
		//Loops until foundNode is empty
		while(foundNode != null && found == false){
			//Sets found to true if the current node's itemID matches the ID to find
			if(foundNode.getAppID() == findID)
			{
				found = true;
			}
			//Traverse the tree until the value is found or the value is not in the tree
			else {
				if(findID < foundNode.getAppID())
				{
					foundNode = foundNode.left;
				}
				else {
					foundNode = foundNode.right;
				}
			}
		}
		//Success messages
		if(found == true)
		{
			System.out.println("\nSuccessfully found the appointment!");
			System.out.println("Appointment Details:");
			System.out.println("Appointment ID: "+foundNode.getAppID());
			System.out.println("Doctor Name: ");
			System.out.println("Appointment Date");
		}
		//Failure message
		else {
			System.out.println("Failed to find appointment.\n");
		}
	}
	}
	
	public void deleteAppointment(AppointmentNode delete) {
		lastOperation = 2;
		head = delete;
	}
	
	public void undoLast() {
		
	}
	
	public void editNode(AppointmentNode edit) {
		lastOperation = 3;
		head = edit;
	}
	
	public AppointmentNode clearDiary(AppointmentNode clear) {
		if (clear != null) {
			clearDiary(clear.left);
			clearDiary(clear.right);	

			clear=null;
			return clear;
		}
		return null;
	}
	
	public AppointmentNode pop() {
		
    	if(head!=null) {
    		head = root.getPrevious();
    	}
    	else
    	{
    		System.out.println("Your Diary is empty");
    	}
    	return head;
    	
	}
	
	public AppointmentNode push(){
		return head;
		
	}
	
	public AppointmentNode undoEdit() {
		return head;
		
	}
}
