package com.chainsys.primevideos.method;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Plan {
	private int planId;
	private int planAmount; 
	private int planDuration; 
	private int noOfScreens;
	private int discountAmount=0;


	public String toString() {
		return "\nPlanId=" + planId + "| PlanAmount=" + planAmount + "| PlanDuration=" + planDuration
				+ "| NoOfScreens=" + noOfScreens + "| DiscountAmount=" + discountAmount+"\n-------------------------------------------------------------------------------------" ;
	}
}