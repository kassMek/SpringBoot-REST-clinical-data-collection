package clinical.com.clinicalrestfuldatacollection.controller;


import clinical.com.clinicalrestfuldatacollection.dao.ClinicalDataRepository;
import clinical.com.clinicalrestfuldatacollection.dao.PatientRepository;
import clinical.com.clinicalrestfuldatacollection.dto.ClinicalDataRequest;
import clinical.com.clinicalrestfuldatacollection.entity.ClinicalData;
import clinical.com.clinicalrestfuldatacollection.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClinicalDataController {

   @Autowired
   private  ClinicalDataRepository clinicalDataRepository;

   @Autowired
    PatientRepository patientRepository;

   @PostMapping("/addClinicalData")
   public ClinicalData saveClinicalData(@RequestBody ClinicalDataRequest clinicalDataRequest){
       Patient patient = patientRepository.findById(clinicalDataRequest.getPatientId()).get();
       ClinicalData clinicalData= new ClinicalData();
       clinicalData.setComponentName(clinicalDataRequest.getComponentName());
       clinicalData.setComponentValue(clinicalDataRequest.getComponentValue());
       //clinicalData.setId(clinicalDataRequest.getPatientId());
       clinicalData.setPatient(patient);
      return clinicalDataRepository.save(clinicalData);

   }
}
