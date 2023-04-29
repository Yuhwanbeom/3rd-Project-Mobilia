package net.mobilia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.mobilia.dao.CommunityDAO;

@Service
public class CommunityServiceImpl implements CommunityService {

	@Autowired
	private CommunityDAO cDao;
}
