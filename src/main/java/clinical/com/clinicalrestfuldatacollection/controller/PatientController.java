package clinical.com.clinicalrestfuldatacollection.controller;


import clinical.com.clinicalrestfuldatacollection.dao.PatientRepository;
import clinical.com.clinicalrestfuldatacollection.entity.ClinicalData;
import clinical.com.clinicalrestfuldatacollection.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class PatientController {

    Map<String, String> filters= new HashMap<>();

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> getAll(){
        return (List<Patient>) patientRepository.findAll();
    }


    @GetMapping("/patients/{id}")
    public Patient getPatient(@PathVariable("id") int id){
        return patientRepository.findById(id).get();
    }

    @PostMapping("/addPatient")
    public Patient savePatient(@RequestBody Patient patient){
        return patientRepository.save(patient);
    }


    @GetMapping("/patients/analyze/{id}")
    public Patient analyzeBmi(@PathVariable("id") int id){
        Patient patient = patientRepository.findById(id).get();
        List<ClinicalData> clinicalData = patient.getClinicalData();
        List<ClinicalData> duplicatedClinicalData= new ArrayList<>(clinicalData);
        for(ClinicalData dd: duplicatedClinicalData){
              if(filters.containsKey(dd.getComponentName())){
                  clinicalData.remove(dd);
                  continue;
                    }

              else{
                  filters.put(dd.getComponentName(),null);
              }
                       if(dd.getComponentName().equals("hw")){
                          String [] heightAndWeight=dd.getComponentValue().split("/");
                           float heightInMeters=Float.parseFloat(heightAndWeight[0])*0.4536F;
                           float bmi=Float.parseFloat(heightAndWeight[1])/(heightInMeters*heightInMeters);
                           ClinicalData bmiData=new ClinicalData();
                           bmiData.setComponentName("bmi");
                           bmiData.setComponentValue(Float.toString(bmi));
                           clinicalData.add(bmiData);

                              }
                         }
        filters.clear();
        return patient;
    }
}
