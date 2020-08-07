package net.javaguides.springboot.springbootcrudrestfulwebservices.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Shuttle")
public class Shuttledetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long booking_id;

	private String depttime;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate deptdate;	
	

	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate startdate;	
	
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate enddate;	
	
	private String tourtype;
	private String boarding_place;
	private String  return_boarding;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate retdate;	
	
	private String rettime;
	private long emp_id;		
	private String emp_name;		
	private String bookingtype;		
	private String booking_for;		
	private String remark;	
	
	private String company;
	private String emailId;
	private String mobile;
	
	//private String emp_loc;
	private String emp_sector;
	
	private String emergencyNo;
	
	
	
	
	//constructor
	public Shuttledetails( LocalDate startdate, LocalDate enddate) {
		this.startdate=startdate;
		this.enddate= enddate;
	}
	public Shuttledetails() {}
	public Shuttledetails(long sid, long booking_id, String tourtype, String boarding_place, String depttime, LocalDate deptdate,
			 long emp_id, String emp_name,String bookingtype, String booking_for, String remark, String status, LocalDate booking_date,
			 String company , String emailId, String mobile, String emp_band,String  emp_loc , String Username, String Password
			 , String emergencyNo, String rettime, LocalDate retdate,  String  return_boarding, long srNo) {
		super();
		
		this.booking_id = booking_id;
		this.tourtype = tourtype;
		this.boarding_place = boarding_place;
		this.depttime = depttime;
		
		this.deptdate = deptdate;
		this.emp_id = emp_id;
		this.emailId= emailId;
		this.mobile= mobile;
		this.company= company;		
		this.emp_name = emp_name;
		//this.employee = new Employee(company,emp_id);
		this.bookingtype = bookingtype;
		this.booking_for = booking_for;
		this.remark = remark;		
		this.emergencyNo= emergencyNo;
		this.retdate = retdate;
		this.rettime = rettime;
		this.return_boarding=return_boarding;
	
		
	}
	
	
	public String getReturn_boarding() {
		return return_boarding;
	}
	public void setReturn_boarding(String return_boarding) {
		this.return_boarding = return_boarding;
	}
	public LocalDate getRetdate() {
		return retdate;
	}
	public void setRetdate(LocalDate retdate) {
		this.retdate = retdate;
	}
	public String getRettime() {
		return rettime;
	}
	public void setRettime(String rettime) {
		this.rettime = rettime;
	}
	public String getEmergencyNo() {
		return emergencyNo;
	}
	public void setEmergencyNo(String emergencyNo) {
		this.emergencyNo = emergencyNo;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	
	public String getEmp_sector() {
		return emp_sector;
	}
	public void setEmp_sector(String emp_sector) {
		this.emp_sector = emp_sector;
	}
	
	public String getDepttime() {
		return depttime;
	}

	public void setDepttime(String depttime) {
		this.depttime = depttime;
	}

	public LocalDate getDeptdate() {
		return deptdate;
	}

	public void setDeptdate(LocalDate deptdate) {
		this.deptdate = deptdate;
	}

	public LocalDate getStartdate() {
		return startdate;
	}

	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}

	public LocalDate getEnddate() {
		return enddate;
	}

	public void setEnddate(LocalDate enddate) {
		this.enddate = enddate;
	}
    public long getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(long booking_id) {
		this.booking_id = booking_id;
	}
	public String getTourtype() {
		return tourtype;
	}
	public void setTourtype(String tourtype) {
		this.tourtype = tourtype;
	}
	public String getBoarding_place() {
		return boarding_place;
	}
	public void setBoarding_place(String boarding_place) {
		this.boarding_place = boarding_place;
	}
	
	public long getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(long emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	
	public String getBookingtype() {
		return bookingtype;
	}
	public void setBookingtype(String bookingtype) {
		this.bookingtype = bookingtype;
	}
	public String getBooking_for() {
		return booking_for;
	}
	public void setBooking_for(String booking_for) {
		this.booking_for = booking_for;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

/*

	@Override
	 public String toString() {
	        return "Booking [ booking_id=" + booking_id + ", tourtype=" + tourtype + ", boarding_place=" + boarding_place +
	        ",depttime=" + depttime +", deptdate=" + deptdate + ",emp_id=" + emp_id + ",emp_name=" + emp_name+ 
	        ",booking_type=" + booking_type + ",booking_for=" + booking_for + ",remark=" + remark+ ", status=" + status + ", "
	        		+ "booking_date=" + booking_date + 
	        ", cancel_date=" + cancel_date + "employee="+ employee +"]";
	    }
	

*/


}
