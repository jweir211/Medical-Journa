import java.util.Date;

public class AppointmentNode {
	
	public int appID;
	public Date date;
	public double startTime;
	public double endTime;
	public String treatment;
	public AppointmentNode left;
	public AppointmentNode right;
	public AppointmentNode previous;
	
	public AppointmentNode(int appID, Date date, double startTime, double endTime, String treatment) {
		
		this.appID = 0;
		this.date = null;
		this.startTime = 0;
		this.endTime = 0;
		this.treatment = null;
		
	}

	public int getAppID() {
		return appID;
	}

	public void setAppID(int appID) {
		this.appID = appID;
	}

	public AppointmentNode getLeft() {
		return left;
	}

	public void setLeft(AppointmentNode left) {
		this.left = left;
	}

	public AppointmentNode getRight() {
		return right;
	}

	public void setRight(AppointmentNode right) {
		this.right = right;
	}

	public AppointmentNode getPrevious() {
		return previous;
	}

	public void setPrevious(AppointmentNode previous) {
		this.previous = previous;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public double getStartTime() {
		return startTime;
	}

	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}

	public double getEndTime() {
		return endTime;
	}

	public void setEndTime(double endTime) {
		this.endTime = endTime;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	
	
}
