package net.mobilia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import net.mobilia.service.CommunityService;

@Controller
public class CommunityController {

	@Autowired
	private CommunityService communityService;
}
