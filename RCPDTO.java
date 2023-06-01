package RCP;

import java.util.HashMap;

public class RCPDTO {
	
	private String rcpName;
	private String rcpView;
	private String fdName;
	private String isAllergy;
	private int calorie;
	private int time;
	private HashMap<String, String> fdMap;

    public HashMap<String, String> getFdMap() {
        return fdMap;
    }

    public void setFdMap(HashMap<String, String> fdMap) {
        this.fdMap = fdMap;
    }
	
	public RCPDTO(){
		super();
	}
	
	public RCPDTO(String rcpName, int calorie, String fdName, String isAllergy, int time,String rcpView) {
		super();
		this.rcpName = rcpName;
		this.calorie = calorie;
		this.fdName = fdName;
		this.isAllergy = isAllergy;
		this.time = time;
		this.rcpView = rcpView;
	}
	public RCPDTO(String rcpName, String fdName, int calorie) {
		super();
		this.rcpName = rcpName;
		this.calorie = calorie;
		this.fdName = fdName;

	}

	public String getRcpName() {
		return rcpName;
	}

	public void setRcpName(String rcpName) {
		this.rcpName = rcpName;
	}

	public String getRcpView() {
		return rcpView;
	}

	public void setRcpView(String rcpView) {
		this.rcpView = rcpView;
	}

	public String getFdName() {
		return fdName;
	}

	public void setFdName(String fdName) {
		this.fdName = fdName;
	}
      

	public String getIsAllergy() {
		return isAllergy;
	}

	public void setIsAllergy(String isAllergy) {
		this.isAllergy = isAllergy;
	}

	public int getCalorie() {
		return calorie;
	}

	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "RCPDTO [rcpName=" + rcpName + ", rcpView=" + rcpView + ", fdName=" + fdName + ", isAllergy=" + isAllergy
				+ ", calorie=" + calorie + ", time=" + time + "]";
	}
	
	
}
