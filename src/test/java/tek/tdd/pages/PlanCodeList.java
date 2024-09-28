package tek.tdd.pages;

import tek.tdd.api.models.PlanCodeResponse;

import java.util.List;

public class PlanCodeList {
    private List<PlanCodeResponse> response;

    public PlanCodeList() {
    }

    public PlanCodeList(List<PlanCodeResponse> response) {
        this.response = response;
    }

    public List<PlanCodeResponse> getResponse() {
        return response;
    }

    public void setResponse(List<PlanCodeResponse> response) {
        this.response = response;
    }
}
