package ${groupId}.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HelpCheckService {
	
	/**
	 * Method to check the health of the service
	 *
	 * @return boolean
	 */
	public boolean helpCheck() {
		log.info("help checking...");
		return true;
	}

}
