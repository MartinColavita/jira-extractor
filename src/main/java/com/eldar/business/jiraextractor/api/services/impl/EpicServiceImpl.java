package com.eldar.business.jiraextractor.api.services.impl;

import com.eldar.business.jiraextractor.api.models.response.BacklogDTO;
import com.eldar.business.jiraextractor.api.models.response.EpicDTO;
import com.eldar.business.jiraextractor.api.services.base.BaseService;
import com.eldar.business.jiraextractor.api.services.contracts.EpicService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class EpicServiceImpl extends BaseService implements EpicService {


    /** Get issues without epic*/
    @Override
    public BacklogDTO getIssuesWithoutEpic() {
        String apiUrl = jiraUrl + "/rest/agile/1.0/epic/none/issue";
        return performGetRequest(apiUrl, BacklogDTO.class);
    }


    /** Get epic */
    @Override
    public EpicDTO getEpic(String epicIdOrKey) {
        String apiUrl = jiraUrl + "/rest/agile/1.0/epic/" + epicIdOrKey;
        return performGetRequest(apiUrl, EpicDTO.class);
    }


    /** Get issues for epic*/
    @Override
    public BacklogDTO getIssuesForEpic(String epicIdOrKey) {
        String apiUrl = jiraUrl + "/rest/agile/1.0/epic/" + epicIdOrKey + "/issue";
        return performGetRequest(apiUrl, BacklogDTO.class);
    }


}
