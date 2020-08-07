package net.javaguides.springboot.springbootcrudrestfulwebservices.controller;

import java.time.LocalDate;


import java.util.List;


//import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.springbootcrudrestfulwebservices.exception.ResourceNotFoundException;

import net.javaguides.springboot.springbootcrudrestfulwebservices.model.Shuttledetails;
//import net.javaguides.springboot.springbootcrudrestfulwebservices.repository.EmployeeRepository;
import net.javaguides.springboot.springbootcrudrestfulwebservices.repository.ShuttleRepository;

@CrossOrigin()
@RestController
@RequestMapping("/api/v1")
public class ShuttleController {
    @Autowired
    private ShuttleRepository shuttleRepository;
 
    //generate an employee booking
    //create booking--------------------working
    @PostMapping("/bookings")
    public Shuttledetails createBooking(@RequestBody Shuttledetails shuttledetails) {
    	System.out.print("hii ");
        return shuttleRepository.save(shuttledetails);
    }
    
    //get all bookings till date
    //get all bookings-----------------------------working
    @GetMapping("/getAllUsers")
    public List<Shuttledetails> getAllbookings() {
        return shuttleRepository.findAll();
    }
    
    
   
    
    //display for cancellation
    //get by date------------------------------working
    @GetMapping("/cancel/single/{deptdate}")
    public List<Shuttledetails> getBookingsByDeptdate(
    		@PathVariable(value="deptdate") @DateTimeFormat(iso= ISO.DATE) LocalDate deptdate){
	   return shuttleRepository.findByDeptdate(deptdate);
   }
    
    //display of cancellation 
    //get by return date-----------------------working
    @GetMapping("/cancel/round/{retdate}")
    public List<Shuttledetails> getBookingsByRetdate(
    		@PathVariable(value="retdate") @DateTimeFormat(iso= ISO.DATE) LocalDate retdate){
	   return shuttleRepository.findByRetdate(retdate);
   }
    
    
    
  //monthly report one-way
    //between dates bookingtype and tourtype and company--------------------------------working
    @GetMapping("/booking/single/{bookingtype}/{tourtype}/{company}/{startdate}/{enddate}")
    public List<Shuttledetails> getBookingsByBookingtypeTourtypeCompanyAndDeptdateBetween(
    		
    		@PathVariable(value = "bookingtype") String bookingtype,
    		@PathVariable(value = "tourtype") String tourtype,
    		@PathVariable(value = "company") String company,
    		@PathVariable(value= "startdate") @DateTimeFormat(iso= ISO.DATE) LocalDate startdate,
    		@PathVariable(value= "enddate") @DateTimeFormat(iso= ISO.DATE) LocalDate enddate    		
    		){
	   return shuttleRepository.findByBookingtypeAndTourtypeAndCompanyAndDeptdateBetween(bookingtype, tourtype,
			   company, startdate, enddate);
   }
    
  //monthly report return
    //between dates bookingtype and tourtype and company--------------------------------working
    @GetMapping("/booking/round/{bookingtype}/{tourtype}/{company}/{startdate}/{enddate}")
    public List<Shuttledetails> getBookingsByBookingtypeTourtypeCompanyAndRetdateBetween(    		
    		@PathVariable(value ="bookingtype") String bookingtype,
    		@PathVariable(value ="tourtype") String tourtype,
    		@PathVariable(value ="company") String company,
    		@PathVariable(value="startdate") @DateTimeFormat(iso= ISO.DATE) LocalDate startdate,
    		@PathVariable(value="enddate") @DateTimeFormat(iso= ISO.DATE) LocalDate enddate    		
    		){
	   return shuttleRepository.findByBookingtypeAndTourtypeAndCompanyAndRetdateBetween(bookingtype, tourtype,
			   company, startdate, enddate );
   }
    
    
	//availability
    //display by date-------------------------------working
    @GetMapping("/availability/single/{deptdate}/{tourtype}/{depttime}")
    public List<Shuttledetails> getBookingsByDateAndTimeAndTourtype(
    		@PathVariable(value= "deptdate") @DateTimeFormat(iso= ISO.DATE) LocalDate deptdate,
    		@PathVariable(value = "tourtype") String tourtype,
    		@PathVariable(value= "depttime") String depttime
    		){

    	return shuttleRepository.findByDeptdateAndTourtypeAndDepttime(deptdate, tourtype, depttime);
   }
    
