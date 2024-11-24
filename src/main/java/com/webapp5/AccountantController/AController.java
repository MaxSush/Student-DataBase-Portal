package com.webapp5.AccountantController;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp5.AccountantPayload.FeesPayload;
import com.webapp5.AccountantPayload.TotalFeesDto;
import com.webapp5.accountantEntity.FeesAmount;
import com.webapp5.accountantEntity.TotalFees;
import com.webapp5.accountantService.FeesAmountService;
import com.webapp5.accountantService.TotalFeesService;

@Controller
public class AController {

	@Autowired
	private FeesAmountService amountService;
	
	@Autowired
	private TotalFeesService feesService;
	
	@RequestMapping("/accountant-dashboard")
	public String dashBoard(@RequestParam String usn,@RequestParam String firstName,@RequestParam String lastName,@RequestParam long acRegId,@RequestParam String department,Model model) {
		model.addAttribute("usn", usn);
		model.addAttribute("firstName", firstName);
		model.addAttribute("lastName", lastName);
		model.addAttribute("acRegId", acRegId);
		model.addAttribute("department", department);
		return "accountant/accountant-dashboard";
	}
	
	@RequestMapping("/add-fees")
	public String addFees(@RequestParam String usn,@RequestParam String firstName,@RequestParam String lastName,@RequestParam long acRegId,@RequestParam String department,Model model) {
		
		model.addAttribute("usn", usn);
		model.addAttribute("firstName", firstName);
		model.addAttribute("lastName", lastName);
		model.addAttribute("acRegId", acRegId);
		model.addAttribute("department", department);
		return "accountant/add-fees";
	}
	
	@RequestMapping("/Add-Fees")
	public String Add_Fees(FeesPayload dto,@RequestParam String usn,@RequestParam String firstName,@RequestParam String lastName,@RequestParam long acRegId,@RequestParam String Acdepartment,Model model) {
		if(feesService.updateFees(dto)) {
			amountService.addFees(dto);
		}
		
		
		model.addAttribute("usn", usn);
		model.addAttribute("firstName", firstName);
		model.addAttribute("lastName", lastName);
		model.addAttribute("acRegId", acRegId);
		model.addAttribute("department", Acdepartment);
		model.addAttribute("Student_department", dto.getDepartment());
		model.addAttribute("date", dto.getDate());
		model.addAttribute("sem", dto.getSem());
		model.addAttribute("year", dto.getYear());
		
		
		
		return  "accountant/add-fees";
	}
	
	@RequestMapping("/fees-collection")
	public String feesCollection(@RequestParam String usn,@RequestParam String firstName,@RequestParam String lastName,@RequestParam long acRegId,@RequestParam String department,Model model) {
		
		List<TotalFees> allEntries = feesService.getAllEntries();
		
		
		model.addAttribute("allEntries", allEntries);
		model.addAttribute("usn", usn);
		model.addAttribute("firstName", firstName);
		model.addAttribute("lastName", lastName);
		model.addAttribute("acRegId", acRegId);
		model.addAttribute("department", department);
		return "accountant/fees-collections";
	}
	
	@RequestMapping("/add-students")
	public String addStudents(@RequestParam String usn,@RequestParam String firstName,@RequestParam String lastName,@RequestParam long acRegId,@RequestParam String department,Model model) {
		model.addAttribute("usn", usn);
		model.addAttribute("firstName", firstName);
		model.addAttribute("lastName", lastName);
		model.addAttribute("acRegId", acRegId);
		model.addAttribute("department", department);
		return "accountant/add-students";
	}
	@RequestMapping("/Add-students")
	public String AddStudents(TotalFeesDto dto,@RequestParam String usn,@RequestParam String firstName,@RequestParam String lastName,@RequestParam long acRegId,@RequestParam String Acdepartment,Model model) {
		feesService.addAmount(dto);
		
		model.addAttribute("usn", usn);
		model.addAttribute("firstName", firstName);
		model.addAttribute("lastName", lastName);
		model.addAttribute("acRegId", acRegId);
		model.addAttribute("department", Acdepartment);
		return "accountant/add-students";
	}
	
	@RequestMapping("/fees-add-history")
	public String fessHistory(@RequestParam String usn,@RequestParam String firstName,@RequestParam String lastName,@RequestParam long acRegId,@RequestParam String department,Model model) {
		List<FeesAmount> all = amountService.getAll();
		model.addAttribute("all", all);
		model.addAttribute("usn", usn);
		model.addAttribute("firstName", firstName);
		model.addAttribute("lastName", lastName);
		model.addAttribute("acRegId", acRegId);
		model.addAttribute("department", department);
		return "accountant/fees-add-history";
	}
	
	
	
	
}
