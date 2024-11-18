package com.vti.frontend;

import java.util.List;

import com.vti.entity.Group;
import com.vti.entity.GroupAccount;
import com.vti.repository.GroupRepository;

public class GroupProgram {
	public static void main(String[] args) {
		GroupRepository repository = new GroupRepository();

//		System.out.println("\n\n***********CREATE GROUP***********");
//		
//		Group groupCre = new Group();
//		groupCre.setGroupName("group test 1");
//		repository.createGroup(groupCre);

		System.out.println("***********GET ALL GROUP***********");

		List<Group> groups = repository.getAllGroups();

		for (Group group : groups) {
			System.out.println("Group name: " + group.getGroupName());
			System.out.println("Creator: " + group.getAccount().getFullName());
			System.out.println("Member: ");
			for(GroupAccount grAc : group.getGroupAccounts()) {
				System.out.println(grAc.getAccount().getFullName());
			}
			System.out.println();
		}

	}
}
