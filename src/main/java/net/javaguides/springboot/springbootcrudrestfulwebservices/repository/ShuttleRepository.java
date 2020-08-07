package net.javaguides.springboot.springbootcrudrestfulwebservices.repository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.javaguides.springboot.springbootcrudrestfulwebservices.model.Shuttledetails;

@Repository
public interface ShuttleRepository extends JpaRepository<Shuttledetails, Long>{

	public List<Shuttledetails> findByDeptdateBetween(LocalDate startdate, LocalDate enddate);
		
	public List<Shuttledetails> findByBookingtypeAndTourtypeAndCompanyAndDeptdateBetween
	(String bookingtype, String tourtype, String company, LocalDate startdate, LocalDate enddate);
	
	public List<Shuttledetails> findByDeptdateAndTourtypeAndDepttime(LocalDate deptdate,   String tourtype, String depttime);
	
	public List<Shuttledetails> findByRetdateAndTourtypeAndRettime(LocalDate retdate,   String tourtype, String rettime);
	
	public List<Shuttledetails> findByDeptdate(LocalDate deptdate);
	
	public List<Shuttledetails> findByRetdate(LocalDate retdate);
	
	public List<Shuttledetails> findByBookingtypeAndTourtypeAndCompanyAndRetdateBetween
	(String bookingtype, String tourtype, String company, LocalDate startdate, LocalDate enddate);
	
	
	
	
	
	
	//public List<Shuttledetails> findByRetdateAndRettimeAndTourtype(Date retdate,   String tourtype, String rettime);

	/*
	//@Query(value="SELECT * FROM Shuttledetails s WHERE s.deptdate BETWEEN ?1 AND ?2" + 
	//("SELECT s FROM Shuttledetails s WHERE  s.bookingtype = :bookingtype AND s.tourtupe = :tourtype AND s.company = :company"))
	List<Shuttledetails> findByBookingtypeAndTourtypeAndCompanyAndDeptdateBetween(
			@Param("startdate") @DateTimeFormat(pattern="yyyy-MM-dd") Date startdate, 
			@Param("enddate")  @DateTimeFormat(pattern="yyyy-MM-dd") Date enddate, 
			@Param("bookingtype") String bookingtype, 
			@Param("tourtype") String tourtype,
			@Param("company") String company  
			);
	
	*/
}
