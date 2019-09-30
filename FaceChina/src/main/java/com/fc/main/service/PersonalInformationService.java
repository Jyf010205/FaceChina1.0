package com.fc.main.service;

import com.fc.main.entity.PersonalInformation;

public interface PersonalInformationService {
	PersonalInformation findPersonalInformationById(Integer user_id);
	int modifyPersonalInformationById(PersonalInformation pi);
}