    //round-trip
    //display by date-------------------------------working
    @GetMapping("/availability/round/{retdate}/{tourtype}/{rettime}")
    public List<Shuttledetails> getBookingsByDateAndTimeAndTourtypeReturn(
    		@PathVariable(value= "retdate") @DateTimeFormat(iso= ISO.DATE) LocalDate retdate,    		
    		@PathVariable(value = "tourtype") String tourtype,
    		@PathVariable(value= "rettime") String rettime
    		){
	   return shuttleRepository.findByRetdateAndTourtypeAndRettime(retdate, tourtype, rettime);
   }
    
    //cancel booking
    //delete by id-----------------------------------working
    @DeleteMapping("/cancel/{booking_id}")
    public List<Shuttledetails> cancelBooking(@PathVariable(value = "booking_id") Long booking_id){
    	shuttleRepository.deleteById(booking_id);
    	return shuttleRepository.findAll();
    }
    
    
    
 
    
   
    /*
      // get by dates between-----------------------------------------working
    @GetMapping("/monthlyreport/{startdate}/{enddate}")
    public List<Shuttledetails> getBookingsByDeptdateBetween(
    		@PathVariable(value="startdate") @DateTimeFormat(pattern="yyyy-MM-dd") Date startdate,
    		@PathVariable(value="enddate") @DateTimeFormat(pattern="yyyy-MM-dd") Date enddate
    		
    		){
	   return shuttleRepository.findByDeptdateBetween(startdate, enddate );
   }
   
   
    //get booking by id
    @GetMapping("/bookings/{id}")
    public ResponseEntity<Shuttledetails> getBookingsByID(@PathVariable(value = "id") Long id)
        throws ResourceNotFoundException {
        Shuttledetails shuttle = shuttleRepository.findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Shuttle booking not found for this id : " + id));
        return ResponseEntity.ok().body(shuttle);
    }
   */
    
    //update booking----------------------------------working
    @PutMapping("/bookings/{booking_id}")
    public ResponseEntity<Shuttledetails> updateBooking(@PathVariable(value = "booking_id") Long bookingid,
          @RequestBody Shuttledetails shuttleDetails) throws ResourceNotFoundException {
        Shuttledetails shuttle = shuttleRepository.findById(bookingid)
        .orElseThrow(() -> new ResourceNotFoundException("Shuttle booking not found for this id : " + bookingid));


        shuttle.setTourtype(shuttleDetails.getTourtype());
        shuttle.setBoarding_place(shuttleDetails.getBoarding_place());
        shuttle.setDepttime(shuttleDetails.getDepttime());
        shuttle.setDeptdate(shuttleDetails.getDeptdate());        
        shuttle.setEmp_id(shuttleDetails.getEmp_id());        
        shuttle.setEmp_name(shuttleDetails.getEmp_name());        
        shuttle.setBookingtype(shuttleDetails.getBookingtype());        
        shuttle.setBooking_for(shuttleDetails.getBooking_for());        
        shuttle.setRemark(shuttleDetails.getRemark());
        
       
        shuttle.setEmailId(shuttleDetails.getEmailId());
       
        shuttle.setEnddate(shuttleDetails.getEnddate());
        shuttle.setEmp_sector(shuttleDetails.getEmp_sector());
        shuttle.setCompany(shuttleDetails.getCompany());
        shuttle.setStartdate(shuttleDetails.getStartdate());;
        
        
        final Shuttledetails updatedEmployee = shuttleRepository.save(shuttle);
        return ResponseEntity.ok(updatedEmployee);
    }
/*
    //delete booking--------------------------------working
    @DeleteMapping("/bookings/{booking_id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "booking_id") Long bookingId)
         throws ResourceNotFoundException {
        Shuttledetails shuttle = shuttleRepository.findById(bookingId)
       .orElseThrow(() -> new ResourceNotFoundException("Shuttle booking not found for this id : " + bookingId));
     
        shuttleRepository.delete(shuttle);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    */
   
}