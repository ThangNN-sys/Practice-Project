package com.vti;

import com.vti.entity.Group;
import com.vti.repository.GroupRepository;

import java.util.List;

public class ProgramGroup {
	public static void main(String[] args) {
		GroupRepository repository = new GroupRepository();

		System.out.println("***********GET ALL GROUPS***********");

		List<Group> groups = repository.getAllGroups();

		for (Group group : groups) {
			System.out.println(group);
		}
//
//		System.out.println("\n\n***********GET GROUP BY ID***********");
//
//		Group groupById = repository.getGroupByID((short) 3);
//		System.out.println(groupById);
//
//		System.out.println("\n\n***********GET GROUP BY NAME***********");
//
//		Group groupByName = repository.getGroupByName("Sale");
//		System.out.println(groupByName);

//		System.out.println("\n\n***********CREATE GROUP***********");
//
//		Group groupCreate = new Group();
//		groupCreate.setName("New Group 01");
//		repository.createGroup(groupCreate);

//		System.out.println("\n\n***********UPDATE GROUP 1***********");
//
//		repository.updateGroup((short) 3, "Security2");
//
//		System.out.println("\n\n***********UPDATE GROUP 2***********");
//
//		Group groupUpdate = new Group();
//		groupUpdate.setId((short) 3);
//		groupUpdate.setName("Security2");
//		repository.updateGroup(groupUpdate);
//
//		System.out.println("\n\n***********DELETE GROUPS***********");
//		repository.deleteGroup((short) 2);
//
//		System.out.println("***********CHECK GROUP EXISTS BY ID***********");
//		System.out.println(repository.isGroupExistsByID((short) 1));
//
//		System.out.println("***********CHECK GROUP EXISTS BY NAME***********");
//		System.out.println(repository.isGroupExistsByName("Security"));

	}
}
