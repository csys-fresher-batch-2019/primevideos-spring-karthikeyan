package com.chainsys.primevideos.TestUtil;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.springframework.stereotype.Component;

import com.chainsys.primevideos.dao.imp.PrimePlanDAOImpl;
import com.chainsys.primevideos.model.Plan;
import com.chainsys.primevideos.util.Logger;
@Component
public class TestExportPlan {
	static Logger logger = new Logger();
	public static void main(String[] args) throws Exception {
		PrimePlanDAOImpl imp = new PrimePlanDAOImpl();
		List<Plan> e = imp.findPlans();
		String filecontents = "";
		StringBuilder bld = new StringBuilder();
		for(Plan ae : e)
		{
			bld.append(ae.getPlanId()).append(",").append(ae.getPlanDuration());
			bld.append(",").append(ae.getPlanAmount()).append(",").append(ae.getNoOfScreens()).append(",").append(ae.getDiscountAmount());
		}
		
		 filecontents = bld.toString();
		logger.info(filecontents);
		
		Path path = Paths.get("D:\\gre.txt");
		
		Files.write(path, filecontents.getBytes(),StandardOpenOption.APPEND );
	}

}
