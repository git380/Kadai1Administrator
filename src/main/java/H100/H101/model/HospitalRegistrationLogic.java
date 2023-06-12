package H100.H101.model;

import H100.H101.dao.HospitalRegistrationDAO;

public class HospitalRegistrationLogic {
    public boolean checkHospital(String tabyouinid) {
        HospitalRegistrationDAO dao = new HospitalRegistrationDAO();
        return dao.checkHospital(tabyouinid);
    }
    public void registerHospital(Hospital hospital) {
        HospitalRegistrationDAO dao = new HospitalRegistrationDAO();
        dao.registerHospital(hospital);
    }
}
