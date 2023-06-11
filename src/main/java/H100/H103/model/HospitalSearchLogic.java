package H100.H103.model;

import H100.H101.model.Hospital;
import H100.H103.dao.HospitalSearchDAO;

import java.util.List;

public class HospitalSearchLogic {
    public List<Hospital> searchHospitals(String address) {
        HospitalSearchDAO hospitalSearch = new HospitalSearchDAO();
        return hospitalSearch.searchHospitals(address);
    }
}
