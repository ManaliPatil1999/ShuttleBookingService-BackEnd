package net.javaguides.springboot.springbootcrudrestfulwebservices.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="Employee")
public class Employee{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	private String emp_name;
	private String company;
	private long emp_id;
	private String emailId;
	private long mobile;
	private String emp_band;
	private String emp_loc;
	private String emp_sector;
	private String Username;
	private String Password;
	public Employee() {
		
	}
	
	public Employee( String company,long emp_id ) 
	{
		super();
		
		this.emp_id = emp_id;
		this.company = company;
		
	}
	public long getId() 
	{
		return id;
	}
	public void setId(long id) 
	{
		this.id = id;
	}
    public String getEmp_name() 
    {
		return emp_name;
	}
	public void setEmp_name(String emp_name) 
	{
		this.emp_name = emp_name;
	}
	public String getCompany() 
	{
		return company;
	}
	public void setCompany(String company) 
	{
		this.company = company;
	}
	public long getEmp_id() 
	{
		return emp_id;
	}
	public void setEmp_id(long emp_id) 
	{
		this.emp_id = emp_id;
	}
	public String getEmailId() 
	{
		return emailId;
	}
	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}
	public long getMobile() 
	{
		return mobile;
	}
	public void setMobile(long mobile) 
	{
		this.mobile = mobile;
	}
	public String getEmp_band() 
	{
		return emp_band;
	}
	public void setEmp_band(String emp_band) 
	{
		this.emp_band = emp_band;
	}
	public String getEmp_loc() 
	{
		return emp_loc;
	}
	public void setEmp_loc(String emp_loc) 
	{
		this.emp_loc = emp_loc;
	}
	public String getEmp_sector() 
	{
		return emp_sector;
	}
	public void setEmp_sector(String emp_sector) 
	{
		this.emp_sector = emp_sector;
	}
	public String getUsername() 
	{
		return Username;
	}
	public void setUsername(String username) 
	{
		Username = username;
	}
	public String getPassword() 
	{
		return Password;
	}
	public void setPassword(String password) 
	{
		Password = password;
	}
	
    /*
	@OneToMany(targetEntity= Shuttledetails.class, cascade=CascadeType.ALL)
	@JoinColumn(name="id_fk", referencedColumnName = "emp_id")
	private List<Shuttledetails> shuttle;
	
	*/
	
	 @Override
	 public String toString() {
	        return "Employee [id=" + id + ", emp_name=" + emp_name + ", company=" + company + ", emp_id=" + emp_id +
	        ",emailId=" + emailId +", mobile=" + mobile + ",emp_band=" + emp_band + ",emp_loc=" + emp_loc + 
	        ",emp_sector=" + emp_sector + ",Username=" + Username + ",Password=" + Password + "]";
	    }
	


}
